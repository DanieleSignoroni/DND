package it.dnd.thip.toyota;

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

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;

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

public abstract class PsnDatiToyotaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static PsnDatiToyota cInstance;

	protected String iClientIdPanth01;

	protected String iClientSecretPanth01;

	protected String iUrlPanth01;

	protected String iClientIdPanth02;

	protected String iClientSecretPanth02;

	protected String iUrlPanth02;

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (PsnDatiToyota) Factory.createObject(PsnDatiToyota.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static PsnDatiToyota elementWithKey(String key, int lockType) throws SQLException {
		return (PsnDatiToyota) PersistentObject.elementWithKey(PsnDatiToyota.class, key, lockType);
	}

	public PsnDatiToyotaPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setClientIdPanth01(String clientIdPanth01) {
		this.iClientIdPanth01 = clientIdPanth01;
		setDirty();
	}

	public String getClientIdPanth01() {
		return iClientIdPanth01;
	}

	public void setClientSecretPanth01(String clientSecretPanth01) {
		this.iClientSecretPanth01 = clientSecretPanth01;
		setDirty();
	}

	public String getClientSecretPanth01() {
		return iClientSecretPanth01;
	}

	public void setUrlPanth01(String urlPanth01) {
		this.iUrlPanth01 = urlPanth01;
		setDirty();
	}

	public String getUrlPanth01() {
		return iUrlPanth01;
	}

	public void setClientIdPanth02(String clientIdPanth02) {
		this.iClientIdPanth02 = clientIdPanth02;
		setDirty();
	}

	public String getClientIdPanth02() {
		return iClientIdPanth02;
	}

	public void setClientSecretPanth02(String clientSecretPanth02) {
		this.iClientSecretPanth02 = clientSecretPanth02;
		setDirty();
	}

	public String getClientSecretPanth02() {
		return iClientSecretPanth02;
	}

	public void setUrlPanth02(String urlPanth02) {
		this.iUrlPanth02 = urlPanth02;
		setDirty();
	}

	public String getUrlPanth02() {
		return iUrlPanth02;
	}

	public void setIdAzienda(String idAzienda) {
		iAzienda.setKey(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
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
		setIdAzienda(key);
	}

	public String getKey() {
		return getIdAzienda();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return PsnDatiToyotaTM.getInstance();
	}

}
