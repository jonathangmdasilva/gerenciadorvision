package dao.administrativo;

import conexao.Conexao;
import model.administrativo.EnderecoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.administrativo.ClienteModel;
import model.estoque.FornecedorModel;

/**
 * @author Jonathan
 */
public class EnderecoDao {

    private final Connection c;

    //DEFININDO CONSTRUTOR DA CLASSE    
    public EnderecoDao() throws SQLException, ClassNotFoundException {
        this.c = new Conexao().getConnection();
    }

    public void inserirCadastroCliente(EnderecoModel em) throws SQLException {
        String sql = "insert into TB_ENDERECO" + " (Logradouro_End, Num_End, Bairro_End,Cidade_End,Id_Estado,Id_Cliente)" + " values (?,?,?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, em.getLogradouro());
            stmt.setInt(2, em.getNumero());
            stmt.setString(3, em.getBairro());
            stmt.setString(4, em.getCidade());
            stmt.setInt(5, em.getIdEstado());
            stmt.setInt(6, em.getIdCliente());
            // executa
            stmt.execute();
            stmt.close();            
        }
    }

    public int listarQtdEndereco() throws SQLException {       
        EnderecoModel em = new EnderecoModel();
        String sql = "SELECT *FROM tb_endereco ORDER BY Id_end DESC;";
        // seta os valores
        try (
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            // executa
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                em.setIdEndereco(rs.getInt(1));
                break;
            }
             rs.close();
             stmt.close();
        }
        return em.getIdEndereco();
    }

    public void alterarEnderecoCliente(ClienteModel cliente) throws SQLException {
        String sql = "UPDATE TB_ENDERECO SET Logradouro_End = ?, Num_End = ?, Bairro_End = ?, Cidade_End = ?, Id_Estado = ? WHERE Id_Cliente = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, cliente.getEndereco().getLogradouro());
            stmt.setInt(2, cliente.getEndereco().getNumero());
            stmt.setString(3, cliente.getEndereco().getBairro());
            stmt.setString(4, cliente.getEndereco().getCidade());
            stmt.setInt(5, cliente.getEndereco().getEstado().getIdEstado());
            stmt.setString(6, cliente.getIdCliente().toString());
            // executa
            stmt.execute();
            stmt.close();
        }
    }

    public int consultarIdEnderecoCliente(Integer idCliente) throws SQLException {
        Integer id = null;        
        String sql = "SELECT Id_End from TB_ENDERECO WHERE Id_Cliente = ?;";
        try (
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                break;
            }
            rs.close();
            stmt.close();
        }
        return id;
    }

    //FORNECEDOR X ENDEREÇO
    public void inserirCadastroFornecedor(EnderecoModel em) throws SQLException {
        String sql = "insert into TB_ENDERECO" + " (Logradouro_End, Num_End, Bairro_End,Cidade_End,Id_Estado,Id_Fornecedor)" + " values (?,?,?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, em.getLogradouro());
            stmt.setInt(2, em.getNumero());
            stmt.setString(3, em.getBairro());
            stmt.setString(4, em.getCidade());
            stmt.setInt(5, em.getIdEstado());
            stmt.setInt(6, em.getIdFornecedor());
            // executa
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR CADASTRO FORNECEDOR");
            System.out.println(e.getMessage());
        }
    }    

    public void alterarEnderecoFornecedor(FornecedorModel fornecedor) throws SQLException {
        String sql = "UPDATE TB_ENDERECO SET Logradouro_End = ?, Num_End = ?, Bairro_End = ?, Cidade_End = ?, Id_Estado = ? WHERE Id_Fornecedor = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, fornecedor.getEndereco().getLogradouro());
            stmt.setInt(2, fornecedor.getEndereco().getNumero());
            stmt.setString(3, fornecedor.getEndereco().getBairro());
            stmt.setString(4, fornecedor.getEndereco().getCidade());
            stmt.setInt(5, fornecedor.getEndereco().getEstado().getIdEstado());
            stmt.setString(6, fornecedor.getIdFornecedor().toString());
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO AO ATUALIZAR FORNECEDOR");
            System.out.println(e.getMessage());
        }
    }

    public int consultarIdEnderecoFornecedor(Integer idFornecedor) throws SQLException {
        Integer id = null;    
        String sql = "SELECT Id_End from TB_ENDERECO WHERE Id_Fornecedor = ?;";
        try (
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                break;
            }
            stmt.close();
            rs.close();
        }
        return id;
    }
    
    public void inserirCadastroEmpresa(EnderecoModel em) throws SQLException {
        String sql = "INSERT INTO TB_ENDERECO (Logradouro_End, Num_End, Bairro_End,Cidade_End,Id_Estado,Id_Empresa)" + " values (?,?,?,?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1, em.getLogradouro());
            stmt.setInt(2, em.getNumero());
            stmt.setString(3, em.getBairro());
            stmt.setString(4, em.getCidade());
            stmt.setInt(5, em.getIdEstado());
            stmt.setInt(6, em.getIdEmpresa());
            // executa
            stmt.execute();
            stmt.close();            
        } catch (Exception e) {            
            System.out.println("ERRO AO INSERIR ENDEREÇO EMPRESA");
            System.out.println(e.getMessage());
        }
    }    
    
    public int consultarIdEnderecoEmpresa(Integer idEmpresa) throws SQLException {
        Integer id = null;        
        String sql = "SELECT Id_End from TB_ENDERECO WHERE Id_Empresa = ?;";
        try (
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                break;
            }
            rs.close();
            stmt.close();
        }
        return id;
    }       
}