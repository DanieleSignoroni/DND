package it.dnd.thip.produzione.ordese.web;

import com.thera.thermfw.collector.EnhBOComponentManager;
import com.thera.thermfw.web.WebEnhDataCollector;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.thera.thip.base.documenti.TipoGestione;

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
 * 71946    06/05/2025  DSSOF3   Prima stesura
 */

public class YGestioneUdsPickingProdDC extends WebEnhDataCollector {

	@Override
	public void initializeHandlingModeOnComponentManagers() {

	}

	@Override
	public void updateHandlingModeOnComponentManagers() {
		EnhBOComponentManager p0 = null;
		YGestioneUdsPickingProd bo = (YGestioneUdsPickingProd) getBo();
		if (bo.getTrasmessoLinea()) { //.Se trasmesso alla linea metto in sola visualizzazione questi attributi
			p0 = (EnhBOComponentManager)getComponentManager("Quantita");
			impostaHandlingModeOnComponentManagers(p0, TipoGestione.SOLO_VISUALIZZ);
			p0 = (EnhBOComponentManager)getComponentManager("IdTipoUds");
			impostaHandlingModeOnComponentManagers(p0, TipoGestione.SOLO_VISUALIZZ);
			p0 = (EnhBOComponentManager)getComponentManager("StatoUds");
			impostaHandlingModeOnComponentManagers(p0, TipoGestione.SOLO_VISUALIZZ);
		}

	}

	public static void impostaHandlingModeOnComponentManagers(EnhBOComponentManager ecm, char valueCombo)
	{
		if(ecm != null)
		{
			switch (valueCombo)
			{
			case TipoGestione.NON_GESTITO:
				ecm.setHandlingMode(EnhBOComponentManager.NOT_MANAGED);
				break;

			case TipoGestione.GESTITO_OBBLIG:
				ecm.setHandlingMode(EnhBOComponentManager.MANDATORY);
				break;

			case TipoGestione.GESTITO_NON_OBBLIG:
				ecm.setHandlingMode(EnhBOComponentManager.NOT_MANDATORY);
				break;

			case TipoGestione.SOLO_VISUALIZZ:
				ecm.setHandlingMode(EnhBOComponentManager.READ_ONLY);
				break;

			case TipoGestione.GESTITO_NON_CONTROL_NON_OBBLIG:
				ecm.setHandlingMode(EnhBOComponentManager.NOT_CHECKED);
				break;

			case TipoGestione.GESTITO_NON_VISUALIZZATO:
				ecm.setHandlingMode(EnhBOComponentManager.NOT_SHOWED);
				break;
			}
		}
	}

}
