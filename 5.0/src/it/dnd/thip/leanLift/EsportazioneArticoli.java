package it.dnd.thip.leanLift;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.util.file.FTPConnection;

import it.thera.thip.base.articolo.ArticoloBarcode;
import it.thera.thip.base.articolo.ArticoloBarcodeTM;
import it.thera.thip.base.articolo.ArticoloTM;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.DatiComuniEstesi;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 11/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    11/06/2025  DSSOF3   Prima stesura
 */

public class EsportazioneArticoli extends BatchRunnable implements Authorizable {

	@Override
	protected boolean run() {
		boolean isOk = true;
		try {
			File fileToDeposit = generaFileArticoliLeanLift();
			if(fileToDeposit != null) {
				FTPConnection conn = new FTPConnection(); 
				if(conn.connect(InterfacciaLeanLift.ip, InterfacciaLeanLift.port)) {
					boolean logged = conn.login(InterfacciaLeanLift.userName, InterfacciaLeanLift.pwd);
					if(logged) {
						boolean risUpload = conn.uploadFile("\\idk", fileToDeposit.getAbsolutePath());
						if(risUpload) {
							//faccio save di un timestamp?
						}
					}
					conn.disconnect();
				}
			}
		}catch (Exception e) {
			isOk = false;
			e.printStackTrace(Trace.excStream);
		}
		return isOk;
	}

	protected File generaFileArticoliLeanLift() {
		String select = "SELECT "
				+ " A."+ArticoloTM.DESCRIZIONE+",AB."+ArticoloBarcodeTM.ID_COD_BARRE+" "
				+ "FROM "
				+ " THIP.ARTICOLI A "
				+ "INNER JOIN THIP.ART_BARCODE AB "
				+ "ON "
				+ " A.ID_AZIENDA = AB.ID_AZIENDA "
				+ " AND A.ID_ARTICOLO = AB.ID_ARTICOLO "
				+ "WHERE "
				+ " A.STATO = '" + DatiComuniEstesi.VALIDO + "' "
				+ " AND A.ID_AZIENDA = '" + Azienda.getAziendaCorrente() + "' "
				+ " AND AB.R_TIPO_COD_BARRE = 'EAN13' "
				+ " AND AB.TIPO_PROP_BAR = '" + ArticoloBarcode.AZIENDA + "' ";
		CachedStatement cs = null;
		ResultSet rs = null;
		File outputFile = null;
		BufferedWriter writer = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String fName = "articoliLeanLift_";	
			fName += sdf.format(TimeUtils.getCurrentTimestamp());
			outputFile = File.createTempFile(fName, ".txt");
			writer = new BufferedWriter(new FileWriter(outputFile));

			int count = 0;
			cs = new CachedStatement(select);
			rs = cs.executeQuery();
			while (rs.next()) {
				String line = InterfacciaLeanLift.recordArticolo(rs.getString(ArticoloBarcodeTM.ID_COD_BARRE).trim(),
						rs.getString(ArticoloTM.DESCRIZIONE).trim());
				if(line != null) {
					if(count > 0)
						writer.newLine();
					if (line != null && !line.isEmpty()) {
						writer.write(line);
					}
					count++;
				}
			}
			writer.flush();
		} catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
		} finally {
			try {
				if (writer != null) writer.close();
				if (rs != null) rs.close();
				if (cs != null) cs.free();
			} catch (Exception e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return outputFile;
	}


	@Override
	protected String getClassAdCollectionName() {
		return "YExpArtLeanLift";
	}

}
