import {ProductoService} from "../services/producto.service";

export interface CarritoModelServer {
  total: number;
  data: [{
    producto: ProductoService,
    numIncar: number;
  }];
}

export interface CarritoModelPublic {
  total: number;
  prodData: [{
    codigo: number;
    incar: number;
  }];
}
