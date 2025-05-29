package it.dnd.thip.base.generale;

import com.thera.thermfw.persist.*;

import it.thera.thip.base.articolo.PoliticaRiordino;
import it.thera.thip.base.generale.*;
import it.thera.thip.logis.fis.MagFisico;
import it.thera.thip.logis.fis.Ubicazione;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 09/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71966    09/05/2025  DSSOF3   Prima stesura
 */

public class YCfgLogTxMov extends CfgLogTxMov {

	protected Proxy	iPoliticaRiordino = new Proxy(PoliticaRiordino.class);
	
	protected Proxy iUbicazioneVersamento = new Proxy(Ubicazione.class);
	protected Proxy iMagFisico = new Proxy(MagFisico.class);

	public YCfgLogTxMov() {
		super();
	}

	@Override
	protected void setIdAziendaInternal(String idAzienda) {
		super.setIdAziendaInternal(idAzienda);
		if(iPoliticaRiordino != null) {
			String key1 = iPoliticaRiordino.getKey();
			iPoliticaRiordino.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idAzienda));
		}
	}

	public void setPoliticaRiordino(PoliticaRiordino politicaRiordino){
		this.iPoliticaRiordino.setObject(politicaRiordino);
		setDirty();
	}

	public PoliticaRiordino getPoliticaRiordino(){
		return (PoliticaRiordino)iPoliticaRiordino.getObject();
	}

	public void setPoliticaRiordinoKey(String key){
		iPoliticaRiordino.setKey(key);
		setDirty();
	}

	public String getPoliticaRiordinoKey(){
		return iPoliticaRiordino.getKey();
	}

	public void setIdPoliticaRiordino(String idPoliticaRiordino){
		iPoliticaRiordino.setKey(KeyHelper.replaceTokenObjectKey(iPoliticaRiordino.getKey(),2,idPoliticaRiordino));
		setDirty();
	}

	public String getIdPoliticaRiordino(){
		return KeyHelper.getTokenObjectKey(iPoliticaRiordino.getKey(),2);
	}
	
	public void setUbicazionestock(Ubicazione ubicazionestock) {
		String idMagazzinoFisicoStock = getIdMagazzinoFisico();
		if (ubicazionestock != null) {
			idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(ubicazionestock.getKey(), 2);
		}
		setIdMagazzinoFisicoInternal(idMagazzinoFisicoStock);
		this.iUbicazioneVersamento.setObject(ubicazionestock);
		setDirty();
	}

	public Ubicazione getUbicazioneVersamento() {
		return (Ubicazione) iUbicazioneVersamento.getObject();
	}

	public void setUbicazioneVersamentoKey(String key) {
		iUbicazioneVersamento.setKey(key);
		String idMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key, 2);
		setIdMagazzinoFisicoInternal(idMagazzinoFisicoStock);
		setDirty();
	}

	public String getUbicazioneVersamentoKey() {
		return iUbicazioneVersamento.getKey();
	}

	public void setIdUbicazioneVersamento(String idCodiceUbicazioneVersamento) {
		String key = iUbicazioneVersamento.getKey();
		iUbicazioneVersamento.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCodiceUbicazioneVersamento));
		setDirty();
	}

	public String getIdUbicazioneVersamento() {
		String key = iUbicazioneVersamento.getKey();
		String objIdCodiceUbicazioneVersamento = KeyHelper.getTokenObjectKey(key, 2);
		return objIdCodiceUbicazioneVersamento;

	}

	public void setMagFisico(MagFisico magfisicostock) {
		setIdMagazzinoFisicoInternal(magfisicostock.getKey());
		this.iMagFisico.setObject(magfisicostock);
		setDirty();
	}

	public MagFisico getMagFisico() {
		return (MagFisico) iMagFisico.getObject();
	}

	public void setMagFisicoKey(String key) {
		iMagFisico.setKey(key);
		setIdMagazzinoFisicoInternal(key);
		setDirty();
	}

	public String getMagFisicoKey() {
		return iMagFisico.getKey();
	}

	public void setIdMagazzinoFisico(String idMagazzinoFisicoStock) {
		setIdMagazzinoFisicoInternal(idMagazzinoFisicoStock);
		setDirty();
	}

	public String getIdMagazzinoFisico() {
		String key = iUbicazioneVersamento.getKey();
		String objIdMagazzinoFisicoStock = KeyHelper.getTokenObjectKey(key, 1);
		return objIdMagazzinoFisicoStock;
	}

	protected void setIdMagazzinoFisicoInternal(String idMagazzinoFisicoPrelievo) {
		String key1 = iUbicazioneVersamento.getKey();
		iUbicazioneVersamento.setKey(KeyHelper.replaceTokenObjectKey(key1, 1, idMagazzinoFisicoPrelievo));
		iMagFisico.setKey(idMagazzinoFisicoPrelievo);
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

}

