package com.lourence.john.loginsystem.employee.service;

import com.lourence.john.loginsystem.employee.repository.Employee;
import com.lourence.john.loginsystem.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) throws Exception {
        hasName(employee.getName());
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    @Override
    public void hasName(String name) throws Exception {
        Employee employee = repository.findByName(name);
        if(employee != null) {
            throw new Exception("Employee Exist");
        }
    }

    @Override
    public Employee getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public boolean hasId(int id) throws Exception {
        if(getById(id)==null) {
            throw new Exception("Id does not Exist");
        }
        return true;
    }
}
