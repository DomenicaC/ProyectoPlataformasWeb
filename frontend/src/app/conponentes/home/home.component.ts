import { Component, OnInit } from '@angular/core';
import {ProductoService} from "../../services/producto.service";
import {count} from "rxjs/operators";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  productos: any[] = [];


  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.showMessage();
    /*this.productoService.getAllProductos().subscribe((prods: {count: Number, productos: any[]}) => {
        this.productos = prods.productos;
        console.log(this.productos);
    });*/
  }

}
