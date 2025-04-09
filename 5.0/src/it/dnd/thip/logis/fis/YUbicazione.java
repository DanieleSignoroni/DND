package it.dnd.thip.logis.fis;

import com.thera.thermfw.persist.*;
import it.thera.thip.logis.fis.*;

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

public class YUbicazione extends Ubicazione {

	protected boolean iBloccataAgv = false;

	protected boolean iGestioneBaiaPrelievo = false;

	protected char iTipoGestionePers = TipoGestioneUbicazione.OPERATORE;

	public YUbicazione() {
		setBloccataAgv(false);
		setGestioneBaiaPrelievo(false);
		setTipoGestionePers(TipoGestioneUbicazione.OPERATORE);
	}

	public void setBloccataAgv(boolean bloccataAgv) {
		this.iBloccataAgv = bloccataAgv;
		setDirty();
	}

	public boolean getBloccataAgv() {
		return iBloccataAgv;
	}

	public void setGestioneBaiaPrelievo(boolean gestioneBaiaPrelievo) {
		this.iGestioneBaiaPrelievo = gestioneBaiaPrelievo;
		setDirty();
	}

	public boolean getGestioneBaiaPrelievo() {
		return iGestioneBaiaPrelievo;
	}

	public void setTipoGestionePers(char tipoGestionePers) {
		this.iTipoGestionePers = tipoGestionePers;
		setDirty();
	}

	public char getTipoGestionePers() {
		return iTipoGestionePers;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

}

