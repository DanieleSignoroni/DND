package it.dnd.thip.logis.rf.gui;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.rf.driver.Driver;
import com.thera.thermfw.rf.driver.FormCreator;
import com.thera.thermfw.rf.tc.TField;
import com.thera.thermfw.rf.tc.TForm;
import com.thera.thermfw.rf.tc.TList;

import it.dnd.thip.logis.bas.YCostantiDnd;
import it.dnd.thip.logis.fis.YEsecuzionePianiCarico;
import it.dnd.thip.logis.lgb.StatoPrelievoRigaToyota;
import it.dnd.thip.logis.lgb.StatoPrelievoUdcToyota;
import it.dnd.thip.logis.lgb.StatoRigaToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyota;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.logis.bas.Attributo;
import it.thera.thip.logis.bas.ParametriLogis;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.logis.fis.Missione;
import it.thera.thip.logis.prd.CampoTrascodificaGruppo;
import it.thera.thip.logis.prd.ConfigurazioneArticolo;
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
			FormCreator.print(YCostantiDnd.searchXml(), this);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	protected final static int MENU = 0;
	protected final static int PRESENTAZIONE = 1;
	protected final static int SELEZIONE = 2;
	protected final static int UDC_NR_RITORNO = 3;
	protected final static int RIPOSIZ_UDC_MAGAZZINO = 4;
	protected final static int ESECUZIONE_CARICO = 5;

	protected final static int OK = 0;
	protected final static int CONFERMA = 1;
	protected final static int PROX_MISS = 2;
	protected final static int PREC_MISS = 3;
	protected final static int NEXT_N_MISS = 4;
	protected final static int PREC_N_MISS = 5;
	protected final static int NUOVA_UDS = 6;
	protected final static int CLR = 7;
	protected final static int RIPETI = 8;
	protected final static int SALTA_MISS = 9;
	protected final static int ERR_GRAVE = 99;
	protected final static int ERRORE = 100;
	protected final static int SALTO_MISSIONI = 10;

	protected int pagina = SELEZIONE;

	public static final String RES_FILE = "it.dnd.thip.logis.rf.resources.DndLogisRf";

	protected String formPaginaSelezioneReparto = "paginaPresentazioneReparti";

	public YEsecuzionePianiCarico esecuzionePianiCarico = null;

	protected boolean flagAvanti = true;
	protected boolean flagIndietro = false;

	protected boolean naviga = true;

	protected boolean gestioneUdsInCorso = true;

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
			case RIPOSIZ_UDC_MAGAZZINO:
				paginaRiposizionamentoUdcMagazzino();
				break;
			case ESECUZIONE_CARICO: 
				paginaEsecuzioneCarico();
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

	public String formPaginaEsecuzioneCarico = "visualizzaMissioneUds";

	protected void paginaEsecuzioneCarico() {
		if(esecuzionePianiCarico.getElencoRighe().size() == 0) {
			try {
				messaggio(true, ResourceLoader.getString(RES_FILE, "noPrelieviEsecuzioneCarico"));
			} catch (Exception ex) {
				ex.printStackTrace(Trace.excStream);
			}
			pagina = UDC_NR_RITORNO;
			return;
		}
		int dim = esecuzionePianiCarico.getElencoRighe().size();
		int res = 0;                            // Esito esecuzione.
		boolean stop = false;
		boolean out = false;
		flagAvanti = naviga &&
				(esecuzionePianiCarico.getElencoRighe().size() > 1 ||
						esecuzionePianiCarico.getElencoBidoneMissioni().size() > 1);
		flagIndietro = false;
		while (!stop &&
				esecuzionePianiCarico.getNumMissConfermate() < dim &&
				esecuzionePianiCarico.getPosMiss() >= 0 &&
				esecuzionePianiCarico.getPosMiss() < dim) {
			esecuzionePianiCarico.setRigaPianoCaricoInConferma((YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(esecuzionePianiCarico.getPosMiss()));
			res = visualizzaMissione();   // Esegui missione.
			switch (res) {
			case SALTA_MISS:
				if (esecuzionePianiCarico.getElencoBidoneMissioniSaltate().isEmpty())
					break;
				Missione mSaltata = (Missione) esecuzionePianiCarico.getElencoBidoneMissioniSaltate().lastElement();
				if (cancellaSaltata(mSaltata)) {
					int num = esecuzionePianiCarico.getNumMissConfermate();
					esecuzionePianiCarico.setNumMissConfermate(++num);
				}
				break;
			case CONFERMA:  // Missione confermata.
			int num = esecuzionePianiCarico.getNumMissConfermate();
			esecuzionePianiCarico.setNumMissConfermate(++num);
			if (!cercaMissioneAvanti())       // Cerca tra le missioni successive.
				stop =  true;
			if (stop) {                       // Non trovata quindi ...
				if (cercaMissioneIndietro())    // ... cerca tra le missioni precedenti.
					stop = false;
			}
			break;
			case PROX_MISS: // Missione saltata.
				flagIndietro = naviga && true;
				if (!cercaMissioneAvanti())       // Cerca tra le missioni successive.
					stop = true;
				break;
			case PREC_MISS: // Missione saltata.
				flagAvanti = naviga && true;
				if (!cercaMissioneIndietro())     // Cerca tra le missioni precedenti.
					stop = true;
				break;
			case NEXT_N_MISS:     // Salta avanti di N missione.
				flagIndietro = naviga;
				if (!saltaAvantiMissioni())       // Cerca tra le missioni successive.
					stop = true;
				break;
			case PREC_N_MISS:     // Salta indietro di N missione.
				flagAvanti = naviga ;
				if (!saltaIndietroMissioni())     // Cerca tra le missioni precedenti.
					stop = true;
				break;
			case CLR:       // Esci.
				stop = true;
				break;
			case ERR_GRAVE: // Torna al menù principale.
				out = true;
				stop = true;
				break;
			case RIPETI:    // Ripropone la missione.
			case ERRORE:
			default:        // Errore.
				break;                            // Ripropone la stessa missione.
			}                 // Rileggo per caricare anche le eventuali missioni aggiunte.
			dim = esecuzionePianiCarico.getElencoRighe().size();
		}
		if (out)
			pagina = MENU;
		else
			pagina = UDC_NR_RITORNO;

	}

	/**
	 * Metodo chiamato dalla classi eredi.
	 */
	protected boolean cancellaSaltata(Missione m) {
		return false;
	}

	public boolean chkTastoFunc(TForm risposta){
		boolean chkTastoFunc = false;
		String bc = risposta.getTField("BarcodeTxt").getValue();
		if (bc != null &&
				!bc.equals(""))
			chkTastoFunc = true;
		if (!chkTastoFunc) {
			String qc = risposta.getTField("QtaConfermataTxt").getValue();
			if (qc != null &&
					!qc.equals("") &&
					!qc.equals("0"))
				chkTastoFunc = true;
		}
		return chkTastoFunc;

	}

	@SuppressWarnings("unchecked")
	protected int visualizzaMissione() {
		YPianoCaricoToyotaRiga m = esecuzionePianiCarico.getRigaPianoCaricoInConferma();
		try {
			if (m.isOnDB()) {   // Se era su DB è possibile che ci siano stati interventi dall'esterno.
				m.retrieve(PersistentObject.NO_LOCK);
				if (m.getStatoRiga() != StatoRigaToyota.APERTA)
					return CONFERMA;
			}
			TForm form = getTForm(formPaginaEsecuzioneCarico);
			settaDatiForm(form, m);
			sendForm(form);
			TForm risposta = readInput();
			boolean chkTastoFunc = this.chkTastoFunc(risposta);
			//26.11.14 - fine
			if (risposta.getKeyPressed().equals(TForm.KEY_F2) ||
					(risposta.getKeyPressed().equals(TForm.KEY_F8) &&
							!gestioneUdsInCorso)) {
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				return RIPETI;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_ESC) ||
					risposta.getKeyPressed().equals(TForm.KEY_CTL_X)) {  // Esci
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				return CLR;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F7) &&
					flagIndietro) {                                      // Missione precedente.
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				return PREC_MISS;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F9) &&
					flagAvanti) {                                        // Missione successiva
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata.");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				esecuzionePianiCarico.getElencoBidoneMissioniSaltate().removeElement(m);
				esecuzionePianiCarico.getElencoBidoneMissioniSaltate().addElement(m);
				return PROX_MISS;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F4) &&
					flagIndietro) {                                      // Missione precedente.
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				return PREC_N_MISS;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F6) &&
					flagAvanti) {                                         // Missione successiva
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				esecuzionePianiCarico.getElencoBidoneMissioniSaltate().removeElement(m);
				esecuzionePianiCarico.getElencoBidoneMissioniSaltate().addElement(m);
				return NEXT_N_MISS;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F3) &&
					gestioneUdsInCorso) {                                 // Richiesta nuova UDS.
				if (chkTastoFunc)
					//Fix 15944 messaggio(false, "NON hai confermato la missione: lascia il materiale al posto oppure spostalo con la funzione dedicata..");
					messaggio(false, ResourceLoader.getString(RESOURCES, "msg0025"));
				return NUOVA_UDS;
			}
		} catch (Exception e) {
			e.printStackTrace(Trace.excStream);
			return ERR_GRAVE;
		}
		return ERRORE;
	}

	protected void settaDatiForm(TForm form, YPianoCaricoToyotaRiga riga) {
		Missione m = riga.getMissione();
		if (m == null) {
			return;
		}

		form.getTField("ArticoloMatricolato").setVisible(false);
		form.getTField("ArticoloMatricolato").setValue("");

		form.getTField("TitoloLbl").setValue(formatoPosizione());
		form.getTField("UMLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.UM.label"));
		form.getTField("ArticoloLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Art.label"));
		form.getTField("VersioneLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Versione.label"));
		form.getTField("Lotto1Lbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Lottto1.label"));
		form.getTField("Lotto2Lbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Lottto2.label"));
		form.getTField("UbicSaldoLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.UbicSaldo.label"));
		form.getTField("UdcLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Udc.label"));
		form.getTField("UbicDestLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.UbicDest.label"));
		form.getTField("QtaGiacienzaLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.QtaGia.label"));
		form.getTField("QtaDisponibileLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.QtaDisp.label"));
		form.getTField("BarcodeLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Barcode.label"));
		form.getTField("QtaRichiestaLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.QtaRich.label"));
		form.getTField("QtaConfermataLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.QtaConf.label"));
		form.getTField("UDSLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.UDS.label"));
		form.getTField("PuntoCaricoLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.PuntoCarico.label"));

		if (true){
			form.getTField("UDSLbl").setValue("");
			form.getTField("UDSTxt").setValue("");
			form.getTField("UDSTxt").setDisplay(TField.DISPLAY_OUTPUT);
		}
		/*else {
			form.getTField("UDSTxt").setDisplay(TField.DISPLAY_INPUT);
		}*/

		if (m.getArticolo().getGruppo().getAbilVersione())
			form.getTField("VersioneVal").setValue(m.getArticolo().getVersione());
		else
			form.getTField("VersioneLbl").setValue("");

		gestioneLotto(form, m);
		gestioneConfigurazione(form, m);

		form.getTField("UMVal").setValue(formato(m.getArticolo().getUmBase(), 2));
		form.getTField("CodiceArticoloVal").setValue(formato(m.getArticolo().getCodice(), 17));
		form.getTField("DescrArticoloVal").setValue(formato(m.getArticolo().getDescrizione(), 21));

		form.getTField("UbicSaldoVal").setValue(formato(m.getSaldo().getCodiceUbicazione(), 17));
		form.getTField("UbicDestVal").setValue(formato(m.getCodiceUbicazioneInv(), 17));
		gestioneUdc(form, m);

		form.getTField("QtaGiacienzaVal").setValue(formattaBigDec(m.getSaldo().getQta1()));
		BigDecimal qtaDisp = m.getSaldo().calcolaDisponibile().add(m.getQta1Richiesta().min(m.getSaldo().getQta1()));
		form.getTField("QtaDisponibileVal").setValue(formattaBigDec(qtaDisp));
		form.getTField("QtaRichiestaVal").setValue(formattaBigDec(m.getQta1Richiesta()));

		form.getTField("QtaConfermataTxt").setVisible(true);
		form.getTField("QtaConfermataLbl").setVisible(true);
		form.getTField("QtaConfermataTxt").setValue("0");
		form.getTField("QtaConfermataLbl").setValue(ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.QtaConf.label"));
		form.getTField("QtaConfermataTxt").setDisplay(TField.DISPLAY_INPUT);

		form.getTField("TastiFunzioneUltimaLbl").setValue(formatoTastiFunzioneBassi());
	}

	protected void gestioneUdc(TForm form, Missione m) {
		String mappaUdc = formato(m.getCodiceMappaUdc(), 17);
		boolean mappaUdcVisible = (mappaUdc.length() > 0);
		form.getTField("UdcVal").setValue(mappaUdc);
		form.getTField("UdcLbl").setVisible(mappaUdcVisible);
		form.getTField("UdcVal").setVisible(mappaUdcVisible);
		if (!mappaUdcVisible) {
			form.getTField("UdcLbl").setValue("");
		}
	}

	protected void gestioneLotto(TForm form, Missione m) {
		String lotto = null;
		if (m.getArticolo().getGruppo().getLotti().size() > 0) {
			CampoTrascodificaGruppo campo = (CampoTrascodificaGruppo) m.getArticolo().getGruppo().getLotti().get(0);
			if (campo.getAbilitazione() && (m.getLotto1() != null)) {
				lotto = m.getLotto1().trim();
			}
		}
		lotto = formato(lotto, 17);
		form.getTField("Lotto1Val").setValue(lotto);
		boolean lotto1Visible = lotto.length() > 0;
		form.getTField("Lotto1Lbl").setVisible(lotto1Visible);
		form.getTField("Lotto1Val").setVisible(lotto1Visible);
		if (!lotto1Visible) {
			form.getTField("Lotto1Lbl").setValue("");
		}
	}

	protected void gestioneConfigurazione(TForm form, Missione m) {
		String configurazione = null;
		if (m.getArticolo().getGruppo().getLotti().size() > 1) {
			CampoTrascodificaGruppo campo = (CampoTrascodificaGruppo) m.getArticolo().getGruppo().getLotti().get(1);
			if (campo.getAbilitazione() && (m.getLotto2() != null)) {
				configurazione = m.getLotto2().trim();
				if (ParametriLogis.INSTALL_PANTHERA) {
					String idEst = ConfigurazioneArticolo.getIdEsternoConfigurazione(m.getCodiceSocieta(), m.getLotto2());
					configurazione = idEst.trim();
				}
			}
		}
		configurazione = formato(configurazione, 17);
		form.getTField("Lotto2Val").setValue(configurazione);
		boolean lotto2Visible = configurazione.length() > 0;
		form.getTField("Lotto2Lbl").setVisible(lotto2Visible);
		form.getTField("Lotto2Val").setVisible(lotto2Visible);
		if (!lotto2Visible) {
			form.getTField("Lotto2Lbl").setValue("");
		}
	}

	protected String formato(String value, int length) {
		if (value == null) {
			return "";
		}

		if (value.length() > length) {
			return value.substring(0, length);
		}

		return value;
	}

	protected String formatoPosizione() {
		int numMiss = esecuzionePianiCarico.getPosMiss() + 1;
		String res = "";
		res = "> " + ResourceLoader.getString(RESOURCES, "visualizzaMissioneUds.Missione.label") + " ";
		res += numMiss + "/" + esecuzionePianiCarico.getElencoRighe().size();
		if (res.length() > 16) {
			res = res.substring(0, 16);
		}
		return res;
	}

	protected String formatoTastiFunzioneBassi() {
		String tasti = "";
		if (flagIndietro){
			tasti = "<F7";
		}

		tasti += Attributo.formatta("", 2);
		if (flagAvanti){
			if(tasti.length() > 0){
				tasti += Attributo.formatta("", 2);	
			}
			tasti += "F9>";
		}

		while (tasti.length() < 14) {
			tasti += " ";
		}

		return tasti;
	}

	/**
	 * Cerca una missione in esecuzione tra quelle precedenti a quella corrente.
	 */
	protected boolean cercaMissioneIndietro() {
		boolean trovato = false;
		// Cerca la prossima missione in esecuzione da confermare ...
		for (int i = esecuzionePianiCarico.getPosMiss() - 1; i >= 0; i--) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				esecuzionePianiCarico.setPosMiss(i);
				trovato = true;
				break;
			}
		}
		flagIndietro = false;
		if (!trovato)         // ... missione non trovato => stop.
			return false;
		// ... trovata. Ne cerca altre per il 'flagIndietro'.
		for (int i = esecuzionePianiCarico.getPosMiss() - 1; i >= 0 && naviga; i--) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				esecuzionePianiCarico.setPosMiss(i);
				trovato = true;
				break;
			}
		}
		return true;
	}

	/**
	 * Cerca una missione in esecuzione tra quelle successive a quella corrente.
	 */
	protected boolean cercaMissioneAvanti() {
		boolean trovato = false;
		int dim = esecuzionePianiCarico.getElencoRighe().size();
		// Cerca la prossima missione in esecuzione da confermare ...
		for (int i = esecuzionePianiCarico.getPosMiss() + 1; i < dim; i++) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				esecuzionePianiCarico.setPosMiss(i);
				trovato = true;
				break;
			}
		}
		flagAvanti = false;
		if (!trovato)
			return false;     // ... nessuna missione in esecuzione trovata => stop.
		// ... trovata. Cerca eventuali altre missioni in esec. per il 'flagAvanti'.
		for (int i = esecuzionePianiCarico.getPosMiss() + 1; i < dim && naviga; i++) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				esecuzionePianiCarico.setPosMiss(i);
				trovato = true;
				break;
			}
		}
		return true;
	}

	/**
	 * Cerca una missione in esecuzione tra quelle precedenti a quella corrente
	 * provando ad andare indietro di N missioni.
	 */
	protected boolean saltaIndietroMissioni() {
		boolean trovato = false;
		int saltate = 0;
		int lastExec = esecuzionePianiCarico.getPosMiss() - 1;
		for (int i = esecuzionePianiCarico.getPosMiss() - 1; i >= 0 && !trovato; i--) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				saltate++;
				lastExec = i;
				if (saltate == SALTO_MISSIONI ||
						i == 0) {
					esecuzionePianiCarico.setPosMiss(i);
					trovato = true;
					break;
				}
			}
		}
		if (!trovato &&
				lastExec < esecuzionePianiCarico.getPosMiss() - 1) {
			esecuzionePianiCarico.setPosMiss(lastExec);
			trovato = true;
		}
		flagIndietro = false;
		if (!trovato) {         // ... missione non trovato => stop.
			return false;
		}
		// ... trovata. Ne cerca altre per il 'flagIndietro'.
		for (int i = esecuzionePianiCarico.getPosMiss() - 1; i >= 0 && naviga; i--) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				flagIndietro = naviga && true;
				break;
			}
		}
		return true;
	}

	/**
	 * Cerca una missione in esecuzione tra quelle successive a quella corrente, saltando di N.
	 */
	protected boolean saltaAvantiMissioni() {
		boolean trovato = false;
		int dim = esecuzionePianiCarico.getElencoRighe().size();
		int saltate = 0;
		int lastExec = 0;
		for (int i = esecuzionePianiCarico.getPosMiss() + 1; i < dim; i++) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				saltate++;
				lastExec = i;
				if (saltate == SALTO_MISSIONI ||
						i == (dim - 1)) {
					esecuzionePianiCarico.setPosMiss(i);
					trovato = true;
					break;
				}
			}
		}
		if (!trovato && lastExec > 0) {
			esecuzionePianiCarico.setPosMiss(lastExec);
			trovato = true;
		}
		flagAvanti = false;
		if (!trovato)
			return false;     // ... nessuna missione in esecuzione trovata => stop.
		// ... trovata. Cerca eventuali altre missioni in esec. per il 'flagAvanti'.
		for (int i = esecuzionePianiCarico.getPosMiss() + 1; i < dim && naviga; i++) {
			YPianoCaricoToyotaRiga m = (YPianoCaricoToyotaRiga) esecuzionePianiCarico.getElencoRighe().elementAt(i);
			if (m.getStatoRiga() == StatoRigaToyota.APERTA) {
				flagAvanti = naviga && true;
				break;
			}
		}
		return true;
	}

	public String formPaginaRiposizionamentoUdcMagazzino = "paginaRiposizUdcMagazzino";

	@SuppressWarnings("rawtypes")
	protected void paginaRiposizionamentoUdcMagazzino() {
		TForm form = getTForm(formPaginaRiposizionamentoUdcMagazzino);
		try {
			String txt = "Sono terminati i prelievi per sull'UDC "+esecuzionePianiCarico.getCodiceMappaUdc();
			txt += "-";
			txt += "Premere F1 se si vuole riposizionare l'UDC a magazzino";
			form.getTField("LblIntestazione").setValue(txt);
			sendForm(form);
			TForm risposta = readInput();
			if (risposta.getKeyPressed().equals(TForm.KEY_ESC) ||
					risposta.getKeyPressed().equals(TForm.KEY_CTL_X)) {
				pagina = SELEZIONE;
				esecuzionePianiCarico.setReparto(null); //.Se torna indietro svuoto il reparto scelto
				return;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F1)) {
				YPianoCaricoToyota pianoInRiposizionamento = esecuzionePianiCarico.getPianoInRiposizionamento();
				pianoInRiposizionamento.setStatoUdc(StatoPrelievoUdcToyota.PRONTA_PER_REINTEGRO);

				Iterator iterRighe = pianoInRiposizionamento.getRighe().iterator();
				while(iterRighe.hasNext()) {
					YPianoCaricoToyotaRiga riga = (YPianoCaricoToyotaRiga) iterRighe.next();
					riga.setStatoRiga(StatoRigaToyota.CHIUSA);
				}

				int rc = pianoInRiposizionamento.save();
				if(rc > 0) {
					ConnectionManager.commit();
					esecuzionePianiCarico.setPianoInRiposizionamento(null); //.Svuoto il piano
					esecuzionePianiCarico.setMappaUdc(null); //.Svuoto la mappa sparata
					pagina = UDC_NR_RITORNO;
				}else {
					ConnectionManager.rollback();
					messaggio(true, "Impossibile salvare il piano di carico, riprovare");
					pagina = RIPOSIZ_UDC_MAGAZZINO;
				}
			}
		} catch(Exception e) {
			e.printStackTrace(Trace.excStream);
			pagina = MENU;
		}
		return;
	}

	public String formPaginaUdcNumeroRitorno = "paginaUdcNumeroRitorno";

	@SuppressWarnings("rawtypes")
	protected void paginaUdcNumeroRitorno() {
		TForm form = getTForm(formPaginaUdcNumeroRitorno);
		try {
			form.getTField("FieldUdc").setValue("");
			form.getTField("FieldNumeroRitorno").setValue("");
			sendForm(form);
			TForm risposta = readInput();
			if (risposta.getKeyPressed().equals(TForm.KEY_ESC) ||
					risposta.getKeyPressed().equals(TForm.KEY_CTL_X)) {
				pagina = UDC_NR_RITORNO;
				esecuzionePianiCarico.setPianoInRiposizionamento(null); //.Svuoto il piano
				esecuzionePianiCarico.setMappaUdc(null); //.Svuoto la mappa sparata
				return;
			}
			if (risposta.getKeyPressed().equals(TForm.KEY_F1)) {
				ErrorMessage errore = testPaginaUdcNumeroRitorno(form.getTField("FieldUdc").getValue(), form.getTField("FieldNumeroRitorno").getValue());
				if(errore != null) {
					messaggio(true, errore.getLongText());
				}
			}
		} catch(Exception e) {
			e.printStackTrace(Trace.excStream);
			pagina = MENU;
		}
		return;
	}

	@SuppressWarnings("rawtypes")
	protected ErrorMessage testPaginaUdcNumeroRitorno(String udc, String numeroRitorno) throws Exception {
		if(udc.isEmpty() && numeroRitorno.isEmpty()) {
			return new ErrorMessage("YLOGIS0003");
		}
		if(udc != null && !udc.isEmpty()) {
			MappaUdc mappa = MappaUdc.elementWithKey(udc, PersistentObject.NO_LOCK);
			if(mappa == null) {
				return new ErrorMessage("YLOGIS0001");
			}else {
				esecuzionePianiCarico.setMappaUdc(mappa); //.Porto sulla classe la mappa udc
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
					messaggio(false, "L'UDC "+udc+" non è presente in baia");
					pagina = UDC_NR_RITORNO;
				}else {
					Iterator iterRighe = ((YPianoCaricoToyota)piani.get(0)).getRighe().iterator();
					boolean tutteChiuse = true;
					while(iterRighe.hasNext()) {
						YPianoCaricoToyotaRiga riga = (YPianoCaricoToyotaRiga) iterRighe.next();
						if(riga.getStatoPrelievo() < StatoPrelievoRigaToyota.PRELEVATA && riga.getStatoRiga() == StatoRigaToyota.APERTA) {
							tutteChiuse = false;
							if(riga.getPrelevabile()) {
								esecuzionePianiCarico.getElencoRighe().add(riga);
							}
						}
					}
					if(tutteChiuse) {
						esecuzionePianiCarico.setPianoInRiposizionamento((YPianoCaricoToyota) piani.get(0)); //.Me lo porto nella pagina successiva
						pagina = RIPOSIZ_UDC_MAGAZZINO;
					}else {
						pagina = ESECUZIONE_CARICO;
					}
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace(Trace.excStream);
			}

		}
		//.Altrimenti verifico se esistono delle righe con StatoPrelievo < 2, StatoRiga A su piani di carico con reparto/udc scelti
		else if(numeroRitorno != null && !numeroRitorno.isEmpty()) {
			YPianoCaricoToyotaRiga riga = esecuzionePianiCarico.recuperaRigaPianoCaricoApertaFromNumRitorno(
					numeroRitorno);
			if(riga != null && riga.getPrelevabile()) {
				esecuzionePianiCarico.getElencoRighe().add(riga);
				pagina = ESECUZIONE_CARICO;
			}else {
				messaggio(false, "Non sono presenti piani di carico aperti per il numero di ritorno sparato");
				pagina = UDC_NR_RITORNO;
			}
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
