package it.dnd.thip.logis.lgb;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.ad.ClassADCollectionManager;
import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.rs.errors.ErrorUtils;
import com.thera.thermfw.security.Authorizable;

import it.dnd.thip.logis.fis.TipoGestioneUbicazione;
import it.dnd.thip.logis.fis.YUbicazione;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.documenti.web.DocumentoDataCollector;
import it.thera.thip.base.generale.IntegrazioneThipLogis;
import it.thera.thip.cs.ThipException;
import it.thera.thip.logis.fis.Missione;
import it.thera.thip.logis.fis.MissioneTM;
import it.thera.thip.produzione.ordese.AttivitaEsecMateriale;
import it.thera.thip.produzione.ordese.AttivitaEsecMaterialeTM;
import it.thera.thip.produzione.ordese.AttivitaEsecutivaTM;
import it.thera.thip.produzione.ordese.OrdineEsecutivo;
import it.thera.thip.vendite.documentoVE.DocumentoVenditaRigaTM;

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
 * Number   Date        Owner   Description
 * 71923    08/04/2025  DSSOF3  Prima stesura
 * 71923	29/04/2025	AGSOF3	Esclusione ubicazioni con tipo gestione pers = default
 */

public class YGenerazionePianiCaricoToyota extends BatchRunnable implements Authorizable {

	public static final String STMT_PIANI_CARICO_TOYOTA_TES = "SELECT "
			+ "	PIANI_PRL_TES.ID_AZIENDA, "
			+ "	LMISSIONE.COD_MAPPA_UDC, "
			+ "	LMISSIONE.COD_MAG_FISICO, "
			+ "	LMISSIONE.COD_UBICAZIONE, "
			+ "	ORD_ESEC_ATV.R_REPARTO, "
			+ "	SUM(COALESCE(LMISSIONE.QTA1_RIC,0)), "
			+ "	SUM(LLISTA_RIGA.QTA1_RIC) "
			+ "FROM "
			+ "	THIP.PIANI_PRL_TES PIANI_PRL_TES "
			+ "INNER JOIN LOGIS.LLISTA_TESTA LLISTA_TESTA ON "
			+ "	LLISTA_TESTA.COD_SOCIETA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND LLISTA_TESTA.CODICE = PIANI_PRL_TES.R_COD_LISTA "
			+ "INNER JOIN LOGIS.LLISTA_RIGA LLISTA_RIGA ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LLISTA_TESTA.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LLISTA_TESTA.CODICE "
			+ "LEFT OUTER JOIN LOGIS.LMISSIONE LMISSIONE ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LMISSIONE.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LMISSIONE.COD_LISTA "
			+ "	AND LLISTA_RIGA.CODICE = LMISSIONE.COD_RIGA_LISTA "
			+ "INNER JOIN THIP.PIANI_PRL_RIG PIANI_PRL_RIG ON "
			+ "	PIANI_PRL_RIG.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND PIANI_PRL_RIG.ID_MODELLO_PRL = PIANI_PRL_TES.ID_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.TIPO_MODELLO_PRL = PIANI_PRL_TES.TIPO_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_MATERIALE = LLISTA_RIGA.NUM_RIGA_HOST "
			+ "INNER JOIN THIP.ORD_ESEC_ATV ORD_ESEC_ATV ON "
			+ "	ORD_ESEC_ATV.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND ORD_ESEC_ATV.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "LEFT OUTER JOIN THIPPERS.YLUBICAZIONE LUBI ON "//AGSOF3 aggiunta JOIN su THIPPERS.YLUBICAZIONE
			+ "	LUBI.COD_MAG_FISICO = LMISSIONE.COD_MAG_FISICO "
			+ "	AND LUBI.CODICE = LMISSIONE.COD_UBICAZIONE "
			+ "INNER JOIN THIPPERS.YREPARTI REP ON  "
			+ "	REP.ID_AZIENDA = ORD_ESEC_ATV.ID_AZIENDA "
			+ "	AND REP.ID_REPARTO = ORD_ESEC_ATV.R_REPARTO "
			+ "WHERE "
			+ "	PIANI_PRL_TES.ID_AZIENDA = ? "
			+ "	AND LLISTA_TESTA.COD_TIPO_LISTA = ? "
			+ "	AND LMISSIONE.COD_MAPPA_UDC IS NOT NULL "
			+ " AND LUBI.TIPO_GESTIONE_PERS <> '"+TipoGestioneUbicazione.DEFAULT+"' " //AGSOF3 scarto le ubicazioni con tipo gestione default
			+ " AND REP.SERVITO_LOGISTICA = '"+Column.TRUE_CHAR+"' " 
			+ "GROUP BY "
			+ "	PIANI_PRL_TES.ID_AZIENDA, "
			+ "	LMISSIONE.COD_MAPPA_UDC, "
			+ "	LMISSIONE.COD_MAG_FISICO, "
			+ "	LMISSIONE.COD_UBICAZIONE, "
			+ "	ORD_ESEC_ATV.R_REPARTO "
			+ "HAVING SUM(COALESCE(LMISSIONE.QTA1_RIC, 0)) = SUM(LLISTA_RIGA.QTA1_RIC) AND (SUM(COALESCE(LMISSIONE.QTA1_RIC, 0)) - SUM(COALESCE(LMISSIONE.QTA1_EVASA, 0))) > 0 ";
	public CachedStatement cSelectPianiCaricoTyotaTes = new CachedStatement(STMT_PIANI_CARICO_TOYOTA_TES);

