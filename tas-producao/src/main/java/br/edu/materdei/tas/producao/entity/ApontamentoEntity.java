package br.edu.materdei.tas.producao.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apontamento")
public class ApontamentoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(length = 6, nullable = false)
    private Integer id;
    
    @Column(nullable = false)
    private LocalDate dtapontamento;
    
    @Column(nullable = false)
    private Integer qtdade;
     

    public ApontamentoEntity() {
        this.dtapontamento = LocalDate.now();
    }

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
     * @return the dtapontamento
     */
    public LocalDate getDtapontamento() {
        return dtapontamento;
    }

    /**
     * @param dtapontamento the dtapontamento to set
     */
    public void setDtapontamento(LocalDate dtapontamento) {
        this.dtapontamento = dtapontamento;
    }

    /**
     * @return the qtdade
     */
    public Integer getQtdade() {
        return qtdade;
    }

    /**
     * @param qtdade the qtdade to set
     */
    public void setQtdade(Integer qtdade) {
        this.qtdade = qtdade;
    }

    
}