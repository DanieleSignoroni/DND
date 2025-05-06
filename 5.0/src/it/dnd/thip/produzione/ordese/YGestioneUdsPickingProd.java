package it.dnd.thip.produzione.ordese;

import java.util.Iterator;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.security.Security;
import com.thera.thermfw.security.User;

import it.thera.thip.base.generale.IntegrazioneThipLogis;
import it.thera.thip.base.profilo.ThipUser;
import it.thera.thip.logis.bas.AbilUtente;
import it.thera.thip.logis.bas.ParametriLogis;
import it.thera.thip.logis.bas.Utente;
import it.thera.thip.logis.fis.OperazioneAllestimento;
import it.thera.thip.logis.fis.RigaUds;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.fis.TipoUds;
import it.thera.thip.logis.lgb.Societa;
import it.thera.thip.logis.prd.Gruppo;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 02/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    02/05/2025  DSSOF3   Prima stesura
 */

public class YGestioneUdsPickingProd extends YGestioneUdsPickingProdPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TestataUds creaTestataUds() {
		TestataUds testata = (TestataUds) Factory.createObject(TestataUds.class);
		if(Utente.getCurrentUtente()!= null){
			if(Utente.getCurrentUtente().getCurrentMagFisico() != null)
				testata.setCodiceMagFisico(Utente.getCurrentUtente().getCurrentMagFisico().getCodice());
			testata.setOperatore(Utente.getCurrentUtente().getCurrentOperatore());
			testata.setPostazione(Utente.getCurrentUtente().getCurrentPostazione());
			if(Utente.getCurrentUtente().getCurrentPostazione() != null)
				testata.setAreaLavoro(Utente.getCurrentUtente().getCurrentPostazione().getAreaLavoro());
		}
		Vector vec = new Vector();
		try{
			vec.addAll(PersistentObject.readOnlyRetrieveList(TipoUds.class));
			if ( vec.size() == 1 ){
				testata.setTipoUds( (TipoUds) vec.get(0));
				testata.setCodice(getIdUds());
				testata.setForma(testata.getTipoUds().getForma());
				testata.getDim().setVolumeIngombro(testata.getTipoUds().getDim().getVolumeIngombro());
				testata.getDim().setVolumeNetto(testata.getTipoUds().getDim().getVolumeNetto());
				testata.getDim().setLarghezza(testata.getTipoUds().getDim().getLarghezza());
				testata.getDim().setLunghezza(testata.getTipoUds().getDim().getLunghezza());
				testata.getDim().setProfondita(testata.getTipoUds().getDim().getProfondita());
				testata.getDim().setPesoMax(testata.getTipoUds().getDim().getPesoMax());
				testata.setTara(testata.getTipoUds().getTara());
			}
			initSocieta(testata);
			vec = new Vector();
			vec.addAll(PersistentObject.readOnlyRetrieveList(OperazioneAllestimento.class));
			if ( vec.size() == 1 ){
				testata.setOperazioneAllestimento( (OperazioneAllestimento) vec.get(0));
			}
		}catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return testata;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RigaUds creaRigaUds(TestataUds testata) {
		RigaUds riga = (RigaUds) Factory.createObject(RigaUds.class);
		riga.setTestataUds(testata);
		Vector vec = new Vector();
		try {
			vec.addAll(PersistentObject.readOnlyRetrieveList(Gruppo.class));
			if(vec.size() == 1)
				riga.setCodiceGruppo(((Gruppo)vec.get(0)).getKey());
		}catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		}
		riga.settaCodiceRigaUds();
		riga.setCodiceTestataLista(getIdCodiceLista());
		riga.setCodiceRigaLista(getIdCodiceRigaLista());
		riga.setQta1Confermata(getQuantita());
		return riga;
	}

	public void initUtente(){
		if(Utente.getCurrentUtente() != null)
			return;
		try{
			User user = Security.getCurrentUser();
			if (user != null)
				if (ParametriLogis.INSTALL_PANTHERA)
					Utente.setCurrentUtente((Utente)Utente.readOnlyElementWithKey(Utente.class, ((ThipUser) user).getUtenteAzienda().getIdUtente())); // Fix 15947
				else
					Utente.setCurrentUtente((Utente)Utente.readOnlyElementWithKey(Utente.class, user.getId())); // Fix 15947

			if(Utente.getCurrentUtente() != null){
				for (int i = 0; i < Utente.getCurrentUtente().getAbilUtenti().size() &&
						Utente.getCurrentUtente().getCurrentMagFisico() == null; i++) {
					AbilUtente a = (AbilUtente) Utente.getCurrentUtente().getAbilUtenti().
							get(i);
					if (a.getFlagDefault()) {
						Utente.getCurrentUtente().setCurrentMagFisico(a.getMagFisico());
						Utente.getCurrentUtente().setCurrentOperatore(a.getOperatore());
						Utente.getCurrentUtente().setCurrentPostazione(a.getPostazione());
					}
				}
			}
		}
		catch (Exception e){
			e.printStackTrace(Trace.excStream);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initSocieta(TestataUds testata){
		try{
			User user = Security.getCurrentUser();
			if (user != null){
				String userAzienda = ((ThipUser)user).getUtenteAzienda().getIdAzienda();
				Vector integrazioni = new Vector();
				integrazioni.addAll(PersistentObject.readOnlyRetrieveList(IntegrazioneThipLogis.class));
				for (Iterator iter = integrazioni.iterator(); iter.hasNext(); ) {
					IntegrazioneThipLogis item = (IntegrazioneThipLogis) iter.next();
					if (item.getCodiceAziendaIC() == null || !item.getCodiceAziendaIC().equals(userAzienda))
						iter.remove();
				}
				if(integrazioni.size() > 0 )
					testata.setSocieta((Societa)Societa.readOnlyElementWithKey(Societa.class, ((IntegrazioneThipLogis)integrazioni.get(0)).getCodiceSocieta())); //Fix 15947
			}
		}catch (Exception e){
			e.printStackTrace(Trace.excStream);
		}
	}

}

