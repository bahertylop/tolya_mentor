package org.example.glav6.questions.question1;


public class Main {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            throw new RuntimeException("Основное исключение");
        } catch (Exception e) {
            System.out.println("Отловдено исключение: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Подавленное исключение: " + suppressed.getMessage());
            }
        }
    }

    static class MyResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Исключение при закрытии ресурса");
        }
    }
}

