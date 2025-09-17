package it.dnd.thip.toyota.utils;

/**
 * <p>Definisce lo stato di un 'Transport' in Toyota</p>
 *
 * <p>
 * Company: Softre Solutions<br>
 * Author: Daniele Signoroni<br>
 * Date: 17/09/2025
 * </p>
 */

/*
 * Revisions:
 * Number   Date        Owner    Description
 * 72XXX    17/09/2025  DSSOF3   Prima stesura
 */

public class TransportState {

	public static final char PENDING = '0';
	public static final char ON_GOIN = '1';
	public static final char WAITING = '2';
	public static final char COMPLETED = '3';
	public static final char ABORTED = '4';
	public static final char REJECTED = '5';
	public static final char ERROR = '6';
}
