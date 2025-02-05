package org.example.glav6.questions.question2;

import java.io.*;
import java.nio.charset.Charset;

public class Test {

    public static void main(String[] args) {
        // прикол как раз в том, что -1 прочтет,
        // считывает байт, преобразует его в положительный int
        // если доходит до конца потока и не может больше считывать, то возвращает -1
        byte[] byteArray = new byte[]{127,-128, -127, 0, 1, 2, 3, 4, 5, 6, 7, 8, -1, 1, 2, 3, 4, 5};
        try (
            InputStream is = new ByteArrayInputStream(byteArray);
            OutputStreamWriter osw = new OutputStreamWriter(System.out)
        ) {
            int readByte;
            while ((readByte = is.read()) != -1) {
//                osw.write(readByte);
                System.out.println(readByte);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
