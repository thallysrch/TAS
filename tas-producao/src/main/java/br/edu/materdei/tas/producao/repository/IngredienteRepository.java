package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.IngredienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<IngredienteEntity, Integer> {
    
}
