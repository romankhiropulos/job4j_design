package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.storage.Store;

import java.util.function.Predicate;

public class ReportBookkeeping extends ReportEngine {
    public ReportBookkeeping(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
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
}
