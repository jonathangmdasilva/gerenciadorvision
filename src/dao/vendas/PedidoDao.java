package dao.vendas;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.administrativo.ClienteModel;
import model.administrativo.UsuarioModel;
import model.vendas.FormaPagamentoModel;
import model.vendas.PedidoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class PedidoDao {

    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public PedidoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(PedidoModel pedido) throws SQLException {        
        String sql = "INSERT INTO TB_PEDIDO (Id_func,Id_Cliente,Data_Hora_Pedido,Sub_Total_Pedido,Total_Pedido,Status_Pedido,Desconto_Pedido,Id_Forma_Pagamento,Obs_Pedido)VALUES(?,?,NOW(),?,?,?,?,?,?)";        
        // seta os valores
        try ( 
            //prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,pedido.getUsuario().getIdUsuario());
            stmt.setInt(2,pedido.getCliente().getIdCliente());
            stmt.setDouble(3,pedido.getSubTotal());
            stmt.setDouble(4,pedido.getTotal());            
            stmt.setString(5,pedido.getStatus());                 
            stmt.setDouble(6,pedido.getDesconto());                 
            stmt.setInt(7,pedido.getPagamento().getIdFormaPagamento());                 
            stmt.setString(8,pedido.getObservacao());  
            // executa
            stmt.execute();
            stmt.close();
        }
    }
    
    
    public int listarTotalPedido() throws SQLException {           
        String sql = "SELECT MAX(Id_Pedido) FROM TB_PEDIDO;";                       
        int codigo = 0;        
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {        
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                codigo = rs.getInt(1);                                
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO AO LISTAR CÓDIGO PEDIDO");
            System.out.println(e.getMessage());
        }finally{
            return codigo;        
        }                    
    }

    public List<PedidoModel> listarTodosPedidos() throws SQLException {   
        List<PedidoModel> pedidos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Pedido, T2.Nome_Cliente, T1.Sub_Total_Pedido, T1.Total_Pedido,T1.Desconto_Pedido,T4.Taxa_Desc,T1.Obs_Pedido,T4.Descricao_Forma_Pagamento,T1.Data_Hora_Pedido, T1.Status_Pedido,T3.Nome_Func FROM TB_PEDIDO T1, TB_CLIENTE T2, TB_FUNCIONARIO T3, TB_FORMA_PAGAMENTO T4 WHERE T2.Id_Cliente = T1.Id_Cliente AND T1.Id_Func= T3.Id_func AND T4.Id_Forma_Pagamento = t1.Id_Forma_Pagamento;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                PedidoModel pedido = new PedidoModel();
                ClienteModel cliente = new ClienteModel();
                UsuarioModel usuario = new UsuarioModel();
                FormaPagamentoModel pagamento = new FormaPagamentoModel();
                
                pedido.setCodigoPedido(rs.getInt(1));                
                cliente.setNome(rs.getString(2));                
                pedido.setSubTotal(rs.getDouble(3));
                pedido.setTotal(rs.getDouble(4));
                pedido.setDesconto(rs.getDouble(5));
                pagamento.setTaxaDesconto(rs.getDouble(6));                
                
                pedido.setObservacao(rs.getString(7));                
                pagamento.setDescricao(rs.getString(8));                
                pedido.setDataHora(rs.getDate(9));
                pedido.setStatus(rs.getString(10));                
                usuario.setNome(rs.getString(11));
                //SETANDO OS OBJETOS EM PEDIDO
                pedido.setCliente(cliente);
                pedido.setUsuario(usuario);
                pedido.setPagamento(pagamento);
                //ADICIONANDO MODELO DE PEDIDO NA LISTA
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
        }                
        return pedidos;        
    }

    public List<PedidoModel> listarPedidosCodigo(int codigo) throws SQLException {   
        List<PedidoModel> pedidos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Pedido, T2.Nome_Cliente, T1.Sub_Total_Pedido, T1.Total_Pedido,T1.Desconto_Pedido,T4.Taxa_Desc,T1.Obs_Pedido,T4.Descricao_Forma_Pagamento,T1.Data_Hora_Pedido, T1.Status_Pedido,T3.Nome_Func FROM TB_PEDIDO T1, TB_CLIENTE T2, TB_FUNCIONARIO T3, TB_FORMA_PAGAMENTO T4 WHERE T2.Id_Cliente = T1.Id_Cliente AND T1.Id_Func= T3.Id_func AND T4.Id_Forma_Pagamento = t1.Id_Forma_Pagamento AND T1.Id_Pedido = ?;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                PedidoModel pedido = new PedidoModel();
                ClienteModel cliente = new ClienteModel();
                UsuarioModel usuario = new UsuarioModel();
                FormaPagamentoModel pagamento = new FormaPagamentoModel();
                
                pedido.setCodigoPedido(rs.getInt(1));                
                cliente.setNome(rs.getString(2));                
                pedido.setSubTotal(rs.getDouble(3));
                pedido.setTotal(rs.getDouble(4));
                pedido.setDesconto(rs.getDouble(5));
                pagamento.setTaxaDesconto(rs.getDouble(6));                
                
                pedido.setObservacao(rs.getString(7));                
                pagamento.setDescricao(rs.getString(8));                
                pedido.setDataHora(rs.getDate(9));
                pedido.setStatus(rs.getString(10));                
                usuario.setNome(rs.getString(11));
                
                //SETANDO OS OBJETOS EM PEDIDO
                pedido.setCliente(cliente);
                pedido.setUsuario(usuario);
                pedido.setPagamento(pagamento);
                //ADICIONANDO MODELO DE PEDIDO NA LISTA
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
        }                
        return pedidos;        
    }    
    
    public List<PedidoModel> listarPedidosPeriodo(Date inicial,Date fim) throws SQLException {   
        List<PedidoModel> pedidos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Pedido, T2.Nome_Cliente, T1.Sub_Total_Pedido, T1.Total_Pedido,T1.Desconto_Pedido,T4.Taxa_Desc,T1.Obs_Pedido,T4.Descricao_Forma_Pagamento,T1.Data_Hora_Pedido, T1.Status_Pedido,T3.Nome_Func FROM TB_PEDIDO T1, TB_CLIENTE T2, TB_FUNCIONARIO T3, TB_FORMA_PAGAMENTO T4 WHERE T2.Id_Cliente = T1.Id_Cliente AND T1.Id_Func= T3.Id_func AND T4.Id_Forma_Pagamento = t1.Id_Forma_Pagamento AND T1.Data_Hora_Pedido  BETWEEN ? AND ?;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setDate(1,inicial);
            stmt.setDate(2,fim);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                PedidoModel pedido = new PedidoModel();
                ClienteModel cliente = new ClienteModel();
                UsuarioModel usuario = new UsuarioModel();
                FormaPagamentoModel pagamento = new FormaPagamentoModel();
                
                pedido.setCodigoPedido(rs.getInt(1));                
                cliente.setNome(rs.getString(2));                
                pedido.setSubTotal(rs.getDouble(3));
                pedido.setTotal(rs.getDouble(4));
                pedido.setDesconto(rs.getDouble(5));
                pagamento.setTaxaDesconto(rs.getDouble(6));                
                
                pedido.setObservacao(rs.getString(7));                
                pagamento.setDescricao(rs.getString(8));                
                pedido.setDataHora(rs.getDate(9));
                pedido.setStatus(rs.getString(10));                
                usuario.setNome(rs.getString(11));
                
                //SETANDO OS OBJETOS EM PEDIDO
                pedido.setCliente(cliente);
                pedido.setUsuario(usuario);
                pedido.setPagamento(pagamento);
                //ADICIONANDO MODELO DE PEDIDO NA LISTA
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
        }                
        return pedidos;        
    }    

    public List<PedidoModel> listarPedidosCLiente(String razao) throws SQLException {   
        List<PedidoModel> pedidos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Pedido, T2.Nome_Cliente, T1.Sub_Total_Pedido, T1.Total_Pedido,T1.Desconto_Pedido,T4.Taxa_Desc,T1.Obs_Pedido,T4.Descricao_Forma_Pagamento,T1.Data_Hora_Pedido, T1.Status_Pedido,T3.Nome_Func FROM TB_PEDIDO T1, TB_CLIENTE T2, TB_FUNCIONARIO T3, TB_FORMA_PAGAMENTO T4 WHERE T2.Id_Cliente = T1.Id_Cliente AND T1.Id_Func= T3.Id_func AND T4.Id_Forma_Pagamento = t1.Id_Forma_Pagamento AND T2.Nome_Cliente like ?;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + razao + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                PedidoModel pedido = new PedidoModel();
                ClienteModel cliente = new ClienteModel();
                UsuarioModel usuario = new UsuarioModel();
                FormaPagamentoModel pagamento = new FormaPagamentoModel();
                
                pedido.setCodigoPedido(rs.getInt(1));                
                cliente.setNome(rs.getString(2));                
                pedido.setSubTotal(rs.getDouble(3));
                pedido.setTotal(rs.getDouble(4));
                pedido.setDesconto(rs.getDouble(5));
                pedido.setObservacao(rs.getString(6));                
                pagamento.setDescricao(rs.getString(7));                
                pedido.setDataHora(rs.getDate(8));
                pedido.setStatus(rs.getString(9));                
                usuario.setNome(rs.getString(10));
                //SETANDO OS OBJETOS EM PEDIDO
                pedido.setCliente(cliente);
                pedido.setUsuario(usuario);
                pedido.setPagamento(pagamento);
                //ADICIONANDO MODELO DE PEDIDO NA LISTA
                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
        }                
        return pedidos;        
    }    
    

    
    public void cancelarPedido(Integer cod) throws SQLException {
        String sql = "UPDATE TB_PEDIDO SET Status_Pedido = ? WHERE Id_Pedido = ?;";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"CANCELADO");
            stmt.setInt(2,cod);        
            // executam
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }           
}