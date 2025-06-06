package controller.vendas;

import dao.estoque.EstoqueEntradaDao;
import dao.estoque.EstoqueSaidaDao;
import dao.estoque.EstoqueSaldoDao;
import dao.vendas.CotacaoDao;
import dao.vendas.FormaPagamentoDao;
import dao.vendas.ItemCotacaoDao;
import dao.vendas.ItemPedidoDao;
import dao.vendas.PedidoDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.estoque.EstoqueModel;
import model.estoque.ProdutoModel;
import model.vendas.CotacaoModel;
import model.vendas.FormaPagamentoModel;
import model.vendas.ItemPedidoModel;
import model.vendas.PedidoModel;

/*
 * @author Jonathan
 */

public class PedidoController {
    
    public void inserirPedido(PedidoModel pedido,List<ItemPedidoModel> listaItemPedido) throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        EstoqueSaidaDao saida = new EstoqueSaidaDao();
        EstoqueSaldoDao es = new EstoqueSaldoDao();
        pedidoDao.inserirCadastro(pedido);                
        int idPedido = pedidoDao.listarTotalPedido();        
        ProdutoModel produto = new ProdutoModel();        
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
        
        for(int x =0;x<listaItemPedido.size();x++){
            //INSERIR OS ITENS DA TABELA ASSOCIATIVA
            listaItemPedido.get(x).setIdPedido(idPedido);
            itemPedidoModel = listaItemPedido.get(x);
            itemPedidoDao.inserirCadastro(itemPedidoModel);
            //EFETUAR BAIXA NO ESTOQUE
            EstoqueModel estoque = new EstoqueModel();
            estoque.setIdProduto(listaItemPedido.get(x).getIdProduto());
            estoque.setQtd(listaItemPedido.get(x).getQtd());            
            estoque.setData(pedido.getDataHora());            
            saida.inserirCadastro(estoque);                                    
            
            produto.setIdProduto(estoque.getIdProduto());
            produto.setSaldo(es.saldoProduto(estoque.getIdProduto()) - estoque.getQtd());
            es.atualizarSaldo(produto);
        }   
    }
    
    public List<FormaPagamentoModel> listarFormasPagamento() throws SQLException, ClassNotFoundException{
        FormaPagamentoDao pagamentoDao = new FormaPagamentoDao();
        return pagamentoDao.listarFormasPagamento();
    }
    
    public List<PedidoModel> listarTodosPedidos() throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        return pedidoDao.listarTodosPedidos();
    }
    
    public List<PedidoModel> listarPedidosPeriodo(Date i, Date f) throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        return pedidoDao.listarPedidosPeriodo(i, f);
    }
    
    public List<PedidoModel> listarPedidosCliente(String razao) throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        return pedidoDao.listarPedidosCLiente(razao);
    }
    
    public List<PedidoModel> listarPedidosCodigo(int codigo) throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        return pedidoDao.listarPedidosCodigo(codigo);
    }
    
    public void cancelarPedido(PedidoModel pedido) throws SQLException, ClassNotFoundException{
        PedidoDao pedidoDao = new PedidoDao();
        pedidoDao.cancelarPedido(pedido.getCodigoPedido());
    
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        EstoqueSaldoDao es = new EstoqueSaldoDao();
        EstoqueEntradaDao entrada = new EstoqueEntradaDao();
        
        List<ItemPedidoModel> listaItemPedido = new ArrayList<>();        
        listaItemPedido = itemPedidoDao.listarItensRetornoPedido(pedido.getCodigoPedido());
        ProdutoModel produto = new ProdutoModel();        
    
        for(int x =0;x<listaItemPedido.size();x++){
            ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
            produto.setSaldo(0.0);
            
            listaItemPedido.get(x).setIdPedido(pedido.getCodigoPedido());
            itemPedidoModel = listaItemPedido.get(x);
            itemPedidoDao.inserirCadastro(itemPedidoModel);
            //EFETUAR ENTRADA NO ESTOQUE
            EstoqueModel estoque = new EstoqueModel();
            estoque.setIdProduto(listaItemPedido.get(x).getIdProduto());
            estoque.setQtd(listaItemPedido.get(x).getQtd());                        
            //estoque.setData(pedido.getDataHora());                        
            produto.setIdProduto(estoque.getIdProduto());
            produto.setSaldo(es.saldoProduto(estoque.getIdProduto()) + estoque.getQtd());           
            es.atualizarSaldo(produto);
            
            entrada.inserirCadastro(estoque);
            estoque.setIdProduto(0);
            estoque.setQtd(0.0);
            System.out.println("SALDO: "+produto.getSaldo());
        }                   
    }    
    
    
    public List<ItemPedidoModel> listarItensPedido(int codigo) throws SQLException, ClassNotFoundException{
        ItemPedidoDao itemPedidoDao = new ItemPedidoDao();
        return itemPedidoDao.listarItensPedido(codigo);
    }
    
    public List<ItemPedidoModel> listarItensCotacao(int codigo) throws SQLException, ClassNotFoundException{
        ItemCotacaoDao itemCotacaoDao = new ItemCotacaoDao();
        return itemCotacaoDao.listarItensCotacao(codigo);
    }    
    
    public void inserirCotacao(CotacaoModel cotacao,List<ItemPedidoModel> listaItemPedido) throws SQLException, ClassNotFoundException{
        CotacaoDao cotacaoDao = new CotacaoDao();
        ItemCotacaoDao itemCotacaoDao = new ItemCotacaoDao();
        cotacaoDao.inserirCadastro(cotacao);        
        int idCotacao = cotacaoDao.listarTotalCotacao();
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
        
        for(int x =0;x<listaItemPedido.size();x++){
            //INSERIR OS ITENS DA TABELA ASSOCIATIVA
            listaItemPedido.get(x).setIdPedido(idCotacao);
            itemPedidoModel = listaItemPedido.get(x);
            itemCotacaoDao.inserirCadastro(itemPedidoModel);                        
        }   
    }        

    public CotacaoModel listarCotacaoCodigo(int codigo) throws SQLException, ClassNotFoundException{
        CotacaoDao cotacaoDao = new CotacaoDao();
        return cotacaoDao.listarCotacaoCodigo(codigo);
    }  
    
    public void invalidarCotacao(int cod) throws SQLException, ClassNotFoundException{
        CotacaoDao cotacaoDao = new CotacaoDao();
        cotacaoDao.invalidarCotacao(cod);
    }
    
}
