package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private Date fechaCreacion;
    private Date fechaActualizacion;
}
