import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SquadreService {

  constructor(private http:HttpClient, private router:Router) { }

  squadre(campionato:string) {
    return this.http.get<any>("http://localhost:8080/api/squadra/" + campionato)
  }

  squadra(nome:string) {
    return this.http.get<any>("http://localhost:8080/api/squadra/nome/" + nome)
  }
}
