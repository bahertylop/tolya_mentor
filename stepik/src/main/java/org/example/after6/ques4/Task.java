package org.example.after6.ques4;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Task {

    public static void main(String[] args) {
        Set<Number> set1 = new HashSet<>(List.of(1, 2, 3));

        Set<Number> set2 = new HashSet<>(List.of(0, 1, 2));

        System.out.println(symmetricDifference2(set1, set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();

        set1.forEach((x) -> { if (!set2.contains(x)) { result.add(x); } });
        set2.forEach((x) -> { if (!set1.contains(x)) { result.add(x); } });
        return result;
    }

    public static <T> Set<T> symmetricDifference2(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);

        set2.stream().filter(x -> !result.add(x)).forEach(result::remove);
        return result;
    }
}
