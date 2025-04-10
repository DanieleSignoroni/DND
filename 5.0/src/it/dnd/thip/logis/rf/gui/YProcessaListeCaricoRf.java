package it.dnd.thip.logis.rf.gui;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.rf.driver.Driver;
import com.thera.thermfw.rf.driver.FormCreator;
import com.thera.thermfw.rf.tc.TForm;
import com.thera.thermfw.rf.tc.TList;

import it.dnd.thip.logis.bas.YCostantiDnd;
import it.dnd.thip.logis.fis.YEsecuzionePianiCarico;
import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.bas.Utente;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.logis.rf.gui.LogisRF;
import it.thera.thip.produzione.ordese.AttivitaEsecutiva;
import it.thera.thip.produzione.ordese.AttivitaEsecutivaTM;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 10/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    10/04/2025  DSSOF3   Prima stesura
 */

public class YProcessaListeCaricoRf extends LogisRF {

	public YProcessaListeCaricoRf(Driver drv, String xml) {
		super(drv, xml);
		try {
			YCostantiDnd c = new YCostantiDnd();
			FormCreator.print(c.searchXml(), this);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	protected final static int MENU = 0;
	protected final static int PRESENTAZIONE = 1;
	protected final static int SELEZIONE = 2;
	protected final static int UDC_NR_RITORNO = 3;

	protected int pagina = SELEZIONE;

	public static String RES_FILE = "it.dnd.thip.logis.rf.resources.DndLogisRf";

	protected String formPaginaSelezioneReparto = "paginaPresentazioneReparti";

	public YEsecuzionePianiCarico esecuzionePianiCarico = null;

	public ErrorMessage esegui() {
		ErrorMessage err = null;
		boolean interrompi = false;
		pagina = SELEZIONE;
		while (!interrompi) {
			switch (pagina) {
			case MENU:
				interrompi = true;
				break;
			case SELEZIONE:
				esecuzionePianiCarico = (YEsecuzionePianiCarico) Factory.createObject(YEsecuzionePianiCarico.class);
				paginaSelezioneReparto();
				break;
			case UDC_NR_RITORNO:
				paginaUdcNumeroRitorno();
				break;
			default:
				try {
					messaggio(true, ResourceLoader.getString(RESOURCES,"msg0001"));
					interrompi = true;
				} catch (Exception e) {
					e.printStackTrace(Trace.excStream);
					interrompi = true;
				}
				break;
			}
		}
		return err;
	}

	public String formPaginaUdcNumeroRitorno = "paginaUdcNumeroRitorno";

	protected void paginaUdcNumeroRitorno() {
		TForm form = getTForm(formPaginaUdcNumeroRitorno);
		ErrorMessage errore = null;
		try {
			form.getTField("FieldUdc").setValue("");
			form.getTField("FieldNumeroRitorno").setValue("");
			sendForm(form);
			TForm risposta = readInput();
			if (risposta.getKeyPressed().equals(TForm.KEY_ESC) ||
					risposta.getKeyPressed().equals(TForm.KEY_CTL_X)) {
				pagina = SELEZIONE;
				esecuzionePianiCarico.setReparto(null); //.Se torna indietro svuoto il reparto scelto
				return;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F1)) {
				errore = testPaginaUdcNumeroRitorno(form.getTField("FieldUdc").getValue(),
						form.getTField("FieldNumeroRitorno").getValue());
				if (errore == null)
					pagina = SELEZIONE;
				else {
					messaggio(true, errore.getLongText());
					esecuzionePianiCarico.setReparto(null); //.Se torna indietro svuoto il reparto scelto
					pagina = SELEZIONE;
				}
			}
		} catch(Exception e) {
			e.printStackTrace(Trace.excStream);
			pagina = MENU;
		}
		return;
	}

	@SuppressWarnings("rawtypes")
	protected ErrorMessage testPaginaUdcNumeroRitorno(String udc, String numeroRitorno) throws SQLException {
		if(udc.isEmpty() && numeroRitorno.isEmpty()) {
			return new ErrorMessage("YLOGIS0003");
		}
		if(udc != null && !udc.isEmpty()) {
			MappaUdc mappa = MappaUdc.elementWithKey(udc, PersistentObject.NO_LOCK);
			if(mappa == null) {
				return new ErrorMessage("YLOGIS0001");
			}
		}
		if(numeroRitorno != null && !numeroRitorno.isEmpty()) {
			String where = " "+AttivitaEsecutivaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' AND "+AttivitaEsecutivaTM.NUM_RITORNO+" = '"+numeroRitorno+"' ";
			try {
				Vector atvs = AttivitaEsecutiva.retrieveList(AttivitaEsecutiva.class, where, "", false);
				if(atvs.size() == 0) {
					return new ErrorMessage("YLOGIS0002");
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}

		//.Verfico se esiste un piano di carico aperto con reparto/udc scelti
		if(udc != null && !udc.isEmpty()) {
			String where = " "+YPianoCaricoToyotaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' "
					+ "AND "+YPianoCaricoToyotaTM.R_REPARTO+" = '"+esecuzionePianiCarico.getReparto().getIdReparto()+"' "
					+ "AND "+YPianoCaricoToyotaTM.R_COD_MAPPA_UDC+" = '"+udc+"' ";
			try {
				Vector piani = YPianoCaricoToyota.retrieveList(where, "", false);
				if(piani.size() == 0) {

				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}

		}
		//.Altrimenti verifico se esistono delle righe con StatoPrelievo < 2, StatoRiga A su piani di carico con reparto/udc scelti
		else if(numeroRitorno != null && !numeroRitorno.isEmpty()) {

		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	protected void paginaSelezioneReparto() {
		TForm formReparti = getTForm(formPaginaSelezioneReparto);
		try {
			Vector listaReparti = caricaRepartiServitiAgv();
			caricaListaReparti(formReparti,listaReparti);
			sendForm(formReparti);
			TForm risposta = readInput();
			if (risposta.getKeyPressed().equals(TForm.KEY_ESC) ||
					risposta.getKeyPressed().equals(TForm.KEY_CTL_X)) {
				pagina = MENU;
				return;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F1) || risposta.getKeyPressed().equals(TForm.KEY_F3)
					|| risposta.getKeyPressed().equals(TForm.KEY_F4) || risposta.getKeyPressed().equals(TForm.KEY_F6)
					|| risposta.getKeyPressed().equals(TForm.KEY_F9) || risposta.getKeyPressed().equals(TForm.KEY_F10))
				return;
			TList list = risposta.getTList("ListaReparti");
			int itemPos = list.getCurrentSelectedItem();
			list.getListSelectedItem().removeElement(new Integer(itemPos));
			list.selectCurrent();
			Reparto reparto = (Reparto) listaReparti.elementAt(itemPos - 1);
			esecuzionePianiCarico.setReparto(reparto);
			pagina = UDC_NR_RITORNO;
		} catch(Exception e) {
			e.printStackTrace(Trace.excStream);
			pagina = MENU;
		}
		return;
	}

	@SuppressWarnings("rawtypes")
	protected void caricaListaReparti(TForm form, Vector lista) {
		TList list = form.getTList("ListaReparti");
		list.resetSelected();
		Vector elencoVecchio = list.getItems();
		while (elencoVecchio.size() > 1) {
			elencoVecchio.removeElementAt(1);
		}
		for (int i = 0; i < lista.size(); i++) {
			Object obj = lista.elementAt(i);
			String item = "";
			if (obj instanceof Reparto) {
				Reparto r = (Reparto) obj;
				item = formatoReparto(form, r);
			}
			list.addItem(item);
		}
		if (lista.size() != 0) {
			list.setCurrentSelectedItem(1);
			list.setCurrentTopItem(1);
		}

	}

	protected String formatoReparto(TForm form, Reparto r) {
		String s = "";
		if(r != null) {
			s = r.getIdReparto() + "-" + r.getDescrizione().getDescrizione();
		}
		return s;
	}

	@SuppressWarnings("rawtypes")
	protected Vector caricaRepartiServitiAgv() {
		esecuzionePianiCarico.riempiElencoRepartiServitiAgv();
		return esecuzionePianiCarico.getElencoRepartiServitiAgv();
	}

	@Override
	public String getDefaultRESFile() {
		return RES_FILE;
	}
}
