package com.strata;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by demian on 2016-09-22.
 */
public class RomanNumeralConverterImpl implements RomanNumeralConverter {
    final private ArrayList<Pair> toRomanNumeralPairs;
    final private ArrayList<Pair> fromRomanNumeralPairs;

    public RomanNumeralConverterImpl() {
        toRomanNumeralPairs = new ArrayList<>();
        toRomanNumeralPairs.add(new Pair("M", 1000));
        toRomanNumeralPairs.add(new Pair("CM", 900));
        toRomanNumeralPairs.add(new Pair("D", 500));
        toRomanNumeralPairs.add(new Pair("CD", 400));
        toRomanNumeralPairs.add(new Pair("C", 100));
        toRomanNumeralPairs.add(new Pair("XC", 90));
        toRomanNumeralPairs.add(new Pair("L", 50));
        toRomanNumeralPairs.add(new Pair("XL", 40));
        toRomanNumeralPairs.add(new Pair("X", 10));
        toRomanNumeralPairs.add(new Pair("IX", 9));
        toRomanNumeralPairs.add(new Pair("V", 5));
        toRomanNumeralPairs.add(new Pair("IV", 4));
        toRomanNumeralPairs.add(new Pair("I", 1));

        fromRomanNumeralPairs = new ArrayList<>();
        fromRomanNumeralPairs.add(new Pair("CM", 900));
        fromRomanNumeralPairs.add(new Pair("M", 1000));
        fromRomanNumeralPairs.add(new Pair("CD", 400));
        fromRomanNumeralPairs.add(new Pair("D", 500));
        fromRomanNumeralPairs.add(new Pair("XC", 90));
        fromRomanNumeralPairs.add(new Pair("C", 100));
        fromRomanNumeralPairs.add(new Pair("XL", 40));
        fromRomanNumeralPairs.add(new Pair("L", 50));
        fromRomanNumeralPairs.add(new Pair("IX", 9));
        fromRomanNumeralPairs.add(new Pair("X", 10));
        fromRomanNumeralPairs.add(new Pair("IV", 4));
        fromRomanNumeralPairs.add(new Pair("V", 5));
        fromRomanNumeralPairs.add(new Pair("I", 1));
    }

    public String toRomanNumeral(int number) {
        if (number <= 0) {
            throw new NumberFormatException("Cannot convert zero or negative to roman numeral");
        }
        if (number > LARGEST_NUMBER) {
            throw new NumberFormatException("Cannot convert a number larger than " + LARGEST_NUMBER);
        }
        StringBuffer romanNumeral = new StringBuffer("");
        for (Pair entry : toRomanNumeralPairs) {
            final int dividesHowManyTimes = number / entry.number;
            if (dividesHowManyTimes >= 1) {
                number = number - (dividesHowManyTimes * entry.number);
                romanNumeral = romanNumeral.append(String.join("",
                        Collections.nCopies(dividesHowManyTimes, entry.romanNumeral)));
            }
        }
        return romanNumeral.toString().toUpperCase();
    }

    public int fromRomanNumeral(final String romanNumeral) throws NumberFormatException {
        if (romanNumeral == null || romanNumeral.trim().equals("")) {
            throw new NumberFormatException("Cannot convert empty or null roman numeral");
        }
        StringBuffer tempRomanNumeral = new StringBuffer(romanNumeral.toUpperCase());
        ArrayList<Pair> listOfPairs = new ArrayList<>(fromRomanNumeralPairs);
        int number = 0;
        while (tempRomanNumeral.length() > 0) {
            final Pair currentPair = listOfPairs.get(0);
            final int findTuple = tempRomanNumeral.indexOf(currentPair.romanNumeral);
            if (findTuple != -1) {
                tempRomanNumeral = tempRomanNumeral.delete(
                        findTuple,
                        findTuple + currentPair.romanNumeral.length());
                number = number + currentPair.number;
            } else {
                listOfPairs.remove(0);
                if (listOfPairs.size() == 0) {
                    throw new NumberFormatException("Cannot convert roman numeral [" + romanNumeral + "]");
                }
            }
        }

        return number;
    }

    private class Pair {
        final String romanNumeral;
        final Integer number;

        Pair(String romanNumeral, Integer number) {
            this.romanNumeral = romanNumeral;
            this.number = number;
        }
    }
}
