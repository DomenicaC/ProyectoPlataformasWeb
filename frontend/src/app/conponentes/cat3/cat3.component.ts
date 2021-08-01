import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";

@Component({
  selector: 'app-cat3',
  templateUrl: './cat3.component.html',
  styleUrls: ['./cat3.component.scss']
})
export class Cat3Component implements OnInit {

  productos: any;
  constructor(private router: Router,
              private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productos = this.productoService.getCat3Prod();
  }

}
