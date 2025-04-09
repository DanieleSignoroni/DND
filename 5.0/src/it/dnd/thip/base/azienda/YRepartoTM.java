package it.dnd.thip.base.azienda;

import java.sql.*;
import it.thera.thip.base.azienda.*;
import com.thera.thermfw.base.*;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 */

public class YRepartoTM extends RepartoTM {

	public static final String SERVITO_LOGISTICA = "SERVITO_LOGISTICA";

	public static final String BLOCCO_MISSIONI_PRL_AGV = "BLOCCO_MISSIONI_PRL_AGV";

	public static final String BLOCCO_MISSIONI_RIPOS_AGV = "BLOCCO_MISSIONI_RIPOS_AGV";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YREPARTI";

	private static final String CLASS_NAME = it.dnd.thip.base.azienda.YReparto.class.getName();

	public YRepartoTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("ServitoLogistica", SERVITO_LOGISTICA, TABLE_NAME_EXT);
		addAttributeOnTable("BloccoMissioniPrlAgv", BLOCCO_MISSIONI_PRL_AGV, TABLE_NAME_EXT);
		addAttributeOnTable("BloccoMissioniRiposAgv", BLOCCO_MISSIONI_RIPOS_AGV, TABLE_NAME_EXT);

	}

}