	public static final String STMT_PIANO_CARICO_TOYOTA_APERTO = "SELECT "
			+ "P.ID_AZIENDA,P.ID_ANNO_DOC,P.ID_NUMERO_DOC "
			+ "FROM "
			+ "THIPPERS.YPIANO_CARICO_TOYOTA_TES P "
			+ "WHERE P.ID_AZIENDA = ? "
			+ "AND P.R_REPARTO = ? "
			+ "AND P.R_COD_MAPPA_UDC = ? "
			+ "AND P.STATO_UDC <= ? ";
	protected static CachedStatement cSelectPianoCaricoToyotaAperto = new CachedStatement(STMT_PIANO_CARICO_TOYOTA_APERTO);

	public static final String STMT_SELECT_MISSIONI_FROM_CHIAVE_LOGICA_PIANO_CARICO = "SELECT "
			+ "	LMISSIONE.COD_MAG_FISICO , "
			+ "	LMISSIONE.CODICE "
			+ "FROM "
			+ "	THIP.PIANI_PRL_TES PIANI_PRL_TES "
			+ "INNER JOIN LOGIS.LLISTA_TESTA LLISTA_TESTA ON "
			+ "	LLISTA_TESTA.COD_SOCIETA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND LLISTA_TESTA.CODICE = PIANI_PRL_TES.R_COD_LISTA "
			+ "INNER JOIN LOGIS.LLISTA_RIGA LLISTA_RIGA ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LLISTA_TESTA.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LLISTA_TESTA.CODICE "
			+ "LEFT OUTER JOIN LOGIS.LMISSIONE LMISSIONE ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LMISSIONE.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LMISSIONE.COD_LISTA "
			+ "	AND LLISTA_RIGA.CODICE = LMISSIONE.COD_RIGA_LISTA "
			+ "INNER JOIN THIP.PIANI_PRL_RIG PIANI_PRL_RIG ON "
			+ "	PIANI_PRL_RIG.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND PIANI_PRL_RIG.ID_MODELLO_PRL = PIANI_PRL_TES.ID_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.TIPO_MODELLO_PRL = PIANI_PRL_TES.TIPO_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_MATERIALE = LLISTA_RIGA.NUM_RIGA_HOST "
			+ "INNER JOIN THIP.ORD_ESEC_ATV ORD_ESEC_ATV ON "
			+ "	ORD_ESEC_ATV.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND ORD_ESEC_ATV.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "WHERE "
			+ "	PIANI_PRL_TES.ID_AZIENDA = ? "
			+ "	AND LLISTA_TESTA.COD_TIPO_LISTA = ? "
			+ "	AND LMISSIONE.COD_UBICAZIONE IS NOT NULL "
			+ "	AND LMISSIONE.COD_MAPPA_UDC = ? "
			+ "	AND ORD_ESEC_ATV.R_REPARTO = ? "
			+ "GROUP BY "
			+ "	LMISSIONE.COD_MAG_FISICO , "
			+ "	LMISSIONE.CODICE ";
	protected static CachedStatement cSelectMissioniChiaveLogicaPianoCarico = new CachedStatement(STMT_SELECT_MISSIONI_FROM_CHIAVE_LOGICA_PIANO_CARICO);

