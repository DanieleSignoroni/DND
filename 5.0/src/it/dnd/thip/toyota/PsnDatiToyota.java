package it.dnd.thip.toyota;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.thera.thermfw.base.IniFile;
import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.Cacheable;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.PersistentObjectCache;

import it.dnd.thip.agv.InterfacciaToyota;
import it.thera.thip.base.azienda.Azienda;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 27/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    27/09/2025  DSSOF3   Prima stesura
 */

public class PsnDatiToyota extends PsnDatiToyotaPO implements Cacheable{

	@SuppressWarnings("rawtypes")
	protected static Hashtable iHistory_PsnDatiToyota = new Hashtable();

	public static PsnDatiToyota getCurrentPsnDatiToyota()
	{
		return getPsnDatiToyota(Azienda.getAziendaCorrente());
	}

	@SuppressWarnings("unchecked")
	public static PsnDatiToyota getPsnDatiToyota(String iIdAzienda)
	{
		if (iIdAzienda == null)
			return null;

		PsnDatiToyota iPsnDatiToyota = null;

		try
		{
			if(PersistentObjectCache.isEnabled())
			{
				return (PsnDatiToyota)PersistentObject.readOnlyElementWithKey(PsnDatiToyota.class, iIdAzienda);
			}
			else
			{
				if(iHistory_PsnDatiToyota.containsKey(iIdAzienda))
					return (PsnDatiToyota)iHistory_PsnDatiToyota.get(iIdAzienda);
				else
				{
					iPsnDatiToyota=PsnDatiToyota.elementWithKey(iIdAzienda, PersistentObject.OPTIMISTIC_LOCK);
					if(iPsnDatiToyota != null)
						iHistory_PsnDatiToyota.put(iIdAzienda,iPsnDatiToyota);
				}
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}

		return iPsnDatiToyota;
	}

	public String getIp() {
		StringTokenizer scan = new StringTokenizer(IniFile.getValue("Web", "Database"), ", ");
		String dbName = scan.nextToken();
		if(dbName != null && dbName.equals("PANTH01")) {
			return getUrlPanth01();
		}else {
			return getUrlPanth02();
		}
	}

	public String getClientId() {
		StringTokenizer scan = new StringTokenizer(IniFile.getValue("Web", "Database"), ", ");
		String dbName = scan.nextToken();
		if(dbName != null && dbName.equals("PANTH01")) {
			return getClientIdPanth01();
		}else {
			return getClientIdPanth02();
		}
	}

	public String getClientSecret() {
		StringTokenizer scan = new StringTokenizer(IniFile.getValue("Web", "Database"), ", ");
		String dbName = scan.nextToken();
		if(dbName != null && dbName.equals("PANTH01")) {
			return getClientSecretPanth01();
		}else {
			return getClientSecretPanth02();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public int saveOwnedObjects(int rc) throws SQLException
	{
		rc += super.saveOwnedObjects(rc);

		if(rc >= 0) {
			iHistory_PsnDatiToyota.put(this.getIdAzienda(),this);
			InterfacciaToyota.reset();
		}

		return rc;
	}

	public ErrorMessage checkDelete() {
		return null;
	}

}