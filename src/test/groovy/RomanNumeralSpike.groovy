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
        def buckets = [X:0, V:0, I:0]
        println "decimal = ${decimal}"
        charValues.each { charVal ->
            println "charVal.value = ${charVal.value}"
            println "decimal/charVal.value = ${decimal/charVal.value}"
            println "decimal%charVal.value = ${decimal%charVal.value}"
            if (decimal/charVal.value >= 1) {
                buckets.(charVal.key) += decimal.intdiv(charVal.value)
                decimal = decimal - (decimal.intdiv(charVal.value)*charVal.value)
                println "new decimal = ${decimal}"
            }
            println "buckets = ${buckets}"
        }
        def answer = buckets.inject("") { result, charVal ->
            if (charVal.value > 0) {
                result += "${charVal.key}" * charVal.value
            } else {
                result
            }
        }
        answer
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
        12          || 'XII'
        13          || 'XIII'
        14          || 'XIIII'
        14          || 'XV'
    }
}
