import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent {
  viewEmployee: Employee | undefined;

  constructor(private readonly employeeService: EmployeeService,
    private route: ActivatedRoute) {
    const phoneNumber = route.snapshot.paramMap.get('phoneNumber') || '';
    this.viewEmployeeProfile(phoneNumber); 
    
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

  deleteProfile(phoneNumber: string | undefined){
    if(phoneNumber){
      this.employeeService.deleteEmployee(phoneNumber)
      .subscribe(response => {
        if(response){
          
        }})
        
        alert("You have successfully delete")
    }
  }
}
