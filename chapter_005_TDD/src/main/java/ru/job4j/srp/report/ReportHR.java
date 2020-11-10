package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.storage.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR extends ReportEngine {
    public ReportHR(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
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
