package com.strata

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Test RomanNumeralConverter
 *
 * https://en.wikipedia.org/wiki/Roman_numerals
 *
 * Created by demian on 2016-09-21.
 */
class RomanNumeralConverterSpec extends Specification {

    def "fromRomanNumeral can handle odd roman numerals, backwards and too many"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()

        expect:
        convertor.fromRomanNumeral(romanNumeral) == anInteger

        where:
        anInteger || romanNumeral
        17        || 'IIIIVX'
        18        || 'IVIVX'
        40        || 'XXXX'
    }

    def "fromRomanNumeral throws exceptions for invalid roman numeral values"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()

        when: "invalid value"
        convertor.fromRomanNumeral('*')
        then:
        thrown NumberFormatException

        when: "empty string value"
        convertor.fromRomanNumeral('')
        then:
        thrown NumberFormatException

        when: "spaces for value"
        convertor.fromRomanNumeral('  ')
        then:
        thrown NumberFormatException

        when: "null value"
        convertor.fromRomanNumeral(null)
        then:
        thrown NumberFormatException

        when: "some valid some invalid values"
        convertor.fromRomanNumeral('V*I*')
        then:
        thrown NumberFormatException
    }

    def "fromRomanNumeral should handle leading and trailing spaces"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()
        when:
        convertor.fromRomanNumeral('  V  ')
        then:
        thrown NumberFormatException
    }

    @Unroll
    def "Solve fromRomanNumeral(#romanNumeral) = #anInteger"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()

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

    def "toRomanNumeral throws exceptions for invalid numbers"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()

        when: "value of 0"
        convertor.toRomanNumeral(0)
        then:
        thrown NumberFormatException
        when: "negative number"
        convertor.toRomanNumeral(-1)
        then:
        thrown NumberFormatException
        when: "very large number"
        convertor.toRomanNumeral(RomanNumeralConverter.LARGEST_NUMBER+1)
        then:
        thrown NumberFormatException
    }

    @Unroll
    def "Solve toRomanNumeral(#anInteger) = #romanNumeral"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumeralConverterImpl()

        expect:
        convertor.toRomanNumeral(anInteger) == romanNumeral

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