import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { HeaderComponent } from './conponentes/header/header.component';
import { FooterComponent } from './conponentes/footer/footer.component';
import { CarritoComponent } from './conponentes/carrito/carrito.component';
import { ChequeoComponent } from './conponentes/chequeo/chequeo.component';
import { HomeComponent } from './conponentes/home/home.component';
import { ProductosComponent } from './conponentes/productos/productos.component';
import { GraciasComponent } from './conponentes/gracias/gracias.component';
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './conponentes/login/login.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CarritoComponent,
    ChequeoComponent,
    HomeComponent,
    ProductosComponent,
    GraciasComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
