package it.dnd.thip.produzione.raccoltaDati;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.dnd.thip.base.articolo.YArticolo;
import it.dnd.thip.base.articolo.YArticoloCliente;
import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProdTM;
import it.thera.thip.base.articolo.ArticoloCliente;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.fis.RigaUds;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.lgb.RigaLista;
import it.thera.thip.logis.lgb.RigaListaTM;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdMat;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdTes;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 02/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71946    02/05/2025  DSSOF3   Prima stesura
 */

public class YRilevDatiPrdTS extends RilevDatiPrdTS {

	public static final String STMT_IS_ATV_ESEC_P_PRE = "SELECT "
			+ "	P.* "
			+ "FROM "
			+ "	THIP.PIANI_PRL_TES P "
			+ "INNER JOIN LOGIS.LLISTA_TESTA T "
			+ "ON P.ID_AZIENDA = T.COD_SOCIETA "
			+ "AND P.R_COD_LISTA = T.CODICE "
			+ "WHERE P.ID_AZIENDA = ? "
			+ "AND P.ID_ANNO_ORD = ? "
			+ "AND P.ID_NUMERO_ORD = ? "
			+ "AND P.ID_RIGA_ATTIVITA = ? "
			+ "AND T.COD_TIPO_LISTA = ?";
	protected static CachedStatement cAtvEsecSuListaPPREL = new CachedStatement(STMT_IS_ATV_ESEC_P_PRE);

	public static final String STMT_RIGA_LISTA = "SELECT  "
			+ "	R.* "
			+ "FROM  "
			+ "	THIP.PIANI_PRL_TES P "
			+ "INNER JOIN LOGIS.LLISTA_TESTA T  "
			+ "	ON "
			+ "	P.ID_AZIENDA = T.COD_SOCIETA "
			+ "	AND P.R_COD_LISTA = T.CODICE "
			+ "INNER JOIN LOGIS.LLISTA_RIGA R "
			+ "ON "
			+ "	R.COD_SOCIETA = T.COD_SOCIETA "
			+ "	AND R.COD_LISTA = T.CODICE "
			+ "WHERE "
			+ "	P.ID_AZIENDA = ? "
			+ "	AND P.ID_ANNO_ORD = ? "
			+ "	AND P.ID_NUMERO_ORD = ? "
			+ "	AND P.ID_RIGA_ATTIVITA = ? "
			+ "	AND T.COD_TIPO_LISTA = ? "
			+ "	AND R.NUM_RIGA_HOST = ?";
	protected static CachedStatement cRigaListaFromRilevazione = new CachedStatement(STMT_RIGA_LISTA);

	public static final String STMT_QTA_IMBALLATA = "SELECT "
			+ "	SUM(QUANTITA) "
			+ "FROM "
			+ "	THIPPERS.YGESTIONE_UDS_PICKING_PROD "
			+ "WHERE ID_AZIENDA = ? "
			+ "AND NUMERO_RITORNO = ? "
			+ "AND R_COD_LISTA = ? "
			+ "AND R_COD_RIGA_LISTA = ? "
			+ "AND STATO = ? ";
	protected static CachedStatement cSommaQuantitaImballata = new CachedStatement(STMT_QTA_IMBALLATA);

	protected String iYIdTipoUDS;
	protected boolean iYNonGestirePicking;
	protected Integer iYNumeroPzBauletto;
	protected Integer iYNumeroPzUds;

	public YRilevDatiPrdTS() {
		setYNonGestirePicking(false);
	}

	public String getYIdTipoUds() {
		return iYIdTipoUDS;
	}

	public void setYIdTipoUds(String iYIdTipoUDS) {
		this.iYIdTipoUDS = iYIdTipoUDS;
		setDirty();
	}

	public boolean isYNonGestirePicking() {
		return iYNonGestirePicking;
	}

	public void setYNonGestirePicking(boolean iYNonGestirePicking) {
		this.iYNonGestirePicking = iYNonGestirePicking;
		setDirty();
	}

	public Integer getYNumeroPzBauletto() {
		return iYNumeroPzBauletto;
	}

	public void setYNumeroPzBauletto(Integer iYNumeroPzBauletto) {
		this.iYNumeroPzBauletto = iYNumeroPzBauletto;
		setDirty();
	}

	public Integer getYNumeroPzUds() {
		return iYNumeroPzUds;
	}

	public void setYNumeroPzUds(Integer iYNumeroPzUds) {
		this.iYNumeroPzUds = iYNumeroPzUds;
		setDirty();
	}

