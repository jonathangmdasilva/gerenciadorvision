package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Jonathan
 */

public class Conexao {

    public static Connection con;
 
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {         
            Class.forName("com.mysql.cj.jdbc.Driver");            
            String url ="jdbc:mysql://localhost:3306/bd_vision?useSSL=false&useTimezone=true&serverTimezone=UTC";
            //String url ="jdbc:mysql://localhost:3306/bd_var_ferramentas?useSSL=false";
            String usuario = "test";            
            String senha = "test_123";
            con = DriverManager.getConnection(url,usuario,senha);            
            //return DriverManager.getConnection(url,usuario,senha);            
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar na base de dados: "+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);            
            return null;            
        }
    }
    
    public void desconecta(){
        try {
            con.close();
            System.out.println("BANCO DESCONECTADO COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se desconectar com banco de dado:\n!!" +ex.getMessage());
        }
    }
}