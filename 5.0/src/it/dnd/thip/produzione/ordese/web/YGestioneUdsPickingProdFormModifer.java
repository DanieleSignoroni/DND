package it.dnd.thip.produzione.ordese.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.gui.cnr.OpenType;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.WebFormModifier;

import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.bas.NumeratoreMaxException;
import it.thera.thip.logis.bas.NumeratoreMaxProgrException;
import it.thera.thip.logis.bas.NumeratoreNotFoundException;
import it.thera.thip.logis.bas.NumeratoreNotValidException;
import it.thera.thip.logis.lgb.RigaLista;

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
 * 71994	10/06/2025	DSSOF3	 Gestione funzione accodamento
 */

public class YGestioneUdsPickingProdFormModifer extends WebFormModifier {

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {
		ServletEnvironment se = getServletEnvironment();
		YGestioneUdsPickingProd bo = (YGestioneUdsPickingProd) getBODataCollector().getBo();
		if(se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null 
				&& se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y")
				&& getMode() == OpenType.NEW) {
			String idTipoUds = se.getRequest().getParameter("IdTipoUds");
			String numeroRitorno = se.getRequest().getParameter("NumeroRitorno");
			String IdCodiceRigaLista = se.getRequest().getParameter("IdCodiceRigaLista");
			String IdCodiceLista = se.getRequest().getParameter("IdCodiceLista");
			bo.setIdCodiceLista(IdCodiceLista);
			bo.setIdCodiceRigaLista(Integer.valueOf(IdCodiceRigaLista));
			bo.setNumeroRitorno(numeroRitorno);
			bo.setIdTipoUds(idTipoUds);
			RigaLista rl = null;
			try {
				rl = (RigaLista) RigaLista.elementWithKey(RigaLista.class, KeyHelper.buildObjectKey(new String[] {
						Azienda.getAziendaCorrente(),IdCodiceLista,IdCodiceRigaLista
				}), PersistentObject.NO_LOCK);
				if(rl != null) {
					bo.setIdArticolo(rl.getCodiceArticolo());
				}
			} catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
			try {
				bo.setIdUds(bo.getTipouds().getTipoCodice().dammiProssimoCodice());
			} catch (NumeratoreMaxProgrException | NumeratoreNotFoundException | InstantiationException
					| ClassNotFoundException | IllegalAccessException | NumeratoreNotValidException
					| NumeratoreMaxException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
			bo.getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
			getBODataCollector().setBo(bo);
			getBODataCollector().setOnBORecursive();
		}
		if(getMode() == OpenType.COPY && se.getRequest().getParameter("AccodamentoUdsRaccoltaDati") != null 
				&& se.getRequest().getParameter("AccodamentoUdsRaccoltaDati").equals("Y")) {
			String numeroRitorno = se.getRequest().getParameter("NumeroRitorno");
			String IdCodiceRigaLista = se.getRequest().getParameter("IdCodiceRigaLista");
			String IdCodiceLista = se.getRequest().getParameter("IdCodiceLista");
			if(numeroRitorno == null || IdCodiceRigaLista == null && IdCodiceLista == null) {
				out.println("<script>");
				out.println("window.close();");
				out.println("</script>");
				return;
			}
			bo.setIdCodiceLista(IdCodiceLista);
			bo.setNumeroRitorno(numeroRitorno);
			bo.setIdCodiceRigaLista(Integer.valueOf(IdCodiceRigaLista));
			bo.setQuantita(null);
			RigaLista rl = null;
			try {
				rl = (RigaLista) RigaLista.elementWithKey(RigaLista.class, KeyHelper.buildObjectKey(new String[] {
						Azienda.getAziendaCorrente(),IdCodiceLista,IdCodiceRigaLista
				}), PersistentObject.NO_LOCK);
				if(rl != null) {
					bo.setIdArticolo(rl.getCodiceArticolo());
				}
			} catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
			getBODataCollector().setBo(bo);
			getBODataCollector().setOnBORecursive();
		}else if(getMode() == OpenType.COPY && se.getRequest().getParameter("AccodamentoUdsRaccoltaDati") == null){
			out.println("<script>");
			out.println("window.close();");
			out.println("<script>");
		}
	}

	@Override
	public void writeBodyStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		ServletEnvironment se = getServletEnvironment();
		if(se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente") != null && se.getRequest().getParameter("MostraUdsAzioneGeneraUdsAutomaticamente").equals("Y")) {
			out.println("<input name=\"MostraUdsAzioneGeneraUdsAutomaticamente\" type=\"hidden\" value=\"Y\">");
		}
		if(se.getRequest().getParameter("AccodamentoUdsRaccoltaDati") != null && se.getRequest().getParameter("AccodamentoUdsRaccoltaDati").equals("Y")) {
			out.println("<input name=\"AccodamentoUdsRaccoltaDati\" type=\"hidden\" value=\"Y\">");
		}
	}

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {

	}

}
