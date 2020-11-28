
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.AbastecimentoEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.AbastecimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbastecimentoService implements IBaseService<AbastecimentoEntity>{
    
    @Autowired
    private AbastecimentoRepository repository;
    
    @Override
    @Transactional
    public List<AbastecimentoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public AbastecimentoEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public AbastecimentoEntity save(AbastecimentoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
