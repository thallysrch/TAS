package br.edu.materdei.tas.producao.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordemproducao")
public class OrdemProduEntity {
   @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(length = 6, nullable = false)
    private Integer id;
    
    @Column(nullable = false)
    private LocalDate dtabertura;
    
    @Column(nullable = false)
    private LocalDate dtfinalizado;
    
     @Column(length = 50, nullable = false)
    private String produtoacabado;
    
    @Column(nullable = false)
    private Integer qtdade;
     

    public OrdemProduEntity() {
        this.dtabertura = LocalDate.now();
    }

    
}