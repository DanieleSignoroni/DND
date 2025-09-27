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
import it.dnd.thip.toyota.transport.Transport;
import it.dnd.thip.toyota.transport.TransportEvent;
import it.thera.thip.cs.DatiComuniEstesi;

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
			load.retrieve();
			load.getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
			int rc = load.save();
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

	public JSONObject receiveTransportNotify(String body) {
		JSONObject res = new JSONObject();
		if (body == null || body.isEmpty()) {
			return res.put("errors", "Empty body");
		}
		JSONObject in = new JSONObject(body);
		String eventType = in.optString("eventType", "");
		JSONObject eventData = in.optJSONObject("eventData");
		String idTransport = eventData != null ? eventData.optString("id", null) : null;
		switch (eventType) {
		case "TransportCreated":
			return handleTransportCreated(idTransport, in);
		case "PriorityUpdated":
			return handleTransportEvent(idTransport, in);
		case "DueTimeUpdated":
			return handleTransportEvent(idTransport, in);
		case "StateUpdated":
			return handleTransportEvent(idTransport, in);
		case "VehicleConnected":
			return handleTransportEvent(idTransport, in);
		case "AbortRequested":
			return handleTransportEvent(idTransport, in);
		case "InstructionsUpdated":
			return handleTransportEvent(idTransport, in);
		case "InstructionCompleted":
			return handleTransportEvent(idTransport, in);
		case "InstructionFailed":
			return handleTransportEvent(idTransport, in);
		default:
			return res.put("ignored", true).put("reason", "Unsupported eventType").put("eventType", eventType);
		}
	}

	@SuppressWarnings("unchecked")
	protected JSONObject handleTransportEvent(String idTransport, JSONObject in) {
		JSONObject res = new JSONObject();
		try {
			Transport transport = getExistingTransport(idTransport);
			if(transport != null) {
				BODataCollector boDC = (BODataCollector) Factory.createObject(BODataCollector.class);
				boDC.initialize("Transport");
				boDC.initSecurityServices(WebForm.UPDATE, true, true, false);
				boDC.setBo(transport);

				TransportEvent event = transportEventFromNotify(in, transport);
				transport.getEvent().add(event);

				int rc = boDC.save();
				if(rc == BODataCollector.OK) {
					ConnectionManager.commit();
				}else {
					res.put("errors", boDC.messages().toString());
					ConnectionManager.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}
		return res;
	}

	protected TransportEvent transportEventFromNotify(JSONObject in, Transport transport) {
		TransportEvent event = (TransportEvent) Factory.createObject(TransportEvent.class);
		event.setFather(transport);
		event.setIndex(in.getInt("index"));
		event.setEventType(in.getString("eventType"));
		event.setData(in.toString());
		return event;
	}

	protected JSONObject handleTransportCreated(String idTransport, JSONObject in) {
		JSONObject res = new JSONObject();
		try {
			BODataCollector boDC = (BODataCollector) Factory.createObject(BODataCollector.class);
			boDC.initialize("Transport");
			boDC.initSecurityServices(WebForm.NEW, true, true, false);

			Transport transport = (Transport) boDC.getBo();
			transport.setId(idTransport);
			//..Recupero le info del Transport chiamando Toyota
			Response transportInfo = Transport.getTransport(idTransport);
			if(transportInfo != null && transportInfo.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
				transport.setData(transportInfo.getEntity().toString());
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

	public Transport getExistingTransport(String id) throws SQLException {
		Transport t = (Transport) Factory.createObject(Transport.class);
		t.setKey(id);
		t.retrieve();
		return t;
	}

}