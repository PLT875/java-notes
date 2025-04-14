package com.plt875.comparator;

import com.plt875.model.CountryLanguage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryLanguageTest {

    @Test
    void shouldRetrieveByCountryLanguage() {
        Map<CountryLanguage, Double> countryLanguagePercentage = new HashMap<>();
        CountryLanguage cl0 = new CountryLanguage("CHE", "German", 20);
        countryLanguagePercentage.put(cl0, 63.59);

        CountryLanguage cl1 = new CountryLanguage("CHE", "French", 10);
        countryLanguagePercentage.put(cl1, 19.2);

        CountryLanguage findCl0 = new CountryLanguage("CHE", "German", 20);
        assertTrue(countryLanguagePercentage.containsKey(findCl0));
        assertEquals(findCl0.hashCode(), cl0.hashCode());
        assertEquals(findCl0, cl0);
    }
}
