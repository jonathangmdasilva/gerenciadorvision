package dao.administrativo;

import conexao.Conexao;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.administrativo.FuncionarioModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class FuncionarioDao implements IDao<FuncionarioModel>{
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public FuncionarioDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }          
    
    public int listarQtdFuncionarios() throws SQLException{        
        FuncionarioModel fm = new FuncionarioModel();
        String sql = "SELECT *FROM FUNCINARIO ORDER BY Id_Func DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                fm.setIdFuncionario(rs.getInt(1));
                break;
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            return fm.getIdFuncionario();
        }        
    } 

    @Override
    public void inserir(FuncionarioModel fm) throws SQLException {
        String sql = "INSERT INTO TB_FUNCIONARIO (Nome_Func, Cargo_Func, Id_Usuario)" + " values (?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,fm.getNome());
            stmt.setString(2,fm.getCargo());
            stmt.setInt(3,fm.getIdUsuario());     
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){
            System.out.println("ERRO AO INSERIR FUNCIONÁRIO");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void alterar(FuncionarioModel funcionario) {
        String sql = "UPDATE TB_FUNCIONARIO SET Nome_Func = ?, Cargo_Func = ? WHERE Id_Func = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,funcionario.getNome());
            stmt.setString(2,funcionario.getCargo());
            stmt.setInt(3,funcionario.getIdFuncionario());
            // executa
            stmt.execute();            
            stmt.close();            
        }catch(Exception e ){
            System.out.println("ERRO AO ATUALIZAR FUNCIONÁRIO");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_USUARIO SET Status_Usuario = ? WHERE Id_Usuario = ?";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"0");
            stmt.setInt(2,cod);        
            // executa
            stmt.execute();                        
            stmt.close();            
        }catch(Exception e ){
            System.out.println("ERRO EXCLUIR FUNCIONÁRIO!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<FuncionarioModel> consultarTodos() {
        List<FuncionarioModel> funcionarios = new ArrayList<>();        
        String sql = "SELECT T1.Id_Func, T1.Nome_Func, T1.Cargo_Func, T2.Login_Usuario, T2.Senha_Usuario, T2.Nivel_Usuario FROM TB_FUNCIONARIO T1 , TB_USUARIO T2 WHERE T2. Status_Usuario = 1 AND T2.Id_Usuario = T1.Id_Usuario AND T2.Id_Usuario>1;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                FuncionarioModel fm = new FuncionarioModel();
                fm.setIdFuncionario(Integer.parseInt(rs.getString(1)));
                fm.setNome(rs.getString(2));
                fm.setCargo(rs.getString(3));
                fm.setLogin(rs.getString(4));   
                fm.setSenha(rs.getString(5));
                fm.setNivel(rs.getString(6));
                funcionarios.add(fm);
            }
            stmt.close();  
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR TODOS FUNCIONÁRIOS");
            System.out.println(ex.getMessage());
        }finally{
            return funcionarios;      
        }        
    }

    @Override
    public List<FuncionarioModel> consultarCodigo(Integer cod) {
        List<FuncionarioModel> funcionarios = new ArrayList<>();                
        //FuncionarioModel fm = new FuncionarioModel();        
        String sql = "SELECT T1.Id_Func, T1.Nome_Func, T1.Cargo_Func, T2.Login_Usuario, T2.Senha_Usuario, T2.Nivel_Usuario FROM TB_FUNCIONARIO T1 , TB_USUARIO T2 WHERE T2. Status_Usuario = 1 AND T2.Id_Usuario = T1.Id_Usuario and T1.Id_Func = ? AND T2.Id_Usuario>1;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                
                FuncionarioModel fm = new FuncionarioModel();
                fm.setIdFuncionario(Integer.parseInt(rs.getString(1)));
                fm.setNome(rs.getString(2));
                fm.setCargo(rs.getString(3));
                fm.setLogin(rs.getString(4));   
                fm.setSenha(rs.getString(5));
                fm.setNivel(rs.getString(6));
                funcionarios.add(fm);
            }
            stmt.close();  
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR FUNCIONÁRIOS PELO CÓDIGO");
            System.out.println(ex.getMessage());
        }finally{
            return funcionarios; 
        }        
    }

    @Override
    public List<FuncionarioModel> consultarNome(String nome) {
        List<FuncionarioModel> funcionarios = new ArrayList<>();        
        String sql = "SELECT T1.Id_Func, T1.Nome_Func, T1.Cargo_Func, T2.Login_Usuario, T2.Senha_Usuario, T2.Nivel_Usuario FROM TB_FUNCIONARIO T1 , TB_USUARIO T2 WHERE T2. Status_Usuario = 1 AND T2.Id_Usuario = T1.Id_Usuario and T1.Nome_Func like ? AND T2.Id_Usuario>1;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()){ 
                FuncionarioModel fm = new FuncionarioModel();
                fm.setIdFuncionario(Integer.parseInt(rs.getString(1)));
                fm.setNome(rs.getString(2));
                fm.setCargo(rs.getString(3));
                fm.setLogin(rs.getString(4));   
                fm.setSenha(rs.getString(5));
                fm.setNivel(rs.getString(6));
                funcionarios.add(fm);
            }
            stmt.close();  
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO CONSULTAR FUNCIONÁRIO PELO NOME!");
            System.out.println(ex.getMessage());
        }finally{
            return funcionarios;     
        }        
    }
}