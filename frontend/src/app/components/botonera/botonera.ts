import { Component, inject, Input } from "@angular/core";
import { Router, RouterLink } from "@angular/router";
import { SeriesService } from "../../services/series.service";
import { Serie } from "../../interfaces/serie";

@Component({
  selector: "app-botonera",
  imports: [RouterLink],
  templateUrl: "./botonera.html",
  styleUrl: "./botonera.css",
})
export class Botonera {
  
  seriesService = inject(SeriesService);
  router = inject(Router);

  @Input() id: number;
  @Input() parent: string;

  constructor() {
    this.id = 0;
    this.parent = "";
  }

  borrarSerie(id: number) {
    let confirmacion = confirm(
      "¿Está seguro de que quiere eliminar la serie con ID: " + id + "?"
    );
    if (confirmacion) {
      this.seriesService.deleteSerie(id).subscribe({
        next: (response: Serie) => {
          alert("Se ha borrado correctamente la serie: " + response.title);
          if (this.parent === "view") {
            this.router.navigate(["/series"]);
          } else if (this.parent === "card") {
            location.reload();
          }
        },
        error: (error) => {
          console.error("Error al borrar la serie:", error);
          alert("Error al borrar la serie. Por favor, inténtelo de nuevo.");
        },
      });
    }
  }
}
