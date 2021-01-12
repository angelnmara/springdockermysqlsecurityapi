package mx.com.aea.dao;

import mx.com.aea.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface CalificacionDao extends CrudRepository<Usuario, Long> {
}
