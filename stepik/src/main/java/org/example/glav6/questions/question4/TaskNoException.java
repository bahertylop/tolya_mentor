package org.example.glav6.questions.question4;

import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

public class TaskNoException {

    public static void main(String[] args) {
        System.out.printf("%.6f", sumDouble(System.in));
    }

    public static double sumDouble(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);
        sc.useLocale(Locale.US);

        double sum = 0.0;
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                sum += sc.nextDouble();
            } else {
                sc.next();
            }

        }

        sc.close();
        return sum;
    }
}
