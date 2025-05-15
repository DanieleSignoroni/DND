/*
 * @(#)MovimentoMagazzino.java
 */

/**
 * Movimento di magazzino (Business Object)
 *
 * <br></br><b>Copyright (C) : Thera s.p.a.</b>
 * @author Paolo J Franzoni 31/07/2002 at 12:13:07
 */
/*
 * Revisions:
 * Fix           Date          Owner      Description
 *               31/07/2002    Wizard     Codice generato da Wizard
 *               22/12/2003    LP         Aggiunto costante AREA_PRODUZIONE
 *               13/01/2004    PJ         fix 1246 - correzione gestione riapplicazione costi
 *  02634        15/10/2004    SL         Aggiunto un metodo di check sul controllo del tipo di
 *                                        movimento mag.
 *                                        Modifica fatta x gestire i CM dei movimenti magazzino.
 *  05264        05/04/2006    GM         cambiato valorizzazione di testTransmission per passare i mov. a Logis solo in creazione
 *               07/04/2006    GM         cambiato il reperimento dei filtri per la trasmissione a Logis
 *                                        aggiunto cfgMov per passare come parametro il filtro per la trasm. dei mov. a Logis
 *               12/04/2006    GM         i movimenti con qtà e qtàSec = 0 non devono passare a Logis
 *  06379        12/12/2006    GM         se la data di reg. è precedente alla data inizio il mov. non passa a Logis
 *  06771        26/02/2007    DBot       Implementazione x movimenti magazzino servizio
 *  08501        08/01/2008    DZ         save: aggiunto controllo che qtaSecondaria sia diverso da null per CM
 *  09252        19/05/2008    GM         trasmissione a Logis dei movimenti modificati
 *  13455        18/11/2010    Linda      Aggiunto il metodo getVecchioCosPrzValPrmEff()
 *  13554        26/11/2010    OC         Corretto sconto totale
 *  14650        20/06/2011    Linda      Aggiunto il metodo checkTipoDocumento()
 *  18360        09/08/2012    PM         Aggiunto main che storna e cancella un movimento in base alla chiave 
 *  24596        07/12/2016    LTB        Aggiungere il nuovo tipo doc nel checkTipoDocumento
 *  29211        22/04/2019    LTB        Svutare tutti i dati documento originale UBI    
 *  30247        28/11/2019    LTB        Troncare il Numero Fattura se è superato a 10 caratteri
 *  31751		 17/09/2020    SZ		  Gestire nella save anche il caso in cui sia l'articolo a non gestire U&B (e non il magazzino)	  
 *  32044		 17/12/2020	   SZ		  Aggiunto il metodo savePO() Per usare nel save del CM DaGriglia.	
 *  35221        28/02/2022    YBA        Aggiunto metodo checkIdEsternoConfig 
 */

package it.thera.thip.magazzino.movimenti;

import java.util.*;
import java.math.*;
import java.sql.*;

import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.security.Security;
import com.thera.thermfw.base.*;

import it.thera.thip.magazzino.saldi.*;
import it.thera.thip.cs.*;
import it.dnd.thip.base.generale.YCfgLogTxMov; //71953
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.generale.*;
import it.thera.thip.logis.bas.Attributo;
import it.thera.thip.logis.fis.RigaMovimento;
import it.thera.thip.logisticaLight.SaldiUbicazionePrt;
import it.thera.thip.magazzino.documenti.DocMagBase;
import it.thera.thip.produzione.documento.DocumentoProduzione;
import it.thera.thip.vendite.generaleVE.TipoDocumento;


public class MovimentoMagazzino extends MovimentoMagazzinoPO {

    public static final char AREA_VENDITA      = 'V';
    public static final char AREA_ACQUISTO     = 'A';
    public static final char AREA_CONTO_LAVORO = 'L';
    public static final char AREA_MAGAZZINO    = 'M';
    public static final char AREA_PRODUZIONE   = 'P';
    public static final char AREA_SERVIZIO     = 'S'; //fix 6771

    public static final String ERROR_TIPO_MOVIM_MAGAZ = "THIP_BS366";//Mod. 02634 SL

