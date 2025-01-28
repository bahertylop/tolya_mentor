package org.example.glav2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Pattern;
import static java.lang.System.*;

public class TwoFromFour {
    public static void main(String[] args) {

        System.out.println(factorial(1));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));

        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        String str = new TwoFromFour().printTextPerRole(roles, textLines);
        System.out.println(str);
        booleanExpression2(true, true, true, true);
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && !c && !d) ||
                (a && c && !b && !d) ||
                (a && d && !c && !b) ||
                (b && c && !a && !d) ||
                (b && d && !a && !c) ||
                (c && d && !a && !b);
    }

    public static boolean booleanExpression2(boolean a, boolean b, boolean c, boolean d) {
        int countTrue = 0;
        if (a) countTrue++;
        if (b) countTrue++;
        if (c) countTrue++;
        if (d) countTrue++;

        return countTrue == 2;
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(c - (a + b)) < 0.0001;
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    public static boolean isPowerOfTwo(int value) {
        int abs = Math.abs(value);
        if (abs == 0) {
            return false;
        }

        while (abs > 0) {
            if (abs % 2 != 0 && abs != 1) {
                return false;
            }
            abs /= 2;
        }
        return true;
    }

    public static boolean isPowerOfTwo2(int value) {
        int num = Math.abs(value);
        return (num & (num - 1)) == 0;
    }

    public static boolean isPalindrome(String text) {
        String pattern = "[^a-zA-Z0-9]";

        String str = text.replaceAll(pattern, "").toLowerCase();
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }

    public static BigInteger factorial(int value) {
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i <= value; i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }

        return fact;

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int newLength = a1.length + a2.length;

        int[] newArr = new int[newLength];
        int a1Ind = 0;
        int a2Ind = 0;
        for (int i = 0; i < newLength; i++) {
            int a1Elem, a2Elem;
            if (a1Ind < a1.length) {
                a1Elem = a1[a1Ind];
            } else {
                a1Elem = Integer.MAX_VALUE;
            }
            if (a2Ind < a2.length) {
                a2Elem = a2[a2Ind];
            } else {
                a2Elem = Integer.MAX_VALUE;
            }

            if (a1Elem > a2Elem) {
                newArr[i] = a2Elem;
                a2Ind++;
            } else {
                newArr[i] = a1Elem;
                a1Ind++;
            }
        }
        return newArr;
    }

    public static int[] mergeArrays2(int[] a1, int[] a2) {
        int[] newArr = new int[a1.length + a2.length];
        int a1Ind = 0;
        int a2Ind = 0;
        int newArrInd = 0;
        while (a1Ind < a1.length && a2Ind < a2.length) {
            if (a1[a1Ind] < a2[a2Ind]) {
                newArr[newArrInd++] = a1[a1Ind++];
            } else {
                newArr[newArrInd++] = a2[a2Ind++];
            }
        }

        while (a1Ind < a1.length) {
            newArr[newArrInd++] = a1[a1Ind++];
        }
        while (a2Ind < a2.length) {
            newArr[newArrInd++] = a2[a2Ind++];
        }

        return newArr;
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();

        for (String role : roles) {
            sb.append(role)
                    .append(":\n");

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(role + ":")) {
                    sb.append((j + 1))
                            .append(")")
                            .append(textLines[j].substring(role.length() + 1))
                            .append('\n');
                }
            }

            sb.append('\n');
        }

        return sb.toString();
    }
}
