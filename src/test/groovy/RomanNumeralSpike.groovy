import spock.lang.Specification
import spock.lang.Unroll

/**
 * Quick Spike at a Roman Numerals Solver.
 * Starting to use subtractive
 *
 * https://en.wikipedia.org/wiki/Roman_numerals
 *
 * Created by demian on 2016-09-21.
 */
class RomanNumeralSpike extends Specification {
    def romanNumeralValues = [M:1000, CM:900, D:500, CD:400, C:100, XC:90, L:50, XL:40, X:10, IX:9, V:5, IV:4, I:1]

    def toRomanNumeral = {anInteger ->
        romanNumeralValues.inject("") { curAnswer, pair ->
            if (anInteger/pair.value >= 1) {
                def number = anInteger.intdiv(pair.value)
                anInteger = anInteger - (number*pair.value)
                curAnswer + "${pair.key}" * number
            } else {
                curAnswer
            }
        }
    }

    def fromRomanNumeral = {anRomanNumeral ->
        println "original ${anRomanNumeral}"
        romanNumeralValues.inject(0) { curAnswer, pair ->
            if (anRomanNumeral.find(pair.key)) {
                while(anRomanNumeral.find(pair.key)) {
                    anRomanNumeral = anRomanNumeral.substring(pair.key.size())
                    println "changing ${anRomanNumeral}"
                    curAnswer = curAnswer + pair.value
                    anRomanNumeral.find(pair.key)
                }
                curAnswer
            } else {
                curAnswer
            }
        }
    }

    def "fast test"() {
        when:
        def ans = fromRomanNumeral('IV')
        then:
        ans == 3
    }

    @Unroll
    def "Solve from #anInteger = #romanNumeral"() {
        expect:
        toRomanNumeral(anInteger) == romanNumeral

        where:
        anInteger   || romanNumeral
        1           || 'I'
        2           || 'II'
        3           || 'III'
        4           || 'IV'
        5           || 'V'
        6           || 'VI'
        7           || 'VII'
        8           || 'VIII'
        9           || 'IX'
        10          || 'X'
        11          || 'XI'
        12          || 'XII'
        13          || 'XIII'
        14          || 'XIV'
        15          || 'XV'
        49          || 'XLIX'
        50          || 'L'
        51          || 'LI'
        99          || 'XCIX'
        100         || 'C'
        101         || 'CI'
        500         || 'D'
        1000        || 'M'
        2016        || 'MMXVI'
    }

    @Unroll
    def "Solve from #romanNumeral = #anInteger"() {
        expect:
        fromRomanNumeral(romanNumeral) == anInteger

        where:
        anInteger   || romanNumeral
        1           || 'I'
        2           || 'II'
        3           || 'III'
        4           || 'IV'
        5           || 'V'
        6           || 'VI'
        7           || 'VII'
        8           || 'VIII'
        9           || 'IX'
        10          || 'X'
        11          || 'XI'
        12          || 'XII'
        13          || 'XIII'
        14          || 'XIV'
        15          || 'XV'
        49          || 'XLIX'
        50          || 'L'
        51          || 'LI'
        99          || 'XCIX'
        100         || 'C'
        101         || 'CI'
        500         || 'D'
        1000        || 'M'
        2016        || 'MMXVI'
    }
}