    protected BigDecimal iVecchioCosPrzValPrmEff;
    //Fix 13455 inizio
    public BigDecimal getVecchioCosPrzValPrmEff(){
      return iVecchioCosPrzValPrmEff;
    }
    //Fix 13455 fine
    public static String tipoDocumento(char area, char tipoDocumento) {
        return new String(new char[] {area, tipoDocumento});
    }

    //...FIX 13554 inizio
    public static final BigDecimal BD_999 = new BigDecimal("999.99");
    //...FIX 13554 fine


    /**
     * checkDelete
     * @param components
     * @return ErrorMessage
     */
    /*
     * Revisions:
     * Date          Owner      Description
     * 30/07/2002    Wizard     Codice generato da Wizard
     *
     */
    public ErrorMessage checkDelete(){
        return null;
    }

    /**
     * checkAll
     * @param components
     * @return Vector
     */
    /*
     * Revisions:
     * Date          Owner      Description
     * 30/07/2002    Wizard     Codice generato da Wizard
     *
     */
    public Vector checkAll(BaseComponentsCollection components) {
        Vector errors = new Vector();
        components.runAllChecks(errors);
        return errors;
    }

    /**
     * checkTipoMovimentoMagazzino
     * @param components
     * @return Vector
     */
    /*
     * Revisions:
     * Fix           Date          Owner      Description
     * 02634         15/10/2004    Wizard     Aggiunto questo metodo di check.
     *
     */

    //Fix 14650 inizio
    public ErrorMessage checkTipoDocumento(){
      String tipoDocumento = getTipoDocumento();
      char char1 = tipoDocumento.charAt(0);
      if (tipoDocumento == null || tipoDocumento.length() != 2) {
        return new ErrorMessage("THIP40T119");
      }
      if (char1 != AREA_VENDITA && char1 != AREA_ACQUISTO && char1 !=AREA_CONTO_LAVORO  && char1 != AREA_MAGAZZINO && char1 != AREA_PRODUZIONE && char1 != AREA_SERVIZIO) {
        return new ErrorMessage("THIP40T119");
      }
      char char2= tipoDocumento.charAt(1);
      if (char1 == AREA_VENDITA || char1 == AREA_ACQUISTO || char1 == AREA_CONTO_LAVORO) {
        if (char2 != TipoDocumento.FATTURA &&
            char2 != TipoDocumento.NOTA_ACCREDITO &&
            char2 != TipoDocumento.NOTA_ADDEBITO &&
            char2 != TipoDocumento.SCONTRINO &&
            char2 != TipoDocumento.RICEVUTA_FISCALE &&
            char2 != TipoDocumento.DOCUM_DA_NON_FATTURARE) {
          return new ErrorMessage("THIP40T119");
        }
      }
      if (char1 == AREA_MAGAZZINO) {
        if (char2 != DocMagBase.GENERICO &&
            char2 != DocMagBase.VERSAMENTO &&
            char2 != DocMagBase.TRASFERIMENTO && 
            char2 != DocMagBase.TRASFERIMENTO_UBI //24596
            ) {
          return new ErrorMessage("THIP40T119");
        }
      }
      if (char1 == AREA_PRODUZIONE || char1 == AREA_SERVIZIO) {
        if (char2 != DocumentoProduzione.DOCUMENTO) {
          return new ErrorMessage("THIP40T119");
        }
      }
      return null;
    }
    //Fix 14650 fine

    public ErrorMessage checkCodiceCauMovimMagaz(){
        char tipoMovimMag = this.getTipoMovimMagaz();
        String azienda = this.getCodiceAzienda();
        String codCausale = this.getCodiceCauMovimMagaz();
        try{
        CausaleMovimentoMagazzino cau = CausaleMovimentoMagazzino.getCausaleSpecifica(KeyHelper.buildObjectKey(new String[]{azienda,codCausale}), tipoMovimMag);
        if(cau == null)
          return new ErrorMessage(ERROR_TIPO_MOVIM_MAGAZ, codCausale);
        else
          return null;
        }
        catch(SQLException sql){
          sql.printStackTrace(Trace.excStream);
          return null;
        }


    }



