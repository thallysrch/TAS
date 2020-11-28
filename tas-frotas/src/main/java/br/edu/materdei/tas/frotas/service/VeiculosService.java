
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.VeiculosEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.VeiculosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VeiculosService implements IBaseService<VeiculosEntity>{
    @Autowired
    private VeiculosRepository repository;
    
    @Override
    @Transactional
    public List<VeiculosEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public VeiculosEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public VeiculosEntity save(VeiculosEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
