import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {CarritoI} from "../Modelos/carrito/carrito.interface";
import {Producto} from "../domain/producto";
import { ProductoI } from '../Modelos/producto/producto.interface';
import { ProductoService } from './producto.service';
import { variable } from '@angular/compiler/src/output/output_ast';
import { Carrito } from '../domain/carrito';
import { MatDialog } from "@angular/material/dialog";
import { MensajeComponent } from "../conponentes/mensaje/mensaje.component";

@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  productos: any[] = [];
  totalCarrito = 0;
  carrito:CarritoI=new Carrito;
  private productAddedSource = new Subject<any>();
  productAdded$ = this.productAddedSource.asObservable();

  private server_URL = environment.server_URL;

  constructor(private  http: HttpClient,
              private productoService:ProductoService,
              private matDialog: MatDialog) { }

  addProducto(codigo:any): Observable<CarritoI>{

    let url = this.server_URL + '/Produc/unProd?cod='+codigo;

    return this.http.get<CarritoI>(url);

  }

  addCarrito(codigo:number, cantidad:number){

    this.productoService.getSingleProduct(codigo).subscribe(prod => {

      var n= localStorage.length;
      var s=""+n;

      this.carrito.cantidad=cantidad;
      this.carrito.codigo=1;
      this.carrito.nombreProd=prod.nombre;
      this.carrito.productos=codigo;
      this.carrito.precio=prod.precioU;
      this.carrito.total=prod.precioU*cantidad;
      this.carrito.stock=prod.stock;

      console.log(prod.precioU*cantidad);
      for(var i=0;i<localStorage.length;i++){
        var p=JSON.parse(localStorage.getItem(''+i) || '{}');

        if(p["productos"]==codigo){
          this.totalCarrito=1;

        }
      }

      if(this.totalCarrito!=1){
        localStorage.setItem(s,JSON.stringify(this.carrito));
        this.matDialog.open(MensajeComponent, {'data':'El producto ' + prod.nombre + ' fue ingresado exitosamente'});
      }else{
        console.log(this.totalCarrito)
        this.totalCarrito=0;
        this.matDialog.open(MensajeComponent, {'data':'El producto ' + prod.nombre + ' ya esta ingresado en su carrito'});
      }
      //console.log(localStorage.getItem('0'))

    //   let existe = false;
    // this.totalCarrito += prod.precioU;
    // // Si el producto aumenta la cantidad
    // this.productos = this.productos.map(_producto => {

    //   if (_producto.producto.productos === prod.codigo){
    //     _producto.cantidad++;
    //     existe = true;
    //   }
    //   return _producto;

    // });

    // //Añadir un nuevo producto si no se ha añadido antes
    // if (!existe){


    //   this.productos.push({
    //     producto: prod,
    //     cantidad: 1
    //   });
    // }

    // this.productAddedSource.next({productos: this.productos, totalCarrito: this.totalCarrito})

    })


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
