package controller.administrativo;

import dao.administrativo.ConfiguracaoDao;
import java.sql.SQLException;
import model.administrativo.ConfiguracaoModel;

/*
 * @author Jonathan
 */

public class ConfiguracaoController {
    
    public void inserirConfiguracao(ConfiguracaoModel conf) throws SQLException, ClassNotFoundException{
        ConfiguracaoDao cDao = new ConfiguracaoDao();
        cDao.inserir(conf);            
    } 

    public ConfiguracaoModel verificarConfiguracao() throws SQLException, ClassNotFoundException{
        ConfiguracaoDao cDao = new ConfiguracaoDao();
        return cDao.retornaConfiguracao();
    }    
}
