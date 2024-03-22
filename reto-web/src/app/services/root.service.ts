import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Root } from '../models/root';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RootService {
  API_URL = environment.apiUrl;
  constructor(private http: HttpClient) {}

  getRootList(): Observable<Root[]>{
    return this.http.get<Root[]>(this.API_URL)
    .pipe(res => res)
  }
}
