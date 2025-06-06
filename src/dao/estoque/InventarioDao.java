package dao.estoque;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.estoque.InventarioModel;
import model.estoque.ProdutoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class InventarioDao {
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public InventarioDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
    
    public List<InventarioModel> realizarInventario() throws SQLException {                   
        List<InventarioModel> inventarios = new ArrayList<>();
        String sql = "SELECT  T1.Id_Produto,T1.Descricao_Produto,T1.Min_Produto,T1.Max_Produto, T2.Saldo_Produto FROM TB_PRODUTO T1, TB_ESTOQUE_SALDO T2 WHERE T1.Id_Produto = T2.Id_Produto;";
        // seta os valores        
        try (
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {  
                InventarioModel inventarioModel = new InventarioModel();
                ProdutoModel produto = new ProdutoModel();
                produto.setIdProduto(rs.getInt(1));                
                produto.setDescricao(rs.getString(2));                                
                produto.setMinimo(rs.getInt(3));                
                produto.setMaximo(rs.getInt(4));                
                inventarioModel.setSaldo(rs.getDouble(5));                               
                inventarioModel.setProduto(produto);
                inventarios.add(inventarioModel);
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            System.out.println(e.getMessage());                       
        }finally{
            return inventarios;
        }                    
    } 
}