    public boolean initializeOwnedObjects(boolean retFather) {
        boolean ret = super.initializeOwnedObjects(retFather);

        /*
        mi metto via il costo/prezzo effettivo. se al momento
        del salvataggio del movimento questo attributo è stato
        modificato devo aggiornare la parte di costi e prezzi dei saldi
        */
        salvaVecchioCostoPrezzoEffettivo();

        return ret;
    }

    public void salvaVecchioCostoPrezzoEffettivo() {
        iVecchioCosPrzValPrmEff = iCosPrzValPrmEff;
    }
    
    public void troncareNumeroFattura() { //30247
      String numeroFattura = getNumeroFattura();
      if(numeroFattura != null && numeroFattura.length() > 10) {
      	numeroFattura = numeroFattura.substring(0,10);
      	setNumeroFattura(numeroFattura);
      }
    }

    public int save() throws SQLException
    {
      //24630 Inizio
    	if(!getGestioneLogisticaLight() || (getMagazzino() !=null && !getMagazzino().getGestioneLogisticaLight())
    			||  (getArticolo() !=null && !getArticolo().isGestioneLogisticaLight()) || (getUbicazione() == null))//Fix 31751
    		azzeraDatiUbicazioneBarcode(); 
      //24630 Fine
    	troncareNumeroFattura();//30247
    	
        boolean modifica = isOnDB();
        if (getQuantitaSec() == null)   //...FIX08501 - DZ
          setQuantitaSec(new BigDecimal("0"));
        boolean qtaZero = getQuantita().compareTo(new BigDecimal(0)) == 0 && //12.04.06
                          getQuantitaSec().compareTo(new BigDecimal(0)) == 0;
        //19.05.08 - inizio
        //boolean  testTransmission = !qtaZero && !modifica && TestTrasmissione();//05.04.06 - 12.04.06
        boolean trasmLogis = TestTrasmissione();
        boolean  testTransmission = !qtaZero && !modifica && trasmLogis;
        //19.05.08 - fine
        setScontoTotale(aggiustaScontoTotale(getScontoTotale())); //...FIX 13554
        //29211 inizio
        if(getAnnoDocOrigLL() == null || getNumeroDocOrigLL() == null) {
        	setAnnoDocOrigLL(null);
        	setNumeroDocOrigLL(null);
        	setNumRigaDocOrigLL(null);
        	setNumDetRigaDocOrigLL(null);
        	setDataDocOrigLL(null);      
        	setTipoDocumentoOrigLL(SaldiUbicazionePrt.NESSUN_DOC); 
        }
        //29211 fine
        	
        
        int retSave = super.save();

        //19.05.08 - inizio
        // se il movimento esiste già (onDB=true) e le qtà sono cambiate,
        // allora storno il movimento in Logis e lo ricreo con i dati attuali
        if (modifica && trasmLogis && retSave >= ErrorCodes.OK){
          if (qtaDiverse()){
            TrasmissioneMovimentiLogis tml = (TrasmissioneMovimentiLogis)Factory.createObject(TrasmissioneMovimentiLogis.class);
            // storno...
            Vector result = tml.trasmetti(this, true, cfgMov);
            if (!result.isEmpty())
              throw new ThipException( (ErrorMessage) result.get(0));
            else
              retSave += ErrorCodes.OK;
            // ....abilito la trasmissione solo se qta != 0
            testTransmission = !qtaZero;
          }
        }
        //19.05.08 - fine

        if(testTransmission && retSave >= ErrorCodes.OK)
        {
          TrasmissioneMovimentiLogis tml=(TrasmissioneMovimentiLogis)Factory.createObject(TrasmissioneMovimentiLogis.class);
          Vector result = tml.trasmetti(this,false,cfgMov);//07.04.06
          if(!result.isEmpty())
            throw new ThipException((ErrorMessage)result.get(0));
          else
            retSave += ErrorCodes.OK;
        }

        if (modifica && costoPrezzoCambiato())
        {
            GestoreSaldi gestore = (GestoreSaldi) Factory.createObject(GestoreSaldi.class);
            ErrorMessage errore = gestore.riapplicaCostiMovimento(this);
            if (errore != null)
                throw new ThipException(errore);
        }

        return retSave;
    }

