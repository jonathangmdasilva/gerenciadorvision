package model.administrativo;

import java.util.Date;

/*
 * @author Jonathan
 */
public class LembreteModel {
    Integer idLembrete;
    boolean ativo;
    Date data;
    String descricao;

    
    public Integer getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(Integer idLembrete) {
        this.idLembrete = idLembrete;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
     
    
}
