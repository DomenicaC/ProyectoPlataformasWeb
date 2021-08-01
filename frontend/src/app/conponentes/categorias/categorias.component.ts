import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CategoriasService} from "../../services/categorias.service";

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.scss']
})
export class CategoriasComponent implements OnInit {

  categorias: any;
  constructor(private router: Router,
              private categoriasService: CategoriasService) { }

  ngOnInit(): void {
    this.categorias = this.categoriasService.getAllCategorias();
  }

}
