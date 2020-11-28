
package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.producao.entity.ProdutoAcabadoEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.producao.repository.ProdutoAcabadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoAcabadoService implements IBaseService<ProdutoAcabadoEntity>{
    @Autowired
    private ProdutoAcabadoRepository repository;
    
    @Override
    @Transactional
    public List<ProdutoAcabadoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public ProdutoAcabadoEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public ProdutoAcabadoEntity save(ProdutoAcabadoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
