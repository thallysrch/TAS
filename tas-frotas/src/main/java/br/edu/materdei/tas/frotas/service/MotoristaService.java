
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.MotoristaEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.MotoristaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotoristaService implements IBaseService<MotoristaEntity>{
    @Autowired
    private MotoristaRepository repository;
    
    @Override
    @Transactional
    public List<MotoristaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public MotoristaEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public MotoristaEntity save(MotoristaEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
