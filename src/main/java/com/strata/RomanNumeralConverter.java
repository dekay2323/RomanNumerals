package com.strata;

/**
 * Convert to an from a roman numeral
 * Subtractive and strict
 *
 * Created by demian on 2016-09-22.
 */
public interface RomanNumeralConverter {
    final public static int LARGEST_NUMBER = 20000;
    int fromRomanNumeral(String romanNumeral) throws NumberFormatException;
    String toRomanNumeral(int number);
}
