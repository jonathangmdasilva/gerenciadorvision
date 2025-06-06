package dao.vendas;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.vendas.FormaPagamentoModel;

/*
 * @author Jonathan
 */

public class FormaPagamentoDao {
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public FormaPagamentoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
    
    public void inserirCadastro(FormaPagamentoModel forma) throws SQLException {        
        String sql = "INSERT INTO TB_FORMA_PAGAMENTO (Descricao_Forma_Pagamento, Taxa_Desc,Ativo_Pagamento) VALUES (?,?,1)";
        // seta os valores
        try ( 
            //prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,forma.getDescricao());            
            stmt.setDouble(2,forma.getTaxaDesconto());            
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao inserir registro de forma de pag. " + e);
        }
    }
    
    
    public FormaPagamentoModel listarFormasPagamentoPelaDescricao(String desc) throws SQLException {                   
        FormaPagamentoModel pag = new FormaPagamentoModel();
        String sql = "SELECT Id_Forma_Pagamento,Descricao_Forma_Pagamento,Taxa_Desc FROM TB_FORMA_PAGAMENTO WHERE Descricao_Forma_Pagamento = ? AND Ativo_Pagamento = 1 ";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"'" + desc + "'");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                
                pag.setIdFormaPagamento(rs.getInt(1));
                pag.setDescricao(rs.getString(2));
                pag.setTaxaDesconto(rs.getDouble(3));                
            }
            stmt.execute();
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO AO LISTAR FORMAS DE PAGAMENTO PELO NOME: " + e.getMessage());
        }finally{
            return pag;
        }                                    
    }
            
    public List<FormaPagamentoModel> listarFormasPagamento() throws SQLException {   
        List<FormaPagamentoModel> pagamentos = new ArrayList<>();        
        String sql = "SELECT *FROM TB_FORMA_PAGAMENTO WHERE Ativo_Pagamento = 1";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {
                FormaPagamentoModel pag = new FormaPagamentoModel();
                pag.setIdFormaPagamento(rs.getInt(1));
                pag.setDescricao(rs.getString(2));
                pag.setTaxaDesconto(rs.getDouble(3));
                pagamentos.add(pag);
            }
            stmt.execute();
            rs.close();
            stmt.close();
        }catch(Exception e){            
            System.out.println("ERRO AO LISTAR FORMAS DE PAGAMENTO TODOS" + e.getMessage());
        }finally{
            return pagamentos;        
        }                    
    }
    
    public int listarCodigoFormasPagamento(String descricao) throws SQLException {           
        String sql = "SELECT Id_Forma_Pagamento,Taxa_Desc FROM TB_FORMA_PAGAMENTO WHERE Descricao_Forma_Pagamento='?'";                       
        int codigo = 0;        
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,descricao);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()){ 
                codigo = rs.getInt(1);                                
            }
            stmt.execute();
            rs.close();
            stmt.close();            
        }catch(Exception e){
            System.out.println("ERRO AO LISTAR FORMAS DE PAGAMENTO(RETONO CÓDIGO): " + e.getMessage());
        }finally{
            return codigo;        
        }                    
    }               
}