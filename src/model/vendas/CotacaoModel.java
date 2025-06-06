package model.vendas;

public class CotacaoModel {
    private Integer periodo;   
    private PedidoModel pedido;

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }    
    
    public Integer getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }     
}