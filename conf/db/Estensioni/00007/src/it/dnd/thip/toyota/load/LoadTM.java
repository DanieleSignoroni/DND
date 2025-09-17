/*
 * @(#)LoadTM.java
 */

/**
 * LoadTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 17/09/2025 at 11:55:01
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 17/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota.load;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class LoadTM extends TableManager {

  
  /**
   * Attributo ID
   */
  public static final String ID = "ID";

  /**
   * Attributo DATA
   */
  public static final String DATA = "DATA";

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
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("TOYOTA") + "LOAD";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.toyota.load.Load.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(LoadTM.class);
    }
    return cInstance;
  }

  /**
   *  LoadTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public LoadTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 17/09/2025    CodeGen     Codice generato da CodeGenerator
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
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("Id", ID);
    addAttribute("Data", DATA);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID);

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
   * 17/09/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID + ", " + DATA + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

