package mx.com.aea.controller;

import mx.com.aea.model.UsuarioDetalle;
import mx.com.aea.repository.UsuarioDetalleJpaRepository;
import mx.com.aea.repository.UsuarioDetalleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioDetalleController {
    private final UsuarioDetalleJpaRepository usuarioDetalleJpaRepository;
    private final UsuarioDetalleRepository usuarioDetalleRepository;

    public UsuarioDetalleController(UsuarioDetalleJpaRepository usuarioDetalleJpaRepository, UsuarioDetalleRepository usuarioDetalleRepository) {
        this.usuarioDetalleJpaRepository = usuarioDetalleJpaRepository;
        this.usuarioDetalleRepository = usuarioDetalleRepository;
    }

    @PostMapping("/usuario-detalle")
    public void saveRol(@RequestBody UsuarioDetalle usuarioDetalle){
        usuarioDetalle.setFechaCreacion(new Date());
        usuarioDetalleJpaRepository.save(usuarioDetalle);
    }

    @GetMapping("/usuario-detalle")
    public List<UsuarioDetalle> getRol(){
        return usuarioDetalleJpaRepository.findAll();
    }

    @GetMapping("/usuario-detalle-by-user-name/{userName}")
    public Optional<UsuarioDetalle> getUsuarioDetallebyUserName(@PathVariable String userName){
        return usuarioDetalleRepository.findUserDetailByUserName(userName);
    }

    @PutMapping("/usuario-detalle/{id}")
    public UsuarioDetalle updateRol(@RequestBody UsuarioDetalle usuarioDetalle, @PathVariable Long id){
        return usuarioDetalleJpaRepository.findById(id).map(UsuarioDetalle ->{
            UsuarioDetalle.setIdUsuario(usuarioDetalle.getIdUsuario());
            UsuarioDetalle.setIdEmpresa(usuarioDetalle.getIdEmpresa());
            UsuarioDetalle.setIdArea(usuarioDetalle.getIdArea());
            UsuarioDetalle.setIdRol(usuarioDetalle.getIdRol());
            UsuarioDetalle.setFechaActualizacion(new Date());
            return usuarioDetalleJpaRepository.save(UsuarioDetalle);
        }).orElseGet(()->{
            usuarioDetalle.setIdRol(id);
            return usuarioDetalleJpaRepository.save(usuarioDetalle);
        });
    }

    @DeleteMapping("/usuario-detalle/{id}")
    public void deleteRol(@PathVariable Long id){
        usuarioDetalleJpaRepository.deleteById(id);
    }
}
