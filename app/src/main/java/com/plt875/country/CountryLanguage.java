package com.plt875.country;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CountryLanguage {

    private String countryCode;

    private String language;

    public CountryLanguage(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }



}
