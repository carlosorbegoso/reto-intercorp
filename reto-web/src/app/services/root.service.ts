import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Root } from '../models/root';

@Injectable({
  providedIn: 'root'
})
export class RootService {
  API_URL = 'http://localhost:8084/root/list';
  constructor(private http: HttpClient) {}

  getRootList(): Observable<Root[]>{
    return this.http.get<Root[]>(this.API_URL)
    .pipe(res => res)
  }
}
