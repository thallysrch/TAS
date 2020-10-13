package br.edu.materdei.tas.controller;

import br.edu.materdei.tas.compra.entity.FornecedorEntity;
import br.edu.materdei.tas.compra.service.FornecedorService;
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
public class FornecedorController {
    
    @Autowired
    private FornecedorService service;
    
    @GetMapping("fornecedores")
    public ResponseEntity<List<FornecedorEntity>> findAll() {
        try{
        List<FornecedorEntity> fornecedores = service.findAll();
        
        return new ResponseEntity(fornecedores, HttpStatus.OK); 
        }catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("fornecedores")
    public ResponseEntity create(@RequestBody FornecedorEntity grupo) {
        try {
            
            this.service.save(grupo);
            return new ResponseEntity(grupo, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("fornecedores/{id}")
    public ResponseEntity findByID(@PathVariable("id")Integer id){
            try {
                FornecedorEntity grupo = this.service.findById(id);
                return new ResponseEntity(grupo, HttpStatus.OK);
                
                
            } catch (ResourceNotFoundException e) {
                 return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.NOT_FOUND);
                
            } catch(Exception e){
                
            }
           return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.INTERNAL_SERVER_ERROR);
            
    }
      @PutMapping("fornecedores/{id}")
    public ResponseEntity update(@PathVariable("id")Integer id,
        @RequestBody FornecedorEntity grupo)   {
        
        try {
                FornecedorEntity found = this.service.findById(id);
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
      @DeleteMapping("fornecedores/{id}")
    public ResponseEntity delete (@PathVariable("id")Integer id){
            try {
                FornecedorEntity found = this.service.findById(id);
                
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