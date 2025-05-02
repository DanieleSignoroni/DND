/*
 * @(#)YArticoloClienteTM.java
 */

/**
 * YArticoloClienteTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import it.thera.thip.base.articolo.*;
import com.thera.thermfw.base.*;

public class YArticoloClienteTM extends ArticoloClienteTM {

  
  /**
   * Attributo NR_PEZZI_BAULETTO
   */
  public static final String NR_PEZZI_BAULETTO = "NR_PEZZI_BAULETTO";

  /**
   * Attributo NR_PEZZI_UDS
   */
  public static final String NR_PEZZI_UDS = "NR_PEZZI_UDS";

  /**
   * Attributo R_TIPO_UDS
   */
  public static final String R_TIPO_UDS = "R_TIPO_UDS";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YARTICOLI_CLI";

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.base.articolo.YArticoloCliente.class.getName();

  
  /**
   *  YArticoloClienteTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YArticoloClienteTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    linkTable(TABLE_NAME_EXT);
    addAttributeOnTable("NrPezziBauletto", NR_PEZZI_BAULETTO, "getIntegerObject", TABLE_NAME_EXT);
    addAttributeOnTable("NrPezziUds", NR_PEZZI_UDS, "getIntegerObject", TABLE_NAME_EXT);
    addAttributeOnTable("IdTipoUDS", R_TIPO_UDS, TABLE_NAME_EXT);
    
    

  }

}

