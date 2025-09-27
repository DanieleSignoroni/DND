package it.dnd.thip.toyota.api;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import it.dnd.thip.agv.InterfacciaToyota;
import it.thera.thip.api.client.ApiClient;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;

/**
 * <p>Classe base che centralizza la chiamata verso l'API Toyota.
 * Le sottoclassi devono solo definire il path base (es. "/loads") e,
 * se serve, sovrascrivere gli hook onBefore/onAfter per logiche specifiche.</p>
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

public abstract class BaseToyotaApi {

	protected abstract String basePath();

	protected void onBefore(CallContext ctx) {
	}

	protected Response onAfter(CallContext ctx, Response response) {
		return response;
	}

	protected Response execute(String operation, Method method, String suffix, JSONObject body) throws Exception {

		ApiClient c = InterfacciaToyota.getInstance().getApiClientWithBearerAuth();
		ApiRequest req = new ApiRequest(method, url(suffix));
		if (body != null)
			req.setBody(body.toString());

		CallContext ctx = new CallContext(operation, method, suffix, body, req);
		onBefore(ctx);

		ApiResponse ar = c.send(req);

		String bodyAsString = ar.getBodyAsString();
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(),
				bodyAsString.isEmpty() ? "" : new JSONObject(bodyAsString));

		return onAfter(ctx, r);
	}

	protected String url(String suffix) {
		String ip = InterfacciaToyota.getInstance().getIp();
		if (suffix == null || suffix.isEmpty()) {
			return ip + basePath();
		}
		if (suffix.startsWith("/")) {
			return ip + basePath() + suffix;
		}
		return ip + basePath() + "/" + suffix;
	}

	public Response list() throws Exception {
		return execute("list", Method.GET, "", null);
	}

	public Response getById(String id) throws Exception {
		return execute("getById", Method.GET, id, null);
	}

	public Response create(JSONObject b) throws Exception {
		return execute("create", Method.POST, "", b);
	}

	public Response update(String id, JSONObject b) throws Exception {
		return execute("update", Method.PUT, id, b);
	}

	public Response delete(String id) throws Exception {
		return execute("delete", Method.DELETE, id, null);
	}

	public static final class CallContext {
		public final String operation;
		public final Method method;
		public final String suffix;
		public final JSONObject body;
		public final ApiRequest request;

		CallContext(String operation, Method method, String suffix, JSONObject body, ApiRequest request) {
			this.operation = operation;
			this.method = method;
			this.suffix = suffix;
			this.body = body;
			this.request = request;
		}
	}
}