	/**
	 * Quando viene convalidata la rilevazione...creando quindi il documento di produzione,
	 * se l'attivita' esecutiva e' collegata ad una lista di prelievo P/VENL allora devo generare in maniera
	 * automatica le UDS che l'operatore ha parcheggiato temporaneamente nella tabella {@value YGestioneUdsPickingProdTM#TABLE_NAME} con 
	 * stato annullato.<br>
	 */
	@Override
	public int convalidaRilevazione(RilevazioneDatiProdTes testata, int rc, boolean genDoc) {
		int rcConvalida = super.convalidaRilevazione(testata, rc, genDoc);

		//.Se la lista e' P/PREL devo generare le UDS automaticamente
		if(rcConvalida > 0 && isAttivitaEsecutivaSuListaPPREL() && !isYNonGestirePicking()) {
			int rcUds = generaUdsLogistica(testata);
			if(rcUds >= 0)
				rcConvalida += rcUds;
			else
				rcConvalida = rcUds;
		}

		return rcConvalida;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected int generaUdsLogistica(RilevazioneDatiProdTes testata) {
		int rc = 0;
		RigaLista rl = getRigaListaCollegataRilevazione();
		if(rl != null) {
			String where = " "+YGestioneUdsPickingProdTM.ID_AZIENDA+" = '"+getIdAzienda()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.NUMERO_RITORNO+" = '"+getAttivitaEsecutiva().getNumeroRitorno()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.R_COD_LISTA+" = '"+rl.getTestataLista().getCodice()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.R_COD_RIGA_LISTA+" = '"+rl.getCodice().toString()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.STATO+" = '"+DatiComuniEstesi.ANNULLATO+"' ";
			try {
				Vector list = YGestioneUdsPickingProd.retrieveList(where, "", false);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					YGestioneUdsPickingProd udsPicking = (YGestioneUdsPickingProd) iterator.next();

					TestataUds testataUds = udsPicking.creaTestataUds();
					if(testataUds != null) {
						int rcTes = testataUds.save();
						if(rcTes > 0) {
							RigaUds rigaUds = udsPicking.creaRigaUds(testataUds);
							RilevazioneDatiProdMat mat = (RilevazioneDatiProdMat)testata.getRigheMateriali().get(0);
							rigaUds.setCodiceMagLogico(mat.getIdMagazzino());
							testataUds.getRigheUds().add(rigaUds);						
						}
						rc = testata.save();
						if(rc > 0) {
							udsPicking.getDatiComuniEstesi().setStato(DatiComuniEstesi.VALIDO);
							rc = udsPicking.save();
						}
					}
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return rc;
	}

	public void valorizzaDatiPickingAutomatico() {
		YArticolo articolo = (YArticolo) getArticolo();
		String idTipoUds = articolo.getIdTipoUDS();
		Integer nrPziBauletto = articolo.getNrPezziBauletto();
		Integer nrPziUds = articolo.getNrPezziUds();
		YArticoloCliente artCli = null;
		try {
			artCli = (YArticoloCliente) ArticoloCliente.getArticoloCliente(getIdAzienda(), getAttivitaEsecutiva().getOrdineEsecutivo().getIdCliente(),
					getIdArticolo(), getIdConfigurazione());
			if(artCli != null) {
				if(artCli.getIdTipoUDS() != null)
					idTipoUds = artCli.getIdTipoUDS();
				if(artCli.getNrPezziBauletto() != null)
					nrPziBauletto = artCli.getNrPezziBauletto();
				if(artCli.getNrPezziUds() != null)
					nrPziUds = artCli.getNrPezziUds();
			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}
		setYIdTipoUds(idTipoUds);
		setYNumeroPzBauletto(nrPziBauletto);
		setYNumeroPzUds(nrPziUds);
	}

	public boolean isAttivitaEsecutivaSuListaPPREL() {
		if(getAttivitaEsecutiva() == null)
			return false;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cAtvEsecSuListaPPREL.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getIdAnnoOrdine());
			db.setString(ps, 3, getIdNumeroOrdine());
			db.setString(ps, 4, getIdRigaAttivita().toString());
			db.setString(ps, 5, "P/PREL");
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				return true;
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return false;
	}

	public RigaLista getRigaListaCollegataRilevazione() {
		RigaLista rl = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cRigaListaFromRilevazione.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getIdAnnoOrdine());
			db.setString(ps, 3, getIdNumeroOrdine());
			db.setString(ps, 4, getIdRigaAttivita().toString());
			db.setString(ps, 5, "P/PREL");
			db.setString(ps, 6, getIdRigaAttivita().toString());
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				rl = RigaLista.elementWithKey(KeyHelper.buildObjectKey(new String[] {
						resultSet.getString(RigaListaTM.CODICE_SOCIETA),
						resultSet.getString(RigaListaTM.CODICE_TESTATA),
						resultSet.getString(RigaListaTM.CODICE)
				}), PersistentObject.NO_LOCK);
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return rl;
	}

	public BigDecimal getSommaQuantitaImballataPickingProduzione(RigaLista rl, char stato) {
		BigDecimal sum = BigDecimal.ZERO;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cSommaQuantitaImballata.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getAttivitaEsecutiva().getNumeroRitorno());
			db.setString(ps, 3, rl.getTestataLista().getCodice());
			db.setString(ps, 4, rl.getCodice().toString());
			db.setString(ps, 5, String.valueOf(stato));
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				sum = resultSet.getBigDecimal(1);
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return sum;
	}

}
