/*
 * @(#)PsnDatiToyotaTM.java
 */

/**
 * PsnDatiToyotaTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/09/2025 at 09:25:05
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class PsnDatiToyotaTM extends TableManager {

  
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
   * Attributo CLIENT_ID_PANTH01
   */
  public static final String CLIENT_ID_PANTH01 = "CLIENT_ID_PANTH01";

  /**
   * Attributo CLIENT_SECRET_PANTH01
   */
  public static final String CLIENT_SECRET_PANTH01 = "CLIENT_SECRET_PANTH01";

  /**
   * Attributo URL_PANTH01
   */
  public static final String URL_PANTH01 = "URL_PANTH01";

  /**
   * Attributo CLIENT_ID_PANTH02
   */
  public static final String CLIENT_ID_PANTH02 = "CLIENT_ID_PANTH02";

  /**
   * Attributo CLIENT_SECRET_PANTH02
   */
  public static final String CLIENT_SECRET_PANTH02 = "CLIENT_SECRET_PANTH02";

  /**
   * Attributo URL_PANTH02
   */
  public static final String URL_PANTH02 = "URL_PANTH02";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "PSN_DATI_TOYOTA";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.toyota.PsnDatiToyota.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(PsnDatiToyotaTM.class);
    }
    return cInstance;
  }

  /**
   *  PsnDatiToyotaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public PsnDatiToyotaTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("ClientIdPanth01", CLIENT_ID_PANTH01);
    addAttribute("ClientSecretPanth01", CLIENT_SECRET_PANTH01);
    addAttribute("UrlPanth01", URL_PANTH01);
    addAttribute("ClientIdPanth02", CLIENT_ID_PANTH02);
    addAttribute("ClientSecretPanth02", CLIENT_SECRET_PANTH02);
    addAttribute("UrlPanth02", URL_PANTH02);
    addAttribute("IdAzienda", ID_AZIENDA);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA);

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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(CLIENT_ID_PANTH01 + ", " + CLIENT_SECRET_PANTH01 + ", " + URL_PANTH01 + ", " + CLIENT_ID_PANTH02
         + ", " + CLIENT_SECRET_PANTH02 + ", " + URL_PANTH02 + ", " + ID_AZIENDA + ", " + STATO
         + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG
        );
  }

}

