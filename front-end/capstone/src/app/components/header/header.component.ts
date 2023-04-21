import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  loggato:boolean=false;
  username:string="";
  constructor(private as:AuthService ) { }

  ngOnInit(): void {
    this.loggato=this.as.isLogged;
    if(this.as.isLogged==true) {
      this.username=this.as.username;
    }
  }

  logout(){
    this.as.logout();
  }


}


