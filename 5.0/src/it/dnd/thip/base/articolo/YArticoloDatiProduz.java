package it.dnd.thip.base.articolo;

import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Proxy;

import it.thera.thip.base.articolo.ArticoloDatiProduz;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.logis.fis.TipoUds;

public class YArticoloDatiProduz extends ArticoloDatiProduz {

	protected Integer iNrPezziBauletto;

	protected Integer iNrPezziUds;

	protected Proxy iTipoUds = new Proxy(it.thera.thip.logis.fis.TipoUds.class);

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

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YArticoloDatiProduz yArticoloCliente = (YArticoloDatiProduz)obj;
		iTipoUds.setEqual(yArticoloCliente.iTipoUds);
	}
}
