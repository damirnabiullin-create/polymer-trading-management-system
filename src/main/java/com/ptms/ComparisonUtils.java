package com.ptms;

import java.util.Comparator;

public class ComparisonUtils {
    public static <T extends Comparable<T>> boolean isGreater(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static <T> boolean isLess(T a, T b, Comparator<T> comparator) {
        return comparator.compare(a, b) < 0;
    }
}
