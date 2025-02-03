package org.example.glav4.part1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
        anotherMethod2();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    private static void anotherMethod2() {
        anotherMethod3();
    }


    private static void anotherMethod3() {
        System.out.println(getCallerClassAndMethodName());
    }
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();

        if (stackTraceElements.length == 2) {
            return null;
        }

        StackTraceElement elemPred = stackTraceElements[2];
        return elemPred.getClassName() + "#" + elemPred.getMethodName();

    }
}
