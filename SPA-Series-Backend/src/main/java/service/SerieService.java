package service;

import com.example.seriesbackend.model.Serie;
import com.example.seriesbackend.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SerieService {

    private static final Logger logger = LoggerFactory.getLogger(SerieService.class);

    @Autowired
    private SerieRepository serieRepository;

    // Obtener todas las series
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    // Obtener una serie por ID
    public Optional<Serie> getSerieById(Long id) {
        return serieRepository.findById(id);
    }

    // Crear una nueva serie
    public Serie createSerie(Serie serie) {
        // Establecer la fecha actual automáticamente
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDate = now.format(formatter);
        
        logger.info("Creando nueva serie: {}", serie.getTitle());
        logger.info("Fecha actual establecida: {}", currentDate);
        
        serie.setAddedDate(currentDate);
        
        Serie savedSerie = serieRepository.save(serie);
        logger.info("Serie guardada con ID: {} y fecha: {}", savedSerie.getId(), savedSerie.getAddedDate());
        
        return savedSerie;
    }

    // Actualizar una serie existente
    public Serie updateSerie(Long id, Serie serieDetails) {
        Optional<Serie> serieOptional = serieRepository.findById(id);
        
        if (serieOptional.isPresent()) {
            Serie serie = serieOptional.get();
            serie.setTitle(serieDetails.getTitle());
            serie.setCreator(serieDetails.getCreator());
            serie.setRating(serieDetails.getRating());
            serie.setDates(serieDetails.getDates());
            serie.setImage(serieDetails.getImage());
            serie.setChannel(serieDetails.getChannel());
            // No actualizamos addedDate para mantener la fecha original de creación
            
            return serieRepository.save(serie);
        } else {
            throw new RuntimeException("Serie no encontrada con ID: " + id);
        }
    }

    // Eliminar una serie
    public void deleteSerie(Long id) {
        if (serieRepository.existsById(id)) {
            serieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Serie no encontrada con ID: " + id);
        }
    }
} 