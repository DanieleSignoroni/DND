package it.dnd.thip.base.articolo;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;

import it.thera.thip.base.articolo.ArticoloDatiProduzTM;

public class YArticoloDatiProduzTM extends ArticoloDatiProduzTM {

	public static final String NR_PEZZI_BAULETTO = "NR_PEZZI_BAULETTO";

	public static final String NR_PEZZI_UDS = "NR_PEZZI_UDS";

	public static final String R_TIPO_UDS = "R_TIPO_UDS";

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
	}

}
