/*
 * @(#)YPianoCaricoToyotaTM.java
 */

/**
 * YPianoCaricoToyotaTM
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

public class YPianoCaricoToyotaTM extends TableManager {

  
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
   * Attributo ID_ANNO_DOC
   */
  public static final String ID_ANNO_DOC = "ID_ANNO_DOC";

  /**
   * Attributo ID_NUMERO_DOC
   */
  public static final String ID_NUMERO_DOC = "ID_NUMERO_DOC";

  /**
   * Attributo DATA_DOC
   */
  public static final String DATA_DOC = "DATA_DOC";

  /**
   * Attributo R_COD_UBICAZIONE_STOCK
   */
  public static final String R_COD_UBICAZIONE_STOCK = "R_COD_UBICAZIONE_STOCK";

  /**
   * Attributo R_MAG_FISICO_STOCK
   */
  public static final String R_MAG_FISICO_STOCK = "R_MAG_FISICO_STOCK";

  /**
   * Attributo R_COD_UBICAZIONE_PRL
   */
  public static final String R_COD_UBICAZIONE_PRL = "R_COD_UBICAZIONE_PRL";

  /**
   * Attributo R_MAG_FISICO_PRL
   */
  public static final String R_MAG_FISICO_PRL = "R_MAG_FISICO_PRL";

  /**
   * Attributo STATO_UDC
   */
  public static final String STATO_UDC = "STATO_UDC";

  /**
   * Attributo R_COD_MAPPA_UDC
   */
  public static final String R_COD_MAPPA_UDC = "R_COD_MAPPA_UDC";

  /**
   * Attributo ID_ANNO_ORDINE
   */
  public static final String ID_ANNO_ORDINE = "ID_ANNO_ORDINE";

  /**
   * Attributo ID_NUMERO_ORD
   */
  public static final String ID_NUMERO_ORD = "ID_NUMERO_ORD";

  /**
   * Attributo ID_RIGA_ATTIVITA
   */
  public static final String ID_RIGA_ATTIVITA = "ID_RIGA_ATTIVITA";

  /**
   * Attributo R_REPARTO
   */
  public static final String R_REPARTO = "R_REPARTO";

  /**
   * Attributo STATO_GESTIONE
   */
  public static final String STATO_GESTIONE = "STATO_GESTIONE";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YPIANO_CARICO_TOYOTA_TES";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.logis.lgb.YPianoCaricoToyota.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(YPianoCaricoToyotaTM.class);
    }
    return cInstance;
  }

  /**
   *  YPianoCaricoToyotaTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YPianoCaricoToyotaTM() throws SQLException {
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
    addAttribute("AnnoDocumento", ID_ANNO_DOC);
    addAttribute("NumeroDocumento", ID_NUMERO_DOC);
    addAttribute("DataDocumento", DATA_DOC);
    addAttribute("StatoUdc", STATO_UDC);
    addAttribute("StatoGestione", STATO_GESTIONE);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdAnnoOrdine", ID_ANNO_ORDINE);
    addAttribute("IdNumeroOrdine", ID_NUMERO_ORD);
    addAttribute("IdRigaAttivita", ID_RIGA_ATTIVITA, "getIntegerObject");
    addAttribute("IdReparto", R_REPARTO);
    addAttribute("IdCodiceUbicazioneStock", R_COD_UBICAZIONE_STOCK);
    addAttribute("IdMagazzinoFisicoStock", R_MAG_FISICO_STOCK);
    addAttribute("IdCodUbicazionePrelievo", R_COD_UBICAZIONE_PRL);
    addAttribute("IdMagazzinoFisicoPrelievo", R_MAG_FISICO_PRL);
    addAttribute("IdCodiceUdc", R_COD_MAPPA_UDC);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_ANNO_DOC + "," + ID_NUMERO_DOC);

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
    configure(ID_ANNO_DOC + ", " + ID_NUMERO_DOC + ", " + DATA_DOC + ", " + STATO_UDC
         + ", " + STATO_GESTIONE + ", " + ID_AZIENDA + ", " + ID_ANNO_ORDINE + ", " + ID_NUMERO_ORD
         + ", " + ID_RIGA_ATTIVITA + ", " + R_REPARTO + ", " + R_COD_UBICAZIONE_STOCK + ", " + R_MAG_FISICO_STOCK
         + ", " + R_COD_UBICAZIONE_PRL + ", " + R_MAG_FISICO_PRL + ", " + R_COD_MAPPA_UDC + ", " + STATO
         + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG
        );
  }

}

