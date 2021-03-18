package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario_detalle")
public class UsuarioDetalle extends CreacionActualizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioDetalle;
    private Long idUsuario;
    private Long idEmpresa;
    private Long idArea;
    private Long idRol;
}
