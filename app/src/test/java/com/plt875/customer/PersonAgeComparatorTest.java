package com.plt875.customer;

import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonAgeComparatorTest {

    @Test
    void testPersonAgeComparator() {
        Customer c0 = new Customer("mark", 88);
        Customer c1 = new Customer("luke", 55);
        Customer c2 = new Customer("peter", 99);

        SortedSet<Customer> customers = new TreeSet<>(new PersonAgeComparator().reversed());
        customers.add(c0);
        customers.add(c1);
        customers.add(c2);

        assertEquals(99, customers.first().getAge());
        assertEquals("peter", customers.first().getName());
    }
}
