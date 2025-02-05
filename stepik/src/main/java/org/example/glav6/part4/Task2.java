package org.example.glav6.part4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

    public static void main(String[] args) {
        testFindMinMax();
    }

    public static void testFindMinMax() {
        List<Integer> numbers = Arrays.asList(5, 1, 9, 3, 7);

        findMinMax(
                numbers.stream(),
                Integer::compare,
                (min, max) -> System.out.println("Min: " + min + ", Max: " + max)
        );

        // Тест с пустым потоком
        findMinMax(
                Stream.<Integer>empty(),
                Integer::compare,
                (min, max) -> System.out.println("Min: " + min + ", Max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}
