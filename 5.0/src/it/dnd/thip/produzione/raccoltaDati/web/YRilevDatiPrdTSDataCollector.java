package it.dnd.thip.produzione.raccoltaDati.web;

import java.math.BigDecimal;
import java.util.Vector;

import com.thera.thermfw.common.ErrorMessage;

import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.lgb.RigaLista;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdRig;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSDataCollector;

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

public class YRilevDatiPrdTSDataCollector extends RilevDatiPrdTSDataCollector {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Vector runCheckAll() {
		String action = (String)getServletEnvironment().getRequest().getAttribute("Action");
		String jspName = (String)getServletEnvironment().getRequest().getParameter("thOldJspName");
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) getBo();
		if(action != null && action.equals(YRilevDatiPrdTSFormActionAdapter.GENERA_UDS_AUTOMATICAMENTE)) {
			getComponentManager("YIdTipoUds").setMandatory(true);
			//getComponentManager("YNumeroPzBauletto").setMandatory(true);
			getComponentManager("YNumeroPzUds").setMandatory(true);
		}
		Vector errors = super.runCheckAll();
		if(action != null && jspName != null && jspName.indexOf("DichiarazioneConBollaSospFine.jsp") > 0 && bo.getTipoTimbratura() == RilevazioneDatiProdRig.FINE
				&& bo.isAttivitaEsecutivaSuListaPPREL() && !action.equals(YRilevDatiPrdTSFormActionAdapter.GENERA_UDS_AUTOMATICAMENTE)) {
			RigaLista rl = bo.getRigaListaCollegataRilevazione();
			if(rl != null) {
				BigDecimal qtaImballata = bo.getSommaQuantitaImballataPickingProduzione(rl, DatiComuniEstesi.ANNULLATO);
				if(qtaImballata == null)
					qtaImballata = BigDecimal.ZERO;
				if(qtaImballata.compareTo(BigDecimal.ZERO) == 0 || qtaImballata.compareTo(bo.getQuantita()) < 0) {
					errors.add(new ErrorMessage("BAS0000078","La quantita' dichiarata non coindice con la quantita' imballata, sono stati imballati "+qtaImballata.intValue()+" pezzi"));
				}
			}
		}
		return errors;
	}
}