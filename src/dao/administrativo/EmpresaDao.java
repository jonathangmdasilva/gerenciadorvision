package dao.administrativo;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.administrativo.ContatoModel;
import model.administrativo.EmpresaModel;
import model.administrativo.EnderecoModel;
import model.administrativo.EstadoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class EmpresaDao{
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public EmpresaDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }                 
    
    public void inserir(EmpresaModel em) throws SQLException {
        String sql = "INSERT INTO TB_EMPRESA (Razao_Empresa, Cnpj_Empresa, Incri_Esta_Empresa)" + " values (?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,em.getRazaoSocial());
            stmt.setString(2,em.getCnpj());
            stmt.setString(3,em.getInscricaoEstadual());     
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){                                  
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar empresa: " + e.getMessage(),"Erro de inserção",JOptionPane.ERROR_MESSAGE);            
        }
    }

    public boolean validaEmpresa() throws SQLException{
        Integer codigo = 0;
        boolean v = false;
        String sql = "SELECT Id_Empresa FROM TB_EMPRESA";        
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            // executa            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){                                
                codigo = rs.getInt(1);
                break;                
            }
            v = codigo != 0;
            stmt.close();
            rs.close();
            if(v){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null,"Erro ao buscar empresa: " + e.getMessage(),"Erro de busca",JOptionPane.ERROR_MESSAGE);            
        }
        return v;
    }   

    public EmpresaModel consultarEmpresa() throws SQLException {
        EmpresaModel empresa = new EmpresaModel();
        ContatoModel contato = new ContatoModel();
        EnderecoModel ende = new EnderecoModel();
        EstadoModel estado = new EstadoModel();        
        String sql = "SELECT T1.Razao_Empresa,T1.Cnpj_Empresa,T1.Incri_Esta_Empresa,T2.Email_Contato, T2.Tel_Um_Contato, T2.Tel_Dois_Contato,  T3.Logradouro_End, T3.Num_End, T3.Cidade_End, T3.Bairro_End, T4.Nome_Estado FROM TB_EMPRESA T1, TB_CONTATO T2 , TB_ENDERECO T3, TB_ESTADO T4 WHERE T1.Id_Empresa = T2.Id_Empresa ANd T2.Id_Empresa = T3. Id_Empresa AND T3.Id_Estado = T4.Id_Estado AND T1.Id_Empresa = ?;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,1);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                
                
                empresa.setRazaoSocial(rs.getString(1));
                empresa.setCnpj(rs.getString(2));
                empresa.setInscricaoEstadual(rs.getString(3));
                
                contato.setEmail(rs.getString(4));
                contato.setTelUm(rs.getString(5));
                contato.setTelDois(rs.getString(6));
                
                empresa.setContato(contato);
                
                ende.setLogradouro(rs.getString(7));
                ende.setNumero(rs.getInt(8));
                ende.setCidade(rs.getString(9));
                ende.setBairro(rs.getString(10));
                
                estado.setNomeEstado(rs.getString(11));                
                ende.setEstado(estado);                                
                empresa.setEndereco(ende);                
            }
            stmt.close();
            rs.close();
        }       
        return empresa;
    }        
}