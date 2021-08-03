import { Component, OnInit } from '@angular/core';
import {ProductoService} from "../../services/producto.service";
import {count} from "rxjs/operators";
import {Router} from "@angular/router";
import {CarritoService} from "../../services/carrito.service";
import {Producto} from "../../domain/producto";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  productos: any;


  constructor(private router: Router,
              private productoService: ProductoService,
              private carritoService: CarritoService) { }

  ngOnInit(): void {
    //this.productoService.showMessage();
    this.productos = this.productoService.getAllProductos();
    

  }

  addCarrito(codigo: number){
    this.carritoService.addCarrito(codigo,5);
    console.log("Producto Añadido " + codigo)
    
  }



}
