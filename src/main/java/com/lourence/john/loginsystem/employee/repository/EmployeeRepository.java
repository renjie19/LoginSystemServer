package com.lourence.john.loginsystem.employee.repository;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Employee findByName(String name);
}
