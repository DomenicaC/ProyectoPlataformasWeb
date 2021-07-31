import { Injectable } from '@angular/core';
import {Login} from "../domain/login";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  login: Login = new Login();

  constructor(private http: HttpClient) { }

  usuario = this.login.correo;
  contrasenia = this.login.contrasenia;

  logear(login: Login): Observable<any>{

    const url = environment.server_URL + '/Clientes/Control/usuario/contrasenia';
    return this.http.post<any>(url, login)

  }

}
