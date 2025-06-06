package model.contas;

/*
 * @author Jonathan
 */
public class ContasPagarModel extends ContasModel {
    String cedente;
    boolean ativo;
 

    public String getCedente() {
        return cedente;
    }

    public void setCedente(String cedente) {
        this.cedente = cedente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
