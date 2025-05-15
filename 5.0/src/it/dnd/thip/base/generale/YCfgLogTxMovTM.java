package it.dnd.thip.base.generale;

import java.sql.*;
import it.thera.thip.base.generale.*;
import com.thera.thermfw.base.*;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 09/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71953    09/05/2025  DSSOF3   Prima stesura
 */

public class YCfgLogTxMovTM extends CfgLogTxMovTM {

	public static final String R_POLITICA_RIORDINO = "R_POLITICA_RIORDINO";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YCFG_LOG_TX_MOV";

	private static final String CLASS_NAME = it.dnd.thip.base.generale.YCfgLogTxMov.class.getName();

	public YCfgLogTxMovTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("IdPoliticaRiordino", R_POLITICA_RIORDINO, TABLE_NAME_EXT);

	}

}

