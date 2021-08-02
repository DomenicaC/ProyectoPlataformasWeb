import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CarritoI} from "../Modelos/carrito/carrito.interface";

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private server_URL = environment.server_URL;

  constructor(private  http: HttpClient) { }

  addProducto(codigo:any): Observable<CarritoI>{
    let url = this.server_URL + '/Produc/unProd?cod='+codigo;
    return this.http.get<CarritoI>(url);
    console.log("Añadido al carrito")
  }

  calcularSubtotal(){

  }

}
