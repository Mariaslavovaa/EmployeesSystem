import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/model/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerEmployee?: Employee
  constructor(private readonly employeeService: EmployeeService,private router: Router) { }

  ngOnInit(): void {
  }

  register( username: string, password: string, fullName: string, phoneNumber: string, email: string) {
    console.log(username)
    console.log(password)
    console.log(fullName)
    console.log(phoneNumber)
    console.log(email)
    this.employeeService.createEmployee({username, password, fullName, phoneNumber, email}).subscribe(response => {
      if(response){
        alert("You have successfully registered")
        this.registerEmployee = response;
        this.router.navigateByUrl("view-profile/" + phoneNumber)
      }
    });

  }

}
