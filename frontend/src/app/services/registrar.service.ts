import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Registro} from "../domain/registro";

@Injectable({
  providedIn: 'root'
})
export class RegistrarService {

  private server_URL = environment.server_URL;

  constructor(private  http: HttpClient) { }

  registrar(registro: Registro): Observable<any>{
    const url = this.server_URL + '/Clientes/RegistroCliente';
    return this.http.put(url,registro);
    console.log("Cliente registrado" + registro);
  }
}
