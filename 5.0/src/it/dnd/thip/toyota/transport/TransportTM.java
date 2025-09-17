package it.dnd.thip.toyota.transport;

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

public class TransportTM extends TableManager {

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID = "ID";

	public static final String DATA = "DATA";

	public static final String TRANSPORT_STATE = "TRANSPORT_STATE";

	public static final String TABLE_NAME = SystemParam.getSchema("TOYOTA") + "TRANSPORT";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.toyota.transport.Transport.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(TransportTM.class);
		}
		return cInstance;
	}

	public TransportTM() throws SQLException {
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
		addAttribute("Data", DATA);
		addAttribute("TransportState", TRANSPORT_STATE);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(ID + ", " + DATA + ", " + TRANSPORT_STATE + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ
				+ ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
