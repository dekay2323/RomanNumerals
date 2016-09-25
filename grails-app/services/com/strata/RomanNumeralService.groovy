package com.strata

import grails.transaction.NotTransactional


class RomanNumeralService {

    @NotTransactional
    def Integer fromRomanNumeral(String romanNumeral) throws NumberFormatException {
        // Call the JAVA
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl();
        convertor.fromRomanNumeral(romanNumeral)
    }

    @NotTransactional
    def String toRomanNumeral(Integer number) {
        // Call the JAVA
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl();
        convertor.toRomanNumeral(number.intValue())
    }
}
