/*
 * @(#)YPianoCaricoToyotaRigaTM.java
 */

/**
 * YPianoCaricoToyotaRigaTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 08/04/2025 at 12:22:55
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 08/04/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.logis.lgb;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YPianoCaricoToyotaRigaTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo ID_ANNO_DOC
   */
  public static final String ID_ANNO_DOC = "ID_ANNO_DOC";

  /**
   * Attributo ID_NUMERO_DOC
   */
  public static final String ID_NUMERO_DOC = "ID_NUMERO_DOC";

  /**
   * Attributo ID_RIGA_DOC
   */
  public static final String ID_RIGA_DOC = "ID_RIGA_DOC";

  /**
   * Attributo R_ARTICOLO
   */
  public static final String R_ARTICOLO = "R_ARTICOLO";

  /**
   * Attributo ID_ANNO_ORDINE_RIGA_MAT
   */
  public static final String ID_ANNO_ORDINE_RIGA_MAT = "ID_ANNO_ORDINE_RIGA_MAT";

  /**
   * Attributo ID_NUMERO_ORD_RIGA_MAT
   */
  public static final String ID_NUMERO_ORD_RIGA_MAT = "ID_NUMERO_ORD_RIGA_MAT";

  /**
   * Attributo ID_RIGA_ATTIVITA_RIGA_MAT
   */
  public static final String ID_RIGA_ATTIVITA_RIGA_MAT = "ID_RIGA_ATTIVITA_RIGA_MAT";

  /**
   * Attributo ID_RIGA_MATERIALE
   */
  public static final String ID_RIGA_MATERIALE = "ID_RIGA_MATERIALE";

  /**
   * Attributo R_COD_MAG_FISICO_MISS
   */
  public static final String R_COD_MAG_FISICO_MISS = "R_COD_MAG_FISICO_MISS";

  /**
   * Attributo R_CODICE_MISSIONE
   */
  public static final String R_CODICE_MISSIONE = "R_CODICE_MISSIONE";

  /**
   * Attributo NUM_RITORNO_ATV
   */
  public static final String NUM_RITORNO_ATV = "NUM_RITORNO_ATV";

  /**
   * Attributo R_CLIENTE
   */
  public static final String R_CLIENTE = "R_CLIENTE";

  /**
   * Attributo NUM_RIFERIMENTO
   */
  public static final String NUM_RIFERIMENTO = "NUM_RIFERIMENTO";

  /**
   * Attributo QTA_RCS_UM_PRM
   */
  public static final String QTA_RCS_UM_PRM = "QTA_RCS_UM_PRM";

  /**
   * Attributo QTA_RCS_UM_SEC
   */
  public static final String QTA_RCS_UM_SEC = "QTA_RCS_UM_SEC";

  /**
   * Attributo QTA_PREL_UM_PRM
   */
  public static final String QTA_PREL_UM_PRM = "QTA_PREL_UM_PRM";

  /**
   * Attributo QTA_PREL_UM_SEC
   */
  public static final String QTA_PREL_UM_SEC = "QTA_PREL_UM_SEC";

  /**
   * Attributo PRIORITA
   */
  public static final String PRIORITA = "PRIORITA";

  /**
   * Attributo PRELEVABILE
   */
  public static final String PRELEVABILE = "PRELEVABILE";

  /**
   * Attributo STATO_PRL_RIGA
   */
  public static final String STATO_PRL_RIGA = "STATO_PRL_RIGA";

  /**
   * Attributo STATO_RIGA
   */
  public static final String STATO_RIGA = "STATO_RIGA";

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
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YPIANO_CARICO_TOYOTA_RIG";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YPianoCaricoToyotaRigaTM.class);
    }
    return cInstance;
  }

  /**
   *  YPianoCaricoToyotaRigaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YPianoCaricoToyotaRigaTM() throws SQLException {
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
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("NumeroRigaDocumento", ID_RIGA_DOC, "getIntegerObject");
    addAttribute("NumRitornoAttivita", NUM_RITORNO_ATV);
    addAttribute("NumeroRiferimento", NUM_RIFERIMENTO);
    addAttribute("QuantitaRichiestaUmPrm", QTA_RCS_UM_PRM);
    addAttribute("QuantitaRichiestaUmSec", QTA_RCS_UM_SEC);
    addAttribute("QuantitaPrelevataUmPrm", QTA_PREL_UM_PRM);
    addAttribute("QuantitaPrelevataUmSec", QTA_PREL_UM_SEC);
    addAttribute("Priorita", PRIORITA);
    addAttribute("Prelevabile", PRELEVABILE);
    addAttribute("StatoPrelievo", STATO_PRL_RIGA);
    addAttribute("StatoRiga", STATO_RIGA);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdAnnoOrdineRigaMat", ID_ANNO_ORDINE_RIGA_MAT);
    addAttribute("IdNumeroOrdRigaMat", ID_NUMERO_ORD_RIGA_MAT);
    addAttribute("IdRigaAttivitaRigaMat", ID_RIGA_ATTIVITA_RIGA_MAT, "getIntegerObject");
    addAttribute("IdRigaMateriale", ID_RIGA_MATERIALE, "getIntegerObject");
    addAttribute("IdArticolo", R_ARTICOLO);
    addAttribute("IdCliente", R_CLIENTE);
    addAttribute("AnnoDocumento", ID_ANNO_DOC);
    addAttribute("NumeroDocumento", ID_NUMERO_DOC);
    addAttribute("IdCodMagFisicoMissione", R_COD_MAG_FISICO_MISS);
    addAttribute("IdCodiceMissione", R_CODICE_MISSIONE, "getIntegerObject");
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_ANNO_DOC + "," + ID_NUMERO_DOC + "," + ID_RIGA_DOC);

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
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID_RIGA_DOC + ", " + NUM_RITORNO_ATV + ", " + NUM_RIFERIMENTO + ", " + QTA_RCS_UM_PRM
         + ", " + QTA_RCS_UM_SEC + ", " + QTA_PREL_UM_PRM + ", " + QTA_PREL_UM_SEC + ", " + PRIORITA
         + ", " + PRELEVABILE + ", " + STATO_PRL_RIGA + ", " + STATO_RIGA + ", " + ID_AZIENDA
         + ", " + ID_ANNO_ORDINE_RIGA_MAT + ", " + ID_NUMERO_ORD_RIGA_MAT + ", " + ID_RIGA_ATTIVITA_RIGA_MAT + ", " + ID_RIGA_MATERIALE
         + ", " + R_ARTICOLO + ", " + R_CLIENTE + ", " + ID_ANNO_DOC + ", " + ID_NUMERO_DOC
         + ", " + R_COD_MAG_FISICO_MISS + ", " + R_CODICE_MISSIONE + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

