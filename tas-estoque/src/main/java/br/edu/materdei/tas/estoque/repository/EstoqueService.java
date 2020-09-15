package br.edu.materdei.tas.estoque.repository;

import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.estoque.entity.EstoqueEntity;
import br.edu.materdei.tas.estoque.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService implements IBaseService<EstoqueEntity> {

    @Autowired
    private EstoqueRepository repository;
    
    @Override
    public List<EstoqueEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public EstoqueEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow( 
                ()-> new ResourceNotFoundException(id));
    }

    @Override
    public EstoqueEntity save(EstoqueEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        repository.deleteById(id);
    }
    
}