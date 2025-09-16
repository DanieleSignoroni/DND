package it.dnd.thip.agv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.dnd.thip.base.azienda.YReparto;
import it.dnd.thip.logis.lgb.StatoPrelievoUdcToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaTM;
import it.thera.thip.base.azienda.Azienda;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 03/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    03/09/2025  DSSOF3   Prima stesura
 */

public class YSchedulazioneBufferAgv extends BatchRunnable implements Authorizable, Conflictable {

	public static final String RES = "it.dnd.thip.agv.resources.YSchedulazioneBufferAgv";

	protected static final String SELECT_PIANI_CARICO_NON_SCHEDUL =
			"SELECT "
					+ "	* "
					+ "FROM "
					+ "	THIPPERS.YPIANO_CARICO_TOYOTA_TES PCT "
					+ "WHERE PCT.ID_AZIENDA = ? "
					+ "AND PCT.STATO_UDC IN ('"+StatoPrelievoUdcToyota.STATO_INIZIALE+"','"+StatoPrelievoUdcToyota.PRONTA_PER_REINTEGRO+"') "
					+ "AND EXISTS ( "
					+ "        SELECT 1 "
					+ "        FROM THIPPERS.YAGV_BUFFER_TES A "
					+ "        WHERE A.ID_AZIENDA = PCT.ID_AZIENDA "
					+ "          AND (PCT.R_REPARTO = A.R_REPARTO_1 OR PCT.R_REPARTO = A.R_REPARTO_2) "
					+ "    )";
	protected static CachedStatement cSelectPianiCaricoNonSchedul = new CachedStatement(SELECT_PIANI_CARICO_NON_SCHEDUL);

	protected String iIdAzienda;
	protected String iScheduledJobId;

	public YSchedulazioneBufferAgv() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdAzienda(String idAzienda){
		iIdAzienda = idAzienda;
	}

	public String getIdAzienda(){
		return iIdAzienda;
	}

