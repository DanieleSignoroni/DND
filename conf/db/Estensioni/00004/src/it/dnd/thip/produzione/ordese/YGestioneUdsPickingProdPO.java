/*
 * @(#)YGestioneUdsPickingProdPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 02/05/2025 at 12:34:18
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 02/05/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.produzione.ordese;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.fis.TipoUds;
import java.math.*;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YGestioneUdsPickingProdPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YGestioneUdsPickingProd cInstance;

  /**
   * Attributo iNumeroRitorno
   */
  protected String iNumeroRitorno;

  /**
   * Attributo iIdCodiceLista
   */
  protected String iIdCodiceLista;

  /**
   * Attributo iIdCodiceRigaLista
   */
  protected Integer iIdCodiceRigaLista;

  /**
   * Attributo iQuantita
   */
  protected BigDecimal iQuantita;

  /**
   * Attributo iStatoUds
   */
  protected char iStatoUds = '0';

  /**
   * Attributo iTrasmessoLinea
   */
  protected boolean iTrasmessoLinea = true;

  /**
   * Attributo iTestatauds
   */
  protected Proxy iTestatauds = new Proxy(it.thera.thip.logis.fis.TestataUds.class);

  /**
   * Attributo iTipouds
   */
  protected Proxy iTipouds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

  
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
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YGestioneUdsPickingProd)Factory.createObject(YGestioneUdsPickingProd.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YGestioneUdsPickingProd
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YGestioneUdsPickingProd elementWithKey(String key, int lockType) throws SQLException {
    return (YGestioneUdsPickingProd)PersistentObject.elementWithKey(YGestioneUdsPickingProd.class, key, lockType);
  }

  /**
   * YGestioneUdsPickingProdPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public YGestioneUdsPickingProdPO() {
    setStatoUds('0');
    setTrasmessoLinea(true);
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param numeroRitorno
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNumeroRitorno(String numeroRitorno) {
    this.iNumeroRitorno = numeroRitorno;
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getNumeroRitorno() {
    return iNumeroRitorno;
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodiceLista
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodiceLista(String idCodiceLista) {
    this.iIdCodiceLista = idCodiceLista;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdCodiceLista() {
    return iIdCodiceLista;
  }

  /**
   * Valorizza l'attributo. 
   * @param idCodiceRigaLista
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdCodiceRigaLista(Integer idCodiceRigaLista) {
    this.iIdCodiceRigaLista = idCodiceRigaLista;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return Integer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdCodiceRigaLista() {
    return iIdCodiceRigaLista;
  }

  /**
   * Valorizza l'attributo. 
   * @param quantita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setQuantita(BigDecimal quantita) {
    this.iQuantita = quantita;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return BigDecimal
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public BigDecimal getQuantita() {
    return iQuantita;
  }

  /**
   * Valorizza l'attributo. 
   * @param statoUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setStatoUds(char statoUds) {
    this.iStatoUds = statoUds;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return char
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public char getStatoUds() {
    return iStatoUds;
  }

  /**
   * Valorizza l'attributo. 
   * @param trasmessoLinea
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTrasmessoLinea(boolean trasmessoLinea) {
    this.iTrasmessoLinea = trasmessoLinea;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public boolean getTrasmessoLinea() {
    return iTrasmessoLinea;
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param testatauds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTestatauds(TestataUds testatauds) {
    this.iTestatauds.setObject(testatauds);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return TestataUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public TestataUds getTestatauds() {
    return (TestataUds)iTestatauds.getObject();
  }

  /**
   * setTestataudsKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTestataudsKey(String key) {
    iTestatauds.setKey(key);
    setDirty();
    setOnDB(false);
  }

  /**
   * getTestataudsKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getTestataudsKey() {
    return iTestatauds.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdUds(String idUds) {
    iTestatauds.setKey(idUds);
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdUds() {
    String key = iTestatauds.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param tipouds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTipouds(TipoUds tipouds) {
    this.iTipouds.setObject(tipouds);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return TipoUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public TipoUds getTipouds() {
    return (TipoUds)iTipouds.getObject();
  }

  /**
   * setTipoudsKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTipoudsKey(String key) {
    iTipouds.setKey(key);
    setDirty();
  }

  /**
   * getTipoudsKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getTipoudsKey() {
    return iTipouds.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idTipoUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdTipoUds(String idTipoUds) {
    iTipouds.setKey(idTipoUds);
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdTipoUds() {
    String key = iTipouds.getKey();
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YGestioneUdsPickingProdPO yGestioneUdsPickingProdPO = (YGestioneUdsPickingProdPO)obj;
    iTestatauds.setEqual(yGestioneUdsPickingProdPO.iTestatauds);
    iTipouds.setEqual(yGestioneUdsPickingProdPO.iTipouds);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setNumeroRitorno(KeyHelper.getTokenObjectKey(key, 2));
    setIdUds(KeyHelper.getTokenObjectKey(key, 3));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    String numeroRitorno = getNumeroRitorno();
    String idUds = getIdUds();
    Object[] keyParts = {idAzienda, numeroRitorno, idUds};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
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
   * 02/05/2025    Wizard     Codice generato da Wizard
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
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YGestioneUdsPickingProdTM.getInstance();
  }

}

