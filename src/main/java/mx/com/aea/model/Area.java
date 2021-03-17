package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    private String nombreArea;
    private String descripcionArea;
    private Date fechaCreacion;
    private Date fechaActualizacion;
}
