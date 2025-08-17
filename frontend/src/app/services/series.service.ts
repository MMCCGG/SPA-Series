import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Serie } from "../interfaces/serie";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class SeriesService {
  httpClient = inject(HttpClient);

  // conectar con la bbdd de postgres
  private baseUrl = "http://localhost:8080/api";

  // obtener todas las series
  getAllSeries(): Observable<Serie[]> {
    return this.httpClient.get<Serie[]>(`${this.baseUrl}/series`);
  }

  // obtener una serie por su id
  getSerieById(id: number): Observable<Serie> {
    return this.httpClient.get<Serie>(`${this.baseUrl}/series/${id}`);
  }

  // crear una nueva serie
  createSerie(serie: Serie): Observable<Serie> {
    return this.httpClient.post<Serie>(`${this.baseUrl}/series`, serie);
  }

  // actualizar una serie
  updateSerie(id: number, serie: Serie): Observable<Serie> {
    return this.httpClient.put<Serie>(`${this.baseUrl}/series/${id}`, serie);
  }

  // eliminar una serie
  deleteSerie(id: number): Observable<Serie> {
    return this.httpClient.delete<Serie>(`${this.baseUrl}/series/${id}`);
  }
}
