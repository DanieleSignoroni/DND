package it.dnd.thip.base.articolo;

import java.sql.*;
import it.thera.thip.base.articolo.*;
import com.thera.thermfw.base.*;

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
 * 71946    02/05/2025  DSSOF3   Prima stesura
 */

public class YArticoloClienteTM extends ArticoloClienteTM {

	public static final String NR_PEZZI_BAULETTO = "NR_PEZZI_BAULETTO";

	public static final String NR_PEZZI_UDS = "NR_PEZZI_UDS";

	public static final String R_TIPO_UDS = "R_TIPO_UDS";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YARTICOLI_CLI";

	private static final String CLASS_NAME = it.dnd.thip.base.articolo.YArticoloCliente.class.getName();

	public YArticoloClienteTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("NrPezziBauletto", NR_PEZZI_BAULETTO, "getIntegerObject", TABLE_NAME_EXT);
		addAttributeOnTable("NrPezziUds", NR_PEZZI_UDS, "getIntegerObject", TABLE_NAME_EXT);
		addAttributeOnTable("IdTipoUDS", R_TIPO_UDS, TABLE_NAME_EXT);

	}

}

