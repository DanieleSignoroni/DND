import java.io.PrintWriter;

import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.security.Security;

import it.thera.thip.logis.bas.ConfigurazioneClasse;

public class MENUEXP {

	public static void main(String[] args) {
		try {
			Security.setCurrentDatabase("DND", null);
			Security.openMainSession("ADMIN_001", "ADMIN1");
			if (Security.isCurrentDatabaseSetted()) {
				String[] keys = new String[] { KeyHelper.buildObjectKey(new String[] { "MENURF", "YPROC_LIST_CARI" }) };
				PrintWriter pr = new PrintWriter(System.out);
				ConfigurazioneClasse.export(pr, keys);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
