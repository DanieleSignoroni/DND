/*
 * @(#)SubscriptionTM.java
 */

/**
 * SubscriptionTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/09/2025 at 09:40:42
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/09/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.toyota.subscription;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class SubscriptionTM extends TableManager {

  
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
   * Attributo ID
   */
  public static final String ID = "ID";

  /**
   * Attributo TS_SUBSCRIPTION
   */
  public static final String TS_SUBSCRIPTION = "TS_SUBSCRIPTION";

  /**
   * Attributo SOURCE_TYPE
   */
  public static final String SOURCE_TYPE = "SOURCE_TYPE";

  /**
   * Attributo ENDPOINT
   */
  public static final String ENDPOINT = "ENDPOINT";

  /**
   * Attributo AUTHENTICATION
   */
  public static final String AUTHENTICATION = "AUTHENTICATION";

  /**
   * Attributo TS_END_SUBSCRIPTION
   */
  public static final String TS_END_SUBSCRIPTION = "TS_END_SUBSCRIPTION";

  /**
   * Attributo TS_SUB_REFRESHED
   */
  public static final String TS_SUB_REFRESHED = "TS_SUB_REFRESHED";

  /**
   * Attributo PASSA_TOYOTA
   */
  public static final String PASSA_TOYOTA = "PASSA_TOYOTA";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("TOYOTA") + "SUBSCRIPTION";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.toyota.subscription.Subscription.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(SubscriptionTM.class);
    }
    return cInstance;
  }

  /**
   *  SubscriptionTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/09/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public SubscriptionTM() throws SQLException {
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
    addAttribute("Id", ID);
    addAttribute("TimestampSubscription", TS_SUBSCRIPTION);
    addAttribute("SourceType", SOURCE_TYPE);
    addAttribute("Endpoint", ENDPOINT);
    addAttribute("Authentication", AUTHENTICATION);
    addAttribute("TsEndSubscription", TS_END_SUBSCRIPTION);
    addAttribute("TsSubRefreshed", TS_SUB_REFRESHED);
    addAttribute("PassaToyota", PASSA_TOYOTA);
    
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
   * 27/09/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID + ", " + TS_SUBSCRIPTION + ", " + SOURCE_TYPE + ", " + ENDPOINT
         + ", " + AUTHENTICATION + ", " + TS_END_SUBSCRIPTION + ", " + TS_SUB_REFRESHED + ", " + PASSA_TOYOTA
         + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG
         + ", " + TIMESTAMP_AGG);
  }

}

