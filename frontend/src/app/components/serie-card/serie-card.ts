import { Component, Input } from '@angular/core';
import { Serie } from '../../interfaces/serie';
import { Botonera } from '../botonera/botonera';

@Component({
  selector: 'app-serie-card',
  imports: [Botonera],
  templateUrl: './serie-card.html',
  styleUrl: './serie-card.css'
})
export class SerieCard {
  
  @Input() miSerie!: Serie;

}
