package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void PasswordChecker_CheckLenght() {
        String password = "Abc_123";
        Checker check = new Checker();
        assertTrue(check.checkLenght(password));
    }

    @Test
    void PasswordChecker_CheckUppercase() {
        String password = "Abc_123";
        Checker check = new Checker();
        assertTrue(check.checkUppercase(password));
    }

    @Test
    void PasswordChecker_CheckSpecial() {
        String password = "Abc_123";
        Checker check = new Checker();
        assertTrue(check.checkSpecial(password));
    }

    @Test
    void PhoneValidator_CheckSymbols() {
        String phoneNr = "867349813";
        Checker check = new Checker();
        assertFalse(check.checkSymbols(phoneNr));
    }

    @Test
    void PhoneValidator_CheckLenght() {
        String phoneNr = "867349813";
        Checker check = new Checker();
        assertTrue(check.CheckPhoneLenght(phoneNr));
    }

    @Test
    void PhoneValidator_CheckPrefix() {
        String phoneNr = "867349813";
        Checker check = new Checker();
        assertTrue(check.checkprefix(phoneNr));
    }

    @Test
    void EmailValidator_CheckEtaSymbol() {
        String email = "name@email.com";
        Checker check = new Checker();
        assertTrue(check.checkEtaSymbol(email));
    }

    @Test
    void EmailValidator_CheckBadSymbols() {
        String email = "name@email.com";
        Checker check = new Checker();
        assertFalse(check.checkBadSymbols(email));
    }

    @Test
    void EmailValidator_CheckDomain() {
        String email = "name@email.com";
        Checker check = new Checker();
        assertTrue(check.checkDomain(email));
    }

    @Test
    void EmailValidator_CheckTLD() {
        String email = "name@email.com";
        Checker check = new Checker();
        assertTrue(check.checkTLD(email));
    }

    @AfterEach
    void tearDown() {
    }
}