	public static final String STMT_SELECT_ORDESEC_ATV_MAT_FROM_MISSIONE = "SELECT "
			+ "	ORD_ESEC_ATV.ID_AZIENDA, "
			+ "	ORD_ESEC_ATV.ID_ANNO_ORD, "
			+ "	ORD_ESEC_ATV.ID_NUMERO_ORD, "
			+ "	ORD_ESEC_ATV.ID_RIGA_ATTIVITA, "
			+ "	PIANI_PRL_RIG.ID_RIGA_MATERIALE "
			+ "FROM "
			+ "	THIP.PIANI_PRL_TES PIANI_PRL_TES "
			+ "INNER JOIN LOGIS.LLISTA_TESTA LLISTA_TESTA ON "
			+ "	LLISTA_TESTA.COD_SOCIETA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND LLISTA_TESTA.CODICE = PIANI_PRL_TES.R_COD_LISTA "
			+ "INNER JOIN LOGIS.LLISTA_RIGA LLISTA_RIGA ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LLISTA_TESTA.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LLISTA_TESTA.CODICE "
			+ "LEFT OUTER JOIN LOGIS.LMISSIONE LMISSIONE ON "
			+ "	LLISTA_RIGA.COD_SOCIETA = LMISSIONE.COD_SOCIETA "
			+ "	AND LLISTA_RIGA.COD_LISTA = LMISSIONE.COD_LISTA "
			+ "	AND LLISTA_RIGA.CODICE = LMISSIONE.COD_RIGA_LISTA "
			+ "INNER JOIN THIP.PIANI_PRL_RIG PIANI_PRL_RIG ON "
			+ "	PIANI_PRL_RIG.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND PIANI_PRL_RIG.ID_MODELLO_PRL = PIANI_PRL_TES.ID_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.TIPO_MODELLO_PRL = PIANI_PRL_TES.TIPO_MODELLO_PRL "
			+ "	AND PIANI_PRL_RIG.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "	AND PIANI_PRL_RIG.ID_RIGA_MATERIALE = LLISTA_RIGA.NUM_RIGA_HOST "
			+ "INNER JOIN THIP.ORD_ESEC_ATV ORD_ESEC_ATV ON "
			+ "	ORD_ESEC_ATV.ID_AZIENDA = PIANI_PRL_TES.ID_AZIENDA "
			+ "	AND ORD_ESEC_ATV.ID_ANNO_ORD = PIANI_PRL_TES.ID_ANNO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_NUMERO_ORD = PIANI_PRL_TES.ID_NUMERO_ORD "
			+ "	AND ORD_ESEC_ATV.ID_RIGA_ATTIVITA = PIANI_PRL_TES.ID_RIGA_ATTIVITA "
			+ "WHERE "
			+ "	PIANI_PRL_TES.ID_AZIENDA = ? "
			+ "	AND LLISTA_TESTA.COD_TIPO_LISTA = ? "
			+ "	AND LMISSIONE.COD_UBICAZIONE IS NOT NULL "
			+ "	AND LMISSIONE.COD_MAG_FISICO = ? "
			+ "	AND LMISSIONE.CODICE = ? "
			+ "GROUP BY "
			+ "	ORD_ESEC_ATV.ID_AZIENDA, "
			+ "	ORD_ESEC_ATV.ID_ANNO_ORD, "
			+ "	ORD_ESEC_ATV.ID_NUMERO_ORD, "
			+ "	ORD_ESEC_ATV.ID_RIGA_ATTIVITA, "
			+ "	PIANI_PRL_RIG.ID_RIGA_MATERIALE";
	protected static CachedStatement cSelectOrdEsecAtvMatFromMissione = new CachedStatement(STMT_SELECT_ORDESEC_ATV_MAT_FROM_MISSIONE);

	protected static final String DOC_VEN_RIG = DocumentoVenditaRigaTM.TABLE_NAME_PRINCIPALE;

	protected static final String SELECT_RIGHE_DOC_DA_RIGA_ORD =
			"SELECT " + DOC_VEN_RIG + ".ID_ANNO_DOC, " + DOC_VEN_RIG + ".ID_NUMERO_DOC, " + DOC_VEN_RIG + ".ID_RIGA_DOC" +
					" FROM " + DOC_VEN_RIG +
					" WHERE " + DOC_VEN_RIG + ".ID_AZIENDA = ? AND" +
					" " + DOC_VEN_RIG + ".R_ANNO_ORD = ? AND" +
					" " + DOC_VEN_RIG + ".R_NUMERO_ORD = ? AND" +
					" " + DOC_VEN_RIG + ".R_RIGA_ORD = ? AND" +
					" " + DOC_VEN_RIG + ".R_DET_RIGA_ORD = 0";
	protected static CachedStatement cRigheDocDaRigaOrd = new CachedStatement(SELECT_RIGHE_DOC_DA_RIGA_ORD);

