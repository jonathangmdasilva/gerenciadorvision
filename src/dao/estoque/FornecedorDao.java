package dao.estoque;

import conexao.Conexao;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.administrativo.ContatoModel;
import model.administrativo.EnderecoModel;
import model.administrativo.EstadoModel;
import model.estoque.FornecedorModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class FornecedorDao implements IDao<FornecedorModel>{
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public FornecedorDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }         
    
    public int listarCodigoFornecedor(String razao) throws SQLException {   
        int codigo = 0;
        String sql = "SELECT Id_Fornecedor  FROM TB_FORNECEDOR WHERE Razao_Social_Forn = ?";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,razao);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                         
                codigo  = rs.getInt(1);                
                return codigo;
            }
            stmt.close();
            rs.close();
        }                
        return codigo;
    }           
    
    public int listarQtdFornecedores() throws SQLException{
        Integer qtd;
        FornecedorModel fm = new FornecedorModel();
        String sql = "SELECT *FROM TB_FORNECEDOR ORDER BY Id_Fornecedor DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                fm.setIdFornecedor(rs.getInt(1));
                break;
            }
            stmt.close();
            rs.close();
        }
        return fm.getIdFornecedor();
    }      
    
    public List<FornecedorModel> listarRzaoFornecedores() throws SQLException {   
        List<FornecedorModel> fornecedores = new ArrayList<>();        
        String sql = "SELECT Razao_Social_Forn FROM TB_FORNECEDOR WHERE Status_Forn =1";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                FornecedorModel flm = new FornecedorModel();
                flm.setRazaoSocial(rs.getString(1));
                fornecedores.add(flm);
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.getMessage();
            System.out.println("ERRO AO LISTAR RAZÃO FORNECEDOR");
        }finally{
            return fornecedores;        
        }                        
    }    

    @Override
    public void inserir(FornecedorModel fm) throws SQLException {
        String sql = "INSERT INTO TB_FORNECEDOR (Razao_Social_Forn, Cnpj_Forn, Status_Forn)" + " values (?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,fm.getRazaoSocial());
            stmt.setString(2,fm.getCnpj());
            stmt.setInt(3,fm.getStatus());     
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){                      
            System.out.println("ERRO NO FORNECEDOR");
        }
    }

    @Override
    public void alterar(FornecedorModel fornecedor) {
        String sql = "UPDATE TB_FORNECEDOR SET Razao_Social_Forn = ?, Cnpj_Forn = ? WHERE Id_Fornecedor = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,fornecedor.getRazaoSocial());
            stmt.setString(2,fornecedor.getCnpj());            
            stmt.setInt(3,fornecedor.getIdFornecedor());        
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            e.getMessage();
            System.out.println("ERRO AO ALTERAR FORNECEDOR");
        }
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_FORNECEDOR SET Status_Forn = ? WHERE Id_Fornecedor = ?";
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
            System.out.println("ERRO AO EXCLUIR FORNECEDOR!");
            System.out.println(ex.getMessage());            
        }       
    }

    @Override
    public List<FornecedorModel> consultarTodos() {
        List<FornecedorModel> fornecedores = new ArrayList<>();        
        String sql = "SELECT T1.Id_Fornecedor, T1.Razao_Social_Forn, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cnpj_Forn, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_FORNECEDOR T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Fornecedor = T2.Id_Fornecedor ANd T2.Id_Fornecedor = T3. Id_Fornecedor AND T1.Status_Forn = 1 AND T3.Id_Estado = T4.Id_Estado";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                FornecedorModel flm = new FornecedorModel();
                ContatoModel contm = new ContatoModel();
                EnderecoModel em = new EnderecoModel();
                EstadoModel estadoModel = new EstadoModel();                
                flm.setIdFornecedor(Integer.parseInt(rs.getString(1)));
                flm.setRazaoSocial(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));        
                flm.setCnpj(rs.getString(6));                                
                em.setLogradouro(rs.getString(7));
                em.setNumero(Integer.parseInt(rs.getString(8)));                
                em.setCidade(rs.getString(9));
                em.setBairro(rs.getString(10));
                estadoModel.setNomeEstado(rs.getString(11)); 
                em.setEstado(estadoModel);
                flm.setContato(contm);
                flm.setEndereco(em);                                
                fornecedores.add(flm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR TODOS FORNECEDORES!");
            System.out.println(ex.getMessage());           
        }finally{
            return fornecedores;  
        }        
    }

    @Override
    public List<FornecedorModel> consultarCodigo(Integer cod) {
        List<FornecedorModel> fornecedores = new ArrayList<>();                
        FornecedorModel flm = new FornecedorModel();
        ContatoModel contm = new ContatoModel();
        EnderecoModel em = new EnderecoModel();
        EstadoModel estadoModel = new EstadoModel();
        String sql = "SELECT T1.Id_Fornecedor, T1.Razao_Social_Forn, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cnpj_Forn, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_FORNECEDOR T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Fornecedor = T2.Id_Fornecedor ANd T2.Id_Fornecedor = T3. Id_Fornecedor AND T1.Status_Forn = 1 AND T3.Id_Estado = T4.Id_Estado AND T1.Id_Fornecedor = ?";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                flm.setIdFornecedor(Integer.parseInt(rs.getString(1)));
                flm.setRazaoSocial(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));        
                flm.setCnpj(rs.getString(6));                                
                em.setLogradouro(rs.getString(7));
                em.setNumero(Integer.parseInt(rs.getString(8)));                
                em.setCidade(rs.getString(9));
                em.setBairro(rs.getString(10));
                estadoModel.setNomeEstado(rs.getString(11)); 
                em.setEstado(estadoModel);
                flm.setContato(contm);
                flm.setEndereco(em);                                
                fornecedores.add(flm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                            
            System.out.println("ERRO AO LISTAR FORNECEDOR PELO CÓDIGO!");
            System.out.println(ex.getMessage());            
        }finally{
            return fornecedores;
        }        
    }

    @Override
    public List<FornecedorModel> consultarNome(String nome) {
        List<FornecedorModel> fornecedores = new ArrayList<>();        
        String sql = "SELECT T1.Id_Fornecedor, T1.Razao_Social_Forn, T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato, T1.Cnpj_Forn, T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_FORNECEDOR T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Fornecedor = T2.Id_Fornecedor ANd T2.Id_Fornecedor = T3. Id_Fornecedor AND T1.Status_Forn = 1 AND T3.Id_Estado = T4.Id_Estado AND T1.Razao_Social_Forn like ?";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
            FornecedorModel flm = new FornecedorModel();
                ContatoModel contm = new ContatoModel();
                EnderecoModel em = new EnderecoModel();
                EstadoModel estadoModel = new EstadoModel();                
                flm.setIdFornecedor(Integer.parseInt(rs.getString(1)));
                flm.setRazaoSocial(rs.getString(2));
                contm.setEmail(rs.getString(3));
                contm.setTelUm(rs.getString(4));
                contm.setTelDois(rs.getString(5));        
                flm.setCnpj(rs.getString(6));                                
                em.setLogradouro(rs.getString(7));
                em.setNumero(Integer.parseInt(rs.getString(8)));                
                em.setCidade(rs.getString(9));
                em.setBairro(rs.getString(10));
                estadoModel.setNomeEstado(rs.getString(11)); 
                em.setEstado(estadoModel);
                flm.setContato(contm);
                flm.setEndereco(em);                                
                fornecedores.add(flm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR FORNECEDOR PELO CÓDIGO");
            System.out.println(ex.getMessage());            
        }
        return fornecedores;
    }    
}