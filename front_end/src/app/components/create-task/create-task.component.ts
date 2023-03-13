import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/model/Task';
import { TaskService } from 'src/app/services/task.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/Employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css']
})
export class CreateTaskComponent implements OnInit {

  viewEmployee?: Employee
  createdTask?: Task
  constructor(private readonly taskService: TaskService, private readonly employeeService: EmployeeService, 
              private route: ActivatedRoute) { 
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

  createTask(title: string, description: string, assignee: string){
    this.taskService.createTask({title, description, assignee}).subscribe(response => {
      if(response){
        alert("You have successfully create task")
        this.createdTask = response;
      }
    });
  }

}
