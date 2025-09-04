package it.dnd.thip.agv.web;

import java.sql.SQLException;

import com.thera.thermfw.batch.web.BatchRunnableDataCollector;
import com.thera.thermfw.common.ErrorMessage;

import it.thera.thip.cs.ThipException;

public class YSchedulazioneBufferAgvBatchDC extends BatchRunnableDataCollector
{

	  /**
	   * Metodo ridefinito al fine di avere un messaggio pulito (senza Errore SQL non conosciuto)
	   * quando viene lanciata una ThipException.
	   * @param ErrorMessage
	   */
	  protected ErrorMessage createMessageForSQLException(SQLException sqlException)
	  {
	    if (sqlException instanceof ThipException)
	    {
	      ErrorMessage em = ( (ThipException) sqlException).getErrorMessage();
	      if (em != null)
	        return em;
	    }
	    return super.createMessageForSQLException(sqlException);
	  }

}
