package com.plt875.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A producer is allowed to produce something more specific, hence extends. (covariance - use more derived type)
 * Use producer for reads, won’t let you add items.
 * A consumer is allowed to accept something more general, hence super. (contravariance - use more general type)
 * User consumer for adds, can only read objects, cannot cast safely
 */
public class Pecs {

    public void consumeEx1(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(BigDecimal.TEN);
        numbers.add(2.0);
        // can only read as object
    }

    public void consumeEx2(List<Number> numbers) {
        numbers.add(1);
        numbers.add(BigDecimal.TEN);
        numbers.add(2.0);
    }

    public void produce(List<? extends Number> numbers) {
        // numbers.add(1); fails we don't know subtype
        for (Number number : numbers) {
            System.out.println("Value: " + number);
        }
    }

    public static void main(String[] args) {
        Pecs pecs = new Pecs();

        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        // pecs.consumeEx1(integerList); fails
        pecs.consumeEx1(numberList);
        pecs.consumeEx1(objectList);

        // pecs.consumeEx2(integerList); fails
        pecs.consumeEx2(numberList);
        // pecs.consumeEx2(objectList); fails

        pecs.produce(integerList);
        pecs.produce(numberList);
        // pecs.produce(objectList); fails
    }
}
