package mx.com.aea.implement;

import mx.com.aea.model.Annio;
import mx.com.aea.model.Calificacion;
import mx.com.aea.model.FiltrosCalificacion;
import mx.com.aea.model.Mes;
import mx.com.aea.repository.CalificacionJpaRepository;
import mx.com.aea.repository.CalificacionRepository;
import mx.com.aea.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalificacionJpaServiceImpl implements CalificacionRepository {
    private final CalificacionJpaRepository repository;

    public CalificacionJpaServiceImpl(CalificacionJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Calificacion> findCalificacionByName(String name, Integer annio, Integer mes) throws Exception {
        List<Calificacion> calificacions = new ArrayList<>();
        if(annio!=null && mes != null){
            calificacions = findCalificacionesByNameAndFilter(name, annio, mes);
        }else{
            calificacions = this.repository.findAll().stream().filter(c->c.getIdUsuario().contains(name)).collect(Collectors.toList());
        }
        return calificacions;
    }

    private List<Calificacion> findCalificacionesByNameAndFilter(String name, Integer annio, Integer mes) throws Exception {
        Utils utils = new Utils();
        return this.repository.findAll().stream().filter(c -> c.getIdUsuario().contains(name) &&
                utils.convertToLocalDateViaInstant(c.getFechaCreacion()).getYear() == annio &&
                utils.convertToLocalDateViaInstant(c.getFechaCreacion()).getMonthValue() == mes
        ).collect(Collectors.toList());
    }

    @Override
    public List<Calificacion> findCalificacionByDate(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        List<Calificacion> calificacionList = new ArrayList<>();
        for (Calificacion calificacion:this.repository.findAll()
             ) {
            Calendar calendar = Calendar.getInstance(Locale.getDefault());
            calendar.setTimeZone(TimeZone.getTimeZone("PST"));
            calendar.setTime(calificacion.getFechaCreacion());
            if(calendar.get(Calendar.DAY_OF_MONTH) == cal.get(Calendar.DAY_OF_MONTH) && calendar.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && calendar.get(Calendar.YEAR) == cal.get(Calendar.YEAR)){
                calificacionList.add(calificacion);
            }
        }
        return calificacionList; //this.repository.findAll().stream().filter(c->c.getFechaCreacion().getDay() == cal.get(Calendar.DAY_OF_MONTH) && c.getFechaCreacion().getMonth() == cal.get(Calendar.MONTH) && c.getFechaCreacion().getYear() == cal.get(Calendar.YEAR)).collect(Collectors.toList());
    }
}
