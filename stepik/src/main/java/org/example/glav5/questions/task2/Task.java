package org.example.glav5.questions.task2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println("Неправильно заданы аргументы: путь-к-файлу максимальное-потребление");
            return;
        }

        String inputFilePath = args[0];
        double maxUsingValue;
        try {
            maxUsingValue = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Неправильно указан аргумент максимальное-потребление, требуется double");
            return;
        }

        String outputFilePath = createOutputFilePath(inputFilePath);
        filterUsers(inputFilePath, outputFilePath, maxUsingValue);
    }

    private static String createOutputFilePath(String inputFilePath) {
        return Paths.get(inputFilePath).getParent().resolve("result.csv").toString();
    }

    public static void filterUsers(String inputFileUrl, String outputFileUrl, double maxUsingValue) {
        File inputFile = new File(inputFileUrl);
        try (
            Scanner sc = new Scanner(new FileInputStream(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileUrl))
        ) {
            int lineCounter = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split("\\|");

                if (lineCounter == 0) {
                    bw.write(line);
                    bw.newLine();
                }
                if (lineCounter > 0 && checkUser(splitLine, maxUsingValue)) {
                    bw.write(line);
                    bw.newLine();
                }
                lineCounter++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    private static boolean checkUser(String[] splitLine, double maxUsing) {
        int startColumn = 2;
        for (int i = startColumn; i < splitLine.length; i++) {
            try {
                if (Double.compare(Double.parseDouble(splitLine[i]), maxUsing) > 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

        }
        return true;
    }
}
