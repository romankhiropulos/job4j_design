package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.storage.Store;

import java.util.function.Predicate;

public class ReportHTML extends ReportProgrammers {
    public ReportHTML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
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
}
