package com.lourence.john.loginsystem.timelog.service;

import com.lourence.john.loginsystem.employee.repository.Employee;
import com.lourence.john.loginsystem.employee.service.EmployeeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
class TimeLogServiceImplTest {
    @Autowired
    TimeLogService timeLogService;
    @Autowired
    EmployeeService employeeService;

    @Before
    void before() {
        employeeService.deleteAll();
    }

    @Test
    void addTimeLog() throws Exception {
        Employee employee = new Employee();
        employee.setName("Rodrigo Duterte");
        employee.setAge(35);
        employee.setAddress("Manila");
        employee.setPosition("President");
        employee = employeeService.createEmployee(employee);
        timeLogService.createTimeLog(employee.getEmployeeId());
    }
}