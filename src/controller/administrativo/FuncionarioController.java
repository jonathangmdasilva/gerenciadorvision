package controller.administrativo;

import dao.administrativo.FuncionarioDao;
import dao.administrativo.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import model.administrativo.FuncionarioModel;

/*
 * @author Jonathan
 */
public class FuncionarioController {
  
        public void inserirFuncionario(String nome,String cargo,String nivel,String login,String senha ,int status) throws SQLException, ClassNotFoundException{
            FuncionarioModel func= new FuncionarioModel();            
            func.setNome(nome);
            func.setCargo(cargo);
            func.setNivel(nivel);
            func.setLogin(login);
            func.setSenha(senha);
            func.setStatus(status);
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.inserirCadastroUsuario(func);
            func.setIdUsuario(usuarioDao.listarQtdUsuarios());
            
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.inserir(func);
        }
        
        public int listarQtdFuncionarios() throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            return funcionarioDao.listarQtdFuncionarios();         
        }
        
        public List<FuncionarioModel> listarTodosFuncionarios() throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            return funcionarioDao.consultarTodos();
        }
        
        public List<FuncionarioModel> listarTodosNome(String nome) throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            return funcionarioDao.consultarNome(nome);
        }     
        
        public List<FuncionarioModel> listarCodigo(Integer cod) throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            return funcionarioDao.consultarCodigo(cod);
        }         
        
        public void excluirFuncionario(Integer  cod) throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            funcionarioDao.excluir(cod);
        }
        
        public void alterarFuncionario(FuncionarioModel func) throws SQLException, ClassNotFoundException{
            FuncionarioDao funcionarioDao = new FuncionarioDao();        
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.alterarCadastroUsuario(func);            
            funcionarioDao.alterar(func);
        }            
    
}
