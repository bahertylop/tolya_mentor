package org.example.glav6.part4;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {

    public static void main(String[] args) {
        IntStream stream = pseudoRandomStream(13);
        stream.limit(20).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> mid(x * x));

    }

    public static int mid(int number) {
        return getDigitAt(number, 3) * 100 + getDigitAt(number, 2) * 10 + getDigitAt(number, 1);
    }

    public static int getDigitAt(int number, int k) {
        return Math.abs(number) / (int) Math.pow(10, k) % 10;
    }
}
