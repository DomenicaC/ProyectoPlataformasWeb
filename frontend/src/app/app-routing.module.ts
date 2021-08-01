import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./conponentes/home/home.component";
import {ProductosComponent} from "./conponentes/productos/productos.component";
import {CarritoComponent} from "./conponentes/carrito/carrito.component";
import {ChequeoComponent} from "./conponentes/chequeo/chequeo.component";
import {GraciasComponent} from "./conponentes/gracias/gracias.component";
import {LoginComponent} from "./conponentes/login/login.component";
import {RegistrarComponent} from "./conponentes/registrar/registrar.component";
import {Cat1Component} from "./conponentes/cat1/cat1.component";
import {Cat2Component} from "./conponentes/cat2/cat2.component";
import {Cat3Component} from "./conponentes/cat3/cat3.component";
import {CategoriasComponent} from "./conponentes/categorias/categorias.component";

const routes: Routes = [

  {
    path: '',component: HomeComponent
  },
  {
    path: 'productos/:codigo', component: ProductosComponent
  },
  {
    path: 'carrito', component: CarritoComponent
  },
  {
    path: 'chequeo', component: ChequeoComponent
  },
  {
    path: 'gracias', component: GraciasComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'registrar', component: RegistrarComponent
  },
  {
    path: 'cat1', component: Cat1Component
  },
  {
    path: 'cat2', component: Cat2Component
  },
  {
    path: 'cat3', component: Cat3Component
  },
  {
    path: 'categorias', component: CategoriasComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
