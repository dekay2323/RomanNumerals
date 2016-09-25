package com.strata

import grails.validation.Validateable

class RomanNumeralCommand implements Validateable {
    String romanNumeral
    Integer number

    static constraints = {
        romanNumeral blank: true, nullable: true
        number blank: true, nullable: true
    }

    public String toString() {
        "romanNumeral ${romanNumeral}, number ${number}"
    }
}