package it.dnd.thip.agv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.batch.BatchJob;
import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.batch.ScheduledJob;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.Column;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;
import com.thera.thermfw.security.Security;
import com.thera.thermfw.web.WebElement;

import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRiga;
import it.dnd.thip.logis.lgb.YPianoCaricoToyotaRigaTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.profilo.ThipUser;
import it.thera.thip.cs.ThipException;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 03/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    03/09/2025  DSSOF3   Prima stesura
 */

public class YSchedulazioneBufferAgv extends BatchRunnable implements Authorizable, Conflictable {

	protected long iSleepTime;

	protected Time iExpirationTime;

	protected Time iOreInitiale;

	protected char iStato = 'V';

	protected boolean iFirstTime = true;
	protected boolean iDoRun =false;
	protected ScheduledJob myScheduled = null;

	protected static String RES = "it.dnd.thip.agv.resources.YSchedulazioneBufferAgv";
	protected static String ServSchedTerm1=ResourceLoader.getString(RES, "ServSchedTerm1");
	protected static String ServSchedTerm2=ResourceLoader.getString(RES, "ServSchedTerm2");
	protected static String ServSchedTerm3=ResourceLoader.getString(RES, "ServSchedTerm3");
	protected static String FallLett1=ResourceLoader.getString(RES, "FallLett1");
	protected static String FallLett2=ResourceLoader.getString(RES, "FallLett2");
	protected static String ProcCorr=ResourceLoader.getString(RES, "ProcCorr");
	protected static String FallSalv=ResourceLoader.getString(RES, "FallSalv");

	protected static String batchQueueId = ResourceLoader.getString(RES, "BatchQueueId");
	protected static String descriptionSchedJobId = ResourceLoader.getString(RES, "DescriptionSchedJobId");

	protected static final String SELECT_PIANI_CARICO_NON_SCHEDUL =
			"SELECT "
					+ "	* "
					+ "FROM "
					+ "	THIPPERS.YPIANO_CARICO_TOYOTA_RIG R "
					+ "INNER JOIN THIPPERS.YPIANO_CARICO_TOYOTA_TES T "
					+ "ON "
					+ "	R.ID_AZIENDA = T.ID_AZIENDA "
					+ "	AND R.ID_ANNO_DOC = T.ID_ANNO_DOC "
					+ "	AND R.ID_NUMERO_DOC = T.ID_NUMERO_DOC "
					+ "WHERE T.STATO_GESTIONE = 'A' AND R.ID_AZIENDA = ? ";
	protected static CachedStatement cSelectPianiCaricoNonSchedul = new CachedStatement(SELECT_PIANI_CARICO_NON_SCHEDUL);

	protected String iIdAzienda;
	protected String iScheduledJobId;

	public YSchedulazioneBufferAgv() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setSleepTime(long sleepTime)
	{
		iSleepTime = sleepTime;
	}

	public long getSleepTime()
	{
		return iSleepTime;
	}

	public void setExpirationTime(Time expirationTime)
	{
		iExpirationTime = expirationTime;
	}

	public Time getExpirationTime()
	{
		return iExpirationTime;
	}

	public void setOreInitiale(Time oreInitiale)
	{
		iOreInitiale = oreInitiale;
	}

	public Time getOreInitiale()
	{
		return iOreInitiale;
	}

	public void setStato(char stato)
	{
		iStato = stato;
	}

	public char getStato()
	{
		return iStato;
	}

	public void setIdAzienda(String idAzienda)
	{
		iIdAzienda = idAzienda;
	}

	public String getIdAzienda()
	{
		return iIdAzienda;
	}

	public void setScheduledJobId(String scheduledJobId)
	{
		iScheduledJobId = scheduledJobId;
	}

