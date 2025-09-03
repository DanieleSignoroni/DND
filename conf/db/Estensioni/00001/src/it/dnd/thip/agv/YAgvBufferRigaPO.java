/*
 * @(#)YAgvBufferRigaPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 03/09/2025 at 10:09:19
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 03/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.agv;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YAgvBufferRigaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

  
  /**
   *  instance
   */
  private static YAgvBufferRiga cInstance;

  /**
   * Attributo iIdRigaBuffer
   */
  protected Integer iIdRigaBuffer;

  /**
   * Attributo iPianocaricotoyotariga
   */
  protected Proxy iPianocaricotoyotariga = new Proxy(it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga.class);

  /**
   * Attributo iParent
   */
  protected Proxy iParent = new Proxy(it.dnd.thip.agv.YAgvBufferTestata.class);

  
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
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YAgvBufferRiga)Factory.createObject(YAgvBufferRiga.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YAgvBufferRiga
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YAgvBufferRiga elementWithKey(String key, int lockType) throws SQLException {
    return (YAgvBufferRiga)PersistentObject.elementWithKey(YAgvBufferRiga.class, key, lockType);
  }

  /**
   * YAgvBufferRigaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public YAgvBufferRigaPO() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param idRigaBuffer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdRigaBuffer(Integer idRigaBuffer) {
    this.iIdRigaBuffer = idRigaBuffer;
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
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdRigaBuffer() {
    return iIdRigaBuffer;
  }

  /**
   * Valorizza l'attributo. 
   * @param pianocaricotoyotariga
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return YPianoCaricoToyotaRiga
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public YPianoCaricoToyotaRiga getPianocaricotoyotariga() {
    return (YPianoCaricoToyotaRiga)iPianocaricotoyotariga.getObject();
  }

  /**
   * setPianocaricotoyotarigaKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getPianocaricotoyotarigaKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getPianocaricotoyotarigaKey() {
    return iPianocaricotoyotariga.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAnnoPcToyota
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAnnoPcToyota(String idAnnoPcToyota) {
    String key = iPianocaricotoyotariga.getKey();
    iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idAnnoPcToyota));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAnnoPcToyota() {
    String key = iPianocaricotoyotariga.getKey();
    String objIdAnnoPcToyota = KeyHelper.getTokenObjectKey(key,2);
    return objIdAnnoPcToyota;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idNumeroPcToyota
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdNumeroPcToyota(String idNumeroPcToyota) {
    String key = iPianocaricotoyotariga.getKey();
    iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key , 3, idNumeroPcToyota));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdNumeroPcToyota() {
    String key = iPianocaricotoyotariga.getKey();
    String objIdNumeroPcToyota = KeyHelper.getTokenObjectKey(key,3);
    return objIdNumeroPcToyota;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idRigaPcToyota
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdRigaPcToyota(Integer idRigaPcToyota) {
    String key = iPianocaricotoyotariga.getKey();
    iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key , 4, idRigaPcToyota));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Integer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdRigaPcToyota() {
    String key = iPianocaricotoyotariga.getKey();
    String objIdRigaPcToyota = KeyHelper.getTokenObjectKey(key,4);
    return KeyHelper.stringToIntegerObj(objIdRigaPcToyota);
  }

  /**
   * Valorizza l'attributo. 
   * @param parent
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return YAgvBufferTestata
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public YAgvBufferTestata getParent() {
    return (YAgvBufferTestata)iParent.getObject();
  }

  /**
   * setParentKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param idBuffer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdBuffer(Integer idBuffer) {
    String key = iParent.getKey();
    iParent.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idBuffer));
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
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdBuffer() {
    String key = iParent.getKey();
    String objIdBuffer = KeyHelper.getTokenObjectKey(key,2);
    return KeyHelper.stringToIntegerObj(objIdBuffer);
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YAgvBufferRigaPO yAgvBufferRigaPO = (YAgvBufferRigaPO)obj;
    iPianocaricotoyotariga.setEqual(yAgvBufferRigaPO.iPianocaricotoyotariga);
    iParent.setEqual(yAgvBufferRigaPO.iParent);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setIdBuffer(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
    setIdRigaBuffer(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 3)));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    Integer idBuffer = getIdBuffer();
    Integer idRigaBuffer = getIdRigaBuffer();
    Object[] keyParts = {idAzienda, idBuffer, idRigaBuffer};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    Wizard     Codice generato da Wizard
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
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YAgvBufferRigaTM.getInstance();
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iPianocaricotoyotariga.getKey();
    iPianocaricotoyotariga.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    String key3 = iParent.getKey();
    iParent.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
  }

}

