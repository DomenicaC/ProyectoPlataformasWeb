import { Component, OnInit } from '@angular/core';
import {ProductoService} from "../../services/producto.service";
import {count} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  productos: any;


  constructor(private router: Router,
              private productoService: ProductoService) { }

  ngOnInit(): void {
    //this.productoService.showMessage();
    this.productos = this.productoService.getAllProductos();


  }



}
