package com.strata

class RomanNumeralController {
    def romanNumeralService

    def index() {
        RomanNumeralCommand command = []
        render view: "index", model: [command: command]
    }

    def calculate(RomanNumeralCommand command) {
        if (command?.romanNumeral) {
            command.number = romanNumeralService.fromRomanNumeral(command?.romanNumeral)
        } else if (command?.number) {
            command.romanNumeral = romanNumeralService.toRomanNumeral(command?.number)
        }

        render view: "index", model: [command: command]
    }
}
