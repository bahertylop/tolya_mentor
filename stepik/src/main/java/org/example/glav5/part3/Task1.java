package org.example.glav5.part3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[] {48, 49, 50, 51};

        System.out.println(readAsString(new ByteArrayInputStream(bytes), StandardCharsets.UTF_8));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (
                InputStreamReader reader = new InputStreamReader(inputStream, charset);
        ) {
            int readSymb;
            while ((readSymb = reader.read()) != -1) {
                sb.append((char) readSymb);
            }
        }

        return sb.toString();
    }

}
