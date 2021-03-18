package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="empresa_rol")
public class EmpresaRol extends CreacionActualizacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresaRol;
    private Long idEmpresa;
    private Long idRol;
}
