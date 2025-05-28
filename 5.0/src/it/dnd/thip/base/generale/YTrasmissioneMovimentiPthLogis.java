package it.dnd.thip.base.generale;

import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaTM;
import it.thera.thip.base.generale.CfgLogTxMov;
import it.thera.thip.base.generale.MovimentoThipLogis;
import it.thera.thip.base.generale.TrasmissioneMovimentiPthLogis;
import it.thera.thip.magazzino.movimenti.MovimentoMagazzino;
import it.thera.thip.produzione.documento.DocumentoProduzione;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 28/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71979    28/05/2025  DSSOF3   Prima stesura
 */

public class YTrasmissioneMovimentiPthLogis extends TrasmissioneMovimentiPthLogis {

	@SuppressWarnings("rawtypes")
	@Override
	protected MovimentoThipLogis setAttributiDaMovimento(MovimentoMagazzino movMagazzino, boolean delete,
			CfgLogTxMov cfgLogTxMov) {
		MovimentoThipLogis movThipLogis = super.setAttributiDaMovimento(movMagazzino, delete, cfgLogTxMov);
		char tipoDoc = movMagazzino.getTipoDocumento().charAt(0);
		if(tipoDoc == MovimentoMagazzino.AREA_PRODUZIONE && movThipLogis.getCodiceOperazMovim().equals("VERPRD")) {
			try {
				DocumentoProduzione docPrd = (DocumentoProduzione) DocumentoProduzione.elementWithKey(DocumentoProduzione.class, KeyHelper.buildObjectKey(new String[] {
						movMagazzino.getCodiceAzienda(),
						movMagazzino.getCodiceAnnoFiscale(),
						movMagazzino.getNumeroDocumento()
				}), PersistentObject.NO_LOCK);
				if(docPrd != null) {
					String where = " "+YPianoCaricoToyotaTM.ID_AZIENDA+" = '"+movMagazzino.getCodiceAzienda()+"' ";
					where += "AND "+YPianoCaricoToyotaTM.NUMERO_RITORNO_VRS+" = '"+docPrd.getNumeroRitorno()+"' ";
					Vector piani = YPianoCaricoToyota.retrieveList(where, "", false);
					if(piani.size() > 0) {
						YPianoCaricoToyota piano = (YPianoCaricoToyota) piani.get(0);

						movThipLogis.setMappaUdc(piano.getUdc());

					}
				}
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return movThipLogis;
	}
}
