
package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.producao.entity.OrdemProduEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.producao.repository.OrdemProduRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdemProduService implements IBaseService<OrdemProduEntity>{
    @Autowired
    private OrdemProduRepository repository;
    
    @Override
    @Transactional
    public List<OrdemProduEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public OrdemProduEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public OrdemProduEntity save(OrdemProduEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
