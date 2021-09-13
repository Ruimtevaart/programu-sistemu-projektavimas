package com.company;

public class Checker {
    public boolean checkLenght(String password) {
        return true;
    }

    public boolean checkUppercase(String password) {
        return true;
    }

    public boolean checkSpecial(String password) {
        return true;
    }

    public boolean checkSymbols(String phoneNr) {
        return false;
    }

    public boolean checkprefix(String phoneNr) {
        return true;
    }

    public boolean CheckPhoneLenght(String phoneNr) {
        return true;
    }

    public boolean checkEtaSymbol(String email) {
        return true;
    }

    public boolean checkBadSymbols(String email) {
        return false;
    }

    public boolean checkDomain(String email) {
        return true;
    }

    public boolean checkTLD(String email) {
        return true;
    }
}
