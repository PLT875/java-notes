package com.plt875.country;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryLanguageTest {

    @Test
    void testSortBySpeakers() {
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 5);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 15);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 10);
        CountryLanguage cl3 = new CountryLanguage("CHE", "Italian", 60);

        List<CountryLanguage> countryLanguages = Arrays.asList(cl0, cl1, cl2, cl3);
        List<CountryLanguage> result = CountryLanguage.sortBySpeakers(countryLanguages);

        assertEquals(result.get(0).getSpeakers(), 60);
        assertEquals(result.get(1).getSpeakers(), 15);
        assertEquals(result.get(2).getSpeakers(), 10);
        assertEquals(result.get(3).getSpeakers(), 5);
    }

    @Test
    void testSortByValue() {
        Map<CountryLanguage, Double> countryLanguagePercentage = new HashMap<>();
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 5);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 15);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 10);
        CountryLanguage cl3 = new CountryLanguage("CHE", "Italian", 60);

        countryLanguagePercentage.put(cl0, 5.0);
        countryLanguagePercentage.put(cl1, 15.0);
        countryLanguagePercentage.put(cl2, 10.0);
        countryLanguagePercentage.put(cl3, 60.0);

        Map<Integer, Double> expectedResult = new HashMap<>();
        expectedResult.put(0, 60.0);
        expectedResult.put(1, 15.0);
        expectedResult.put(2, 10.0);
        expectedResult.put(3, 5.0);

        LinkedHashMap<CountryLanguage, Double> result = CountryLanguage.sortByValue(countryLanguagePercentage);
        int counter = 0;
        for (Map.Entry e : result.entrySet()) {
            assertEquals(e.getValue(), expectedResult.get(counter));
            counter++;
        }
    }

    @Test
    void testSortedSet() {
        SortedSet<CountryLanguage> countryLanguages = new TreeSet<>(new CountrySpeakersComparator());
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 15);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 5);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 20);
        CountryLanguage cl3 = new CountryLanguage("CHE", "Italian", 50);

        countryLanguages.add(cl0);
        countryLanguages.add(cl1);
        countryLanguages.add(cl2);
        countryLanguages.add(cl3);

        assertEquals(5, countryLanguages.first().getSpeakers());
        assertEquals(50, countryLanguages.last().getSpeakers());
    }

    @Test
    void random() {
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple");
        LinkedHashMap<Character, String> m = s.collect(
                Collectors.toMap(
                        s1 -> s1.charAt(0),
                        s1 -> s1,
                        (s1, s2) -> s1 + "|" + s2,
                        LinkedHashMap::new)
        );
        
    }

}
