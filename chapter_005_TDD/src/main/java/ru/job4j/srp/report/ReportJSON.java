package ru.job4j.srp.report;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.job4j.srp.Employee;
import ru.job4j.srp.storage.Store;

import java.util.function.Predicate;

public class ReportJSON extends ReportProgrammers {
    public ReportJSON(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JSONArray employeeList = new JSONArray();
        JSONObject employeeDetails;
        JSONObject employeeObject;
        for (Employee employee : store.findBy(filter)) {
            employeeDetails = new JSONObject();
            employeeDetails.put("name", employee.getName());
            employeeDetails.put("hired", employee.getHired().toString());
            employeeDetails.put("fired", employee.getFired().toString());
            employeeDetails.put("salary", String.valueOf(employee.getSalary()));
            employeeObject = new JSONObject();
            employeeObject.put("employee", employeeDetails);
            employeeList.add(employeeObject);
        }

        return employeeList.toJSONString();
    }
}
