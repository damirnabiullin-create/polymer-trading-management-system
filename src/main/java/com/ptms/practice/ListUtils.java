package com.ptms.practice;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T extends List<T>> List<T> mergeLists(List<T> firstList, List<T> secondList) {
        if (firstList == null || secondList == null) {
            throw new IllegalArgumentException("Входящие списки не должны быть null");
        }
        List<T> mergedList = new ArrayList<>(firstList);
        for (T value : secondList) {
            mergedList.add(value);
        }
        return mergedList;
    }
}
