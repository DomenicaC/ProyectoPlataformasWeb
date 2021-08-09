import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Carrito } from '../domain/carrito';
import { CarritoCliente } from '../domain/carritoCliente';
import { Factura } from '../domain/factura';
import { Registro } from '../domain/registro';
import { ResponseI } from '../Modelos/login/response.interface';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  private server_URL = environment.server_URL;

  constructor(private  http: HttpClient) { }

  ingrearFactura(factura:Factura): Observable<any>{
    const url=this.server_URL+"/Factura/RegistroFactura";
    return this.http.put(url,factura);
  }

  ingresarCarrito(carrito:CarritoCliente): Observable<any>{
    const url=this.server_URL+"/Factura/RegistroCarrito";
    
    return this.http.put(url,carrito);
  }

  getCliente(cedula:String): Observable<Registro>{
    const url=this.server_URL+"/Clientes/getcliente/"+cedula;

    return this.http.post<Registro>(url,cedula)
  }

}
