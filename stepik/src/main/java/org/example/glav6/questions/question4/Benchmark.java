package org.example.glav6.questions.question4;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// примерно в 2 раза отстает метод с исключениями на большом количестве в 50_000_000 однобуквенных слов
// в 3+ раза с количеством однобуквенных слов около 1_000_000
public class Benchmark {

    public static void main(String[] args) {
        byte[] testBytes = getTestByteArray();
        testTimeWithException(testBytes);
        testTimeWithoutException(testBytes);
        System.out.println(testBytes.length);
    }

    public static void testTimeWithException(byte[] stream) {
        long startTime = System.currentTimeMillis();
        TaskWithException.sumDouble(new ByteArrayInputStream(stream));
        System.out.println("time spent to method with exception: " + (System.currentTimeMillis() - startTime));
    }

    public static void testTimeWithoutException(byte[] stream) {
        long startTime = System.currentTimeMillis();
        TaskNoException.sumDouble(new ByteArrayInputStream(stream));
        System.out.println("time spent to method without exception: " + (System.currentTimeMillis() - startTime));
    }

    public static byte[] getTestByteArray() {
        Random random = new Random();
        String result = IntStream.rangeClosed(0, 50_000_000)
                .mapToObj(i -> String.valueOf((char) ('a' + random.nextInt(26))))
                .collect(Collectors.joining(" "));
        return result.getBytes();
    }
}
