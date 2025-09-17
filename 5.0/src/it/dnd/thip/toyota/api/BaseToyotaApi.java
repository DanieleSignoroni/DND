package it.dnd.thip.toyota.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

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

	/** Ogni anagrafica dichiara il suo path: "/loads", "/transports", ... */
	protected abstract String basePath();

	/**
	 * Viene chiamato prima di inviare la richiesta.
	 * Puoi: validare/mutare il body, aggiungere header, loggare, ecc.
	 * Di default non fa nulla.
	 */
	protected void onBefore(String operation,
			ApiRequest request,
			JSONObject bodyOrNull) {
	}

	/**
	 * Viene chiamato dopo aver ottenuto la Response.
	 * Puoi: tradurre errori, mappare payload, loggare, ecc.
	 * Di default ritorna la response così com’è.
	 */
	protected Response onAfter(String operation,
			Response response) {
		return response;
	}

	protected ApiClient client() throws KeyManagementException, NoSuchAlgorithmException {
		return InterfacciaToyota.getInstance().getApiClientWithBearerAuth();
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

	public Response list() throws KeyManagementException, NoSuchAlgorithmException {
		ApiClient c = client();
		ApiRequest req = new ApiRequest(Method.GET, url(""));
		onBefore("list", req, null);
		ApiResponse ar = c.send(req);
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(), new JSONObject(ar.getBodyAsString()));
		return onAfter("list", r);
	}

	public Response getById(String id) throws KeyManagementException, NoSuchAlgorithmException {
		ApiClient c = client();
		ApiRequest req = new ApiRequest(Method.GET, url(id));
		onBefore("getById", req, null);
		ApiResponse ar = c.send(req);
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(), new JSONObject(ar.getBodyAsString()));
		return onAfter("getById", r);
	}

	public Response create(JSONObject body) throws KeyManagementException, NoSuchAlgorithmException {
		ApiClient c = client();
		ApiRequest req = new ApiRequest(Method.POST, url(""));
		if (body != null) {
			req.setBody(body.toString());
		}
		onBefore("create", req, body);
		ApiResponse ar = c.send(req);
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(), new JSONObject(ar.getBodyAsString()));
		return onAfter("create", r);
	}

	public Response update(String id, JSONObject body) throws KeyManagementException, NoSuchAlgorithmException {
		ApiClient c = client();
		ApiRequest req = new ApiRequest(Method.PUT, url(id));
		if (body != null) {
			req.setBody(body.toString());
		}
		onBefore("update", req, body);
		ApiResponse ar = c.send(req);
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(), new JSONObject(ar.getBodyAsString()));
		return onAfter("update", r);
	}

	public Response delete(String id) throws KeyManagementException, NoSuchAlgorithmException {
		ApiClient c = client();
		ApiRequest req = new ApiRequest(Method.DELETE, url(id));
		onBefore("delete", req, null);
		ApiResponse ar = c.send(req);
		Response r = InterfacciaToyota.getInstance().buildResponse(ar.getStatus(), new JSONObject(ar.getBodyAsString()));
		return onAfter("delete", r);
	}
}
