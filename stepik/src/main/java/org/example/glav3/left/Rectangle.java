package org.example.glav3.left;

import java.util.function.DoubleUnaryOperator;

public class Rectangle {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;
        for (double i = a; i < b; i += Math.pow(10, -6)) {
            result += f.applyAsDouble(i) * (Math.pow(10, -6));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }

}
