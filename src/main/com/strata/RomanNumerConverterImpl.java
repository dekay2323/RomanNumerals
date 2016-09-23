package com.strata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.deploy.util.StringUtils;
import groovy.lang.Tuple;

/**
 * Created by demian on 2016-09-22.
 */
public class RomanNumerConverterImpl implements com.strata.RomanNumeralConverter {
    final private LinkedHashMap<String, Integer> toRomanNumeralPairs;
    final private LinkedHashMap<String, Integer> fromRomanNumeralPairs;

    public RomanNumerConverterImpl() {
        toRomanNumeralPairs = new LinkedHashMap<String, Integer>() {
            {
                put("M", 1000);
                put("CM", 900);
                put("D", 500);
                put("CD", 400);
                put("C", 100);
                put("XC", 90);
                put("L", 50);
                put("XL", 40);
                put("X", 10);
                put("IX", 9);
                put("V", 5);
                put("IV", 4);
                put("I", 1);
            }
        };
        fromRomanNumeralPairs = new LinkedHashMap<String, Integer>() {
                {
                put("CM", 900);
                put("M", 1000);
                put("CD", 400);
                put("D", 500);
                put("XC", 90);
                put("C", 100);
                put("XL", 40);
                put("L", 50);
                put("IX", 9);
                put("X", 10);
                put("IV", 4);
                put("V", 5);
                put("I", 1);
            }
        };
    }



    public String toRomanNumeral(int number) {
        String answer = "";
        for (Map.Entry<String, Integer> entry : toRomanNumeralPairs.entrySet()) {
            if (number / entry.getValue() >= 1) {
                final int howMany = number / entry.getValue();
                number = number - (howMany * entry.getValue());
                answer = answer + String.join("", Collections.nCopies(howMany, entry.getKey()));
            }
        }
        return answer;
    }

    public class Tuple {
        public final String x;
        public final Integer y;
        public Tuple(String x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public int fromRomanNumeral(final String romanNumeral) {
        String currentRomanNumeral = romanNumeral;
        ArrayList<Tuple> listOfPairs = (ArrayList<Tuple>)fromRomanNumeralPairs.entrySet()
                .stream()
                .map(a->new Tuple(a.getKey(), a.getValue()))
                .collect(Collectors.toList());
        int answer = 0;
        while (currentRomanNumeral.length() > 0) {
            Tuple currentTuple = listOfPairs.get(0);
            if(currentRomanNumeral.indexOf(currentTuple.x) != -1) {
                currentRomanNumeral = currentRomanNumeral.replaceFirst(currentTuple.x, "");
                answer = answer + currentTuple.y;
            } else {
                listOfPairs.remove(0);
            }
        }

        return answer;
    }
}
