package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private Map<String, Employee> EMPLOYEES = new HashMap<String, Employee>() {{
        put("1", new Employee("1", "小明", 20, "男"));
        put("2", new Employee("2", "小红", 19, "女"));
        put("3", new Employee("3", "小智", 15, "男"));
        put("4", new Employee("4", "小刚", 16, "男"));
        put("5", new Employee("5", "小霞", 15, "女"));
    }};

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(EMPLOYEES.values());
    }

    public void addEmployee(Employee employee) {
        if (EMPLOYEES.containsKey(employee.getId())) {
            throw new RuntimeException("Duplicated Employee");
        }

        EMPLOYEES.put(employee.getId(), employee);
    }

    public void deleteEmployee(String id) {
        if (!EMPLOYEES.containsKey(id)) {
            throw new RuntimeException("Not Found Employee");
        }

        EMPLOYEES.remove(id);
    }

    public void updateEmployee(Employee employee) {
        if (!EMPLOYEES.containsKey(employee.getId())) {
            throw new RuntimeException("Not Found Employee");
        }

        EMPLOYEES.put(employee.getId(), employee);
    }

    public Employee getById(String id) {
        if (!EMPLOYEES.containsKey(id)) {
            throw new RuntimeException("Not Found Employee");
        }

        return EMPLOYEES.get(id);
    }
}
