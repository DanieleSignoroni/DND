package it.dnd.thip.logis.bas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.batch.CrystalReportsInterface;
import com.thera.thermfw.batch.DefaultReportsSettingTransformer;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.thera.thip.logis.bas.Azione;
import it.thera.thip.logis.bas.EsecutoreAzione;
import it.thera.thip.logis.bas.Stampante;
import it.thera.thip.logis.bas.StampanteObjectLoader;
import it.thera.thip.logis.bas.Tabella;
import it.thera.thip.logis.bas.Utente;
import it.thera.thip.logis.fis.Postazione;
import it.thera.thip.logis.fis.PostazioneStampa;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 20/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    20/05/2025  DSSOF3   Prima stesura
 */

public class StampaEtichettaPianoCarico extends EsecutoreAzione {

	public final static String STAMPA_ETIC_COL = "YE_PCRC";
	public final static String SEGMENTO_ETIC_COL = "YE_PCRC";

	protected YPianoCaricoToyotaRiga oggetto;

	protected Stampante stampante;

	protected Tabella tipoEtichetta;

	public StampaEtichettaPianoCarico(Azione evento) {
		oggetto = (YPianoCaricoToyotaRiga) evento.getIstanza();
		tipoEtichetta = (Tabella) Factory.createObject(Tabella.class);
		tipoEtichetta.setCodiceElemento(evento.getAttivita());
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected boolean esegui() {
		boolean esito = true;
		try {
			CrystalReportsInterface interf = (CrystalReportsInterface) Factory.createObject(CrystalReportsInterface.class);
			DefaultReportsSettingTransformer transf = interf.getSettingTransformer();
			Thread.sleep(1000); // Tempo di attesa per commit della transazione su Thread scatenante.
			if (getCodiceStampante() == null) {
				PostazioneStampa post = trovaPostazioneStampa();
				if (post != null) {
					setCodiceStampante(post.getCodiceStampante());
				}
			}
			if (getCodiceStampante() != null) {
				stampante = StampanteObjectLoader.elementWithKey(stampante.getCodice(), PersistentObject.NO_LOCK);
			}
			stampante.setTipoStampante(Stampante.THERM);
			if (stampante != null && stampante.getTipoStampante() == Stampante.THERM) {
				if (oggetto != null) {
					EticPianoCaricoRpt etSovRpt = (EticPianoCaricoRpt) Factory.createObject(EticPianoCaricoRpt.class);
					salvaTestList(oggetto, 1, etSovRpt);
					String root = ".";
					String rptFileName = getTipoEtichetta().getAttributi();
					String orderBy = ""+EticPianoCaricoRptTM.TABLE_NAME+"." + EticPianoCaricoRptTM.ID_RIGA_DOC + ".ASC";
					String printerId = stampante.getChiaveThermPrinter();
					String where = transf.buildEqualsElement(EticPianoCaricoRptTM.TABLE_NAME, EticPianoCaricoRptTM.REPORT_NR, Integer.toString(etSovRpt.getReportNr()));
					interf.printObjectList(root, rptFileName, where, orderBy, new HashMap(), printerId);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace(Trace.excStream);
			esito = false;
		}
		return esito;
	}

	protected void salvaTestList(YPianoCaricoToyotaRiga oggetto, int i, EticPianoCaricoRpt etSovRpt) {
		int ret = 0;
		etSovRpt.setCodiceSocieta(oggetto.getIdAzienda());
		etSovRpt.setAnnoDocumento(oggetto.getAnnoDocumento());
		etSovRpt.setNumeroDocumento(oggetto.getNumeroDocumento());
		etSovRpt.setNumeroRigaDocumento(oggetto.getNumeroRigaDocumento());
		etSovRpt.setNumRitornoAttivita(oggetto.getNumRitornoAttivita());
		etSovRpt.setNumeroRiferimento(oggetto.getNumeroRiferimento());
		etSovRpt.setIdCliente(etSovRpt.getIdCliente());
		etSovRpt.setIdReparto(((YPianoCaricoToyota)oggetto.getTestata()).getIdReparto());
		try {
			ret = etSovRpt.save();
			if (ret > 0) {
				ConnectionManager.commit();

			}
			else {
				ConnectionManager.rollback();
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}

	}

	public Tabella getTipoEtichetta() {
		if (tipoEtichetta != null) {
			try {
				tipoEtichetta.setCodiceSegmento(SEGMENTO_ETIC_COL);
				tipoEtichetta = (Tabella)Tabella.readOnlyElementWithKey(Tabella.class, tipoEtichetta.getKey()); // Fix 15947
			}
			catch (SQLException ex1) {
			}
			return tipoEtichetta;
		}
		else {
			try {
				tipoEtichetta = (Tabella)Tabella.readOnlyElementWithKey(Tabella.class, KeyHelper.buildObjectKey(new String[]{SEGMENTO_ETIC_COL,STAMPA_ETIC_COL}));
			}
			catch (SQLException ex) {
				ex.printStackTrace(Trace.excStream);
			}
			return tipoEtichetta;
		}
	}

	public String getCodiceStampante() {
		if (stampante != null)
			return stampante.getCodice();
		return null;
	}

	public void setCodiceStampante(String codice) {
		if (stampante == null) {
			stampante = (Stampante) Factory.createObject(Stampante.class);
		}
		stampante.setCodice(codice);
	}

	@SuppressWarnings("rawtypes")
	protected PostazioneStampa trovaPostazioneStampa() {
		Postazione p = Utente.getCurrentUtente().getCurrentPostazione();
		boolean trovato = false;
		Vector vPost = new Vector();
		try {
			p = (Postazione)Postazione.readOnlyElementWithKey(Postazione.class, p.getKey()); // Fix 15947
			vPost = PostazioneStampa.getListaPostazioniStampa(p.getCodiceMagFisico(),p.getCodice());
		}
		catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
		for (int i = 0; i < vPost.size() && !trovato; i++) {
			PostazioneStampa ps = (PostazioneStampa) vPost.get(i);
			if (ps.getNomeEtichette().equals(getTipoEtichetta().getCodiceElemento())) {
				trovato = true;
				return ps;
			}
		}
		return null;
	}
}
