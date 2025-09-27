package it.dnd.thip.toyota.subscription;

import java.sql.SQLException;
import java.util.Vector;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.json.JSONObject;

import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;
import com.thera.thermfw.type.EnumType;

import it.dnd.thip.toyota.api.SubscriptionApi;
import it.thera.thip.cs.DatiComuniEstesi;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 27/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    27/09/2025  DSSOF3   Prima stesura
 */

public class Subscription extends SubscriptionPO {

	public static final char NON_SIGNIFICATIVO = '-';
	public static final char INVENTORY = 'I';
	public static final char TRANSPORT = 'T';

	private static final SubscriptionApi API = new SubscriptionApi();

	public ErrorMessage checkDelete() {
		return null;
	}

	public static Response listSubscriptions() throws Exception {
		return API.list();
	}

	public static Response getSubscription(String id) throws Exception {
		return API.getById(id);
	}

	public static Response createNewSubscription(JSONObject body) throws Exception {
		return API.createNewSubscription(body);
	}

	public static Response updateSubscription(String id, JSONObject body) throws Exception {
		return API.update(id, body);
	}

	public static Response removeSubscription(String id) throws Exception {
		return API.removeSubscription(id);
	}

	@Override
	public int save() throws SQLException {
		if(!isOnDB() && getTsSubRefreshed() == null) {
			getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
		}
		return super.save();
	}

	public ErrorMessage checkSourceType() {
		if(!isOnDB() && getSourceType() == NON_SIGNIFICATIVO) {
			return new ErrorMessage("BAS0000078","In creazione Source Type dev'essere valorizzato");
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = super.checkAll(components);
		if(!isOnDB()) {
			ErrorMessage em = checkActiveSubscription();
			if(em != null)
				errors.add(em);
		}
		return errors;
	}

	protected ErrorMessage checkActiveSubscription() {
		ErrorMessage em = null;
		if(getActiveSubscription().size() > 0) {
			em = new ErrorMessage("BAS0000078","Per il SourceType "+getSourceTypeDescription(getSourceType())+" esiste gia' una subscription attiva, cancellare prima l'altra");
		}
		return em;
	}

	@SuppressWarnings("rawtypes")
	protected Vector getActiveSubscription() {
		String where = " "+SubscriptionTM.SOURCE_TYPE+" = '"+getSourceType()+"' "
				+ "AND "+SubscriptionTM.STATO+" = '"+DatiComuniEstesi.VALIDO+"' "
				+ "AND "+SubscriptionTM.TS_END_SUBSCRIPTION+" IS NULL ";
		Vector v = new Vector();
		try {
			v = retrieveList(where, "", false);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace(Trace.excStream);
		}
		return v;
	}

	@Override
	public int delete() throws SQLException {
		//return super.delete();
		if(getDatiComuniEstesi().getStato() == DatiComuniEstesi.VALIDO && getPassaToyota()) {
			try {
				Response r = API.delete(getId());
				if(r.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
					getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
					setTsEndSubscription(TimeUtils.getCurrentTimestamp());
					setPassaToyota(false);
					save();
				}
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return 1;
	}

	public JSONObject getJsonNewSubscription() {
		JSONObject json = new JSONObject();
		json.put("sourceType", getSourceTypeDescription(getSourceType()));
		json.put("endpoint", getEndpoint());
		JSONObject auth = new JSONObject();
		auth.put("credentials", JSONObject.NULL);
		json.put("authentication", auth);
		return json;
	}

	public static String getSourceTypeDescription(char sourceType) {
		EnumType en = EnumType.getEnumTypeInstance("YSubSourceTypeToyota", EnumType.class);
		if(en != null) {
			return en.descriptionFromValue(String.valueOf(sourceType));
		}
		return null;	
	}
}

