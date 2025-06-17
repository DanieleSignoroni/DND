package it.dnd.thip.vendite.documentoVE.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.ErrorList;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.util.file.FTPConnection;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.BaseServlet;

import it.dnd.thip.leanLift.InterfacciaLeanLift;
import it.thera.thip.cs.ThipException;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;

/**
 *
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 17/06/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71XXX    17/06/2025  DSSOF3   Prima stesura
 */

public class InviaListaPrelievoLeanLift extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void processAction(ServletEnvironment se) throws Exception {
		ErrorList el = new ErrorList();
		boolean daEstratto = false;
		if(( (Boolean) se.getRequest().getAttribute("DaEstratto") != null &&
				((Boolean) se.getRequest().getAttribute("DaEstratto")).booleanValue() == true)){
			daEstratto = true;
		}
		List lstChiaviSelected = (List) se.getRequest().getAttribute("lstChiaviSelected");
		List chiavi = new ArrayList();
		String singleKey = se.getRequest().getParameter(KEY);
		if(lstChiaviSelected != null && !lstChiaviSelected.isEmpty()) {
			chiavi.addAll(lstChiaviSelected);
		}else if(singleKey != null) {
			chiavi.add(singleKey);
		}

		File outputFile = null;
		BufferedWriter writer = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String fName = "listePrelievo_";	
			fName += sdf.format(TimeUtils.getCurrentTimestamp());
			outputFile = File.createTempFile(fName, ".txt");
			writer = new BufferedWriter(new FileWriter(outputFile));

			int count = 0;
			Iterator iterKeys = chiavi.iterator();
			while(iterKeys.hasNext()) {
				String key = (String) iterKeys.next();
				DocumentoVendita docVen = (DocumentoVendita) DocumentoVendita.elementWithKey(DocumentoVendita.class, key, PersistentObject.NO_LOCK);
				if(docVen != null) {
					String line = InterfacciaLeanLift.recordListaPrelievo(docVen);
					if(line != null) {
						if(count > 0)
							writer.newLine();
						if (line != null && !line.isEmpty()) {
							writer.write(line);
						}
						count++;
					}
				}
			}
			writer.flush();
		} catch (ThipException ex) {
			el.addError(new ErrorMessage("BAS0000078",ex.getMessage()));
			ex.printStackTrace(Trace.excStream);
		} finally {
			try {
				if (writer != null) writer.close();
			} catch (Exception e) {
				el.addError(new ErrorMessage("BAS0000078",e.getMessage()));
				e.printStackTrace(Trace.excStream);
			}
		}

		if(el.getErrors().isEmpty()) {
			if(outputFile != null) {
				FTPConnection conn = new FTPConnection(); 
				if(conn.connect(InterfacciaLeanLift.ip, InterfacciaLeanLift.port)) {
					boolean logged = conn.login(InterfacciaLeanLift.userName, InterfacciaLeanLift.pwd);
					if(logged) {
						boolean risUpload = conn.uploadFile("\\idk", outputFile.getAbsolutePath());
						if(risUpload) {
							//faccio save di un timestamp?
						}
					}
					conn.disconnect();
				}
			}
		}

		se.addErrorMessages(el.getErrors());

		if(!daEstratto) {
			se.sendRequest(getServletContext(), "com/thera/thermfw/common/InfoAreaHandler.jsp", false);
		}else {
			se.sendRequest(getServletContext(), "com/thera/thermfw/common/ErrorListHandler.jsp", false);
		}
	}

}
