package controller.contas;

import dao.contas.ContasDao;
import dao.contas.ContasPagarDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.contas.ContasPagarModel;

/*
 * @author Jonathan
 */
public class ContasPagarController {
  
    public void inserirContasPagar(ContasPagarModel cp) throws SQLException, ClassNotFoundException{
        ContasDao cd = new ContasDao();
        cd.inserirCadastroContas(cp);
        int cod = cd.listarQtdContas();
        cp.setIdConta(cod);
        ContasPagarDao cpd = new ContasPagarDao();
        cpd.inserir(cp);
    }    
    
    public void excluirContasPagar(Integer  cod) throws SQLException, ClassNotFoundException{
        ContasDao contasDao = new ContasDao();        
        contasDao.excluirCadastroContas(cod);
    }
    
    public void alterarContasPagar(ContasPagarModel pagar) throws SQLException, ClassNotFoundException{
        ContasDao contasDao = new ContasDao();        
        ContasPagarDao pagarDao = new ContasPagarDao();
        pagarDao.alterar(pagar);
        int x = pagarDao.recuperarIdContas(pagar);
        contasDao.alterarCadastroContas(pagar,x);                
    }    

    public List<ContasPagarModel> listarTodosContasPagar() throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();        
        return pagarDao.consultarTodos();
    }

    public List<ContasPagarModel> listarTodosCedente(String nome) throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();           
        return pagarDao.consultarNome(nome);
    }     
    
    public List<ContasPagarModel> listarTodasPeriodoVenc(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();           
        return pagarDao.listarTodasPeriodoVenc(inicio, fim);
    }         

    public List<ContasPagarModel> listarPorStatus(String nome) throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();           
        return pagarDao.listarTodasContasPagarStatus(nome);
    }     
    
    public List<ContasPagarModel> listarCodigo(Integer cod) throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();        
        return pagarDao.consultarCodigo(cod);
    }                     
    
    public Boolean existePagarVencidas() throws SQLException, ClassNotFoundException{
        ContasPagarDao pagarDao = new ContasPagarDao();           
        return pagarDao.existeContaPagarVencida();
    }         
}