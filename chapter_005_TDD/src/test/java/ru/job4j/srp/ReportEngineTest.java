package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(System.lineSeparator());
        expect.append("<html>").append(System.lineSeparator());
        expect.append("<head>").append(System.lineSeparator());
        expect.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">")
                .append(System.lineSeparator());
        expect.append("<title>Report for programmers</title>").append(System.lineSeparator());
        expect.append("</head>").append(System.lineSeparator());
        expect.append("<body>").append(System.lineSeparator());
        expect.append("<h1>Report for programmers</h1>").append(System.lineSeparator());
        expect.append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator());
        expect.append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator());
        expect.append("<p>").append(worker.getName()).append(";").append("<p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getHired()).append(";").append("<p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getFired()).append(";").append("<p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getSalary()).append(";").append("<p>")
                .append(System.lineSeparator());
        expect.append("</body>").append(System.lineSeparator());
        expect.append("/html").append(System.lineSeparator());
        assertThat(engine.generateForProgrammers(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForBookkeeping() {
        double tax = 0.13;
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);

        ReportEngine engine = new ReportEngine(store);

        Employee expectedWorker = new Employee("Ivan", now, now, 100 * (1 - tax));
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(expectedWorker.getName()).append(";")
                .append(expectedWorker.getHired()).append(";")
                .append(expectedWorker.getFired()).append(";")
                .append(expectedWorker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateForBookkeeping(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 150);
        store.add(worker1);
        store.add(worker2);

        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generateForHR(em -> !em.getName().isEmpty()), is(expect.toString()));
    }
}