import { Component, inject, OnDestroy } from "@angular/core";
import { Serie } from "../../interfaces/serie";
import { SeriesService } from "../../services/series.service";
import { SerieCard } from "../../components/serie-card/serie-card";
import { Subscription } from "rxjs";

@Component({
  selector: "app-series-list",
  imports: [SerieCard],
  templateUrl: "./series-list.html",
  styleUrl: "./series-list.css",
})
export class SeriesList {
  arrSeries: Serie[];
  serieService = inject(SeriesService);

  constructor() {
    this.arrSeries = [];
  }

  ngOnInit(): void {
    this.loadSeries();
  }

  private loadSeries(): void {
    //Usando Observables
    this.serieService.getAllSeries().subscribe((data: Serie[]) => {
      this.arrSeries = data;
    });
  }
}
