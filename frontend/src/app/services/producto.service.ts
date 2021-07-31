import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private server_URL = environment.server_URL;
  constructor(private  http: HttpClient) { }

  /*Obtener todos los productos */

  getAllProductos(): Observable<any>{

    const url = environment.server_URL + '/Produc/Productos';
    return this.http.get(url)

  }

  showMessage(){
    console.log("Listando Productos")
  }

}
