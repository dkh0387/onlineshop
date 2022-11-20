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

	public static final String SHOPPING_CART_PAGE_TITLE = "Einkaufswagen";
	public static final String PRODUCT_IMAGE = "Abbildung";
	public static final String PRODUCT_DESCRIPTION = "Beschreibung";
	public static final String PRODUCT_QUANTITY = "Menge";
	public static final String PRODUCT_PRICE = "Preis pro Stk.";

	public static final String PROD_CATALOG_PAGE_TITLE = "Produktkatalog";
	public static final String SHOW_PROD_CATALOG_NO_SEL_USER_ERROR = "Kein User für die Anzeige des Produktkatalogs ausgewählt!";
	public static final String SHOW_PROD_CATALOG_MULTI_USER_ERROR = "Der Produktkatalog kann nur für einen User angezeigt werden!";
	public static final String PROD_QUANTITY_PAGE_TITLE = "Menge";
	public static final String PROD_QUANTITY_SELECTION_ERROR = "Das ausgewählte Produkt ist in der gewünschten Menge nicht mehr verfügbar (gewünscht: %d, verfügbar: %d)!";

	public static final String PROD_SHOPPING_CART_PAGE_TITLE = "Einkaufswagen";
	public static final String PRODUCT_TOTAL_PRICE = "Gesamt";
	public static final String SHOW_SHOPPING_CART_MULTI_USER_ERROR = "Der Einkaufswagen kann nur für einen User angezeigt werden!";
	public static final String SHOW_SHOPPING_CART_NO_SEL_USER_ERROR = "Kein User für die Anzeige des Einkaufswagens ausgewählt!";
	public static final String ORDER_PLACED = "Ihre Bestellung wurde erfolgreich aufgegeben, die Bestellbestätigung wurde an %s verschickt!";
	public static final String ORDER_ADDED = "Die Auswahl wurde dem Einkaufswagen hinzugefügt!";

}
