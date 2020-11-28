
package br.edu.materdei.tas.frotas.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "multas")
public class MultasEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(nullable = false)
   private Integer cod_multa;
   @Column(nullable = false)
   private Integer nro_infracao;
   @Column(nullable = false, length = 7)
   private String placa;
   @Column(nullable = false)
   private Integer id_motorista;
   @Column(nullable = false)
   private Double valor;
   @Column(nullable = false)
   private LocalDate data_multa;
   @Column(nullable = false)
   private String hora_multa;
   @Column(nullable = false, length = 40)
   private String local_multa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

   
   
    /**
     * @return the cod_multa
     */
    public Integer getCod_multa() {
        return cod_multa;
    }

    /**
     * @param cod_multa the cod_multa to set
     */
    public void setCod_multa(Integer cod_multa) {
        this.cod_multa = cod_multa;
    }

    /**
     * @return the nro_infracao
     */
    public Integer getNro_infracao() {
        return nro_infracao;
    }

    /**
     * @param nro_infracao the nro_infracao to set
     */
    public void setNro_infracao(Integer nro_infracao) {
        this.nro_infracao = nro_infracao;
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the data_multa
     */
    public LocalDate getData_multa() {
        return data_multa;
    }

    /**
     * @param data_multa the data_multa to set
     */
    public void setData_multa(LocalDate data_multa) {
        this.data_multa = data_multa;
    }

    /**
     * @return the hora_multa
     */
    public String getHora_multa() {
        return hora_multa;
    }

    /**
     * @param hora_multa the hora_multa to set
     */
    public void setHora_multa(String hora_multa) {
        this.hora_multa = hora_multa;
    }

    /**
     * @return the local_multa
     */
    public String getLocal_multa() {
        return local_multa;
    }

    /**
     * @param local_multa the local_multa to set
     */
    public void setLocal_multa(String local_multa) {
        this.local_multa = local_multa;
    }
   
}
