package mx.com.aea.model;

import lombok.Data;
import java.util.Date;

@Data
public class CreacionActualizacion {
    private Long usuarioCreacion;
    private Date fechaCreacion;
    private Long usuarioActualizacion;
    private Date fechaActualizacion;
}
