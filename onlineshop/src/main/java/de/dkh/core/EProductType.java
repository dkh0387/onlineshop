package de.dkh.core;

public enum EProductType {
	MARMALADE, CHOCOLATE_CREAM, INSTANT_COFFEE, SUGAR;

	private final static String SOURCE_PATH = "/de/dkh/onlineshop/images/";

	public String getImageSource() {
		switch (this) {
		case MARMALADE:
			return SOURCE_PATH + "marmalade.png";

		case CHOCOLATE_CREAM:
			return SOURCE_PATH + "chocolatecream.png";

		case INSTANT_COFFEE:
			return SOURCE_PATH + "instantcoffee.png";

		case SUGAR:
			return SOURCE_PATH + "sugar.png";
		}
		return null;
	}
}
