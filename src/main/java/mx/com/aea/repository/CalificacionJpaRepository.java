package mx.com.aea.repository;

import mx.com.aea.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionJpaRepository extends JpaRepository<Calificacion, Long> {
}
