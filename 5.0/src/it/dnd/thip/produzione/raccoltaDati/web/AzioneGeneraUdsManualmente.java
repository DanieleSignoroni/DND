package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.BaseServlet;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.logis.lgb.RigaLista;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 07/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71946    07/05/2025  DSSOF3   Prima stesura
 */

public class AzioneGeneraUdsManualmente extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void processAction(ServletEnvironment se) throws ServletException, IOException, SQLException{
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) se.getRequest().getSession().getAttribute("RilevDatiPrdTSOldObject");
		String idTipoUds = getStringParameter(se.getRequest(), "IdTipoUds");
		if (se.isErrorListEmpity()){
			RigaLista rl = bo.getRigaListaCollegataRilevazione();
			if(rl != null) {
				PrintWriter out = se.getResponse().getWriter();
				String url = se.getServletPath();
				String restrictCondition = "IdCodiceLista=" + rl.getTestataLista().getCodice();
				//restrictCondition += ";IdCodiceRigaLista=" + rl.getCodice();
				restrictCondition += ";StatoUds=" + YGestioneUdsPickingProd.PACKING_IN_CORSO;
				restrictCondition += ";IdAzienda=" + Azienda.getAziendaCorrente();
				String restrictConditions = "&thRestrictConditions=" +
						com.thera.thermfw.web.URLUtils.get().encode(restrictCondition);
				url += "it.dnd.thip.produzione.raccoltaDati.web.MostraUdsAzioneGeneraUdsAutomaticamente?ClassName=YGestioneUdsPickingProd&ngLook=true&thGridType=list" +
						restrictConditions;
				url += "&IdTipoUds="+idTipoUds;
				url += "&NumeroRitorno="+bo.getAttivitaEsecutiva().getNumeroRitorno();
				out.println("  <script language=\'JavaScript1.2\'>");
				if (url.startsWith("/"))
					url = url.substring(1);
				out.println("    var url = '" + se.getWebApplicationPath() + url + "'");
				out.println(" 	 var winFeature = 'width=" + 1000 + ", height=" + 700 + ", resizable=yes';"); 
				out.println("    var winName = '" + String.valueOf(System.currentTimeMillis()) + "';");
				out.println("    var winrUrl = parent.window.open(url, winName, winFeature);");
				out.println("  </script>");
				out.close();
			}
		}
	}

}
