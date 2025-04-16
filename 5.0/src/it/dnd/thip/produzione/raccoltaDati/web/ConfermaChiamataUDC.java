package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.collector.BaseBOComponentManager;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebDataCollector;
import com.thera.thermfw.web.servlet.BaseServlet;
import com.thera.thermfw.web.servlet.Check;

import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.logis.fis.RigaMovimento;
import it.thera.thip.logis.fis.RigaMovimentoTM;
import it.thera.thip.logis.fis.Saldo;
import it.thera.thip.logis.fis.SaldoTM;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.AzionePaginaTS;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 16/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    16/04/2025  DSSOF3   Prima stesura
 */

public class ConfermaChiamataUDC extends Check {

	public static final String STMT_ELENCO_UDC_ARTICOLO_CON_GIACENZA = "SELECT "
			+ "S.COD_SOCIETA,S.CODICE "
			+ "FROM "
			+ "	LOGIS.LMAPPA_UDC U "
			+ "INNER JOIN LOGIS.LSALDO S "
			+ "ON "
			+ "	U.CODICE = S.COD_MAPPA_UDC "
			+ "WHERE "
			+ "	S.COD_ARTICOLO = ? "
			+ "	AND S.COD_SOCIETA = ?";
	public static CachedStatement cElencoUdcArticoloConGiacenza = new CachedStatement(STMT_ELENCO_UDC_ARTICOLO_CON_GIACENZA);

	public static final String STMT_MOVIMENTO_QTA_0_STORICO = "SELECT "
			+ "	* "
			+ "FROM "
			+ "	LOGIS.LMOVIM_RIGA M "
			+ "WHERE M.COD_SOCIETA = ? "
			+ "AND M.COD_ARTICOLO = ? "
			+ "AND M.COD_MAPPA_UDC IS NOT NULL "
			+ "AND M.QTA1 = 0 ";
	public static CachedStatement cMovimentoStoricoQta0 = new CachedStatement(STMT_MOVIMENTO_QTA_0_STORICO);

	private static final long serialVersionUID = 1L;

