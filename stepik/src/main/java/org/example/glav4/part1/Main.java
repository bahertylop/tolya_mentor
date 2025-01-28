package org.example.glav4.part1;

public class Main {

    public static double sqrt(double x) {
        if (x < 0.0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        
        return Math.sqrt(x);
    }

}
