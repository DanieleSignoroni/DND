package it.dnd.thip.agv.web;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.batch.BatchJob;
import com.thera.thermfw.web.WebFormModifier;

import it.dnd.thip.agv.YSchedulazioneBufferAgv;
import it.thera.thip.base.azienda.Azienda;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 04/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    04/09/2025  DSSOF3   Prima stesura
 */
public class YSchedulazioneBufferAgvModifier extends WebFormModifier
{
	public YSchedulazioneBufferAgvModifier()
	{
	}

	public void writeFormStartElements(JspWriter out) throws java.io.IOException
	{
	}
	public void writeHeadElements(JspWriter out) throws java.io.IOException
	{
		/**@todo Implement this com.thera.thermfw.web.WebFormModifier abstract method*/
	}

	@SuppressWarnings("rawtypes")
	public void writeFormEndElements(JspWriter out) throws java.io.IOException
	{
		List l = YSchedulazioneBufferAgv.cercaBatchJob(Azienda.getAziendaCorrente()); //Fix 12836
		if (l != null && l.size() > 0)
		{
			out.println("<script language='JavaScript1.2'>");
			out.println("  onload=errore");
			out.println("function errore() {");
			out.println("  var nrBatchJob = " + ((BatchJob)l.get(0)).getBatchJobId() + ";");
			out.println("  window.alert('Già attivo il servizio di schedulazione degli ordini esecutivi (vedi lavoro in coda n°' + nrBatchJob + ')');");
			out.println("}");
			out.println("</script>");
		}
	}
	public void writeBodyEndElements(JspWriter out) throws java.io.IOException
	{
		String nlsName = "";
		try
		{
			nlsName = getClassADCollection().getClassNameNLS();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		out.println("<script language=\"JavaScript1.2\">");
		out.println("   document.title = \"" + nlsName + "\";");
		out.println("   controlLabel(\"" + nlsName + "\");");
		out.println("</script>");
	}
	public void writeBodyStartElements(JspWriter out) throws java.io.IOException
	{
		/**@todo Implement this com.thera.thermfw.web.WebFormModifier abstract method*/
	}

}
