import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'capstone';

  constructor(private as:AuthService, private router:Router) { }

  ngOnInit(): void {
    if(localStorage.getItem('user')){
      const user=JSON.parse(localStorage.getItem('user')!);
      this.as.accessToken=user.accessToken;
      this.as.email=user.email;
      this.as.username=user.username;
      this.as.isLogged=true;
    }
    console.log(this.as.isLogged)
    console.log(this.as.email)
    console.log(this.as.username)
  }
}

