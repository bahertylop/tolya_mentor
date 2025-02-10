package org.example.after6.ques8;

import org.example.glav6.part1.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Task {

    public static void main(String[] args) {

        List<Report> reports = new ArrayList<>(Arrays.asList(
                new Report(
                        1L,
                        "no_punkz",
                        1,
                        LocalDate.parse("2021-09-25", DateTimeFormatter.ISO_LOCAL_DATE),
                        "Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени"
                ),
                new Report(
                        2L,
                        "no_punkz",
                        2,
                        LocalDate.parse("2021-09-26", DateTimeFormatter.ISO_LOCAL_DATE),
                        "Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата"
                ),
                new Report(
                        3L,
                        "no_punkz",
                        5,
                        LocalDate.parse("2021-09-27", DateTimeFormatter.ISO_LOCAL_DATE),
                        "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"
                ),
                new Report(
                        5L,
                        "punkz",
                        15,
                        LocalDate.parse("2021-09-28", DateTimeFormatter.ISO_LOCAL_DATE),
                        "собес на котором узнал много нового"
                ),
                new Report(
                        6L,
                        "no_punkz",
                        5,
                        LocalDate.parse("2021-08-27", DateTimeFormatter.ISO_LOCAL_DATE),
                        "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"
                ),
                new Report(
                        4L,
                        "no_punkz",
                        5,
                        LocalDate.parse("2021-10-27", DateTimeFormatter.ISO_LOCAL_DATE),
                        "Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового"
                )
        ));
        System.out.println(reportHistory2(reports, "no_punkz", 2));
    }

    public static String reportHistory(List<Report> reports, String studentUserName, int count) {
        List<Report> resultReports = reports.stream()
                .filter(report -> studentUserName.equals(report.getStudentUserName()))
                .sorted(Comparator.comparing(Report::getDate).reversed())
                .limit(count)
                .toList();


        StringBuilder sb = new StringBuilder();
        for (int i = resultReports.size() - 1; i >= 0; i--) {
            sb.append(resultReports.get(i));
            if (i != 0) {
                sb.append("\n-----------------\n");
            }
        }
        return sb.toString();
    }

    public static String reportHistory2(List<Report> reports, String studentUserName, int count) {
        return reports.stream()
                .filter(report -> studentUserName.equals(report.getStudentUserName()))
                .sorted(Comparator.comparing(Report::getDate).reversed())
                .limit(count)
                .sorted(Comparator.comparing(Report::getDate))
                .map(Report::toString)
                .collect(Collectors.joining("\n-----------------\n"));
    }
}
