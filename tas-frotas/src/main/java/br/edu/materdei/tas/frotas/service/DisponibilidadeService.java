
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.DisponibilidadeEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.DisponibilidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisponibilidadeService implements IBaseService<DisponibilidadeEntity>{
    
    @Autowired
    private DisponibilidadeRepository repository;
    
    @Override
    @Transactional
    public List<DisponibilidadeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public DisponibilidadeEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public DisponibilidadeEntity save(DisponibilidadeEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
