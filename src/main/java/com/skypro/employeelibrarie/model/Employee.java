package com.skypro.employeelibrarie.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        if (firstName.isBlank() || lastName.isBlank()){
            throw new IllegalArgumentException("Имя и фамилия сотрудника должно быть установлено");
        }
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.department = department;
        this.salary = salary;

        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
