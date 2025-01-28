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
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            System.out.println(Arrays.toString(stackTraceElements));
            if (stackTraceElements.length == 2) {
                return null;
            }

            StackTraceElement elemPred = stackTraceElements[2];
            return elemPred.getClassName() + "#" + elemPred.getMethodName();
        }
    }
}
