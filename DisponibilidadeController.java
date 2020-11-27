package br.edu.materdei.tas.server.controller;

import br.edu.materdei.tas.frotas.entity.DisponibilidadeEntity;
import br.edu.materdei.tas.frotas.service.DisponibilidadeService;
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
public class DisponibilidadeController {
    
    @Autowired
    private DisponibilidadeService service;
    
    @GetMapping("disponibilidade")
    public ResponseEntity<List<DisponibilidadeEntity>> findAll() {
        try {
            //Busca TODOS os registros no banco de dados
            List<DisponibilidadeEntity> disponibilidade = service.findAll();

            //Retorna a lista de disponibilidade
            return new ResponseEntity(disponibilidade, HttpStatus.OK);  
            
        } catch (Exception e) {
            
            //Qualquer outro erro
            return new ResponseEntity(
                    new CustomErrorResponse(e.getMessage()), 
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("disponibilidade")
    public ResponseEntity create(@RequestBody DisponibilidadeEntity veiculo) {
        try {
            //Insere o veiculo no bando de dados
            this.service.save(veiculo);
            
            //Retorna o veiculo inserido
            return new ResponseEntity(veiculo, HttpStatus.CREATED);
            
        } catch (Exception e) {
            
            //Qualquer outro erro
            return new ResponseEntity(
                    new CustomErrorResponse(e.getMessage()), 
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("disponibilidade/{id}")
    public ResponseEntity findByID(@PathVariable("id") Integer id) {
        try {
            
            //Verifica se existe um veiculo com o ID passado por parametro
            DisponibilidadeEntity veiculo = this.service.findById(id);
            
            //Retorna o veiculo com o ID do parametro
            return new ResponseEntity(veiculo, HttpStatus.OK);
            
        } catch (ResourceNotFoundException e) {
            
            //Erro de veiculo não encontrado
            return new ResponseEntity(
                    new CustomErrorResponse("Não existe um veiculo com este código"),
                    HttpStatus.NOT_FOUND);
            
        } catch (Exception e) {
                    
            //Qualquer outro erro
            return new ResponseEntity(
                    new CustomErrorResponse(e.getMessage()), 
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("disponibilidade/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, 
            @RequestBody DisponibilidadeEntity veiculo) {
        try {
            //Verifica se existe um veiculo com o ID passado por parametro
            DisponibilidadeEntity found = this.service.findById(id);
            
            //Força que o novo objeto tenha o memso ID do objeto localizado
            veiculo.setId(found.getId());
            
            //Salvara o novo objeto no banco
            this.service.save(veiculo);            
            
            //Retorna o objeto que foi atualizado
            return new ResponseEntity(veiculo, HttpStatus.OK);
            
        } catch (ResourceNotFoundException e) {
            
            //Erro de veiculo não encontrado
            return new ResponseEntity(
                    new CustomErrorResponse("Não existe um veiculo com este código"),
                    HttpStatus.NOT_FOUND);
            
        } catch (Exception e) {
                        
            //Qualquer outro erro
            return new ResponseEntity(
                    new CustomErrorResponse(e.getMessage()), 
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("disponibilidade/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            //Verifica se existe um veiculo com o ID passado por parametro
            DisponibilidadeEntity found = this.service.findById(id);
            
            
            //Exclui o item localizado
            this.service.delete(found.getId());
            
            //Como não há o que retornar, retorna-se apenas um status de "Sem Conteúdo"
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            
        } catch (ResourceNotFoundException e) {
            
            //Erro de veiculo não encontrado
            return new ResponseEntity(
                    new CustomErrorResponse("Não existe um veiculo com este código"),
                    HttpStatus.NOT_FOUND);
            
        } catch (Exception e) {
                    
            //Qualquer outro erro
            return new ResponseEntity(
                    new CustomErrorResponse(e.getMessage()), 
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
