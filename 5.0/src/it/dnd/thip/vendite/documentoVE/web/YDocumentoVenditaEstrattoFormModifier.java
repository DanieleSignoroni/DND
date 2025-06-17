package it.dnd.thip.vendite.documentoVE.web;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.web.WebJSTypeList;

import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaEstrattoFormModifier;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 17/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    17/06/2025  DSSOF3   Prima stesura
 */

public class YDocumentoVenditaEstrattoFormModifier extends DocumentoVenditaEstrattoFormModifier {

	protected static final String RES = "it.dnd.thip.vendite.documentoVE.resources.YDocumentoVendita";

	public void writeHeadElements(JspWriter out) throws java.io.IOException {
		super.writeHeadElements(out);
		out.println(WebJSTypeList.getImportForJSLibrary("it/dnd/thip/vendite/documentoVE/YDocumentoVenditaEstratto.js", getServletEnvironment().getRequest()));
	}

	@Override
	public void writePulsantiBarraAzioniPers(JspWriter out) throws IOException {
		super.writePulsantiBarraAzioniPers(out);
		out.println("<td nowrap=\"true\" height=\"0\">");
		out.println("<button name=\"thInviaListaPrlLeanLift\" id=\"thInviaListaPrlLeanLift\" onclick=\"inviaListaPrlLeanLift()\" style=\"width:" + widthBtnBarraAzioniStandard + ";height:30px;\" type=\"button\" title=\"" + ResourceLoader.getString(RES, "InviaListaPrlLeanLift") + "\">");
		out.println("<img border=\"0\" width=\"" + widthImgBarraAzioniStandard + "\" height=\"24px\" src=\"" + getIconaBarraAzioniStandard("it/thera/thip/base/documenti/images/ApriTestata.gif") + "\" >");
		out.println("</button>");
		out.println("</td>");
	}
}
