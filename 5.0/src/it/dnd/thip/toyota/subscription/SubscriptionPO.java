
package it.dnd.thip.toyota.subscription;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.cs.PersistentObjectDCE;

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

public abstract class SubscriptionPO extends PersistentObjectDCE implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static Subscription cInstance;

	protected String iId;

	protected java.sql.Timestamp iTimestampSubscription;

	protected String iSourceType;

	protected String iEndpoint;

	protected String iAuthentication;

	protected java.sql.Timestamp iTsEndSubscription;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (Subscription) Factory.createObject(Subscription.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static Subscription elementWithKey(String key, int lockType) throws SQLException {
		return (Subscription) PersistentObject.elementWithKey(Subscription.class, key, lockType);
	}

	public SubscriptionPO() {
	}

	public void setId(String id) {
		this.iId = id;
		setDirty();
		setOnDB(false);
	}

	public String getId() {
		return iId;
	}

	public void setTimestampSubscription(java.sql.Timestamp timestampSubscription) {
		this.iTimestampSubscription = timestampSubscription;
		setDirty();
	}

	public java.sql.Timestamp getTimestampSubscription() {
		return iTimestampSubscription;
	}

	public void setSourceType(String sourceType) {
		this.iSourceType = sourceType;
		setDirty();
	}

	public String getSourceType() {
		return iSourceType;
	}

	public void setEndpoint(String endpoint) {
		this.iEndpoint = endpoint;
		setDirty();
	}

	public String getEndpoint() {
		return iEndpoint;
	}

	public void setAuthentication(String authentication) {
		this.iAuthentication = authentication;
		setDirty();
	}

	public String getAuthentication() {
		return iAuthentication;
	}

	public void setTsEndSubscription(java.sql.Timestamp tsEndSubscription) {
		this.iTsEndSubscription = tsEndSubscription;
		setDirty();
	}

	public java.sql.Timestamp getTsEndSubscription() {
		return iTsEndSubscription;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		SubscriptionPO subscriptionPO = (SubscriptionPO) obj;
		if (subscriptionPO.iTimestampSubscription != null)
			iTimestampSubscription = (java.sql.Timestamp) subscriptionPO.iTimestampSubscription.clone();
		if (subscriptionPO.iTsEndSubscription != null)
			iTsEndSubscription = (java.sql.Timestamp) subscriptionPO.iTsEndSubscription.clone();
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setId(key);
	}

	public String getKey() {
		return getId();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return SubscriptionTM.getInstance();
	}

}
