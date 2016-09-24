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

    @Unroll
    def "JAVA  Solve fromRomanNumeral(#romanNumeral) = #anInteger"() {
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

    @Unroll
    def "JAVA Solve toRomanNumeral(#anInteger) = #romanNumeral"() {
        setup:
        RomanNumeralConverter convertor = new RomanNumerConverterImpl()

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