package com.plt875.comparator;

import com.plt875.model.CountryLanguage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryLanguageComparatorTest {

    @Test
    void testSortBySpeakers() {
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 5);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 15);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 10);
        CountryLanguage cl3 = new CountryLanguage("CHE", "Italian", 60);

        List<CountryLanguage> countryLanguages = Arrays.asList(cl0, cl1, cl2, cl3);
        List<CountryLanguage> result = CountryLanguage.sortBySpeakers(countryLanguages);

        assertEquals(60, result.get(0).getSpeakers());
        assertEquals(15, result.get(1).getSpeakers());
        assertEquals(10, result.get(2).getSpeakers());
        assertEquals(5, result.get(3).getSpeakers());
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
        for (Map.Entry<CountryLanguage, Double> e : result.entrySet()) {
            assertEquals(e.getValue(), expectedResult.get(counter));
            counter++;
        }
    }

    @Test
    void shouldSortByComparatorComparingSpeakers() {
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 20);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 10);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 10);
        CountryLanguage cl3 = new CountryLanguage("CHE", "German", 15);
        List<CountryLanguage> list0 = Arrays.asList(cl0, cl1, cl2, cl3);

        var sortedList = list0.stream()
                .sorted(Comparator.comparing(CountryLanguage::getSpeakers))
                .toList();

        assertEquals(sortedList.get(0), cl1);
        assertEquals(sortedList.get(3), cl0);
    }

    @Test
    void shouldSortByCountrySpeakersComparator() {
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 20);
        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 10);
        CountryLanguage cl2 = new CountryLanguage("CHE", "English", 10);
        CountryLanguage cl3 = new CountryLanguage("CHE", "German", 15);
        List<CountryLanguage> list0 = Arrays.asList(cl0, cl1, cl2, cl3);
        list0.sort(new CountrySpeakersComparator());

        assertEquals(list0.get(0), cl1);
        assertEquals(list0.get(3), cl0);
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

        /// same but without comparator class
        SortedSet<CountryLanguage> countryLanguages2 = new TreeSet<>(new Comparator<CountryLanguage>() {
            @Override
            public int compare(CountryLanguage o1, CountryLanguage o2) {
                return Integer.compare(o1.getSpeakers(), o2.getSpeakers());
            }
        });

        countryLanguages2.add(cl0);
        countryLanguages2.add(cl1);
        countryLanguages2.add(cl2);
        countryLanguages2.add(cl3);

        assertEquals(5, countryLanguages2.first().getSpeakers());
        assertEquals(50, countryLanguages2.last().getSpeakers());
    }
}
