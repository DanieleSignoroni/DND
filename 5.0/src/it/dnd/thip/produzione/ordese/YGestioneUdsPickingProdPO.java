package it.dnd.thip.produzione.ordese;

import java.math.BigDecimal;
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
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.fis.TipoUds;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 02/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71946    02/05/2025  DSSOF3   Prima stesura
 */

public abstract class YGestioneUdsPickingProdPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {
	
	public static final char PACKING_IN_CORSO = '0';
	public static final char PACKING_COMPLETATO = '1';

	private static YGestioneUdsPickingProd cInstance;

	protected String iNumeroRitorno;

	protected String iIdCodiceLista;

	protected Integer iIdCodiceRigaLista;

	protected BigDecimal iQuantita;

	protected char iStatoUds = PACKING_IN_CORSO;

	protected boolean iTrasmessoLinea = true;

	protected Proxy iTestatauds = new Proxy(it.thera.thip.logis.fis.TestataUds.class);

	protected Proxy iTipouds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YGestioneUdsPickingProd) Factory.createObject(YGestioneUdsPickingProd.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YGestioneUdsPickingProd elementWithKey(String key, int lockType) throws SQLException {
		return (YGestioneUdsPickingProd) PersistentObject.elementWithKey(YGestioneUdsPickingProd.class, key, lockType);
	}

	public YGestioneUdsPickingProdPO() {
		setStatoUds(PACKING_IN_CORSO);
		setTrasmessoLinea(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setNumeroRitorno(String numeroRitorno) {
		this.iNumeroRitorno = numeroRitorno;
		setDirty();
		setOnDB(false);
	}

	public String getNumeroRitorno() {
		return iNumeroRitorno;
	}

	public void setIdCodiceLista(String idCodiceLista) {
		this.iIdCodiceLista = idCodiceLista;
		setDirty();
	}

	public String getIdCodiceLista() {
		return iIdCodiceLista;
	}

	public void setIdCodiceRigaLista(Integer idCodiceRigaLista) {
		this.iIdCodiceRigaLista = idCodiceRigaLista;
		setDirty();
	}

	public Integer getIdCodiceRigaLista() {
		return iIdCodiceRigaLista;
	}

	public void setQuantita(BigDecimal quantita) {
		this.iQuantita = quantita;
		setDirty();
	}

	public BigDecimal getQuantita() {
		return iQuantita;
	}

	public void setStatoUds(char statoUds) {
		this.iStatoUds = statoUds;
		setDirty();
	}

	public char getStatoUds() {
		return iStatoUds;
	}

	public void setTrasmessoLinea(boolean trasmessoLinea) {
		this.iTrasmessoLinea = trasmessoLinea;
		setDirty();
	}

	public boolean getTrasmessoLinea() {
		return iTrasmessoLinea;
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

	public void setTestatauds(TestataUds testatauds) {
		this.iTestatauds.setObject(testatauds);
		setDirty();
		setOnDB(false);
	}

	public TestataUds getTestatauds() {
		return (TestataUds) iTestatauds.getObject();
	}

	public void setTestataudsKey(String key) {
		iTestatauds.setKey(key);
		setDirty();
		setOnDB(false);
	}

	public String getTestataudsKey() {
		return iTestatauds.getKey();
	}

	public void setIdUds(String idUds) {
		iTestatauds.setKey(idUds);
		setDirty();
		setOnDB(false);
	}

	public String getIdUds() {
		String key = iTestatauds.getKey();
		return key;
	}

	public void setTipouds(TipoUds tipouds) {
		this.iTipouds.setObject(tipouds);
		setDirty();
	}

	public TipoUds getTipouds() {
		return (TipoUds) iTipouds.getObject();
	}

	public void setTipoudsKey(String key) {
		iTipouds.setKey(key);
		setDirty();
	}

	public String getTipoudsKey() {
		return iTipouds.getKey();
	}

	public void setIdTipoUds(String idTipoUds) {
		iTipouds.setKey(idTipoUds);
		setDirty();
	}

	public String getIdTipoUds() {
		String key = iTipouds.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YGestioneUdsPickingProdPO yGestioneUdsPickingProdPO = (YGestioneUdsPickingProdPO) obj;
		iTestatauds.setEqual(yGestioneUdsPickingProdPO.iTestatauds);
		iTipouds.setEqual(yGestioneUdsPickingProdPO.iTipouds);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setNumeroRitorno(KeyHelper.getTokenObjectKey(key, 2));
		setIdUds(KeyHelper.getTokenObjectKey(key, 3));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String numeroRitorno = getNumeroRitorno();
		String idUds = getIdUds();
		Object[] keyParts = { idAzienda, numeroRitorno, idUds };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YGestioneUdsPickingProdTM.getInstance();
	}

}
