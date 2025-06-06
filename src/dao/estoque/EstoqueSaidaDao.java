package dao.estoque;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.estoque.EstoqueModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class EstoqueSaidaDao {
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public EstoqueSaidaDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(EstoqueModel em) throws SQLException {
        String sql = "INSERT INTO TB_ESTOQUE_SAIDA (Id_Produto,Qtd_Saida,DH_Saida)VALUES(?,?,NOW())";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,em.getIdProduto());
            stmt.setDouble(2,em.getQtd());
            //stmt.setDate(3,new Date(em.getData().getTime()));     
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "Erro ao efetuar sáida de produtos: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    public double saldoSaida(Integer codigo) throws SQLException {                   
        String sql = "SELECT SUM(Qtd_Saida) FROM TB_ESTOQUE_SAIDA WHERE Id_Produto =?;";               
        double saldoSaida=0;
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                saldoSaida = rs.getDouble(1);               
                return saldoSaida;
            }
            stmt.close();
            rs.close();
        }                
        return saldoSaida;
    } 
}