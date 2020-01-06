package org.stepik.task.task62.task6214;

import java.util.*;

/**
 Реализуйте метод, вычисляющий симметрическую разность двух множеств.
 Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

 Пример
 Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */
public class Main {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(0);
        num2.add(1);
        num2.add(2);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        // put your solution here
        Set<T> removeSet = new HashSet<>();
        removeSet.addAll(set1);
        removeSet.addAll(set2);
        Set<T> newSet = new HashSet<>();
        newSet.addAll(removeSet);
        removeSet.retainAll(set1);
        removeSet.retainAll(set2);
        newSet.removeAll(removeSet);
        return newSet;
    }
}