import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";

@Component({
  selector: 'app-cat2',
  templateUrl: './cat2.component.html',
  styleUrls: ['./cat2.component.scss']
})
export class Cat2Component implements OnInit {

  productos: any;
  constructor(private router: Router,
              private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productos = this.productoService.getCat2Prod();
  }

}
