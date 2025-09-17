
package it.dnd.thip.toyota.subscription;

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
 * Date: 17/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    17/09/2025  DSSOF3   Prima stesura
 */

public class SubscriptionTM extends TableManager {

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID = "ID";

	public static final String TS_SUBSCRIPTION = "TS_SUBSCRIPTION";

	public static final String SOURCE_TYPE = "SOURCE_TYPE";

	public static final String ENDPOINT = "ENDPOINT";

	public static final String AUTHENTICATION = "AUTHENTICATION";

	public static final String TS_END_SUBSCRIPTION = "TS_END_SUBSCRIPTION";

	public static final String TABLE_NAME = SystemParam.getSchema("TOYOTA") + "SUBSCRIPTION";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.toyota.subscription.Subscription.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(SubscriptionTM.class);
		}
		return cInstance;
	}

	public SubscriptionTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("Id", ID);
		addAttribute("TimestampSubscription", TS_SUBSCRIPTION);
		addAttribute("SourceType", SOURCE_TYPE);
		addAttribute("Endpoint", ENDPOINT);
		addAttribute("Authentication", AUTHENTICATION);
		addAttribute("TsEndSubscription", TS_END_SUBSCRIPTION);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(ID + ", " + TS_SUBSCRIPTION + ", " + SOURCE_TYPE + ", " + ENDPOINT + ", " + AUTHENTICATION + ", "
				+ TS_END_SUBSCRIPTION + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG
				+ ", " + TIMESTAMP_AGG);
	}

}
