import { Component, OnInit } from '@angular/core';
import {Registro} from "../../domain/registro";
import {NavigationExtras, Router} from "@angular/router";
import {RegistrarService} from "../../services/registrar.service";

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.scss']
})
export class RegistrarComponent implements OnInit {

  registro: Registro = new Registro();

  constructor(private router: Router,
              private registrarService: RegistrarService) { }

  ngOnInit(): void {
  }

  registrarse(){
    console.log(this.registro);
    this.registrarService.registrar(this.registro).subscribe(data =>{
      console.log(data)
    });

    console.log("Usuario registrado")
    let params: NavigationExtras = {
      queryParams: {
        registro: this.registro
      }
    }
    this.router.navigate(['login'],params);

  }

}
