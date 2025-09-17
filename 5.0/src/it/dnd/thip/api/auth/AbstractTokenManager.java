package it.dnd.thip.api.auth;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Super-classe che gestisce cache, scadenza e rinnovo thread-safe.
 * Le sottoclassi implementano fetchToken() con la chiamata reale.
 */
public abstract class AbstractTokenManager implements TokenProvider {

	private static final long DEFAULT_SKEW_MS = 30_000L; // margine 30s
	private final ReentrantLock lock = new ReentrantLock();

	private volatile String token;
	private volatile long expiryEpochMillis;
	private final long skewMs;

	protected AbstractTokenManager() {
		this(DEFAULT_SKEW_MS);
	}
	protected AbstractTokenManager(long skewMs) {
		this.skewMs = Math.max(0, skewMs);
	}

	@Override
	public String getToken() {
		// Fast path senza lock
		if (token == null || isExpiredWithSkew()) {
			refreshIfNeeded();
		}
		return token;
	}

	private boolean isExpiredWithSkew() {
		return System.currentTimeMillis() + skewMs >= expiryEpochMillis;
	}

	private void refreshIfNeeded() {
		lock.lock();
		try {
			if (token == null || isExpiredWithSkew()) {
				TokenResponse tr = fetchToken();
				if (tr == null || tr.getToken() == null) {
					throw new IllegalStateException("fetchToken() ha restituito un risultato nullo o senza token");
				}
				this.token = tr.getToken();
				this.expiryEpochMillis = tr.getExpiryEpochMillis();
			}
		} finally {
			lock.unlock();
		}
	}

	/**
	 * Le sottoclassi implementano la logica di chiamata e parsing.
	 * Devono restituire un TokenResponse con epochMillis di scadenza.
	 */
	protected abstract TokenResponse fetchToken();
}
