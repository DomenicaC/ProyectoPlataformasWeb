import { Component, OnInit } from '@angular/core';
import {Producto} from "../../domain/producto";
import {CarritoI} from "../../Modelos/carrito/carrito.interface";
import {Carrito} from "../../domain/carrito";
import {ActivatedRoute, Router} from "@angular/router";
import {CarritoService} from "../../services/carrito.service";

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss']
})
export class CarritoComponent implements OnInit {

  producto: Producto = new Producto();
  productos: any;
  datosCarri: CarritoI = new Carrito();

  constructor(private router: Router,
              private carritoService: CarritoService,
              private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {

    let codigoP = this.activateRoute.snapshot.paramMap.get('codigo')
    console.log(codigoP)

  }


}
