package com.lourence.john.loginsystem.employee.service;

import com.lourence.john.loginsystem.employee.repository.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee) throws Exception;
    List<Employee> getAll();
    Employee updateEmployee(Employee employee);
    void deleteAll();
    Employee getById(int id);
    void deleteEmployee(int id);
    void hasName(String name) throws Exception;
    Employee getByName(String name);
    boolean hasId(int id) throws Exception;
}
