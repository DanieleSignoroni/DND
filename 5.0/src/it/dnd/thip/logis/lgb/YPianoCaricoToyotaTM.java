package it.dnd.thip.logis.lgb;

import com.thera.thermfw.persist.*;
import java.sql.*;
import com.thera.thermfw.base.*;

import it.thera.thip.base.generale.NumeratoreHandlerTTM;
import it.thera.thip.cs.*;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 */

public class YPianoCaricoToyotaTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID_ANNO_DOC = "ID_ANNO_DOC";

	public static final String ID_NUMERO_DOC = "ID_NUMERO_DOC";
	
	public static final String NUMERO_DOC_FMT = "NUMERO_DOC_FMT";

	public static final String DATA_DOC = "DATA_DOC";

	public static final String R_COD_UBICAZIONE_STOCK = "R_COD_UBICAZIONE_STOCK";

	public static final String R_MAG_FISICO_STOCK = "R_MAG_FISICO_STOCK";

	public static final String R_COD_UBICAZIONE_PRL = "R_COD_UBICAZIONE_PRL";

	public static final String R_MAG_FISICO_PRL = "R_MAG_FISICO_PRL";

	public static final String STATO_UDC = "STATO_UDC";

	public static final String R_COD_MAPPA_UDC = "R_COD_MAPPA_UDC";

	public static final String ID_ANNO_ORDINE = "ID_ANNO_ORDINE";

	public static final String ID_NUMERO_ORD = "ID_NUMERO_ORD";

	public static final String ID_RIGA_ATTIVITA = "ID_RIGA_ATTIVITA";

	public static final String R_REPARTO = "R_REPARTO";

	public static final String STATO_GESTIONE = "STATO_GESTIONE";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YPIANO_CARICO_TOYOTA_TES";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.logis.lgb.YPianoCaricoToyota.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(YPianoCaricoToyotaTM.class);
		}
		return cInstance;
	}

	public YPianoCaricoToyotaTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("AnnoDocumento", ID_ANNO_DOC);
		addAttribute("NumeroDocumento", ID_NUMERO_DOC);
		addAttribute("NumeroDocumentoFormattato" , NUMERO_DOC_FMT);
		addAttribute("DataDocumento", DATA_DOC);
		addAttribute("StatoUdc", STATO_UDC);
		addAttribute("StatoGestione", STATO_GESTIONE);
		addAttribute("IdAnnoOrdine", ID_ANNO_ORDINE);
		addAttribute("IdNumeroOrdine", ID_NUMERO_ORD);
		addAttribute("IdRigaAttivita", ID_RIGA_ATTIVITA, "getIntegerObject");
		addAttribute("IdReparto", R_REPARTO);
		addAttribute("IdCodiceUbicazioneStock", R_COD_UBICAZIONE_STOCK);
		addAttribute("IdMagazzinoFisicoStock", R_MAG_FISICO_STOCK);
		addAttribute("IdCodUbicazionePrelievo", R_COD_UBICAZIONE_PRL);
		addAttribute("IdMagazzinoFisicoPrelievo", R_MAG_FISICO_PRL);
		addAttribute("IdCodiceUdc", R_COD_MAPPA_UDC);

		addComponent("NumeratoreHandler", NumeratoreHandlerTTM.class);
		changeAttributeColumn(new String[] {"NumeratoreHandler", "DataDocumento"}, DATA_DOC);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + ID_ANNO_DOC + "," + ID_NUMERO_DOC);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}

