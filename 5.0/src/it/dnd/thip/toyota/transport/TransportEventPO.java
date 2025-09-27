/*
 * @(#)TransportEventPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/09/2025 at 13:43:12
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota.transport;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import com.thera.thermfw.security.*;

public abstract class TransportEventPO extends PersistentObjectDCE implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

  
  /**
   *  instance
   */
  private static TransportEvent cInstance;

  /**
   * Attributo iIndex
   */
  protected Integer iIndex;

  /**
   * Attributo iEventType
   */
  protected String iEventType;

  /**
   * Attributo iData
   */
  protected String iData;

  /**
   * Attributo iParent
   */
  protected Proxy iParent = new Proxy(it.dnd.thip.toyota.transport.Transport.class);

  
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
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (TransportEvent)Factory.createObject(TransportEvent.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return TransportEvent
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static TransportEvent elementWithKey(String key, int lockType) throws SQLException {
    return (TransportEvent)PersistentObject.elementWithKey(TransportEvent.class, key, lockType);
  }

  /**
   * TransportEventPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public TransportEventPO() {
  
    // TO DO
  }

  /**
   * Valorizza l'attributo. 
   * @param index
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIndex(Integer index) {
    this.iIndex = index;
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIndex() {
    return iIndex;
  }

  /**
   * Valorizza l'attributo. 
   * @param eventType
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEventType(String eventType) {
    this.iEventType = eventType;
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getEventType() {
    return iEventType;
  }

  /**
   * Valorizza l'attributo. 
   * @param data
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setData(String data) {
    this.iData = data;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getData() {
    return iData;
  }

  /**
   * Valorizza l'attributo. 
   * @param parent
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setParent(Transport parent) {
    this.iParent.setObject(parent);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return Transport
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public Transport getParent() {
    return (Transport)iParent.getObject();
  }

  /**
   * setParentKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setParentKey(String key) {
    iParent.setKey(key);
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getParentKey() {
    return iParent.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param id
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setId(String id) {
    iParent.setKey(id);
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getId() {
    String key = iParent.getKey();
    return key;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    TransportEventPO transportEventPO = (TransportEventPO)obj;
    iParent.setEqual(transportEventPO.iParent);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setId(KeyHelper.getTokenObjectKey(key, 1));
    setIndex(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
    setEventType(KeyHelper.getTokenObjectKey(key, 3));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String id = getId();
    Integer index = getIndex();
    String eventType = getEventType();
    Object[] keyParts = {id, index, eventType};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    Wizard     Codice generato da Wizard
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
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return TransportEventTM.getInstance();
  }

}

