package it.dnd.thip.produzione.ordese.web;

import java.util.Iterator;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.EnhBOComponentManager;
import com.thera.thermfw.gui.cnr.OpenType;
import com.thera.thermfw.web.WebEnhDataCollector;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProdTM;
import it.thera.thip.base.documenti.TipoGestione;
import it.thera.thip.cs.DatiComuniEstesi;

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

	@SuppressWarnings("rawtypes")
	@Override
	protected Vector runCheckAll() {
		if(getMode() == OpenType.NEW) {
			getComponentManager("IdUds").setRunCheckRelatedBo(false); //.Per evitare che faccia il controllo sulla tabella relazionata
		}else if(getServletEnvironment() != null && (getServletEnvironment().getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null
				&& getServletEnvironment().getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y"))
				&& getMode() == OpenType.UPDATE) {
			getComponentManager("IdUds").setRunCheckRelatedBo(false); //.Per evitare che faccia il controllo sulla tabella relazionata
		}
		return super.runCheckAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int save() {
		if(getServletEnvironment() != null && (getServletEnvironment().getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null
				&& getServletEnvironment().getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y"))) {
			
			setOnBORecursive(); //.Carico i valori
			
			YGestioneUdsPickingProd bo = (YGestioneUdsPickingProd) getBo();
			bo.getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);

			//.Se vengo dall'azione di generazione manuale e sto modificando una UDS gia' creata
			//.devo modificare di riflesso sulle altre UDS, tipo uds e stato
			if(getMode() == OpenType.UPDATE) {
				String where = " "+YGestioneUdsPickingProdTM.ID_AZIENDA+" = '"+bo.getIdAzienda()+"' "
						+ "AND "+YGestioneUdsPickingProdTM.NUMERO_RITORNO+" = '"+bo.getNumeroRitorno()+"' "
						+ "AND "+YGestioneUdsPickingProdTM.R_COD_LISTA+" = '"+bo.getIdCodiceLista()+"' "
						+ "AND "+YGestioneUdsPickingProdTM.R_COD_RIGA_LISTA+" = '"+bo.getIdCodiceRigaLista()+"' "
						+ "AND "+YGestioneUdsPickingProdTM.STATO+" = '"+DatiComuniEstesi.ANNULLATO+"' "
						+ "AND "+YGestioneUdsPickingProdTM.R_UDS+" NOT IN ('"+bo.getIdUds()+"') ";
				try {
					Vector list = YGestioneUdsPickingProd.retrieveList(where, "", false);
					for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						YGestioneUdsPickingProd uds = (YGestioneUdsPickingProd) iterator.next();

						if(!uds.getIdTipoUds().equals(bo.getIdTipoUds())) 
							uds.setTipouds(bo.getTipouds());

						if(uds.getStatoUds() != bo.getStatoUds())
							uds.setStatoUds(bo.getStatoUds());

						if(uds.dirty) {
							uds.save();
						}
					}
				}catch (Exception e) {
					e.printStackTrace(Trace.excStream);
				}
			}

		}
		return super.save();
	}

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
