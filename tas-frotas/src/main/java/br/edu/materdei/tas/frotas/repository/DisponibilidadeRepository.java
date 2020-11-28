
package br.edu.materdei.tas.frotas.repository;

import br.edu.materdei.tas.frotas.entity.DisponibilidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadeEntity, Integer> {
    
}
