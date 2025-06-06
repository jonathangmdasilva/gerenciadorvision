package controller.administrativo;

import dao.administrativo.EnderecoDao;
import model.administrativo.EnderecoModel;
import java.sql.SQLException;
import model.estoque.FornecedorModel;

/*
 * @author Jonathan
 */
public class EnderecoController {
     
    public void inserirEnderecoCliente(String logradouro,int numero,String bairro,String cidade,int estado,int idCliente) throws SQLException, ClassNotFoundException{
            EnderecoModel endereco= new EnderecoModel();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setCidade(cidade);
            endereco.setBairro(bairro);
            endereco.setIdEstado(estado);
            endereco.setIdCliente(idCliente);
                        
            EnderecoDao enderecoDao = new EnderecoDao();
            enderecoDao.inserirCadastroCliente(endereco);            
    }    
    
    public void inserirEnderecoFornecedor(String logradouro,int numero,String bairro,String cidade,int estado,int idFornecedor) throws SQLException, ClassNotFoundException{
        EnderecoModel endereco= new EnderecoModel();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setBairro(bairro);
        endereco.setIdEstado(estado);
        endereco.setIdFornecedor(idFornecedor);

        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.inserirCadastroFornecedor(endereco);            
    }    
    
    public void inserirEnderecoEmpresa(EnderecoModel endereco) throws SQLException, ClassNotFoundException{                
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.inserirCadastroEmpresa(endereco);            
    }    
    
    
    public int listarQtdEnderecos() throws SQLException, ClassNotFoundException{
         EnderecoDao enderecoDao = new EnderecoDao();
         EnderecoModel enderecoModel = new EnderecoModel();         
         return enderecoDao.listarQtdEndereco();         
    }
    
    public void alterarEnderecoFornecedor(FornecedorModel fornecedor) throws SQLException, ClassNotFoundException{
         EnderecoDao enderecoDao = new EnderecoDao();
         enderecoDao.alterarEnderecoFornecedor(fornecedor);
    }
    
}
