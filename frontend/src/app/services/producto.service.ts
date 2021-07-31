import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private server_URL = environment.server_URL;
  constructor(private  http: HttpClient) { }

  /*Obtener todos los productos */
  getAllProductos(numberOfResults = 10){

    return this.http.get(this.server_URL+'/productos', {
      params: {
        limit: numberOfResults.toString()
      }
    });

  }

  showMessage(){
    console.log("Llamando servicio")
  }

}
