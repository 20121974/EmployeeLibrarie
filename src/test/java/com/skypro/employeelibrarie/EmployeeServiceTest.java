package com.skypro.employeelibrarie;

import com.skypro.employeelibrarie.exception.IllegalNumberException;
import com.skypro.employeelibrarie.record.EmployeeRequest;
import com.skypro.employeelibrarie.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();


    @ParameterizedTest
    @MethodSource("sumTest")
    public void sumTest(int salary1, int salary2, int salary3, int result) {
        Assertions.assertEquals(result, employeeService.getSalarySum());
    }

    @MethodSource("minSalary")
    public void minSalaryTest(int salary1, int salary2, int salary3, int result) {
        Assertions.assertEquals(result, employeeService.getMinSalary());
    }

    @MethodSource("maxSalary")
    public void maxSalaryTest(int salary1, int salary2, int salary3, int result) {
        Assertions.assertEquals(result, employeeService.getMinSalary());
    }

    public static List<Arguments> sumTest() {
        return List.of(
                Arguments.of(1000, 5000, 15000),
                Arguments.of(5000, 3000, 2000),
                Arguments.of(5000, 3000, 2000));
    }

    public static List<Arguments> minSalaryTest() {
        return List.of(
                Arguments.of(7000, 5000, 14000),
                Arguments.of(5000, 3000, 2000),
                Arguments.of(5000, 3000, 2000));
    }

    public static List<Arguments> maxSalaryTest() {
        return List.of(
                Arguments.of(10000, 5000, 13000),
                Arguments.of(5000, 3000, 2000),
                Arguments.of(5000, 3000, 2000));
    }

}
