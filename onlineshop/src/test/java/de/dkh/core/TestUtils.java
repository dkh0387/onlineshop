package de.dkh.core;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class TestUtils {

	public static Map<String, Object> createAttrMapForNegTest() {
		return Map.of(Constants.USER_NAME, "name", Constants.USER_ADRESS, "", Constants.USER_MAIL, "mail",
				Constants.USER_BDAY, LocalDate.of(1900, 12, 12));
	}

	public static Map<String, Object> createAttrMapForPosTest() {
		return Map.of(Constants.USER_NAME, "name", Constants.USER_ADRESS, "adress", Constants.USER_MAIL, "mail",
				Constants.USER_BDAY, LocalDate.of(1900, 12, 12));
	}

	public static Map<String, Object> createEmptyAttrMap() {
		return Collections.emptyMap();
	}

}
