import { Injectable } from '@angular/core';
import {Login} from "../domain/login";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {LoginI} from "../Modelos/login/login.interface";
import {ResponseI} from "../Modelos/login/response.interface";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  login: Login = new Login();

  constructor(private http: HttpClient) { }

  /*usuario = this.login.correo;
  contrasenia = this.login.contrasenia;*/


  logear(form: LoginI): Observable<ResponseI>{

    let url = environment.server_URL + '/Clientes/Control/'+ form.usuario + '/' + form.contrasenia;
    return this.http.post<ResponseI>(url, form)

  }

}
