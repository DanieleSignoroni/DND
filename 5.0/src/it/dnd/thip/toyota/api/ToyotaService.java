package it.dnd.thip.toyota.api;

import java.sql.SQLException;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.WebForm;

import it.dnd.thip.toyota.load.Load;

/**
 * <p>Servizio per la gestione dell'integrazione con Toyota</p>
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
		if (body == null || body.isEmpty()) {
			return res.put("errors", "Empty body");
		}
		JSONObject in = new JSONObject(body);
		String eventType = in.optString("eventType", "");
		JSONObject eventData = in.optJSONObject("eventData");
		String idLoad = eventData != null ? eventData.optString("id", null) : null;
		switch (eventType) {
		case "LoadCreated":
			return handleLoadCreated(idLoad, in);
		case "LoadDeleted":
			return handleLoadDeleted(idLoad, in);
		default:
			return res.put("ignored", true).put("reason", "Unsupported eventType").put("eventType", eventType);
		}
	}

	protected JSONObject handleLoadDeleted(String idLoad, JSONObject in) {
		JSONObject res = new JSONObject();
		Load load = (Load) Factory.createObject(Load.class);
		load.setId(idLoad);
		try {
			int rc = load.delete();
			if(rc > 0) {
				res.put("message", "Load deleted");
				ConnectionManager.commit();
			}else {
				res.put("errors", "Load deletion failed, rc "+rc);
				ConnectionManager.rollback();
			}
		} catch (SQLException e) {
			res.put("errors", "Delete error : "+e.getMessage());
			e.printStackTrace(Trace.excStream);
		}
		return res;
	}

	protected JSONObject handleLoadCreated(String idLoad, JSONObject in) {
		JSONObject res = new JSONObject();
		try {
			BODataCollector boDC = (BODataCollector) Factory.createObject(BODataCollector.class);
			boDC.initialize("Load");
			boDC.initSecurityServices(WebForm.NEW, true, true, false);

			Load load = (Load) boDC.getBo();
			load.setId(idLoad);
			//..Recupero le info del Load chiamando Toyota
			Response loadInfo = Load.getLoad(idLoad);
			if(loadInfo != null && loadInfo.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
				load.setData(loadInfo.getEntity().toString());
			}else {
				//?
			}

			int rc = boDC.save();
			if(rc == BODataCollector.OK) {
				res.put("message", "Load created");
				ConnectionManager.commit();
			}else {
				res.put("errors", "Load creation failed, rc "+boDC.messages().toString());
				ConnectionManager.rollback();
			}
			
		} catch (SQLException e) {
			res.put("errors", "Save error : "+e.getMessage());
			e.printStackTrace(Trace.excStream);
		} catch (Exception e) {
			res.put("errors", "Error while retrieving info Load from Toyota: "+e.getMessage());
			e.printStackTrace(Trace.excStream);
		}
		return res;
	}

}
