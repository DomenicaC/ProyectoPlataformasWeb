import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductoI} from "../Modelos/producto/producto.interface";

@Injectable({
  providedIn: 'root'
})
export class BuscarService {

  private server_URL = environment.server_URL;
  constructor(private  http: HttpClient) { }

  buscarProducto(palabra: any): Observable<ProductoI>{

    let url = this.server_URL + '/Produc/Buscarprod?palabra='+ palabra;
    return this.http.get<ProductoI>(url);
    console.log("Producto Obtenido")

  }


}
