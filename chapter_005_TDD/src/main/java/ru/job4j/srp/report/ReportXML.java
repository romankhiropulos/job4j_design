package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.storage.Store;

import java.util.function.Predicate;

public class ReportXML extends ReportProgrammers {
    public ReportXML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder xmlText = new StringBuilder();
        xmlText.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            xmlText.append("<employee>")
                    .append(System.lineSeparator())
                    .append("  ").append("<name>").append(employee.getName()).append("</name>")
                    .append(System.lineSeparator())
                    .append("  ").append("<hired>").append(employee.getHired()).append("</hired>")
                    .append(System.lineSeparator())
                    .append("  ").append("<fired>").append(employee.getFired()).append("</fired>")
                    .append(System.lineSeparator())
                    .append("  ").append("<salary>").append(employee.getSalary()).append("</salary>")
                    .append(System.lineSeparator())
                    .append("</employee>");
        }

        return xmlText.toString();
    }
}
