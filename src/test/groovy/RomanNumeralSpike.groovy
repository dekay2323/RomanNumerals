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

    def toRomanNumeral = {anInteger ->
        def buckets = [X:0, V:0, I:0]
        println "decimal = ${anInteger}"
        charValues.each { pair ->
            println "charVal.value = ${pair.value}"
            println "anInteger/charVal.value = ${anInteger/pair.value}"
            println "anInteger%charVal.value = ${anInteger%pair.value}"
            if (anInteger/pair.value >= 1) {
                buckets.(pair.key) += anInteger.intdiv(pair.value)
                anInteger = anInteger - (anInteger.intdiv(pair.value)*pair.value)
                println "new anInteger = ${anInteger}"
            }
            println "buckets = ${buckets}"
        }
        def answer = buckets.inject("") { result, pair ->
            if (pair.value > 0) {
                result += "${pair.key}" * pair.value
            } else {
                result
            }
        }
        answer
    }

    @Unroll
    def "Roman Numerals solver (non subtractive) #anInteger = #romanNumeral"() {
        expect:
        toRomanNumeral(anInteger) == romanNumeral

        where:
        anInteger     || romanNumeral
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
