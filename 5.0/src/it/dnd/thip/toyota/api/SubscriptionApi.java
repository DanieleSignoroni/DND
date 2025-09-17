package it.dnd.thip.toyota.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 17/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    17/09/2025  DSSOF3   Prima stesura
 */
public class SubscriptionApi extends BaseToyotaApi {

	@Override
	protected String basePath() {
		return "/subscriptions";
	}

	@Override
	protected void onBefore(CallContext ctx) {
	}

	@Override
	protected Response onAfter(CallContext ctx, Response response) {
		if(ctx.operation.equals("delete") && response != null && response.getStatus() == Status.OK.getStatusCode()) {
			//..Non cancello la subscription a Panthera ma la spengo e dichiaro come nulla
		}
		return response;
	}

	public Response createNewSubscription(JSONObject body) throws Exception {
		return create(body);
	}

	public Response removeSubscription(String id) throws Exception {
		return delete(id);
	}

}
