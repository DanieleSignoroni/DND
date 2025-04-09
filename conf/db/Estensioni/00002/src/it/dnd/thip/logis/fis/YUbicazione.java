/*
 * @(#)YUbicazione.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 08/04/2025 at 10:15:42
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 08/04/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.logis.fis;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.logis.fis.*;
import com.thera.thermfw.common.*;

public class YUbicazione extends Ubicazione {

  
  /**
   * Attributo iBloccataAgv
   */
  protected boolean iBloccataAgv = false;

  /**
   * Attributo iGestioneBaiaPrelievo
   */
  protected boolean iGestioneBaiaPrelievo = false;

  /**
   * Attributo iTipoGestionePers
   */
  protected char iTipoGestionePers = 'O';

  
  /**
   * YUbicazione
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public YUbicazione() {
    setBloccataAgv(false);
    setGestioneBaiaPrelievo(false);
    setTipoGestionePers('O');
  }

  /**
   * Valorizza l'attributo. 
   * @param bloccataAgv
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setBloccataAgv(boolean bloccataAgv) {
    this.iBloccataAgv = bloccataAgv;
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
  public boolean getBloccataAgv() {
    return iBloccataAgv;
  }

  /**
   * Valorizza l'attributo. 
   * @param gestioneBaiaPrelievo
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setGestioneBaiaPrelievo(boolean gestioneBaiaPrelievo) {
    this.iGestioneBaiaPrelievo = gestioneBaiaPrelievo;
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
  public boolean getGestioneBaiaPrelievo() {
    return iGestioneBaiaPrelievo;
  }

  /**
   * Valorizza l'attributo. 
   * @param tipoGestionePers
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setTipoGestionePers(char tipoGestionePers) {
    this.iTipoGestionePers = tipoGestionePers;
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
  public char getTipoGestionePers() {
    return iTipoGestionePers;
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
  }

}

