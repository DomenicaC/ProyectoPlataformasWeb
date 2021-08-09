import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Carrito } from 'src/app/domain/carrito';
import { Factura } from 'src/app/domain/factura';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-chequeo',
  templateUrl: './chequeo.component.html',
  styleUrls: ['./chequeo.component.scss']
})
export class ChequeoComponent implements OnInit {

  productos: any = [];
  cartTotal = 0;
  factura: Factura=new Factura();
  carrito: Carrito=new Carrito();

  constructor(private router: Router,
              private facturaServices:FacturaService) { }

  ngOnInit(): void {

    console.log(localStorage.length);
    for(var i=0;i<localStorage.length;i++){
      var p=JSON.parse(localStorage.getItem(''+i) || '{}');
      this.cartTotal=this.cartTotal+p["total"];
      this.productos.push(p);
    }
 
  } 

  llenarUsuario(){
    console.log(this.factura.usuario.cedula);
    this.facturaServices.getCliente(this.factura.usuario.cedula).subscribe(data =>{
      console.log(data);
      this.factura.usuario=data;
    });
  }

  registrarFactura(){
     console.log(this.factura);

     this.factura.total=this.cartTotal;
     this.factura.iva=this.cartTotal*0.12;
     this.factura.subtotal=this.cartTotal-this.factura.iva;

    this.facturaServices.ingrearFactura(this.factura).subscribe(data =>{
    console.log("datos=> "+data);
  });

    /*for(var i=0;i<localStorage.length;i++){
      this.carrito=JSON.parse(localStorage.getItem(''+i) || '{}')
      this.facturaServices.ingresarCarrito(this.carrito).subscribe(data1=>{
        console.log(data1);
      });
    }*/
    

    console.log("Factura Registrada")
    let params: NavigationExtras = {
      queryParams: {
        factura:this.factura,
        //carrito:this.carrito
      }
    }

    this.router.navigate(['gracias'],params)

  }

}
