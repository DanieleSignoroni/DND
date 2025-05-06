package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.WebElement;

import it.dnd.thip.logis.fis.YEsecuzionePianiCarico;
import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.fis.RigaMovimento;
import it.thera.thip.logis.fis.Saldo;
import it.thera.thip.produzione.ordese.PersDatiPrdUtenteRilev;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSFormActionAdapter;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSWebFormModifier;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 15/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    15/04/2025  DSSOF3   Prima stesura
 */

public class YRilevDatiPrdTSWebFormModifier extends RilevDatiPrdTSWebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {
		super.writeHeadElements(out);
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) getBODataCollector().getBo();
		String action = (String) getRequest().getAttribute("Action");
		if(action != null && action.equals(RilevDatiPrdTSFormActionAdapter.PRODUZIONE)) {
			boolean isListaPPREL = ((YRilevDatiPrdTS)bo).isAttivitaEsecutivaSuListaPPREL();
			if(isListaPPREL) {
				bo.valorizzaDatiPickingAutomatico();
				getBODataCollector().setBo(bo);
			}
		}
	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		super.writeFormEndElements(out);
		RilevDatiPrdTS bo = (RilevDatiPrdTS) getBODataCollector().getBo();
		String action = (String) getRequest().getAttribute("Action");
		if (action != null && (action.equals(YRilevDatiPrdTSFormActionAdapter.RIPOSIZIONA_UDC) || action.equals(YRilevDatiPrdTSFormActionAdapter.CHIAMATA_UDC))) {
			if(getRequest().getAttribute("DisplayReparti") != null && getRequest().getAttribute("DisplayReparti").equals("N")) {
				String idReparto = (String) getRequest().getAttribute("IdReparto");
				out.println("<script>");
				out.println("document.getElementById('IdMateriale1').parentNode.parentNode.style.display = displayBlock;");
				out.println("document.forms[0].IdOperatore.value = '"+idReparto+"';");
				out.println("</script>");
			}else {
				displaySceltaReparti(out, bo);
				out.println("<script>");
				out.println("parent.document.getElementById('Conferma').style.display = displayNone;"); //.Qui il btn di conferma non dev'esserci
				out.println("</script>");
			}
		}else if(action != null && (action.equals(YRilevDatiPrdTSFormActionAdapter.RIPOSIZIONA_UDC_SCELTA_OPERATORE))) {
			out.println("<script>");
			out.println("document.getElementById('IdMateriale1').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('Titolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("parent.document.getElementById('Conferma').style.display = displayBlock;");
			out.println("document.getElementById('IdMateriale1').style.background = mCo;");
			out.println("document.getElementById('IdMateriale1').focus();");
			out.println("</script>");
		}else if(action != null && (action.equals(YRilevDatiPrdTSFormActionAdapter.CHIAMATA_UDC_SCELTA_OPERATORE))) {
			out.println("<script>");
			out.println("document.getElementById('IdMateriale1').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('IdArticolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('Titolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("parent.document.getElementById('Conferma').style.display = displayBlock;");
			out.println("document.getElementById('IdMateriale1').style.background = mCo;");
			out.println("document.getElementById('IdArticolo').style.background = mCo;");
			out.println("document.getElementById('IdMateriale1').focus();");
			out.println("</script>");
		}else if(action != null && action.equals(YRilevDatiPrdTSFormActionAdapter.CHIAMATA_UDC_LISTA_UDC)) {
			out.println("<script>");
			out.println("document.getElementById('IdMateriale1').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('IdArticolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('Titolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("parent.document.getElementById('Conferma').style.display = displayBlock;");
			out.println("document.getElementById('IdMateriale1').style.background = mCo;");
			out.println("document.getElementById('IdArticolo').style.background = mCo;");
			out.println("document.getElementById('IdMateriale1').focus();");
			out.println("</script>");
			displayListaUDC(out,bo);
		}else if(action != null && action.equals(RilevDatiPrdTSFormActionAdapter.PRODUZIONE)) {
			boolean isListaPPREL = ((YRilevDatiPrdTS)bo).isAttivitaEsecutivaSuListaPPREL();
			if(!isListaPPREL) {
				out.println("<script>");
				out.println("document.getElementById('YIdTipoUds').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNumeroPzUds').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNumeroPzBauletto').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNonGestirePicking').parentNode.parentNode.style.display = displayNone;");
				out.println("</script>");
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void displayListaUDC(JspWriter out, RilevDatiPrdTS bo) throws IOException {
		HashMap<Object,BigDecimal> list = new HashMap<Object, BigDecimal>();
		if(getRequest().getAttribute("ListaSaldi") != null) {
			ArrayList<Saldo> saldi = (ArrayList<Saldo>) getRequest().getAttribute("ListaSaldi");
			for (Iterator iterator = saldi.iterator(); iterator.hasNext();) {
				Saldo saldo = (Saldo) iterator.next();
				list.put(saldo, saldo.getQta1());
			}
		}else if(getRequest().getAttribute("RigaMovimentoStorico") != null) {
			RigaMovimento rM = (RigaMovimento) getRequest().getAttribute("RigaMovimentoStorico");
			list.put(rM, rM.getQta1());
		}
		String width = "\"width:117px\"";
		if(bo.getPersDatiPrdUtenteRilev().getRisoluzioneVideo()== PersDatiPrdUtenteRilev.RISOL_800_600) {
			width = "\"width:100px\"" ;
		}
		out.println("<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%\">");
		out.println("<tr valign=\"top\">");
		out.println("<td style=\"height:0px\"></td>");
		out.println("<tr>");
		out.println("<td width=\"15px\"></td>");
		out.println("<td>");
		out.println("<td>");
		out.println("  <table id=\"extraTable\" cellpadding=\"1\" cellspacing=\"3\" class=\"monitorListTable\">");
		out.println("  <tr>");
		out.println("    <th class=\"cell\" >Mappa UDC</th>");
		out.println("    <th class=\"cell\" >Quantita'</th>");
		out.println("  </tr>");
		int index = 0;
		for (Map.Entry<Object,BigDecimal> entry : list.entrySet()) {
			String codMappaUdc = null;
			if(entry.getKey() instanceof Saldo) {
				codMappaUdc = ((Saldo)entry.getKey()).getCodiceMappaUdc();
			}else if(entry.getKey() instanceof RigaMovimento) {
				codMappaUdc = ((RigaMovimento)entry.getKey()).getMappaUdc().getCodice();
			}
			BigDecimal val = entry.getValue();
			out.println("    <tr>");
			out.println("    <td class=\"cell\" id=\"CodMappaUdcTD" + index +"\" nowrap=\"true\" >"+codMappaUdc+"</td>");
			out.println("    <td class=\"cell\" nowrap=\"true\" >"+val+"</td>");
			out.println("    <td class=\"cell\" ><button type=\"button\" onclick=\"setCurrentEvent(event);selectUDC(" + index + ")\" style="+ width +">Conferma</button></td>");
			out.println("    <td class=\"cell\" style=\"display:none\"><input type =\"text\" id=\"CodMappaUDC" + index + "\" value='" + WebElement.formatStringForHTML(codMappaUdc) + "' /></td>"); //Fix 14725
			if(entry.getKey() instanceof Saldo) {
				out.println("    <td class=\"cell\" style=\"display:none\"><input type =\"text\" id=\"SaldoKey" + index + "\" id=\"SaldoKey" + index + "\" value='" + WebElement.formatStringForHTML(((Saldo)entry.getKey()).getCodice()) + "' /></td>"); //Fix 14725
			}
			out.println("   </tr>");
			index++;
		}
		out.println("  </table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>"); //Fix 13264
		out.println("<td colspan=\"5\" style=\"height:100%\"></td>"); //Fix 13264
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"5px\">");//Fix 13175
		out.println("</td>");//Fix 13175
		out.println("<td colspan=\"5\">");
		out.println("<table cellpadding=\"3\" cellspacing=\"3\">"); //Fix 13574
		out.println("<tr>");
		out.println("<td><label class=\"labelError\" id=\"ErroriList\"></label></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}

	@SuppressWarnings("rawtypes")
	protected void displaySceltaReparti(JspWriter out, RilevDatiPrdTS bo) throws IOException {
		String width = "\"width:117px\"";
		if(bo.getPersDatiPrdUtenteRilev().getRisoluzioneVideo()== PersDatiPrdUtenteRilev.RISOL_800_600) {
			width = "\"width:100px\"" ;
		}
		out.println("<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%\">");
		out.println("<tr valign=\"top\">");
		out.println("<td style=\"height:0px\"></td>");
		out.println("<tr>");
		out.println("<td width=\"15px\"></td>");
		out.println("<td>");
		out.println("<td>");
		out.println("  <table id=\"extraTable\" cellpadding=\"1\" cellspacing=\"3\" class=\"monitorListTable\">");
		out.println("  <tr>");
		out.println("    <th class=\"cell\" >Reparto</th>");
		out.println("    <th class=\"cell\" >Descrizione</th>");
		out.println("  </tr>");
		int index = 0;
		YEsecuzionePianiCarico esecuzionePianiCarico = (YEsecuzionePianiCarico) Factory.createObject(YEsecuzionePianiCarico.class);
		esecuzionePianiCarico.riempiElencoRepartiServitiAgv();
		Iterator iter = esecuzionePianiCarico.getElencoRepartiServitiAgv().iterator();
		while (iter.hasNext()) {
			Reparto reparto = (Reparto) iter.next();
			out.println("    <tr>");
			out.println("    <td class=\"cell\" id=\"IdRepartoTD" + index +"\" nowrap=\"true\" >"+reparto.getIdReparto()+"</td>");
			out.println("    <td class=\"cell\" nowrap=\"true\" >"+reparto.getDescrizione().getDescrizione()+"</td>");
			out.println("    <td class=\"cell\" ><button type=\"button\" onclick=\"setCurrentEvent(event);selectReparto(" + index + ")\" style="+ width +">Seleziona</button></td>");
			out.println("    <td class=\"cell\" style=\"display:none\"><input type =\"text\" id=\"IdOperatore" + index + "\" value='" + WebElement.formatStringForHTML(reparto.getIdReparto()) + "' /></td>"); //Fix 14725
			out.println("   </tr>");
			index++;
		}
		out.println("  </table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>"); //Fix 13264
		out.println("<td colspan=\"5\" style=\"height:100%\"></td>"); //Fix 13264
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"5px\">");//Fix 13175
		out.println("</td>");//Fix 13175
		out.println("<td colspan=\"5\">");
		out.println("<table cellpadding=\"3\" cellspacing=\"3\">"); //Fix 13574
		out.println("<tr>");
		out.println("<td><label class=\"labelError\" id=\"ErroriList\"></label></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}
}
