package it.dnd.thip.agv;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.cs.DatiComuniEstesiTTM;

public class YAgvBufferRigaTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String ID_BUFFER = "ID_BUFFER";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID_RIGA_BUFFER = "ID_RIGA_BUFFER";

	public static final String R_ANNO_PC_TOYOTA = "R_ANNO_PC_TOYOTA";

	public static final String R_NUMERO_PC_TOYOTA = "R_NUMERO_PC_TOYOTA";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YAGV_BUFFER_RIG";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.agv.YAgvBufferRiga.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YAgvBufferRigaTM.class);
		}
		return cInstance;
	}

	public YAgvBufferRigaTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("IdRigaBuffer", ID_RIGA_BUFFER, "getIntegerObject");
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdAnnoPcToyota", R_ANNO_PC_TOYOTA);
		addAttribute("IdNumeroPcToyota", R_NUMERO_PC_TOYOTA);
		addAttribute("IdBuffer", ID_BUFFER, "getIntegerObject");

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + ID_BUFFER + "," + ID_RIGA_BUFFER);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(ID_RIGA_BUFFER + ", " + ID_AZIENDA + ", " + R_ANNO_PC_TOYOTA + ", " + R_NUMERO_PC_TOYOTA + ", " + ID_BUFFER + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", "
				+ R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
