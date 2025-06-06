package controller.administrativo;

import dao.administrativo.ContatoDao;
import model.administrativo.ContatoModel;
import java.sql.SQLException;
import model.administrativo.ClienteModel;
import model.estoque.FornecedorModel;

/*
 * @author Jonathan
 */
public class ContatoController {
    
     public void inserirContatoCliente(String email,String telefoneUm,String telefoneDois,int idCliente) throws SQLException, ClassNotFoundException{
            ContatoModel contato= new ContatoModel();
            contato.setEmail(email);
            contato.setTelUm(telefoneUm);
            contato.setTelDois(telefoneDois);
            contato.setIdCliente(idCliente);
            ContatoDao contatoDao = new ContatoDao();
            contatoDao.inserirContatoCliente(contato);    
    }
     
     public int listarQtdContatos() throws SQLException, ClassNotFoundException{
         ContatoDao contatoDao = new ContatoDao();
         ContatoModel contatoModel = new ContatoModel();         
         return contatoDao.listarQtdContatos();         
     }
     
     public void alterarContatoCliente(ClienteModel cliente) throws SQLException, ClassNotFoundException{
         ContatoDao contatoDao = new ContatoDao();
         contatoDao.alterarContatoCliente(cliente);         
     }
     
     //FORNECEDOR X CONTATO
     
     public void inserirContatoFornecedor(String email,String telefoneUm,String telefoneDois,int idFornecdor) throws SQLException, ClassNotFoundException{
            ContatoModel contato= new ContatoModel();
            contato.setEmail(email);
            contato.setTelUm(telefoneUm);
            contato.setTelDois(telefoneDois);
            contato.setIdFornecedor(idFornecdor);
            ContatoDao contatoDao = new ContatoDao();
            contatoDao.inserirContatoFornecedor(contato);    
    }     
     
    public void alterarContatoFornecedor(FornecedorModel fornecedor) throws SQLException, ClassNotFoundException{
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.alterarContatoFornecedor(fornecedor);         
    }     
        
    //EMPRESA X CONTATO
    
    public void inserirContatoEmpresa(ContatoModel contato) throws SQLException, ClassNotFoundException{
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.inserirContatoEmpresa(contato);    
    }         
}
