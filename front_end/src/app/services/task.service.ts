import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { Task } from '../model/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private readonly http: HttpClient) { }

  public createTask(task : Task) : Observable<Task>{
    return this.http.post<Task>(`${environment.restApi}/tasks`, task);
  }

  public findTask(id : number) : Observable<Task>{
    return this.http.get<Task>(`${environment.restApi}/tasks/${id}`);
  }

  public updateTask(id : number, task : Task) : Observable<Task>{
    return this.http.put<Task>(`${environment.restApi}/tasks/${id}`, task);
  } 

  public deleteTask(id : number) : Observable<Task>{
    return this.http.delete<Task>(`${environment.restApi}/tasks/${id}`);
  }

}
