import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/Employee';
import { EmployeeService } from 'src/app/services/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  viewEmployee?: Employee
  updatedEmployee?: Employee
  constructor(private readonly employeeService: EmployeeService, private route: ActivatedRoute) { 
    
    const phoneNumber = route.snapshot.paramMap.get('phoneNumber') || '';
    this.viewEmployeeProfile(phoneNumber); 
  }

  ngOnInit(): void {
  }

  viewEmployeeProfile(phoneNumber: string){
    this.employeeService.findEmployee(phoneNumber)
    .subscribe((foundEmployee) => {
      if (foundEmployee) {
        console.log(foundEmployee);
        this.viewEmployee = foundEmployee;
      }
    });
  }

  editProfile( username: string, password: string, fullName: string, phoneNumber: string, email: string) {
    this.employeeService.updateEmployee(phoneNumber, {username, password, fullName, phoneNumber, email}).subscribe(response => {
      if(response){
        alert("You have successfully update")
        this.updatedEmployee = response;
      }})
  }

  deleteProfile(phoneNumber: string){
    this.employeeService.deleteEmployee(phoneNumber)
    .subscribe(response => {
      if(response){
        alert("You have successfully delete")
      }})
  }


}
