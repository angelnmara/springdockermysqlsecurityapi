package mx.com.aea.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;
    private Long calificacion;
    private String emocion;
    private Long idUsuario;

}
