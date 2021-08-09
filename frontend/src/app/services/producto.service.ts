import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Producto} from "../domain/producto";
import {ProductoI} from "../Modelos/producto/producto.interface";

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

    console.log("Listando Productos")

  }
  /*----------------------------------------------------------------------------------*/
  getSingleProduct(codigo:any): Observable<ProductoI>{

    let url = this.server_URL + '/Produc/unProd?cod='+codigo;
    return this.http.get<ProductoI>(url);
    console.log("Producto Obtenido")
  }
  /*----------------------------------------------------------------------------------*/
  getProductoCompleto(codigo:any): Observable<ProductoI>{

    let url = this.server_URL + '/Produc/Producto?cod='+codigo;
    return this.http.get<ProductoI>(url);
    console.log("Producto Obtenido")
  }
  /*----------------------------------------------------------------------------------*/

  
  getCat1Prod(): Observable<any> {
    const url = environment.server_URL + '/Produc/catLacteos';
    return this.http.get(url)

    console.log("Listando Productos categoria 1")
  }

  getCat2Prod(): Observable<any> {
    const url = environment.server_URL + '/Produc/catLimpieza';
    return this.http.get(url)

    console.log("Listando Productos categoria 2")
  }

  getCat3Prod(): Observable<any> {
    const url = environment.server_URL + '/Produc/catRopa';
    return this.http.get(url)

    console.log("Listando Productos categoria 3")
  }

  showMessage(){

  }

}