	@Override
	public void processAction(ServletEnvironment se) throws ServletException, IOException, SQLException {
		//String key = se.getRequest().getParameter(KEY);
		String className = se.getRequest().getParameter(CLASS_NAME);
		String collectorName = se.getRequest().getParameter(COLLECTOR_NAME);
		if (collectorName==null || collectorName.equals(""))
			collectorName = BODataCollector.class.getName();
		ClassADCollection cadc = getClassADCollection(className);
		BODataCollector boDC = (BODataCollector) Factory.createObject(collectorName);
		if (boDC instanceof WebDataCollector)
			((WebDataCollector)boDC).setServletEnvironment(se);
		boDC.initialize(className, true, getCurrentLockType(se));
		// 07981 - DF
		boDC.setCheckWithDomain(true);
		setValues(cadc, boDC, se);
		if (se.isErrorListEmpity())
			actionOnObject(boDC, se);
		closeAction(boDC, se);
		//Mod.1959 - ini
		//se.sendRequest(getServletContext(), "com/thera/thermfw/common/ErrorListHandler.jsp", true);
		afterProcessAction(boDC, se);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void actionOnObject(BODataCollector boDC, ServletEnvironment se) {
		String action = se.getRequest().getParameter(ACTION);
		if(action.equals(YRilevDatiPrdTSFormActionAdapter.CONFERMA_CHIAMATA_UDC)) {
			boDC.getComponent("BollaLavorazione").getComponentManager().setCheckMode(BaseBOComponentManager.CHECK_NEVER); //.Evito il controllo 
			boDC.getComponent("IdOperatore").getComponentManager().setCheckMode(BaseBOComponentManager.CHECK_NEVER); //.Evito il controllo

			boDC.getComponent("IdOperatore").getComponentManager().setMandatory(false); //.Di default su hdr e' mandatory quindi spengo

			String idReparto = (String) boDC.getComponent("IdOperatore").getValue(); //.Prendo il valore prima della check dato che sto usando un campo fittizio
			boDC.getComponent("IdOperatore").setValue(""); //.Svuoto cosi da evitare errori su Proxy

			RilevDatiPrdTS bo = (RilevDatiPrdTS) boDC.getBo();
			bo.setIdOperatore(idReparto);
			if (boDC.check() != BODataCollector.OK) {
				for (Iterator iterator = boDC.getErrorList().getErrors().iterator(); iterator.hasNext();) {
					ErrorMessage em = (ErrorMessage) iterator.next();
					em.addComponent("UDC", "UDC", boDC.getComponent("IdOperatore")); //.Cambio la label al campo 'BollaLavorazione'
				}
				se.addErrorMessages(boDC.getErrorList().getErrors());
			}else {
				String udc = bo.getBollaLavorazione();
				if(bo.getIdArticolo() != null) {
					Articolo articolo = bo.getArticolo();
					if(articolo != null) {
						ArrayList<Saldo> saldi = elencoSaldiArticoloUdc(articolo.getIdArticolo());
						if(!saldi.isEmpty()) {
							se.getRequest().setAttribute("ListaSaldi", saldi);
						}else {
							RigaMovimento rM = trovaRigaMovimentoStorico(articolo.getIdArticolo());
							se.getRequest().setAttribute("RigaMovimentoStorico", rM);
						}
					}else {
						ErrorMessage emArt = new ErrorMessage("BAS0000004",new String[] {bo.getIdArticolo()});
						emArt.addComponent(boDC.getComponent("IdArticolo").getComponentManager().getClassADName(),
								boDC.getComponent("IdArticolo").getComponentManager().getAttributeLabel(), boDC.getComponent("IdArticolo"));
						boDC.getErrorList().addError(emArt);
					}
				}else if(udc != null) {
					MappaUdc mappa = null;
					try {
						mappa = MappaUdc.elementWithKey(udc, PersistentObject.NO_LOCK);
					} catch (SQLException e1) {
						e1.printStackTrace(Trace.excStream);
					}
					if(mappa == null) {
						boDC.getErrorList().addError((new ErrorMessage("YLOGIS0001")));
					}
				}else {
					boDC.getErrorList().addError((new ErrorMessage("BAS0000078","Almeno uno dei due campi va valorizzato")));
				}
				se.addErrorMessages(boDC.getErrorList().getErrors());
			}
		}else if(action.equals(YRilevDatiPrdTSFormActionAdapter.CHIAMATA_UDC_SCELTA_UDC)) {
			String idReparto = (String) boDC.getComponent("IdOperatore").getValue();
			String codMappaUDC = (String) boDC.getComponent("BollaLavorazione").getValue();
			boolean stop = true;
		}
	}
	
	public YPianoCaricoToyota generaTestataPianoCarico(MappaUdc udc, Reparto reparto) {
		YPianoCaricoToyota pianoCarico = (YPianoCaricoToyota) Factory.createObject(YPianoCaricoToyota.class);
		pianoCarico.setIdCodiceUdc(udc.getCodice());
		pianoCarico.setIdReparto(reparto.getIdReparto());
		pianoCarico.setIdMagazzinoFisicoStock(udc.getCodiceMagFisico());
		//pianoCarico.setIdCodiceUbicazioneStock(rs.getString(MissioneTM.COD_UBICAZIONE));
		return pianoCarico;
	}

	public void afterProcessAction(BODataCollector boDC, ServletEnvironment se) throws ServletException, IOException {
		se.getRequest().setAttribute("myObject", boDC.getBo());
		RilevDatiPrdTS rdpTS = (RilevDatiPrdTS)boDC.getBo();
		if (se.isErrorListEmpity() && rdpTS.getArticolo() == null){
			pulisciDatiSessione(se);
			se.getRequest().setAttribute("Action", null);
			se.getRequest().setAttribute("JspName", "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp"); //Fix 16109
			String url = "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp";
			se.sendRequest(getServletContext(), url, true);
		}else if(se.isErrorListEmpity() && rdpTS.getArticolo() != null){
			se.getRequest().setAttribute("Action", YRilevDatiPrdTSFormActionAdapter.CHIAMATA_UDC_LISTA_UDC);
			String url = "it/dnd/thip/produzione/raccoltaDati/YChiamataUDC.jsp";
			se.getRequest().setAttribute("JspName", url);
			se.sendRequest(getServletContext(), se.getServletPath() + "it.dnd.thip.produzione.raccoltaDati.web.AzioneRilevazioneFunzioniUdcTS", true);
		}
		else{
			String oldAction = getStringParameter(se.getRequest(),"thOldAction"); //Fix 15866
			String oldJspName = getStringParameter(se.getRequest(),"thOldJspName"); //Fix 15866
			String prevJspName = getStringParameter(se.getRequest(),"thPrevJspName"); //Fix 15866
			se.getRequest().setAttribute("Action", oldAction);
			se.getRequest().setAttribute("ErroriList", boDC.getErrorList().getErrors());
			se.getRequest().setAttribute("JspName", oldJspName);
			se.getRequest().setAttribute("PrevJspName", prevJspName);
			se.getRequest().setAttribute("DisplayReparti", "N");
			se.getRequest().setAttribute("IdReparto", rdpTS.getIdOperatore());

			se.sendRequest(getServletContext(), oldJspName, true);
		}
	}

	public void pulisciDatiSessione(ServletEnvironment se){
		String iChiaveInSessione = BaseServlet.getStringParameter(se.getRequest(), AzionePaginaTS.CHIAVE_DATI_SESSIONE);
		RilevDatiPrdTS boInSessione = iChiaveInSessione != null ? (RilevDatiPrdTS) se.getSession().getAttribute(iChiaveInSessione) : null;;
		if(boInSessione != null){
			//se.getSession().setAttribute(iChiaveInSessione, null); //Fix 35801
			se.getSession().removeAttribute(iChiaveInSessione); //Fix 35801
		}
	}

	public ArrayList<Saldo> elencoSaldiArticoloUdc(String codMappaUDC) {
		ResultSet rs = null;
		ArrayList<Saldo> saldi = new ArrayList<Saldo>();
		try{
			PreparedStatement ps = cElencoUdcArticoloConGiacenza.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, codMappaUDC);
			db.setString(ps, 2, Azienda.getAziendaCorrente());
			rs = ps.executeQuery();
			while (rs.next()){
				saldi.add(Saldo.elementWithKey(KeyHelper.buildObjectKey(new String[] {
						rs.getString(SaldoTM.COD_SOCIETA),
						rs.getString(SaldoTM.CODICE)
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
		return saldi;
	}

	public RigaMovimento trovaRigaMovimentoStorico(String idArticolo) {
		ResultSet rs = null;
		RigaMovimento riga = null;
		try{
			PreparedStatement ps = cElencoUdcArticoloConGiacenza.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, idArticolo);
			rs = ps.executeQuery();
			if (rs.next()){
				riga = RigaMovimento.elementWithKey(KeyHelper.buildObjectKey(new String[] {
						rs.getString(RigaMovimentoTM.CODICE_SOCIETA),
						rs.getString(RigaMovimentoTM.CODICE_TESTATA),
						rs.getString(RigaMovimentoTM.CODICE_RIGA),
						rs.getString(RigaMovimentoTM.CODICE_DETTAGLIO)
				}), PersistentObject.NO_LOCK);
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
		return riga;
	}

}
