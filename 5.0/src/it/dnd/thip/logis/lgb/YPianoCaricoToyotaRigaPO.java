package it.dnd.thip.logis.lgb;

import java.math.BigDecimal;
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
import com.thera.thermfw.persist.OneToMany;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.base.documenti.DocumentoBaseRiga;
import it.thera.thip.logis.fis.Missione;
import it.thera.thip.produzione.ordese.AttivitaEsecMateriale;
import it.thera.thip.vendite.documentoVE.DocumentoVenRigaLottoPrm;

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

public abstract class YPianoCaricoToyotaRigaPO extends DocumentoBaseRiga implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

	private static YPianoCaricoToyotaRiga cInstance;

	protected Integer iNumeroRigaDocumento;

	protected String iNumRitornoAttivita;

	protected String iNumeroRiferimento;

	protected BigDecimal iQuantitaRichiestaUmPrm;

	protected BigDecimal iQuantitaRichiestaUmSec;

	protected BigDecimal iQuantitaPrelevataUmPrm;

	protected BigDecimal iQuantitaPrelevataUmSec;

	protected String iPriorita = "50";

	protected boolean iPrelevabile = false;

	protected char iStatoPrelievo = StatoPrelievoRigaToyota.NON_PRELEVATA;

	protected char iStatoRiga = StatoRigaToyota.APERTA;

	protected Proxy iAttivitaesecmateriale = new Proxy(it.thera.thip.produzione.ordese.AttivitaEsecMateriale.class);

	protected Proxy iArticolo = new Proxy(it.thera.thip.base.articolo.Articolo.class);

	protected Proxy iCliente = new Proxy(it.thera.thip.base.cliente.ClientePrimrose.class);

	protected Proxy iMissione = new Proxy(it.thera.thip.logis.fis.Missione.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YPianoCaricoToyotaRiga) Factory.createObject(YPianoCaricoToyotaRiga.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YPianoCaricoToyotaRiga elementWithKey(String key, int lockType) throws SQLException {
		return (YPianoCaricoToyotaRiga) PersistentObject.elementWithKey(YPianoCaricoToyotaRiga.class, key, lockType);
	}

	public YPianoCaricoToyotaRigaPO() {
		super();
		setNumeroRigaDocumento(new Integer(0));
		setPriorita("50");
		setPrelevabile(false);
		setStatoPrelievo(StatoPrelievoRigaToyota.NON_PRELEVATA);
		setStatoRiga(StatoRigaToyota.APERTA);
		setIdAzienda(Azienda.getAziendaCorrente());
		this.iTestata = new Proxy(it.dnd.thip.logis.lgb.YPianoCaricoToyota.class);
		this.iRigheLotto = new OneToMany(DocumentoVenRigaLottoPrm.class, this, 15, true); //Fake per evitare exc
	}

	public void setNumeroRigaDocumento(Integer numeroRigaDocumento) {
		this.iNumeroRigaDocumento = numeroRigaDocumento;
		setDirty();
		setOnDB(false);
	}

	public Integer getNumeroRigaDocumento() {
		return iNumeroRigaDocumento;
	}

	public void setNumRitornoAttivita(String numRitornoAttivita) {
		this.iNumRitornoAttivita = numRitornoAttivita;
		setDirty();
	}

	public String getNumRitornoAttivita() {
		return iNumRitornoAttivita;
	}

	public void setNumeroRiferimento(String numeroRiferimento) {
		this.iNumeroRiferimento = numeroRiferimento;
		setDirty();
	}

	public String getNumeroRiferimento() {
		return iNumeroRiferimento;
	}

	public void setQuantitaRichiestaUmPrm(BigDecimal quantitaRichiestaUmPrm) {
		this.iQuantitaRichiestaUmPrm = quantitaRichiestaUmPrm;
		setDirty();
	}

	public BigDecimal getQuantitaRichiestaUmPrm() {
		return iQuantitaRichiestaUmPrm;
	}

	public void setQuantitaRichiestaUmSec(BigDecimal quantitaRichiestaUmSec) {
		this.iQuantitaRichiestaUmSec = quantitaRichiestaUmSec;
		setDirty();
	}

	public BigDecimal getQuantitaRichiestaUmSec() {
		return iQuantitaRichiestaUmSec;
	}

	public void setQuantitaPrelevataUmPrm(BigDecimal quantitaPrelevataUmPrm) {
		this.iQuantitaPrelevataUmPrm = quantitaPrelevataUmPrm;
		setDirty();
	}

	public BigDecimal getQuantitaPrelevataUmPrm() {
		return iQuantitaPrelevataUmPrm;
	}

	public void setQuantitaPrelevataUmSec(BigDecimal quantitaPrelevataUmSec) {
		this.iQuantitaPrelevataUmSec = quantitaPrelevataUmSec;
		setDirty();
	}

	public BigDecimal getQuantitaPrelevataUmSec() {
		return iQuantitaPrelevataUmSec;
	}

	public void setPriorita(String priorita) {
		this.iPriorita = priorita;
		setDirty();
	}

	public String getPriorita() {
		return iPriorita;
	}

	public void setPrelevabile(boolean prelevabile) {
		this.iPrelevabile = prelevabile;
		setDirty();
	}

	public boolean getPrelevabile() {
		return iPrelevabile;
	}

	public void setStatoPrelievo(char statoPrelievo) {
		this.iStatoPrelievo = statoPrelievo;
		setDirty();
	}

	public char getStatoPrelievo() {
		return iStatoPrelievo;
	}

	public void setStatoRiga(char statoRiga) {
		this.iStatoRiga = statoRiga;
		setDirty();
	}

	public char getStatoRiga() {
		return iStatoRiga;
	}

	public void setAttivitaesecmateriale(AttivitaEsecMateriale attivitaesecmateriale) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (attivitaesecmateriale != null) {
			idAzienda = KeyHelper.getTokenObjectKey(attivitaesecmateriale.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iAttivitaesecmateriale.setObject(attivitaesecmateriale);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public AttivitaEsecMateriale getAttivitaesecmateriale() {
		return (AttivitaEsecMateriale) iAttivitaesecmateriale.getObject();
	}

	public void setAttivitaesecmaterialeKey(String key) {
		String oldObjectKey = getKey();
		iAttivitaesecmateriale.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getAttivitaesecmaterialeKey() {
		return iAttivitaesecmateriale.getKey();
	}

	public void setIdAnnoOrdineRigaMat(String idAnnoOrdineRigaMat) {
		String key = iAttivitaesecmateriale.getKey();
		iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idAnnoOrdineRigaMat));
		setDirty();
	}

	public String getIdAnnoOrdineRigaMat() {
		String key = iAttivitaesecmateriale.getKey();
		String objIdAnnoOrdineRigaMat = KeyHelper.getTokenObjectKey(key, 2);
		return objIdAnnoOrdineRigaMat;

	}

	public void setIdNumeroOrdRigaMat(String idNumeroOrdRigaMat) {
		String key = iAttivitaesecmateriale.getKey();
		iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key, 3, idNumeroOrdRigaMat));
		setDirty();
	}

	public String getIdNumeroOrdRigaMat() {
		String key = iAttivitaesecmateriale.getKey();
		String objIdNumeroOrdRigaMat = KeyHelper.getTokenObjectKey(key, 3);
		return objIdNumeroOrdRigaMat;

	}

	public void setIdRigaAttivitaRigaMat(Integer idRigaAttivitaRigaMat) {
		String key = iAttivitaesecmateriale.getKey();
		iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key, 4, idRigaAttivitaRigaMat));
		setDirty();
	}

	public Integer getIdRigaAttivitaRigaMat() {
		String key = iAttivitaesecmateriale.getKey();
		String objIdRigaAttivitaRigaMat = KeyHelper.getTokenObjectKey(key, 4);
		return KeyHelper.stringToIntegerObj(objIdRigaAttivitaRigaMat);

	}

	public void setIdRigaMateriale(Integer idRigaMateriale) {
		String key = iAttivitaesecmateriale.getKey();
		iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key, 5, idRigaMateriale));
		setDirty();
	}

	public Integer getIdRigaMateriale() {
		String key = iAttivitaesecmateriale.getKey();
		String objIdRigaMateriale = KeyHelper.getTokenObjectKey(key, 5);
		return KeyHelper.stringToIntegerObj(objIdRigaMateriale);
	}

	public void setArticolo(Articolo articolo) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (articolo != null) {
			idAzienda = KeyHelper.getTokenObjectKey(articolo.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iArticolo.setObject(articolo);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public Articolo getArticolo() {
		return (Articolo) iArticolo.getObject();
	}

	public void setArticoloKey(String key) {
		String oldObjectKey = getKey();
		iArticolo.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getArticoloKey() {
		return iArticolo.getKey();
	}

	public void setIdArticolo(String idArticolo) {
		String key = iArticolo.getKey();
		iArticolo.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idArticolo));
		setDirty();
	}

	public String getIdArticolo() {
		String key = iArticolo.getKey();
		String objIdArticolo = KeyHelper.getTokenObjectKey(key, 2);
		return objIdArticolo;
	}

	public void setCliente(ClientePrimrose cliente) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (cliente != null) {
			idAzienda = KeyHelper.getTokenObjectKey(cliente.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iCliente.setObject(cliente);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public ClientePrimrose getCliente() {
		return (ClientePrimrose) iCliente.getObject();
	}

	public void setClienteKey(String key) {
		String oldObjectKey = getKey();
		iCliente.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getClienteKey() {
		return iCliente.getKey();
	}

	public void setIdCliente(String idCliente) {
		String key = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCliente));
		setDirty();
	}

	public String getIdCliente() {
		String key = iCliente.getKey();
		String objIdCliente = KeyHelper.getTokenObjectKey(key, 2);
		return objIdCliente;
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAttivitaesecmateriale.getKey();
		String objIdAzienda = KeyHelper.getTokenObjectKey(key, 1);
		return objIdAzienda;

	}

	public void setMissione(Missione missione) {
		this.iMissione.setObject(missione);
		setDirty();
	}

	public Missione getMissione() {
		return (Missione) iMissione.getObject();
	}

	public void setMissioneKey(String key) {
		iMissione.setKey(key);
		setDirty();
	}

	public String getMissioneKey() {
		return iMissione.getKey();
	}

	public void setIdCodMagFisicoMissione(String idCodMagFisicoMissione) {
		String key = iMissione.getKey();
		iMissione.setKey(KeyHelper.replaceTokenObjectKey(key, 1, idCodMagFisicoMissione));
		setDirty();
	}

	public String getIdCodMagFisicoMissione() {
		String key = iMissione.getKey();
		String objIdCodMagFisicoMissione = KeyHelper.getTokenObjectKey(key, 1);
		return objIdCodMagFisicoMissione;

	}

	public void setIdCodiceMissione(Integer idCodiceMissione) {
		String key = iMissione.getKey();
		iMissione.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCodiceMissione));
		setDirty();
	}

	public Integer getIdCodiceMissione() {
		String key = iMissione.getKey();
		String objIdCodiceMissione = KeyHelper.getTokenObjectKey(key, 2);
		return KeyHelper.stringToIntegerObj(objIdCodiceMissione);
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YPianoCaricoToyotaRigaPO yPianoCaricoToyotaRigaPO = (YPianoCaricoToyotaRigaPO) obj;
		iAttivitaesecmateriale.setEqual(yPianoCaricoToyotaRigaPO.iAttivitaesecmateriale);
		iArticolo.setEqual(yPianoCaricoToyotaRigaPO.iArticolo);
		iCliente.setEqual(yPianoCaricoToyotaRigaPO.iCliente);
		iMissione.setEqual(yPianoCaricoToyotaRigaPO.iMissione);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setAnnoDocumento(KeyHelper.getTokenObjectKey(key, 2));
		setNumeroDocumento(KeyHelper.getTokenObjectKey(key, 3));
		setNumeroRigaDocumento(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 4)));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String annoDocumento = getAnnoDocumento();
		String numeroDocumento = getNumeroDocumento();
		Integer numeroRigaDocumento = getNumeroRigaDocumento();
		Object[] keyParts = { idAzienda, annoDocumento, numeroDocumento, numeroRigaDocumento };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String getOrderByClause() {
		return "";
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YPianoCaricoToyotaRigaTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		String key1 = iAttivitaesecmateriale.getKey();
		iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idAzienda));
		String key2 = iArticolo.getKey();
		iArticolo.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
		//iAzienda.setKey(idAzienda);
	}

}
