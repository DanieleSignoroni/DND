/*
 * @(#)YArticoloCliente.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 02/05/2025 at 14:07:50
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 02/05/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.base.articolo;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.logis.fis.TipoUds;
import it.thera.thip.base.articolo.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;

public class YArticoloCliente extends ArticoloCliente {

  
  /**
   * Attributo iNrPezziBauletto
   */
  protected Integer iNrPezziBauletto;

  /**
   * Attributo iNrPezziUds
   */
  protected Integer iNrPezziUds;

  /**
   * Attributo iTipouds
   */
  protected Proxy iTipouds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

  
  /**
   * YArticoloCliente
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public YArticoloCliente() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param nrPezziBauletto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNrPezziBauletto(Integer nrPezziBauletto) {
    this.iNrPezziBauletto = nrPezziBauletto;
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
  public Integer getNrPezziBauletto() {
    return iNrPezziBauletto;
  }

  /**
   * Valorizza l'attributo. 
   * @param nrPezziUds
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setNrPezziUds(Integer nrPezziUds) {
    this.iNrPezziUds = nrPezziUds;
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
  public Integer getNrPezziUds() {
    return iNrPezziUds;
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
   * @param idTipoUDS
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdTipoUDS(String idTipoUDS) {
    iTipouds.setKey(idTipoUDS);
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
  public String getIdTipoUDS() {
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
    YArticoloCliente yArticoloCliente = (YArticoloCliente)obj;
    iTipouds.setEqual(yArticoloCliente.iTipouds);
  }

}

