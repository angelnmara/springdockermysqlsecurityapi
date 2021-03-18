package mx.com.aea.controller;

import mx.com.aea.model.EmpresaRol;
import mx.com.aea.repository.EmpresaRolJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmpresaRolController {
    private final EmpresaRolJpaRepository repository;

    public EmpresaRolController(EmpresaRolJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/empresa-rol")
    public void saveArea(@RequestBody EmpresaRol empresaRol){
        empresaRol.setFechaCreacion(new Date());
        repository.save(empresaRol);
    }

    @GetMapping("/empresa-rol")
    public List<EmpresaRol> getArea(){
        return repository.findAll();
    }

    @PutMapping("/empresa-rol/{id}")
    public EmpresaRol updateArea(@RequestBody EmpresaRol newEmpresaRol, @PathVariable Long id){
        return repository.findById(id).map(EmpresaRol ->{
            EmpresaRol.setIdRol(newEmpresaRol.getIdRol());
            EmpresaRol.setIdEmpresa(newEmpresaRol.getIdEmpresa());
            EmpresaRol.setFechaActualizacion(new Date());
            EmpresaRol.setUsuarioActualizacion(newEmpresaRol.getUsuarioActualizacion());
            return repository.save(EmpresaRol);
        }).orElseGet(()->{
            newEmpresaRol.setIdEmpresa(id);
            return repository.save(newEmpresaRol);
        });
    }

    @DeleteMapping("/empresa-rol/{id}")
    public void deleteArea(@PathVariable Long id){
        repository.deleteById(id);
    }

}
