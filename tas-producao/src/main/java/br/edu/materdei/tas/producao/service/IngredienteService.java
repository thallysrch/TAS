
package br.edu.materdei.tas.producao.service;

import br.edu.materdei.tas.producao.entity.IngredienteEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.producao.repository.IngredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredienteService implements IBaseService<IngredienteEntity>{
    @Autowired
    private IngredienteRepository repository;
    
    @Override
    @Transactional
    public List<IngredienteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public IngredienteEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public IngredienteEntity save(IngredienteEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