	@Override
	protected boolean run() {
		boolean isOk = true;
		try {
			isOk = runGenerazionePianiCaricoToyota();
		}catch (Exception e) {
			output.println("Exc non gestita "+e.getMessage());
			isOk = false;
			e.printStackTrace(Trace.excStream);
		}
		return isOk;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean runGenerazionePianiCaricoToyota() {
		boolean ret = true;

		List<YPianoCaricoToyota> testate = estrazionePianiCaricoNuoviEsistenti();
		for (Iterator iterator = testate.iterator(); iterator.hasNext();) {
			YPianoCaricoToyota pianoCarico = (YPianoCaricoToyota) iterator.next();
			if(!pianoCarico.isOnDB()) {
				pianoCarico.getNumeratoreHandler().setAnno(String.valueOf(TimeUtils.getCurrentDate().toLocalDate().getYear()));
				pianoCarico.getNumeratoreHandler().setDataDocumento(TimeUtils.getCurrentDate());
			}else {
				//.Update di tutte le righe presenti a Stato C
				Iterator iterRighe = pianoCarico.getRighe().iterator();
				while(iterRighe.hasNext()) {
					YPianoCaricoToyotaRiga riga = (YPianoCaricoToyotaRiga) iterRighe.next();
					riga.setStatoRiga(StatoRigaToyota.CHIUSA);
				}
			}

			BODataCollector boDC = null;
			try {
				boDC = createDataCollector("YPianoCaricoToyota");
				boDC.setAutoCommit(true);
				boDC.setBo(pianoCarico);
				if(!pianoCarico.isOnDB()) {
					((DocumentoDataCollector)boDC).setNuovoDocumento(true);
				}
				DocumentoDataCollector.initRighePerCheck(boDC);
				int rc1 = boDC.save();
				if (rc1 == BODataCollector.ERROR){
					output.println("Impossibile salvare il piano di carico, errori : "+ErrorUtils.getInstance().toJSON(boDC.getErrorList().getErrors()).toString());
				}else {
					try {
						List<Missione> missioni = trovaMissioniChiaveLogicaPianoCarico(pianoCarico.getIdReparto(), pianoCarico.getIdCodiceUdc());
						for (Iterator iterator2 = missioni.iterator(); iterator2.hasNext();) {
							Missione missione = (Missione) iterator2.next();

							YPianoCaricoToyotaRiga rigaPiano = (YPianoCaricoToyotaRiga) Factory.createObject(YPianoCaricoToyotaRiga.class);
							rigaPiano.setTestata(pianoCarico);

							rigaPiano.setIdArticolo(missione.getCodiceArticolo()); //.Assumo esista in thip
							rigaPiano.setMissione(missione);

							AttivitaEsecMateriale materiale = trovaMaterialeFromMissione(missione);
							if(materiale != null) {
								rigaPiano.setAttivitaesecmateriale(materiale);
								rigaPiano.setNumRitornoAttivita(materiale.getAttivitaEsecutiva().getNumeroRitorno());

								OrdineEsecutivo ordEsec = materiale.getAttivitaEsecutiva().getOrdineEsecutivo();
								rigaPiano.setIdCliente(ordEsec.getIdCliente());

								if(ordEsec.getOrdineVenditaRiga() != null) {
									List chiaviRigheDoc = selectRigheDocDaRigheOrd(Arrays.asList(ordEsec.getOrdineVenditaRiga().getKey()));
									if(chiaviRigheDoc != null && chiaviRigheDoc.size() > 0) {
										String c1 = (String) chiaviRigheDoc.get(0);
										String[] parts = KeyHelper.unpackObjectKey(c1);
										rigaPiano.setNumeroRiferimento(IntegrazioneThipLogis.VENDITA + parts[1] + parts[2]);
									}
								}else {
									rigaPiano.setNumeroRiferimento(materiale.getAttivitaEsecutiva().getNumeroRitorno());
								}

								rigaPiano.setQuantitaRichiestaUmPrm(missione.getQta1Richiesta());
								rigaPiano.setQuantitaPrelevataUmPrm(BigDecimal.ZERO);
								
								if(pianoCarico.getStatoGestione() == TipoGestioneUbicazione.AGV || pianoCarico.getStatoGestione() == TipoGestioneUbicazione.OPERATORE) {
									rigaPiano.setPrelevabile(true);
								}else {
									rigaPiano.setPrelevabile(false);
								}

								pianoCarico.getRighe().add(rigaPiano);
							}

						}
					} catch (SQLException e1) {
						e1.printStackTrace(Trace.excStream);
					}

					boDC.setBo(pianoCarico);
					rc1 = boDC.save();
					if (rc1 == BODataCollector.ERROR){
						output.println("Impossibile salvare il piano di carico, errori : "+ErrorUtils.getInstance().toJSON(boDC.getErrorList().getErrors()).toString());
					}

				}
			}
			catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}

		}
		return ret;
	}

