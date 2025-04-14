package it.dnd.thip.logis.lgb;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;

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

public class YPianoCaricoToyotaRiga extends YPianoCaricoToyotaRigaPO {

	public static final String QUERY_SAVE = "SELECT COALESCE(MAX(ID_RIGA_DOC)+1,1) AS MAXI_VAL FROM THIPPERS.YPIANO_CARICO_TOYOTA_RIG WHERE ID_AZIENDA = ? AND ID_ANNO_DOC = ? AND ID_NUMERO_DOC = ?";

	public static CachedStatement querySave = new CachedStatement(QUERY_SAVE);

	public ErrorMessage checkDelete() {

		return null;
	}

	public int save() throws SQLException {
		if (!isOnDB()) {
			ResultSet rs = null;
			int value = 1;
			Database db = ConnectionManager.getCurrentDatabase();
			synchronized (querySave) {
				PreparedStatement ps = querySave.getStatement();
				db.setString(ps, 1, getIdAzienda());
				db.setString(ps, 2, getAnnoDocumento());
				db.setString(ps, 3, getNumeroDocumento());
				rs = ps.executeQuery();
				if (rs.next())
					value = rs.getInt("MAXI_VAL");
				rs.close();
				setNumeroRigaDocumento(new Integer(value));
			}
		}
		return super.save();
	}
	
	public BigDecimal getResiduoDaPrelevare() {
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal qtaRcs = getQuantitaRichiestaUmPrm() != null ? getQuantitaRichiestaUmPrm() : BigDecimal.ZERO;
		BigDecimal qtaPrel = getQuantitaPrelevataUmPrm() != null ? getQuantitaPrelevataUmPrm() : BigDecimal.ZERO;
		res = qtaRcs.subtract(qtaPrel);
		return res;
	}

}
