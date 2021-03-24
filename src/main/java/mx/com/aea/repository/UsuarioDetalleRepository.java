package mx.com.aea.repository;

import mx.com.aea.model.Usuario;
import mx.com.aea.model.UsuarioDetalle;

import java.util.Optional;

public interface UsuarioDetalleRepository {
    Optional<UsuarioDetalle> findUserDetailByUserName(String userName);
}
