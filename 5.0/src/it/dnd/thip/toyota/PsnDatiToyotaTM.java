package it.dnd.thip.toyota;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.cs.DatiComuniEstesiTTM;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 27/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    27/09/2025  DSSOF3   Prima stesura
 */

public class PsnDatiToyotaTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String CLIENT_ID_PANTH01 = "CLIENT_ID_PANTH01";

	public static final String CLIENT_SECRET_PANTH01 = "CLIENT_SECRET_PANTH01";

	public static final String URL_PANTH01 = "URL_PANTH01";

	public static final String CLIENT_ID_PANTH02 = "CLIENT_ID_PANTH02";

	public static final String CLIENT_SECRET_PANTH02 = "CLIENT_SECRET_PANTH02";

	public static final String URL_PANTH02 = "URL_PANTH02";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "PSN_DATI_TOYOTA";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.toyota.PsnDatiToyota.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(PsnDatiToyotaTM.class);
		}
		return cInstance;
	}

	public PsnDatiToyotaTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("ClientIdPanth01", CLIENT_ID_PANTH01);
		addAttribute("ClientSecretPanth01", CLIENT_SECRET_PANTH01);
		addAttribute("UrlPanth01", URL_PANTH01);
		addAttribute("ClientIdPanth02", CLIENT_ID_PANTH02);
		addAttribute("ClientSecretPanth02", CLIENT_SECRET_PANTH02);
		addAttribute("UrlPanth02", URL_PANTH02);
		addAttribute("IdAzienda", ID_AZIENDA);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(CLIENT_ID_PANTH01 + ", " + CLIENT_SECRET_PANTH01 + ", " + URL_PANTH01 + ", " + CLIENT_ID_PANTH02
				+ ", " + CLIENT_SECRET_PANTH02 + ", " + URL_PANTH02 + ", " + ID_AZIENDA + ", " + STATO + ", "
				+ R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
