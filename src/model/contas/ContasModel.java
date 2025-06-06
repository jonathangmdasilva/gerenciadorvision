package model.contas;

//import java.sql.Date;

import java.util.Date;


/*
 * @author Jonathan
 */
public class ContasModel {
    //DEFINIÇÃO DAS VARIAVEIS
    Integer idConta,ativa;
    String numeroConta,observacaoConta,tipo,status;
    Double valorConta;
    Date emissaoConta,vencimentoConta;
    
    //Date emissaoConta,vencimentoConta;

    
    //MÉTODOS DE ACESSO
    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getObservacaoConta() {
        return observacaoConta;
    }

    public void setObservacaoConta(String observacaoConta) {
        this.observacaoConta = observacaoConta;
    }

    public Double getValorConta() {
        return valorConta;
    }

    public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    

    public Integer getAtiva() {
        return ativa;
    }

    public void setAtiva(Integer ativa) {
        this.ativa = ativa;
    }

    public Date getEmissaoConta() {
        return emissaoConta;
    }

    public void setEmissaoConta(Date emissaoConta) {
        this.emissaoConta = emissaoConta;
    }

    public Date getVencimentoConta() {
        return vencimentoConta;
    }

    public void setVencimentoConta(Date vencimentoConta) {
        this.vencimentoConta = vencimentoConta;
    }

    
    
}
