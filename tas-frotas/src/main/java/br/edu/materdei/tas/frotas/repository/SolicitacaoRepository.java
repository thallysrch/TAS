
package br.edu.materdei.tas.frotas.repository;

import br.edu.materdei.tas.frotas.entity.SolicitacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity, Integer> {
    
}
