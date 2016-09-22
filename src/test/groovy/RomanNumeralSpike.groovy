import spock.lang.Specification
import spock.lang.Unroll

/**
 * Quick Spike at a Roman Numerals Solver.
 * Non Subtractive first then subtractive
 *
 * https://en.wikipedia.org/wiki/Roman_numerals
 *
 * Created by demian on 2016-09-21.
 */
class RomanNumeralSpike extends Specification {
    def charValues = [X:10, V:5, I:1]

    def romanSolver = {decimal ->
        charValues.each {charVal ->
            println "decimal(${decimal}) % char.value(${charVal.value})"
            if (decimal % charVal.value >= 0) {
                (1..(decimal / charVal.value)).each {
                    println charVal.key
                }
            }
        }
    }

    @Unroll
    def "Roman Numerals solver (non subtractive) #decimal = #romanNumeral"() {
        expect:
        romanSolver(decimal) == romanNumeral

        where:
        decimal     || romanNumeral
        1           || 'I'
        2           || 'II'
        3           || 'III'
        4           || 'IIII'
        5           || 'V'
        6           || 'VI'
        7           || 'VII'
        8           || 'VIII'
        9           || 'VIIII'
        10          || 'X'
        11          || 'XI'
        12          || 'XI'
        13          || 'XI'
        14          || 'XIIII'
        14          || 'XV'
    }
}
