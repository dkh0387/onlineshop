package de.dkh.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
	private Validator validator;
	private Map<String, Object> attrMap;
	private final static String VALID_MAIL = "abc@gmail.com";
	private final static String INVALID_MAIL_1 = "abc_gmail.com";
	private final static String INVALID_MAIL_2 = "abc@gmail_com";
	private final static String INVALID_MAIL_3 = "abc@x.";

	@BeforeEach
	void setUp() throws Exception {
		validator = new Validator();
	}

	@Test
	@DisplayName("Validation of fields: " + "Testing the case at least one attribute is empty")
	void validateFieldsTest1() {
		attrMap = TestUtils.createAttrMapForNegTest();
		assertTrue(!validator.validateFields(attrMap).isEmpty());
	}

	@Test
	@DisplayName("Validation of fields: " + "Testing the case the whole map is empty")
	void validateFieldsTest2() {
		attrMap = TestUtils.createEmptyAttrMap();
		assertTrue(validator.validateFields(attrMap) == null);
	}

	@Test
	@DisplayName("Validation of fields: " + "Testing the case all attributes are valid")
	void validateFieldsTest3() {
		attrMap = TestUtils.createAttrMapForPosTest();
		assertTrue(validator.validateFields(attrMap).isEmpty());
	}

	@Test
	@DisplayName("Validation of mail: " + "Testing if the mail is null")
	void validateMailTest1() {
		assertFalse(validator.validateMail(null));
	}

	@Test
	@DisplayName("Validation of mail: " + "Testing if the mail is valid")
	void validateMailTest2() {
		assertTrue(validator.validateMail(VALID_MAIL));
	}

	@DisplayName("Validation of mail: " + "Testing if the mail is invalid")
	@ParameterizedTest(name = "{index} => message=''{0}''")
	@ValueSource(strings = { INVALID_MAIL_1, INVALID_MAIL_2, INVALID_MAIL_3 })
	void validateMailTest3(String mail) {
		assertFalse(validator.validateMail(mail));
	}

}
