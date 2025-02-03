package org.example.glav5.part3;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.printf("%.6f", sumDouble(System.in));
    }

    public static double sumDouble(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);

        double sum = 0.0;
        while (sc.hasNext()) {
            try {
                sum += sc.nextDouble();
            } catch (InputMismatchException ignored) {
                sc.next();
            }
        }
        return sum;
    }
}
