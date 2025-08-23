package spaseries.controller;

import spaseries.model.Serie;
import spaseries.service.SerieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "http://localhost:4200")
public class SerieController {

    @Autowired
    private SerieService serieService;

    // GET /api/series - Obtener todas las series
    @GetMapping
    public ResponseEntity<List<Serie>> getAllSeries() {
        List<Serie> series = serieService.getAllSeries();
        return ResponseEntity.ok(series);
    }

    // GET /api/series/{id} - Obtener una serie por ID
    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable Long id) {
        Optional<Serie> serie = serieService.getSerieById(id);
        if (serie.isPresent()) {
            return ResponseEntity.ok(serie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/series - Crear una nueva serie
    @PostMapping
    public ResponseEntity<Serie> createSerie(@Valid @RequestBody Serie serie) {
        Serie createdSerie = serieService.createSerie(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSerie);
    }

    // PUT /api/series/{id} - Actualizar una serie existente
    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable Long id, @Valid @RequestBody Serie serieDetails) {
        try {
            Serie updatedSerie = serieService.updateSerie(id, serieDetails);
            return ResponseEntity.ok(updatedSerie);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/series/{id} - Eliminar una serie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Long id) {
        try {
            serieService.deleteSerie(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 