package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "El título es obligatorio")
    private String title;

    @Column(name = "creator", nullable = false)
    @NotBlank(message = "El creador es obligatorio")
    private String creator;

    @Column(name = "rating", nullable = false)
    @Min(value = 0, message = "El rating debe ser mayor o igual a 0")
    @Max(value = 10, message = "El rating debe ser menor o igual a 10")
    private Integer rating;

    @Column(name = "dates", nullable = false)
    @NotBlank(message = "Las fechas son obligatorias")
    private String dates;

    // fecha de añadicion a la BBDD
    @Column(name = "added_date", nullable = false)
    private String addedDate;

    @Column(name = "image", nullable = false)
    @NotBlank(message = "La imagen es obligatoria")
    private String image;

    @Column(name = "channel", nullable = false)
    @NotBlank(message = "El canal es obligatorio")
    private String channel;

}