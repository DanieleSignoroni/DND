package it.dnd.thip.toyota.load;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONObject;

import com.thera.thermfw.common.*;

import it.dnd.thip.agv.InterfacciaToyota;
import it.thera.thip.api.client.ApiClient;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;

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

	public ErrorMessage checkDelete() {
		return null;
	}

	/**
	 * Si occupa di ritornare le informazioni di un 'Load' chiedendole a Toyota.
	 * @param id del Load
	 * @return una response con {@link StatusType} e un json object che contiene la response
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static Response getLoadInformation(String id) throws KeyManagementException, NoSuchAlgorithmException {
		Response response = null;
		ApiClient client = InterfacciaToyota.getInstance().getApiClientWithBearerAuth();
		if(client != null) {
			ApiRequest request = new ApiRequest(Method.GET, InterfacciaToyota.getInstance().getIp() + "/loads/"+id);
			ApiResponse apiResponse = client.send(request);
			response = InterfacciaToyota.getInstance().buildResponse(apiResponse.getStatus(), new JSONObject(apiResponse.getBodyAsString()));
		}
		return response;
	}

}