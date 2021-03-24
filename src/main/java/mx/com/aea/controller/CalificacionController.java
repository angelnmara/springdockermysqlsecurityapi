package mx.com.aea.controller;

import mx.com.aea.model.Calificacion;
import mx.com.aea.repository.CalificacionJpaRepository;
import mx.com.aea.repository.CalificacionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CalificacionController {
    private final CalificacionJpaRepository repository;
    private final CalificacionRepository repositoryCalificacion;

    public CalificacionController(CalificacionJpaRepository repository, CalificacionRepository repositoryCalificacion) {
        this.repository = repository;
        this.repositoryCalificacion = repositoryCalificacion;
    }


    @PostMapping("/calificacion")
    public void saveCalificacion(@RequestBody Calificacion calificacion) {
        calificacion.setFechaCreacion(new Date());
        repository.save(calificacion);
    }

    @GetMapping("/calificacion")
    public List<Calificacion> getAllCalificaciones() {
        return repository.findAll(Sort.by("fechaCreacion").descending());
    }

    @GetMapping("/calificacion-month-year")
    public List<Calificacion> getAllCalificacionesByMonthYear(
            @RequestParam(required = false) Integer mes
            , @RequestParam(required = false) Integer annio
            , @RequestParam Long idEmpresa) throws Exception {
        return repositoryCalificacion.findCalificacionByMonthYear(mes, annio, idEmpresa);
    }

    @GetMapping("/calificacion/{id}")
    public Optional<Calificacion> getCalificacionById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/calificacion-usuario")
    public List<Calificacion> getCalificacionByUsuario(@RequestParam Long idUsuario
            , @RequestParam(required = false) Integer annio
            , @RequestParam(required = false) Integer mes) throws Exception {
        return repositoryCalificacion.findCalificacionByName(idUsuario, annio, mes);
    }

    @GetMapping("/calificacion-fecha")
    public List<Calificacion> getCalificacionByDate(@RequestParam String fechaStr
            , @RequestParam Long idEmpresa ) throws ParseException {
        Date fecha=new SimpleDateFormat("yyyyMMdd").parse(fechaStr);
        return repositoryCalificacion.findCalificacionByDate(fecha, idEmpresa);
    }

    @GetMapping("/calificacion-empresa")
    public List<Calificacion> getCalificacionByEmpresa(@RequestParam Long idEmpresa) throws ParseException {
        return repositoryCalificacion.findCalificacionByEmpresa(idEmpresa);
    }
}


//@RequestMapping(value={ "/calificacion-usuario?idUsuario={idUsuario}&annio={annio}&mes={mes}", "/calificacion-usuario?idUsuario={idUsuario}" }, method=RequestMethod.GET)