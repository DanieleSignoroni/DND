package it.dnd.thip.logis.bas;

import it.thera.thip.logis.bas.ParametriLogis;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.persist.KeyHelper;

/**
 * <p></p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 10/04/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 71923    10/04/2025  DSSOF3   Prima stesura
 */

public class YCostantiDnd {

	public static String DND_XML = "it/dnd/thip/logis/rf/xml/Dnd.xml";

	@SuppressWarnings("rawtypes")
	protected static Map valoriParametri = new HashMap();
	protected static final String NULL_VALUE = "-";

	@SuppressWarnings("unchecked")
	public static String getValoreParametro(String sezione, String chiave) {
		String sezChiave = KeyHelper.buildObjectKey(new String[] { sezione, chiave });
		String valore = (String) valoriParametri.get(sezChiave);
		if (valore == null) {
			valore = ParametriLogis.valoreDiSezioneChiave(sezione, chiave);
			if (valore == null)
				valore = NULL_VALUE;
			valoriParametri.put(sezChiave, valore);
		}
		if (NULL_VALUE.equals(valore)) {
			Trace.println("Valore non trovato per la chiave " + sezione + "/" + chiave);
			return null;
		}
		return valore;
	}

	public static String searchXml(){
		String defaultXml = DND_XML;
		URL url = YCostantiDnd.class.getClassLoader().getResource(defaultXml);
		if(url != null){
			return url.toString();
		}
		return DND_XML;
	}

}
