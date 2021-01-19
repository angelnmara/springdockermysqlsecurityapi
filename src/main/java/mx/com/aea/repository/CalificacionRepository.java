package mx.com.aea.repository;

import mx.com.aea.model.Calificacion;
import mx.com.aea.model.FiltrosCalificacion;

import java.util.Date;
import java.util.List;

public interface CalificacionRepository {
    List<Calificacion> findCalificacionByName(String name, Integer annio, Integer mes) throws Exception;
    List<Calificacion> findCalificacionByDate(Date fecha);
}
