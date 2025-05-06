package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.BaseServlet;
import com.thera.thermfw.web.servlet.Check;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.bas.Numeratore;
import it.thera.thip.logis.bas.NumeratoreMaxProgrException;
import it.thera.thip.logis.bas.NumeratoreNotFoundException;
import it.thera.thip.logis.bas.NumeratoreNotValidException;
import it.thera.thip.logis.lgb.RigaLista;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.AzionePaginaTS;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSDataCollector;
import it.thera.thip.vendite.proposteEvasione.CreaMessaggioErrore;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 06/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    06/05/2025  DSSOF3   Prima stesura
 */

public class AzioneGeneraUdsAutomaticamente extends Check {

	private static final long serialVersionUID = 1L;

	public void processAction(ServletEnvironment se) throws ServletException, IOException, SQLException{
		String action = (String) se.getRequest().getAttribute("Action");
		RilevDatiPrdTSDataCollector boDC = getRilevDatiPrdTSBODC(se);
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) boDC.getBo();
		if (se.isErrorListEmpity()){
			BigDecimal qtaDichiarata = bo.getQuantita();
			BigDecimal numeroPzPerUds = new BigDecimal(bo.getYNumeroPzUds());
			int numeroUds = 0;
			if (numeroPzPerUds.compareTo(BigDecimal.ZERO) > 0) {
				BigDecimal[] divisione = qtaDichiarata.divideAndRemainder(numeroPzPerUds);
				BigDecimal udsComplete = divisione[0]; // quante UDS intere possiamo fare
				BigDecimal residuo = divisione[1];     // pezzi residui

				numeroUds = udsComplete.intValue(); // solo le UDS complete

				if (residuo.compareTo(BigDecimal.ZERO) > 0) {
					se.addErrorMessage(new ErrorMessage(
							"BAS0000089", 
							"C'è un residuo di " + residuo.intValue() + " pezzi da gestire manualmente"
							));
				}
			} else {
				se.addErrorMessage(new ErrorMessage(
						"BAS0000078", 
						"Il numero di pezzi per UDS non può essere zero o negativo"
						));
			}
			RigaLista rl = bo.getRigaListaCollegataRilevazione();
			int rc = 0;
			for(int i = 0; i < numeroUds; i++) {
				YGestioneUdsPickingProd uds = (YGestioneUdsPickingProd) Factory.createObject(YGestioneUdsPickingProd.class);
				uds.setNumeroRitorno(bo.getAttivitaEsecutiva().getNumeroRitorno());
				try {
					uds.setIdUds(Numeratore.getNextProgr("UDS001"));
					uds.setIdTipoUds(bo.getYIdTipoUds());
					uds.setQuantita(new BigDecimal(bo.getYNumeroPzUds()));
					if(rl != null) {
						uds.setIdCodiceRigaLista(rl.getCodice());
						uds.setIdCodiceLista(rl.getTestataLista().getCodice());
					}
					uds.getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO); //.La validero' dopo
					int rcUds = uds.save();
					if(rcUds < 0)
						rc = rcUds;
				} catch (NumeratoreMaxProgrException | NumeratoreNotFoundException | InstantiationException
						| ClassNotFoundException | IllegalAccessException | NumeratoreNotValidException | SQLException e) {
					if(e instanceof SQLException)
						se.addErrorMessage(CreaMessaggioErrore.daRcAErrorMessage(rc, (SQLException) e));
					e.printStackTrace(Trace.excStream);
				}
			}
			if(rc >= 0) {
				bo.setYIdTipoUds(null);
				bo.setYNumeroPzBauletto(null);
				bo.setYNumeroPzUds(null);
				ConnectionManager.commit();
			}else {
				ConnectionManager.rollback();
			}
		}
		if (se.isErrorListEmpity()){
			String url = "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp";
			se.getRequest().setAttribute("Action", action);
			se.getRequest().setAttribute("myObject", bo);
			se.getRequest().setAttribute("JspName", url);
			String oldAction = getStringParameter(se.getRequest(),"thOldAction");
			String oldJspName = getStringParameter(se.getRequest(),"thOldJspName");
			String prevJspName = getStringParameter(se.getRequest(),"thPrevJspName");
			prevJspName = prevJspName + KeyHelper.KEY_SEPARATOR + oldJspName + KeyHelper.KEY_SEPARATOR + oldAction;
			se.getRequest().setAttribute("PrevJspName", prevJspName);

			se.sendRequest(getServletContext(), url, true);
		}
		else {
			String oldAction = getStringParameter(se.getRequest(),"thOldAction");
			String oldJspName = getStringParameter(se.getRequest(),"thOldJspName");
			String prevJspName = getStringParameter(se.getRequest(),"thPrevJspName");

			se.getRequest().setAttribute("myObject", bo);
			se.getRequest().setAttribute("Action", oldAction);
			se.getRequest().setAttribute("ErroriList", boDC.getErrorList().getErrors());
			se.getRequest().setAttribute("JspName", oldJspName);
			se.getRequest().setAttribute("PrevJspName", prevJspName);

			if (oldJspName.indexOf("DichiarazionePrelievi.jsp") > 0)
				se.getRequest().setAttribute("Azione", "PRELIEVI");
			else if (oldJspName.indexOf("DichiarazioneVersamenti.jsp") > 0)
				se.getRequest().setAttribute("Azione", "VERSAMENTI");
			se.sendRequest(getServletContext(), oldJspName, true);
		}
	}

	public RilevDatiPrdTSDataCollector getRilevDatiPrdTSBODC(ServletEnvironment se) {
		String className = getStringParameter(se.getRequest(),"thClassName");
		String collectorName = getStringParameter(se.getRequest(),"thCollectorName");
		String action = (String) se.getRequest().getAttribute("Action");
		String url = getStringParameter(se.getRequest(),"thOldJspName");
		if (collectorName==null || collectorName.equals(""))
			collectorName = BODataCollector.class.getName();
		ClassADCollection cadc = getClassADCollection(className);
		RilevDatiPrdTSDataCollector boDC = (RilevDatiPrdTSDataCollector) Factory.createObject(collectorName);
		String iChiaveInSessione = BaseServlet.getStringParameter(se.getRequest(), AzionePaginaTS.CHIAVE_DATI_SESSIONE);
		RilevDatiPrdTS boInSessione = iChiaveInSessione != null ? (RilevDatiPrdTS) se.getSession().getAttribute(iChiaveInSessione) : null;;
		if(boInSessione != null) {
			if (url.indexOf("DichiarazionePrelievi.jsp") > 0) {
				boDC.setBo(boInSessione);	
			}
		}
		boDC.initialize(className, true, getCurrentLockType(se));
		setValues(cadc, boDC, se);
		boDC.completaRilevazione(action);    
		if (se.isErrorListEmpity())
		{
			boDC.setAutoCheck(false);
			boDC.setServletEnvironment(se);
			se.getRequest().setAttribute("Action", action);
			RilevDatiPrdTS ril = (RilevDatiPrdTS) boDC.getBo();
			if (url.indexOf("DichiarazionePrelievi.jsp") > 0)
				ril.setInPrelieviJsp(true);
			actionOnObject(boDC, se);
			ril.setInPrelieviJsp(false); 
		}
		return boDC;
	}
}
