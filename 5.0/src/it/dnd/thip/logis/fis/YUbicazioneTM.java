package it.dnd.thip.logis.fis;

import java.sql.*;
import it.thera.thip.logis.fis.*;
import com.thera.thermfw.base.*;

/**
 *
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

public class YUbicazioneTM extends UbicazioneTM {

	public static final String BLOCCATA_AGV = "BLOCCATA_AGV";

	public static final String GES_BAIA_PRELIEVO = "GES_BAIA_PRELIEVO";

	public static final String TIPO_GESTIONE_PERS = "TIPO_GESTIONE_PERS";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YLUBICAZIONE";

	private static final String CLASS_NAME = it.dnd.thip.logis.fis.YUbicazione.class.getName();

	public YUbicazioneTM() throws SQLException {
		super();
	}

	public void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	public void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("BloccataAgv", BLOCCATA_AGV, TABLE_NAME_EXT);
		addAttributeOnTable("GestioneBaiaPrelievo", GES_BAIA_PRELIEVO, TABLE_NAME_EXT);
		addAttributeOnTable("TipoGestionePers", TIPO_GESTIONE_PERS, TABLE_NAME_EXT);



	}

}

