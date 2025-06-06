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

public class LucroProdutoDao {
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public LucroProdutoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
    
    public void inserirCadastro(ProdutoModel pm) throws SQLException {
        String sql = "INSERT INTO TB_LUCRO_PRODUTO (Valor_Compra,Valor_Venda,Lucro_Produto,Margem_Lucro)VALUES (?,?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setDouble(1,pm.getLucro().getValorCompra());
            stmt.setDouble(2,pm.getLucro().getValorVenda());
            stmt.setDouble(3,pm.getLucro().getLucro());
            stmt.setDouble(4,pm.getLucro().getMargem());
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){                      
            System.out.println("ERRO NO LUCRO PRODUTO");
            System.out.println(e.getMessage());            
        }
    }    
    
    public int listarLucros() throws SQLException{        
        Integer qtd = null;
        //LucroProdutoModel lm = new LucroProdutoModel();
        String sql = "SELECT max(Id_Lucro) FROM TB_LUCRO_PRODUTO;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {
                qtd = rs.getInt(1);                
            }
            stmt.close();
            rs.close();
        }
        return qtd;
    }       
}