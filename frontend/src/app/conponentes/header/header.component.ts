import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BuscarService} from "../../services/buscar.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Buscar} from "../../domain/buscar";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {


  buscarForm = new FormGroup({
    palabra: new FormControl('')
  })

  ruta: any;

  buscar: Buscar = new Buscar();

  constructor(private router: Router,
              private buscarService: BuscarService,
              private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  buscarP(form:any){
    let buscar1 = ((document.getElementById("buscar") as HTMLInputElement).value);
    console.log(buscar1)
    //this.router.navigate(['http://localhost:4200/buscar/', buscar1]);
    this.ruta = this.buscarForm.getRawValue()
    let url: string = '/buscar/'+ buscar1;
    console.log(url);
    this.router.navigate([url])
  }

}
