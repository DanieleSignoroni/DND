package it.dnd.thip.vendite.documentoVE.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.web.ServletEnvironment;

import it.thera.thip.vendite.documentoVE.web.DocumentoTestataVenditaEstrattoFormActionAdapter;

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

public class YDocumentoTestataVenditaEstrattoFormActionAdapter extends DocumentoTestataVenditaEstrattoFormActionAdapter {

	private static final long serialVersionUID = 1L;

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getAzione(se);
		if(azione != null && azione.equals(YDocumentoVenditaGridActionAdapter.INVIA_LISTA_PRL_LEAN_LIFT)) {
			inviaListaPrelievoLeanLift(cadc, se);
		}else {
			super.otherActions(cadc, se);
		}
	}

	protected void inviaListaPrelievoLeanLift(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		try {
			se.getRequest().setAttribute(KEY, se.getRequest().getParameter(KEY));
			se.getRequest().setAttribute("DaEstratto",Boolean.TRUE);
			se.sendRequest(getServletContext(), se.getServletPath() + "it.dnd.thip.vendite.documentoVE.web.InviaListaPrelievoLeanLift", false);
		}
		catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
	}
}
