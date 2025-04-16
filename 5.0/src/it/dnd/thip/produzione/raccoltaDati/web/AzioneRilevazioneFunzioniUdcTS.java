package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.sql.SQLException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.FillObject;

import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSDataCollector;

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

public class AzioneRilevazioneFunzioniUdcTS extends FillObject {

	private static final long serialVersionUID = 1L;

	public void processAction(ServletEnvironment se) throws javax.servlet.ServletException, IOException, SQLException{
		//String key = getStringParameter(se.getRequest(), "thKey");
		String className = getStringParameter(se.getRequest(), "thClassName");
		String collectorName = getStringParameter(se.getRequest(), "thCollectorName");
		String action = (String) se.getRequest().getAttribute("Action");
		if (collectorName == null || collectorName.equals(""))
			collectorName = BODataCollector.class.getName();
		ClassADCollection cadc = getClassADCollection(className);
		RilevDatiPrdTSDataCollector boDC = (RilevDatiPrdTSDataCollector) Factory.createObject(collectorName);
		boDC.initialize(className, true, getCurrentLockType(se));
		setValues(cadc, boDC, se);
		boDC.completaRilevazione(action);
		if (se.isErrorListEmpity()) {
			boDC.setAutoCheck(false);
			actionOnObject(boDC, se);
		}
		closeAction(boDC, se);

		se.getRequest().setAttribute("myObject", boDC.getBo());
		se.getRequest().setAttribute("Action", action);
		String jsp = (String) se.getRequest().getAttribute("JspName");
		se.getRequest().setAttribute("JspName", jsp);
		String prevJsp = getStringParameter(se.getRequest(), "thPrevJspName");
		String oldJsp = getStringParameter(se.getRequest(), "thOldJspName");
		String oldAction = getStringParameter(se.getRequest(), "thOldAction");
		prevJsp = prevJsp + KeyHelper.KEY_SEPARATOR + oldJsp + KeyHelper.KEY_SEPARATOR + oldAction; 
		se.getRequest().setAttribute("PrevJspName", prevJsp);
		se.sendRequest(getServletContext(), jsp, true);
	}
}
