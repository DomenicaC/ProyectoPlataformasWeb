import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";
import {CarritoService} from "../../services/carrito.service";

@Component({
  selector: 'app-cat3',
  templateUrl: './cat3.component.html',
  styleUrls: ['./cat3.component.scss']
})
export class Cat3Component implements OnInit {

  productos: any;
  constructor(private router: Router,
              private productoService: ProductoService,
              private carritoService: CarritoService) { }

  ngOnInit(): void {
    this.productos = this.productoService.getCat3Prod();
  }

  addCarrito(codigo: number){

    var d=(document.getElementById(""+codigo) as HTMLInputElement).value;

    var num=parseInt(d);
    console.log(num);
    this.carritoService.addCarrito(codigo,num);
    console.log("Producto Añadido " + codigo)

  }
}
