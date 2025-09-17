package it.dnd.thip.toyota.load;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.thera.thermfw.common.ErrorMessage;

import it.dnd.thip.toyota.api.LoadApi;

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

public class Load extends LoadPO {

	private static final LoadApi API = new LoadApi();

	public ErrorMessage checkDelete() {
		return null;
	}

	public static Response listLoads() throws Exception {
		return API.list();
	}

	public static Response getLoad(String id) throws Exception {
		return API.getById(id);
	}

	public static Response createNewLoad(JSONObject body) throws Exception {
		return API.createNewLoad(body);
	}

	public static Response updateLoad(String id, JSONObject body) throws Exception {
		return API.update(id, body);
	}

	public static Response removeLoad(String id) throws Exception {
		return API.removeLoad(id);
	}

}