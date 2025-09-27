/*
 * @(#)SubscriptionPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/09/2025 at 09:40:42
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota.subscription;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import com.thera.thermfw.security.*;

public abstract class SubscriptionPO extends PersistentObjectDCE implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static Subscription cInstance;

  /**
   * Attributo iId
   */
  protected String iId;

  /**
   * Attributo iTimestampSubscription
   */
  protected java.sql.Timestamp iTimestampSubscription;

  /**
   * Attributo iSourceType
   */
  protected char iSourceType = '-';

  /**
   * Attributo iEndpoint
   */
  protected String iEndpoint;

  /**
   * Attributo iAuthentication
   */
  protected String iAuthentication;

  /**
   * Attributo iTsEndSubscription
   */
  protected java.sql.Timestamp iTsEndSubscription;

  /**
   * Attributo iTsSubRefreshed
   */
  protected java.sql.Timestamp iTsSubRefreshed;

  /**
   * Attributo iPassaToyota
   */
  protected boolean iPassaToyota = false;

  
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
      cInstance = (Subscription)Factory.createObject(Subscription.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return Subscription
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Subscription elementWithKey(String key, int lockType) throws SQLException {
    return (Subscription)PersistentObject.elementWithKey(Subscription.class, key, lockType);
  }

  /**
   * SubscriptionPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public SubscriptionPO() {
    setSourceType('-');
    setPassaToyota(false);
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
    this.iId = id;
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
    return iId;
  }

  /**
   * Valorizza l'attributo. 
   * @param timestampSubscription
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTimestampSubscription(java.sql.Timestamp timestampSubscription) {
    this.iTimestampSubscription = timestampSubscription;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Timestamp
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Timestamp getTimestampSubscription() {
    return iTimestampSubscription;
  }

  /**
   * Valorizza l'attributo. 
   * @param sourceType
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setSourceType(char sourceType) {
    this.iSourceType = sourceType;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public char getSourceType() {
    return iSourceType;
  }

  /**
   * Valorizza l'attributo. 
   * @param endpoint
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEndpoint(String endpoint) {
    this.iEndpoint = endpoint;
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
  public String getEndpoint() {
    return iEndpoint;
  }

  /**
   * Valorizza l'attributo. 
   * @param authentication
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setAuthentication(String authentication) {
    this.iAuthentication = authentication;
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
  public String getAuthentication() {
    return iAuthentication;
  }

  /**
   * Valorizza l'attributo. 
   * @param tsEndSubscription
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTsEndSubscription(java.sql.Timestamp tsEndSubscription) {
    this.iTsEndSubscription = tsEndSubscription;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Timestamp
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Timestamp getTsEndSubscription() {
    return iTsEndSubscription;
  }

  /**
   * Valorizza l'attributo. 
   * @param tsSubRefreshed
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTsSubRefreshed(java.sql.Timestamp tsSubRefreshed) {
    this.iTsSubRefreshed = tsSubRefreshed;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Timestamp
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Timestamp getTsSubRefreshed() {
    return iTsSubRefreshed;
  }

  /**
   * Valorizza l'attributo. 
   * @param passaToyota
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setPassaToyota(boolean passaToyota) {
    this.iPassaToyota = passaToyota;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean getPassaToyota() {
    return iPassaToyota;
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
    SubscriptionPO subscriptionPO = (SubscriptionPO)obj;
    if (subscriptionPO.iTimestampSubscription != null)
        iTimestampSubscription = (java.sql.Timestamp)subscriptionPO.iTimestampSubscription.clone();
    if (subscriptionPO.iTsEndSubscription != null)
        iTsEndSubscription = (java.sql.Timestamp)subscriptionPO.iTsEndSubscription.clone();
    if (subscriptionPO.iTsSubRefreshed != null)
        iTsSubRefreshed = (java.sql.Timestamp)subscriptionPO.iTsSubRefreshed.clone();
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
    setId(key);
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
    return getId();
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
    return SubscriptionTM.getInstance();
  }

}

