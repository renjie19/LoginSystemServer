package com.lourence.john.loginsystem.employee.resource;

import com.lourence.john.loginsystem.employee.repository.Employee;
import com.lourence.john.loginsystem.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {
    @Autowired
    private EmployeeService service;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee)throws Exception {
        return service.createEmployee(employee);
    }

    @GetMapping("/findById")
    public Employee findById(@RequestParam int id) {
        return service.getById(id);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(@RequestParam int id) {
        service.deleteEmployee(id);
    }

    @GetMapping("/getByName")
    public Employee getEmployee(@RequestParam String name) {
        return service.getByName(name);
    }
}
