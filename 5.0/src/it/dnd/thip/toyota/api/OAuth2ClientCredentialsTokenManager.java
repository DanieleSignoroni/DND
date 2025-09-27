package it.dnd.thip.toyota.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.thera.thermfw.web.URLUtils;

import it.dnd.thip.api.auth.AbstractTokenManager;
import it.dnd.thip.api.auth.TokenResponse;

public class OAuth2ClientCredentialsTokenManager extends AbstractTokenManager {

	private final String tokenUrl;
	private final String clientId;
	private final String clientSecret;
	private final String scope;   // opzionale/multiplo separato da spazi

	public OAuth2ClientCredentialsTokenManager(
			String tokenUrl, String clientId, String clientSecret, String scope) {
		super(30_000L);
		this.tokenUrl = tokenUrl;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.scope = scope;
	}

	@Override
	protected TokenResponse fetchToken() {
		try {
			// Build x-www-form-urlencoded body (encode each VALUE once)
			StringBuilder form = new StringBuilder()
					.append("grant_type=client_credentials")
					.append("&client_id=").append(urlEncode(clientId))
					.append("&client_secret=").append(urlEncode(clientSecret));

			if (scope != null && !scope.trim().isEmpty()) {
				form.append("&scope=").append(urlEncode(scope)); // spaces -> +
			}

			byte[] bytes = form.toString().getBytes(StandardCharsets.UTF_8);

			// POST to the final token endpoint (HTTPS, no redirects)
			URL url = new URL(tokenUrl + "Auth/connect/token");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setInstanceFollowRedirects(false);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Length", String.valueOf(bytes.length));

			try (OutputStream os = conn.getOutputStream()) {
				os.write(bytes);
			}

			int code = conn.getResponseCode();

			String resp;
			try (InputStream is = (code >= 200 && code < 300) ? conn.getInputStream() : conn.getErrorStream();
					java.util.Scanner sc = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A")) {
				resp = sc.hasNext() ? sc.next() : "";
			}

			if (code / 100 != 2) {
				// include body for easier debugging
				throw new RuntimeException("OAuth2 token call failed: HTTP " + code + " - " + resp);
			}

			// Parse JSON and return token
			JSONObject json = new JSONObject(resp);
			if (!json.has("access_token")) {
				String err = json.optString("error_description", json.optString("error", "missing access_token"));
				throw new RuntimeException("OAuth2 response missing access_token: " + err + " | body=" + resp);
			}

			String accessToken = json.getString("access_token");
			long expiresInSec = json.optLong("expires_in", 3600L);
			long expiryMs = System.currentTimeMillis() + (expiresInSec * 1000L);

			return new TokenResponse(accessToken, expiryMs);

		} catch (Exception e) {
			throw new RuntimeException("Errore durante fetchToken OAuth2", e);
		}
	}

	private static String urlEncode(String s) {
		try {
			return URLUtils.get().encode(s);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
