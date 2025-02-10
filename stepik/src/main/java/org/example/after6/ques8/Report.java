package org.example.after6.ques8;

import java.time.LocalDate;

public class Report {

    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;


    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%d\n%s", studentUserName, date.toString(), hours, title);
    }
}
