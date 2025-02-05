package org.example.glav6.part4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
                Stream<String> stream = br.lines();
        ) {
            Map<String, Integer> wordsMap = stream
                    .map(String::toLowerCase)
                    .flatMap((x) ->
                            Arrays.stream(
                                    x.replaceAll("[^\\p{L}\\p{N}]+", " ").split(" ")
                            )
                    )
                    .filter(s -> !s.isEmpty())
                    .collect(makeCollector());

            wordsMap.entrySet().stream()
                    .sorted(makeComparator())
                    .limit(10)
                    .forEach(x -> {
                        System.out.println(x.getKey());
                    }
                );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Comparator<Map.Entry<String, Integer>> makeComparator() {
        return Comparator
                .comparing(Map.Entry<String, Integer>::getValue).reversed()
                .thenComparing(Map.Entry::getKey);
    }

    public static Collector<String, ?, Map<String, Integer>> makeCollector() {
        return Collectors.toMap(
                Function.identity(),
                x -> 1,
                Integer::sum
        );
    }
}
