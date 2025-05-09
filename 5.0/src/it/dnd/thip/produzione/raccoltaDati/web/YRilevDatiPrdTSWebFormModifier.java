package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.Q6Calc;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.WebElement;

import it.dnd.thip.logis.fis.YEsecuzionePianiCarico;
import it.dnd.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.fis.Missione;
import it.thera.thip.logis.fis.RigaMovimento;
import it.thera.thip.logis.fis.Saldo;
import it.thera.thip.produzione.ordese.AttivitaEsecMateriale;
import it.thera.thip.produzione.ordese.PersDatiPrdUtenteRilev;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdRig;
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
 * 71946	02/05/2025	DSSOF3	 Gestione nuove azioni
 * 71953	09/05/2025	DSSOF3	 Gestione nuovi attributi MappaUdc (1-20), picking automatico in dichiarazione prelievi.
 */

public class YRilevDatiPrdTSWebFormModifier extends RilevDatiPrdTSWebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {
		super.writeHeadElements(out);
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) getBODataCollector().getBo();
		String action = (String) getRequest().getAttribute("Action");
		if(action != null && action.equals(RilevDatiPrdTSFormActionAdapter.PRODUZIONE)) { //71946
			boolean isListaPPREL = ((YRilevDatiPrdTS)bo).checkAttivitaEsecutivaSuListaPVENL();
			if(isListaPPREL) {
				bo.valorizzaDatiPickingAutomatico();
				getBODataCollector().setBo(bo);
			}
		}
	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		super.writeFormEndElements(out);
		YRilevDatiPrdTS bo = (YRilevDatiPrdTS) getBODataCollector().getBo();
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
		}else if(action != null && action.equals(RilevDatiPrdTSFormActionAdapter.PRODUZIONE)) { //71946
			boolean isListaPPREL = ((YRilevDatiPrdTS)bo).checkAttivitaEsecutivaSuListaPVENL();
			if(!isListaPPREL) {
				out.println("<script>");
				out.println("document.getElementById('YIdTipoUds').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNumeroPzUds').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNumeroPzBauletto').parentNode.parentNode.style.display = displayNone;");
				out.println("document.getElementById('YNonGestirePicking').parentNode.parentNode.style.display = displayNone;");
				out.println("</script>");
			}else {
				//Li metto come mandatory
				out.println("<script>");
				out.println("setFieldMandatory('YIdTipoUds',true);");
				out.println("setFieldMandatory('YNumeroPzUds',true);");
				out.println("setFieldMandatory('YNumeroPzBauletto',true);");
				out.println("</script>");
			}
		}else if(action != null && action.equals(RilevDatiPrdTSFormActionAdapter.SUCCESSIVO) && bo.getTipoTimbratura() == RilevazioneDatiProdRig.FINE) {
			//.Se sto passando alla pagina successiva (dove viene creato il doc prd) e ho il flag acceso
			//.devo scriverlo nella form in modo da averlo poi nella save
			if(bo.isYNonGestirePicking()) {
				out.println("<input name=\"YNonGestirePicking\" type=\"hidden\" value=\"Y\">");
			}
			out.println("<script>");
			out.println("document.getElementById('LabelPers1').style.display = displayBlock;");
			out.println("document.getElementById('LabelPers1').innerHTML = 'UDC';");
			out.println("</script>");
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

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] initRigaDaOrdineEsec(RilevDatiPrdTS bo, AttivitaEsecMateriale atvEsecMat, int i) {
		try {
			String setterUdc = "setCodiceMappaUdc" + String.valueOf(i);
			Class<?> c = Factory.getClass(bo.getClass());
			Method udcMethod = c.getMethod(setterUdc, new Class[] { String.class });
			udcMethod.invoke(bo, new Object[] { "UDC" });
		} catch (Exception e) {
			e.printStackTrace(Trace.excStream);
		}
		Object[] result = new Object[2];
		List missioni = YRilevDatiPrdTS.trovaMissioniAttivitaEsecutivaMateriale(atvEsecMat);
		try {
			List lotti = recuperaLottiMat(bo, atvEsecMat);
			Iterator iter = lotti.iterator();
			while (iter.hasNext()) {
				Object[] obj = (Object[]) iter.next();
				String idLotto = (String) obj[0];
				BigDecimal qta = (BigDecimal) obj[1];
				if(missioni.size() > 0) {
					Iterator iterMissioni = missioni.iterator();
					while(iterMissioni.hasNext()) {
						Missione m = (Missione) iterMissioni.next();
						valorizzaRighe(bo, qta, idLotto, i, atvEsecMat,m);

						//.Se ho solo una missione, allora il scrivo una variabile che mi mettera in read only il campo qtaPrel
						if(atvEsecMat.getIdMagazzinoPrl().equals("001") && missioni.size() == 1) {
							JspWriter out = this.webForm.getJspWriter();
							out.println("<script language='JavaScript1.2'>");
							String var = " var isQtaPrelevataUMPrm"+i+"Enabled=false";
							out.println(var+";");
							out.println("</script>");
						}
						i++;
						if (i > 20) {
							bo.setCurrentNumPag((i / 20) + bo.getCurrentNumPag());
							bo.setIdAzienda(bo.getIdAzienda());
							i = 1;
						}
					}
				}else {
					valorizzaRighe(bo, qta, idLotto, i, atvEsecMat,null);
					i++;
					if (i > 20) {
						bo.setCurrentNumPag((i / 20) + bo.getCurrentNumPag());
						bo.setIdAzienda(bo.getIdAzienda());
						i = 1;
					}
				}
			}
			result[0] = bo;
			result[1] = new Integer(i);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void valorizzaRighe(RilevDatiPrdTS bo, BigDecimal qta,
			String idLotto, int i,
			AttivitaEsecMateriale atvEsecMat, Missione m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (qta.compareTo(new BigDecimal(0)) == 0) {
			//qta = null; //Fix 25930 commento
			idLotto = null;
		}
		String setterPrd = "setIdMateriale" + String.valueOf(i);
		String setterVers = "setIdVersione" + String.valueOf(i);
		String setterCfg = "setIdConfigurazione" + String.valueOf(i);
		String setterMag = "setIdMagazzinoPrl" + String.valueOf(i);
		String setterQta = "setQtaPrlUmPrm" + String.valueOf(i);
		String setterQtaSec = "setQtaPrlUmSec" + String.valueOf(i);
		String setterIdLot = "setIdLotto" + String.valueOf(i);
		String setterDescMat = "setDescrizioneMateriale" + String.valueOf(i);
		String setterCodMappaUdc = "setCodiceMappaUdc" + String.valueOf(i);

		//Fix 26027 inizio
		String setterEster = "setIdEsternoConfig"+String.valueOf(i);
		//Fix 26027 fine

		Class c = Factory.getClass(bo.getClass());
		Method matMethod = c.getMethod(setterPrd, new Class[] { String.class });
		Method versMethod = c.getMethod(setterVers, new Class[] { Integer.class });
		Method cfgMethod = c.getMethod(setterCfg, new Class[] { Integer.class });
		Method magMethod = c.getMethod(setterMag, new Class[] { String.class });
		Method qtaMethod = c.getMethod(setterQta, new Class[] { BigDecimal.class });
		Method qtaSecMethod = c.getMethod(setterQtaSec, new Class[] { BigDecimal.class });
		Method idLotMethod = c.getMethod(setterIdLot, new Class[] { String.class });
		Method descMatMethod = c.getMethod(setterDescMat, new Class[] { String.class });
		Method codMappaUdcMethod = c.getMethod(setterCodMappaUdc, new Class[] { String.class });

		//Fix 26027 inizio
		Method EsternMethod = c.getMethod(setterEster, new Class[] { String.class });
		EsternMethod.invoke(bo, new Object[] { atvEsecMat.getIdEsternoConfig()});
		//Fix 26027 fine

		matMethod.invoke(bo, new Object[] { atvEsecMat.getIdArticolo() });
		versMethod.invoke(bo, new Object[] { atvEsecMat.getIdVersione() });
		cfgMethod.invoke(bo, new Object[] { atvEsecMat.getIdConfigurazione() });
		magMethod.invoke(bo, new Object[] { atvEsecMat.getIdMagazzinoPrl() });

		if(m != null)
			qta = m.getQta1Richiesta();

		qtaMethod.invoke(bo, new Object[] { qta });
		codMappaUdcMethod.invoke(bo, new Object[] {m != null ? m.getCodiceMappaUdc() : null});
		Articolo articolo = atvEsecMat.getArticolo();
		if (articolo != null && articolo.getIdUMSecMag() != null) {
			BigDecimal qtaSec = articolo.convertiUM(qta, articolo.getUMPrmMag(), articolo.getUMSecMag(),
					atvEsecMat.getVersione());
			if (qtaSec != null) //Fix 39755
				qtaSec = Q6Calc.get().setScale(qtaSec, 2, BigDecimal.ROUND_HALF_UP); //Fix 39755
			qtaSecMethod.invoke(bo, new Object[] { qtaSec });
		}
		if (idLotto != null)
			idLotMethod.invoke(bo, new Object[] { idLotto });

		if (atvEsecMat.getDescrizione() != null) {
			descMatMethod.invoke(bo, new Object[] { atvEsecMat.getDescrizione().getDescrizione() });
		}
	}
}
