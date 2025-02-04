package org.example.glav5.part3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
        String s = "Ы";
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));

        try (
            OutputStream outputStream = System.out;
            Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        ) {
            writer.write(new char[] {'Ы'});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
