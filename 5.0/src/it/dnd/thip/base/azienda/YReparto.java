package it.dnd.thip.base.azienda;

import com.thera.thermfw.persist.*;

import it.dnd.thip.agv.LogicaMissioniToyota;
import it.dnd.thip.logis.fis.TipoGestioneUbicazione;
import it.thera.thip.base.azienda.*;
import it.thera.thip.base.azienda.Azienda;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 08/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    08/04/2025  DSSOF3   Prima stesura
 * 72036	07/07/2025	DSSOF3	 Aggiunta tipo gestione.
 */

public class YReparto extends Reparto {

	protected boolean iServitoLogistica = false;

	protected boolean iBloccoMissioniPrlAgv = false;

	protected boolean iBloccoMissioniRiposAgv = false;

	protected boolean iAgvNonDefault = false;

	protected char iTipoGestionePers = TipoGestioneUbicazione.DEFAULT; //Fix 72036

	protected char iLogicaMissioniToyota = LogicaMissioniToyota.NON_SIGNIFICATIVO;

	public YReparto() {
		setServitoLogistica(false);
		setBloccoMissioniPrlAgv(false);
		setBloccoMissioniRiposAgv(false);
		setAgvNonDefault(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setServitoLogistica(boolean servitoLogistica) {
		this.iServitoLogistica = servitoLogistica;
		setDirty();
	}

	public boolean getServitoLogistica() {
		return iServitoLogistica;
	}

	public void setBloccoMissioniPrlAgv(boolean bloccoMissioniPrlAgv) {
		this.iBloccoMissioniPrlAgv = bloccoMissioniPrlAgv;
		setDirty();
	}

	public boolean getBloccoMissioniPrlAgv() {
		return iBloccoMissioniPrlAgv;
	}

	public void setBloccoMissioniRiposAgv(boolean bloccoMissioniRiposAgv) {
		this.iBloccoMissioniRiposAgv = bloccoMissioniRiposAgv;
		setDirty();
	}

	public boolean getBloccoMissioniRiposAgv() {
		return iBloccoMissioniRiposAgv;
	}

	public boolean isAgvNonDefault() {
		return iAgvNonDefault;
	}

	public void setAgvNonDefault(boolean iAgvNonDefault) {
		this.iAgvNonDefault = iAgvNonDefault;
		setDirty();
	}

	//Fix 72036

	public void setTipoGestionePers(char tipoGestionePers) {
		this.iTipoGestionePers = tipoGestionePers;
		setDirty();
	}

	public char getTipoGestionePers() {
		return iTipoGestionePers;
	}

	//Fix 72036

	public char getLogicaMissioniToyota() {
		return iLogicaMissioniToyota;
	}

	public void setLogicaMissioniToyota(char iLogicaMissioniToyota) {
		this.iLogicaMissioniToyota = iLogicaMissioniToyota;
		setDirty();
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

}

