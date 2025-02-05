package org.example.glav6.part1;

import java.util.Objects;

public class Pair<T, X> {

    private T tValue;

    private X xValue;

    public T getFirst() {
        return tValue;
    }

    public X getSecond() {
        return xValue;
    }

    private Pair(T tValue, X xValue) {
        this.tValue = tValue;
        this.xValue = xValue;
    }

    public static <T, X> Pair<T, X> of(T tValue, X xValue) {
        return new Pair<>(tValue, xValue);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) object;
        return Objects.equals(tValue, pair.tValue) && Objects.equals(xValue, pair.xValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tValue, xValue);
    }
}
