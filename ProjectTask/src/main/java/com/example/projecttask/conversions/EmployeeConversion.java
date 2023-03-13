package com.example.projecttask.conversions;

import com.example.projecttask.dtos.EmployeeDto;
import com.example.projecttask.model.Employee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeConversion {
    public static EmployeeDto entityToDto(Employee employee){
        return new EmployeeDto(employee.getPhoneNumber(), employee.getFullName(), employee.getUsername(),
                employee.getPassword(), employee.getEmail(), employee.getDateOfBirth(),
                employee.getMonthlySalary(), employee.getTaskList());
    }

    public static Employee dtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.getPhoneNumber(), employeeDto.getFullName(), employeeDto.getUsername(),
                employeeDto.getPassword(), employeeDto.getEmail(), employeeDto.getDateOfBirth(),
                employeeDto.getMonthlySalary(), employeeDto.getTaskList());
    }
}
