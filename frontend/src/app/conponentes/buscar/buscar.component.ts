import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BuscarService} from "../../services/buscar.service";

@Component({
  selector: 'app-buscar',
  templateUrl: './buscar.component.html',
  styleUrls: ['./buscar.component.scss']
})
export class BuscarComponent implements OnInit {

  produtos: any;
  constructor(private router: Router,
              private buscarService: BuscarService,
              private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let palabra = this.activateRoute.snapshot.paramMap.get('palabra')
    this.buscarService.buscarProducto(palabra).subscribe(data => {
      console.log(data)

      this.produtos = data;
    });
  }

}