	public String getScheduledJobId()
	{
		return iScheduledJobId;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected boolean run() {
		init();
		Time now = TimeUtils.getCurrentTime();
		if ((iOreInitiale.compareTo(now) > 0) || (iExpirationTime.compareTo(now) < 0)){
			output.println((new ErrorMessage("THIP110344")).getLongText());
			return false;
		}
		if (iStato != 'V'){
			output.println((new ErrorMessage("THIP110345")).getLongText());
			return false;
		}
		while (iExpirationTime.getTime() >= TimeUtils.getCurrentTime().getTime()){
			this.checkPointImmediate();
			if (!manager.getBatchManager().getServer().isRunning())
			{
				output.println(ServSchedTerm1);
				return true;
			}
			if (iSleepTime == 0){
				iSleepTime = 30;
			}
			List keys = null;
			int nbreSqlException = 0;
			while ((keys == null) && (nbreSqlException++ <= 10)) {
				try {
					Thread.sleep(iSleepTime * 1000);
					keys = selectPianiCaricoNonSchedulati(Azienda.getAziendaCorrente());
				}
				catch (InterruptedException ie) {
					ie.printStackTrace();
					output.println(ServSchedTerm3);
				} catch (SQLException e) {
					e.printStackTrace(Trace.excStream);
				}
			}
			if (keys != null) {
				Iterator it = keys.iterator();
				while (it.hasNext()) {
					String key = (String) it.next();
					YPianoCaricoToyotaRiga oe = null;
					try {
						oe = YPianoCaricoToyotaRiga.elementWithKey(key, PersistentObject.OPTIMISTIC_LOCK);
					}
					catch (SQLException e) {
						e.printStackTrace();
						output.println(FallLett2 + KeyHelper.formatKeyString(key));
					}
					if (oe != null) {
						//logica di invio a toyota nei buffer
					}
					this.checkPointImmediate();
					if (!manager.getBatchManager().getServer().isRunning()){
						output.println(ServSchedTerm2);
						return true;
					}
				}
			}
			try {
				if (iSleepTime == 0)
					iSleepTime = 30;
				Thread.sleep(iSleepTime * 1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				output.println(ServSchedTerm3);
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	protected void init()
	{
		if (!iFirstTime)
			return;
		iFirstTime = false;
		List l = null;
		try
		{
			String where = "RUNNER_CLASS_NAME = 'it.dnd.thip.agv.YSchedulazioneBufferAgv'" +
					" AND RTRIM(USER_ID) LIKE '%" + getIdAzienda() + "'"; //Fix 12836
			l = ScheduledJob.retrieveList(where, "", false);
			if (!l.isEmpty())
				myScheduled = (ScheduledJob) l.get(0);
			else
				createScheduledJob(); //Fix 12836
			String par = myScheduled.getParameters();
			if (par != null) //Fix 12836
			{
				par = par.replace(';', (char)18);
				getDataCollector().streamToObject(this, par);
			}
			setScheduledJobId(myScheduled.getScheduledJobId()); //Fix 12836
			setOreInitiale(myScheduled.getTime());
			setStato(myScheduled.getStatus());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean retrieve(int lockType) throws SQLException {
		init();
		return true;
	}

	public void createScheduledJob() throws SQLException {
		myScheduled = (ScheduledJob) Factory.createObject(ScheduledJob.class);
		myScheduled.setScheduledJobId(WebElement.formatStringForHTML("SAGV_"+Azienda.getAziendaCorrente()));
		myScheduled.setDescription(descriptionSchedJobId);
		myScheduled.setBatchQueueId(batchQueueId);
		myScheduled.setRunnerClassName(Factory.getName("it.dnd.thip.agv.YSchedulazioneBufferAgv", Factory.CLASS));
		myScheduled.setJobPeriodicity(ScheduledJob.DAILY);
		if (Security.getCurrentUser() != null) {
			myScheduled.setUserId(((ThipUser) Security.getCurrentUser()).getId());
		}
	}

	public int save() throws SQLException {
		iDoRun = true;
		return super.save();
	}


	@SuppressWarnings("rawtypes")
	public int save(boolean force) throws SQLException {
		int rc = 0;
		if (myScheduled != null)
		{
			String par = getDataCollector().objectToStream(this);
			par = par.replace((char)18, ';');
			myScheduled.setParameters(par);
			myScheduled.setTime(getOreInitiale());
			myScheduled.setStatus(getStato());
			rc = myScheduled.save();
		}
		if (iDoRun)
		{
			if (iOreInitiale.getTime() > TimeUtils.getCurrentTime().getTime() || iExpirationTime.getTime() < TimeUtils.getCurrentTime().getTime())
				throw new ThipException(new ErrorMessage("THIP110344"));
			if (iStato != 'V')
				throw new ThipException(new ErrorMessage("THIP110345"));

			List l = null;
			try
			{
				String where = "RUNNER_CLASS_NAME = 'it.dnd.thip.agv.YSchedulazioneBufferAgv'";
				where += " AND STATUS = 'A'";
				l = BatchJob.retrieveList(where, "", false);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (l != null && l.size() > 1)
				throw new ThipException(new ErrorMessage("THIP110346"));

			rc = super.save(force);
		}
		iDoRun = false;
		return rc;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List selectPianiCaricoNonSchedulati(String aziendaCorrente) throws SQLException {
		ArrayList ret = new ArrayList();
		Database db = ConnectionManager.getCurrentDatabase();
		PreparedStatement ps = cSelectPianiCaricoNonSchedul.getStatement();
		db.setString(ps, 1, aziendaCorrente);
		ResultSet rs = ps.executeQuery();
		String key = null;
		while (rs.next()){
			String idAnnoDocumento = Column.rightTrim(rs.getString(YPianoCaricoToyotaRigaTM.ID_ANNO_DOC));
			String idNumeroDocumento = Column.rightTrim(rs.getString(YPianoCaricoToyotaRigaTM.ID_NUMERO_DOC));
			Integer idRigaDocumento = Integer.valueOf(Column.rightTrim(rs.getString(YPianoCaricoToyotaRigaTM.ID_RIGA_DOC)));
			Object[] keyParts = {aziendaCorrente, idAnnoDocumento, idNumeroDocumento, idRigaDocumento};
			key = KeyHelper.buildObjectKey(keyParts);
			ret.add(key);
		}
		rs.close();
		return ret;
	}

	@SuppressWarnings("rawtypes")
	public static List cercaBatchJob(String idAzienda) {
		List l = null;
		try
		{
			String where = "RUNNER_CLASS_NAME = 'it.dnd.thip.agv.YSchedulazioneBufferAgv'";
			where += " AND STATUS = 'A'";
			where += " AND JOB_PARAMETERS LIKE '%IdAzienda=" + idAzienda + "%'";
			l = BatchJob.retrieveList(where, "", false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}

	@Override
	protected String getClassAdCollectionName() {
		return "YSchedulazioneBufferAgv";
	}

}