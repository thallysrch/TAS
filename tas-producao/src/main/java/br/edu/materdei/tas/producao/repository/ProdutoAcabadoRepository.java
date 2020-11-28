package br.edu.materdei.tas.producao.repository;

import br.edu.materdei.tas.producao.entity.ProdutoAcabadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoAcabadoRepository extends JpaRepository<ProdutoAcabadoEntity, Integer> {
    
}
