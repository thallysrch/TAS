
package br.edu.materdei.tas.frotas.repository;

import br.edu.materdei.tas.frotas.entity.VeiculosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<VeiculosEntity, Integer> {
    
}

