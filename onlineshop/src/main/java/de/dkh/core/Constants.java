package de.dkh.core;

/**
 * All the globals needed.
 * 
 * @author dkh
 *
 */
public final class Constants {

	private Constants() {

	}

	public static final String PAGE_TITLE = "User-Verwaltung";
	public static final String USER_NAME = "Name";
	public static final String USER_ADRESS = "Adresse";
	public static final String USER_MAIL = "E-Mail";
	public static final String USER_BDAY = "Geburtsdatum";

	public static final String USER_DELETE_DIALOG_TEXT = "Sind Sie sicher, dass sie die ausgewählten User löschen wollen?";
	public static final String USER_DELETE_DIALOG_TITLE = "User löschen";
	public static final String USER_DELETE_NO_SELECTION = "Keine User ausgewählt!";

	public static final String NEW_USER_PAGE_TITLE = "Neuen User anlegen";
	public static final String BTN_OK = "OK";
	public static final String USER_NEW_FIELDS_ERROR = "Folgende Felder dürfen nicht leer sein: %s";
	public static final String USER_NEW_MAIL_ERROR = "Die eingegebene E-Mail entspricht nicht dem richtigen Format!";
}
