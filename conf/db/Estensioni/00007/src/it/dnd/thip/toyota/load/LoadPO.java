/*
 * @(#)LoadPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 17/09/2025 at 11:55:01
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 17/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota.load;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import com.thera.thermfw.security.*;

public abstract class LoadPO extends PersistentObjectDCE implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static Load cInstance;

  /**
   * Attributo iId
   */
  protected String iId;

  /**
   * Attributo iData
   */
  protected String iData;

  
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
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (Load)Factory.createObject(Load.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return Load
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Load elementWithKey(String key, int lockType) throws SQLException {
    return (Load)PersistentObject.elementWithKey(Load.class, key, lockType);
  }

  /**
   * LoadPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public LoadPO() {
  
    // TO DO
  }

  /**
   * Valorizza l'attributo. 
   * @param id
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getId() {
    return iId;
  }

  /**
   * Valorizza l'attributo. 
   * @param data
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getData() {
    return iData;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    Wizard     Codice generato da Wizard
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
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return LoadTM.getInstance();
  }

}

