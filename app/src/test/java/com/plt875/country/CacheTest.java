package com.plt875.country;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {

    @Test
    void shouldRetrieveByCountryLanguage() {
        Map<CountryLanguage, Double> countryLanguagePercentage = new HashMap<>();
        CountryLanguage cl0 = new CountryLanguage("CHE", "German");
        countryLanguagePercentage.put(cl0, 63.59);

        CountryLanguage cl1 = new CountryLanguage("CHE", "French");
        countryLanguagePercentage.put(cl1, 19.2);

        CountryLanguage findCl0 = new CountryLanguage("CHE", "German");
        assertTrue(countryLanguagePercentage.containsKey(findCl0));
        assertTrue(findCl0.hashCode() == cl0.hashCode());
        assertTrue(findCl0.equals(cl0));
    }
}
