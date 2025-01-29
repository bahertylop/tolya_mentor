package org.example.glav2;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {

        System.out.println(true & true);
        System.out.println(true & false);
        System.out.println(false & true);
        System.out.println(false & false);

        System.out.println(true == true);
        System.out.println(true == false);
        System.out.println(false == true);
        System.out.println(false == false);
        long l = 23453456l;
        float f = l;
        System.out.println();
        System.out.println(Charset.defaultCharset());
    }
}
