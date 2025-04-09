package it.dnd.thip.logis.lgb.web;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.BaseComponent;
import com.thera.thermfw.common.BaseComponentsCollection;

import it.thera.thip.base.documenti.web.DocumentoDataCollector;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 */

public class YPianoCaricoToyotaDataCollector extends DocumentoDataCollector {

	@Override
	protected String getNavigatoreName() {
		return "it.dnd.thip.logis.lgb.web.YPianoCaricoToyotaNavigazioneWeb";
	}

	@Override
	public void impostaSecondoCausale() {

	}

	protected BaseComponentsCollection getComponentiNuovoDocDaControllare(){
		String[] bcNames = new String[]{"NumeratoreHandler.DataDocumento","NumeratoreHandler.Anno", "NumeratoreHandler.Numero", "NumeratoreHandler.IdNumeratore"};

		BaseComponentsCollection bcc = new BaseComponentsCollection();
		for(int i =0; i<bcNames.length; i++){
			BaseComponent bc = componentsCollection.getComponent(bcNames[i]);
			if (bc==null)
				Trace.printlnUserArea(Trace.US1, "WARNING: Componente con AD = '"+bcNames[i]+"' non trovato!", DocumentoDataCollector.TRACE_SELECTOR);
			else
				bcc.addComponent(bc.getClassADName(),bc);
		}
		return bcc;
	}

}
