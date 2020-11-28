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
@Table(name = "produtoacabado")
public class ProdutoAcabadoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(length = 6, nullable = false)
    private Integer id;
    
    
    @Column(nullable = false)
    private Double qtdade;
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoAcabadoEntity produto;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the qtdade
     */
    public Double getQtdade() {
        return qtdade;
    }

    /**
     * @param qtdade the qtdade to set
     */
    public void setQtdade(Double qtdade) {
        this.qtdade = qtdade;
    }

    /**
     * @return the produto
     */
    public ProdutoAcabadoEntity getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoAcabadoEntity produto) {
        this.produto = produto;
    }


   
}