package dao.vendas;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.administrativo.ClienteModel;
import model.administrativo.UsuarioModel;
import model.vendas.CotacaoModel;
import model.vendas.FormaPagamentoModel;
import model.vendas.PedidoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class CotacaoDao {

    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public CotacaoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(CotacaoModel cotacao) throws SQLException {
        String sql = "INSERT INTO TB_COTACAO (Id_Func,Id_Cliente,Data_Hora_Cotacao,Total_Cotacao,Status_Cotacao,Desconto_Cotacao,Id_Forma_Pagamento,Periodo_Val_Cotacao,Obs_Cotacao)VALUES(?,?,NOW(),?,?,?,?,?,?)";
        // seta os valores
        try ( 
            //prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,cotacao.getPedido().getUsuario().getIdUsuario());
            stmt.setInt(2,cotacao.getPedido().getCliente().getIdCliente());
            stmt.setDouble(3,cotacao.getPedido().getTotal());            
            stmt.setString(4,cotacao.getPedido().getStatus());                 
            stmt.setDouble(5,cotacao.getPedido().getDesconto());                 
            stmt.setInt(6,cotacao.getPedido().getPagamento().getIdFormaPagamento());                 
            stmt.setInt(7,cotacao.getPeriodo());  
            stmt.setString(8,cotacao.getPedido().getObservacao());  
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println("Erro" + e.getMessage());            
        }
    }
    
    
    public int listarTotalCotacao() throws SQLException {           
        String sql = "SELECT MAX(Id_Cotacao) FROM TB_COTACAO;";                       
        int codigo = 0;        
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {        
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                codigo = rs.getInt(1);                                
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.getMessage();
            System.out.println("ERRO AO LISTAR CÓDIGO COTAÇÃO");
        }finally{
            return codigo;        
        }                    
    }
    
    public CotacaoModel listarCotacaoCodigo(int codigo) throws SQLException {   
        CotacaoModel cotacao = new CotacaoModel();        
        String sql = "SELECT T1.Id_Cotacao, T2.Id_Cliente, T1.Total_Cotacao,T1.Desconto_Cotacao,T1.Obs_Cotacao,T4.Id_Forma_Pagamento, T1.Status_Cotacao,T3.Id_Func, ADDDATE(T1.Data_Hora_Cotacao, INTERVAL T1.Periodo_Val_Cotacao DAY) AS 'DATA DIA'  FROM TB_COTACAO T1, TB_CLIENTE T2, TB_FUNCIONARIO T3, TB_FORMA_PAGAMENTO T4 WHERE T2.Id_Cliente = T1.Id_Cliente AND T1.Id_Func= T3.Id_func AND T4.Id_Forma_Pagamento = T1.Id_Forma_Pagamento AND T1.Id_Cotacao = ?;";                 
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
                cliente.setIdCliente(rs.getInt(2));                                
                pedido.setTotal(rs.getDouble(3));
                pedido.setDesconto(rs.getDouble(4));
                pedido.setObservacao(rs.getString(5));                
                pagamento.setIdFormaPagamento(rs.getInt(6));                
                
                pedido.setStatus(rs.getString(7));                
                usuario.setIdUsuario(rs.getInt(8));
                pedido.setDataHora(rs.getDate(9));
                //SETANDO OS OBJETOS EM PEDIDO
                pedido.setCliente(cliente);
                pedido.setUsuario(usuario);
                pedido.setPagamento(pagamento);
                pedido.setSubTotal(pedido.getTotal());
                //ADICIONANDO MODELO DE PEDIDO NA LISTA
                cotacao.setPedido(pedido);                               
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Erro no listarCotacaoCodigo: " + e.getMessage());
        }                
        return cotacao;        
    }        
    
    public void invalidarCotacao(int codigo){
        String sql = "UPDATE TB_COTACAO SET Status_Cotacao = ? WHERE Id_Cotacao = ?";        
        try ( 
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"INVALIDA");            
            stmt.setInt(2,codigo);            
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){
            System.out.println("invalidarCotacao: "+e.getMessage());
            System.out.println("ERRO NO INVALIDAR COTAÇÃO DAO");
        }
    }   
}