import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Carrito } from 'src/app/domain/carrito';
import { Factura } from 'src/app/domain/factura';
import { CarritoCliente } from 'src/app/domain/carritoCliente';
import { FacturaService } from 'src/app/services/factura.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-chequeo',
  templateUrl: './chequeo.component.html',
  styleUrls: ['./chequeo.component.scss']
})
export class ChequeoComponent implements OnInit {

  productos: any = [];
  cartTotal = 0;
  factura: Factura=new Factura();
  carrito: CarritoCliente= new CarritoCliente();

  constructor(private router: Router,
              private productoService: ProductoService,
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
      //console.log(data);
      this.factura.usuario=data;
    });
  }

  registrarFactura(){
     //console.log(this.factura);
     const datePipe = new DatePipe('en-US');
     this.factura.fecha= ""+datePipe.transform(new Date,"dd-MM-yyyy");
     this.factura.total=this.cartTotal;
     this.factura.iva=this.cartTotal*0.12;
     this.factura.subtotal=this.cartTotal-this.factura.iva;

  //    this.facturaServices.ingrearFactura(this.factura).subscribe(data =>{
  //    //console.log("datos=> "+data);
  //  });

    for(var i=0;i<localStorage.length;i++){
      this.carrito=JSON.parse(localStorage.getItem(''+i) || '{}')
      //this.carrito.factura=this.factura;

      console.log(this.carrito);
      // this.productoService.getProductoCompleto(this.carrito.productos).subscribe(data2 =>{
      //   this.carrito.productos=data2;
      //   //console.log(this.carrito)
      // });
        this.facturaServices.ingresarCarrito(this.carrito).subscribe(data1=>{
          //console.log(data1);
        });
      
    }
    

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
