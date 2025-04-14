package com.plt875.comparator;

import com.plt875.model.CountryLanguage;

import java.util.Comparator;

public class CountrySpeakersComparator implements Comparator<CountryLanguage> {

    @Override
    public int compare(CountryLanguage cl0, CountryLanguage cl1) {
        return cl0.getSpeakers() - cl1.getSpeakers();
    }

}
