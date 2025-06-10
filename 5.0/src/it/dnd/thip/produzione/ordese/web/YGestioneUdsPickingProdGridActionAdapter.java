package it.dnd.thip.produzione.ordese.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebToolBar;
import com.thera.thermfw.web.WebToolBarButton;
import com.thera.thermfw.web.servlet.GridActionAdapter;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 10/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71994    10/06/2025  DSSOF3   Prima stesura
 */

public class YGestioneUdsPickingProdGridActionAdapter extends GridActionAdapter {

	private static final long serialVersionUID = 1L;

	protected static final String RES = "it.dnd.thip.produzione.ordese.resources.YGestioneUdsPickingProd";
	public static final String ACCODA_UDS = "ACCODA_RIGHE";

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		WebToolBarButton accodaRighe = new WebToolBarButton("AccodaUds",
				"action_submit", "new", "no", RES, "AccodaUds",
				"it/thera/thip/vendite/ordineVE/images/AccodaRigheEva.gif", ACCODA_UDS, "single", true);
		toolBar.addButton(accodaRighe);
	}

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getStringParameter(se.getRequest(), ACTION);
		if(azione.equals(ACCODA_UDS)) {
			String url = getCurrentViewSelector().getCopyObjectURL(cadc, se, getClass().getName());
			url += "&IdCodiceRigaLista"+getStringParameter(se.getRequest(), "IdCodiceRigaLista");
			url += "&IdCodiceLista"+getStringParameter(se.getRequest(), "IdCodiceLista");
			url += "&AccodamentoUdsRaccoltaDati=Y";
			
			se.sendRequest(getServletContext(), url, false);
		}else {
			super.otherActions(cadc, se);
		}
	}
}
