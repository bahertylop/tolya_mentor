package org.example.after6.ques5;

import java.util.stream.IntStream;

public class Task {

    public static void main(String[] args) {
        IntStream stream = pseudoRandomStream(13);
        stream.limit(20).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> mid(x * x));

    }

    public static int mid(int number) {
        // берет второй третий и четвертый разряд числа
        return number / 10 % 1000;
    }
}
