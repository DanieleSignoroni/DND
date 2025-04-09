package it.dnd.thip.logis.lgb;

import java.sql.SQLException;
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

import it.dnd.thip.logis.fis.TipoGestioneUbicazione;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.base.documenti.DocumentoBase;
import it.thera.thip.base.generale.NumeratoreHandler;
import it.thera.thip.logis.fis.MagFisico;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.logis.fis.Ubicazione;
import it.thera.thip.produzione.ordese.AttivitaEsecutiva;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 */

public abstract class YPianoCaricoToyotaPO extends DocumentoBase implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YPianoCaricoToyota cInstance;

	protected java.sql.Date iDataDocumento;

	protected char iStatoUdc = StatoPrelievoUdcToyota.STATO_INIZIALE;

	protected char iStatoGestione = TipoGestioneUbicazione.OPERATORE;

	protected Proxy iAttivitaesecutiva = new Proxy(it.thera.thip.produzione.ordese.AttivitaEsecutiva.class);

	protected Proxy iReparto = new Proxy(it.thera.thip.base.azienda.Reparto.class);

	protected Proxy iUbicazionestock = new Proxy(it.thera.thip.logis.fis.Ubicazione.class);

	protected Proxy iMagfisicostock = new Proxy(it.thera.thip.logis.fis.MagFisico.class);

	protected Proxy iUbicazioneprelievo = new Proxy(it.thera.thip.logis.fis.Ubicazione.class);

	protected Proxy iMagfisicoprl = new Proxy(it.thera.thip.logis.fis.MagFisico.class);

	protected Proxy iUdc = new Proxy(it.thera.thip.logis.fis.MappaUdc.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YPianoCaricoToyota) Factory.createObject(YPianoCaricoToyota.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YPianoCaricoToyota elementWithKey(String key, int lockType) throws SQLException {
		return (YPianoCaricoToyota) PersistentObject.elementWithKey(YPianoCaricoToyota.class, key, lockType);
	}

	public YPianoCaricoToyotaPO() {
		super();
		setStatoUdc(StatoPrelievoUdcToyota.STATO_INIZIALE);
		setStatoGestione(TipoGestioneUbicazione.OPERATORE);
		setIdAzienda(Azienda.getAziendaCorrente());
		ivNumeratoreHandler = (NumeratoreHandler) Factory.createObject(NumeratoreHandler.class);
		ivNumeratoreHandler.setIdTipoDocumento("PIA_CRC_TOYO");
		ivNumeratoreHandler.setIdSerie("PC");
		ivNumeratoreHandler.setOwner(this);
		this.iRighe = new OneToMany(it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga.class,this, 7, false);
	}

	public String getNumeroDocumento() {
		return iNumeroDocumento;
	}

	public void setDataDocumento(java.sql.Date dataDocumento) {
		this.iDataDocumento = dataDocumento;
		setDirty();
	}

	public void setStatoUdc(char statoUdc) {
		this.iStatoUdc = statoUdc;
		setDirty();
	}

	public char getStatoUdc() {
		return iStatoUdc;
	}

	public void setStatoGestione(char statoGestione) {
		this.iStatoGestione = statoGestione;
		setDirty();
	}

	public char getStatoGestione() {
		return iStatoGestione;
	}

	public void setAttivitaesecutiva(AttivitaEsecutiva attivitaesecutiva) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (attivitaesecutiva != null) {
			idAzienda = KeyHelper.getTokenObjectKey(attivitaesecutiva.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iAttivitaesecutiva.setObject(attivitaesecutiva);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iRighe.setFatherKeyChanged();
		}
	}

	public AttivitaEsecutiva getAttivitaesecutiva() {
		return (AttivitaEsecutiva) iAttivitaesecutiva.getObject();
	}

	public void setAttivitaesecutivaKey(String key) {
		String oldObjectKey = getKey();
		iAttivitaesecutiva.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iRighe.setFatherKeyChanged();
		}
	}

	public String getAttivitaesecutivaKey() {
		return iAttivitaesecutiva.getKey();
	}

	public void setIdAnnoOrdine(String idAnnoOrdine) {
		String key = iAttivitaesecutiva.getKey();
		iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idAnnoOrdine));
		setDirty();
	}

	public String getIdAnnoOrdine() {
		String key = iAttivitaesecutiva.getKey();
		String objIdAnnoOrdine = KeyHelper.getTokenObjectKey(key, 2);
		return objIdAnnoOrdine;

	}

	public void setIdNumeroOrdine(String idNumeroOrdine) {
		String key = iAttivitaesecutiva.getKey();
		iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key, 3, idNumeroOrdine));
		setDirty();
	}

	public String getIdNumeroOrdine() {
		String key = iAttivitaesecutiva.getKey();
		String objIdNumeroOrdine = KeyHelper.getTokenObjectKey(key, 3);
		return objIdNumeroOrdine;

	}

	public void setIdRigaAttivita(Integer idRigaAttivita) {
		String key = iAttivitaesecutiva.getKey();
		iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key, 4, idRigaAttivita));
		setDirty();
	}

	public Integer getIdRigaAttivita() {
		String key = iAttivitaesecutiva.getKey();
		String objIdRigaAttivita = KeyHelper.getTokenObjectKey(key, 4);
		return KeyHelper.stringToIntegerObj(objIdRigaAttivita);
	}

	public void setReparto(Reparto reparto) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (reparto != null) {
			idAzienda = KeyHelper.getTokenObjectKey(reparto.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iReparto.setObject(reparto);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iRighe.setFatherKeyChanged();
		}
	}

	public Reparto getReparto() {
		return (Reparto) iReparto.getObject();
	}

	public void setRepartoKey(String key) {
		String oldObjectKey = getKey();
		iReparto.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iRighe.setFatherKeyChanged();
		}
	}

	public String getRepartoKey() {
		return iReparto.getKey();
	}

	public void setIdReparto(String idReparto) {
		String key = iReparto.getKey();
		iReparto.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idReparto));
		setDirty();
	}

	public String getIdReparto() {
		String key = iReparto.getKey();
		String objIdReparto = KeyHelper.getTokenObjectKey(key, 2);
		return objIdReparto;
	}

	public void setUbicazionestock(Ubicazione ubicazionestock) {
		String idMagazzinoFisicoStock = getIdMagazzinoFisicoStock();
		if (ubicazionestock != null) {
			idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(ubicazionestock.getKey(), 2);
		}
		setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
		this.iUbicazionestock.setObject(ubicazionestock);
		setDirty();
	}

	public Ubicazione getUbicazioneStock() {
		return (Ubicazione) iUbicazionestock.getObject();
	}

	public void setUbicazioneStockKey(String key) {
		iUbicazionestock.setKey(key);
		String idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key, 2);
		setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
		setDirty();
	}

	public String getUbicazioneStockKey() {
		return iUbicazionestock.getKey();
	}

	public void setIdCodiceUbicazioneStock(String idCodiceUbicazioneStock) {
		String key = iUbicazionestock.getKey();
		iUbicazionestock.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCodiceUbicazioneStock));
		setDirty();
	}

	public String getIdCodiceUbicazioneStock() {
		String key = iUbicazionestock.getKey();
		String objIdCodiceUbicazioneStock = KeyHelper.getTokenObjectKey(key, 2);
		return objIdCodiceUbicazioneStock;

	}

	public void setMagfisicostock(MagFisico magfisicostock) {
		setIdMagazzinoFisicoStockInternal(magfisicostock.getKey());
		this.iMagfisicostock.setObject(magfisicostock);
		setDirty();
	}

	public MagFisico getMagfisicostock() {
		return (MagFisico) iMagfisicostock.getObject();
	}

	public void setMagfisicostockKey(String key) {
		iMagfisicostock.setKey(key);
		setIdMagazzinoFisicoStockInternal(key);
		setDirty();
	}

	public String getMagfisicostockKey() {
		return iMagfisicostock.getKey();
	}

	public void setIdMagazzinoFisicoStock(String idMagazzinoFisicoStock) {
		setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
		setDirty();
	}

	public String getIdMagazzinoFisicoStock() {
		String key = iUbicazionestock.getKey();
		String objIdMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key, 1);
		return objIdMagazzinoFisicoStock;
	}

	public void setUbicazioneprelievo(Ubicazione ubicazioneprelievo) {
		String idMagazzinoFisicoPrelievo = getIdMagazzinoFisicoPrelievo();
		if (ubicazioneprelievo != null) {
			idMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(ubicazioneprelievo.getKey(), 2);
		}
		setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
		this.iUbicazioneprelievo.setObject(ubicazioneprelievo);
		setDirty();
	}

	public Ubicazione getUbicazioneprelievo() {
		return (Ubicazione) iUbicazioneprelievo.getObject();
	}

	public void setUbicazioneprelievoKey(String key) {
		iUbicazioneprelievo.setKey(key);
		String idMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(key, 2);
		setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
		setDirty();
	}

	public String getUbicazioneprelievoKey() {
		return iUbicazioneprelievo.getKey();
	}

	public void setIdCodUbicazionePrelievo(String idCodUbicazionePrelievo) {
		String key = iUbicazioneprelievo.getKey();
		iUbicazioneprelievo.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCodUbicazionePrelievo));
		setDirty();
	}

	public String getIdCodUbicazionePrelievo() {
		String key = iUbicazioneprelievo.getKey();
		String objIdCodUbicazionePrelievo = KeyHelper.getTokenObjectKey(key, 2);
		return objIdCodUbicazionePrelievo;

	}

	public void setMagfisicoprl(MagFisico magfisicoprl) {
		setIdMagazzinoFisicoPrelievoInternal(magfisicoprl.getKey());
		this.iMagfisicoprl.setObject(magfisicoprl);
		setDirty();
	}

	public MagFisico getMagfisicoprl() {
		return (MagFisico) iMagfisicoprl.getObject();
	}

	public void setMagfisicoprlKey(String key) {
		iMagfisicoprl.setKey(key);
		setIdMagazzinoFisicoPrelievoInternal(key);
		setDirty();
	}

	public String getMagfisicoprlKey() {
		return iMagfisicoprl.getKey();
	}

	public void setIdMagazzinoFisicoPrelievo(String idMagazzinoFisicoPrelievo) {
		setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
		setDirty();
	}

	public String getIdMagazzinoFisicoPrelievo() {
		String key = iUbicazioneprelievo.getKey();
		String objIdMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(key, 1);
		return objIdMagazzinoFisicoPrelievo;
	}

	public void setUdc(MappaUdc udc) {
		this.iUdc.setObject(udc);
		setDirty();
	}

	public MappaUdc getUdc() {
		return (MappaUdc) iUdc.getObject();
	}

	public void setUdcKey(String key) {
		iUdc.setKey(key);
		setDirty();
	}

	public String getUdcKey() {
		return iUdc.getKey();
	}

	public void setIdCodiceUdc(String idCodiceUdc) {
		iUdc.setKey(idCodiceUdc);
		setDirty();
	}

	public String getIdCodiceUdc() {
		String key = iUdc.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YPianoCaricoToyotaPO yPianoCaricoToyotaPO = (YPianoCaricoToyotaPO) obj;
		if (yPianoCaricoToyotaPO.iDataDocumento != null)
			iDataDocumento = (java.sql.Date) yPianoCaricoToyotaPO.iDataDocumento.clone();
		iAttivitaesecutiva.setEqual(yPianoCaricoToyotaPO.iAttivitaesecutiva);
		iReparto.setEqual(yPianoCaricoToyotaPO.iReparto);
		iUbicazionestock.setEqual(yPianoCaricoToyotaPO.iUbicazionestock);
		iMagfisicostock.setEqual(yPianoCaricoToyotaPO.iMagfisicostock);
		iUbicazioneprelievo.setEqual(yPianoCaricoToyotaPO.iUbicazioneprelievo);
		iMagfisicoprl.setEqual(yPianoCaricoToyotaPO.iMagfisicoprl);
		iUdc.setEqual(yPianoCaricoToyotaPO.iUdc);
		iRighe.setEqual(yPianoCaricoToyotaPO.iRighe);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = super.checkAll(components);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setAnnoDocumento(KeyHelper.getTokenObjectKey(key, 2));
		setNumeroDocumento(KeyHelper.getTokenObjectKey(key, 3));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String annoDocumento = getAnnoDocumento();
		String numeroDocumento = getNumeroDocumento();
		Object[] keyParts = { idAzienda, annoDocumento, numeroDocumento };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YPianoCaricoToyotaTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iAttivitaesecutiva.getKey();
		iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iReparto.getKey();
		iReparto.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

	protected void setIdMagazzinoFisicoStockInternal(String idMagazzinoFisicoStock) {
		String key1 = iUbicazionestock.getKey();
		iUbicazionestock.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idMagazzinoFisicoStock));
		iMagfisicostock.setKey(idMagazzinoFisicoStock);
	}

	protected void setIdMagazzinoFisicoPrelievoInternal(String idMagazzinoFisicoPrelievo) {
		String key1 = iUbicazioneprelievo.getKey();
		iUbicazioneprelievo.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idMagazzinoFisicoPrelievo));
		iMagfisicoprl.setKey(idMagazzinoFisicoPrelievo);
	}

}
