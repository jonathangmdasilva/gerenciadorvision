package dao.estoque;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.estoque.ProdutoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class EstoqueSaldoDao {
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public EstoqueSaldoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(ProdutoModel pm) throws SQLException {
        String sql = "INSERT INTO TB_ESTOQUE_SALDO (Id_Produto,Saldo_Produto,Atualizacao_Saldo)VALUES(?,?,NOW())";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,pm.getIdProduto());
            stmt.setDouble(2,pm.getSaldo());            
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){                                    
            System.out.println("ERRO AO INSERIR SALDO");
            System.out.println(e.getMessage());
        }
    }

    public double saldoProduto(Integer codigo) throws SQLException {                   
        String sql = "SELECT Saldo_Produto FROM TB_ESTOQUE_SALDO WHERE Id_Produto=?;";
        double saldo=0;
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                saldo = rs.getDouble(1);               
                return saldo;
            }
            stmt.close();
            rs.close();
        }                
        return saldo;
    }   
    
    public void atualizarSaldo(ProdutoModel produto) throws SQLException {
        String sql = "UPDATE TB_ESTOQUE_SALDO SET Saldo_Produto = ?, Atualizacao_Saldo = NOW() WHERE Id_Saldo = ?; ";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setDouble(1, produto.getSaldo());
            stmt.setInt(2, produto.getIdProduto());        
            // executa
            stmt.execute();
            stmt.close();
        }
    }        
}