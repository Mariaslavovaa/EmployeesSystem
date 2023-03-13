package com.example.projecttask.service;

import com.example.projecttask.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee findById(String phoneNumber);
    Employee updateEmployee(String phoneNumber, Employee employeeDto);
    void deleteById(String phoneNumber);
    List<Employee> findTopFiveEmployees();
    Employee login(String username, String password);
}
