
package br.edu.materdei.tas.frotas.repository;

import br.edu.materdei.tas.frotas.entity.AbastecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository extends JpaRepository<AbastecimentoEntity, Integer> {
    
}
