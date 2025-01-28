package org.example.glav3.ascii;

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

    @Override
    public String toString() {
        return new String(byteArray);
    }
}
