import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import { HeaderComponent } from './conponentes/header/header.component';
import { FooterComponent } from './conponentes/footer/footer.component';
import { CarritoComponent } from './conponentes/carrito/carrito.component';
import { ChequeoComponent } from './conponentes/chequeo/chequeo.component';
import { HomeComponent } from './conponentes/home/home.component';
import { ProductosComponent } from './conponentes/productos/productos.component';
import { GraciasComponent } from './conponentes/gracias/gracias.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './conponentes/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RegistrarComponent } from './conponentes/registrar/registrar.component';
import {Cat1Component} from "./conponentes/cat1/cat1.component";
import {Cat2Component} from "./conponentes/cat2/cat2.component";
import {Cat3Component} from "./conponentes/cat3/cat3.component";
import { CategoriasComponent } from './conponentes/categorias/categorias.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CarritoComponent,
    Cat1Component,
    Cat2Component,
    Cat3Component,
    ChequeoComponent,
    HomeComponent,
    ProductosComponent,
    GraciasComponent,
    LoginComponent,
    RegistrarComponent,
    CategoriasComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
