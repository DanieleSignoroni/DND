package it.dnd.thip.logis.lgb.web;

import it.thera.thip.base.documenti.web.DocumentoNavigazioneWeb;

/**
 *
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

public class YPianoCaricoToyotaNavigazioneWeb extends DocumentoNavigazioneWeb {

	public YPianoCaricoToyotaNavigazioneWeb() {
		iDescrittoreTestata = "YPianoCaricoToyota";
		iDescrittoreRigaPrm= "YPianoCaricoToyotaRiga";

		iJspTestataEstratto = "it/dnd/thip/logis/lgb/YPianoCaricoToyotaTesEstratto.jsp";
		iJspTestataEstrattoAltezza = 200;

		iJspTestataNuovo = "it/dnd/thip/logis/lgb/YPianoCaricoToyota.jsp";
		iJspTestataCompleta = "it/dnd/thip/logis/lgb/YPianoCaricoToyota.jsp";

		iJspRigaPrmCompleta = "it/dnd/thip/logis/lgb/YPianoCaricoToyotaRiga.jsp";
		iJspRigaPrmNuovo = "it/dnd/thip/logis/lgb/YPianoCaricoToyotaRiga.jsp";
	}
}
