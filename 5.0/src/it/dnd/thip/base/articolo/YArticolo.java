package it.dnd.thip.base.articolo;

import java.sql.SQLException;

import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Proxy;

import it.dnd.thip.datiTecnici.modpro.YModelloProduttivo;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.datiTecnici.modpro.ModelloProduttivoTM;
import it.thera.thip.logis.fis.TipoUds;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Andrea Gatta<br>
 * Date: 05/12/2024
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71725    05/12/2024  AGSOF3   Aggiunta campo Stato inserimento modello produttivo
 * 71946	02/05/2025	DSSOF3	 Aggiunta campi
 */

public class YArticolo extends Articolo {

	/**
	 * Attributo iStatoInsModPro
	 */
	protected boolean iStatoInsModPro = false;

	protected Integer iNrPezziBauletto; //71946

	protected Integer iNrPezziUds; //71946

	protected Proxy iTipoUds = new Proxy(it.thera.thip.logis.fis.TipoUds.class); //71946

	public YArticolo() {
		setStatoInsModPro(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setStatoInsModPro(boolean statoInsModPro) {
		this.iStatoInsModPro = statoInsModPro;
		setDirty();
	}

	public boolean getStatoInsModPro() {
		return iStatoInsModPro;
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

	/**
	 * Controllo se esiste almeno un modello produttivo per l'articolo, 
	 * se così fosse allora setto StatoInsModPro = true
	 * altrimenti a false
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void updateStatoInsModPro() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String where = ModelloProduttivoTM.ID_AZIENDA + " = '"+this.getIdAzienda()+"' AND " +
				ModelloProduttivoTM.R_ARTICOLO + " = '"+this.getIdArticolo()+"' ";
		boolean hasModelliProduttivi = !YModelloProduttivo.retrieveList(where, "", false).isEmpty();
		this.setStatoInsModPro(hasModelliProduttivi);
		this.save();
	}

	@Override
	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		if(obj instanceof YArticolo) {
			YArticolo yArticoloCliente = (YArticolo)obj;
			iTipoUds.setEqual(yArticoloCliente.iTipoUds);
		}
	}

}