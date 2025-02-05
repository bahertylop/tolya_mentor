package org.example.glav6.part2;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1,2,3));
        Set<Integer> set2 = new HashSet<>(List.of(0,1,2));
        System.out.println(Arrays.toString(symmetricDifference(set1, set2).toArray()));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Copy = new HashSet<>(set1);
        Set<T> set2Copy = new HashSet<>(set2);

        set1Copy.removeAll(set2);
        set2Copy.removeAll(set1);

        set1Copy.addAll(set2Copy);
        return set1Copy;
    }
}

interface A {
    public static final String str = "sldkncsdkjnc";
}