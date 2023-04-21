import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../auth.service';
import { Router } from '@angular/router';
import { User } from 'src/app/utils/interfacce';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private as:AuthService, private router:Router) { }

  ngOnInit(): void {

  }

  onSubmit (f:NgForm) {
    if(f.value.email!="" && f.value.password!="") {
      this.as.login(f.value).subscribe( data=>{
        console.log(data);
        console.log("login eseguito correttamente")
        const user={} as User;
        user.email=data.email;
        user.accessToken=data.accessToken;
        user.username=data.username;
      localStorage.setItem('user',JSON.stringify(user));
        this.router.navigate(["/"]).then(()=>{
          window.location.reload();
        })
      }, error=>{
        console.log("errore nel login",error);
      })
    }
  }

}
