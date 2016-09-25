package com.strata

class RomanNumeralController {
    def romanNumeralService

    def index() {
        RomanNumeralCommand command = []

        render view: "index", model: [command: command]
    }

    def calculate(RomanNumeralCommand command) {
        if (command.hasErrors()) {
            render view: "index", model: [command: command]
            return
        }

        if (command?.romanNumeral) {
            try {
                command.number = romanNumeralService.fromRomanNumeral(command?.romanNumeral)
            } catch (NumberFormatException e) {
                command.errors.rejectValue(
                        'romanNumeral',
                        '',
                        e.getMessage())
            }
        } else if (command?.number) {
            command.romanNumeral = romanNumeralService.toRomanNumeral(command?.number)
        }

        render view: "index", model: [command: command]
    }
}
