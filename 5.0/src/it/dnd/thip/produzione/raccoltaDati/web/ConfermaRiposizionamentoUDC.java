package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.collector.BaseBOComponentManager;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebDataCollector;
import com.thera.thermfw.web.servlet.BaseServlet;
import com.thera.thermfw.web.servlet.Check;

import it.dnd.thip.logis.lgb.StatoPrelievoUdcToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.AzionePaginaTS;
import it.thera.thip.vendite.proposteEvasione.CreaMessaggioErrore;

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
 * 71XXX    16/04/2025  DSSOF3   Prima stesura
 */

public class ConfermaRiposizionamentoUDC extends Check {

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
		boDC.getComponent("BollaLavorazione").getComponentManager().setCheckMode(BaseBOComponentManager.CHECK_NEVER); //.Evito il controllo 
		boDC.getComponent("IdOperatore").getComponentManager().setCheckMode(BaseBOComponentManager.CHECK_NEVER); //.Evito il controllo
		boDC.getComponent("IdOperatore").getComponentManager().setMandatory(false); //.Di default su hdr e' mandatory quindi spengo
		boDC.getComponent("BollaLavorazione").getComponentManager().setMandatory(true); //.Rendo il mio campo udc mandatory
		String idReparto = (String) boDC.getComponent("IdOperatore").getValue(); //.Prendo il valore prima della check dato che sto usando un campo fittizio
		boDC.getComponent("IdOperatore").setValue(""); //.Svuoto cosi da evitare errori su Proxy
		RilevDatiPrdTS bo = (RilevDatiPrdTS) boDC.getBo();
		if (boDC.check() != BODataCollector.OK) {
			bo.setIdOperatore(idReparto);
			for (Iterator iterator = boDC.getErrorList().getErrors().iterator(); iterator.hasNext();) {
				ErrorMessage em = (ErrorMessage) iterator.next();
				em.addComponent("UDC", "UDC", boDC.getComponent("IdOperatore")); //.Cambio la label al campo 'BollaLavorazione'
			}
			se.addErrorMessages(boDC.getErrorList().getErrors());
		}else {
			String udc = bo.getBollaLavorazione();
			MappaUdc mappa = null;
			try {
				mappa = MappaUdc.elementWithKey(udc, PersistentObject.NO_LOCK);
			} catch (SQLException e1) {
				e1.printStackTrace(Trace.excStream);
			}
			if(mappa == null) {
				boDC.getErrorList().addError((new ErrorMessage("YLOGIS0001")));
			}else {
				String where = " "+YPianoCaricoToyotaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' "
						+ "AND "+YPianoCaricoToyotaTM.R_REPARTO+" = '"+idReparto+"' "
						+ "AND "+YPianoCaricoToyotaTM.R_COD_MAPPA_UDC+" = '"+udc+"' AND "+YPianoCaricoToyotaTM.STATO_UDC+" = '"+StatoPrelievoUdcToyota.RICEVUTA+"' ";
				try {
					Vector piani = YPianoCaricoToyota.retrieveList(where, "", false);
					if(piani.size() == 0) {
						boDC.getErrorList().addError((new ErrorMessage("BAS0000078","L'UDC "+udc+" non è presente in baia")));
					}else {
						YPianoCaricoToyota pianoInRiposizionamento = (YPianoCaricoToyota) piani.get(0);
						pianoInRiposizionamento.setStatoUdc(StatoPrelievoUdcToyota.PRONTA_PER_REINTEGRO);
						int rc = pianoInRiposizionamento.save();
						if(rc > 0) {
							ConnectionManager.commit();
						}else {
							ConnectionManager.rollback();
							boDC.getErrorList().addError((CreaMessaggioErrore.daRcAErrorMessage(rc, (SQLException) pianoInRiposizionamento.getException())));
						}
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
					e.printStackTrace(Trace.excStream);
				}
			}
			se.addErrorMessages(boDC.getErrorList().getErrors());
		}
	}

	public void afterProcessAction(BODataCollector boDC, ServletEnvironment se) throws ServletException, IOException {
		se.getRequest().setAttribute("myObject", boDC.getBo());
		RilevDatiPrdTS rdpTS = (RilevDatiPrdTS)boDC.getBo();
		if (se.isErrorListEmpity()){
			pulisciDatiSessione(se);
			se.getRequest().setAttribute("Action", null);
			se.getRequest().setAttribute("JspName", "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp"); //Fix 16109
			String url = "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp";
			se.sendRequest(getServletContext(), url, true);
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
}
