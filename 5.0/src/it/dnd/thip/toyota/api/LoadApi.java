package it.dnd.thip.toyota.api;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import it.thera.thip.api.client.ApiRequest;

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

public class LoadApi extends BaseToyotaApi {

	@Override
	protected String basePath() { 
		return "/loads";
	}

	@Override
	protected void onBefore(String operation, ApiRequest request, JSONObject bodyOrNull) {
	}

	@Override
	protected Response onAfter(String operation, Response response) {
		return response;
	}

	public Response createNewLoad(JSONObject body) throws Exception {
		return create(body);
	}

	public Response removeLoad(String id) throws Exception {
		return delete(id);
	}
}
