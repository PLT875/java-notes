package com.plt875.comparator;

import com.plt875.model.Customer;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c0, Customer c1) {
        return Integer.compare(c0.getAge(), c1.getAge());
    }
}
