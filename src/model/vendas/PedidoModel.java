package model.vendas;

import java.util.Date;
import model.administrativo.ClienteModel;
import model.administrativo.UsuarioModel;

public class PedidoModel {
    private Integer codigoPedido;   
    private Date dataHora;
    private Double subTotal, total,desconto,pedidoComDesconto; 
    private String status,observacao;

    public Double getPedidoComDesconto() {
        return pedidoComDesconto;
    }

    public void setPedidoComDesconto(Double pedidoComDesconto) {
        this.pedidoComDesconto = pedidoComDesconto;
    }
    
    private boolean ativo;
    
    private ClienteModel cliente;
    private UsuarioModel usuario;
    private FormaPagamentoModel pagamento;

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }          

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }   

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }       

    public FormaPagamentoModel getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamentoModel pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
   
}