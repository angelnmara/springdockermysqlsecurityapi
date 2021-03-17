package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String correoEmpresa;
    private String telefonoEmpresa;
    private Integer numeroColaboradoresEmpresa;
    private Date fechaCreacion;
    private Date fechaActualizacion;
}
