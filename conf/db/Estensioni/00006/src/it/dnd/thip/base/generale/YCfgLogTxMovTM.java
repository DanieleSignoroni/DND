/*
 * @(#)YCfgLogTxMovTM.java
 */

/**
 * YCfgLogTxMovTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import it.thera.thip.base.generale.*;
import com.thera.thermfw.base.*;

public class YCfgLogTxMovTM extends CfgLogTxMovTM {

  
  /**
   * Attributo R_POLITICA_RIORDINO
   */
  public static final String R_POLITICA_RIORDINO = "R_POLITICA_RIORDINO";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YCFG_LOG_TX_MOV";

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.base.generale.YCfgLogTxMov.class.getName();

  
  /**
   *  YCfgLogTxMovTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YCfgLogTxMovTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 09/05/2025    CodeGen     Codice generato da CodeGenerator
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
   * 09/05/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    linkTable(TABLE_NAME_EXT);
    addAttributeOnTable("IdPoliticaRiordino", R_POLITICA_RIORDINO, TABLE_NAME_EXT);
    
    

  }

}

