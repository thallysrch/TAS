
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.MultasEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.MultasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultasService implements IBaseService<MultasEntity>{
    @Autowired
    private MultasRepository repository;
    
    @Override
    @Transactional
    public List<MultasEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public MultasEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public MultasEntity save(MultasEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
