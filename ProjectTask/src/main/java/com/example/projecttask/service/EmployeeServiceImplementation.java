package com.example.projecttask.service;

import com.example.projecttask.model.Employee;
import com.example.projecttask.model.Task;
import com.example.projecttask.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImplementation(final EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee == null){
            throw new IllegalArgumentException("Employee cannot be null!");
        }
        return repository.save(employee);
    }

    @Override
    public Employee findById(String phoneNumber) {
        return repository.findById(phoneNumber).orElseThrow(() ->
                new EntityNotFoundException("Could not find this employee"));
    }

    @Override
    public Employee updateEmployee(String phoneNumber, Employee employee) {
        Employee employeeFound = repository.findById(employee.getPhoneNumber()).orElseThrow(EntityNotFoundException::new);
        return repository.save(employee);
    }

    @Override
    public void deleteById(String phoneNumber) {
        repository.deleteById(phoneNumber);
    }

    @Override
    public List<Employee> findTopFiveEmployees(){

        List<Employee> result = new ArrayList<>();

        repository.findAll().forEach(result::add);
        Map<Employee, Integer> employeeNumberTasksForLastMonth = new HashMap<>();
        result.forEach(employee -> {
            List<Task> temp = employee.getTaskList();
            int counter = 0;
            for (Task t:
                 temp) {
                if (t.getDueDate().isBefore(LocalDate.now()) &&
                    t.getDueDate().isAfter(LocalDate.now().minusMonths(1))){
                    counter++;
                }
            }
            employeeNumberTasksForLastMonth.put(employee, counter);
        });
        //sort hashmap //sublist
        TreeMap<Employee, Integer> sortedMap = new TreeMap<>(employeeNumberTasksForLastMonth);
        for (Map.Entry<Employee, Integer> entry : sortedMap.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());


//        sortedMap.subMap()
//        TreeMap<Employee, Integer> myNewMap = sortedMap.entrySet().stream()
//                .limit(5).collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
//        result = sortedMap.entrySet().stream().limit(5).map(Employee::).collect(Collectors.toList());

        return result;
    }

    @Override
    public Employee login(String username, String password) {
       return this.repository.findByUsernameAndPassword(username.trim(), password.trim())
               .orElseThrow(EntityNotFoundException::new);
    }
}
