
package br.edu.materdei.tas.frotas.entity;

import br.edu.materdei.tas.core.converter.BooleanConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilidade")
public class DisponibilidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @Convert(converter = BooleanConverter.class)
    @Column(columnDefinition = "char(1) default 'S'")
    private Boolean disponivel;
    
    @Column(nullable = false, length = 150)
    private String obs;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return disponivel sim
     */
    public Boolean getDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the sim to set
     */
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
