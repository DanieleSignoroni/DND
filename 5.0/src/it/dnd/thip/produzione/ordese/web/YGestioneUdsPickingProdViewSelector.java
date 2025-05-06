package it.dnd.thip.produzione.ordese.web;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.ViewSelectorDefault;

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
 * 71XXX    06/05/2025  DSSOF3   Prima stesura
 */

public class YGestioneUdsPickingProdViewSelector extends ViewSelectorDefault {

	@Override
	public String getNewObjectURL(ClassADCollection cadc, ServletEnvironment se, String actionAdapterName) {
		String newUrl = super.getNewObjectURL(cadc, se, actionAdapterName);
		return newUrl;
	}
}
