
package br.edu.materdei.tas.frotas.service;

import br.edu.materdei.tas.frotas.entity.UsuarioEntity;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.frotas.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IBaseService<UsuarioEntity>{
    @Autowired
    private UsuarioRepository repository;
    
    @Override
    @Transactional
    public List<UsuarioEntity> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public UsuarioEntity findById(Integer id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public UsuarioEntity save(UsuarioEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ResourceNotFoundException {
       repository.deleteById(id);
    }
    
}
