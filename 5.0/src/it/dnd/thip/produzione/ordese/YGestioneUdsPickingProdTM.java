package it.dnd.thip.produzione.ordese;

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
 * Date: 02/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    02/05/2025  DSSOF3   Prima stesura
 */

public class YGestioneUdsPickingProdTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String NUMERO_RITORNO = "NUMERO_RITORNO";

	public static final String R_UDS = "R_UDS";

	public static final String R_COD_LISTA = "R_COD_LISTA";

	public static final String R_COD_RIGA_LISTA = "R_COD_RIGA_LISTA";

	public static final String R_TIPO_UDS = "R_TIPO_UDS";

	public static final String QUANTITA = "QUANTITA";

	public static final String STATO_UDS = "STATO_UDS";

	public static final String TRASMESSO_LINEA = "TRASMESSO_LINEA";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YGESTIONE_UDS_PICKING_PROD";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YGestioneUdsPickingProdTM.class);
		}
		return cInstance;
	}

	public YGestioneUdsPickingProdTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("NumeroRitorno", NUMERO_RITORNO);
		addAttribute("IdCodiceLista", R_COD_LISTA);
		addAttribute("IdCodiceRigaLista", R_COD_RIGA_LISTA, "getIntegerObject");
		addAttribute("Quantita", QUANTITA);
		addAttribute("StatoUds", STATO_UDS);
		addAttribute("TrasmessoLinea", TRASMESSO_LINEA);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("IdUds", R_UDS);
		addAttribute("IdTipoUds", R_TIPO_UDS);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + NUMERO_RITORNO + "," + R_UDS);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure();
	}

}
