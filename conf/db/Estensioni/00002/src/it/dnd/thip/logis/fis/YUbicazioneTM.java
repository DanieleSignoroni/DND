/*
 * @(#)YUbicazioneTM.java
 */

/**
 * YUbicazioneTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import it.thera.thip.logis.fis.*;
import com.thera.thermfw.base.*;

public class YUbicazioneTM extends UbicazioneTM {

  
  /**
   * Attributo BLOCCATA_AGV
   */
  public static final String BLOCCATA_AGV = "BLOCCATA_AGV";

  /**
   * Attributo GES_BAIA_PRELIEVO
   */
  public static final String GES_BAIA_PRELIEVO = "GES_BAIA_PRELIEVO";

  /**
   * Attributo TIPO_GESTIONE_PERS
   */
  public static final String TIPO_GESTIONE_PERS = "TIPO_GESTIONE_PERS";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YLUBICAZIONE";

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.logis.fis.YUbicazione.class.getName();

  
  /**
   *  YUbicazioneTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YUbicazioneTM() throws SQLException {
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
    addAttributeOnTable("BloccataAgv", BLOCCATA_AGV, TABLE_NAME_EXT);
    addAttributeOnTable("GestioneBaiaPrelievo", GES_BAIA_PRELIEVO, TABLE_NAME_EXT);
    addAttributeOnTable("TipoGestionePers", TIPO_GESTIONE_PERS, TABLE_NAME_EXT);
    
    

  }

}

