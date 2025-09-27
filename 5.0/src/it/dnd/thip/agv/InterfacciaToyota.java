package it.dnd.thip.agv;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Properties;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.StatusType;

import com.thera.thermfw.base.CacheController;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.Factory;

import it.dnd.thip.toyota.PsnDatiToyota;
import it.dnd.thip.toyota.api.OAuth2ClientCredentialsTokenManager;
import it.thera.thip.api.client.ApiClient;
import it.thera.thip.api.client.auth.BearerAuthentication;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 03/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    03/09/2025  DSSOF3   Prima stesura
 */

public class InterfacciaToyota {

	public static final String PROPERTIES = "it/dnd/thip/agv/resources/InterfacciaToyota.properties";

	protected static InterfacciaToyota instance;

	protected Properties properties = new Properties();

	private final OAuth2ClientCredentialsTokenManager tokenManager;

	static {
		try {
			CacheController.registerCache(InterfacciaToyota.class, "reset", true);
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace(Trace.excStream);
		}
	}

	public static InterfacciaToyota getInstance() {
		if (instance == null)
			instance = (InterfacciaToyota) Factory.createObject(InterfacciaToyota.class);
		return instance;
	}

	public static void reset() {
		instance = null;
		getInstance().load();
	}

	public InterfacciaToyota() {
		load();
		this.tokenManager = new OAuth2ClientCredentialsTokenManager(getIp(), getClient_id(), getClient_secret(), getScope());
	}

	protected void load() {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES));
		}
		catch (IOException e) {
			e.printStackTrace(Trace.excStream);
		}
	}

	public String getClient_id() {
		PsnDatiToyota psnDati = PsnDatiToyota.getCurrentPsnDatiToyota();
		if(psnDati != null) {
			return psnDati.getClientId();
		}else {
			return getStringProperty("client_id");
		}
	}

	public String getClient_secret() {
		PsnDatiToyota psnDati = PsnDatiToyota.getCurrentPsnDatiToyota();
		if(psnDati != null) {
			return psnDati.getClientSecret();
		}else {
			return getStringProperty("client_secret");
		}
	}

	public String getScope() {
		return getStringProperty("scope");
	}

	public String getGrant_type() {
		return getStringProperty("grant_type");
	}

	public String getIp() {
		PsnDatiToyota psnDati = PsnDatiToyota.getCurrentPsnDatiToyota();
		if(psnDati != null) {
			return psnDati.getIp();
		}else {
			return getStringProperty("ip");
		}
	}

	/**
	 * Metodo di utilità, restituisce il contenuto di un elemento sotto forma di booleano.
	 * Se l'elemento non è reperibile viene restituito <code>false</code>.
	 * @param name String
	 * @return boolean
	 */
	protected boolean getBooleanProperty(String name) {
		String res = properties.getProperty(name);
		if (res == null)
			return false;
		return res.equalsIgnoreCase("true");
	}

	/**
	 * Metodo di utilità, restituisce il contenuto di un elemento sotto forma di stringa.
	 * @param name String
	 * @return String
	 */
	protected String getStringProperty(String name) {
		String res = properties.getProperty(name);
		if (res == null)
			return "";
		return res;
	}

	/**
	 * Metodo di utilità, restituisce il contenuto di un elemento sotto forma di <code>int</code>.
	 * Se l'elemento non è reperibile viene restituito zero.
	 * @param name String
	 * @return int
	 */
	protected int getIntProperty(String name) {
		String res = properties.getProperty(name);
		if (res == null || res.length() == 0)
			return 0;
		return Integer.parseInt(res);
	}

	/**
	 * Ritorna il token
	 * @return
	 */
	public String getToken() {
		return tokenManager.getToken();
	}

	public ApiClient getApiClientWithBearerAuth() {
		ApiClient client = new ApiClient("");
		client.setAuthentication(new BearerAuthentication(getToken()));
		return client;
	}

	public Response buildResponse(StatusType status, Object entity) {
		ResponseBuilder builder = Response.status(status); 

		if (entity != null) {
			builder.entity(entity.toString());
		}

		return builder.build();
	}
	
	public static Timestamp getTimestampForString(String s) {
		Instant instant = Instant.parse(s);          
		Timestamp ts = Timestamp.from(instant);
		return ts;
	}
}
