import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private as:AuthService, private router:Router) { }

  ngOnInit(): void {

  }

  onSubmit (f:NgForm) {
    if(f.value.name!="") {

      this.as.signup(f.value).subscribe( data=>{
        console.log(data);
        console.log("register eseguito correttamente")
        this.router.navigate(["/login"])
      }, error=>{
        console.log("errore nel register",error);
        this.router.navigate(["/login"])

      })
    }
  }

}
