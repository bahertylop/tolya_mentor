package org.example.glav5.part2;

import java.io.IOException;
import java.io.InputStream;

public class Task1 {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSum = 0;
        int rotateDistance = 1;
        int readByte;
        while ((readByte = inputStream.read()) != -1) {
            controlSum = Integer.rotateLeft(controlSum, rotateDistance) ^ readByte;
        }

        return controlSum;
    }
}
