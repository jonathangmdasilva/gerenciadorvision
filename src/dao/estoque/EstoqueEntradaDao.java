package dao.estoque;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.estoque.EstoqueModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class EstoqueEntradaDao {
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public EstoqueEntradaDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(EstoqueModel em) throws SQLException {
        String sql = "INSERT INTO TB_ESTOQUE_ENTRADA (Id_Produto,Qtd_Entrada,DH_Entrada)VALUES(?,?,NOW())";
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
            System.out.println("ERRO AO INSERIR ENTRADA: " + e.getMessage());
        }
    }

    public double saldoEntrada(Integer codigo) throws SQLException {                   
        String sql = "SELECT SUM(Qtd_Entrada) FROM TB_ESTOQUE_ENTRADA WHERE Id_Produto =?;";               
        double saldoEntrada=0;
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                saldoEntrada = rs.getDouble(1);               
                return saldoEntrada;
            }
            stmt.close();
            rs.close();
        }                
        return saldoEntrada;
    }     
}