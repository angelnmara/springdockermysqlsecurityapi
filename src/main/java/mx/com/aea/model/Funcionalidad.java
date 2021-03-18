package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionalidad")
public class Funcionalidad extends CreacionActualizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionalidad;
    private Long idPlataforma;
    private String nombreFuncionalidad;
    private String descripcionFuncionalidad;

}
