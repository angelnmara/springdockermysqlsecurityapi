package mx.com.aea.controller;

import mx.com.aea.model.Calificacion;
import mx.com.aea.repository.CalificacionJpaRepository;
import mx.com.aea.repository.CalificacionRepository;
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


    @PostMapping("/calificacion/")
    public void saveCalificacion(@RequestBody Calificacion calificacion) {
        calificacion.setFechaCreacion(new Date());
        repository.save(calificacion);
    }

    @GetMapping("/calificacion/")
    public List<Calificacion> getAllCalificaciones() {
        return repository.findAll();
    }

    @GetMapping("/calificacion/{id}")
    public Optional<Calificacion> getCalificacionById(@PathVariable Long id) {
        return repository.findById(id);
    }

    //@GetMapping("/calificacion-usuario/{idUsuario}/{annio}/{mes}")
    @RequestMapping(value={ "/calificacion-usuario/{idUsuario}/{annio}/{mes}", "/calificacion-usuario/{idUsuario}" }, method=RequestMethod.GET)
    public List<Calificacion> getCalificacionByUsuario(@PathVariable String idUsuario
            , @PathVariable(required = false) Integer annio
            , @PathVariable(required = false) Integer mes) throws Exception {
        return repositoryCalificacion.findCalificacionByName(idUsuario, annio, mes);
    }

    @GetMapping("/calificacion-fecha/{fechaStr}")
    public List<Calificacion> getCalificacionByDate(@PathVariable String fechaStr ) throws ParseException {
        Date fecha=new SimpleDateFormat("yyyyMMdd").parse(fechaStr);
        return repositoryCalificacion.findCalificacionByDate(fecha);
    }
}
