import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
 Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
 minMaxConsumer.accept(min, max);
 Если стрим не содержит элементов, то вызовите
 minMaxConsumer.accept(null, null);*/
public class Main {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.iterate(5,n -> n + 1).limit(15);
        BiConsumer<Integer, Integer> biConsumerMinMax = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                integer = new Integer(0);
                integer2 = new Integer(0);
            }
        };
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);

        findMinMax(integerStream,comparator,biConsumerMinMax);
        //System.out.println(biConsumerMinMax.);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Object[] items = stream.sorted(order).toArray();

        if (items.length == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = (T) items[0];
            T max = (T) items[items.length - 1];

            minMaxConsumer.accept(min, max);
        }
    }

    //Решение преподавателя курса:
/*
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }
*/

    private static class MinMaxFinder<T> implements Consumer<T> {

        private final Comparator<? super T> order;
        T min;
        T max;

        private MinMaxFinder(Comparator<? super T> order) {
            this.order = order;
        }

        @Override
        public void accept(T t) {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(max, t) < 0) {
                max = t;
            }
        }
    }
}