import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MaglieService {

  constructor(private http:HttpClient, private router:Router) {

   }

   maglie(campionato:string, squadra:string) {
    return this.http.get<any>("http://localhost:8080/api/maglia/" + campionato + "/" + squadra)
  }

  maglia(id:string) {
    return this.http.get<any>("http://localhost:8080/api/maglia/" + id)
  }
}
