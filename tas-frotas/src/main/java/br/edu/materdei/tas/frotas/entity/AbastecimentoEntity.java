package br.edu.materdei.tas.frotas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abastecimento")
public class AbastecimentoEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private Integer id;
    
    @Column(nullable = false) 
    private Double nota_fiscal;
    @Column(nullable = false)
    private Double litros;
    @Column(nullable = false)
    private Integer odometro;
    @Column(nullable = false)
    private Double valor_litros;
    @Column(nullable = false, length = 80)
    private String nome_posto;
    @Column(nullable = false, length = 7)
    private String placa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nota_fiscal
     */
    public Double getNota_fiscal() {
        return nota_fiscal;
    }

    /**
     * @param nota_fiscal the nota_fiscal to set
     */
    public void setNota_fiscal(Double nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

    /**
     * @return the litros
     */
    public Double getLitros() {
        return litros;
    }

    /**
     * @param litros the litros to set
     */
    public void setLitros(Double litros) {
        this.litros = litros;
    }

    /**
     * @return the odometro
     */
    public Integer getOdometro() {
        return odometro;
    }

    /**
     * @param odometro the odometro to set
     */
    public void setOdometro(Integer odometro) {
        this.odometro = odometro;
    }

    /**
     * @return the valor_litros
     */
    public Double getValor_litros() {
        return valor_litros;
    }

    /**
     * @param valor_litros the valor_litros to set
     */
    public void setValor_litros(Double valor_litros) {
        this.valor_litros = valor_litros;
    }

    /**
     * @return the nome_posto
     */
    public String getNome_posto() {
        return nome_posto;
    }

    /**
     * @param nome_posto the nome_posto to set
     */
    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
