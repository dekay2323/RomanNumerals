package com.strata

class RomanNumeralController {
    def romanNumeralService

    def index() {
        RomanNumeralCommand command = []
        render view: "index", model: [command: command]
    }

    def calculate(RomanNumeralCommand command) {
        String calcRomanNumeral = (command?.number) ? romanNumeralService.toRomanNumeral(command?.number) : 0
        Integer calcNumber = (command?.romanNumeral) ? romanNumeralService.fromRomanNumeral(command?.romanNumeral) : ""

        render view: "index", model: [command: command, calcRomanNumeral: calcRomanNumeral, calcNumber: calcNumber]
    }
}
