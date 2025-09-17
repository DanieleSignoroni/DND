package it.dnd.thip.api.auth;

public final class TokenResponse {
	private final String token;
	private final long expiryEpochMillis;

	public TokenResponse(String token, long expiryEpochMillis) {
		this.token = token;
		this.expiryEpochMillis = expiryEpochMillis;
	}
	public String getToken() { return token; }
	public long getExpiryEpochMillis() { return expiryEpochMillis; }
}
