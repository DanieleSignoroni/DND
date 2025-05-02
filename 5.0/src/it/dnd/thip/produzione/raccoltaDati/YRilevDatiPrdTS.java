package it.dnd.thip.produzione.raccoltaDati;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;

import it.dnd.thip.base.articolo.YArticolo;
import it.dnd.thip.base.articolo.YArticoloCliente;
import it.thera.thip.base.articolo.ArticoloCliente;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;

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
 * 71XXX    02/05/2025  DSSOF3   Prima stesura
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
			db.setString(ps, 5, "P/PRE");
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				return true;
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace(Trace.excStream);
				}
			}
		}
		return false;
	}

}
