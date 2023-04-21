import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLogged:boolean=false;
  email:string="";
  accessToken:string="";
  username:string="";

  constructor(private http:HttpClient, private router:Router) {

  }

  signup(data: {}) {
    return this.http.post<any>("http://localhost:8080/api/auth/signup", data)
  }

  login(data: {}) {
    return this.http.post<any>("http://localhost:8080/api/auth/login", data)
  }

  logout() {
    localStorage.removeItem("user");
    this.isLogged=false;
    this.email="";
    this.accessToken="";
    this.username="";
    window.location.reload();
  }

}
