package it.dnd.thip.produzione.raccoltaDati;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.ErrorCodes;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.dnd.thip.base.articolo.YArticolo;
import it.dnd.thip.base.articolo.YArticoloCliente;
import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProd;
import it.dnd.thip.produzione.ordese.YGestioneUdsPickingProdTM;
import it.thera.thip.base.articolo.ArticoloCliente;
import it.thera.thip.base.generale.IntegrazioneThipLogis;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.logis.fis.MappaUdc;
import it.thera.thip.logis.fis.RigaUds;
import it.thera.thip.logis.fis.TestataUds;
import it.thera.thip.logis.lgb.RigaLista;
import it.thera.thip.logis.lgb.RigaListaTM;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdMat;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdTes;
import it.thera.thip.vendite.proposteEvasione.CreaMessaggioErrore;

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
 * 71946    02/05/2025  DSSOF3   Prima stesura
 */

public class YRilevDatiPrdTS extends RilevDatiPrdTS {

	public static final String STMT_IS_ATV_ESEC_PVEN_L = "SELECT 1 FROM THIP.ORD_ESEC OE "
			+ "INNER JOIN THIP.ORD_VEN_RIG OVR "
			+ "ON OE.ID_AZIENDA = OVR.ID_AZIENDA "
			+ "AND OE.R_ANNO_ORD_CLI = OVR.ID_ANNO_ORD "
			+ "AND OE.R_NUMERO_ORD_CLI = OVR.ID_NUMERO_ORD "
			+ "AND OE.R_RIGA_ORD_CLI = OVR.ID_RIGA_ORD "
			+ "INNER JOIN THIP.DOC_VEN_RIG DVR "
			+ "ON DVR.ID_AZIENDA = OE.ID_AZIENDA "
			+ "AND DVR.R_ANNO_ORD = OVR.ID_ANNO_ORD "
			+ "AND DVR.R_NUMERO_ORD = OVR.ID_NUMERO_ORD "
			+ "AND DVR.R_RIGA_ORD = OVR.ID_RIGA_ORD "
			+ "INNER JOIN LOGIS.LLISTA_RIGA LR  "
			+ "ON LR.COD_SOCIETA = OE.ID_AZIENDA "
			+ "AND LR.COD_LISTA = CONCAT('"+IntegrazioneThipLogis.VENDITA+"',TRIM(DVR.ID_ANNO_DOC),DVR.ID_NUMERO_DOC) "
			+ "AND LR.NUM_RIGA_HOST = DVR.ID_RIGA_DOC "
			+ "INNER JOIN LOGIS.LLISTA_TESTA LT "
			+ "ON LR.COD_SOCIETA = LT.COD_SOCIETA "
			+ "AND LR.COD_LISTA = LT.CODICE "
			+ "WHERE OE.ID_AZIENDA = ? "
			+ "AND OE.ID_ANNO_ORD = ? "
			+ "AND OE.ID_NUMERO_ORD = ? "
			+ "AND LT.COD_TIPO_LISTA = ?";
	protected static CachedStatement cAttivitaSuOrdineEsecutivoPVENL = new CachedStatement(STMT_IS_ATV_ESEC_PVEN_L);

	public static final String STMT_RIGA_LISTA_ATV_OE_PVENL = "SELECT LR.* FROM THIP.ORD_ESEC OE "
			+ "INNER JOIN THIP.ORD_VEN_RIG OVR "
			+ "ON OE.ID_AZIENDA = OVR.ID_AZIENDA "
			+ "AND OE.R_ANNO_ORD_CLI = OVR.ID_ANNO_ORD "
			+ "AND OE.R_NUMERO_ORD_CLI = OVR.ID_NUMERO_ORD "
			+ "AND OE.R_RIGA_ORD_CLI = OVR.ID_RIGA_ORD "
			+ "INNER JOIN THIP.DOC_VEN_RIG DVR "
			+ "ON DVR.ID_AZIENDA = OE.ID_AZIENDA "
			+ "AND DVR.R_ANNO_ORD = OVR.ID_ANNO_ORD "
			+ "AND DVR.R_NUMERO_ORD = OVR.ID_NUMERO_ORD "
			+ "AND DVR.R_RIGA_ORD = OVR.ID_RIGA_ORD "
			+ "INNER JOIN LOGIS.LLISTA_RIGA LR  "
			+ "ON LR.COD_SOCIETA = OE.ID_AZIENDA "
			+ "AND LR.COD_LISTA = CONCAT('"+IntegrazioneThipLogis.VENDITA+"',TRIM(DVR.ID_ANNO_DOC),DVR.ID_NUMERO_DOC) "
			+ "AND LR.NUM_RIGA_HOST = DVR.ID_RIGA_DOC "
			+ "INNER JOIN LOGIS.LLISTA_TESTA LT "
			+ "ON LR.COD_SOCIETA = LT.COD_SOCIETA "
			+ "AND LR.COD_LISTA = LT.CODICE "
			+ "WHERE OE.ID_AZIENDA = ? "
			+ "AND OE.ID_ANNO_ORD = ? "
			+ "AND OE.ID_NUMERO_ORD = ? "
			+ "AND LT.COD_TIPO_LISTA = ? ";
	protected static CachedStatement cRigaListaAttivitaSuOrdineEsecutivoPVENL = new CachedStatement(STMT_RIGA_LISTA_ATV_OE_PVENL);

