package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.ApontamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApontamentoRepository extends JpaRepository<ApontamentoEntity, Integer> {
    
}
