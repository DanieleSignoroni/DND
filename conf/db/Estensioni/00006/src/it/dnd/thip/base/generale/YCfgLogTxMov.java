/*
 * @(#)YCfgLogTxMov.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 09/05/2025 at 16:19:40
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 09/05/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.base.generale;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.generale.*;
import com.thera.thermfw.common.*;

public class YCfgLogTxMov extends CfgLogTxMov {

  
  /**
   * Attributo iIdPoliticaRiordino
   */
  protected String iIdPoliticaRiordino;

  
  /**
   * YCfgLogTxMov
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public YCfgLogTxMov() {
  
    // TO DO
  }

  /**
   * Valorizza l'attributo. 
   * @param idPoliticaRiordino
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setIdPoliticaRiordino(String idPoliticaRiordino) {
    this.iIdPoliticaRiordino = idPoliticaRiordino;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public String getIdPoliticaRiordino() {
    return iIdPoliticaRiordino;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
  }

}

