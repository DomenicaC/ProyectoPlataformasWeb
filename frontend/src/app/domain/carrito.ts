import { Factura } from "./factura";

export class Carrito {
  codigo: number = 0;
  productos: number = 0;
  nombreProd: String = '';
  cantidad: number = 0;
  precio: number = 0;
  total: number = 0;
  factura: Factura = new Factura;
  stock:number=0;
}
