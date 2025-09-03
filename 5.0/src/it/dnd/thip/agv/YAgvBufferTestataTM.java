package it.dnd.thip.agv;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.cs.DatiComuniEstesiTTM;

public class YAgvBufferTestataTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID_BUFFER = "ID_BUFFER";

	public static final String STATO_BUFFER = "STATO_BUFFER";

	public static final String R_REPARTO_1 = "R_REPARTO_1";

	public static final String R_REPARTO_2 = "R_REPARTO_2";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YAGV_BUFFER_TES";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.agv.YAgvBufferTestata.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YAgvBufferTestataTM.class);
		}
		return cInstance;
	}

	public YAgvBufferTestataTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("IdBuffer", ID_BUFFER, "getIntegerObject");
		addAttribute("StatoBuffer", STATO_BUFFER);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdReparto1", R_REPARTO_1);
		addAttribute("IdReparto2", R_REPARTO_2);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + ID_BUFFER);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(ID_BUFFER + ", " + STATO_BUFFER + ", " + ID_AZIENDA + ", " + R_REPARTO_1 + ", " + R_REPARTO_2 + ", "
				+ STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
