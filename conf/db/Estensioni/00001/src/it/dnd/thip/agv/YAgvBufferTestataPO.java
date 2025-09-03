/*
 * @(#)YAgvBufferTestataPO.java
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
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YAgvBufferTestataPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YAgvBufferTestata cInstance;

  /**
   * Attributo iIdBuffer
   */
  protected Integer iIdBuffer;

  /**
   * Attributo iStatoBuffer
   */
  protected char iStatoBuffer = 'S';

  /**
   * Attributo iReparto1
   */
  protected Proxy iReparto1 = new Proxy(it.thera.thip.base.azienda.Reparto.class);

  /**
   * Attributo iReparto2
   */
  protected Proxy iReparto2 = new Proxy(it.thera.thip.base.azienda.Reparto.class);

  /**
   * Attributo iYAgvBufferRiga
   */
  protected OneToMany iYAgvBufferRiga = new OneToMany(it.dnd.thip.agv.YAgvBufferRiga.class, this, 3, false);

  
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
      cInstance = (YAgvBufferTestata)Factory.createObject(YAgvBufferTestata.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YAgvBufferTestata
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YAgvBufferTestata elementWithKey(String key, int lockType) throws SQLException {
    return (YAgvBufferTestata)PersistentObject.elementWithKey(YAgvBufferTestata.class, key, lockType);
  }

  /**
   * YAgvBufferTestataPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public YAgvBufferTestataPO() {
    setStatoBuffer('S');
    setIdAzienda(Azienda.getAziendaCorrente());
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
    this.iIdBuffer = idBuffer;
    setDirty();
    setOnDB(false);
    iYAgvBufferRiga.setFatherKeyChanged();
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
    return iIdBuffer;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoBuffer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoBuffer(char statoBuffer) {
    this.iStatoBuffer = statoBuffer;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public char getStatoBuffer() {
    return iStatoBuffer;
  }

  /**
   * Valorizza l'attributo. 
   * @param reparto1
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return Reparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Reparto getReparto1() {
    return (Reparto)iReparto1.getObject();
  }

  /**
   * setReparto1Key
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getReparto1Key
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getReparto1Key() {
    return iReparto1.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idReparto1
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdReparto1(String idReparto1) {
    String key = iReparto1.getKey();
    iReparto1.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idReparto1));
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
  public String getIdReparto1() {
    String key = iReparto1.getKey();
    String objIdReparto1 = KeyHelper.getTokenObjectKey(key,2);
    return objIdReparto1;
  }

  /**
   * Valorizza l'attributo. 
   * @param reparto2
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return Reparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Reparto getReparto2() {
    return (Reparto)iReparto2.getObject();
  }

  /**
   * setReparto2Key
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * getReparto2Key
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getReparto2Key() {
    return iReparto2.getKey();
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
    iYAgvBufferRiga.setFatherKeyChanged();
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
   * @param idReparto2
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdReparto2(String idReparto2) {
    String key = iReparto2.getKey();
    iReparto2.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idReparto2));
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
  public String getIdReparto2() {
    String key = iReparto2.getKey();
    String objIdReparto2 = KeyHelper.getTokenObjectKey(key,2);
    return objIdReparto2;
  }

  /**
   * getYAgvBufferRiga
   * @return List
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public List getYAgvBufferRiga() {
    return getYAgvBufferRigaInternal();
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
    YAgvBufferTestataPO yAgvBufferTestataPO = (YAgvBufferTestataPO)obj;
    iReparto1.setEqual(yAgvBufferTestataPO.iReparto1);
    iReparto2.setEqual(yAgvBufferTestataPO.iReparto2);
    iYAgvBufferRiga.setEqual(yAgvBufferTestataPO.iYAgvBufferRiga);
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
    Object[] keyParts = {idAzienda, idBuffer};
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
   * saveOwnedObjects
   * @param rc
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public int saveOwnedObjects(int rc) throws SQLException {
    rc = iYAgvBufferRiga.save(rc);
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
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public int deleteOwnedObjects() throws SQLException {
    return getYAgvBufferRigaInternal().delete();
  }

  /**
   * initializeOwnedObjects
   * @param result
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean initializeOwnedObjects(boolean result) {
    result = iYAgvBufferRiga.initialize(result);
    return result;
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
    return YAgvBufferTestataTM.getInstance();
  }

  /**
   * getYAgvBufferRigaInternal
   * @return OneToMany
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  protected OneToMany getYAgvBufferRigaInternal() {
    if (iYAgvBufferRiga.isNew())
        iYAgvBufferRiga.retrieve();
    return iYAgvBufferRiga;
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
        String key2 = iReparto1.getKey();
    iReparto1.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    String key3 = iReparto2.getKey();
    iReparto2.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
  }

}

