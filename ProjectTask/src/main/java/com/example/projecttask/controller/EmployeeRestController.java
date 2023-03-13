package com.example.projecttask.controller;

import com.example.projecttask.conversions.EmployeeConversion;
import com.example.projecttask.dtos.EmployeeDto;
import com.example.projecttask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeRestController {

    private final EmployeeService service;

    @Autowired
    public EmployeeRestController(final EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<EmployeeDto> findEmployee(@PathVariable("phoneNumber") String phoneNumber){
        return new ResponseEntity<>(EmployeeConversion.entityToDto(service.findById(phoneNumber)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(EmployeeConversion.entityToDto(service
                .createEmployee(EmployeeConversion.dtoToEntity(employeeDto))), HttpStatus.CREATED);
    }

    @PutMapping("/{phoneNumber}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("phoneNumber") String phoneNumber,
                                                      @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(EmployeeConversion.entityToDto(service.updateEmployee(phoneNumber,
                EmployeeConversion.dtoToEntity(employeeDto))), HttpStatus.OK);
    }

    @DeleteMapping("/{phoneNumber}")
    public void deleteEmployee(@PathVariable("phoneNumber") String phoneNumber){
        service.deleteById(phoneNumber);
    }

    @PostMapping("/login")
    public ResponseEntity<EmployeeDto> login(@RequestParam("username") String username,@RequestParam("password") String password){
        return new ResponseEntity<>(EmployeeConversion.entityToDto(service.login(username, password)), HttpStatus.OK);
    }

    @GetMapping("/topFive")
    public ResponseEntity<List<EmployeeDto>> findTopFiveEmployees(){
        return new ResponseEntity<>(service.findTopFiveEmployees().stream()
                .map(EmployeeConversion::entityToDto).toList(), HttpStatus.OK);
    }

}
