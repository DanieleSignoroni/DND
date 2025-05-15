package it.dnd.thip.base.generale;

import com.thera.thermfw.persist.*;

import it.thera.thip.base.articolo.PoliticaRiordino;
import it.thera.thip.base.generale.*;

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
 * 71953    09/05/2025  DSSOF3   Prima stesura
 */

public class YCfgLogTxMov extends CfgLogTxMov {

	protected Proxy	iPoliticaRiordino = new Proxy(PoliticaRiordino.class);

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

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

}

