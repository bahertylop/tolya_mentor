package org.example.after6.ques6;

import javax.print.attribute.IntegerSyntax;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task {

    public static void main(String[] args) {
        System.out.println("Работа с коллекцией:");
        List<Integer> numbers = List.of(1,2,3,4,5);
        numbers.forEach(System.out::println);
        numbers.forEach(System.out::println);

        System.out.println("Работа со стримом:");
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(System.out::println);
        // вызовет исключение IllegalStateException: stream has already been operated upon or closed
        intStream.forEach(System.out::println);
    }
}
