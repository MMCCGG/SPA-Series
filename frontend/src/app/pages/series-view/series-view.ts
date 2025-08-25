import { Component, inject } from "@angular/core";
import { Serie } from "../../interfaces/serie";
import { SeriesService } from "../../services/series.service";
import { ActivatedRoute } from "@angular/router";
import { Botonera } from "../../components/botonera/botonera";

@Component({
  selector: "app-series-view",
  imports: [Botonera],
  templateUrl: "./series-view.html",
  styleUrl: "./series-view.css",
})
export class SeriesView {
  seriesService = inject(SeriesService);
  activatedRoute = inject(ActivatedRoute);

  miSerie!: Serie;

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: any) => {
      let id: number = params.id as number;
      console.log("ID de la serie a cargar:", id);

      this.seriesService.getSerieById(id).subscribe({
        next: (serie: Serie) => {
          this.miSerie = serie;
          console.log("Serie cargada exitosamente:", this.miSerie);
        },
        error: (error) => {
          console.error("Error al llamar a la API:", error);
          console.error("Status:", error.status);
          console.error("Message:", error.message);
        },
      });
    });
  }
}
