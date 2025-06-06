package model.estoque;

/*
 * @author Jonathan
 */

public class InventarioModel {
    ProdutoModel produto;
    double saldo;

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }  
}
