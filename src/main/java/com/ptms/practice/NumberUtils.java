package com.ptms.practice;

import java.util.List;

public class NumberUtils {
    public static <T extends Number> double half(T number) {
        return number.doubleValue() / 2;
    }

    public static double findMax(List<? extends Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }
        double maxValue = numbers.getFirst().doubleValue();
        for (Number number : numbers) {
            if (number.doubleValue() > maxValue) {
                maxValue = number.doubleValue();
            }
        }
        return maxValue;
    }

    public static double sumNumbers(List<? extends Number> listOfNumbers) {
        if (listOfNumbers == null) {
            throw new IllegalArgumentException("Список чисел не должен быть null");
        }

        double sum = 0.0;
        for (Number number : listOfNumbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}
