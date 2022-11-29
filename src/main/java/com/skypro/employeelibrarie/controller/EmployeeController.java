package com.skypro.employeelibrarie.controller;

import com.skypro.employeelibrarie.exception.IllegalNumberException;
import com.skypro.employeelibrarie.model.Employee;

import com.skypro.employeelibrarie.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeServiсe;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeServiсe = employeeService;
    }//конструктор

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {//получить всех сотрудников из базы сотрудников с использованием метода сервиса получить
        return this.employeeServiсe.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(Employee employee) {//добавить сотрудника в базу сотрудников с использованием метода сервиса добавить
        return this.employeeServiсe.addEmployee(employee);
    }

    @GetMapping("/employees/salary/sum")//получить сумму ЗП
    public int getSalarySum() {
        return this.employeeServiсe.getSalarySum();
    }

    @GetMapping("/employees/salary/MinSalary")//получить минимальную ЗП
    public Object getMinSalary(Employee employee) {
        return this.employeeServiсe.getMinSalary();
    }

    @GetMapping("/employees/salary/MaxSalary")//получить максимальную ЗП
    public Object getMaxSalary(Employee employee) {
        return this.employeeServiсe.getMaxSalary();
    }

    @GetMapping("/employees/salary/SalaryAverage")//получить среднюю ЗП
    public Object getSalaryAverage() {
        return this.employeeServiсe.getSalaryAverage();
    }

    @GetMapping("/employees/salary/high-salary")//получить сотрудников с ЗП выше средней
    public List<Employee> getTingAllEmployeesWhoseSalaryIsHigherThanTheAverageSalary() {
        return this.employeeServiсe.getHighSalary();
    }
    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberHandler(IllegalNumberException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}