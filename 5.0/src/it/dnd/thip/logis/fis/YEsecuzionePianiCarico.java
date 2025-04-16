package it.dnd.thip.logis.fis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;

import it.dnd.thip.logis.lgb.StatoPrelievoRigaToyota;
import it.dnd.thip.logis.lgb.StatoPrelievoUdcToyota;
import it.dnd.thip.logis.lgb.StatoRigaToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRigaTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.base.azienda.RepartoTM;
import it.thera.thip.logis.fis.MappaUdc;

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
 * 71923    10/04/2025  DSSOF3   Prima stesura
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

	protected Proxy proxyMappaUdc = new Proxy(MappaUdc.class);

	protected Proxy pianoInRiposizionamento = new Proxy(YPianoCaricoToyota.class);

	protected Vector<YPianoCaricoToyotaRiga> elencoRighe = new Vector<YPianoCaricoToyotaRiga>();

	protected YPianoCaricoToyotaRiga rigaPianoCaricoInConferma = null;

	protected Vector elencoBidoneMissioniSaltate = new Vector();
	protected Vector elencoBidoneMissioni = new Vector();

	protected int posMiss = 0;

	protected int numMissConfermate = 0;

	public int getNumMissConfermate() {
		return numMissConfermate;
	}

	public void setNumMissConfermate(int n) {
		numMissConfermate = n;
	}

	public int getPosMiss() {
		return posMiss;
	}

	public void setPosMiss(int p) {
		posMiss = p;
	}

	public YPianoCaricoToyotaRiga getRigaPianoCaricoInConferma() {
		return rigaPianoCaricoInConferma;
	}

	public void setRigaPianoCaricoInConferma(YPianoCaricoToyotaRiga rigaPianoCaricoInConferma) {
		this.rigaPianoCaricoInConferma = rigaPianoCaricoInConferma;
	}

	@SuppressWarnings("rawtypes")
	public Vector getElencoRepartiServitiAgv() {
		return this.elencoRepartiServitiAgv;
	}

	@SuppressWarnings("rawtypes")
	public void setElencoRepartiServitiAgv(Vector elencoRepartiServitiAgv) {
		this.elencoRepartiServitiAgv = elencoRepartiServitiAgv;
	}

	public Vector<YPianoCaricoToyotaRiga> getElencoRighe() {
		return elencoRighe;
	}

	public void setElencoRighe(Vector<YPianoCaricoToyotaRiga> elencoRighe) {
		this.elencoRighe = elencoRighe;
	}

	public void setReparto(Reparto reparto) {
		this.iReparto.setObject(reparto);
	}

	public Vector getElencoBidoneMissioni() {
		return elencoBidoneMissioni;
	}

	public Vector getElencoBidoneMissioniSaltate() {
		return elencoBidoneMissioniSaltate;
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

	public MappaUdc getMappaUdc() {
		return (MappaUdc) proxyMappaUdc.getObject();
	}

	public void setMappaUdc(MappaUdc mu) {
		proxyMappaUdc.setObject(mu);
	}

	public String getCodiceMappaUdc() {
		return proxyMappaUdc.getKey();
	}

	public void setCodiceMappaUdc(String u) {
		proxyMappaUdc.setKey(u);
	}

	public YPianoCaricoToyota getPianoInRiposizionamento() {
		return (YPianoCaricoToyota) pianoInRiposizionamento.getObject();
	}

	public void setPianoInRiposizionamento(YPianoCaricoToyota mu) {
		pianoInRiposizionamento.setObject(mu);
	}

	public String getPianoInRiposizionamentoKey() {
		return pianoInRiposizionamento.getKey();
	}

	public void setPianoInRiposizionamentoKey(String u) {
		pianoInRiposizionamento.setKey(u);
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

	public List<YPianoCaricoToyotaRiga> recuperaRigaPianoCaricoApertaFromNumRitorno(String numeroRitorno) {
		List<YPianoCaricoToyotaRiga> righe = new ArrayList<YPianoCaricoToyotaRiga>();
		ResultSet rs = null;
		try{
			String select = "SELECT "
					+ "	R.* "
					+ "FROM "
					+ "	THIPPERS.YPIANO_CARICO_TOYOTA_RIG R "
					+ "INNER JOIN THIPPERS.YPIANO_CARICO_TOYOTA_TES T "
					+ "ON R.ID_AZIENDA = T.ID_AZIENDA "
					+ "AND R.ID_ANNO_DOC = T.ID_ANNO_DOC "
					+ "AND R.ID_NUMERO_DOC = T.ID_NUMERO_DOC "
					+ "WHERE R.ID_AZIENDA = '"+Azienda.getAziendaCorrente()+"' AND T.STATO_UDC = '"+StatoPrelievoUdcToyota.RICEVUTA+"' "
					+ "AND R.STATO_PRL_RIGA < '"+StatoPrelievoRigaToyota.PRELEVATA+"' "
					+ "AND R.STATO_RIGA = '"+StatoRigaToyota.APERTA+"' AND T.R_REPARTO = '"+getReparto().getIdReparto()+"' ";
			select += "AND R.NUM_RITORNO_ATV = '"+numeroRitorno+"' ";
			if(getMappaUdc() != null) {
				select += "AND R.R_COD_MAPPA_UDC = '"+getMappaUdc().getCodice()+"' ";
			}
			CachedStatement cs = new CachedStatement(select);
			rs = cs.executeQuery();
			if (rs.next()){
				righe.add(YPianoCaricoToyotaRiga.elementWithKey(KeyHelper.buildObjectKey(new String[] {
						rs.getString(YPianoCaricoToyotaRigaTM.ID_AZIENDA),
						rs.getString(YPianoCaricoToyotaRigaTM.ID_ANNO_DOC),
						rs.getString(YPianoCaricoToyotaRigaTM.ID_NUMERO_DOC),
						rs.getString(YPianoCaricoToyotaRigaTM.ID_RIGA_DOC),
				}), PersistentObject.NO_LOCK));
			}
			cs.free();
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
		return righe;
	}

}
