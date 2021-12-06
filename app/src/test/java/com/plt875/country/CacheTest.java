package com.plt875.country;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {

    @Test
    void shouldRetrieveByCountryLanguage() {
        Map<CountryLanguage, Double> countryLanguagePercentage = new HashMap<>();
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 20);
        countryLanguagePercentage.put(cl0, 63.59);

        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 10);
        countryLanguagePercentage.put(cl1, 19.2);

        CountryLanguage findCl0 = new CountryLanguage("CHE", "German", 20);
        assertTrue(countryLanguagePercentage.containsKey(findCl0));
        assertTrue(findCl0.hashCode() == cl0.hashCode());
        assertTrue(findCl0.equals(cl0));
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
                .collect(Collectors.toList());

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
        Collections.sort(list0, new CountrySpeakersComparator());

        assertEquals(list0.get(0), cl1);
        assertEquals(list0.get(3), cl0);
    }
}
