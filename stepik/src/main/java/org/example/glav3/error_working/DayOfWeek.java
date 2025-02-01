package org.example.glav3.error_working;

public enum DayOfWeek {

    SUNDAY ("Воскресенье"),
    MONDAY ("Понедельник"),
    TUESDAY ("Вторник"),
    WEDNESDAY ("Среда"),
    THURSDAY ("Четверг"),
    FRIDAY ("Пятница"),
    SATURDAY ("Суббота");

    private String title;

    DayOfWeek(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        dayOfWeek.getTitle();
        dayOfWeek.title = "dscs";
        System.out.println(dayOfWeek);
        System.out.println(DayOfWeek.valueOf("MONDAY"));
        System.out.println(DayOfWeek.SUNDAY.ordinal());
    }
}