package com.skypro.employeelibrarie.service;

import com.skypro.employeelibrarie.model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private Comparator<Object> Comparators;


    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }//получить всех сотрудников

    public Employee addEmployee(Employee employee) {//добавление сотрудника
        this.employees.put(employee.getId(), employee);//положить
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public Employee getMinSalary() {
        Employee result = null;
        int minSalary = Integer.MIN_VALUE;
        for (Employee employee : getAllEmployees())
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        return null;
    }
    public Employee getMaxSalary() {
        Employee result = null;
        int maxSalary = Integer.MAX_VALUE;
        for (Employee employee : getAllEmployees())
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        return null;
    }

    public Object getSalaryAverage() {
        return employees.values().stream().mapToInt(Employee::getSalary).average();//средняя ЗП
    }

    public List<Employee> getHighSalary() {
        double average = (double) getSalaryAverage();
        return (List<Employee>) employees.values().stream().filter(e -> e.getSalary() > average);
    }

}
