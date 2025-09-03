package it.dnd.thip.agv;

import java.sql.Time;

import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.azienda.Azienda;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 03/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    03/09/2025  DSSOF3   Prima stesura
 */

public class YSchedulazioneBufferAgv extends BatchRunnable implements Authorizable, Conflictable {

	protected long iSleepTime;

	protected Time iExpirationTime;

	protected Time iOreInitiale;

	protected char iStato = 'V';

	protected String iIdAzienda;

	public YSchedulazioneBufferAgv() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setSleepTime(long sleepTime)
	{
		iSleepTime = sleepTime;
	}

	public long getSleepTime()
	{
		return iSleepTime;
	}

	public void setExpirationTime(Time expirationTime)
	{
		iExpirationTime = expirationTime;
	}

	public Time getExpirationTime()
	{
		return iExpirationTime;
	}

	public void setOreInitiale(Time oreInitiale)
	{
		iOreInitiale = oreInitiale;
	}

	public Time getOreInitiale()
	{
		return iOreInitiale;
	}

	public void setStato(char stato)
	{
		iStato = stato;
	}

	public char getStato()
	{
		return iStato;
	}

	public void setIdAzienda(String idAzienda)
	{
		iIdAzienda = idAzienda;
	}

	public String getIdAzienda()
	{
		return iIdAzienda;
	}

	@Override
	protected boolean run() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getClassAdCollectionName() {
		// TODO Auto-generated method stub
		return null;
	}

}
