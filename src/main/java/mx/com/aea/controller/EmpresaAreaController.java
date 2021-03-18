package mx.com.aea.controller;

import mx.com.aea.model.EmpresaArea;
import mx.com.aea.repository.EmpresaAreaJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmpresaAreaController {
    private final EmpresaAreaJpaRepository repository;

    public EmpresaAreaController(EmpresaAreaJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/empresa-area")
    public void saveArea(@RequestBody EmpresaArea empresaArea){
        empresaArea.setFechaCreacion(new Date());
        repository.save(empresaArea);
    }

    @GetMapping("/empresa-area")
    public List<EmpresaArea> getArea(){
        return repository.findAll();
    }

    @PutMapping("/empresa-area/{id}")
    public EmpresaArea updateArea(@RequestBody EmpresaArea newEmpresaArea, @PathVariable Long id){
        return repository.findById(id).map(EmpresaArea ->{
            EmpresaArea.setIdArea(newEmpresaArea.getIdArea());
            EmpresaArea.setIdEmpresa(newEmpresaArea.getIdEmpresa());
            EmpresaArea.setFechaActualizacion(new Date());
            EmpresaArea.setUsuarioActualizacion(newEmpresaArea.getUsuarioActualizacion());
            return repository.save(EmpresaArea);
        }).orElseGet(()->{
            newEmpresaArea.setIdEmpresa(id);
            return repository.save(newEmpresaArea);
        });
    }

    @DeleteMapping("/empresa-area/{id}")
    public void deleteArea(@PathVariable Long id){
        repository.deleteById(id);
    }

}