	@Override
	protected boolean run() {
		boolean isOk = true;
		try {
			isOk = popolazioneBuffer();
		}catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		return isOk;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean popolazioneBuffer() throws SQLException {
		//..Sono 7 ma per sicurezza lo metto in un properties
		Integer numeroBuffer = Integer.valueOf(ResourceLoader.getString(RES, "NumeroBuffer"));

		List pianiCaricoDaSchedulare = selectPianiCaricoNonSchedulati(getIdAzienda());
		if(pianiCaricoDaSchedulare.size() == 0) {
			output.println("Nessun piano di carico da schedulare");
			return true;
		}

		//..Scorro i buffer per popolarli con le missioni
		for(int i = 0 ; i < numeroBuffer.intValue(); i++) {
			try {
				String c = KeyHelper.buildObjectKey(new String[] { getIdAzienda(),String.valueOf(i)});
				YAgvBufferTestata bufferX = YAgvBufferTestata.elementWithKey(c, PersistentObject.OPTIMISTIC_LOCK);
				if(bufferX != null) {

					//..Forzo l'apertura del buffer e la pulizia di eventuali righe
					bufferX.setStatoBuffer(YAgvBufferTestata.SPENTO);
					if(bufferX.getYAgvBufferRiga().size() > 0) {
						bufferX.getYAgvBufferRiga().clear();
					}
					int rcSave = bufferX.save();
					if(rcSave > 0) {
						ConnectionManager.commit();
					}else {
						output.print("Buffer ["+c+"] impossibile salvare dopo aver spento e pulito le righe, rc ="+rcSave);
						ConnectionManager.rollback();
						return false;
					}

					//.Aggiorno da db
					bufferX.retrieve();

					YReparto reparto1 = (YReparto) bufferX.getReparto1();
					YReparto reparto2 = (YReparto) bufferX.getReparto2();

					char logicaMissioniR1 = reparto1.getLogicaMissioniToyota();
					char logicaMissioniR2 = reparto2.getLogicaMissioniToyota();

					List<YPianoCaricoToyota> pianiR1 = trovaPianiCaricoLogicaReparto(pianiCaricoDaSchedulare,reparto1,logicaMissioniR1);
					for (Iterator iterator = pianiR1.iterator(); iterator.hasNext();) {
						YPianoCaricoToyota piano = (YPianoCaricoToyota) iterator.next();
						if(piano != null) {
							YAgvBufferRiga riga = rigaAgv(bufferX, c, piano);

							bufferX.getYAgvBufferRiga().add(riga);
						}
					}

					List<YPianoCaricoToyota> pianiR2 = trovaPianiCaricoLogicaReparto(pianiCaricoDaSchedulare,reparto2,logicaMissioniR2);
					for (Iterator iterator = pianiR2.iterator(); iterator.hasNext();) {
						YPianoCaricoToyota piano = (YPianoCaricoToyota) iterator.next();
						if(piano != null) {
							YAgvBufferRiga riga = rigaAgv(bufferX, c, piano);

							bufferX.getYAgvBufferRiga().add(riga);
						}
					}

					rcSave = bufferX.save();
					if(rcSave > 0) {
						ConnectionManager.commit();
					}else {
						output.print("Buffer ["+c+"] impossibile salvare dopo aver spento e pulito le righe, rc ="+rcSave);
						ConnectionManager.rollback();
						return false;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}

		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<YPianoCaricoToyota> trovaPianiCaricoLogicaReparto(
			List pianiCaricoDaSchedulare, 
			YReparto reparto,
			char logicaMissioni) throws SQLException {

		List<YPianoCaricoToyota> result = new ArrayList<>(2);
		if (pianiCaricoDaSchedulare == null || pianiCaricoDaSchedulare.isEmpty()) {
			return result; // lista vuota
		}

		Iterator<String> it = pianiCaricoDaSchedulare.iterator();

		switch (logicaMissioni) {
		case LogicaMissioniToyota.PRELIEVO_RIPRISTINO: {
			YPianoCaricoToyota iniziale = null;
			YPianoCaricoToyota reintegro = null;

			while (it.hasNext() && (iniziale == null || reintegro == null)) {
				YPianoCaricoToyota pct = YPianoCaricoToyota.elementWithKey(it.next(), PersistentObject.NO_LOCK);
				if (!matchesReparto(pct, reparto)) continue;

				if (iniziale == null 
						&& pct.getStatoUdc() == StatoPrelievoUdcToyota.STATO_INIZIALE) {
					iniziale = pct;
					it.remove(); // rimuovi dalla lista di schedulazione
					continue;
				}

				if (reintegro == null 
						&& pct.getStatoUdc() == StatoPrelievoUdcToyota.PRONTA_PER_REINTEGRO) {
					reintegro = pct;
					it.remove();
				}
			}

			if (iniziale != null) result.add(iniziale);
			if (reintegro != null && result.size() < 2) result.add(reintegro);
			break;
		}

		case LogicaMissioniToyota.FIFO: {
			while (it.hasNext() && result.size() < 2) {
				YPianoCaricoToyota pct = YPianoCaricoToyota.elementWithKey(it.next(), PersistentObject.NO_LOCK);
				if (!matchesReparto(pct, reparto)) continue;

				if (pct.getStatoUdc() == StatoPrelievoUdcToyota.STATO_INIZIALE) {
					result.add(pct);
					it.remove(); // rimuovi appena selezionato
				}
			}
			break;
		}

		default:
			// logica non riconosciuta -> ritorna lista vuota (o lancia eccezione, se preferisci)
			break;
		}

		return result;
	}


	private boolean matchesReparto(YPianoCaricoToyota pct, YReparto reparto) {
		if (reparto == null) return true;
		try {
			return pct.getIdReparto().equals(reparto.getIdReparto());
		} catch (Exception e) {
			return true;
		}
	}

	public static YAgvBufferRiga rigaAgv(YAgvBufferTestata bufferT, String idAzienda, YPianoCaricoToyota pianoCaricoT) {
		YAgvBufferRiga riga = (YAgvBufferRiga) Factory.createObject(YAgvBufferRiga.class);
		riga.setFather(bufferT);
		riga.setIdAzienda(idAzienda);
		riga.setPianoCaricoToyota(pianoCaricoT);
		return riga;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List selectPianiCaricoNonSchedulati(String aziendaCorrente) throws SQLException {
		ArrayList ret = new ArrayList();
		Database db = ConnectionManager.getCurrentDatabase();
		PreparedStatement ps = cSelectPianiCaricoNonSchedul.getStatement();
		db.setString(ps, 1, aziendaCorrente);
		ResultSet rs = ps.executeQuery();
		String key = null;
		while (rs.next()){
			String idAnnoDocumento = Column.rightTrim(rs.getString(YPianoCaricoToyotaTM.ID_ANNO_DOC));
			String idNumeroDocumento = Column.rightTrim(rs.getString(YPianoCaricoToyotaTM.ID_NUMERO_DOC));
			Object[] keyParts = {aziendaCorrente, idAnnoDocumento, idNumeroDocumento};
			key = KeyHelper.buildObjectKey(keyParts);
			ret.add(key);
		}
		rs.close();
		return ret;
	}

	@Override
	protected String getClassAdCollectionName() {
		return "YSchedulazioneBufferAgv";
	}

}