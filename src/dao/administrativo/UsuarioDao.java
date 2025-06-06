package dao.administrativo;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.administrativo.FuncionarioModel;
import model.administrativo.UsuarioModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class UsuarioDao {
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public UsuarioDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastroUsuario(FuncionarioModel fm) throws SQLException {
        String sql = "INSERT INTO TB_USUARIO (Login_Usuario, Senha_Usuario, Nivel_Usuario,Status_Usuario)" + " values (?,?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,fm.getLogin());
            stmt.setString(2,fm.getSenha());
            stmt.setString(3,fm.getNivel());
            stmt.setInt(4,fm.getStatus());     
            // executa
            stmt.execute();            
            stmt.close();
        }catch(Exception e){
        }                
    }    
    
    
    public void excluirCadastroUsuario(Integer cod) throws SQLException {
        String sql = "UPDATE TB_USUARIO SET Status_Usuario = ? WHERE Id_Usuario = ?";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"0");
            stmt.setInt(2,cod);        
            // executa
            stmt.execute();
            stmt.close();
        }
    }
    
    public void alterarCadastroUsuario(FuncionarioModel funcionario) throws SQLException {
        String sql = "UPDATE TB_USUARIO SET Login_Usuario = ?, Senha_Usuario = ?,Nivel_Usuario = ? WHERE Id_Usuario = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,funcionario.getLogin());
            stmt.setString(2,funcionario.getSenha());
            stmt.setString(3,funcionario.getNivel());
            stmt.setInt(4,funcionario.getIdUsuario());
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    
    public int listarQtdUsuarios() throws SQLException{        
        UsuarioModel um = new UsuarioModel();
        String sql = "SELECT *FROM TB_USUARIO ORDER BY Id_Usuario DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                um.setIdUsuario(rs.getInt(1));
                break;
            }
            rs.close();
            stmt.close();
        }
        return um.getIdUsuario();
    }        
    
    public UsuarioModel validaLogin(String login,String senha) throws SQLException{
        UsuarioModel usu = new UsuarioModel();
        String sql = "SELECT T1.Id_Usuario, T1.Login_Usuario, T1.Senha_Usuario,T1.Nivel_Usuario,T1.Status_Usuario, T2.Nome_Func FROM TB_USUARIO T1, TB_FUNCIONARIO T2 WHERE T1.Id_Usuario = T2.Id_Usuario AND Login_Usuario = ? AND Senha_Usuario = ?;";        
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,login);
            stmt.setString(2,senha);
            try ( 
                // executa
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {                    
                    // criando o objeto Usuario
                    usu.setIdUsuario(rs.getInt(1));
                    usu.setLogin(rs.getString(2));
                    usu.setSenha(rs.getString(3));
                    usu.setNivel(rs.getString(4));
                    usu.setStatus(rs.getInt(5));
                    usu.setNome(rs.getString(6));
                    // adiciona o usu à lista de usus
                }
                rs.close();
                stmt.close();
            }                        
            if(usu.getIdUsuario()==null) usu.setIdUsuario(-1);
        }catch(Exception e){ 
            System.out.println("ERRO NA BUSCA");
            System.out.println(e.getMessage());
        }
        return usu;
    }                
}