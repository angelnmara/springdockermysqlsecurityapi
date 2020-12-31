package mx.com.aea.controller;

import mx.com.aea.domain.Calificacion;
import mx.com.aea.repository.CalificacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CalificacionController {
    private final CalificacionRepository repository;

    public CalificacionController(CalificacionRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/calificacion/")
    public void saveCalificacion(@RequestBody Calificacion calificacion) {
        repository.save(calificacion);
    }

    @GetMapping("/calificacion/")
    public List<Calificacion> getAllCalificaciones() {
        return repository.findAll();
    }

    @GetMapping("/calificacion/{id}")
    public Optional<Calificacion> getCalificacion(@PathVariable Long id) {
        return repository.findById(id);
    }

}
