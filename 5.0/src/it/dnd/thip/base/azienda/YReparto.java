package it.dnd.thip.base.azienda;

import com.thera.thermfw.persist.*;
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
 */

public class YReparto extends Reparto {

	protected boolean iServitoLogistica = false;

	protected boolean iBloccoMissioniPrlAgv = false;

	protected boolean iBloccoMissioniRiposAgv = false;

	public YReparto() {
		setServitoLogistica(false);
		setBloccoMissioniPrlAgv(false);
		setBloccoMissioniRiposAgv(false);
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

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

}

