package br.edu.materdei.tas.producao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingrediente")
public class IngredienteEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(length = 6, nullable = false)
    private Integer id;
    
    
    @Column(nullable = false)
    private Double qtdade;
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private IngredienteEntity produto;


    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQtdade() {
        return qtdade;
    }

   
    public void setQtdade(Double qtdade) {
        this.qtdade = qtdade;
    }

  
    public IngredienteEntity getProduto() {
        return produto;
    }

  
    public void setProduto(IngredienteEntity produto) {
        this.produto = produto;
    }
    
    
}