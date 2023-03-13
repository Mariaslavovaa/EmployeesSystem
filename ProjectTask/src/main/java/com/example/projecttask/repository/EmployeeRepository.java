package com.example.projecttask.repository;

import com.example.projecttask.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByUsernameAndPassword(String username, String password);
}
