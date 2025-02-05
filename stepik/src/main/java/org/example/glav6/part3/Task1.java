package org.example.glav6.part3;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Task1 {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse
    ) {
        return (T t) -> (condition.test(t)) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
