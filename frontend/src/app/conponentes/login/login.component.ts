import { Component, OnInit } from '@angular/core';
import {Login} from "../../domain/login";
import {NavigationExtras, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login: Login = new Login();

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  guardar(){
    console.log(this.login)
    let params: NavigationExtras = {
      queryParams: {
        login: this.login
      }
    }
    console.log("Cliente logeado")

    this.router.navigate([''], params)
  }



}
