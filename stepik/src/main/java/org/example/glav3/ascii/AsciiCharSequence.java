package org.example.glav3.ascii;

import com.sun.jdi.CharType;

import java.awt.*;
import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private final byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
        return (char) byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if ( start > length() || start > end || start < 0 || end < 0) {
            throw new IndexOutOfBoundsException();
        }

        byte[] newByteArray = new byte[end - start];
        for (int i = 0; i < end - start; i++) {
            newByteArray[i] = byteArray[i + start];
        }
        return new AsciiCharSequence(newByteArray);
    }

    public AsciiCharSequence subSequence(int start) {
        return (AsciiCharSequence) subSequence(start, length());
    }

    public CharSequence delete(int from, int to) {
        if (to < from || to < 0 || from < 0 || from > length() || to > length()) {
            throw new IndexOutOfBoundsException();
        }
        byte[] newByteArray = new byte[length() - (to - from)];
//        System.arraycopy(byteArray, 0, newByteArray, 0, from);
//        System.arraycopy(byteArray, to, newByteArray, from, length() - to);


        for (int i = 0; i < from; i++) {
            newByteArray[i] = byteArray[i];
        }
        for (int i = from; i < newByteArray.length; i++) {
            newByteArray[i] = byteArray[to + (i - from)];
        }
        return new AsciiCharSequence(newByteArray);
    }

    @Override
    public String toString() {
        return new String(byteArray);
    }

    public static void main(String[] args) {
        byte[] byteArray = "Hello I`m Lev and today we will study C++".getBytes();

        AsciiCharSequence sequence = new AsciiCharSequence(byteArray);

        for (int i = byteArray.length; i >= 0; i--) {
            CharSequence sub = sequence.subSequence(i);
            System.out.println(sub);
        }

        // тест delete(int from, int to)
        byte[] bytes = "ILoveDogs".getBytes();
        sequence = new AsciiCharSequence(bytes);
        System.out.println(sequence.delete(1, 5));
//        System.out.println(sequence.subSequence(1, 4));
    }
}
