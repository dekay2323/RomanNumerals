package com.strata

import grails.converters.JSON

class RomanNumeralController {
    def romanNumeralService

    def index() {
        RomanNumeralCommand command = []
        render view: "index", model: [command: command]
    }

    def calculate(RomanNumeralCommand command) {
        if (command.hasErrors()) {
            withFormat {
                html {
                    render view: "index", model: [command: command]
                }
                json {
                    response.status = 400
                    render command.errors as JSON
                }
            }
            return
        }

        if (command?.romanNumeral) {
            try {
                command.number = romanNumeralService.fromRomanNumeral(command?.romanNumeral)
            } catch (NumberFormatException e) {
                command.errors.rejectValue('romanNumeral','',e.getMessage())
            }
        } else if (command?.number) {
            command.romanNumeral = romanNumeralService.toRomanNumeral(command?.number)
        }
        withFormat {
            html {
                render view: "index", model: [command: command]
            }
            json {
                def json = [
                    romanNumeral: command?.romanNumeral,
                    number: command?.number
                ]
                render json as JSON
            }
        }
    }

    def exceptionHandler(Exception e) {
        flash.message = e.getMessage()
        log.error "Exception ${e.getMessage()}", e
        withFormat {
            html {
                render view: "index", model: [command: new RomanNumeralCommand()]
            }
            json {
                response.status = 400
                def json = [
                        errors: [message: "${e.getMessage()}"]
                ]
                render json as JSON
            }
        }
    }
}
