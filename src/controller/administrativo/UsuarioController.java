package controller.administrativo;

import dao.administrativo.UsuarioDao;
import java.sql.SQLException;
import model.administrativo.UsuarioModel;

/*
 * @author Jonathan
 */
public class UsuarioController {
  
    public UsuarioModel validarUsuario(String login,String senha) throws SQLException, ClassNotFoundException{
        UsuarioDao usuarioDao = new UsuarioDao(); 
        UsuarioModel usuario = new UsuarioModel();
        usuario = usuarioDao.validaLogin(login,senha);         
        return usuario;
    }
}
