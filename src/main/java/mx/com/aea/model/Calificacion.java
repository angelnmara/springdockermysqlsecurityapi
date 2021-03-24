package mx.com.aea.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;
    private Long idCatCalificacion;
    private Long idUsuario;
    private Long idEmpresa;
    private Date fechaCreacion;
}