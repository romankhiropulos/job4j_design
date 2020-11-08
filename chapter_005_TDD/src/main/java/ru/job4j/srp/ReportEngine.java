package ru.job4j.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

//    Через месяц применения системы отчетности отдел программистов потребовал ответы в виде html.
//
//    Отдел бухгалтерии попросил изменить вид зарплаты.
//
//    Отдел HR попросил выводить сотрудников в порядке убывания зарплаты и убрать поля даты найма и увольнения.

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateForProgrammers(Predicate<Employee> filter) {
        StringBuilder htmlText = new StringBuilder();
        htmlText.append("<!DOCTYPE html>").append(System.lineSeparator());
        htmlText.append("<html>").append(System.lineSeparator());
        htmlText.append("<head>").append(System.lineSeparator());
        htmlText.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">")
                .append(System.lineSeparator());
        htmlText.append("<title>Report for programmers</title>").append(System.lineSeparator());
        htmlText.append("</head>").append(System.lineSeparator());
        htmlText.append("<body>").append(System.lineSeparator());
        htmlText.append("<h1>Report for programmers</h1>").append(System.lineSeparator());
        htmlText.append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator());
        htmlText.append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            htmlText.append("<p>").append(employee.getName()).append(";").append("<p>")
                    .append(System.lineSeparator())
                    .append("<p>").append(employee.getHired()).append(";").append("<p>")
                    .append(System.lineSeparator())
                    .append("<p>").append(employee.getFired()).append(";").append("<p>")
                    .append(System.lineSeparator())
                    .append("<p>").append(employee.getSalary()).append(";").append("<p>")
                    .append(System.lineSeparator());
        }
        htmlText.append("</body>").append(System.lineSeparator());
        htmlText.append("/html").append(System.lineSeparator());

        return htmlText.toString();
    }

    public String generateForBookkeeping(Predicate<Employee> filter) {
        double tax = 0.13;
        StringBuilder bookkeepingText = new StringBuilder();
        bookkeepingText.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            bookkeepingText.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * (1 - tax)).append(";")
                    .append(System.lineSeparator());
        }

        return bookkeepingText.toString();
    }

    public String generateForHR(Predicate<Employee> filter) {
        StringBuilder hrText = new StringBuilder();
        hrText.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        List<Employee> list = store.findBy(filter);
        list.sort(Comparator.comparingDouble(Employee::getSalary));
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            Employee employee = list.get(i);
            hrText.append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }

        return hrText.toString();
    }
}
