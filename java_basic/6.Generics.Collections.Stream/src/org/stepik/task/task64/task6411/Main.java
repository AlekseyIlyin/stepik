package org.stepik.task.task64.task6411;

import java.util.stream.IntStream;

/**
 Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

 Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 Первый элемент последовательности устанавливается равным этому числу.
 Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(R2n), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.
 */

public class Main {
    public static void main(String[] args) {
        IntStream intStream = pseudoRandomStream(13);
        intStream.limit(10).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }
}