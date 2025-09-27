package it.dnd.thip.toyota.api;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
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

public class TransportApi extends BaseToyotaApi {

	@Override
	protected String basePath() { 
		return "v1/transports";
	}

	@Override
	protected void onBefore(CallContext ctx) {
	}

	@Override
	protected Response onAfter(CallContext ctx, Response response) {
		return response;
	}
	public Response createNewTransport(JSONObject body) throws Exception {
		return create(body);
	}

	public Response removeTransport(String id) throws Exception {
		return delete(id);
	}
}
