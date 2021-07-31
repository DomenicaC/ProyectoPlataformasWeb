import { Injectable } from '@angular/core';
import {Login} from "../domain/login";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }



  logear(login: Login): Observable<any>{

    const url = environment.server_URL + '/Clientes/Control/{usuario:String}/{contra:String}';
    return this.http.post<any>(url, login)

  }

}
