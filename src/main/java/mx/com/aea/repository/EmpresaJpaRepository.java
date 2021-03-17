package mx.com.aea.repository;

import mx.com.aea.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaJpaRepository extends JpaRepository<Empresa, Long> {
}
