package it.dnd.thip.toyota.subscription;

import java.sql.SQLException;

import org.json.JSONObject;

import com.thera.thermfw.common.*;

import it.thera.thip.cs.DatiComuniEstesi;

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

public class Subscription extends SubscriptionPO {

	public static final char NON_SIGNIFICATIVO = '-';
	public static final char INVENTORY = 'I';
	public static final char TRANSPORT = 'T';

	public ErrorMessage checkDelete() {
		return null;
	}

	@Override
	public int save() throws SQLException {
		if(!isOnDB() && getTsSubRefreshed() == null) {
			getDatiComuniEstesi().setStato(DatiComuniEstesi.ANNULLATO);
		}
		return super.save();
	}

	public ErrorMessage checkSourceType() {
		if(!isOnDB() && getSourceType() == NON_SIGNIFICATIVO) {
			return new ErrorMessage("BAS0000078","In creazione Source Type dev'essere valorizzato");
		}
		return null;
	}

	@Override
	public int delete() throws SQLException {
		return super.delete();
	}

	public JSONObject getJsonNewSubscription() {
		JSONObject json = new JSONObject();
		return json;
	}
}

