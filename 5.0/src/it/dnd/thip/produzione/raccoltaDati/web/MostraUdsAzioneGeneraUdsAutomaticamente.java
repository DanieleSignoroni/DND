package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.ShowGrid;

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

public class MostraUdsAzioneGeneraUdsAutomaticamente extends ShowGrid {

	private static final long serialVersionUID = 1L;

	@Override
	protected void callGridJSP(ServletEnvironment se, String gridURL) throws IOException, ServletException {
		gridURL+="&MostraUdsAzioneGeneraUdsAutomaticamente=Y";
		gridURL+="&IdTipoUds="+se.getRequest().getParameter("IdTipoUds");
		gridURL+="&NumeroRitorno="+se.getRequest().getParameter("NumeroRitorno");
		gridURL = gridURL.replace("com/thera/thermfw/common/Grid.jsp", "it/dnd/thip/produzione/raccoltaDati/MostraUdsAzioneGeneraManGrid.jsp");
		super.callGridJSP(se, gridURL);
	}
}
