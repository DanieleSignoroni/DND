package it.dnd.thip.logis.bas;

import java.sql.SQLException;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.Numerator;
import com.thera.thermfw.common.NumeratorException;
import com.thera.thermfw.persist.ErrorCodes;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 20/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    20/05/2025  DSSOF3   Prima stesura
 */

public class EticPianoCaricoRpt extends EticPianoCaricoRptPO {

	public int save() throws SQLException {
		if (getReportNr() == 0) {
			try {
				setReportNr(Numerator.getNextInt("PERS.LETIC_PIAN_CARICO"));
			}
			catch (NumeratorException n) {
				n.printStackTrace(Trace.excStream);
				return ErrorCodes.NO_ROWS_UPDATED;
			}
		}
		return super.save();
	}
}
