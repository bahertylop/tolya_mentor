package org.example.glav5.part2;

import java.io.*;

public class Task2 {

    private static final int CARRIAGE_RETURN = '\r'; // 13
    private static final int LINE_FEED = '\n'; // 10

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        int lastByte = -1;
        int currentByte;

        while ((currentByte = inputStream.read()) != -1) {
            if (!(lastByte == CARRIAGE_RETURN && currentByte == LINE_FEED) && lastByte != -1) {
                outputStream.write(lastByte);
            }
            lastByte = currentByte;
        }

        if (lastByte != -1) {
            outputStream.write(lastByte);
        }

        inputStream.close();
        outputStream.close();
    }
}

