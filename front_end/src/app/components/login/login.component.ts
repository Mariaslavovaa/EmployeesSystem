import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Employee } from 'src/app/model/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  found?: Employee
  //loginForm?: FormGroup;
  constructor(private readonly employeeService: EmployeeService) { }

  ngOnInit(): void {
  }

  login(username: string, password: string){
    console.log(username)
    console.log(password)
    this.employeeService.loginEmployee(username, password).subscribe(response => {
      if(response){
        alert("Welcome " + response.fullName)
        this.found = response;
      }
    })
  }

}
