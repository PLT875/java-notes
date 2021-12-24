package com.plt875.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorFor2dArrayTest {

    @Test
    void ComparatorFor2dArrayTest() {
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
