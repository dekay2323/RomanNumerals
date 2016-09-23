import com.strata.RomanNumerConverterImpl
import com.strata.RomanNumeralConverter
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Quick Spike at a Roman Numerals Solver.
 *
 * https://en.wikipedia.org/wiki/Roman_numerals
 *
 * Created by demian on 2016-09-21.
 */
class RomanNumeralSpike extends Specification {
    def toRomanNumeralPairs = [M: 1000, CM: 900, D: 500, CD: 400, C: 100, XC: 90, L: 50, XL: 40, X: 10, IX: 9, V: 5, IV: 4, I: 1]
    def fromRomanNumeralPairs = [CM: 900, M: 1000, CD: 400, D: 500, XC: 90, C: 100, XL: 40, L: 50, IX: 9, X: 10, IV: 4, V: 5, I: 1]

    def toRomanNumeral = { anInteger ->
        toRomanNumeralPairs.inject("") { curAnswer, pair ->
            if (anInteger / pair.value >= 1) {
                def number = anInteger.intdiv(pair.value)
                anInteger = anInteger - (number * pair.value)
                curAnswer + "${pair.key}" * number
            } else {
                curAnswer
            }
        }
    }

    def fromRomanNumeral = { anRomanNumeral ->
        println "original ${anRomanNumeral}"
        fromRomanNumeralPairs.inject(0) { curAnswer, pair ->
            while (anRomanNumeral.find(pair.key)) {
                anRomanNumeral = anRomanNumeral.substring(pair.key.size())
                println "changing ${anRomanNumeral}"
                curAnswer = curAnswer + pair.value
                anRomanNumeral.find(pair.key)
            }
            curAnswer
        }
    }

    @Unroll
    def "GROOVY Solve from toRomanNumeral(#anInteger) = #romanNumeral"() {
        expect:
        toRomanNumeral(anInteger) == romanNumeral

        where:
        anInteger || romanNumeral
        1         || 'I'
        2         || 'II'
        3         || 'III'
        4         || 'IV'
        5         || 'V'
        6         || 'VI'
        7         || 'VII'
        8         || 'VIII'
        9         || 'IX'
        10        || 'X'
        11        || 'XI'
        12        || 'XII'
        13        || 'XIII'
        14        || 'XIV'
        15        || 'XV'
        49        || 'XLIX'
        50        || 'L'
        51        || 'LI'
        95        || 'XCV'
        99        || 'XCIX'
        100       || 'C'
        101       || 'CI'
        404       || 'CDIV'
        500       || 'D'
        1000      || 'M'
        1443      || 'MCDXLIII'
        2016      || 'MMXVI'
    }

    @Unroll
    def "GROOVY Solve from #romanNumeral = #anInteger"() {
        expect:
        fromRomanNumeral(romanNumeral) == anInteger

        where:
        anInteger || romanNumeral
        1         || 'I'
        2         || 'II'
        3         || 'III'
        4         || 'IV'
        5         || 'V'
        6         || 'VI'
        7         || 'VII'
        8         || 'VIII'
        9         || 'IX'
        10        || 'X'
        11        || 'XI'
        12        || 'XII'
        13        || 'XIII'
        14        || 'XIV'
        15        || 'XV'
        49        || 'XLIX'
        50        || 'L'
        51        || 'LI'
        95        || 'XCV'
        99        || 'XCIX'
        100       || 'C'
        101       || 'CI'
        404       || 'CDIV'
        500       || 'D'
        1000      || 'M'
        1443      || 'MCDXLIII'
        2016      || 'MMXVI'
    }

    @Unroll
    def "JAVA Solve from #romanNumeral = #anInteger"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumerConverterImpl()

        expect:
        convertor.fromRomanNumeral(romanNumeral) == anInteger

        where:
        anInteger || romanNumeral
        1         || 'I'
        2         || 'II'
        3         || 'III'
        4         || 'IV'
        5         || 'V'
        6         || 'VI'
        7         || 'VII'
        8         || 'VIII'
        9         || 'IX'
        10        || 'X'
        11        || 'XI'
        12        || 'XII'
        13        || 'XIII'
        14        || 'XIV'
        15        || 'XV'
        49        || 'XLIX'
        50        || 'L'
        51        || 'LI'
        95        || 'XCV'
        99        || 'XCIX'
        100       || 'C'
        101       || 'CI'
        404       || 'CDIV'
        500       || 'D'
        1000      || 'M'
        1443      || 'MCDXLIII'
        2016      || 'MMXVI'

    }

}