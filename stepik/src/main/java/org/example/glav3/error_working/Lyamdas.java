package org.example.glav3.error_working;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Lyamdas {

    public static void main(String[] args) {
        Function<Integer, Integer> plusTen = x -> x + 10;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);


        Lyamda lyamda = new Lyamda() {

            @Override
            public void print2(String str) {
                System.out.println("переопределен метод print2 в анонимном классе");
            }

            @Override
            public void print1(String str) {
                System.out.print(str);
            }
        };

        Lyamda lyamda1 = System.out::print;

        lyamda1.print2("qwerty");
        lyamda1.print1("qwerty");

        lyamda.print2("qwerty");
        lyamda.print1("qwerty");

        ClassForAnonymClass classForAnonymClass = new ClassForAnonymClass("QWERTY") {

            public static void method()  {
                System.out.println("static method");
            }

            @Override
            public void method2() {

            }

            @Override
            public void method3() {

            }
        };





        MyClass myClass = new MyClass("") {
            @Override
            public void method1() {
                System.out.println(nameField + " переопределено");
            }
        };

        myClass.nameField = "";


    }
}

interface Lyamda {

    void print1(String str);

    default void print2(String str) {
        System.out.println(str);
    }
}

abstract class ClassForAnonymClass {

    protected String nameField;

    public ClassForAnonymClass(String nameField) {
        this.nameField = nameField;
    }

    public void method1() {
        System.out.println("method1");
    }

    public abstract void method2();

    public abstract void method3();
}


