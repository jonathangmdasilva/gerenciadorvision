package dao.administrativo;

import conexao.Conexao;
import model.administrativo.ContatoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.administrativo.ClienteModel;
import model.estoque.FornecedorModel;

/**
 * @author Jonathan
 */
public class ContatoDao{
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ContatoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
            
    public void inserirContatoCliente(ContatoModel cm) throws SQLException {
        String sql = "insert into TB_CONTATO" + " (Email_Contato, Tel_Um_Contato, Tel_Dois_Contato,Id_Cliente)" + " values (?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cm.getEmail());
            stmt.setString(2,cm.getTelUm());
            stmt.setString(3,cm.getTelDois());
            stmt.setInt(4,cm.getIdCliente());                
            // executa
            stmt.execute();            
            stmt.close();   
        }
    }    

    public void alterarContatoCliente(ClienteModel cliente) throws SQLException {
        String sql = "UPDATE TB_CONTATO SET Email_Contato = ?, Tel_Um_Contato = ?, Tel_Dois_Contato = ? WHERE Id_Cliente =?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cliente.getContato().getEmail());
            stmt.setString(2,cliente.getContato().getTelUm());
            stmt.setString(3,cliente.getContato().getTelDois());
            stmt.setInt(4,cliente.getIdCliente());        
            // executa
            stmt.execute();
            stmt.close();  
        }
    }
    
    public int listarQtdContatos() throws SQLException{
        Integer qtd;
        ContatoModel cm = new ContatoModel();
        String sql = "SELECT *FROM tb_contato ORDER BY Id_Contato DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                cm.setIdContato(rs.getInt(1));
                break;
            }
            stmt.close();  
            rs.close();
        }
        return cm.getIdContato();        
    }
    
   public int consultarIdContatoCliente(Integer idCliente) throws SQLException{
        Integer id = null;
        //EnderecoModel em = new EnderecoModel();
        String sql = "SELECT Id_Contato from TB_CONTATO WHERE Id_Cliente = ?;";        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                id = rs.getInt(1);
                break;
            } 
            stmt.close();  
            rs.close();
        }
        return id;                               
   }    
   
   //FORNECEDOR X CONTATO   
   public int consultarIdContatoFornecedor(Integer idFornecedor) throws SQLException{
        Integer id = null;
        //EnderecoModel em = new EnderecoModel();
        String sql = "SELECT Id_Contato from TB_CONTATO WHERE Id_Fornecedor = ?;";        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,idFornecedor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                id = rs.getInt(1);
                break;
            }            
            stmt.close();  
            rs.close();
        }
        return id;                               
   }
 
    public void inserirContatoFornecedor(ContatoModel cm) throws SQLException {
        String sql = "INSERT INTO TB_CONTATO" + " (Email_Contato, Tel_Um_Contato, Tel_Dois_Contato,Id_Fornecedor)" + " values (?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cm.getEmail());
            stmt.setString(2,cm.getTelUm());
            stmt.setString(3,cm.getTelDois());
            stmt.setInt(4,cm.getIdFornecedor());                
            // executa
            stmt.execute();
            stmt.close();
        }
    }        
   
    public void alterarContatoFornecedor(FornecedorModel fornecedor) throws SQLException {
        String sql = "UPDATE TB_CONTATO SET Email_Contato = ?, Tel_Um_Contato = ?, Tel_Dois_Contato = ? WHERE Id_Fornecedor =?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,fornecedor.getContato().getEmail());
            stmt.setString(2,fornecedor.getContato().getTelUm());
            stmt.setString(3,fornecedor.getContato().getTelDois());
            stmt.setInt(4,fornecedor.getIdFornecedor());        
            // executa
            stmt.execute();
            stmt.close();              
        }                    
    }    
    
    public void inserirContatoEmpresa(ContatoModel cm) throws SQLException {
        String sql = "INSERT INTO TB_CONTATO" + " (Email_Contato, Tel_Um_Contato, Tel_Dois_Contato,Id_Empresa)" + " values (?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cm.getEmail());
            stmt.setString(2,cm.getTelUm());
            stmt.setString(3,cm.getTelDois());
            stmt.setInt(4,cm.getIdEmpresa());                
            // executa
            stmt.execute();
            stmt.close();
        }    
    }         
}