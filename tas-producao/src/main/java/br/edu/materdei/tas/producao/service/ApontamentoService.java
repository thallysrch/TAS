
package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.producao.entity.ApontamentoEntity;
import br.edu.materdei.tas.producao.repository.ApontamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApontamentoService implements IBaseService<ApontamentoEntity>{
    
    @Autowired
    private ApontamentoRepository repository;    
   
    @Transactional
    @Override
    public List<ApontamentoEntity> findAll() {
        return repository.findAll();
    }

    
    @Transactional
    @Override
    public ApontamentoEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

   
    @Transactional
    @Override
    public ApontamentoEntity save(ApontamentoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    
    @Transactional
    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
