package it.dnd.thip.toyota.subscription.web;

import java.util.Vector;

import com.thera.thermfw.web.WebDataCollector;
import com.thera.thermfw.web.WebForm;

import it.dnd.thip.toyota.subscription.Subscription;

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

public class SubscriptionDataCollector extends WebDataCollector {

	@SuppressWarnings("rawtypes")
	@Override
	protected Vector runCheckAll() {
		int mode = getMode();
		if(mode == WebForm.NEW) {
			getComponent("Endpoint").getComponentManager().setMandatory(true);
			getComponent("SourceType").getComponentManager().setMandatory(true);
		}
		return super.runCheckAll();
	}

	@Override
	public int save() {
		int mode = getMode();
		if(mode == WebForm.NEW) {
			Subscription bo = (Subscription) getBo();

			//.faccio la chaimata a toyota per creare una nuova subscription
		}
		return super.save();
	}
}
