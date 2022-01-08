package com.plt875.customer;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c0, Customer c1) {
        int ageCompare = Integer.compare(c0.getAge(), c1.getAge());
        return ageCompare;
    }
}
