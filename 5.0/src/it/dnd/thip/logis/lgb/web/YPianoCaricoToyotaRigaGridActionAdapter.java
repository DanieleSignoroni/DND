package it.dnd.thip.logis.lgb.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebGridForm;
import com.thera.thermfw.web.WebMenuAbstract;
import com.thera.thermfw.web.WebMenuBar;
import com.thera.thermfw.web.WebToolBar;

import it.thera.thip.base.documenti.web.DocumentoDatiSessione;
import it.thera.thip.base.documenti.web.DocumentoGridActionAdapter;
import it.thera.thip.base.documenti.web.DocumentoNavigazioneWeb;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 09/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    09/04/2025  DSSOF3   Prima stesura
 */

public class YPianoCaricoToyotaRigaGridActionAdapter extends DocumentoGridActionAdapter {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void modifyMenuBar(WebMenuBar menuBar) {
		super.modifyMenuBar(menuBar);
		ArrayList voce = new ArrayList();
		WebMenuAbstract wma = menuBar.getMenu("ListMenu");
		voce.add("New");
		wma.removeMenu(voce);
		voce.clear();
		voce.add("NewTemplate");
		wma.removeMenu(voce);
		wma = menuBar.getMenu("SelectedMenu");
		voce.clear();
		voce.add("Open");
		voce.clear();
		voce.add("Copy");
		wma.removeMenu(voce);
	}

	@Override
	public void modifyToolBar(WebToolBar toolBar) {
		super.modifyToolBar(toolBar);
		toolBar.removeButton("New");
		toolBar.removeButton("Copy");
	}

	public void internalProcessAction(ServletEnvironment se) throws ServletException, IOException {
		DocumentoDatiSessione datiSessione = getDatiSessione(se);
		if(datiSessione == null) { //la jsp di una riga anche al di fuori della navigazione dei documenti
			super.internalProcessAction(se);
			datiSessione = getDatiSessione(se);
			//...FIX02576 - DZ  sennò dà NullPointer in writeBodyStartElements di OrdineAcquistoRigaPrmFormModifier
			String keyRiga = getStringParameter(se.getRequest(), "ObjectKey");
			datiSessione.setValoriChiaviDocumento(new String[] {
					KeyHelper.getTokenObjectKey(keyRiga, 1),
					KeyHelper.getTokenObjectKey(keyRiga, 2),
					KeyHelper.getTokenObjectKey(keyRiga, 3)});
			//...fine FIX02576 - DZ
		}
		String modoForm = getStringParameter(se.getRequest(), DocumentoNavigazioneWeb.MODO_FORM);
		if(modoForm != null && !datiSessione.getModoForm().equals(modoForm)) {
			datiSessione.setModoForm(modoForm);
			datiSessione.salvaInSessione(se);
		}

		//...FIX 7093 inizio
		//...imposto il valore dell'attributo RicercaPerBarcode solo se anche
		//...l'attributo modoForm è valorizzato, altrimenti rischio di impostarlo+
		//...erroneamente a "false" perchè alcune volte viene chiamato questo
		//...metodo senza che i parametri siano valorizzati.
		if(modoForm != null) {
			String ricBarcode = getStringParameter(se.getRequest(), "thRicBarcode");
			if(ricBarcode != null && ricBarcode.equalsIgnoreCase("on"))
				datiSessione.setRicercaPerBarcode(DocumentoNavigazioneWeb.RIC_BARCODE_SI);
			else
				datiSessione.setRicercaPerBarcode(DocumentoNavigazioneWeb.RIC_BARCODE_NO);
			datiSessione.salvaInSessione(se);
		}

	}

	public void impostaModoIniziale(DocumentoDatiSessione datiSessione, String modo) {
		datiSessione.setModoInizialeRigaPrm(modo);
	}

	/**
	 * getJSPCorrenteNuovo
	 * @param se ServletEnvironment
	 * @param datiSessione DocumentoDatiSessione
	 * @param azione String
	 * @return String
	 */
	protected String getJSPCorrenteNuovo(ServletEnvironment se, DocumentoDatiSessione datiSessione, String azione) {
		return datiSessione.getNavigatore().getJspRigaPrmNuovo();
	}

	/**
	 * getJSPCorrenteEstratto
	 * @param se ServletEnvironment
	 * @param datiSessione DocumentoDatiSessione
	 * @param azione String
	 * @return String
	 */
	protected String getJSPCorrenteEstratto(ServletEnvironment se, DocumentoDatiSessione datiSessione, String azione) {
		return datiSessione.getNavigatore().getJspRigaPrmEstratto();
	}

	/**
	 * getJSPCorrenteCompleta
	 * @param se ServletEnvironment
	 * @param datiSessione DocumentoDatiSessione
	 * @param azione String
	 * @return String
	 */
	protected String getJSPCorrenteCompleta(ServletEnvironment se, DocumentoDatiSessione datiSessione, String azione) {
		return datiSessione.getNavigatore().getJspRigaPrmCompleta();
	}

	/**
	 * getJSPCorrenteRidotta
	 * @param se ServletEnvironment
	 * @param datiSessione DocumentoDatiSessione
	 * @param azione String
	 * @return String
	 */
	protected String getJSPCorrenteRidotta(ServletEnvironment se, DocumentoDatiSessione datiSessione, String azione) {
		return datiSessione.getNavigatore().getJspRigaPrmRidotta();
	}

	public String getGridJSPName() {
		return "it/thera/thip/base/documenti/DocRigaPrmGrid.jsp";
	}

	public int getTipoEstratto() {
		return DocumentoNavigazioneWeb.RIGA_PRM_ESTRATTO;
	}

	public String getDoubleClickAction() {
		return WebGridForm.DOUBLE_CLICK_DEF_ACTION;
	}

}
