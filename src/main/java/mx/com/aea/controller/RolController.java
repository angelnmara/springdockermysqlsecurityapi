package mx.com.aea.controller;

import mx.com.aea.model.Rol;
import mx.com.aea.repository.RolJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RolController {
    private final RolJpaRepository repository;

    public RolController(RolJpaRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/rol")
    public void saveRol(@RequestBody Rol rol){
        rol.setFechaCreacion(new Date());
        repository.save(rol);
    }
    @GetMapping("/rol")
    public List<Rol> getRol(){
        return repository.findAll();
    }

    @PutMapping("/rol/{id}")
    public Rol updateRol(@RequestBody Rol newRol, @PathVariable Long id){
        return repository.findById(id).map(Rol ->{
            Rol.setNombreRol(newRol.getNombreRol());
            Rol.setDescripcionRol(newRol.getDescripcionRol());
            Rol.setFechaActualizacion(new Date());
            return repository.save(Rol);
        }).orElseGet(()->{
            newRol.setIdRol(id);
            return repository.save(newRol);
        });
    }

    @DeleteMapping("/rol/{id}")
    public void deleteRol(@PathVariable Long id){
        repository.deleteById(id);
    }
}
