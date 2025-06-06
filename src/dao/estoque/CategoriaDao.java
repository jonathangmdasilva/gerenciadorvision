package dao.estoque;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.estoque.CategoriaModel;

/*
 * @author Jonathan
 */
public class CategoriaDao {
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public CategoriaDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
    
    public List<CategoriaModel> listarCategoriaProdutos() throws SQLException {   
        List<CategoriaModel> categorias = new ArrayList<>();        
        String sql = "SELECT Descricao_Cat_Prod FROM TB_CATEGORIA_PRODUTO;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                CategoriaModel cm = new CategoriaModel();
                cm.setDescricao(rs.getString(1));
                categorias.add(cm);
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.getMessage();
            System.out.println("ERRO AO LISTAR CATEGORIAS DE PRODUTOS");
        }finally{
            return categorias;        
        }                    
    }
            
    public int listarCodigoCategoriaProdutos(String categoria) throws SQLException {           
        String sql = "SELECT Id_Cat_Prod FROM TB_CATEGORIA_PRODUTO WHERE Descricao_cat_Prod = ?";                       
        int codigo = 0;        
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,categoria);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                codigo = rs.getInt(1);                                
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.getMessage();
            System.out.println("ERRO AO LISTAR CATEGORIAS DE PRODUTOS");
        }finally{
            return codigo;        
        }                    
    }    
}