    protected boolean costoPrezzoCambiato()
    {
        BigDecimal a = iCosPrzValPrmEff == null ? new BigDecimal(0) : iCosPrzValPrmEff;
        BigDecimal b = iVecchioCosPrzValPrmEff == null ? new BigDecimal(0) : iVecchioCosPrzValPrmEff;

        return a.compareTo(b) != 0;
    }

    protected CfgLogTxMov cfgMov = null;//07.04.06

    protected boolean TestTrasmissione()
    {
      CollegamentoThipLogis ctl = (CollegamentoThipLogis)Factory.createObject(CollegamentoThipLogis.class);
      if(!ctl.getConnessioneLogis(it.thera.thip.base.azienda.Azienda.getAziendaCorrente(),getDtaRegistrazione()))//fix 6379
        return false;

        try {
          //07.04.06 - inizio
          //cfgMov = CfgLogTxMov.elementWithKey(KeyHelper.buildObjectKey(new Object[] {getCodiceAzienda(),getCodiceCauMovimMagaz(),getCodiceMagazzino()}),PersistentObject.NO_LOCK);
          cfgMov = null;
          Vector elencoFiltri = new Vector();
          String where = CfgLogTxMovTM.ID_AZIENDA + "='" + getCodiceAzienda() + "' AND " +
                         CfgLogTxMovTM.ID_CAU_MOV_MAG + "='" + getCodiceCauMovimMagaz() +"' AND " +
                         CfgLogTxMovTM.ABILITATO + "='Y'";
          elencoFiltri = CfgLogTxMov.retrieveList(where,"",false);
          for (int i=0; i<elencoFiltri.size(); i++){
        	//71953 SOF3 Inizio
            YCfgLogTxMov filtro = (YCfgLogTxMov)elencoFiltri.get(i);
            if (filtro.getIdMagazzino() != null &&
                    filtro.getIdMagazzino().equals(getCodiceMagazzino()) &&
                    filtro.getIdMagFisico() != null &&
                    filtro.getIdMagFisico().equals("") &&
                    filtro.getIdPoliticaRiordino() != null &&
                    getArticolo().getIdPoliticaRiordino().equals(filtro.getIdPoliticaRiordino())){ //centro distribuzione
            	cfgMov = filtro;
            	break;
            }
            //71953 SOF3 Fine
            // caso in cui esiste il record del mag.
            if (filtro.getIdMagazzino() != null &&
                filtro.getIdMagazzino().equals(getCodiceMagazzino())){
              cfgMov = filtro;
              //break; 71953
            }
            // nel caso non esista il record del mag. vale quello senza mag.
            if (filtro.getIdMagazzino() == null)
              cfgMov = filtro;
          }
          //07.04.06 - fine
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }

       if(cfgMov == null)
         return false;
       else {
         //fix 6379 - inizio
         // se la data di reg. è precedente alla data inizio il mov. non passa
         if (cfgMov.getDataInizio() != null &&
             getDtaRegistrazione().compareTo(cfgMov.getDataInizio()) < 0)
             return false;
         //fix 6379 - fine
         if (CfgLogTxArtic.compatibile(getArticolo()))
           return true;
       }
      return false;
    }

    public int delete() throws SQLException
    {
      int retDelete;
      boolean testTransmission = TestTrasmissione();

        retDelete = super.delete();
      if(testTransmission && retDelete >= ErrorCodes.OK)
      {
        TrasmissioneMovimentiLogis tml=(TrasmissioneMovimentiLogis)Factory.createObject(TrasmissioneMovimentiLogis.class);
        Vector result = tml.trasmetti(this,true,cfgMov);//07.04.06
        if(!result.isEmpty())
            throw new ThipException((ErrorMessage)result.get(0));
        else
          retDelete += ErrorCodes.OK;
      }
      return retDelete;
    }

