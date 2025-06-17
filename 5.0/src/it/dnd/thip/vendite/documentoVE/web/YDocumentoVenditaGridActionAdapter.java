package it.dnd.thip.vendite.documentoVE.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;

import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaGridActionAdapter;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 17/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    17/06/2025  DSSOF3   Prima stesura
 */

public class YDocumentoVenditaGridActionAdapter extends DocumentoVenditaGridActionAdapter {

	private static final long serialVersionUID = 1L;

	protected static final String RES = "it.dnd.thip.vendite.documentoVE.resources.YDocumentoVendita";

	public static final String INVIA_LISTA_PRL_LEAN_LIFT = "INVIA_LISTA_PRL_LEAN_LIFT";

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton inviaListaPrlLeanLift = new WebToolBarButton("InviaListaPrlLeanLift",
				"action_submit", "infoArea", "no", RES, "InviaListaPrlLeanLift",
				"it/softre/thip/base/firmadigitale/img/firma.png", INVIA_LISTA_PRL_LEAN_LIFT, "multiple", false);
		toolBar.addButton(inviaListaPrlLeanLift);
	}

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getAzione(se);
		if(azione != null && azione.equals(INVIA_LISTA_PRL_LEAN_LIFT)) {
			inviaListaPrelievoLeanLift(cadc, se);
		}else {
			super.otherActions(cadc, se);
		}
	}

	@SuppressWarnings("rawtypes")
	protected void inviaListaPrelievoLeanLift(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		List lstChiaviSelected = getChiaviSelected(cadc, se);
		try {
			se.getRequest().setAttribute("lstChiaviSelected", lstChiaviSelected);
			se.sendRequest(getServletContext(), se.getServletPath() + "it.dnd.thip.vendite.documentoVE.web.InviaListaPrelievoLeanLift", false);
		}
		catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
	}
}
