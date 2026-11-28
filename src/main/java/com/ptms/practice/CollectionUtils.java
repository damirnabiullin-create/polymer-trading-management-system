package com.ptms.practice;

import java.util.*;
import java.util.function.Predicate;

public class CollectionUtils {

    public static <T> int prepareDataWithConditionNoneDuplicatesSortedByComparator(List<? extends T> source,
                                                                                   List<? super T> destination,
                                                                                   Comparator<T> comparator,
                                                                                   Predicate<T> predicate) {
        if (source == null ||
                destination == null ||
                comparator == null ||
                predicate == null) {
            throw new IllegalArgumentException("Входящий и исходящий списки а так же, условия отбора и сортировки не должны быть null");
        }

        List<? extends T> result = source.stream()
                .filter(predicate)
                .distinct()
                .sorted(comparator)
                .toList();
        destination.addAll(result);

        return result.size();
    }

    public static <T> int selectToListByCondition(List<? extends T> source,
                                                  List<? super T> destination,
                                                  Predicate<T> condition) {
        if (source == null || destination == null || condition == null) {
            throw new IllegalArgumentException("Входящий список и список назначения и условие отбора не должны быть null");
        }

        List<? extends T> result = source.stream()
                .filter(condition)
                .toList();
        destination.addAll(result);
        return result.size();
    }

    public static <T> Optional<T> findFirstByCondition(List<T> listOfT, Predicate<T> condition) {
        if (listOfT == null || condition == null) {
            throw new IllegalArgumentException("Список и условие поиска не должны быть null");
        }

        return listOfT.stream()
                .filter(condition)
                .findFirst();
    }

    public static <T> void appendAll(List<? super T> toMergeList, List<T> toAppendList) {
        if (toMergeList == null || toAppendList == null) {
            throw new IllegalArgumentException("Целевой список и список для копирования не должны быть null");
        }
        for (T value : toAppendList) {
            toMergeList.add(value);
        }
    }

    public static <T> List<T> copyList(List<T> inputList) {
        if (inputList == null) {
            throw new IllegalArgumentException("Входящий список не должен быть null");
        }
        List<T> copy = new ArrayList<>();
        for (T value : inputList) {
            copy.add(value);
        }
        return copy;
    }

    public static <T extends Comparable<T>> T biggestInCollection(Collection<T> collectionForCheck) {
        if (collectionForCheck == null) {
            throw new IllegalArgumentException("Коллекция не должна быть null");
        }
        if (collectionForCheck.isEmpty()) {
            throw new IllegalArgumentException("Коллекция не должна быть пустой");
        }

        T biggestElement = null;
        for (T currentElement : collectionForCheck) {
            if (currentElement == null) {
                continue;
            }
            if (biggestElement == null || currentElement.compareTo(biggestElement) > 0) {
                biggestElement = currentElement;
            }
        }
        if (biggestElement == null) {
            throw new IllegalArgumentException("Коллекция не содержит допустимых элементов");
        }
        return biggestElement;
    }

    public static <T> List<T> filter(Collection<T> collectionForFilter,
                                     Predicate<T> condition) {
        if (collectionForFilter == null) {
            throw new IllegalArgumentException("Коллекция не должна быть null");
        }
        if (condition == null) {
            throw new IllegalArgumentException("Условие не должно быть null");
        }

        List<T> result = new ArrayList<>();

        for (T currentElement : collectionForFilter) {
            if (condition.test(currentElement)) {
                result.add(currentElement);
            }
        }
        return result;
    }

    public static <T> T findMaxMatching(Collection<T> collection,
                                        Predicate<T> isAffordable,
                                        Comparator<T> comparator) {
        if (collection == null) {
            throw new IllegalArgumentException("Коллекция не должна быть null");
        }
        if (isAffordable == null) {
            throw new IllegalArgumentException("Условие отбора элементов не должно быть null");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Условие сравнения элементов не должно быть null");
        }
        T max = null;

        for (T element : collection) {
            if (element == null) {
                continue;
            }
            if (isAffordable.test(element) && (max == null || comparator.compare(element, max) > 0)) {
                max = element;
            }
        }
        return max;
    }

    public static <T> List<T> mergeLists(List<? extends T> fistList, List<? extends T> secondList) {
        if (fistList == null || secondList == null) {
            throw new IllegalArgumentException("Входящие списки не должны быть null");
        }

        List<T> mergedList = new ArrayList<>(fistList);
        for (T element : secondList) {
            mergedList.add(element);
        }
        return mergedList;
    }
}
