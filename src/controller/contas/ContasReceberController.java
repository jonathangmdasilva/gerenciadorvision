package controller.contas;

import dao.contas.ContasDao;
import dao.contas.ContasReceberDao;
import java.sql.Date;
import java.util.List;
import java.sql.SQLException;
import model.contas.ContasReceberModel;

/*
 * @author Jonathan
 */
public class ContasReceberController {
  
    public void inserirContasReceber(ContasReceberModel cr) throws SQLException, ClassNotFoundException{        
        ContasDao cd = new ContasDao();
        cd.inserirCadastroContas(cr);
        int cod = cd.listarQtdContas();
        cr.setIdConta(cod);
        ContasReceberDao crd = new ContasReceberDao();
        crd.inserir(cr);
    }            
    
    public void excluirContasReceber(Integer  cod) throws SQLException, ClassNotFoundException{
        ContasDao contasDao = new ContasDao();        
        contasDao.excluirCadastroContas(cod);
    }
    
    public void alterarContasReceber(ContasReceberModel receber) throws SQLException, ClassNotFoundException{
        ContasDao contasDao = new ContasDao();        
        ContasReceberDao receberDao = new ContasReceberDao();
        receberDao.alterar(receber);
        int x = receberDao.recuperarIdContas(receber);
        contasDao.alterarCadastroContas(receber,x);                
    }    

    public List<ContasReceberModel> listarTodosContasReceber() throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();        
        return receberDao.consultarTodos();
    }

    public List<ContasReceberModel> listarTodosSacado(String nome) throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();           
        return receberDao.consultarNome(nome);
    }     
    
    public List<ContasReceberModel> listarTodasPeriodoVenc(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();           
        return receberDao.listarTodasPeriodoVenc(inicio, fim);
    }         

    public List<ContasReceberModel> listarPorStatus(String nome) throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();           
        return receberDao.listarTodasContasReceberStatus(nome);
    }     
    
    public List<ContasReceberModel> listarCodigo(Integer cod) throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();        
        return receberDao.consultarCodigo(cod);
    }                         
    
    public Boolean existeReceberVencidas() throws SQLException, ClassNotFoundException{
        ContasReceberDao receberDao = new ContasReceberDao();        
        return receberDao.existeContaReceberVencida();
    } 
}