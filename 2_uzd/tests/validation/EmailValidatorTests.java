package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validation.Validator;

class EmailValidatorTests {

	Validator validator;

	@BeforeEach
	void setUp() {
		validator  = new Validator();
	}
	
	@Test
	void emailValidator_emptyEmail_shouldReturnFalse() {
		String email = "";
		boolean valid = validator.emptyEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_emptyEmailBeforeAt_shouldReturnFalse() {
		String email = "@gmail.com";
		boolean valid = validator.emptyEmailBeforeAt(email);
		assertFalse(valid);
	}
	
	@Test
	void SemailValidator_hasAtymbol_shouldReturnFalse() {
		String email = "testgmail.com";
		boolean valid = validator.hasAtSymbol(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasAtSymbol_shouldReturnTrue() {
		String email = "test@gmail.com";
		boolean valid = validator.hasAtSymbol(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasIllegalSymbol_shouldReturnFalse() {
		String email = "test@gmail.com";
		boolean valid = validator.hasIllegalSymbol(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasIllegalSymbol_shouldReturnTrue() {
		String email = "tčst@gmail.com";
		boolean valid = validator.hasIllegalSymbol(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasCorrectDomain_shouldReturnTrue() {
		String email = "test@gmail.com";
		boolean valid = validator.hasCorrectDomain(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasCorrectDomain_shouldReturnFalse() {
		String email = "test@.com";
		boolean valid = validator.hasCorrectDomain(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasCorrectTopDomain_shouldReturnFalse() {
		String email = "test@gmail.com3pr";
		boolean valid = validator.hasCorrectTopDomain(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasCorrectTopDomain_shouldReturnTrue() {
		String email = "test@.com";
		boolean valid = validator.hasCorrectTopDomain(email);
		assertTrue(valid);
	}
}
