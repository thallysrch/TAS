package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.OrdemProduEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemProduRepository extends JpaRepository<OrdemProduEntity, Integer> {
    
}
