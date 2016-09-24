package com.strata;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by demian on 2016-09-22.
 */
public class RomanNumeralConverterImpl implements com.strata.RomanNumeralConverter {
    final private ArrayList<Tuple> toRomanNumeralPairs;
    final private ArrayList<Tuple> fromRomanNumeralPairs;

    public RomanNumeralConverterImpl() {
        toRomanNumeralPairs = new ArrayList<Tuple>();
        toRomanNumeralPairs.add(new Tuple("M", 1000));
        toRomanNumeralPairs.add(new Tuple("CM", 900));
        toRomanNumeralPairs.add(new Tuple("D", 500));
        toRomanNumeralPairs.add(new Tuple("CD", 400));
        toRomanNumeralPairs.add(new Tuple("C", 100));
        toRomanNumeralPairs.add(new Tuple("XC", 90));
        toRomanNumeralPairs.add(new Tuple("L", 50));
        toRomanNumeralPairs.add(new Tuple("XL", 40));
        toRomanNumeralPairs.add(new Tuple("X", 10));
        toRomanNumeralPairs.add(new Tuple("IX", 9));
        toRomanNumeralPairs.add(new Tuple("V", 5));
        toRomanNumeralPairs.add(new Tuple("IV", 4));
        toRomanNumeralPairs.add(new Tuple("I", 1));

        fromRomanNumeralPairs = new ArrayList<Tuple>();
        fromRomanNumeralPairs.add(new Tuple("CM", 900));
        fromRomanNumeralPairs.add(new Tuple("M", 1000));
        fromRomanNumeralPairs.add(new Tuple("CD", 400));
        fromRomanNumeralPairs.add(new Tuple("D", 500));
        fromRomanNumeralPairs.add(new Tuple("XC", 90));
        fromRomanNumeralPairs.add(new Tuple("C", 100));
        fromRomanNumeralPairs.add(new Tuple("XL", 40));
        fromRomanNumeralPairs.add(new Tuple("L", 50));
        fromRomanNumeralPairs.add(new Tuple("IX", 9));
        fromRomanNumeralPairs.add(new Tuple("X", 10));
        fromRomanNumeralPairs.add(new Tuple("IV", 4));
        fromRomanNumeralPairs.add(new Tuple("V", 5));
        fromRomanNumeralPairs.add(new Tuple("I", 1));
    }

    public String toRomanNumeral(int number) {
        String romanNumeral = "";
        for (Tuple entry : toRomanNumeralPairs) {
            if (number / entry.y >= 1) {
                final int howManyTimes = number / entry.y;
                number = number - (howManyTimes * entry.y);
                romanNumeral = romanNumeral + String.join("", Collections.nCopies(howManyTimes, entry.x));
            }
        }
        return romanNumeral;
    }

    public int fromRomanNumeral(final String romanNumeral) throws NumberFormatException {
        if (romanNumeral == null || romanNumeral.trim() == "") {
            throw new NumberFormatException("Cannot convert empty or null romanNumeral to int");
        }
        String tempRomanNumeral = romanNumeral;
        ArrayList<Tuple> listOfPairs = new ArrayList<>(fromRomanNumeralPairs);
        int number = 0;
        while (tempRomanNumeral.length() > 0) {
            Tuple currentTuple = listOfPairs.get(0);
            if (tempRomanNumeral.indexOf(currentTuple.x) != -1) {
                tempRomanNumeral = tempRomanNumeral.replaceFirst(currentTuple.x, "");
                number = number + currentTuple.y;
            } else {
                listOfPairs.remove(0);
                if (listOfPairs.size() == 0) {
                    throw new NumberFormatException("Cannot convert romanNumeral [" + romanNumeral + "] to int");
                }
            }
        }

        return number;
    }

    private class Tuple {
        final String x;
        final Integer y;

        Tuple(String x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