	public static final String STMT_QTA_IMBALLATA = "SELECT "
			+ "	SUM(QUANTITA) "
			+ "FROM "
			+ "	THIPPERS.YGESTIONE_UDS_PICKING_PROD "
			+ "WHERE ID_AZIENDA = ? "
			+ "AND NUMERO_RITORNO = ? "
			+ "AND R_COD_LISTA = ? "
			+ "AND R_COD_RIGA_LISTA = ? "
			+ "AND STATO = ? ";
	protected static CachedStatement cSommaQuantitaImballata = new CachedStatement(STMT_QTA_IMBALLATA);

	protected String iYIdTipoUDS;
	protected boolean iYNonGestirePicking;
	protected Integer iYNumeroPzBauletto;
	protected Integer iYNumeroPzUds;

	@SuppressWarnings("rawtypes")
	protected Map iMappaUdc = new Hashtable();

	public YRilevDatiPrdTS() {
		setYNonGestirePicking(false);
	}

	public String getYIdTipoUds() {
		return iYIdTipoUDS;
	}

	public void setYIdTipoUds(String iYIdTipoUDS) {
		this.iYIdTipoUDS = iYIdTipoUDS;
		setDirty();
	}

	public boolean isYNonGestirePicking() {
		return iYNonGestirePicking;
	}

	public void setYNonGestirePicking(boolean iYNonGestirePicking) {
		this.iYNonGestirePicking = iYNonGestirePicking;
		setDirty();
	}

	public Integer getYNumeroPzBauletto() {
		return iYNumeroPzBauletto;
	}

	public void setYNumeroPzBauletto(Integer iYNumeroPzBauletto) {
		this.iYNumeroPzBauletto = iYNumeroPzBauletto;
		setDirty();
	}

	public Integer getYNumeroPzUds() {
		return iYNumeroPzUds;
	}

	public void setYNumeroPzUds(Integer iYNumeroPzUds) {
		this.iYNumeroPzUds = iYNumeroPzUds;
		setDirty();
	}

