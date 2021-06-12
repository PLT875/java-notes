package com.plt875.country;

import lombok.EqualsAndHashCode;
import lombok.Getter;

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
}

