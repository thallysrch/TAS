
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.SolicitacaoEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.SolicitacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitacaoService implements IBaseService<SolicitacaoEntity>{
    @Autowired
    private SolicitacaoRepository repository;
    
    @Override
    @Transactional
    public List<SolicitacaoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public SolicitacaoEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public SolicitacaoEntity save(SolicitacaoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
