import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Producto} from "../../domain/producto";
import {CarritoI} from "../../Modelos/carrito/carrito.interface";
import {Carrito} from "../../domain/carrito";
import {ActivatedRoute, Router} from "@angular/router";
import {CarritoService} from "../../services/carrito.service";

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.scss']
})
export class CarritoComponent implements OnInit {

  producto: Producto = new Producto();
  productos: any = [];
  numProds = 0;
  expanded = false;
  expandedHeight: string = '';
  cartTotal = 0;
  heredar: string = '';
  valor=0;
  changeDetectorRef: ChangeDetectorRef ;

  datosCarri: CarritoI = new Carrito();


  
  constructor(private router: Router,
              private carritoService: CarritoService,
              private activateRoute: ActivatedRoute,
              changeDetectorRef: ChangeDetectorRef) {
    this.changeDetectorRef = changeDetectorRef;
  }

  ngOnInit(): void {

    /*this.expandedHeight = '0';
    this.carritoService.productAdded$.subscribe(data => {
      this.productos = data.productos;
      this.cartTotal = data.cartTotal;
      this.numProds = data.productos.reduce((acc:any, prod:any) => {
          acc += prod.cantidad;
          return acc;
      }, 0);

    })

    let codigoP = this.activateRoute.snapshot.paramMap.get('codigo')
    console.log(codigoP)*/
    //console.log(localStorage.length);
    this.productos=[]
    this.cartTotal=0;
    for(var i=0;i<localStorage.length;i++){
      var p=JSON.parse(localStorage.getItem(''+i) || '{}');
      this.cartTotal=this.cartTotal+p["total"];
      this.productos.push(p);
    }

    console.log(this.productos);
    // this.carrito=JSON.parse(localStorage.getItem('0') || '{}');
    // console.log(this.carrito)
    //localStorage.clear();
  }

  eliminarProd(codigo: number){
    console.log(codigo)
    this.carritoService.eliminarProducto(codigo);
    this.ngOnInit();
    
  }
  onCartClick() {
    this.expanded = !this.expanded;
  }



}
