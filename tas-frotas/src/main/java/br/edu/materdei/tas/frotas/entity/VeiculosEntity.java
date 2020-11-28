package br.edu.materdei.tas.frotas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class VeiculosEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(nullable = false)
   private Integer cod_veiculo;
   @Column(nullable = false)
   private Integer km_veiculo;
   @Column(nullable = false, length = 7)
   private String placa;
   @Column(nullable = false, length = 17)
   private String chassi;
   @Column(nullable = false, length = 11)
   private String renavam;
   @Column(nullable = false, length = 40)
   private String marca;   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
   
    /**
     * @return the cod_veiculo
     */
    public Integer getCod_veiculo() {
        return cod_veiculo;
    }

    /**
     * @param cod_veiculo the cod_veiculo to set
     */
    public void setCod_veiculo(Integer cod_veiculo) {
        this.cod_veiculo = cod_veiculo;
    }

    /**
     * @return the km_veiculo
     */
    public Integer getKm_veiculo() {
        return km_veiculo;
    }

    /**
     * @param km_veiculo the km_veiculo to set
     */
    public void setKm_veiculo(Integer km_veiculo) {
        this.km_veiculo = km_veiculo;
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

    /**
     * @return the chassi
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * @param chassi the chassi to set
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * @return the renavam
     */
    public String getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
