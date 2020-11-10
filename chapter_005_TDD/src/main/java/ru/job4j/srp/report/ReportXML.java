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
        return super.generate(filter);
    }
}
