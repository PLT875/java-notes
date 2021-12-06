package com.plt875.country;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
