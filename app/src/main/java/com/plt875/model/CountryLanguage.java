package com.plt875.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class CountryLanguage implements Comparable<CountryLanguage> {

    private String countryCode;

    private String language;

    private int speakers;

    public CountryLanguage(String countryCode, String language, int speakers) {
        this.countryCode = countryCode;
        this.language = language;
        this.speakers = speakers;
    }

    @Override
    public int compareTo(CountryLanguage cl) {
        return this.getSpeakers() - cl.getSpeakers();
    }

    public static List<CountryLanguage> sortBySpeakers(List<CountryLanguage> countryLanguages) {
        return countryLanguages.stream()
                .sorted(Comparator.comparing(CountryLanguage::getSpeakers).reversed())
                .collect(Collectors.toList());
    }

    public static LinkedHashMap<CountryLanguage, Double> sortByValue(
            Map<CountryLanguage, Double> countryLanguagesPercentage
    ) {
        LinkedHashMap<CountryLanguage, Double> result = new LinkedHashMap<>();
        countryLanguagesPercentage
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(m -> result.put(m.getKey(), m.getValue()));

        return result;
    }
}

