package org.example.glav3.error_working;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        final int[] mas = {0, 0, 0};
//        method(mas);
//        anotherMethod(mas);
//        mas = new int[] {1, 2, 3};
//        mas[0] = 1;
        System.out.println(Arrays.toString(mas));
    }
    public static void method(int[] arr) {
        arr[0] = 999;
    }
    public static void anotherMethod(int[] arr) {
        int[] mas = {1,1,1};
        arr = mas;

    }
}
