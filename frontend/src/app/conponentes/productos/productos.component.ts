import { Component, OnInit } from '@angular/core';
import {Producto} from "../../domain/producto";
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.scss']
})
export class ProductosComponent implements OnInit {

  producto: Producto = new Producto();
  productos: any;
  constructor(private router: Router,
              private productoService: ProductoService,
              private _route: ActivatedRoute) { }

  ngOnInit(): void {

  }

  getSingleP(){
    console.log(this.producto);
    this.productoService.getSingleProduct(this.producto).subscribe(data => {
      console.log("Data " + data)
    });

    let params: NavigationExtras = {
      queryParams: {
        producto: this.producto
      }
    }

    this.router.navigate(['/productos',this.producto.codigo]);
  }

}
