import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from '../model/Employee';
import { Task } from '../model/Task';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private readonly http: HttpClient) { }

  public findEmployee(phoneNumber : string) : Observable<Employee>{
    return this.http.get<Employee>(`${environment.restApi}/employees/${phoneNumber}`);
  }

  public findEmployeeTasks(phoneNumber : string) : Observable<Task[]>{
    return this.http.get<Task[]>(`${environment.restApi}/employees/${phoneNumber}/self-tasks`);
  }

  public createEmployee(employee : Employee) : Observable<Employee>{
    return this.http.post<Employee>(`${environment.restApi}/employees`, employee);
  }

  public updateEmployee(phoneNumber : string, employee : Employee) : Observable<Employee>{
    return this.http.put<Employee>(`${environment.restApi}/employees/${phoneNumber}`, employee);
  } 

  public deleteEmployee(phoneNumber : string) : Observable<Employee>{
    return this.http.delete<Employee>(`${environment.restApi}/employees/${phoneNumber}`);
  }

  public loginEmployee(username : string, password : string) : Observable<Employee>{
    const myheader = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    let body = new HttpParams();
    body = body.set('username', username);
    body = body.set('password', password);
    return this.http.post<Employee>(`${environment.restApi}/employees/login` ,body, {headers: myheader});
  }
  
}
