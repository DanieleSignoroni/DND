package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebDataCollector;
import com.thera.thermfw.web.servlet.BaseServlet;
import com.thera.thermfw.web.servlet.Check;

import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.logis.fis.RigaUds;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.lgb.TestataLista;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.AzionePaginaTS;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 28/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71979    28/05/2025  DSSOF3   Prima stesura
 */

public class AzioneConfermaChisuraListaTesta extends Check {

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void actionOnObject(BODataCollector boDC, ServletEnvironment se) {
		super.actionOnObject(boDC, se);
		String action = se.getRequest().getParameter(ACTION);
		if(action.equals(YRilevDatiPrdTSFormActionAdapter.CONFERMA_CHIUSURA_LISTA_TESTA) && se.isErrorListEmpity() && boDC.getErrorList().getErrors().isEmpty()) {
			boDC.setOnBORecursive();
			YRilevDatiPrdTS bo = (YRilevDatiPrdTS) boDC.getBo();
			try {
				TestataLista tl = (TestataLista) TestataLista.elementWithKey(TestataLista.class, KeyHelper.buildObjectKey(new String[] {
						bo.getIdAzienda(),bo.getCodiceTestataLista()
				}), PersistentObject.NO_LOCK);
				if(tl != null) {
					Vector rlPackListInSped = RigaUds.retrieveList("COD_SOCIETA = '" + bo.getIdAzienda() + "' AND " +
							"COD_LISTA = '" + bo.getCodiceTestataLista()+"' ", "", true);
					TestataUds tu = null;
					for (Iterator iterator = rlPackListInSped.iterator(); iterator.hasNext();) {
						RigaUds ru = (RigaUds) iterator.next();
						if(ru.getTestataUds().getStatoAllestimento() == TestataUds.CHIUSO)
							continue;
						if(tu != null && !tu.getCodice().equals(ru.getTestataUds().getCodice())) {
							ru.getTestataUds().chiudiUds();
						}else {
							ru.getTestataUds().chiudiUds();
						}
						tu = ru.getTestataUds();
					}
					Vector errors = tl.forzaChiudi();
					boDC.getErrorList().getErrors().addAll(errors);
				}else {
					boDC.getErrorList().addError(new ErrorMessage("BAS0000078","La lista di prelievo "+bo.getCodiceTestataLista()+" non esiste!"));
				}
			} catch (Exception e) {
				boDC.getErrorList().addError(new ErrorMessage("BAS0000078",e.getMessage()));
				e.printStackTrace(Trace.excStream);
			}
		}
		se.addErrorMessages(boDC.getErrorList().getErrors());
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
		}else{
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
