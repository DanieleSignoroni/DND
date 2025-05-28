package it.dnd.thip.base.articolo;

import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.Proxy;

import it.thera.thip.base.articolo.ArticoloDatiProduz;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.logis.fis.MagFisico;
import it.thera.thip.logis.fis.TipoUds;
import it.thera.thip.logis.fis.Ubicazione;

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
 * 71979	28/05/2025	DSSOF3	 Aggiunta ubicazione versamento e magazzino fisico
 */

public class YArticoloDatiProduz extends ArticoloDatiProduz {

	protected Integer iNrPezziBauletto;

	protected Integer iNrPezziUds;

	protected Proxy iTipoUds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

	protected Proxy iUbicazioneVersamento = new Proxy(Ubicazione.class);
	protected Proxy iMagFisico = new Proxy(MagFisico.class);

	public YArticoloDatiProduz() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setNrPezziBauletto(Integer nrPezziBauletto) {
		this.iNrPezziBauletto = nrPezziBauletto;
		setDirty();
	}

	public Integer getNrPezziBauletto() {
		return iNrPezziBauletto;
	}

	public void setNrPezziUds(Integer nrPezziUds) {
		this.iNrPezziUds = nrPezziUds;
		setDirty();
	}

	public Integer getNrPezziUds() {
		return iNrPezziUds;
	}

	public void setTipoUds(TipoUds tipouds) {
		this.iTipoUds.setObject(tipouds);
		setDirty();
	}

	public TipoUds getTipoUds() {
		return (TipoUds)iTipoUds.getObject();
	}

	public void setTipoUdsKey(String key) {
		iTipoUds.setKey(key);
		setDirty();
	}

	public String getTipoUdsKey() {
		return iTipoUds.getKey();
	}

	public void setIdTipoUDS(String idTipoUDS) {
		iTipoUds.setKey(idTipoUDS);
		setDirty();
	}

	public String getIdTipoUDS() {
		String key = iTipoUds.getKey();
		return key;
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
		YArticoloDatiProduz yArticoloCliente = (YArticoloDatiProduz)obj;
		iTipoUds.setEqual(yArticoloCliente.iTipoUds);
	}
}
