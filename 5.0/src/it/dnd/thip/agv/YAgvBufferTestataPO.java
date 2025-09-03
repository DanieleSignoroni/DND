package it.dnd.thip.agv;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.OneToMany;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.cs.EntitaAzienda;

public abstract class YAgvBufferTestataPO extends EntitaAzienda
implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YAgvBufferTestata cInstance;

	protected Integer iIdBuffer;

	protected char iStatoBuffer = 'S';

	protected Proxy iReparto1 = new Proxy(it.thera.thip.base.azienda.Reparto.class);

	protected Proxy iReparto2 = new Proxy(it.thera.thip.base.azienda.Reparto.class);

	protected OneToMany iYAgvBufferRiga = new OneToMany(it.dnd.thip.agv.YAgvBufferRiga.class, this, 3, false);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YAgvBufferTestata) Factory.createObject(YAgvBufferTestata.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YAgvBufferTestata elementWithKey(String key, int lockType) throws SQLException {
		return (YAgvBufferTestata) PersistentObject.elementWithKey(YAgvBufferTestata.class, key, lockType);
	}

	public YAgvBufferTestataPO() {
		setStatoBuffer('S');
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdBuffer(Integer idBuffer) {
		this.iIdBuffer = idBuffer;
		setDirty();
		setOnDB(false);
		iYAgvBufferRiga.setFatherKeyChanged();
	}

	public Integer getIdBuffer() {
		return iIdBuffer;
	}

	public void setStatoBuffer(char statoBuffer) {
		this.iStatoBuffer = statoBuffer;
		setDirty();
	}

	public char getStatoBuffer() {
		return iStatoBuffer;
	}

	public void setReparto1(Reparto reparto1) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (reparto1 != null) {
			idAzienda = KeyHelper.getTokenObjectKey(reparto1.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iReparto1.setObject(reparto1);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYAgvBufferRiga.setFatherKeyChanged();
		}
	}

	public Reparto getReparto1() {
		return (Reparto) iReparto1.getObject();
	}

	public void setReparto1Key(String key) {
		String oldObjectKey = getKey();
		iReparto1.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYAgvBufferRiga.setFatherKeyChanged();
		}
	}

	public String getReparto1Key() {
		return iReparto1.getKey();
	}

	public void setIdReparto1(String idReparto1) {
		String key = iReparto1.getKey();
		iReparto1.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idReparto1));
		setDirty();
	}

	public String getIdReparto1() {
		String key = iReparto1.getKey();
		String objIdReparto1 = KeyHelper.getTokenObjectKey(key, 2);
		return objIdReparto1;
	}

	public void setReparto2(Reparto reparto2) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (reparto2 != null) {
			idAzienda = KeyHelper.getTokenObjectKey(reparto2.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iReparto2.setObject(reparto2);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYAgvBufferRiga.setFatherKeyChanged();
		}
	}

	public Reparto getReparto2() {
		return (Reparto) iReparto2.getObject();
	}

	public void setReparto2Key(String key) {
		String oldObjectKey = getKey();
		iReparto2.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYAgvBufferRiga.setFatherKeyChanged();
		}
	}

	public String getReparto2Key() {
		return iReparto2.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
		iYAgvBufferRiga.setFatherKeyChanged();
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setIdReparto2(String idReparto2) {
		String key = iReparto2.getKey();
		iReparto2.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idReparto2));
		setDirty();
	}

	public String getIdReparto2() {
		String key = iReparto2.getKey();
		String objIdReparto2 = KeyHelper.getTokenObjectKey(key, 2);
		return objIdReparto2;
	}

	@SuppressWarnings("rawtypes")
	public List getYAgvBufferRiga() {
		return getYAgvBufferRigaInternal();
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YAgvBufferTestataPO yAgvBufferTestataPO = (YAgvBufferTestataPO) obj;
		iReparto1.setEqual(yAgvBufferTestataPO.iReparto1);
		iReparto2.setEqual(yAgvBufferTestataPO.iReparto2);
		iYAgvBufferRiga.setEqual(yAgvBufferTestataPO.iYAgvBufferRiga);
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
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		Integer idBuffer = getIdBuffer();
		Object[] keyParts = { idAzienda, idBuffer };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public int saveOwnedObjects(int rc) throws SQLException {
		rc = iYAgvBufferRiga.save(rc);
		return rc;
	}

	public int deleteOwnedObjects() throws SQLException {
		return getYAgvBufferRigaInternal().delete();
	}

	public boolean initializeOwnedObjects(boolean result) {
		result = iYAgvBufferRiga.initialize(result);
		return result;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YAgvBufferTestataTM.getInstance();
	}

	protected OneToMany getYAgvBufferRigaInternal() {
		if (iYAgvBufferRiga.isNew())
			iYAgvBufferRiga.retrieve();
		return iYAgvBufferRiga;
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iReparto1.getKey();
		iReparto1.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iReparto2.getKey();
		iReparto2.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

}
