package com.plt875.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorFor2dArrayTest {

    @Test
    void comparatorTest() {
        int[][] arr = new int[][]{
                { 3, 2 },
                { 2, 2 },
                { 2, 1 },
                { 2, 3 },
                { 5, 5 },
        };

        Comparator<int[]> first = Comparator.comparing(a -> a[0]);
        Comparator<int[]> second = Comparator.comparing(a -> a[1]);

        // Arrays.sort(arr, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(c -> c[1]));
        Arrays.sort(arr, first.thenComparing(second));
        assertEquals(arr[0][0], 2);
        assertEquals(arr[0][1], 1);

        assertEquals(arr[1][0], 2);
        assertEquals(arr[1][1], 2);

        assertEquals(arr[2][0], 2);
        assertEquals(arr[2][1], 3);

        assertEquals(arr[3][0], 3);
        assertEquals(arr[3][1], 2);

        assertEquals(arr[4][0], 5);
        assertEquals(arr[4][1], 5);
    }

    @Test
    void comparatorFor2dArrayTest() {
        int[][] arr = new int[][]{
                { 3, 2 },
                { 2, 2 },
                { 2, 1 },
                { 2, 3 },
                { 5, 5 },
        };

        ComparatorFor2dArray comparator = new ComparatorFor2dArray();
        Arrays.sort(arr, comparator);
        assertEquals(arr[0][0], 2);
        assertEquals(arr[0][1], 1);

        assertEquals(arr[1][0], 2);
        assertEquals(arr[1][1], 2);

        assertEquals(arr[2][0], 2);
        assertEquals(arr[2][1], 3);

        assertEquals(arr[3][0], 3);
        assertEquals(arr[3][1], 2);

        assertEquals(arr[4][0], 5);
        assertEquals(arr[4][1], 5);
    }
}