	@SuppressWarnings("rawtypes")
	protected List<YPianoCaricoToyota> estrazionePianiCaricoNuoviEsistenti() {
		List<YPianoCaricoToyota> testate = new ArrayList<YPianoCaricoToyota>();
		try {
			List<YPianoCaricoToyota> pianiCarico = trovaPianiCaricoToyota();
			for (Iterator iterator = pianiCarico.iterator(); iterator.hasNext();) {
				YPianoCaricoToyota pianoCarico = (YPianoCaricoToyota) iterator.next();

				//.Qui devo verificare se esiste gia' un piano con StatoUDC <= 2, allora accodo altrimenti creo con StatoUDC = 0
				YPianoCaricoToyota pianoEsistente = trovaPianoCaricoApertoChiaveLogica(pianoCarico.getIdReparto(), pianoCarico.getIdCodiceUdc());
				if(pianoEsistente != null) {
					pianoEsistente.retrieve();

					testate.add(pianoEsistente);
				}else {

					//.Scarico il flag 'StatoGestione' dall'ubicazione
					if(pianoCarico.getUbicazioneStock() != null) {
						pianoCarico.setStatoGestione(((YUbicazione)pianoCarico.getUbicazioneStock()).getTipoGestionePers());
					}

					testate.add(pianoCarico);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}
		return testate;
	}

	public static YPianoCaricoToyota trovaPianoCaricoApertoChiaveLogica(String idReparto, String codMappaUdc) throws SQLException {
		YPianoCaricoToyota piano = null;
		ResultSet rs = null;
		try{
			PreparedStatement ps = cSelectPianoCaricoToyotaAperto.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, idReparto);
			db.setString(ps, 3, codMappaUdc); 
			db.setString(ps, 4, String.valueOf(StatoPrelievoUdcToyota.RICEVUTA)); 
			rs = ps.executeQuery();
			if (rs.next()){
				piano = (YPianoCaricoToyota) Factory.createObject(YPianoCaricoToyota.class);
				piano.setKey(KeyHelper.buildObjectKey(new String[] {
						rs.getString(YPianoCaricoToyotaTM.ID_AZIENDA),
						rs.getString(YPianoCaricoToyotaTM.ID_ANNO_DOC),
						rs.getString(YPianoCaricoToyotaTM.ID_NUMERO_DOC)
				}));
			}
		}finally{
			try{
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace(Trace.excStream);
			}
		}
		return piano;
	}

	public static List<Missione> trovaMissioniChiaveLogicaPianoCarico(String idReparto, String codMappaUdc) throws SQLException {
		List<Missione> missioni = new ArrayList<Missione>();
		ResultSet rs = null;
		try{
			codMappaUdc = Column.rightTrim(codMappaUdc);
			PreparedStatement ps = cSelectMissioniChiaveLogicaPianoCarico.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, "P/PRE");
			db.setString(ps, 3, codMappaUdc);
			db.setString(ps, 4, idReparto); 
			rs = ps.executeQuery();
			while (rs.next()){
				missioni.add((Missione) Missione.elementWithKey(Missione.class, KeyHelper.buildObjectKey(new String[] {
						rs.getString(MissioneTM.COD_MAG_FISICO),
						rs.getString(MissioneTM.CODICE)
				}),PersistentObject.NO_LOCK));
			}
		}finally{
			try{
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace(Trace.excStream);
			}
		}
		return missioni;
	}

