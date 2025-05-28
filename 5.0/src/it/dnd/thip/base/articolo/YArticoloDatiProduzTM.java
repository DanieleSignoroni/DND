package it.dnd.thip.base.articolo;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;

import it.thera.thip.base.articolo.ArticoloDatiProduzTM;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 06/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71946    06/05/2025  DSSOF3   Prima stesura
 * 71979	28/05/2025	DSSOF3	 Aggiunta colonne ubicazione versamento e magazzino fisico
 */

public class YArticoloDatiProduzTM extends ArticoloDatiProduzTM {

	public static final String NR_PEZZI_BAULETTO = "NR_PEZZI_BAULETTO";

	public static final String NR_PEZZI_UDS = "NR_PEZZI_UDS";

	public static final String R_TIPO_UDS = "R_TIPO_UDS";
	
	public static final String ID_UBICAZIONE_VRS = "R_UBICAZIONE_VRS";
	public static final String ID_COD_MAG_FISICO = "R_COD_MAG_FISICO";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YARTICOLI";

	private static final String CLASS_NAME = it.dnd.thip.base.articolo.YArticoloDatiProduz.class.getName();

	public YArticoloDatiProduzTM() throws SQLException {
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
		addAttributeOnTable("IdUbicazioneVersamento", ID_UBICAZIONE_VRS, TABLE_NAME_EXT);
		addAttributeOnTable("IdMagazzinoFisico", ID_COD_MAG_FISICO, TABLE_NAME_EXT);
	}

}
