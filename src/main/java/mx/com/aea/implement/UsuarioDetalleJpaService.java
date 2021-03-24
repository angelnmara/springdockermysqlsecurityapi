package mx.com.aea.implement;

import mx.com.aea.model.Usuario;
import mx.com.aea.model.UsuarioDetalle;
import mx.com.aea.repository.UsuarioDetalleJpaRepository;
import mx.com.aea.repository.UsuarioDetalleRepository;
import mx.com.aea.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDetalleJpaService implements UsuarioDetalleRepository {

    private final UsuarioDetalleJpaRepository usuarioDetalleJpaRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetalleJpaService(UsuarioDetalleJpaRepository usuarioDetalleJpaRepository, UsuarioRepository usuarioRepository) {
        this.usuarioDetalleJpaRepository = usuarioDetalleJpaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<UsuarioDetalle> findUserDetailByUserName(String userName) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findAll().stream().filter(c->c.getUsername().equals(userName)).findFirst();
        Usuario usuario = optionalUsuario.get();
        return usuarioDetalleJpaRepository.findAll().stream().filter(v->v.getIdUsuario()==usuario.getId()).findFirst();
    }
}
