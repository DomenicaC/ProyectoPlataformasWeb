import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chequeo',
  templateUrl: './chequeo.component.html',
  styleUrls: ['./chequeo.component.scss']
})
export class ChequeoComponent implements OnInit {

  productos: any = [];
  cartTotal = 0;
  constructor() { }

  ngOnInit(): void {

    console.log(localStorage.length);
    for(var i=0;i<localStorage.length;i++){
      var p=JSON.parse(localStorage.getItem(''+i) || '{}');
      this.cartTotal=this.cartTotal+p["total"];
      this.productos.push(p);
    }

  }

}
