import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./conponentes/home/home.component";
import {ProductosComponent} from "./conponentes/productos/productos.component";
import {CarritoComponent} from "./conponentes/carrito/carrito.component";
import {ChequeoComponent} from "./conponentes/chequeo/chequeo.component";
import {GraciasComponent} from "./conponentes/gracias/gracias.component";

const routes: Routes = [

  {
    path: '',component: HomeComponent
  },
  {
    path: 'productos/:id', component: ProductosComponent
  },
  {
    path: 'carrito', component: CarritoComponent
  },
  {
    path: 'chequeo', component: ChequeoComponent
  },
  {
    path: 'gracias', component: GraciasComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
