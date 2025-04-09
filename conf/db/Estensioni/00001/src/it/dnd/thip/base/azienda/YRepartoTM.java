/*
 * @(#)YRepartoTM.java
 */

/**
 * YRepartoTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 08/04/2025 at 11:07:03
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 08/04/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.base.azienda;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import it.thera.thip.base.azienda.*;
import com.thera.thermfw.base.*;

public class YRepartoTM extends RepartoTM {

  
  /**
   * Attributo SERVITO_LOGISTICA
   */
  public static final String SERVITO_LOGISTICA = "SERVITO_LOGISTICA";

  /**
   * Attributo BLOCCO_MISSIONI_PRL_AGV
   */
  public static final String BLOCCO_MISSIONI_PRL_AGV = "BLOCCO_MISSIONI_PRL_AGV";

  /**
   * Attributo BLOCCO_MISSIONI_RIPOS_AGV
   */
  public static final String BLOCCO_MISSIONI_RIPOS_AGV = "BLOCCO_MISSIONI_RIPOS_AGV";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YREPARTI";

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.base.azienda.YReparto.class.getName();

  
  /**
   *  YRepartoTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YRepartoTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    super.initialize();
    setObjClassName(CLASS_NAME);
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    linkTable(TABLE_NAME_EXT);
    addAttributeOnTable("ServitoLogistica", SERVITO_LOGISTICA, TABLE_NAME_EXT);
    addAttributeOnTable("BloccoMissioniPrlAgv", BLOCCO_MISSIONI_PRL_AGV, TABLE_NAME_EXT);
    addAttributeOnTable("BloccoMissioniRiposAgv", BLOCCO_MISSIONI_RIPOS_AGV, TABLE_NAME_EXT);
    
    

  }

}

