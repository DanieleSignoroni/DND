package it.dnd.thip.logis.bas;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.logis.bas.EticSovracolloRptTM;

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

public class EticPianoCaricoRptTM extends TableManager {

	public static final String REPORT_NR = "REPORT_NR";

	public static final String ID_ANNO_DOC = "ID_ANNO_DOC";

	public static final String ID_NUMERO_DOC = "ID_NUMERO_DOC";

	public static final String ID_RIGA_DOC = "ID_RIGA_DOC";

	public static final String COD_SOCIETA = "COD_SOCIETA";

	public static final String NUM_RITORNO = "NUM_RITORNO_ATV";

	public static final String NUM_RIFERIMENTO = "NUM_RIFERIMENTO";

	public static final String ID_CLIENTE = "R_CLIENTE";

	public static final String ID_REPARTO = "R_REPARTO";

	public static final String TS_CREAZIONE = "TS_CREAZIONE";

	public static final String TS_AGGIORNAMENTO = "TS_AGGIORNAMENTO";

	public static final String UT_AGGIORNAMENTO = "UT_AGGIORNAMENTO";

	public static final String UT_CREAZIONE = "UT_CREAZIONE";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "LRPT_ETIC_PIA_CARICO";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.logis.bas.EticPianoCaricoRpt.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(EticSovracolloRptTM.class);
		}
		return cInstance;
	}

	public EticPianoCaricoRptTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("ReportNr" , REPORT_NR);
		addAttribute("AnnoDocumento", ID_ANNO_DOC);
		addAttribute("NumeroDocumento", ID_NUMERO_DOC);
		addAttribute("NumeroRigaDocumento", ID_RIGA_DOC, "getIntegerObject");
		addAttribute("CodSocieta" , COD_SOCIETA);
		addAttribute("NumeroRitorno" , NUM_RITORNO);
		addAttribute("NumeroRiferimento" , NUM_RIFERIMENTO);
		addAttribute("IdCliente" , ID_CLIENTE);
		addAttribute("IdReparto" , ID_REPARTO);
		addAttribute("TsCreazione" , TS_CREAZIONE);
		addAttribute("TsAggiornamento" , TS_AGGIORNAMENTO);
		addAttribute("UtAggiornamento" , UT_AGGIORNAMENTO);
		addAttribute("UtCreazione" , UT_CREAZIONE);
		getColumn(TS_CREAZIONE).excludeFromInsert();
		getColumn(TS_CREAZIONE).excludeFromUpdate();
		getColumn(TS_AGGIORNAMENTO).excludeFromInsert();
		getColumn(TS_AGGIORNAMENTO).excludeFromUpdate();

		setKeys(REPORT_NR + "," + COD_SOCIETA + "," + ID_ANNO_DOC + "," + ID_NUMERO_DOC + "," + ID_RIGA_DOC);
	}

	private void init() throws SQLException {
		configure();
	}
}
