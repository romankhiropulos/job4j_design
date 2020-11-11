package ru.job4j.srp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import ru.job4j.srp.report.*;
import ru.job4j.srp.storage.MemStore;

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
        Report engine = new ReportEngine(store);
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
    public void whenGenerateForProgrammersHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportHTML(store);
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
        expect.append("<p>").append(worker.getName()).append(";").append("</p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getHired()).append(";").append("</p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getFired()).append(";").append("</p>")
                .append(System.lineSeparator())
                .append("<p>").append(worker.getSalary()).append(";").append("</p>")
                .append(System.lineSeparator());
        expect.append("</body>").append(System.lineSeparator());
        expect.append("/html").append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForProgrammersJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);

        JSONArray employeeList = new JSONArray();
        JSONObject employeeObject = new JSONObject();
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("name", worker.getName());
        employeeDetails.put("hired", worker.getHired().toString());
        employeeDetails.put("fired", worker.getFired().toString());
        employeeDetails.put("salary", String.valueOf(worker.getSalary()));
        employeeObject.put("employee", employeeDetails);
        employeeList.add(employeeObject);
        assertThat(engine.generate(em -> em.getName().equals("Ivan")), is(employeeList.toString()));
    }

    @Test
    public void whenGenerateForProgrammersXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);

        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(System.lineSeparator());
        expect.append("<employee>")
                .append(System.lineSeparator())
                .append("  ").append("<name>").append(worker.getName()).append("</name>")
                .append(System.lineSeparator())
                .append("  ").append("<hired>").append(worker.getHired()).append("</hired>")
                .append(System.lineSeparator())
                .append("  ").append("<fired>").append(worker.getFired()).append("</fired>")
                .append(System.lineSeparator())
                .append("  ").append("<salary>").append(worker.getSalary()).append("</salary>")
                .append(System.lineSeparator())
                .append("</employee>");

        assertThat(engine.generate(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForBookkeeping() {
        double tax = 0.13;
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportBookkeeping(store);

        Employee expectedWorker = new Employee("Ivan", now, now, 100 * (1 - tax));
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(expectedWorker.getName()).append(";")
                .append(expectedWorker.getHired()).append(";")
                .append(expectedWorker.getFired()).append(";")
                .append(expectedWorker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName().equals("Ivan")), is(expect.toString()));
    }

    @Test
    public void whenGenerateForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 150);
        store.add(worker1);
        store.add(worker2);

        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> !em.getName().isEmpty()), is(expect.toString()));
    }
}