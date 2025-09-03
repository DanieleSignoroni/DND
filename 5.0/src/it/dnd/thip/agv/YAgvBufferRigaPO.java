package it.dnd.thip.agv;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.Child;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;

public abstract class YAgvBufferRigaPO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

	private static YAgvBufferRiga cInstance;

	protected Integer iIdRigaBuffer;

	protected Proxy iPianocaricotoyotariga = new Proxy(it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga.class);

	protected Proxy iParent = new Proxy(it.dnd.thip.agv.YAgvBufferTestata.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YAgvBufferRiga) Factory.createObject(YAgvBufferRiga.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YAgvBufferRiga elementWithKey(String key, int lockType) throws SQLException {
		return (YAgvBufferRiga) PersistentObject.elementWithKey(YAgvBufferRiga.class, key, lockType);
	}

	public YAgvBufferRigaPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdRigaBuffer(Integer idRigaBuffer) {
		this.iIdRigaBuffer = idRigaBuffer;
		setDirty();
		setOnDB(false);
	}

	public Integer getIdRigaBuffer() {
		return iIdRigaBuffer;
	}

	public void setPianocaricotoyotariga(YPianoCaricoToyotaRiga pianocaricotoyotariga) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (pianocaricotoyotariga != null) {
			idAzienda = KeyHelper.getTokenObjectKey(pianocaricotoyotariga.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iPianocaricotoyotariga.setObject(pianocaricotoyotariga);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public YPianoCaricoToyotaRiga getPianocaricotoyotariga() {
		return (YPianoCaricoToyotaRiga) iPianocaricotoyotariga.getObject();
	}

	public void setPianocaricotoyotarigaKey(String key) {
		String oldObjectKey = getKey();
		iPianocaricotoyotariga.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getPianocaricotoyotarigaKey() {
		return iPianocaricotoyotariga.getKey();
	}

	public void setIdAnnoPcToyota(String idAnnoPcToyota) {
		String key = iPianocaricotoyotariga.getKey();
		iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idAnnoPcToyota));
		setDirty();
	}

	public String getIdAnnoPcToyota() {
		String key = iPianocaricotoyotariga.getKey();
		String objIdAnnoPcToyota = KeyHelper.getTokenObjectKey(key, 2);
		return objIdAnnoPcToyota;

	}

	public void setIdNumeroPcToyota(String idNumeroPcToyota) {
		String key = iPianocaricotoyotariga.getKey();
		iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key, 3, idNumeroPcToyota));
		setDirty();
	}

	public String getIdNumeroPcToyota() {
		String key = iPianocaricotoyotariga.getKey();
		String objIdNumeroPcToyota = KeyHelper.getTokenObjectKey(key, 3);
		return objIdNumeroPcToyota;

	}

	public void setIdRigaPcToyota(Integer idRigaPcToyota) {
		String key = iPianocaricotoyotariga.getKey();
		iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key, 4, idRigaPcToyota));
		setDirty();
	}

	public Integer getIdRigaPcToyota() {
		String key = iPianocaricotoyotariga.getKey();
		String objIdRigaPcToyota = KeyHelper.getTokenObjectKey(key, 4);
		return KeyHelper.stringToIntegerObj(objIdRigaPcToyota);
	}

	public void setParent(YAgvBufferTestata parent) {
		String idAzienda = getIdAzienda();
		if (parent != null) {
			idAzienda = KeyHelper.getTokenObjectKey(parent.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iParent.setObject(parent);
		setDirty();
		setOnDB(false);
	}

	public YAgvBufferTestata getParent() {
		return (YAgvBufferTestata) iParent.getObject();
	}

	public void setParentKey(String key) {
		iParent.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getParentKey() {
		return iParent.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setIdBuffer(Integer idBuffer) {
		String key = iParent.getKey();
		iParent.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idBuffer));
		setDirty();
		setOnDB(false);
	}

	public Integer getIdBuffer() {
		String key = iParent.getKey();
		String objIdBuffer = KeyHelper.getTokenObjectKey(key, 2);
		return KeyHelper.stringToIntegerObj(objIdBuffer);
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YAgvBufferRigaPO yAgvBufferRigaPO = (YAgvBufferRigaPO) obj;
		iPianocaricotoyotariga.setEqual(yAgvBufferRigaPO.iPianocaricotoyotariga);
		iParent.setEqual(yAgvBufferRigaPO.iParent);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdBuffer(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
		setIdRigaBuffer(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 3)));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		Integer idBuffer = getIdBuffer();
		Integer idRigaBuffer = getIdRigaBuffer();
		Object[] keyParts = { idAzienda, idBuffer, idRigaBuffer };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String getFatherKey() {
		return getParentKey();
	}

	public void setFatherKey(String key) {
		setParentKey(key);
	}

	public void setFather(PersistentObject father) {
		iParent.setObject(father);
	}

	public String getOrderByClause() {
		return "";
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YAgvBufferRigaTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iPianocaricotoyotariga.getKey();
		iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iParent.getKey();
		iParent.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

}
