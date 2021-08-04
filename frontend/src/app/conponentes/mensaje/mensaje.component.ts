import {Component, Inject, OnInit} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog'

@Component({
  selector: 'app-mensaje',
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.scss']
})
export class MensajeComponent implements OnInit {

  datos: string = '';

  constructor(@Inject(MAT_DIALOG_DATA) private data: string) {
    this.datos = data;
  }

  ngOnInit(): void {
  }

}
