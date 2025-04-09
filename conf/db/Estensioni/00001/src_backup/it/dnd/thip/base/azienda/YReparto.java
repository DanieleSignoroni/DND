/*
 * @(#)YReparto.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 08/04/2025 at 10:10:25
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 08/04/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.base.azienda;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;

public class YReparto extends Reparto {

  
  /**
   * Attributo iServitoLogistica
   */
  protected char iServitoLogistica = '0';

  /**
   * Attributo iBloccoMissioniPrlAgv
   */
  protected boolean iBloccoMissioniPrlAgv = false;

  /**
   * Attributo iBloccoMissioniRiposAgv
   */
  protected boolean iBloccoMissioniRiposAgv = false;

  
  /**
   * YReparto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public YReparto() {
    setServitoLogistica('0');
    setBloccoMissioniPrlAgv(false);
    setBloccoMissioniRiposAgv(false);
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param servitoLogistica
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setServitoLogistica(char servitoLogistica) {
    this.iServitoLogistica = servitoLogistica;
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
  public char getServitoLogistica() {
    return iServitoLogistica;
  }

  /**
   * Valorizza l'attributo. 
   * @param bloccoMissioniPrlAgv
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setBloccoMissioniPrlAgv(boolean bloccoMissioniPrlAgv) {
    this.iBloccoMissioniPrlAgv = bloccoMissioniPrlAgv;
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
  public boolean getBloccoMissioniPrlAgv() {
    return iBloccoMissioniPrlAgv;
  }

  /**
   * Valorizza l'attributo. 
   * @param bloccoMissioniRiposAgv
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public void setBloccoMissioniRiposAgv(boolean bloccoMissioniRiposAgv) {
    this.iBloccoMissioniRiposAgv = bloccoMissioniRiposAgv;
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
  public boolean getBloccoMissioniRiposAgv() {
    return iBloccoMissioniRiposAgv;
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

