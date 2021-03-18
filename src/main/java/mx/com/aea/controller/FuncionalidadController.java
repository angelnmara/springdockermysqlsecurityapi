package mx.com.aea.controller;

import mx.com.aea.model.Funcionalidad;
import mx.com.aea.repository.FuncionalidadJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FuncionalidadController {
    private final FuncionalidadJpaRepository repository;

    public FuncionalidadController(FuncionalidadJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/funcionalidad")
    public void saveRol(@RequestBody Funcionalidad funcionalidad){
        funcionalidad.setFechaCreacion(new Date());
        repository.save(funcionalidad);
    }

    @GetMapping("/funcionalidad")
    public List<Funcionalidad> getRol(){
        return repository.findAll();
    }

    @PutMapping("/funcionalidad/{id}")
    public Funcionalidad updateRol(@RequestBody Funcionalidad newFuncionalidad, @PathVariable Long id){
        return repository.findById(id).map(funcionalidad ->{
            funcionalidad.setDescripcionFuncionalidad(newFuncionalidad.getDescripcionFuncionalidad());
            funcionalidad.setNombreFuncionalidad(newFuncionalidad.getNombreFuncionalidad());
            funcionalidad.setIdPlataforma(newFuncionalidad.getIdPlataforma());
            funcionalidad.setFechaActualizacion(new Date());
            return repository.save(funcionalidad);
        }).orElseGet(()->{
            newFuncionalidad.setIdFuncionalidad(id);
            return repository.save(newFuncionalidad);
        });
    }

    @DeleteMapping("/funcionalidad/{id}")
    public void deleteRol(@PathVariable Long id){
        repository.deleteById(id);
    }

}
