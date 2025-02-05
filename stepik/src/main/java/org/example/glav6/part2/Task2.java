package org.example.glav6.part2;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Deque<Integer> numbers = readNumbers();
        printNumbers(numbers);
    }

    public static Deque<Integer> readNumbers() {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> numbers = new LinkedList<>();

        int ind = 0;
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (ind++ % 2 != 0) {
                numbers.add(number);
            }
        }

        scanner.close();
        return numbers;
    }

    public static void printNumbers(Deque<Integer> numbers) {
        while (!numbers.isEmpty()) {
            System.out.print(numbers.removeLast() + " ");
        }
    }
}
