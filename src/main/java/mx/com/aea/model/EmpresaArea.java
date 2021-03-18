package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="empresa_area")
public class EmpresaArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresaArea;
    private Long idArea;
    private Long idEmpresa;
    private Long usuarioCreacion;
    private Date fechaCreacion;
    private Long usuarioActualizacion;
    private Date fechaActualizacion;
}
