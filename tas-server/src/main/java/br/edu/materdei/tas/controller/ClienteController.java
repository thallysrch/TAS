package br.edu.materdei.tas.controller;



import br.edu.materdei.tas.core.exception.ResourceNotFoundException;
import br.edu.materdei.tas.utils.CustomErrorResponse;
import br.edu.materdei.tas.venda.entity.ClienteEntity;
import br.edu.materdei.tas.venda.service.ClienteService;
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
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("cliente")
    public ResponseEntity<List<ClienteEntity>> findAll() {
        try{
        List<ClienteEntity> cliente = service.findAll();
        
        return new ResponseEntity(cliente, HttpStatus.OK); 
        }catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("cliente")
    public ResponseEntity create(@RequestBody ClienteEntity grupo) {
        try {
            
            this.service.save(grupo);
            return new ResponseEntity(grupo, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity(new CustomErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("cliente/{id}")
    public ResponseEntity findByID(@PathVariable("id")Integer id){
            try {
                ClienteEntity grupo = this.service.findById(id);
                return new ResponseEntity(grupo, HttpStatus.OK);
                
                
            } catch (ResourceNotFoundException e) {
                 return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.NOT_FOUND);
                
            } catch(Exception e){
                
            }
           return new ResponseEntity(new CustomErrorResponse("Não existe grupo com este codigo"),
                         HttpStatus.INTERNAL_SERVER_ERROR);
            
    }
      @PutMapping("cliente/{id}")
    public ResponseEntity update(@PathVariable("id")Integer id,
        @RequestBody ClienteEntity grupo)   {
        
        try {
                ClienteEntity found = this.service.findById(id);
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
      @DeleteMapping("cliente/{id}")
    public ResponseEntity delete (@PathVariable("id")Integer id){
            try {
                ClienteEntity found = this.service.findById(id);
                
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