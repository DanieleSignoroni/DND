package it.dnd.thip.produzione.ordese.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.gui.cnr.OpenType;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebFormModifier;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.bas.NumeratoreMaxException;
import it.thera.thip.logis.bas.NumeratoreMaxProgrException;
import it.thera.thip.logis.bas.NumeratoreNotFoundException;
import it.thera.thip.logis.bas.NumeratoreNotValidException;

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

public class YGestioneUdsPickingProdFormModifer extends WebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {
		ServletEnvironment se = getServletEnvironment();
		YGestioneUdsPickingProd bo = (YGestioneUdsPickingProd) getBODataCollector().getBo();
		if(se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null 
				&& se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y")
				&& getMode() == OpenType.NEW) {
			String idTipoUds = se.getRequest().getParameter("IdTipoUds");
			String numeroRitorno = se.getRequest().getParameter("NumeroRitorno");

			bo.setNumeroRitorno(numeroRitorno);
			bo.setIdTipoUds(idTipoUds);
			try {
				bo.setIdUds(bo.getTipouds().getTipoCodice().dammiProssimoCodice());
			} catch (NumeratoreMaxProgrException | NumeratoreNotFoundException | InstantiationException
					| ClassNotFoundException | IllegalAccessException | NumeratoreNotValidException
					| NumeratoreMaxException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
			bo.getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
		}
	}

	@Override
	public void writeBodyStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		ServletEnvironment se = getServletEnvironment();
		if(se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null && se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y")) {
			out.println("<input name=\"MostraUdsAzioneGeneraUdsAutomaticamente\" type=\"hidden\" value=\"Y\">");
		}
	}

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {

	}

}
