package it.dnd.thip.toyota.subscription.web;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.ViewSelectorDefault;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 27/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    27/09/2025  DSSOF3   Prima stesura
 */
public class SubscriptionViewSelector extends ViewSelectorDefault {

	@Override
	public String getNewObjectURL(ClassADCollection cadc, ServletEnvironment se, String actionAdapterName) {
		String url = null;
		String urlObj = "it/dnd/thip/toyota/subscription/SubscriptionNuovo.jsp";
		if (urlObj != null)
			url = "/" + urlObj + "?Mode=NEW" + "&InitialActionAdapter=" + actionAdapterName;
		return url;
	}
}
