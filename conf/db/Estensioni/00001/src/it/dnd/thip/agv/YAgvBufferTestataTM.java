/*
 * @(#)YAgvBufferTestataTM.java
 */

/**
 * YAgvBufferTestataTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 03/09/2025 at 10:09:19
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 03/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.agv;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YAgvBufferTestataTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo STATO
   */
  public static final String STATO = "STATO";

  /**
   * Attributo R_UTENTE_CRZ
   */
  public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

  /**
   * Attributo TIMESTAMP_CRZ
   */
  public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

  /**
   * Attributo R_UTENTE_AGG
   */
  public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

  /**
   * Attributo TIMESTAMP_AGG
   */
  public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

  /**
   * Attributo ID_BUFFER
   */
  public static final String ID_BUFFER = "ID_BUFFER";

  /**
   * Attributo STATO_BUFFER
   */
  public static final String STATO_BUFFER = "STATO_BUFFER";

  /**
   * Attributo R_REPARTO_1
   */
  public static final String R_REPARTO_1 = "R_REPARTO_1";

  /**
   * Attributo R_REPARTO_2
   */
  public static final String R_REPARTO_2 = "R_REPARTO_2";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YAGV_BUFFER_TES";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.agv.YAgvBufferTestata.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YAgvBufferTestataTM.class);
    }
    return cInstance;
  }

  /**
   *  YAgvBufferTestataTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YAgvBufferTestataTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    setTableName(TABLE_NAME);
    setObjClassName(CLASS_NAME);
    init();
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("IdBuffer", ID_BUFFER, "getIntegerObject");
    addAttribute("StatoBuffer", STATO_BUFFER);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdReparto1", R_REPARTO_1);
    addAttribute("IdReparto2", R_REPARTO_2);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_BUFFER);

    setTimestampColumn("TIMESTAMP_AGG");
    ((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
  }

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID_BUFFER + ", " + STATO_BUFFER + ", " + ID_AZIENDA + ", " + R_REPARTO_1
         + ", " + R_REPARTO_2 + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ
         + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

