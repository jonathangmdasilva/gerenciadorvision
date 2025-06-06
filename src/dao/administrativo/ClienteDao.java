package dao.administrativo;

import conexao.Conexao;
import interfaces.IDao;
import model.administrativo.ClienteModel;
import view.validacao.Validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.administrativo.ContatoModel;
import model.administrativo.EnderecoModel;
import model.administrativo.EstadoModel;

/*
 * @author Jonathan
 */
public class ClienteDao implements IDao<ClienteModel>{
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ClienteDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }                        
    
    public int listarQtdClientes() throws SQLException{
        ClienteModel cm = new ClienteModel();
        String sql = "SELECT *FROM tb_cliente ORDER BY Id_Cliente DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                cm.setIdCliente(rs.getInt(1));
                break;
            }
        }
        return cm.getIdCliente();        
    }       

    @Override
    public void inserir(ClienteModel cm) throws SQLException {
        String sql = "insert into TB_CLIENTE (Nome_Cliente, Tipo_Cliente, Cpf_Cliente,Cnpj_Cliente,Status_Cliente)" + " values (?,?,?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cm.getNome());
            stmt.setString(2,cm.getTipo());
            stmt.setString(3,cm.getCpf());
            stmt.setString(4,cm.getCnpj());
            stmt.setInt(5,cm.getStatus());     
            // executa
            stmt.execute();
            stmt.close();
        }
    }

    @Override
    public void alterar(ClienteModel cliente) {
       String sql = "UPDATE TB_CLIENTE SET Nome_Cliente = ?, Tipo_Cliente = ?,Cpf_Cliente = ?, Cnpj_Cliente = ? WHERE Id_Cliente = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getTipo());
            stmt.setString(3,cliente.getCpf());
            stmt.setString(4,cliente.getCnpj());
            stmt.setInt(5,cliente.getIdCliente());        
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println("ERRO DAO CLIENTE(INSERIR)");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_CLIENTE SET Status_Cliente = ? WHERE Id_Cliente = ?";
        // prepared statement para inserção
        PreparedStatement stmt;
        try {
            stmt = c.prepareStatement(sql);
            stmt.setString(1,"0");
            stmt.setInt(2,cod);            
            // executa
            stmt.execute();
            stmt.close();            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXCLUIR CLIENTE!");
        }                        
    }

    @Override
    public List<ClienteModel> consultarTodos() {
       List<ClienteModel> clientes = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cliente, T1.Nome_cliente, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cpf_Cliente, T1.Cnpj_Cliente, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_CLIENTE T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Cliente = T2.Id_Cliente ANd T2.Id_Cliente = T3. Id_Cliente AND T1.Status_Cliente = 1 AND T3.Id_Estado = T4.Id_Estado";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ClienteModel clm = new ClienteModel();
                ContatoModel contm = new ContatoModel();
                EnderecoModel em = new EnderecoModel();
                EstadoModel estadoModel = new EstadoModel();
                clm.setIdCliente(Integer.parseInt(rs.getString(1)));
                clm.setNome(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));
                clm.setCpf(rs.getString(6));
                clm.setCnpj(rs.getString(7));                
                em.setLogradouro(rs.getString(8));
                em.setNumero(Integer.parseInt(rs.getString(9)));                
                em.setCidade(rs.getString(10));
                em.setBairro(rs.getString(11));
                estadoModel.setNomeEstado(rs.getString(12)); 
                em.setEstado(estadoModel);
                clm.setContato(contm);
                clm.setEndereco(em);                                
                clientes.add(clm);                
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERRO AO LISTAR TODOS CLIENTES");            
            System.out.println(ex.getMessage());
        }finally{                        
            return clientes;  
        }        
    }

    @Override
    public List<ClienteModel> consultarCodigo(Integer cod) {
        List<ClienteModel> clientes = new ArrayList<>();                
        ClienteModel clm = new ClienteModel();
        ContatoModel contm = new ContatoModel();
        EnderecoModel em = new EnderecoModel();
        EstadoModel estadoModel = new EstadoModel();
        String sql = "SELECT T1.Id_Cliente, T1.Nome_cliente, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cpf_Cliente, T1.Cnpj_Cliente, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_CLIENTE T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Cliente = T2.Id_Cliente ANd T2.Id_Cliente = T3. Id_Cliente AND T1.Status_Cliente = 1 AND T3.Id_Estado = T4.Id_Estado AND T1.Id_Cliente = ?";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                
                clm.setIdCliente(Integer.parseInt(rs.getString(1)));
                clm.setNome(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));
                clm.setCpf(rs.getString(6));
                clm.setCnpj(rs.getString(7));                
                em.setLogradouro(rs.getString(8));
                em.setNumero(Integer.parseInt(rs.getString(9)));                
                em.setCidade(rs.getString(10));
                em.setBairro(rs.getString(11));
                estadoModel.setNomeEstado(rs.getString(12)); 
                em.setEstado(estadoModel);
                clm.setContato(contm);
                clm.setEndereco(em);                                                
                clientes.add(clm);                
                stmt.close();
                rs.close();
            }
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR CLIENTES PELO CÓDIGO");            
            System.out.println(ex.getMessage());
        }finally{            
            return clientes; 
        }        
    }

    @Override
    public List<ClienteModel> consultarNome(String nome) {
        List<ClienteModel> clientes = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cliente, T1.Nome_cliente, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cpf_Cliente, T1.Cnpj_Cliente, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_CLIENTE T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Cliente = T2.Id_Cliente ANd T2.Id_Cliente = T3. Id_Cliente AND T1.Status_Cliente = 1 AND T3.Id_Estado = T4.Id_Estado AND T1.Nome_Cliente like ?;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ClienteModel clm = new ClienteModel();
                ContatoModel contm = new ContatoModel();
                EnderecoModel em = new EnderecoModel();
                EstadoModel estadoModel = new EstadoModel();
                clm.setIdCliente(Integer.parseInt(rs.getString(1)));
                clm.setNome(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));
                clm.setCpf(rs.getString(6));
                clm.setCnpj(rs.getString(7));                
                em.setLogradouro(rs.getString(8));
                em.setNumero(Integer.parseInt(rs.getString(9)));                
                em.setCidade(rs.getString(10));
                em.setBairro(rs.getString(11));
                estadoModel.setNomeEstado(rs.getString(12)); 
                em.setEstado(estadoModel);
                clm.setContato(contm);
                clm.setEndereco(em);                                
                clientes.add(clm);                
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR CLIENTES POR NOME!");            
            System.out.println(ex.getMessage());
        }finally{
            return clientes;        
        }        
    }
}