	public MappaUdc getMappaUdc1() {
		return (MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setIdAziendaInternal(String idAzienda) {
		super.setIdAziendaInternal(idAzienda);
		if(iMappaUdc != null) {
			for(int i=0; i<20;i++){
				if(iMappaUdc.isEmpty() || iMappaUdc.size() <= (i + (iCurrentNumPag - 1) * 20)){
					iMappaUdc.put(new Integer((i + (iCurrentNumPag - 1) * 20)), (MappaUdc)Factory.createObject(MappaUdc.class));
				}
			}
		}
	}

	public void setMappaUdc1(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc1Key() {
		if(iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc1(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc1() {
		String key = null;
		if(iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(0 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc2() {
		return (MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc2(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc2Key() {
		if(iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc2(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc2() {
		String key = null;
		if(iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(1 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc3() {
		return (MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc3(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc3Key() {
		if(iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc3(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc3() {
		String key = null;
		if(iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(2 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc4() {
		return (MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc4(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc4Key() {
		if(iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc4(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc4() {
		String key = null;
		if(iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(3 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc5() {
		return (MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc5(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc5Key() {
		if(iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc5(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc5() {
		String key = null;
		if(iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(4 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc6() {
		return (MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc6(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc6Key() {
		if(iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc6(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc6() {
		String key = null;
		if(iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(5 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc7() {
		return (MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc7(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc7Key() {
		if(iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc7(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc7() {
		String key = null;
		if(iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(6 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc8() {
		return (MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc8(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc8Key() {
		if(iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc8(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc8() {
		String key = null;
		if(iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(7 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc9() {
		return (MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc9(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc9Key() {
		if(iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc9(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc9() {
		String key = null;
		if(iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(8 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc10() {
		return (MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc10(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc10Key() {
		if(iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc10(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc10() {
		String key = null;
		if(iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(9 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc11() {
		return (MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc11(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc11Key() {
		if(iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc11(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc11() {
		String key = null;
		if(iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(10 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc12() {
		return (MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc12(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc12Key() {
		if(iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc12(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc12() {
		String key = null;
		if(iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(11 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc13() {
		return (MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc13(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc13Key() {
		if(iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc13(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc13() {
		String key = null;
		if(iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(12 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc14() {
		return (MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc14(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc14Key() {
		if(iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc14(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc14() {
		String key = null;
		if(iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(13 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc15() {
		return (MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc15(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc15Key() {
		if(iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc15(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc15() {
		String key = null;
		if(iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(14 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc16() {
		return (MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc16(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc16Key() {
		if(iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc16(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc16() {
		String key = null;
		if(iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(15 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc17() {
		return (MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc17(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc17Key() {
		if(iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc17(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc17() {
		String key = null;
		if(iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(16 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc18() {
		return (MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc18(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc18Key() {
		if(iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc18(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc18() {
		String key = null;
		if(iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(17 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc19() {
		return (MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc19(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc19Key() {
		if(iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc19(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc19() {
		String key = null;
		if(iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(18 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	public MappaUdc getMappaUdc20() {
		return (MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20));
	}

	public void setMappaUdc20(String key) {
		String oldObjectKey = getKey();
		if(iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20)) != null)
			((MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20))).setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getMappaUdc20Key() {
		if(iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20)) != null)
			return ((MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20))).getKey();
		return null;
	}

	public void setCodiceMappaUdc20(String codiceMappaUDC) {
		if(iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20)) != null){
			String key = ((MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20))).getKey();
			((MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20))).setKey(KeyHelper.replaceTokenObjectKey(key , 1, codiceMappaUDC));
			setDirty();
		}
	}

	public String getCodiceMappaUdc20() {
		String key = null;
		if(iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20)) != null)
			key = ((MappaUdc)iMappaUdc.get(new Integer(19 + (iCurrentNumPag - 1) * 20))).getKey();
		return KeyHelper.getTokenObjectKey(key, 1);
	}

	/**
	 * Quando viene convalidata la rilevazione...creando quindi il documento di produzione,
	 * se l'attivita' esecutiva e' collegata ad una lista di prelievo P/VENL allora devo generare in maniera
	 * automatica le UDS che l'operatore ha parcheggiato temporaneamente nella tabella {@value YGestioneUdsPickingProdTM#TABLE_NAME} con 
	 * stato annullato.<br>
	 */
	@Override
	public int convalidaRilevazione(RilevazioneDatiProdTes testata, int rc, boolean genDoc) {
		int rcConvalida = super.convalidaRilevazione(testata, rc, genDoc);

		//.Se la lista e' P/PREL devo generare le UDS automaticamente
		if(rcConvalida > 0 && checkAttivitaEsecutivaSuListaPVENL() && !isYNonGestirePicking()) {
			int rcUds = generaUdsLogistica(testata);
			if(rcUds >= 0)
				rcConvalida += rcUds;
			else
				rcConvalida = rcUds;
		}

		return rcConvalida;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected int generaUdsLogistica(RilevazioneDatiProdTes testata) { 
		int rc = 0;
		RigaLista rl = getRigaListaCollegataRilevazione();
		if(rl != null) {
			String where = " "+YGestioneUdsPickingProdTM.ID_AZIENDA+" = '"+getIdAzienda()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.NUMERO_RITORNO+" = '"+getAttivitaEsecutiva().getNumeroRitorno()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.R_COD_LISTA+" = '"+rl.getTestataLista().getCodice()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.R_COD_RIGA_LISTA+" = '"+rl.getCodice().toString()+"' "
					+ "AND "+YGestioneUdsPickingProdTM.STATO+" = '"+DatiComuniEstesi.ANNULLATO+"' ";
			try {
				Vector list = YGestioneUdsPickingProd.retrieveList(where, "", false);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					YGestioneUdsPickingProd udsPicking = (YGestioneUdsPickingProd) iterator.next();

					TestataUds testataUds = udsPicking.creaTestataUds();
					if(testataUds != null) {
						int rcTes = testataUds.save();
						if(rcTes > 0) {
							RigaUds rigaUds = udsPicking.creaRigaUds(testataUds);
							rigaUds.setArticolo(rl.getArticolo());
							RilevazioneDatiProdMat mat = (RilevazioneDatiProdMat)testata.getRigheMateriali().get(0);
							rigaUds.setCodiceMagLogico(mat.getIdMagazzino());

							rc = rigaUds.save();
						}
						if(rc > 0) {
							udsPicking.getDatiComuniEstesi().setStato(DatiComuniEstesi.VALIDO);
							rc = udsPicking.save();
						}
					}
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace(Trace.excStream);
				if(e instanceof SQLException)
					testata.iErrori.add(CreaMessaggioErrore.daRcAErrorMessage(rc, (SQLException) e));
				else
					testata.iErrori.add(new ErrorMessage("BAS0000078",e.getMessage()));
				rc = ErrorCodes.GENERIC_ERROR;
			}
		}
		return rc;
	}

	public void valorizzaDatiPickingAutomatico() {
		YArticolo articolo = (YArticolo) getArticolo();
		String idTipoUds = articolo.getIdTipoUDS();
		Integer nrPziBauletto = articolo.getNrPezziBauletto();
		Integer nrPziUds = articolo.getNrPezziUds();
		YArticoloCliente artCli = null;
		try {
			artCli = (YArticoloCliente) ArticoloCliente.getArticoloCliente(getIdAzienda(), getAttivitaEsecutiva().getOrdineEsecutivo().getIdCliente(),
					getIdArticolo(), getIdConfigurazione());
			if(artCli != null) {
				if(artCli.getIdTipoUDS() != null)
					idTipoUds = artCli.getIdTipoUDS();
				if(artCli.getNrPezziBauletto() != null)
					nrPziBauletto = artCli.getNrPezziBauletto();
				if(artCli.getNrPezziUds() != null)
					nrPziUds = artCli.getNrPezziUds();
			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}
		setYIdTipoUds(idTipoUds);
		setYNumeroPzBauletto(nrPziBauletto);
		setYNumeroPzUds(nrPziUds);
	}

	public boolean checkAttivitaEsecutivaSuListaPVENL() {
		if(getAttivitaEsecutiva() == null)
			return false;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cAttivitaSuOrdineEsecutivoPVENL.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getIdAnnoOrdine());
			db.setString(ps, 3, getIdNumeroOrdine());
			db.setString(ps, 4, "P/VENL");
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				return true;
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return false;
	}

	public RigaLista getRigaListaCollegataRilevazione() {
		RigaLista rl = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cRigaListaAttivitaSuOrdineEsecutivoPVENL.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getIdAnnoOrdine());
			db.setString(ps, 3, getIdNumeroOrdine());
			db.setString(ps, 4, "P/VENL");
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				rl = RigaLista.elementWithKey(KeyHelper.buildObjectKey(new String[] {
						resultSet.getString(RigaListaTM.CODICE_SOCIETA),
						resultSet.getString(RigaListaTM.CODICE_TESTATA),
						resultSet.getString(RigaListaTM.CODICE)
				}), PersistentObject.NO_LOCK);
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return rl;
	}

	public BigDecimal getSommaQuantitaImballataPickingProduzione(RigaLista rl, char stato) {
		BigDecimal sum = BigDecimal.ZERO;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = cSommaQuantitaImballata.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, getIdAzienda());
			db.setString(ps, 2, getAttivitaEsecutiva().getNumeroRitorno());
			db.setString(ps, 3, rl.getTestataLista().getCodice());
			db.setString(ps, 4, rl.getCodice().toString());
			db.setString(ps, 5, String.valueOf(stato));
			resultSet =  ps.executeQuery();
			if(resultSet.next()){
				sum = resultSet.getBigDecimal(1);
			}
		}catch (SQLException ex) {
			ex.printStackTrace(Trace.excStream);
		}
		return sum;
	}

}
