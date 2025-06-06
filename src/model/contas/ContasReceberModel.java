package model.contas;

/*
 * @author Jonathan
 */
public class ContasReceberModel extends ContasModel{
    String sacado;
    boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    

    public String getSacado() {
        return sacado;
    }

    public void setSacado(String sacado) {
        this.sacado = sacado;
    }
    
    
}
