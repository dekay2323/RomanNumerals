package com.strata;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by demian on 2016-09-22.
 */
public class RomanNumerConverterImpl implements com.strata.RomanNumeralConverter {
    final private LinkedHashMap<String, Integer> toRomanNumeralPairs;
    final private LinkedHashMap<String, Integer> fromRomanNumeralPairs;

    public RomanNumerConverterImpl() {
        toRomanNumeralPairs = (LinkedHashMap)Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
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
        });
        fromRomanNumeralPairs = (LinkedHashMap)Collections.unmodifiableMap(new LinkedHashMap<String, Integer>() {
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
        });
    }



    public String toRomanNumeral(int number) {
        return null;
    }

    public int fromRomanNumeral(String romanNumeral) {
/*        def fromRomanNumeral = { anRomanNumeral ->
                println "original ${anRomanNumeral}"
                fromRomanNumeralPairs.inject(0) { curAnswer, pair ->
        while (anRomanNumeral.find(pair.key)) {
            anRomanNumeral = anRomanNumeral.substring(pair.key.size())
            println "changing ${anRomanNumeral}"
            curAnswer = curAnswer + pair.value
            anRomanNumeral.find(pair.key)
        }
        curAnswer
        }*/

        Set<String> set = fromRomanNumeralPairs.keySet();
        Stream<String> stream = set.stream();


        int answer = stream.reduce(0, (int curAnswer, String key) -> {
            String tempRomanNumeral = romanNumeral;
            while(tempRomanNumeral.indexOf(key) != -1)  {
                tempRomanNumeral = tempRomanNumeral.substring(0, key.length());
                curAnswer = curAnswer + fromRomanNumeralPairs.get(key).intValue();

            }
            return curAnswer;
        });

        return answer;
    }
}
