import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {CarritoI} from "../Modelos/carrito/carrito.interface";
import {Producto} from "../domain/producto";

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  productos: any[] = [];
  totalCarrito = 0;

  private productAddedSource = new Subject<any>();
  productAdded$ = this.productAddedSource.asObservable();

  private server_URL = environment.server_URL;

  constructor(private  http: HttpClient) { }

  addProducto(codigo:any): Observable<CarritoI>{

    let url = this.server_URL + '/Produc/unProd?cod='+codigo;
    return this.http.get<CarritoI>(url);
    console.log("Añadido al carrito")
  }

  addCarrito(producto: Producto){

    let existe = false;
    this.totalCarrito += producto.precioU;
    // Si el producto aumenta la cantidad
    this.productos = this.productos.map(_producto => {

      if (_producto.producto.productos === producto.codigo){
        _producto.cantidad++;
        existe = true;
      }
      return _producto;

    });

    //Añadir un nuevo producto si no se ha añadido antes
    if (!existe){
      this.productos.push({
        producto: producto,
        cantidad: 1
      });
    }

    this.productAddedSource.next({productos: this.productos, totalCarrito: this.totalCarrito})

  }

  eliminarProducto(producto: Producto){

    this.productos = this.productos.filter(_producto => {
      if (_producto.producto.productos === producto.codigo) {
        this.totalCarrito -= _producto.producto.precioU * _producto.cantidad;
        return false;
      }
      return true;
    });

    this.productAddedSource.next({productos: this.productos, totalCarrito: this.totalCarrito});

  }

  vaciarCarrito(){
    this.productos = [];
    this.totalCarrito = 0;
    this.productAddedSource.next({productos: this.productos, totalCarrito: this.totalCarrito});
  }

  calcularSubtotal(){

  }

}
