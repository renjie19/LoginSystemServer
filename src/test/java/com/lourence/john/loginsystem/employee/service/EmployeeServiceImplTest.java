package com.lourence.john.loginsystem.employee.service;

import com.lourence.john.loginsystem.employee.repository.Employee;
import com.lourence.john.loginsystem.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
class EmployeeServiceImplTest {
    @Autowired
    EmployeeService service;
    @Autowired
    EmployeeRepository repository;
    @Test
    void getByName() throws Exception {
        Employee employee = new Employee();
        employee.setName("Rodrigo Duterte");
        employee.setAge(35);
        employee.setAddress("Manila");
        employee.setPosition("president");
        service.createEmployee(employee);
        service.hasName("Rodrigo Duterte");
    }
            }