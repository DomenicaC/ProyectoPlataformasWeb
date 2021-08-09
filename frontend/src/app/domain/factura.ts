import { Registro } from "./registro";

export class Factura{
    fecha:String="";
    subtotal:number=0;
    iva:number=0;
    total:number=0;

    usuario:Registro=new Registro;
    
}