    //19.05.08 - inizio
    // ritorna true se le qtà del mov. non coincidono con quelle del mov. in Logis
    public boolean qtaDiverse(){
      RigaMovimento rm = null;
      CollegamentoThipLogis ctlv = (CollegamentoThipLogis) Factory.createObject(CollegamentoThipLogis.class);
      String key = KeyHelper.buildObjectKey(new String[] {ctlv.getImpresaCommLogis(getAziendaKey()).getCodiceSocieta(),
                                      "PTH"+Attributo.formatta(getNumRegistrazione(),17),
                                      getNumRigaDocumento().toString(),
                                      getNumDetRigaDocumento().toString()});
      try {
        rm = RigaMovimento.elementWithKey(key, PersistentObject.OPTIMISTIC_LOCK);
      }
      catch (SQLException ex) {
        ex.printStackTrace(Trace.excStream);
        return false;
      }
      if (rm == null) {
        return false;
      }
      else {
        return (getQuantita().compareTo(rm.getQta2()) != 0 ||
                getQuantitaSec().compareTo(rm.getQta3()) != 0);
      }
    }
    //19.05.08 - inizio

    //...FIX 13554 inizio

   /**
    * aggiustaScontoTotale.
    * @param scontoTotale BigDecimal
    * @return BigDecimal
    */
   public BigDecimal aggiustaScontoTotale(BigDecimal scontoTotale) {
     if(scontoTotale != null) {
       if(scontoTotale.compareTo(BD_999) > 0)
         return BD_999;
       else if(scontoTotale.compareTo(BD_999.negate()) < 0)
         return BD_999.negate();
     }
     return scontoTotale;
   }

   //...FIX 13554 fine

   //Fix 18360 PM >
   public static void main(String[] args) throws Exception
   {
       Security.setCurrentDatabase(args[0], null);
       Security.openDefaultConnection();
       Security.openMainSession(args[1], args[2]);
       GestoreSaldi gestore = (GestoreSaldi) Factory.createObject(GestoreSaldi.class);
       String movKey = KeyHelper.buildObjectKey(new String[]{Azienda.getAziendaCorrente(), args[3]});
       MovimentoMagazzino movimento = (MovimentoMagazzino) MovimentoMagazzino.elementWithKey(MovimentoMagazzino.class.getName(), movKey, PersistentObject.OPTIMISTIC_LOCK);
       if (movimento != null)
       {
           ErrorMessage errore = gestore.stornaMovimento(movimento);
           if (errore != null)
           {
               System.out.println("Errore nello storno del movimento " + movKey + " :");
               System.out.println(errore);
               ConnectionManager.rollback();
           }
           else
           {
               
               int rc = movimento.delete();
               System.out.println("Movimento " + movKey +  " stornato correttamente e cancellato " +rc);
               ConnectionManager.commit();
           }
       }
       else
           System.out.println("Il Movimento " + movKey +  " non esiste");
           
       Security.closeDefaultConnection();
   }
   
   //Fix 18360 PM <
   
   //Fix 24630 Inizio
   public void azzeraDatiUbicazioneBarcode() {
  	 setIdUbicazione(null); 
  	 setSaldoPartita(false);
 		setGestioneLogisticaLight(false);
 		setAnnoDocOrigLL(null);
 		setNumeroDocOrigLL(null);
 		setNumRigaDocOrigLL(null);
 		setNumDetRigaDocOrigLL(null);
 		setDataDocOrigLL(null);      
 		setTipoDocumentoOrigLL(SaldiUbicazionePrt.NESSUN_DOC); 

   }
   //Fix 24630 Fine
   
   //Fix 32044 Inizio
	public int savePO() throws SQLException {
		return super.save();
	}

	public int deletePO() throws SQLException {
		return super.delete();
	}
   //Fix 32044 Fine
	
	  //Fix 35221 inizio
	public ErrorMessage checkIdEsternoConfig() {
		
		if (getArticolo() != null && getArticolo().isConfigurato()) {
			  //controllo che la configurazione caricata sia relativa all'articolo
			  if (getConfigurazione() != null && !getConfigurazione().getIdArticolo().equals(getArticolo().getIdArticolo())) 
				  return new ErrorMessage("THIP_TN805", new String[]{String.valueOf(getConfigurazione().getIdConfigurazione()), getArticolo().getIdArticolo()});
	               }
		return null;
	  }
	  //Fix 35221 fine
}
