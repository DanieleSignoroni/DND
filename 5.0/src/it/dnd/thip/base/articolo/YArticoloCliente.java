package it.dnd.thip.base.articolo;

import com.thera.thermfw.persist.*;
import it.thera.thip.logis.fis.TipoUds;
import it.thera.thip.base.articolo.*;
import it.thera.thip.base.azienda.Azienda;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 02/05/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71946	02/05/2025	DSSOF3   Prima stesura
 */

public class YArticoloCliente extends ArticoloCliente {

	protected Integer iNrPezziBauletto;

	protected Integer iNrPezziUds;

	protected Proxy iTipoUds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

	public YArticoloCliente() {
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

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YArticoloCliente yArticoloCliente = (YArticoloCliente)obj;
		iTipoUds.setEqual(yArticoloCliente.iTipoUds);
	}

}

