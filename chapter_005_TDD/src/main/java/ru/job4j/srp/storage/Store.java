package ru.job4j.srp.storage;

import ru.job4j.srp.Employee;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}