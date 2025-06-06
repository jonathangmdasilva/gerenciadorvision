package controller.administrativo;

import dao.administrativo.ClienteDao;
import dao.administrativo.ContatoDao;
import dao.administrativo.EnderecoDao;
import model.administrativo.ClienteModel;
import java.sql.SQLException;
import java.util.List;

/*
 * @author Jonathan
 */
public class ClienteController {       
    
        public void inserirClient(String nome,String tipo,String cpf,String cnpj,int status) throws SQLException, ClassNotFoundException{
            ClienteModel cliente= new ClienteModel();
            cliente.setNome(nome);
            cliente.setTipo(tipo);
            cliente.setCpf(cpf);
            cliente.setCnpj(cnpj);
            cliente.setStatus(status);           
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.inserir(cliente);
            
        }
        
        public int listarQtdClientes() throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();            
            return clienteDao.listarQtdClientes();         
        }
        
        public List<ClienteModel> listarTodosClientes() throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();        
            return clienteDao.consultarTodos();
        }
        
        public List<ClienteModel> listarTodosNome(String nome) throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();        
            return clienteDao.consultarNome(nome);
        }     
        
        public List<ClienteModel> listarCodigo(Integer cod) throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();        
            return clienteDao.consultarCodigo(cod);
        }         
        
        public void excluirCliente(Integer  cod) throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();        
            clienteDao.excluir(cod);
        }
        
        public void alterarCliente(ClienteModel cliente) throws SQLException, ClassNotFoundException{
            ClienteDao clienteDao = new ClienteDao();        
            ContatoDao contatoDao = new ContatoDao();
            EnderecoDao endDao = new EnderecoDao();
            
            clienteDao.alterar(cliente);
            cliente.getEndereco().setIdEndereco(endDao.consultarIdEnderecoCliente(cliente.getIdCliente()));
            cliente.getContato().setIdContato(contatoDao.consultarIdContatoCliente(cliente.getIdCliente()));
            endDao.alterarEnderecoCliente(cliente);                    
            contatoDao.alterarContatoCliente(cliente);
        }        
}