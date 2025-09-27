/*
 * @(#)PsnDatiToyotaPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/09/2025 at 09:25:05
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class PsnDatiToyotaPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static PsnDatiToyota cInstance;

  /**
   * Attributo iClientIdPanth01
   */
  protected String iClientIdPanth01;

  /**
   * Attributo iClientSecretPanth01
   */
  protected String iClientSecretPanth01;

  /**
   * Attributo iUrlPanth01
   */
  protected String iUrlPanth01;

  /**
   * Attributo iClientIdPanth02
   */
  protected String iClientIdPanth02;

  /**
   * Attributo iClientSecretPanth02
   */
  protected String iClientSecretPanth02;

  /**
   * Attributo iUrlPanth02
   */
  protected String iUrlPanth02;

  
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
      cInstance = (PsnDatiToyota)Factory.createObject(PsnDatiToyota.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return PsnDatiToyota
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static PsnDatiToyota elementWithKey(String key, int lockType) throws SQLException {
    return (PsnDatiToyota)PersistentObject.elementWithKey(PsnDatiToyota.class, key, lockType);
  }

  /**
   * PsnDatiToyotaPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public PsnDatiToyotaPO() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param clientIdPanth01
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setClientIdPanth01(String clientIdPanth01) {
    this.iClientIdPanth01 = clientIdPanth01;
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
  public String getClientIdPanth01() {
    return iClientIdPanth01;
  }

  /**
   * Valorizza l'attributo. 
   * @param clientSecretPanth01
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setClientSecretPanth01(String clientSecretPanth01) {
    this.iClientSecretPanth01 = clientSecretPanth01;
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
  public String getClientSecretPanth01() {
    return iClientSecretPanth01;
  }

  /**
   * Valorizza l'attributo. 
   * @param urlPanth01
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUrlPanth01(String urlPanth01) {
    this.iUrlPanth01 = urlPanth01;
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
  public String getUrlPanth01() {
    return iUrlPanth01;
  }

  /**
   * Valorizza l'attributo. 
   * @param clientIdPanth02
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setClientIdPanth02(String clientIdPanth02) {
    this.iClientIdPanth02 = clientIdPanth02;
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
  public String getClientIdPanth02() {
    return iClientIdPanth02;
  }

  /**
   * Valorizza l'attributo. 
   * @param clientSecretPanth02
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setClientSecretPanth02(String clientSecretPanth02) {
    this.iClientSecretPanth02 = clientSecretPanth02;
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
  public String getClientSecretPanth02() {
    return iClientSecretPanth02;
  }

  /**
   * Valorizza l'attributo. 
   * @param urlPanth02
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setUrlPanth02(String urlPanth02) {
    this.iUrlPanth02 = urlPanth02;
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
  public String getUrlPanth02() {
    return iUrlPanth02;
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    iAzienda.setKey(idAzienda);
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
  public String getIdAzienda() {
    String key = iAzienda.getKey();
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
    setIdAzienda(key);
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
    return getIdAzienda();
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
    return PsnDatiToyotaTM.getInstance();
  }

}

