package br.edu.materdei.tas.controller;

import br.edu.materdei.tas.compra.entity.CompraEntity;
import br.edu.materdei.tas.compra.service.CompraService;
import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.server.utils.CustomErrorResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {
    
    @Autowired
    private CompraService service;
    
    @GetMapping("compra")
    public ResponseEntity<List<CompraEntity>> findAll() {
        try{
        List<CompraEntity> compra = service.findAll();
        
        return new ResponseEntity(compra, HttpStatus.OK); 
        }catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("compra")
    public ResponseEntity create(@RequestBody CompraEntity grupo) {
        try {
            
            this.service.save(grupo);
            return new ResponseEntity(grupo, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("compra/{id}")
    public ResponseEntity findByID(@PathVariable("id")Integer id){
            try {
                CompraEntity grupo = this.service.findById(id);
                return new ResponseEntity(grupo, HttpStatus.OK);
                
                
            } catch (ResourceNotFoundException e) {
                 return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.NOT_FOUND);
                
            } catch(Exception e){
                
            }
           return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.INTERNAL_SERVER_ERROR);
            
    }
      @PutMapping("compra/{id}")
    public ResponseEntity update(@PathVariable("id")Integer id,
        @RequestBody CompraEntity grupo)   {
        
        try {
                CompraEntity found = this.service.findById(id);
                grupo.setId(found.getId());
                
                this.service.save(grupo);
                
                return new ResponseEntity(grupo, HttpStatus.OK);
                
                
            } catch (ResourceNotFoundException e) {
                 return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.NOT_FOUND);
                
            } catch(Exception e){
                
            }
           return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.INTERNAL_SERVER_ERROR);
            
    }
      @DeleteMapping("compra/{id}")
    public ResponseEntity delete (@PathVariable("id")Integer id){
            try {
                CompraEntity found = this.service.findById(id);
                
                this.service.delete(found.getId());
                
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                
                
            } catch (ResourceNotFoundException e) {
                 return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.NOT_FOUND);
                
            } catch(Exception e){
                
            }
           return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.INTERNAL_SERVER_ERROR);
            
    }
}