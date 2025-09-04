package it.dnd.thip.auth;

public interface TokenProvider {
	/** Ritorna un token valido (rinnova se scaduto). */
	String getToken();
}
