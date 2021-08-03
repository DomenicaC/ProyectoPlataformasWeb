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
  cantidad=0;

  constructor(private router: Router,
              private productoService: ProductoService,
              private carritoService: CarritoService) { }

  ngOnInit(): void {
    //this.productoService.showMessage();
    this.productos = this.productoService.getAllProductos();
    

  }



  addCarrito(codigo: number){
    
    var d=(document.getElementById(""+codigo) as HTMLInputElement).value;
    
    var num=parseInt(d);
    console.log(num);
    this.carritoService.addCarrito(codigo,num);
    console.log("Producto Añadido " + codigo)
    
  }



}
