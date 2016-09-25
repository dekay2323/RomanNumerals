package com.strata

import grails.validation.Validateable

class RomanNumeralCommand implements Validateable {
    String romanNumeral
    Integer number

    static constraints = {
        romanNumeral blank: true, nullable: true, length: 8
        number blank: true, nullable: true, range: 1..10000, length: 5
    }

    public String toString() {
        "romanNumeral ${romanNumeral}, number ${number}"
    }
}