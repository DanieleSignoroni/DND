/*
 * @(#)YGestioneUdsPickingProdTM.java
 */

/**
 * YGestioneUdsPickingProdTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 02/05/2025 at 12:34:18
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 02/05/2025    Wizard     Codice generato da Wizard
 *
 */
package it.dnd.thip.produzione.ordese;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YGestioneUdsPickingProdTM extends TableManager {

  
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
   * Attributo NUMERO_RITORNO
   */
  public static final String NUMERO_RITORNO = "NUMERO_RITORNO";

  /**
   * Attributo R_UDS
   */
  public static final String R_UDS = "R_UDS";

  /**
   * Attributo R_COD_LISTA
   */
  public static final String R_COD_LISTA = "R_COD_LISTA";

  /**
   * Attributo R_COD_RIGA_LISTA
   */
  public static final String R_COD_RIGA_LISTA = "R_COD_RIGA_LISTA";

  /**
   * Attributo R_TIPO_UDS
   */
  public static final String R_TIPO_UDS = "R_TIPO_UDS";

  /**
   * Attributo QUANTITA
   */
  public static final String QUANTITA = "QUANTITA";

  /**
   * Attributo STATO_UDS
   */
  public static final String STATO_UDS = "STATO_UDS";

  /**
   * Attributo TRASMESSO_LINEA
   */
  public static final String TRASMESSO_LINEA = "TRASMESSO_LINEA";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YGESTIONE_UDS_PICKING_PROD";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YGestioneUdsPickingProdTM.class);
    }
    return cInstance;
  }

  /**
   *  YGestioneUdsPickingProdTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/05/2025    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YGestioneUdsPickingProdTM() throws SQLException {
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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("NumeroRitorno", NUMERO_RITORNO);
    addAttribute("IdCodiceLista", R_COD_LISTA);
    addAttribute("IdCodiceRigaLista", R_COD_RIGA_LISTA, "getIntegerObject");
    addAttribute("Quantita", QUANTITA);
    addAttribute("StatoUds", STATO_UDS);
    addAttribute("TrasmessoLinea", TRASMESSO_LINEA);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdUds", R_UDS);
    addAttribute("IdTipoUds", R_TIPO_UDS);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + NUMERO_RITORNO + "," + R_UDS);

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
   * 02/05/2025    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(NUMERO_RITORNO + ", " + R_COD_LISTA + ", " + R_COD_RIGA_LISTA + ", " + QUANTITA
         + ", " + STATO_UDS + ", " + TRASMESSO_LINEA + ", " + ID_AZIENDA + ", " + R_UDS
         + ", " + R_TIPO_UDS + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ
         + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

