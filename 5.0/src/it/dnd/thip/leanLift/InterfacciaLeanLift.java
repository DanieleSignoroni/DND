package it.dnd.thip.leanLift;

import java.util.Iterator;
import java.util.List;

import com.thera.thermfw.base.ResourceLoader;

import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.articolo.ArticoloBarcode;
import it.thera.thip.base.comuniVenAcq.TipoRiga;
import it.thera.thip.cs.ThipException;
import it.thera.thip.vendite.documentoVE.DocumentoVenRigaPrm;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 11/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    11/06/2025  DSSOF3   Prima stesura
 */

public class InterfacciaLeanLift {

	public static final String CHAR_START_ROW = "*";
	public static final String SEP = "$";
	public static final String CHAR_ENDING_ROW = "E99";

	/*
	 * -------------------------------------
	 * Inizio info per la connesione all'ftp
	 * -------------------------------------
	 */
	public static String RES_FILE = "it.dnd.thip.leanLift.resources.InterfacciaLeanLift";

	public static final String userName = String.valueOf((ResourceLoader.getString(RES_FILE, "ftp.username")));

	public static final String pwd = String.valueOf((ResourceLoader.getString(RES_FILE, "ftp.password")));

	public static final String ip = String.valueOf((ResourceLoader.getString(RES_FILE, "ftp.host")));

	public static final int port = Integer.valueOf((ResourceLoader.getString(RES_FILE, "ftp.port"))).intValue();

	/*
	 * -------------------------------------
	 * Fine info per la connesione all'ftp
	 * -------------------------------------
	 */

	public static String recordArticolo(String idCodiceBarre, String descrizione) {
		String descrizione40 = (descrizione.length() >= 40)
				? descrizione.substring(0, 40)
						: String.format("%-40s", descrizione);

		return "*$S" + idCodiceBarre + "$N" + descrizione40 + "$";

	}

	@SuppressWarnings("unchecked")
	public static String recordListaPrelievo(DocumentoVendita dv) throws ThipException {
		StringBuilder tracciato = new StringBuilder();

		// Riga intestazione
		String numeroOrdine = dv.getNumeroDocumento();

		//K. indica il numero ordine
		String intestazione = CHAR_START_ROW + SEP + "K" + numeroOrdine;

		//W. indica lo stato della lista, C. e' una campo descrittivo
		intestazione += SEP + "W" + "00" + SEP + "C" + dv.getNumeroRifIntestatario() + SEP;
		tracciato.append(intestazione).append("\n");

		for (DocumentoVenRigaPrm riga : (List<DocumentoVenRigaPrm>)(dv.getRighe())) {
			if (riga.getTipoRiga() == TipoRiga.MERCE) {
				tracciato.append(CHAR_START_ROW);

				String ean13 = getCodiceBarreEAN13Articolo(riga.getArticolo());
				if(ean13 == null)
					throw new ThipException("L'articolo "+riga.getIdArticolo()+" non ha un codice a barre di tipo EAN13");

				//EAN 13 articolo
				tracciato.append(SEP).append("S").append(riga.getIdArticolo());

				// Descrizione articolo
				tracciato.append(SEP).append("N").append(riga.getDescrizioneArticolo());

				// Tipo movimentazione (es. 'c')
				tracciato.append(SEP).append("V").append("c");

				// Quantità con padding a 10 cifre
				String qta = String.format("%08d", riga.getQtaInUMRif().intValue());
				tracciato.append(SEP).append("Q").append(qta);

				// Stato riga lista (es. '00')
				tracciato.append(SEP).append("W").append("00");

				//.Campo aggiuntivo U08
				tracciato.append(SEP).append("U08").append(dv.getCliente().getRagioneSociale()).append(SEP);

				// Fine riga
				tracciato.append("\n");
			}
		}

		tracciato.append(CHAR_START_ROW).append(CHAR_ENDING_ROW).append("\n");

		return tracciato.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String getCodiceBarreEAN13Articolo(Articolo articolo) {
		Iterator iterBarcodes = articolo.getBarcodeArticoloColl().iterator();
		while(iterBarcodes.hasNext()) {
			ArticoloBarcode artBarcode = (ArticoloBarcode) iterBarcodes.next();
			if(artBarcode.getIdTipoCodiceBarre().equals("EAN13") && artBarcode.getTipoPropBarcode() == ArticoloBarcode.AZIENDA) {
				return artBarcode.getIdCodiceBarre();
			}
		}
		return null;
	}

}