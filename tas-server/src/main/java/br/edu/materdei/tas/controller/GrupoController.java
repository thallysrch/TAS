package br.edu.materdei.tas.controller;

import br.edu.materdei.tas.core.entity.GrupoEntity;
import br.edu.materdei.tas.core.service.GrupoService;
import br.edu.materdei.tas.server.utils.CustomErrorResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrupoController {
    
    @Autowired
    private GrupoService service;
    
    @GetMapping("grupos")
    public ResponseEntity<List<GrupoEntity>> findAll() {
        List<GrupoEntity> grupos = service.findAll();
        
        return new ResponseEntity<List<GrupoEntity>>(grupos, HttpStatus.OK);        
    }
    
    @PostMapping("grupos")
    public ResponseEntity create(@RequestBody GrupoEntity grupo){
        try{
            this.service.save(grupo);
            return new ResponseEntity(grupo, HttpStatus.CREATED);
        }   catch (Exception e){
            return new ResponseEntity("", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("grupos/{id}")
    public ResponseEntity findByID(@PathVariable("id")Integer id){
      try{
          GrupoEntity grupo = this.service.findById(id);
          return new ResponseEntity(grupo, HttpStatus.OK);
      }  catch (Exception e) {
          return new ResponseEntity(new CustomErrorResponse("Não existe um grupo com este codigo"),
           HttpStatus.INTERNAL_SERVER_ERROR);             
      }
    }
    
}