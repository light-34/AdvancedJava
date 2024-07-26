package org.adv.formatter;

public enum CountryPhoneNumberCodes {
    CANADA("+1"),
    US("+1");

    CountryPhoneNumberCodes(String code) {
        this.code = code;
    }

    private final String code;

    public String getCode() {
        return code;
    }
}
