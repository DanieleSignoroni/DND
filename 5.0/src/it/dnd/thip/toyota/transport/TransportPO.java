
package it.dnd.thip.toyota.transport;

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

import it.dnd.thip.toyota.utils.TransportState;
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

public abstract class TransportPO extends PersistentObjectDCE implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static Transport cInstance;

	protected String iId;

	protected String iData;

	protected char iTransportState = TransportState.PENDING;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (Transport) Factory.createObject(Transport.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static Transport elementWithKey(String key, int lockType) throws SQLException {
		return (Transport) PersistentObject.elementWithKey(Transport.class, key, lockType);
	}

	public TransportPO() {
		
	}

	public void setId(String id) {
		this.iId = id;
		setDirty();
		setOnDB(false);
	}

	public String getId() {
		return iId;
	}

	public void setData(String data) {
		this.iData = data;
		setDirty();
	}

	public String getData() {
		return iData;
	}

	public void setTransportState(char transportState) {
		this.iTransportState = transportState;
		setDirty();
	}

	public char getTransportState() {
		return iTransportState;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
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
		return TransportTM.getInstance();
	}

}
