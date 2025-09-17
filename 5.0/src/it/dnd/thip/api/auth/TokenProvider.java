package it.dnd.thip.api.auth;

public interface TokenProvider {
	/** Ritorna un token valido (rinnova se scaduto). */
	String getToken();
}
