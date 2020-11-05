package ru.job4j.tdd;

import java.util.*;

public class MaxMin {

    public <T extends Comparable<T>> T max(List<T> value) {
        return getResult(value, (o1, o2) -> Objects.equals(o1, o2) ? 0 : o1.compareTo(o2) < 0 ? -1 : 1);
    }

    public <T extends Comparable<T>> T min(List<T> value) {
        return getResult(value, (o1, o2) -> Objects.equals(o1, o2) ? 0 : o1.compareTo(o2) < 0 ? 1 : -1);
    }

    private <T extends Comparable<T>> T getResult(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T current : value) {
            if (comparator.compare(result, current) <= 0) {
                result = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, -2, 4, 5, 5, 0));
        System.out.println(new MaxMin().max(list));
        System.out.println(new MaxMin().min(list));
    }
}
