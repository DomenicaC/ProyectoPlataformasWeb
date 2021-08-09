import { Factura } from "src/app/domain/factura";

export interface CarritoI {
  codigo: number;
  productos: number;
  nombreProd: String;
  cantidad: number;
  precio: number;
  total: number;
  factura: Factura;
  stock:number;
}
