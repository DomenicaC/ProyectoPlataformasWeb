import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gracias',
  templateUrl: './gracias.component.html',
  styleUrls: ['./gracias.component.scss']
})
export class GraciasComponent implements OnInit {

  productos: any = [];
  cartTotal = 0;
  constructor() { }

  ngOnInit(): void {

    for(var i=0;i<localStorage.length;i++){
      var p=JSON.parse(localStorage.getItem(''+i) || '{}');
      this.cartTotal=this.cartTotal+p["total"];
      this.productos.push(p);
    }

  }

}
