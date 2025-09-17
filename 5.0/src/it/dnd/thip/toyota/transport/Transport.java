package it.dnd.thip.toyota.transport;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.thera.thermfw.common.ErrorMessage;

import it.dnd.thip.toyota.api.TransportApi;

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

public class Transport extends TransportPO {

	private static final TransportApi API = new TransportApi();

	public ErrorMessage checkDelete() {
		return null;
	}

	public static Response listTransports() throws Exception {
		return API.list();
	}

	public static Response getTransport(String id) throws Exception {
		return API.getById(id);
	}

	public static Response createNewTransport(JSONObject body) throws Exception {
		return API.createNewTransport(body);
	}

	public static Response updateTransport(String id, JSONObject body) throws Exception {
		return API.update(id, body);
	}

	public static Response removeTransport(String id) throws Exception {
		return API.removeTransport(id);
	}

}
