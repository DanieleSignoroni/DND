/*
 * @(#)YPianoCaricoToyotaPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 08/04/2025 at 12:22:55
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 08/04/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.logis.lgb;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.produzione.ordese.AttivitaEsecutiva;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.fis.Ubicazione;
import it.thera.thip.logis.fis.MagFisico;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YPianoCaricoToyotaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YPianoCaricoToyota cInstance;

  /**
   * Attributo iAnnoDocumento
   */
  protected String iAnnoDocumento;

  /**
   * Attributo iNumeroDocumento
   */
  protected String iNumeroDocumento;

  /**
   * Attributo iDataDocumento
   */
  protected java.sql.Date iDataDocumento;

  /**
   * Attributo iStatoUdc
   */
  protected char iStatoUdc = '0';

  /**
   * Attributo iStatoGestione
   */
  protected char iStatoGestione = 'O';

  /**
   * Attributo iAttivitaesecutiva
   */
  protected Proxy iAttivitaesecutiva = new Proxy(it.thera.thip.produzione.ordese.AttivitaEsecutiva.class);

  /**
   * Attributo iReparto
   */
  protected Proxy iReparto = new Proxy(it.thera.thip.base.azienda.Reparto.class);

  /**
   * Attributo iUbicazionestock
   */
  protected Proxy iUbicazionestock = new Proxy(it.thera.thip.logis.fis.Ubicazione.class);

  /**
   * Attributo iMagfisicostock
   */
  protected Proxy iMagfisicostock = new Proxy(it.thera.thip.logis.fis.MagFisico.class);

  /**
   * Attributo iUbicazioneprelievo
   */
  protected Proxy iUbicazioneprelievo = new Proxy(it.thera.thip.logis.fis.Ubicazione.class);

  /**
   * Attributo iMagfisicoprl
   */
  protected Proxy iMagfisicoprl = new Proxy(it.thera.thip.logis.fis.MagFisico.class);

  /**
   * Attributo iUdc
   */
  protected Proxy iUdc = new Proxy(it.thera.thip.logis.fis.MappaUdc.class);

  /**
   * Attributo iYPianoCaricoToyotaRighe
   */
  protected OneToMany iYPianoCaricoToyotaRighe = new OneToMany(it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga.class, this, 7, false);

  
  /**
   *  retrieveList
   * @param where
   * @param orderBy
   * @param optimistic
   * @return Vector
   * @throws SQLException
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YPianoCaricoToyota)Factory.createObject(YPianoCaricoToyota.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YPianoCaricoToyota
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YPianoCaricoToyota elementWithKey(String key, int lockType) throws SQLException {
    return (YPianoCaricoToyota)PersistentObject.elementWithKey(YPianoCaricoToyota.class, key, lockType);
  }

  /**
   * YPianoCaricoToyotaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public YPianoCaricoToyotaPO() {
    setStatoUdc('0');
    setStatoGestione('O');
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param annoDocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setAnnoDocumento(String annoDocumento) {
    this.iAnnoDocumento = annoDocumento;
    setDirty();
    setOnDB(false);
    iYPianoCaricoToyotaRighe.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getAnnoDocumento() {
    return iAnnoDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param numeroDocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNumeroDocumento(String numeroDocumento) {
    this.iNumeroDocumento = numeroDocumento;
    setDirty();
    setOnDB(false);
    iYPianoCaricoToyotaRighe.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getNumeroDocumento() {
    return iNumeroDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param dataDocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setDataDocumento(java.sql.Date dataDocumento) {
    this.iDataDocumento = dataDocumento;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Date
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Date getDataDocumento() {
    return iDataDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoUdc
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoUdc(char statoUdc) {
    this.iStatoUdc = statoUdc;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public char getStatoUdc() {
    return iStatoUdc;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoGestione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoGestione(char statoGestione) {
    this.iStatoGestione = statoGestione;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public char getStatoGestione() {
    return iStatoGestione;
  }

  /**
   * Valorizza l'attributo. 
   * @param attivitaesecutiva
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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
      iYPianoCaricoToyotaRighe.setFatherKeyChanged();
    }
  }

  /**
   * Restituisce l'attributo. 
   * @return AttivitaEsecutiva
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public AttivitaEsecutiva getAttivitaesecutiva() {
    return (AttivitaEsecutiva)iAttivitaesecutiva.getObject();
  }

  /**
   * setAttivitaesecutivaKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setAttivitaesecutivaKey(String key) {
    String oldObjectKey = getKey();
    iAttivitaesecutiva.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYPianoCaricoToyotaRighe.setFatherKeyChanged();
    }
  }

  /**
   * getAttivitaesecutivaKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getAttivitaesecutivaKey() {
    return iAttivitaesecutiva.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAnnoOrdine
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAnnoOrdine(String idAnnoOrdine) {
    String key = iAttivitaesecutiva.getKey();
    iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idAnnoOrdine));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAnnoOrdine() {
    String key = iAttivitaesecutiva.getKey();
    String objIdAnnoOrdine = KeyHelper.getTokenObjectKey(key,2);
    return objIdAnnoOrdine;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idNumeroOrdine
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdNumeroOrdine(String idNumeroOrdine) {
    String key = iAttivitaesecutiva.getKey();
    iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key , 3, idNumeroOrdine));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdNumeroOrdine() {
    String key = iAttivitaesecutiva.getKey();
    String objIdNumeroOrdine = KeyHelper.getTokenObjectKey(key,3);
    return objIdNumeroOrdine;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idRigaAttivita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdRigaAttivita(Integer idRigaAttivita) {
    String key = iAttivitaesecutiva.getKey();
    iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key , 4, idRigaAttivita));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Integer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdRigaAttivita() {
    String key = iAttivitaesecutiva.getKey();
    String objIdRigaAttivita = KeyHelper.getTokenObjectKey(key,4);
    return KeyHelper.stringToIntegerObj(objIdRigaAttivita);
  }

  /**
   * Valorizza l'attributo. 
   * @param reparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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
      iYPianoCaricoToyotaRighe.setFatherKeyChanged();
    }
  }

  /**
   * Restituisce l'attributo. 
   * @return Reparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Reparto getReparto() {
    return (Reparto)iReparto.getObject();
  }

  /**
   * setRepartoKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setRepartoKey(String key) {
    String oldObjectKey = getKey();
    iReparto.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYPianoCaricoToyotaRighe.setFatherKeyChanged();
    }
  }

  /**
   * getRepartoKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getRepartoKey() {
    return iReparto.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
    iYPianoCaricoToyotaRighe.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param idReparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdReparto(String idReparto) {
    String key = iReparto.getKey();
    iReparto.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idReparto));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdReparto() {
    String key = iReparto.getKey();
    String objIdReparto = KeyHelper.getTokenObjectKey(key,2);
    return objIdReparto;
  }

  /**
   * Valorizza l'attributo. 
   * @param ubicazionestock
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUbicazionestock(Ubicazione ubicazionestock) {
    String idMagazzinoFisicoStock = getIdMagazzinoFisicoStock();
    if (ubicazionestock != null) {
      idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(ubicazionestock.getKey(), 2);
    }
    setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
    this.iUbicazionestock.setObject(ubicazionestock);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Ubicazione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Ubicazione getUbicazionestock() {
    return (Ubicazione)iUbicazionestock.getObject();
  }

  /**
   * setUbicazionestockKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUbicazionestockKey(String key) {
    iUbicazionestock.setKey(key);
    String idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key, 2);
    setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
    setDirty();
  }

  /**
   * getUbicazionestockKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getUbicazionestockKey() {
    return iUbicazionestock.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodiceUbicazioneStock
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodiceUbicazioneStock(String idCodiceUbicazioneStock) {
    String key = iUbicazionestock.getKey();
    iUbicazionestock.setKey(KeyHelper.replaceTokenObjectKey(key , 1, idCodiceUbicazioneStock));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdCodiceUbicazioneStock() {
    String key = iUbicazionestock.getKey();
    String objIdCodiceUbicazioneStock = KeyHelper.getTokenObjectKey(key,1);
    return objIdCodiceUbicazioneStock;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param magfisicostock
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMagfisicostock(MagFisico magfisicostock) {
    setIdMagazzinoFisicoStockInternal(magfisicostock.getKey());
    this.iMagfisicostock.setObject(magfisicostock);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return MagFisico
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public MagFisico getMagfisicostock() {
    return (MagFisico)iMagfisicostock.getObject();
  }

  /**
   * setMagfisicostockKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMagfisicostockKey(String key) {
    iMagfisicostock.setKey(key);
    setIdMagazzinoFisicoStockInternal(key);
    setDirty();
  }

  /**
   * getMagfisicostockKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getMagfisicostockKey() {
    return iMagfisicostock.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idMagazzinoFisicoStock
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdMagazzinoFisicoStock(String idMagazzinoFisicoStock) {
    setIdMagazzinoFisicoStockInternal(idMagazzinoFisicoStock);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdMagazzinoFisicoStock() {
    String key = iUbicazionestock.getKey();
    String objIdMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key,2);
    return objIdMagazzinoFisicoStock;
  }

  /**
   * Valorizza l'attributo. 
   * @param ubicazioneprelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUbicazioneprelievo(Ubicazione ubicazioneprelievo) {
    String idMagazzinoFisicoPrelievo = getIdMagazzinoFisicoPrelievo();
    if (ubicazioneprelievo != null) {
      idMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(ubicazioneprelievo.getKey(), 2);
    }
    setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
    this.iUbicazioneprelievo.setObject(ubicazioneprelievo);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Ubicazione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Ubicazione getUbicazioneprelievo() {
    return (Ubicazione)iUbicazioneprelievo.getObject();
  }

  /**
   * setUbicazioneprelievoKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUbicazioneprelievoKey(String key) {
    iUbicazioneprelievo.setKey(key);
    String idMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(key, 2);
    setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
    setDirty();
  }

  /**
   * getUbicazioneprelievoKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getUbicazioneprelievoKey() {
    return iUbicazioneprelievo.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodUbicazionePrelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodUbicazionePrelievo(String idCodUbicazionePrelievo) {
    String key = iUbicazioneprelievo.getKey();
    iUbicazioneprelievo.setKey(KeyHelper.replaceTokenObjectKey(key , 1, idCodUbicazionePrelievo));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdCodUbicazionePrelievo() {
    String key = iUbicazioneprelievo.getKey();
    String objIdCodUbicazionePrelievo = KeyHelper.getTokenObjectKey(key,1);
    return objIdCodUbicazionePrelievo;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param magfisicoprl
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMagfisicoprl(MagFisico magfisicoprl) {
    setIdMagazzinoFisicoPrelievoInternal(magfisicoprl.getKey());
    this.iMagfisicoprl.setObject(magfisicoprl);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return MagFisico
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public MagFisico getMagfisicoprl() {
    return (MagFisico)iMagfisicoprl.getObject();
  }

  /**
   * setMagfisicoprlKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMagfisicoprlKey(String key) {
    iMagfisicoprl.setKey(key);
    setIdMagazzinoFisicoPrelievoInternal(key);
    setDirty();
  }

  /**
   * getMagfisicoprlKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getMagfisicoprlKey() {
    return iMagfisicoprl.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idMagazzinoFisicoPrelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdMagazzinoFisicoPrelievo(String idMagazzinoFisicoPrelievo) {
    setIdMagazzinoFisicoPrelievoInternal(idMagazzinoFisicoPrelievo);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdMagazzinoFisicoPrelievo() {
    String key = iUbicazioneprelievo.getKey();
    String objIdMagazzinoFisicoPrelievo = KeyHelper.getTokenObjectKey(key,2);
    return objIdMagazzinoFisicoPrelievo;
  }

  /**
   * Valorizza l'attributo. 
   * @param udc
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUdc(MappaUdc udc) {
    this.iUdc.setObject(udc);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return MappaUdc
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public MappaUdc getUdc() {
    return (MappaUdc)iUdc.getObject();
  }

  /**
   * setUdcKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUdcKey(String key) {
    iUdc.setKey(key);
    setDirty();
  }

  /**
   * getUdcKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getUdcKey() {
    return iUdc.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodiceUdc
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodiceUdc(String idCodiceUdc) {
    iUdc.setKey(idCodiceUdc);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdCodiceUdc() {
    String key = iUdc.getKey();
    return key;
  }

  /**
   * getYPianoCaricoToyotaRighe
   * @return List
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public List getYPianoCaricoToyotaRighe() {
    return getYPianoCaricoToyotaRigheInternal();
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YPianoCaricoToyotaPO yPianoCaricoToyotaPO = (YPianoCaricoToyotaPO)obj;
    if (yPianoCaricoToyotaPO.iDataDocumento != null)
        iDataDocumento = (java.sql.Date)yPianoCaricoToyotaPO.iDataDocumento.clone();
    iAttivitaesecutiva.setEqual(yPianoCaricoToyotaPO.iAttivitaesecutiva);
    iReparto.setEqual(yPianoCaricoToyotaPO.iReparto);
    iUbicazionestock.setEqual(yPianoCaricoToyotaPO.iUbicazionestock);
    iMagfisicostock.setEqual(yPianoCaricoToyotaPO.iMagfisicostock);
    iUbicazioneprelievo.setEqual(yPianoCaricoToyotaPO.iUbicazioneprelievo);
    iMagfisicoprl.setEqual(yPianoCaricoToyotaPO.iMagfisicoprl);
    iUdc.setEqual(yPianoCaricoToyotaPO.iUdc);
    iYPianoCaricoToyotaRighe.setEqual(yPianoCaricoToyotaPO.iYPianoCaricoToyotaRighe);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Vector checkAll(BaseComponentsCollection components) {
    Vector errors = new Vector();
    components.runAllChecks(errors);
    return errors;
  }

  /**
   *  setKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setAnnoDocumento(KeyHelper.getTokenObjectKey(key, 2));
    setNumeroDocumento(KeyHelper.getTokenObjectKey(key, 3));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    String annoDocumento = getAnnoDocumento();
    String numeroDocumento = getNumeroDocumento();
    Object[] keyParts = {idAzienda, annoDocumento, numeroDocumento};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * saveOwnedObjects
   * @param rc
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public int saveOwnedObjects(int rc) throws SQLException {
    rc = iYPianoCaricoToyotaRighe.save(rc);
    return rc;
  }

  /**
   * deleteOwnedObjects
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public int deleteOwnedObjects() throws SQLException {
    return getYPianoCaricoToyotaRigheInternal().delete();
  }

  /**
   * initializeOwnedObjects
   * @param result
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean initializeOwnedObjects(boolean result) {
    result = iYPianoCaricoToyotaRighe.initialize(result);
    return result;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String toString() {
    return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
  }

  /**
   *  getTableManager
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YPianoCaricoToyotaTM.getInstance();
  }

  /**
   * getYPianoCaricoToyotaRigheInternal
   * @return OneToMany
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected OneToMany getYPianoCaricoToyotaRigheInternal() {
    if (iYPianoCaricoToyotaRighe.isNew())
        iYPianoCaricoToyotaRighe.retrieve();
    return iYPianoCaricoToyotaRighe;
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iAttivitaesecutiva.getKey();
    iAttivitaesecutiva.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    String key3 = iReparto.getKey();
    iReparto.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
  }

  /**
   * setIdMagazzinoFisicoStockInternal
   * @param idMagazzinoFisicoStock
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdMagazzinoFisicoStockInternal(String idMagazzinoFisicoStock) {
    String key1 = iUbicazionestock.getKey();
    iUbicazionestock.setKey(KeyHelper.replaceTokenObjectKey(key1, 2, idMagazzinoFisicoStock));
    iMagfisicostock.setKey(idMagazzinoFisicoStock);
  }

  /**
   * setIdMagazzinoFisicoPrelievoInternal
   * @param idMagazzinoFisicoPrelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdMagazzinoFisicoPrelievoInternal(String idMagazzinoFisicoPrelievo) {
    String key1 = iUbicazioneprelievo.getKey();
    iUbicazioneprelievo.setKey(KeyHelper.replaceTokenObjectKey(key1, 2, idMagazzinoFisicoPrelievo));
    iMagfisicoprl.setKey(idMagazzinoFisicoPrelievo);
  }

}

