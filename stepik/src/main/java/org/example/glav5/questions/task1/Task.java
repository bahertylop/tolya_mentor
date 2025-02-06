package org.example.glav5.questions.task1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
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

        try {
            Files.walkFileTree(path, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                    new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                                throws IOException {
                            Path newFilePath = dir.resolve(TASK_FILE_NAME);
                            try (FileWriter fw = new FileWriter(newFilePath.toFile(), false)) {
                                fw.write(TASK_TEXT);
                            }

                            return FileVisitResult.CONTINUE;
                        }
                    }
            );
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
