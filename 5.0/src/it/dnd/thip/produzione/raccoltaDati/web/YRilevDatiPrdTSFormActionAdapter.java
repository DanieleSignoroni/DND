package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.web.ServletEnvironment;

import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSFormActionAdapter;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 16/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    16/04/2025  DSSOF3   Prima stesura
 */

public class YRilevDatiPrdTSFormActionAdapter extends RilevDatiPrdTSFormActionAdapter {

	private static final long serialVersionUID = 1L;

	public static final String CHIAMATA_UDC = "CHIAMATA_UDC";
	public static final String CHIAMATA_UDC_SCELTA_OPERATORE = "CHIAMATA_UDC_SCELTA_OPERATORE";
	public static final String CHIAMATA_UDC_LISTA_UDC = "CHIAMATA_UDC_LISTA_UDC";
	public static final String CHIAMATA_UDC_SCELTA_UDC = "CHIAMATA_UDC_SCELTA_UDC";
	public static final String CONFERMA_CHIAMATA_UDC = "CONFERMA_CHIAMATA_UDC";

	public static final String RIPOSIZIONA_UDC = "RIPOSIZIONA_UDC";
	public static final String RIPOSIZIONA_UDC_SCELTA_OPERATORE = "RIPOSIZIONA_UDC_SCELTA_OPERATORE";
	public static final String CONFERMA_RIPOSIZIONAMENTO_UDC = "CONFERMA_RIPOSIZIONAMENTO_UDC";

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getStringParameter(se.getRequest(), ACTION).toUpperCase();
		if(azione.equals(CHIAMATA_UDC)) {
			azioneChiamataUDC(se,azione);
		}else if(azione.equals(RIPOSIZIONA_UDC)) {
			azioneRiposizionaUDC(se,azione);
		}else if(azione.equals(RIPOSIZIONA_UDC_SCELTA_OPERATORE)) {
			azioneRilevazioneFunzioniUDC(azione, se);
		}else if(azione.equals(CHIAMATA_UDC_SCELTA_OPERATORE)) {
			azioneRilevazioneFunzioniUDC(azione, se);
		}else if(azione.equals(CHIAMATA_UDC_LISTA_UDC)) {
			azioneRilevazioneFunzioniUDC(azione, se);
		}else if(azione.equals(CONFERMA_RIPOSIZIONAMENTO_UDC)) {
			azioneConfermaRiposizionamentoUDC(se);
		}else if(azione.equals(CONFERMA_CHIAMATA_UDC) || azione.equals(CHIAMATA_UDC_SCELTA_UDC)) {
			azioneConfermaChiamataUDC(se);
		}else {
			super.otherActions(cadc, se);
		}
	}

	protected void azioneRilevazioneFunzioniUDC(String azione, ServletEnvironment se) throws ServletException, IOException {
		se.getRequest().setAttribute("Action", azione);
		String url = "";
		if(azione.equals(RIPOSIZIONA_UDC_SCELTA_OPERATORE)) {
			url = "it/dnd/thip/produzione/raccoltaDati/YRiposizionamentoUDC.jsp";
		}else if(azione.equals(CHIAMATA_UDC_SCELTA_OPERATORE) || azione.equals(CHIAMATA_UDC_LISTA_UDC)) {
			url = "it/dnd/thip/produzione/raccoltaDati/YChiamataUDC.jsp";
		}
		se.getRequest().setAttribute("JspName", url);
		se.sendRequest(getServletContext(), se.getServletPath() + "it.dnd.thip.produzione.raccoltaDati.web.AzioneRilevazioneFunzioniUdcTS", true);
	}

	protected void azioneConfermaRiposizionamentoUDC(ServletEnvironment se) throws ServletException, IOException {
		se.sendRequest(getServletContext(),  se.getServletPath() + "it.dnd.thip.produzione.raccoltaDati.web.ConfermaRiposizionamentoUDC", true);
	}

	protected void azioneConfermaChiamataUDC(ServletEnvironment se) throws ServletException, IOException {
		se.sendRequest(getServletContext(),  se.getServletPath() + "it.dnd.thip.produzione.raccoltaDati.web.ConfermaChiamataUDC", true);
	}

	protected void azioneRiposizionaUDC(ServletEnvironment se, String action) throws ServletException, IOException {
		String url = "it/dnd/thip/produzione/raccoltaDati/YRiposizionamentoUDC.jsp";
		se.getRequest().setAttribute("JspName", url); 
		se.getRequest().setAttribute("Action", action);
		se.getRequest().setAttribute("PrevJspName", "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp" + KeyHelper.KEY_SEPARATOR + "");
		se.sendRequest(getServletContext(), url, true);
	}

	protected void azioneChiamataUDC(ServletEnvironment se, String action) throws ServletException, IOException {
		String url = "it/dnd/thip/produzione/raccoltaDati/YChiamataUDC.jsp";
		se.getRequest().setAttribute("JspName", url); 
		se.getRequest().setAttribute("Action", action);
		se.getRequest().setAttribute("PrevJspName", "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp" + KeyHelper.KEY_SEPARATOR + "");
		se.sendRequest(getServletContext(), url, true);
	}
}
