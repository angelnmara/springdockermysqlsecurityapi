
package mx.com.aea.dao;

import mx.com.aea.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
