package com.plt875.comparator;

import java.util.Comparator;

public class ComparatorFor2dArray implements Comparator<int[]> {
    @Override
    public int compare(int[] t0, int[] t1) {
        int result = Integer.compare(t0[0], t1[0]);
        if (result == 0) {
            return Integer.compare(t0[1], t1[1]);
        }

        return result;
    }
}