	public static AttivitaEsecMateriale trovaMaterialeFromMissione(Missione m) throws SQLException {
		AttivitaEsecMateriale materiale = null;
		ResultSet rs = null;
		try{
			PreparedStatement ps = cSelectOrdEsecAtvMatFromMissione.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, "P/PRE");
			db.setString(ps, 3, m.getCodiceMagFisico());
			db.setString(ps, 4, String.valueOf(m.getCodice())); 
			rs = ps.executeQuery();
			if (rs.next()){
				materiale = (AttivitaEsecMateriale) AttivitaEsecMateriale.elementWithKey(AttivitaEsecMateriale.class, KeyHelper.buildObjectKey(new String[] {
						rs.getString(AttivitaEsecMaterialeTM.ID_AZIENDA),
						rs.getString(AttivitaEsecMaterialeTM.ID_ANNO_ORD),
						rs.getString(AttivitaEsecMaterialeTM.ID_NUMERO_ORD),
						rs.getString(AttivitaEsecMaterialeTM.ID_RIGA_ATTIVITA),
						rs.getString(AttivitaEsecMaterialeTM.ID_RIGA_MATERIALE)
				}), PersistentObject.NO_LOCK);
			}
		}finally{
			try{
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				e.printStackTrace(Trace.excStream);
			}
		}
		return materiale;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List selectRigheDocDaRigheOrd(List ordVenRigKeys) throws SQLException {
		List ret = new ArrayList();
		Database db = ConnectionManager.getCurrentDatabase();
		Iterator iter = ordVenRigKeys.iterator();
		while (iter.hasNext()) {
			synchronized (cRigheDocDaRigaOrd) {
				String ordVenRigKey = (String) iter.next();
				String[] tmp = KeyHelper.unpackObjectKey(ordVenRigKey);
				String idAzienda =  tmp[0];
				String idAnnoOrd = tmp[1];
				String idNumeroOrd = tmp[2];
				String idRigaOrd = tmp[3];
				PreparedStatement ps = cRigheDocDaRigaOrd.getStatement();
				db.setString(ps, 1, idAzienda);
				db.setString(ps, 2, idAnnoOrd);
				db.setString(ps, 3, idNumeroOrd);
				db.setString(ps, 4, idRigaOrd);
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					String idAnnoDoc = Column.rightTrim(res.getString(1));
					String idNumeroDoc = Column.rightTrim(res.getString(2));
					String idRigaDoc = Column.rightTrim(res.getString(3));
					String rigKey = KeyHelper.buildObjectKey(new String[] {idAzienda, idAnnoDoc, idNumeroDoc, idRigaDoc, "0"});
					ret.add(rigKey);
				}
				res.close();
			}
		}
		Collections.sort(ret);
		return ret;
	}

	public List<YPianoCaricoToyota> trovaPianiCaricoToyota() throws SQLException {
		List<YPianoCaricoToyota> piani = new ArrayList<YPianoCaricoToyota>();
		ResultSet rs = null;
		try{
			PreparedStatement ps = cSelectPianiCaricoTyotaTes.getStatement();
			Database db = ConnectionManager.getCurrentDatabase();
			db.setString(ps, 1, Azienda.getAziendaCorrente());
			db.setString(ps, 2, "P/PRE");
			rs = ps.executeQuery();
			while (rs.next()){
				YPianoCaricoToyota pianoCarico = (YPianoCaricoToyota) Factory.createObject(YPianoCaricoToyota.class);
				pianoCarico.setIdCodiceUdc(rs.getString(MissioneTM.COD_MAPPA_UDC));
				pianoCarico.setIdReparto(rs.getString(AttivitaEsecutivaTM.R_REPARTO));
				pianoCarico.setIdMagazzinoFisicoStock(rs.getString(MissioneTM.COD_MAG_FISICO));
				pianoCarico.setIdCodiceUbicazioneStock(rs.getString(MissioneTM.COD_UBICAZIONE));

				piani.add(pianoCarico);
			}
		}finally{
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace(Trace.excStream);
			}
		}
		return piani;
	}

	protected BODataCollector createDataCollector(String str) throws SQLException{
		try {
			BODataCollector bodc = null;
			ClassADCollection classDesc = ClassADCollectionManager.collectionWithName(str);
			String collectorName = classDesc.getBODataCollector();
			if (collectorName != null) {
				bodc = (BODataCollector)Factory.createObject(collectorName);
				if (bodc instanceof DocumentoDataCollector){
					((DocumentoDataCollector)bodc).setDisabilitaControlliRelazione(true);
				}
				bodc.initialize(classDesc.getClassName(), true);
			}
			else
				bodc = new BODataCollector(classDesc.getClassName(), true);

			return bodc;
		}
		catch (Exception e){
			e.printStackTrace(Trace.excStream);
			throw new ThipException(e.getMessage());
		}
	}

	@Override
	protected String getClassAdCollectionName() {
		return "YGenPianCaricoToyota";
	}

}
