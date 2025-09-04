package it.dnd.thip.toyota;

import javax.ws.rs.core.Response.Status.Family;
import org.json.JSONObject;
import it.thera.thip.api.client.ApiClient;
import it.thera.thip.api.client.ApiRequest;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;
import it.dnd.thip.auth.AbstractTokenManager;
import it.dnd.thip.auth.TokenResponse;

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
			ApiClient apiClient = new ApiClient("");
			ApiRequest apiReq = new ApiRequest(Method.POST, tokenUrl);
			apiReq.addHeader("Content-Type", "application/x-www-form-urlencoded");

			// Corpo form-encoded
			StringBuilder form = new StringBuilder()
					.append("grant_type=client_credentials")
					.append("&client_id=").append(urlEncode(clientId))
					.append("&client_secret=").append(urlEncode(clientSecret));

			if (scope != null && !scope.isEmpty()) {
				form.append("&scope=").append(urlEncode(scope));
			}
			apiReq.setBody(form.toString());

			ApiResponse apiResp = apiClient.send(apiReq);
			if (apiResp.getStatus().getFamily() != Family.SUCCESSFUL) {
				throw new RuntimeException("OAuth2 token call fallita: " + apiResp.getBodyAsString());
			}

			JSONObject resp = apiResp.getBodyAsJSONObject();
			if (!resp.has("access_token")) {
				throw new RuntimeException("Risposta OAuth2 priva di access_token");
			}

			String accessToken = resp.getString("access_token");
			long expiresInSec = resp.optLong("expires_in", 3600L);
			long expiryMs = System.currentTimeMillis() + (expiresInSec * 1000L);

			return new TokenResponse(accessToken, expiryMs);
		} catch (Exception e) {
			throw new RuntimeException("Errore durante fetchToken OAuth2", e);
		}
	}

	private static String urlEncode(String s) {
		try {
			return java.net.URLEncoder.encode(s, java.nio.charset.StandardCharsets.UTF_8.name());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
