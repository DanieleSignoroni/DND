/*
 * @(#)YPianoCaricoToyotaRiga.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera s.p.a.</b>
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
import java.sql.*;
import it.thera.thip.produzione.ordese.AttivitaEsecMateriale;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.logis.fis.Missione;
import com.thera.thermfw.common.*;
import com.thera.thermfw.base.*;

public class YPianoCaricoToyotaRiga extends YPianoCaricoToyotaRigaPO {

  
public static final String QUERY_SAVE = "SELECT COALESCE(MAX(ID_RIGA_DOC)+1,1) AS MAXI_VAL FROM THIPPERS.YPIANO_CARICO_TOYOTA_RIG WHERE ID_AZIENDA = ? AND ID_ANNO_DOC = ? AND ID_NUMERO_DOC = ?";

public static CachedStatement querySave = new CachedStatement(QUERY_SAVE);

  
  /**
   * checkDelete
   * @return ErrorMessage
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public ErrorMessage checkDelete() {
    /**@todo*/
    return null;
  }

  /**
   * save
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 08/04/2025    Wizard     Codice generato da Wizard
   *
   */
  public int save() throws SQLException {
    if (!isOnDB()) {
      ResultSet rs = null;
      int value = 1;
      Database db = ConnectionManager.getCurrentDatabase();
      synchronized(querySave){
        PreparedStatement ps = querySave.getStatement();
        db.setString(ps, 1, getIdAzienda());
        db.setString(ps, 2, getAnnoDocumento());
        db.setString(ps, 3, getNumeroDocumento());
        rs = ps.executeQuery();
        if (rs.next())
          value = rs.getInt("MAXI_VAL");
        rs.close();
      setNumeroRigaDocumento(new Integer(value));
      }
    }
    return super.save();
  }

}

