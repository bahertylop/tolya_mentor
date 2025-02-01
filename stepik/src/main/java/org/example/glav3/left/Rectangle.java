package org.example.glav3.left;

import org.example.glav3.error_working.MyClass;

import java.util.function.DoubleUnaryOperator;

public class Rectangle {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double netStep = Math.pow(10, -6);
        double integralSum = 0;
        for (double i = a; i < b; i += netStep) {
            integralSum += f.applyAsDouble(i) * netStep;
        }

        return integralSum;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }

}
