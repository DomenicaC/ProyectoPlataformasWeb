import { Component, OnInit } from '@angular/core';
import {Producto} from "../../domain/producto";
import {ActivatedRoute, NavigationExtras, ParamMap, Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductoI} from "../../Modelos/producto/producto.interface";
import {map} from "rxjs/operators";
import {CarritoService} from "../../services/carrito.service";

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {

  producto: Producto = new Producto();
  productos: any;
  datosProd: ProductoI = new Producto();

  constructor(private router: Router,
              private productoService: ProductoService,
              private activateRoute: ActivatedRoute,
              private carritoService: CarritoService) { }

  ngOnInit(): void {

    let codigoP = this.activateRoute.snapshot.paramMap.get('codigo')
    console.log(codigoP)
    this.productoService.getSingleProduct(codigoP).subscribe(data =>{
      console.log(data)

      this.producto = data;
    })

    }

  addCarrito(codigo: number){

    var d=(document.getElementById(""+codigo) as HTMLInputElement).value;

    var num=parseInt(d);
    console.log(num);
    this.carritoService.addCarrito(codigo,num);
    console.log("Producto Añadido " + codigo)

  }



  /*getSingleP(){
    console.log(this.producto);
    this.productoService.getSingleProduct(this.producto).subscribe(data => {
      console.log(data)
      let dataResponseP: ResponsePI = data;
    });

    this.router.navigate(['/productos',this.producto.codigo]);
  }*/

}
