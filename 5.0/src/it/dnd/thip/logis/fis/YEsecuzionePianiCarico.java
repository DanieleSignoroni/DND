package it.dnd.thip.logis.fis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.base.azienda.RepartoTM;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 10/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    10/04/2025  DSSOF3   Prima stesura
 */

public class YEsecuzionePianiCarico {

	public static final String STMT_SELECT_REPARTI_LOGISITCA = "SELECT "
			+ "R.* "
			+ "FROM "
			+ "THIP.REPARTI R "
			+ "INNER JOIN THIPPERS.YREPARTI Y "
			+ "ON R.ID_AZIENDA = Y.ID_AZIENDA "
			+ "AND R.ID_REPARTO = Y.ID_REPARTO "
			+ "WHERE R.ID_AZIENDA = ? "
			+ "AND Y.SERVITO_LOGISTICA = ? "; 
	public static CachedStatement cSelezionaRepartiServitiLogistica = new CachedStatement(STMT_SELECT_REPARTI_LOGISITCA);

	@SuppressWarnings("rawtypes")
	protected Vector elencoRepartiServitiAgv = new Vector();

	protected Proxy iReparto = new Proxy(it.thera.thip.base.azienda.Reparto.class);

	@SuppressWarnings("rawtypes")
	public Vector getElencoRepartiServitiAgv() {
		return this.elencoRepartiServitiAgv;
	}

	@SuppressWarnings("rawtypes")
	public void setElencoRepartiServitiAgv(Vector elencoRepartiServitiAgv) {
		this.elencoRepartiServitiAgv = elencoRepartiServitiAgv;
	}

	public void setReparto(Reparto reparto) {
		this.iReparto.setObject(reparto);
	}

	public Reparto getReparto() {
		return (Reparto) iReparto.getObject();
	}

	public void setRepartoKey(String key) {
		iReparto.setKey(key);
	}

	public String getRepartoKey() {
		return iReparto.getKey();
	}

	public void setIdReparto(String idReparto) {
		String key = iReparto.getKey();
		iReparto.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idReparto));
	}

	@SuppressWarnings("unchecked")
	public void riempiElencoRepartiServitiAgv() {
		ResultSet rs = null;
		try{
			PreparedStatement ps = cSelezionaRepartiServitiLogistica.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, String.valueOf(Column.TRUE_CHAR));
			rs = ps.executeQuery();
			while (rs.next()){
				elencoRepartiServitiAgv.add(Reparto.elementWithKey(Reparto.class, KeyHelper.buildObjectKey(new String[] {
						rs.getString(RepartoTM.ID_AZIENDA),rs.getString(RepartoTM.ID_REPARTO)
				}), PersistentObject.NO_LOCK));
			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}finally{
			try{
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace(Trace.excStream);
			}
		}
	}


}
