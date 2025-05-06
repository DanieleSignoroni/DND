package it.dnd.thip.base.articolo;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;

import it.thera.thip.base.articolo.ArticoloTM;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Andrea Gatta<br>
 * Date: 05/12/2024
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71725    05/12/2024  AGSOF3   Aggiunta campo Stato inserimento modello produttivo
 * 71946	02/05/2025	DSSOF3	 Aggiunta campi
 */


public class YArticoloTM extends ArticoloTM {

	/**
	 * Attributo STATO_INS_MOD_PRO
	 */
	public static final String STATO_INS_MOD_PRO = "STATO_INS_MOD_PRO";
	
	public static final String NR_PEZZI_BAULETTO = "NR_PEZZI_BAULETTO";

	public static final String NR_PEZZI_UDS = "NR_PEZZI_UDS";

	public static final String R_TIPO_UDS = "R_TIPO_UDS";

	/**
	 *  TABLE_NAME
	 */
	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YARTICOLI";

	/**
	 *  CLASS_NAME
	 */
	private static final String CLASS_NAME = it.dnd.thip.base.articolo.YArticolo.class.getName();

	public YArticoloTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("StatoInsModPro", STATO_INS_MOD_PRO, TABLE_NAME_EXT);
		addAttributeOnTable("NrPezziBauletto", NR_PEZZI_BAULETTO, "getIntegerObject", TABLE_NAME_EXT);
		addAttributeOnTable("NrPezziUds", NR_PEZZI_UDS, "getIntegerObject", TABLE_NAME_EXT);
		addAttributeOnTable("IdTipoUDS", R_TIPO_UDS, TABLE_NAME_EXT);
	}

}