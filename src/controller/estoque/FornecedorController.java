package controller.estoque;

import dao.administrativo.ContatoDao;
import dao.administrativo.EnderecoDao;
import dao.estoque.FornecedorDao;
import java.sql.SQLException;
import java.util.List;
import model.estoque.FornecedorModel;

/**
 * @author Jonathan
 */
public class FornecedorController {

    public void inserirFornecedor(String razao,String cnpj,int status) throws SQLException, ClassNotFoundException{
        FornecedorModel fornecedor= new FornecedorModel();
        fornecedor.setRazaoSocial(razao);
        fornecedor.setCnpj(cnpj);            
        fornecedor.setStatus(status);                       
        FornecedorDao fornecedorDao = new FornecedorDao();
        fornecedorDao.inserir(fornecedor);            
    }

    public int listarQtdFornecedores() throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();            
        return fornecedorDao.listarQtdFornecedores();         
    }

    public List<FornecedorModel> listarTodosFornecedores() throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        return fornecedorDao.consultarTodos();
    }

    public List<FornecedorModel> listarTodosNome(String razao) throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        return fornecedorDao.consultarNome(razao);
    }     

    public List<FornecedorModel> listarCodigo(Integer cod) throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        return fornecedorDao.consultarCodigo(cod);
    }         

    public void excluirFornecedor(Integer  cod) throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        fornecedorDao.excluir(cod);
    }

    public void alterarFornecedor(FornecedorModel fornecedor) throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        ContatoDao contatoDao = new ContatoDao();
        EnderecoDao endDao = new EnderecoDao();            
        fornecedorDao.alterar(fornecedor);
        endDao.alterarEnderecoFornecedor(fornecedor);                    
        contatoDao.alterarContatoFornecedor(fornecedor);
    }            

    public List<FornecedorModel> listarComboFornecedor() throws SQLException, ClassNotFoundException{
        FornecedorDao fornecedorDao = new FornecedorDao();        
        return fornecedorDao.listarRzaoFornecedores();
    }         
    
    public int listarCodigoFornecedor(String fornecedor) throws SQLException, ClassNotFoundException{
       FornecedorDao fornecedorDao = new FornecedorDao();        
       return fornecedorDao.listarCodigoFornecedor(fornecedor);
    }
}
