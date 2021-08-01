import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductoService} from "../../services/producto.service";

@Component({
  selector: 'app-cat1',
  templateUrl: './cat1.component.html',
  styleUrls: ['./cat1.component.scss']
})
export class Cat1Component implements OnInit {

  productos: any;
  constructor(private router: Router,
              private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productos = this.productoService.getCat1Prod();
  }

}
