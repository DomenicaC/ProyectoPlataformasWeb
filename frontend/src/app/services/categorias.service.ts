import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Categoria} from "../domain/categoria";

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  private server_URL = environment.server_URL;
  constructor(private  http: HttpClient) { }

  getAllCategorias(): Observable<any>{
    const url = this.server_URL + '/Cates/Categorias';
    return this.http.get(url)

    console.log("Listando Categorias")
  }
}



