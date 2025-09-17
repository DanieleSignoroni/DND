package it.dnd.thip.toyota.api;

import org.json.JSONObject;

import com.thera.thermfw.persist.Factory;

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

public class ToyotaService {

	private static ToyotaService instance;

	public static ToyotaService getInstance() {
		if (instance == null) {
			instance = (ToyotaService) Factory.createObject(ToyotaService.class);
		}
		return instance;
	}

	public JSONObject receiveInventoryNotify(String body) {
		JSONObject res = new JSONObject();
		
		return res;
	}

}
