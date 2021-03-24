package mx.com.aea.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "funcionalidad_empresa_rol")
public class FuncionalidadEmpresaRol extends CreacionActualizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionalidadEmpresaRol;
    private Long idFuncionalidad;
    private Long idEmpresa;
    private Long idRol;
}