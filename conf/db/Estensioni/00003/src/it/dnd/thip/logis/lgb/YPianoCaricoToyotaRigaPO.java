/*
 * @(#)YPianoCaricoToyotaRigaPO.java
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
import it.thera.thip.produzione.ordese.AttivitaEsecMateriale;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.logis.fis.Missione;
import java.math.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YPianoCaricoToyotaRigaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

  
  /**
   *  instance
   */
  private static YPianoCaricoToyotaRiga cInstance;

  /**
   * Attributo iNumeroRigaDocumento
   */
  protected Integer iNumeroRigaDocumento;

  /**
   * Attributo iNumRitornoAttivita
   */
  protected String iNumRitornoAttivita;

  /**
   * Attributo iNumeroRiferimento
   */
  protected String iNumeroRiferimento;

  /**
   * Attributo iQuantitaRichiestaUmPrm
   */
  protected BigDecimal iQuantitaRichiestaUmPrm;

  /**
   * Attributo iQuantitaRichiestaUmSec
   */
  protected BigDecimal iQuantitaRichiestaUmSec;

  /**
   * Attributo iQuantitaPrelevataUmPrm
   */
  protected BigDecimal iQuantitaPrelevataUmPrm;

  /**
   * Attributo iQuantitaPrelevataUmSec
   */
  protected BigDecimal iQuantitaPrelevataUmSec;

  /**
   * Attributo iPriorita
   */
  protected String iPriorita = "50";

  /**
   * Attributo iPrelevabile
   */
  protected boolean iPrelevabile = false;

  /**
   * Attributo iStatoPrelievo
   */
  protected char iStatoPrelievo = '0';

  /**
   * Attributo iStatoRiga
   */
  protected char iStatoRiga = 'A';

  /**
   * Attributo iAttivitaesecmateriale
   */
  protected Proxy iAttivitaesecmateriale = new Proxy(it.thera.thip.produzione.ordese.AttivitaEsecMateriale.class);

  /**
   * Attributo iArticolo
   */
  protected Proxy iArticolo = new Proxy(it.thera.thip.base.articolo.Articolo.class);

  /**
   * Attributo iCliente
   */
  protected Proxy iCliente = new Proxy(it.thera.thip.base.cliente.ClientePrimrose.class);

  /**
   * Attributo iParent
   */
  protected Proxy iParent = new Proxy(it.dnd.thip.logis.lgb.YPianoCaricoToyota.class);

  /**
   * Attributo iMissione
   */
  protected Proxy iMissione = new Proxy(it.thera.thip.logis.fis.Missione.class);

  
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
      cInstance = (YPianoCaricoToyotaRiga)Factory.createObject(YPianoCaricoToyotaRiga.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YPianoCaricoToyotaRiga
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YPianoCaricoToyotaRiga elementWithKey(String key, int lockType) throws SQLException {
    return (YPianoCaricoToyotaRiga)PersistentObject.elementWithKey(YPianoCaricoToyotaRiga.class, key, lockType);
  }

  /**
   * YPianoCaricoToyotaRigaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public YPianoCaricoToyotaRigaPO() {
    setNumeroRigaDocumento(new Integer(0));
    setPriorita("50");
    setPrelevabile(false);
    setStatoPrelievo('0');
    setStatoRiga('A');
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param numeroRigaDocumento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNumeroRigaDocumento(Integer numeroRigaDocumento) {
    this.iNumeroRigaDocumento = numeroRigaDocumento;
    setDirty();
    setOnDB(false);
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
  public Integer getNumeroRigaDocumento() {
    return iNumeroRigaDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param numRitornoAttivita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNumRitornoAttivita(String numRitornoAttivita) {
    this.iNumRitornoAttivita = numRitornoAttivita;
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
  public String getNumRitornoAttivita() {
    return iNumRitornoAttivita;
  }

  /**
   * Valorizza l'attributo. 
   * @param numeroRiferimento
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNumeroRiferimento(String numeroRiferimento) {
    this.iNumeroRiferimento = numeroRiferimento;
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
  public String getNumeroRiferimento() {
    return iNumeroRiferimento;
  }

  /**
   * Valorizza l'attributo. 
   * @param quantitaRichiestaUmPrm
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setQuantitaRichiestaUmPrm(BigDecimal quantitaRichiestaUmPrm) {
    this.iQuantitaRichiestaUmPrm = quantitaRichiestaUmPrm;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getQuantitaRichiestaUmPrm() {
    return iQuantitaRichiestaUmPrm;
  }

  /**
   * Valorizza l'attributo. 
   * @param quantitaRichiestaUmSec
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setQuantitaRichiestaUmSec(BigDecimal quantitaRichiestaUmSec) {
    this.iQuantitaRichiestaUmSec = quantitaRichiestaUmSec;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getQuantitaRichiestaUmSec() {
    return iQuantitaRichiestaUmSec;
  }

  /**
   * Valorizza l'attributo. 
   * @param quantitaPrelevataUmPrm
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setQuantitaPrelevataUmPrm(BigDecimal quantitaPrelevataUmPrm) {
    this.iQuantitaPrelevataUmPrm = quantitaPrelevataUmPrm;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getQuantitaPrelevataUmPrm() {
    return iQuantitaPrelevataUmPrm;
  }

  /**
   * Valorizza l'attributo. 
   * @param quantitaPrelevataUmSec
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setQuantitaPrelevataUmSec(BigDecimal quantitaPrelevataUmSec) {
    this.iQuantitaPrelevataUmSec = quantitaPrelevataUmSec;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getQuantitaPrelevataUmSec() {
    return iQuantitaPrelevataUmSec;
  }

  /**
   * Valorizza l'attributo. 
   * @param priorita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setPriorita(String priorita) {
    this.iPriorita = priorita;
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
  public String getPriorita() {
    return iPriorita;
  }

  /**
   * Valorizza l'attributo. 
   * @param prelevabile
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setPrelevabile(boolean prelevabile) {
    this.iPrelevabile = prelevabile;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean getPrelevabile() {
    return iPrelevabile;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoPrelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoPrelievo(char statoPrelievo) {
    this.iStatoPrelievo = statoPrelievo;
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
  public char getStatoPrelievo() {
    return iStatoPrelievo;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoRiga
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoRiga(char statoRiga) {
    this.iStatoRiga = statoRiga;
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
  public char getStatoRiga() {
    return iStatoRiga;
  }

  /**
   * Valorizza l'attributo. 
   * @param attivitaesecmateriale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return AttivitaEsecMateriale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public AttivitaEsecMateriale getAttivitaesecmateriale() {
    return (AttivitaEsecMateriale)iAttivitaesecmateriale.getObject();
  }

  /**
   * setAttivitaesecmaterialeKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getAttivitaesecmaterialeKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getAttivitaesecmaterialeKey() {
    return iAttivitaesecmateriale.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAnnoOrdineRigaMat
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAnnoOrdineRigaMat(String idAnnoOrdineRigaMat) {
    String key = iAttivitaesecmateriale.getKey();
    iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idAnnoOrdineRigaMat));
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
  public String getIdAnnoOrdineRigaMat() {
    String key = iAttivitaesecmateriale.getKey();
    String objIdAnnoOrdineRigaMat = KeyHelper.getTokenObjectKey(key,2);
    return objIdAnnoOrdineRigaMat;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idNumeroOrdRigaMat
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdNumeroOrdRigaMat(String idNumeroOrdRigaMat) {
    String key = iAttivitaesecmateriale.getKey();
    iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key , 3, idNumeroOrdRigaMat));
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
  public String getIdNumeroOrdRigaMat() {
    String key = iAttivitaesecmateriale.getKey();
    String objIdNumeroOrdRigaMat = KeyHelper.getTokenObjectKey(key,3);
    return objIdNumeroOrdRigaMat;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idRigaAttivitaRigaMat
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdRigaAttivitaRigaMat(Integer idRigaAttivitaRigaMat) {
    String key = iAttivitaesecmateriale.getKey();
    iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key , 4, idRigaAttivitaRigaMat));
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
  public Integer getIdRigaAttivitaRigaMat() {
    String key = iAttivitaesecmateriale.getKey();
    String objIdRigaAttivitaRigaMat = KeyHelper.getTokenObjectKey(key,4);
    return KeyHelper.stringToIntegerObj(objIdRigaAttivitaRigaMat);
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idRigaMateriale
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdRigaMateriale(Integer idRigaMateriale) {
    String key = iAttivitaesecmateriale.getKey();
    iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key , 5, idRigaMateriale));
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
  public Integer getIdRigaMateriale() {
    String key = iAttivitaesecmateriale.getKey();
    String objIdRigaMateriale = KeyHelper.getTokenObjectKey(key,5);
    return KeyHelper.stringToIntegerObj(objIdRigaMateriale);
  }

  /**
   * Valorizza l'attributo. 
   * @param articolo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return Articolo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Articolo getArticolo() {
    return (Articolo)iArticolo.getObject();
  }

  /**
   * setArticoloKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getArticoloKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getArticoloKey() {
    return iArticolo.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idArticolo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdArticolo(String idArticolo) {
    String key = iArticolo.getKey();
    iArticolo.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idArticolo));
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
  public String getIdArticolo() {
    String key = iArticolo.getKey();
    String objIdArticolo = KeyHelper.getTokenObjectKey(key,2);
    return objIdArticolo;
  }

  /**
   * Valorizza l'attributo. 
   * @param cliente
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return ClientePrimrose
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public ClientePrimrose getCliente() {
    return (ClientePrimrose)iCliente.getObject();
  }

  /**
   * setClienteKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getClienteKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getClienteKey() {
    return iCliente.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idCliente
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCliente(String idCliente) {
    String key = iCliente.getKey();
    iCliente.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idCliente));
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
  public String getIdCliente() {
    String key = iCliente.getKey();
    String objIdCliente = KeyHelper.getTokenObjectKey(key,2);
    return objIdCliente;
  }

  /**
   * Valorizza l'attributo. 
   * @param parent
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setParent(YPianoCaricoToyota parent) {
    String idAzienda = getIdAzienda();
    if (parent != null) {
      idAzienda = KeyHelper.getTokenObjectKey(parent.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iParent.setObject(parent);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return YPianoCaricoToyota
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public YPianoCaricoToyota getParent() {
    return (YPianoCaricoToyota)iParent.getObject();
  }

  /**
   * setParentKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setParentKey(String key) {
    iParent.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * getParentKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getParentKey() {
    return iParent.getKey();
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
    String key = iAttivitaesecmateriale.getKey();
    String objIdAzienda = KeyHelper.getTokenObjectKey(key,1);
    return objIdAzienda;
    
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
    String key = iParent.getKey();
    iParent.setKey(KeyHelper.replaceTokenObjectKey(key , 2, annoDocumento));
    setDirty();
    setOnDB(false);
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
    String key = iParent.getKey();
    String objAnnoDocumento = KeyHelper.getTokenObjectKey(key,2);
    return objAnnoDocumento;
    
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
    String key = iParent.getKey();
    iParent.setKey(KeyHelper.replaceTokenObjectKey(key , 3, numeroDocumento));
    setDirty();
    setOnDB(false);
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
    String key = iParent.getKey();
    String objNumeroDocumento = KeyHelper.getTokenObjectKey(key,3);
    return objNumeroDocumento;
  }

  /**
   * Valorizza l'attributo. 
   * @param missione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMissione(Missione missione) {
    this.iMissione.setObject(missione);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Missione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public Missione getMissione() {
    return (Missione)iMissione.getObject();
  }

  /**
   * setMissioneKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setMissioneKey(String key) {
    iMissione.setKey(key);
    setDirty();
  }

  /**
   * getMissioneKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getMissioneKey() {
    return iMissione.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodMagFisicoMissione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodMagFisicoMissione(String idCodMagFisicoMissione) {
    String key = iMissione.getKey();
    iMissione.setKey(KeyHelper.replaceTokenObjectKey(key , 1, idCodMagFisicoMissione));
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
  public String getIdCodMagFisicoMissione() {
    String key = iMissione.getKey();
    String objIdCodMagFisicoMissione = KeyHelper.getTokenObjectKey(key,1);
    return objIdCodMagFisicoMissione;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodiceMissione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodiceMissione(Integer idCodiceMissione) {
    String key = iMissione.getKey();
    iMissione.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idCodiceMissione));
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
  public Integer getIdCodiceMissione() {
    String key = iMissione.getKey();
    String objIdCodiceMissione = KeyHelper.getTokenObjectKey(key,2);
    return KeyHelper.stringToIntegerObj(objIdCodiceMissione);
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
    YPianoCaricoToyotaRigaPO yPianoCaricoToyotaRigaPO = (YPianoCaricoToyotaRigaPO)obj;
    iAttivitaesecmateriale.setEqual(yPianoCaricoToyotaRigaPO.iAttivitaesecmateriale);
    iArticolo.setEqual(yPianoCaricoToyotaRigaPO.iArticolo);
    iCliente.setEqual(yPianoCaricoToyotaRigaPO.iCliente);
    iParent.setEqual(yPianoCaricoToyotaRigaPO.iParent);
    iMissione.setEqual(yPianoCaricoToyotaRigaPO.iMissione);
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
    setNumeroRigaDocumento(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 4)));
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
    Integer numeroRigaDocumento = getNumeroRigaDocumento();
    Object[] keyParts = {idAzienda, annoDocumento, numeroDocumento, numeroRigaDocumento};
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
   * getFatherKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getFatherKey() {
    return getParentKey();
  }

  /**
   * setFatherKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setFatherKey(String key) {
    setParentKey(key);
  }

  /**
   * setFather
   * @param father
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setFather(PersistentObject father) {
    iParent.setObject(father);
  }

  /**
   * getOrderByClause
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getOrderByClause() {
    return "";
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
    return YPianoCaricoToyotaRigaTM.getInstance();
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
    String key1 = iAttivitaesecmateriale.getKey();
    iAttivitaesecmateriale.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idAzienda));
    String key2 = iArticolo.getKey();
    iArticolo.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    String key3 = iCliente.getKey();
    iCliente.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
    iAzienda.setKey(idAzienda);
        String key5 = iParent.getKey();
    iParent.setKey(KeyHelper.replaceTokenObjectKey(key5, 1, idAzienda));
  }

}

