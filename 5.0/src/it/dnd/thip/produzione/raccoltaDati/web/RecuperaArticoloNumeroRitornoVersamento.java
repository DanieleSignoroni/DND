package it.dnd.thip.produzione.raccoltaDati.web;

import java.io.PrintWriter;
import java.util.Vector;

import org.json.JSONObject;

import com.thera.thermfw.persist.Column;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.BaseServlet;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.produzione.ordese.AttivitaEsecutiva;
import it.thera.thip.produzione.ordese.AttivitaEsecutivaTM;

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
 * 71XXX    28/05/2025  DSSOF3   Prima stesura
 */

public class RecuperaArticoloNumeroRitornoVersamento extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	protected void processAction(ServletEnvironment se) throws Exception {
		String numeroRitornoVersamento = getStringParameter(se.getRequest(), "NumeroRitornoVersamento");
		if(numeroRitornoVersamento != null) {
			JSONObject jsonObj = new JSONObject();

			String where = " "+AttivitaEsecutivaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"'";
			where += " AND "+AttivitaEsecutivaTM.NUM_RITORNO+" = '"+numeroRitornoVersamento+"'";
			where += " AND "+AttivitaEsecutivaTM.ATV_FINALE+" = '"+Column.TRUE_CHAR+"'";
			Vector atvs = AttivitaEsecutiva.retrieveList(AttivitaEsecutiva.class, where, "", false);
			if(atvs.size() > 0) {
				AttivitaEsecutiva attivita = (AttivitaEsecutiva) atvs.get(0);
				jsonObj.put("IdArticolo", attivita.getOrdineEsecutivo().getIdArticolo());
			}

			se.getResponse().setContentType("text/html; charset=UTF-8");
			PrintWriter out = se.getResponse().getWriter();
			out.print(jsonObj);
			out.flush();
		}

	}

}
