package org.example.glav5.questions.task1;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task {

    public static final String TASK_TEXT = "public class Joke {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello world!!!\");\n" +
            "    }\n" +
            "}";
    public static final String TASK_FILE_NAME = "Joke.java";

    public static void main(String[] args) {
        System.out.println("Введите абсолютный путь до директории:");

        Scanner sc = new Scanner(System.in);
        String startDirectory = sc.nextLine();
        sc.close();
        bypassDirectory(startDirectory);
    }

    public static void bypassDirectory(String directoryName) {
        Path path = Paths.get(directoryName);
        String newFileName = path + File.separator + TASK_FILE_NAME;
        try (
            DirectoryStream<Path> pathStream = Files.newDirectoryStream(path);
            FileWriter fw = new FileWriter(newFileName, false);
        ) {
            pathStream.forEach(folderOrFile -> {
                if (Files.isDirectory(folderOrFile)) {
                    bypassDirectory(folderOrFile.toString());
                }
            });
            fw.write(TASK_TEXT);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
