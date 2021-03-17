package mx.com.aea.controller;

import mx.com.aea.model.Empresa;
import mx.com.aea.repository.EmpresaJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmpresaController {
    private final EmpresaJpaRepository repository;

    public EmpresaController(EmpresaJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/empresa")
    public void saveArea(@RequestBody Empresa empresa){
        empresa.setFechaCreacion(new Date());
        repository.save(empresa);
    }

    @GetMapping("/empresa")
    public List<Empresa> getArea(){
        return repository.findAll();
    }

    @PutMapping("/empresa/{id}")
    public Empresa updateArea(@RequestBody Empresa newEmpresa, @PathVariable Long id){
        return repository.findById(id).map(Empresa ->{
            Empresa.setNombreEmpresa(newEmpresa.getNombreEmpresa());
            Empresa.setDireccionEmpresa(newEmpresa.getDireccionEmpresa());
            Empresa.setCorreoEmpresa(newEmpresa.getCorreoEmpresa());
            Empresa.setTelefonoEmpresa(newEmpresa.getTelefonoEmpresa());
            Empresa.setNumeroColaboradoresEmpresa(newEmpresa.getNumeroColaboradoresEmpresa());
            Empresa.setFechaActualizacion(new Date());
            return repository.save(Empresa);
        }).orElseGet(()->{
            newEmpresa.setIdEmpresa(id);
            return repository.save(newEmpresa);
        });
    }

    @DeleteMapping("/empresa/{id}")
    public void deleteArea(@PathVariable Long id){
        repository.deleteById(id);
    }

}
