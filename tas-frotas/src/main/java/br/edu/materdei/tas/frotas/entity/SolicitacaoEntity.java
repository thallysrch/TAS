
package br.edu.materdei.tas.frotas.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacao")
public class SolicitacaoEntity {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer cod_solicitacao;
    @Column(nullable = false)
    private LocalDate data_solicitacao;
    @Column(nullable = false, length = 40)
    private String destino_solicitacao;
    @Column(nullable = false, length = 10)
    private String hora_solicitacao;
    @Column(nullable = false)
    private Integer cod_cliente;
    @Column(nullable = false)
    private Integer km_inicial;
    @Column(nullable = false)
    private Integer km_final;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    /**
     * @return the cod_solicitacao
     */
    public Integer getCod_solicitacao() {
        return cod_solicitacao;
    }

    /**
     * @param cod_solicitacao the cod_solicitacao to set
     */
    public void setCod_solicitacao(Integer cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
    }

    /**
     * @return the data_solicitacao
     */
    public LocalDate getData_solicitacao() {
        return data_solicitacao;
    }

    /**
     * @param data_solicitacao the data_solicitacao to set
     */
    public void setData_solicitacao(LocalDate data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    /**
     * @return the destino_solicitacao
     */
    public String getDestino_solicitacao() {
        return destino_solicitacao;
    }

    /**
     * @param destino_solicitacao the destino_solicitacao to set
     */
    public void setDestino_solicitacao(String destino_solicitacao) {
        this.destino_solicitacao = destino_solicitacao;
    }

    /**
     * @return the hora_solicitacao
     */
    public String getHora_solicitacao() {
        return hora_solicitacao;
    }

    /**
     * @param hora_solicitacao the hora_solicitacao to set
     */
    public void setHora_solicitacao(String hora_solicitacao) {
        this.hora_solicitacao = hora_solicitacao;
    }

    /**
     * @return the cod_cliente
     */
    public Integer getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the km_inicial
     */
    public Integer getKm_inicial() {
        return km_inicial;
    }

    /**
     * @param km_inicial the km_inicial to set
     */
    public void setKm_inicial(Integer km_inicial) {
        this.km_inicial = km_inicial;
    }

    /**
     * @return the km_final
     */
    public Integer getKm_final() {
        return km_final;
    }

    /**
     * @param km_final the km_final to set
     */
    public void setKm_final(Integer km_final) {
        this.km_final = km_final;
    }
    
}
