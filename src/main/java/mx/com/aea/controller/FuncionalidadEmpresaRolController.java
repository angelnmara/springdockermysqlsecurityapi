package mx.com.aea.controller;

import mx.com.aea.model.FuncionalidadEmpresaRol;
import mx.com.aea.repository.FuncionalidadEmpresaRolJapRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FuncionalidadEmpresaRolController {
    private final FuncionalidadEmpresaRolJapRepository repository;

    public FuncionalidadEmpresaRolController(FuncionalidadEmpresaRolJapRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/funcionalidad-empresa-rol")
    public void saveRol(@RequestBody FuncionalidadEmpresaRol funcionalidadEmpresaRol){
        funcionalidadEmpresaRol.setFechaCreacion(new Date());
        repository.save(funcionalidadEmpresaRol);
    }
    @GetMapping("/funcionalidad-empresa-rol")
    public List<FuncionalidadEmpresaRol> getRol(){
        return repository.findAll();
    }

    @PutMapping("/funcionalidad-empresa-rol/{id}")
    public FuncionalidadEmpresaRol updateRol(@RequestBody FuncionalidadEmpresaRol funcionalidadEmpresaRol, @PathVariable Long id){
        return repository.findById(id).map(FuncionalidadEmpresaRol ->{
            FuncionalidadEmpresaRol.setIdRol(FuncionalidadEmpresaRol.getIdRol());
            FuncionalidadEmpresaRol.setIdEmpresa(FuncionalidadEmpresaRol.getIdEmpresa());
            FuncionalidadEmpresaRol.setIdFuncionalidad(FuncionalidadEmpresaRol.getIdFuncionalidad());
            FuncionalidadEmpresaRol.setFechaActualizacion(new Date());
            return repository.save(FuncionalidadEmpresaRol);
        }).orElseGet(()->{
            funcionalidadEmpresaRol.setIdFuncionalidadEmpresaRol(id);
            return repository.save(funcionalidadEmpresaRol);
        });
    }

    @DeleteMapping("/funcionalidad-empresa-rol/{id}")
    public void deleteRol(@PathVariable Long id){
        repository.deleteById(id);
    }
}