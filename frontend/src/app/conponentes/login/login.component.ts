import { Component, OnInit } from '@angular/core';
import {Login} from "../../domain/login";
import {NavigationExtras, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login: Login = new Login();

  constructor(private router: Router,
              private loginService: LoginService) { }

  ngOnInit(): void {
  }

  loguear(){
    console.log(this.login)
    this.loginService.logear(this.login);
    let params: NavigationExtras = {
      queryParams: {
        login: this.login
      }
    }
    console.log("Cliente logueado")

    this.router.navigate([''], params)
  }



}
