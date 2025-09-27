package it.dnd.thip.toyota.subscription.web;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.ErrorCodes;
import com.thera.thermfw.web.WebDataCollector;
import com.thera.thermfw.web.WebForm;

import it.dnd.thip.agv.InterfacciaToyota;
import it.dnd.thip.toyota.subscription.Subscription;
import it.thera.thip.cs.DatiComuniEstesi;

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
	protected int runSave(boolean force) throws SQLException {
		int mode = getMode();
		if(mode == WebForm.NEW) {
			Subscription bo = (Subscription) getBo();
			try {
				Response r = Subscription.createNewSubscription(bo.getJsonNewSubscription());
				if(r.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
					JSONObject body = new JSONObject((String)r.getEntity());
					if(body != null) {
						bo.setId(body.getString("id"));
						bo.setEndpoint(body.getString("endpoint"));
						bo.getDatiComuniEstesi().setStato(DatiComuniEstesi.VALIDO);
						bo.setPassaToyota(true);
						String s = body.getString("createdDateTime");
						Timestamp ts = InterfacciaToyota.getTimestampForString(s);
						bo.setTimestampSubscription(ts);
						bo.setTsSubRefreshed(ts);
					}
				}else {
					getErrorList().addError(new ErrorMessage("BAS0000078","Toyota - creazione subscription terminata con status "+r.getStatus()+" e con errori : "+r.getEntity()));
					return ErrorCodes.GENERIC_ERROR;
				}
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
				return ErrorCodes.GENERIC_ERROR;
			}
		}
		return super.runSave(force);
	}

}