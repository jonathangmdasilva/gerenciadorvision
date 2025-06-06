package model.estoque;

/*
 * @author Jonathan
 */
public class LucroProdutoModel {
    Integer idLucro;
    Double valorCompra,valorVenda,lucro,margem; 

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Integer getIdLucro() {
        return idLucro;
    }

    public void setIdLucro(Integer idLucro) {
        this.idLucro = idLucro;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    
}
