package de.dkh.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public Validator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Proof if at least one of the fields is {@code null}.
	 * 
	 * @param map
	 * @return
	 */
	public List<String> validateFields(Map<String, Object> map) {

		if (map.isEmpty()) {
			return null;
		}
		List<String> emptyFieldList = new ArrayList<>();

		map.keySet().forEach(field -> {

			if (map.get(field).equals("")) {
				emptyFieldList.add(field);
			}
		});
		return emptyFieldList;
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public boolean validateMail(String emailStr) {

		if (emailStr == null) {
			return false;
		}
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

}
