package it.dnd.thip.logis.fis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRigaTM;
import it.thera.thip.logis.fis.EsecuzioneMissioni;
import it.thera.thip.logis.fis.MissioneTM;
import it.thera.thip.logis.lgb.TestataLista;
import it.thera.thip.logis.lgb.TestataListaTM;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 15/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    15/04/2025  DSSOF3   Prima stesura, rimuovere dalle liste standard quelle relative al carico toyota
 */

public class YEsecuzioneMissioni extends EsecuzioneMissioni {

	public static final String AND_EXCLUDE_PIANI_CARICO_TOYOTA = "AND NOT EXISTS ( "
			+ "			SELECT 1 FROM "+YPianoCaricoToyotaRigaTM.TABLE_NAME+" P "
			+ "			INNER JOIN "+MissioneTM.NOME_TABELLA+" M "
			+ "			ON P."+YPianoCaricoToyotaRigaTM.R_CODICE_MISSIONE+" = M."+MissioneTM.CODICE+" "
			+ "			WHERE TRIM(M."+MissioneTM.COD_LISTA+") = TL."+TestataListaTM.CODICE+" "
			+ "		)";

	@SuppressWarnings("unchecked")
	@Override
	public void riempiElencoTestate(boolean pianificazione) {
		//super.riempiElencoTestate(pianificazione);
		elencoTutteTestate.removeAllElements();
		elencoTestate.removeAllElements();
		elencoMissioni.removeAllElements();
		elencoMissioniDB.removeAllElements();
		elencoMissioniSuMancante.removeAllElements();
		ResultSet rs = null;
		CachedStatement cs = null;
		ArrayList<String> keys = new ArrayList<String>();
		try {
			String select = "SELECT TL."+TestataListaTM.CODICE_SOCIETA+",TL."+TestataListaTM.CODICE+" FROM "+TestataListaTM.NOME_TABELLA+" TL ";
			String where = "WHERE " + whereRiempiElencoTestate(pianificazione);
			where+= AND_EXCLUDE_PIANI_CARICO_TOYOTA;
			String orderBy = " ORDER BY " + orderByRiempiElencoTestate();
			cs = new CachedStatement(select+where+orderBy);
			rs = cs.executeQuery();
			while(rs.next()) {
				keys.add(KeyHelper.buildObjectKey(new String[] {
						rs.getString(TestataListaTM.CODICE_SOCIETA).trim(),
						rs.getString(TestataListaTM.CODICE).trim()
				}));
			}
		} catch(SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}finally {
			if(rs != null) {
				try {
					rs.close();
					cs.free();
				} catch (SQLException e) {
					e.printStackTrace(Trace.excStream);
				}
			}
		}
		int dim = keys.size();
		for(int i = 0; i < dim; i++) {
			TestataLista tl;
			try {
				tl = (TestataLista) TestataLista.elementWithKey(keys.get(i), PersistentObject.NO_LOCK);
				if (!pianificazione &&
						filtraListeInLavorazione &&
						tl.isInLavorazione(getAreaLavoro()))
					continue;
				tl.setIndice(i);
				elencoTutteTestate.addElement(tl);
			} catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}
	}
}
