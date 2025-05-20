package it.dnd.thip.logis.bas;

import java.sql.SQLException;

import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.azienda.Reparto;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.logis.bas.LogisPO;
import it.thera.thip.logis.lgb.Societa;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 20/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    20/05/2025  DSSOF3   Prima stesura
 */

public class EticPianoCaricoRptPO extends LogisPO {

	protected Integer iNumeroRigaDocumento;

	protected String iNumRitornoAttivita;

	protected String iNumeroRiferimento;

	protected Proxy iCliente = new Proxy(it.thera.thip.base.cliente.ClientePrimrose.class);

	protected Proxy societa = new Proxy(Societa.class);

	protected Proxy iReparto = new Proxy(it.thera.thip.base.azienda.Reparto.class);

	protected String iAnnoDocumento                   = null;
	protected String iNumeroDocumento                 = null;

	protected int iReportNr;

	public EticPianoCaricoRptPO() {
		setCodiceSocieta(Azienda.getAziendaCorrente());
	}

	public void setReportNr(int reportNr) {
		this.iReportNr = reportNr;
		setDirty();
		setOnDB(false);
	}

	public int getReportNr() {
		return iReportNr;
	}

	public void setSocieta(Societa s){
		societa.setObject(s);
		dirty=true;
		onDB=false;
	}

	public Societa getSocieta(){
		return (Societa) societa.getObject();
	}

	public void setCodiceSocieta(String cod){
		societa.setKey(cod);
		setIdAziendaInternal(cod);
		dirty=true;
		onDB=false;
	}

	public String getCodiceSocieta(){
		return societa.getKey();
	}

	public void setNumRitornoAttivita(String numRitornoAttivita) {
		this.iNumRitornoAttivita = numRitornoAttivita;
		setDirty();
	}

	public String getNumRitornoAttivita() {
		return iNumRitornoAttivita;
	}

	public void setNumeroRiferimento(String numeroRiferimento) {
		this.iNumeroRiferimento = numeroRiferimento;
		setDirty();
	}

	public String getNumeroRiferimento() {
		return iNumeroRiferimento;
	}

	public void setCliente(ClientePrimrose cliente) {
		String oldObjectKey = getKey();
		String idAzienda = getCodiceSocieta();
		if (cliente != null) {
			idAzienda = KeyHelper.getTokenObjectKey(cliente.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iCliente.setObject(cliente);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public ClientePrimrose getCliente() {
		return (ClientePrimrose) iCliente.getObject();
	}

	public void setClienteKey(String key) {
		String oldObjectKey = getKey();
		iCliente.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getClienteKey() {
		return iCliente.getKey();
	}

	public void setIdCliente(String idCliente) {
		String key = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idCliente));
		setDirty();
	}

	public String getIdCliente() {
		String key = iCliente.getKey();
		String objIdCliente = KeyHelper.getTokenObjectKey(key, 2);
		return objIdCliente;
	}

	public void setReparto(Reparto reparto) {
		String idAzienda = getCodiceSocieta();
		if (reparto != null) {
			idAzienda = KeyHelper.getTokenObjectKey(reparto.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iReparto.setObject(reparto);
		setDirty();
	}

	public Reparto getReparto() {
		return (Reparto) iReparto.getObject();
	}

	public void setRepartoKey(String key) {
		iReparto.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
	}

	public String getRepartoKey() {
		return iReparto.getKey();
	}

	public void setIdReparto(String idReparto) {
		String key = iReparto.getKey();
		iReparto.setKey(KeyHelper.replaceTokenObjectKey(key, 2, idReparto));
		setDirty();
	}

	public String getIdReparto() {
		String key = iReparto.getKey();
		String objIdReparto = KeyHelper.getTokenObjectKey(key, 2);
		return objIdReparto;
	}

	protected void setIdAziendaInternal(String idAzienda) {
		String key3 = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
		String key4 = iReparto.getKey();
		iReparto.setKey(KeyHelper.replaceTokenObjectKey(key4, 1, idAzienda));
	}

	public void setNumeroDocumento(String NumeroDocumento){
		this.iNumeroDocumento = NumeroDocumento;
		setDirty();
		setOnDB(false);
	}

	public String getNumeroDocumento(){
		return iNumeroDocumento;
	}

	public void setAnnoDocumento(String AnnoDocumento){
		this.iAnnoDocumento = AnnoDocumento;
		setDirty();
		setOnDB(false);
	}

	public String getAnnoDocumento(){
		return iAnnoDocumento;
	}

	public void setNumeroRigaDocumento(Integer numeroRigaDocumento) {
		this.iNumeroRigaDocumento = numeroRigaDocumento;
		setDirty();
		setOnDB(false);
	}

	public Integer getNumeroRigaDocumento() {
		return iNumeroRigaDocumento;
	}

	@Override
	protected TableManager getTableManager() throws SQLException {
		return EticPianoCaricoRptTM.getInstance();
	}

	@Override
	public String getKey() {
		Integer reportNr = new Integer(getReportNr());
		String idAzienda = getCodiceSocieta();
		String annoDocumento = getAnnoDocumento();
		String numeroDocumento = getNumeroDocumento();
		Integer numeroRigaDocumento = getNumeroRigaDocumento();
		Object[] keyParts = {reportNr, idAzienda, annoDocumento, numeroDocumento, numeroRigaDocumento };
		return KeyHelper.buildObjectKey(keyParts);
	}

	@Override
	public void setKey(String key) {
		setReportNr(KeyHelper.stringToInt(KeyHelper.getTokenObjectKey(key, 1)));
		setCodiceSocieta(KeyHelper.getTokenObjectKey(key, 2));
		setAnnoDocumento(KeyHelper.getTokenObjectKey(key, 3));
		setNumeroDocumento(KeyHelper.getTokenObjectKey(key, 4));
		setNumeroRigaDocumento(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 5)));
	}

}
