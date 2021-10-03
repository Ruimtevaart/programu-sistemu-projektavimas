package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validation.Validator;

class PhoneValidatorTests {

	Validator validator;

	@BeforeEach
	void setUp() {
		validator  = new Validator();
	}
	
	@Test
	void phoneValidator_numberTooShort_shouldReturnFalse() {
		String number = "+3765";
		validator.phoneLength(12);
		boolean valid = validator.numberTooShort(number);
		assertFalse(valid);
	}
	
	@Test
	void phoneValidator_numberTooLong_shouldReturnFalse() {
		String number = "+370645899457";
		validator.phoneLength(12);
		boolean valid = validator.numberTooLong(number);
		assertFalse(valid);
	}
	
	@Test
	void phoneValidator_numberHasNotNumber_shouldReturnFalse() {
		String number = "+370645a9945";
		boolean valid = validator.numberHasNotNumber(number);
		assertFalse(valid);
	}
	
	@Test
	void phoneValidator_numberLTChangedToInternational_shouldReturnTrue() {
		String number = "864589945";
		boolean valid = validator.numberLTChangedToInternational(number);
		assertTrue(valid);
	}
	
	@Test
	void phoneValidator_numberMatchesCountryCodeLT_shouldReturnTrue() {
		String number = "+37064559945";
		boolean valid = validator.numberMatchesCountryCodeLT(number);
		assertTrue(valid);
	}
	
	@Test
	void phoneValidator_numberMatchesCountryCodeLV_shouldReturnTrue() {
		String number = "+37164565020";
		validator.phoneCountry("LV","+371");
		boolean valid = validator.numberMatchesCountryCodeLV(number);
		assertTrue(valid);
	}
}
