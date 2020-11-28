
package br.edu.materdei.tas.frotas.repository;

import br.edu.materdei.tas.frotas.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
}
