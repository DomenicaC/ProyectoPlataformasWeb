import { Component, OnInit } from '@angular/core';
import {Login} from "../../domain/login";
import {NavigationExtras, Router} from "@angular/router";
import {LoginService} from "../../services/login.service";
import {LoginI} from "../../Modelos/login/login.interface";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ResponseI} from "../../Modelos/login/response.interface";
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    usuario: new FormControl('',Validators.required),
    contrasenia: new FormControl('',Validators.required)
  })

  login: Login = new Login();

  constructor(private router: Router,
              private loginService: LoginService) { }

  ngOnInit(): void {
  }

  onLogin(form: LoginI){
    this.loginService.logear(form).subscribe(data => {
      console.log(data)
      let dataResponse: ResponseI = data;
      if(dataResponse.msj == "ERROR"){
        console.log(dataResponse.msj)
        console.log("Correo o contraseña incorrecta")
      }else if(dataResponse.msj == "OK"){
        console.log(dataResponse.msj)
        environment.sesion=true;
        console.log(environment.sesion)
        this.router.navigate(['']);
      }
    });
    console.log(form)

  }

  /*loguear(form1:LoginI){
    console.log(this.login)
    this.loginService.logear(form1).subscribe(data => {
      console.log("Data " + data)
    });

    console.log("Cliente logueado")

    this.router.navigate([''])
  }*/



}
