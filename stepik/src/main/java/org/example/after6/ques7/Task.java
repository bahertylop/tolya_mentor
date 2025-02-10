package org.example.after6.ques7;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        List<T> minmax = Arrays.asList(null, null);

        stream.forEach((x) -> {
            if (minmax.get(0) == null || order.compare(minmax.get(0), x) > 0) {
                minmax.set(0, x);
            }
            if (minmax.get(1) == null || order.compare(minmax.get(1), x) < 0) {
                minmax.set(1, x);
            }
        });
        minMaxConsumer.accept(minmax.get(0), minmax.get(1));
    }
}
