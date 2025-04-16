package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.WebElement;

import it.dnd.thip.logis.fis.YEsecuzionePianiCarico;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.produzione.ordese.PersDatiPrdUtenteRilev;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
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
 * 71XXX    15/04/2025  DSSOF3   Prima stesura
 */

public class YRilevDatiPrdTSWebFormModifier extends RilevDatiPrdTSWebFormModifier {

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		super.writeFormEndElements(out);
		RilevDatiPrdTS bo = (RilevDatiPrdTS) getBODataCollector().getBo();
		String action = (String) getRequest().getAttribute("Action");
		if (action != null && (action.equals(YRilevDatiPrdTSFormActionAdapter.RIPOSIZIONA_UDC))) {
			if(getRequest().getAttribute("DisplayReparti") != null && getRequest().getAttribute("DisplayReparti").equals("N")) {
				String idReparto = (String) getRequest().getAttribute("IdReparto");
				out.println("<script>");
				out.println("document.getElementById('BollaLavorazione').parentNode.parentNode.style.display = displayBlock;");
				out.println("document.forms[0].IdOperatore.value = '"+idReparto+"';");
				out.println("</script>");
			}else {
				displaySceltaReparti(out, bo);
			}
		}else if(action != null && (action.equals(YRilevDatiPrdTSFormActionAdapter.RIPOSIZIONA_UDC_SCELTA_OPERATORE))) {
			out.println("<script>");
			out.println("document.getElementById('BollaLavorazione').parentNode.parentNode.style.display = displayBlock;");
			out.println("document.getElementById('Titolo').parentNode.parentNode.style.display = displayBlock;");
			out.println("parent.document.getElementById('Conferma').style.display = displayBlock;");
			out.println("document.getElementById('BollaLavorazione').style.background = mCo;");
			out.println("document.getElementById('BollaLavorazione').focus();");
			out.println("</script>");
		}
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
