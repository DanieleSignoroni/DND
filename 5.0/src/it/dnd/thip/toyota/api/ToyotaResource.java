package it.dnd.thip.toyota.api;

import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.thera.thermfw.rs.BaseResource;

@Path("/toyota")
public class ToyotaResource extends BaseResource {
	
	private ToyotaService service = ToyotaService.getInstance();

	@PermitAll
	@POST 
	@Path("/inventory/notify")
	public Response inventoryNotify(String body) {	   
		JSONObject res = service.receiveInventoryNotify(body);
		return buildResponse(Status.OK, res);
	}

	@PermitAll
	@POST 
	@Path("/transport/notify")
	public Response transportNotify(String body) {	   
		return buildResponse(Status.OK);
	}
}
