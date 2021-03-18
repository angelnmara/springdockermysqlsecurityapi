package mx.com.aea.controller;

import mx.com.aea.model.UsuarioDetalle;
import mx.com.aea.repository.UsuarioDetalleJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UsuarioDetalleController {
    private final UsuarioDetalleJpaRepository repository;

    public UsuarioDetalleController(UsuarioDetalleJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/usuario-detalle")
    public void saveRol(@RequestBody UsuarioDetalle usuarioDetalle){
        usuarioDetalle.setFechaCreacion(new Date());
        repository.save(usuarioDetalle);
    }

    @GetMapping("/usuario-detalle")
    public List<UsuarioDetalle> getRol(){
        return repository.findAll();
    }

    @PutMapping("/usuario-detalle/{id}")
    public UsuarioDetalle updateRol(@RequestBody UsuarioDetalle usuarioDetalle, @PathVariable Long id){
        return repository.findById(id).map(UsuarioDetalle ->{
            UsuarioDetalle.setIdUsuario(usuarioDetalle.getIdUsuario());
            UsuarioDetalle.setIdEmpresa(usuarioDetalle.getIdEmpresa());
            UsuarioDetalle.setIdArea(usuarioDetalle.getIdArea());
            UsuarioDetalle.setIdRol(usuarioDetalle.getIdRol());
            UsuarioDetalle.setFechaActualizacion(new Date());
            return repository.save(UsuarioDetalle);
        }).orElseGet(()->{
            usuarioDetalle.setIdRol(id);
            return repository.save(usuarioDetalle);
        });
    }

    @DeleteMapping("/usuario-detalle/{id}")
    public void deleteRol(@PathVariable Long id){
        repository.deleteById(id);
    }
}
