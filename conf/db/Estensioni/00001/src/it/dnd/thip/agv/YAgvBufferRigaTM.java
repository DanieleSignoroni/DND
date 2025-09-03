/*
 * @(#)YAgvBufferRigaTM.java
 */

/**
 * YAgvBufferRigaTM
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

public class YAgvBufferRigaTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo ID_BUFFER
   */
  public static final String ID_BUFFER = "ID_BUFFER";

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
   * Attributo ID_RIGA_BUFFER
   */
  public static final String ID_RIGA_BUFFER = "ID_RIGA_BUFFER";

  /**
   * Attributo R_ANNO_PC_TOYOTA
   */
  public static final String R_ANNO_PC_TOYOTA = "R_ANNO_PC_TOYOTA";

  /**
   * Attributo R_NUMERO_PC_TOYOTA
   */
  public static final String R_NUMERO_PC_TOYOTA = "R_NUMERO_PC_TOYOTA";

  /**
   * Attributo R_RIGA_PC_TOYOTA
   */
  public static final String R_RIGA_PC_TOYOTA = "R_RIGA_PC_TOYOTA";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YAGV_BUFFER_RIG";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.agv.YAgvBufferRiga.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(YAgvBufferRigaTM.class);
    }
    return cInstance;
  }

  /**
   *  YAgvBufferRigaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 03/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YAgvBufferRigaTM() throws SQLException {
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
    addAttribute("IdRigaBuffer", ID_RIGA_BUFFER, "getIntegerObject");
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdAnnoPcToyota", R_ANNO_PC_TOYOTA);
    addAttribute("IdNumeroPcToyota", R_NUMERO_PC_TOYOTA);
    addAttribute("IdRigaPcToyota", R_RIGA_PC_TOYOTA, "getIntegerObject");
    addAttribute("IdBuffer", ID_BUFFER, "getIntegerObject");
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_BUFFER + "," + ID_RIGA_BUFFER);

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
    configure(ID_RIGA_BUFFER + ", " + ID_AZIENDA + ", " + R_ANNO_PC_TOYOTA + ", " + R_NUMERO_PC_TOYOTA
         + ", " + R_RIGA_PC_TOYOTA + ", " + ID_BUFFER + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

