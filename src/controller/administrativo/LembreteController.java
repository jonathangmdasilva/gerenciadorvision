package controller.administrativo;

import dao.administrativo.LembreteDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.administrativo.LembreteModel;

/*
 * @author Jonathan
 */
public class LembreteController {
    
    public void inserirLembrete(LembreteModel lembrete) throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        lDao.inserir(lembrete);
    }
    public void excluirLembrete(int codigo) throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        lDao.excluir(codigo);        
    }
    
    public void alterarLembrete(LembreteModel lembrete) throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        lDao.alterar(lembrete);        
    }    
    
    public List<LembreteModel> listarTodosLembretes() throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        return lDao.consultarTodos();
    }    
    
    public List<LembreteModel> listarTodosLembretesCodigo(int codigo) throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        return lDao.consultarCodigo(codigo);
    }        
    
    public List<LembreteModel> listarTodosLembretesData(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        return lDao.listarTodosLembretesData(inicio,fim);
    }            
    
    public List<LembreteModel> listarTodosLembretesDoDia() throws SQLException, ClassNotFoundException{
        LembreteDao lDao = new LembreteDao();
        return lDao.listarTodosLembretesDoDia();
    }                    
}
