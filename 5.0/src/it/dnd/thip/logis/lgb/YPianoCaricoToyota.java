package it.dnd.thip.logis.lgb;

import java.sql.Date;

import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.type.DateType;

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

public class YPianoCaricoToyota extends YPianoCaricoToyotaPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	@Override
	public String getAltreInfoHeader() {
		if(isOnDB()) {
			Date dataDocumento = getDataDocumento();
			if(getDataDocumento() != null) {
				String data = dataDocumento.toString();

				if(dataDocumento != null) {
					DateType type = Factory.newObject(DateType.class);
					data = type.objectToString(dataDocumento);
					data = type.format(data);
				}
				return "(" + data + ")";
			}
		}else
			return "";
		return "";
	}
}

