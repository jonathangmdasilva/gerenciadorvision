package dao.contas;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.contas.ContasModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ContasDao {
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ContasDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastroContas(ContasModel cp) throws SQLException {
        String sql = "INSERT INTO TB_CONTAS (Numero_Conta, Valor_Conta, Emissao_Conta, Venc_Conta, Status_Conta,Tipo_Conta,Ativa_Conta, Obser_Conta)" + " values (?,?,?,?,?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cp.getNumeroConta());
            stmt.setDouble(2,cp.getValorConta());
            stmt.setDate(3,new Date(cp.getEmissaoConta().getTime()));
            stmt.setDate(4,new Date(cp.getVencimentoConta().getTime()));
            stmt.setString(5,cp.getStatus());     
            stmt.setString(6,cp.getTipo());
            stmt.setInt(7,1);
            stmt.setString(8,cp.getObservacaoConta());                             
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println("ERRO EM CONTAS");
            System.out.println(e.getMessage());            
        }
    }


    public int listarQtdContas() throws SQLException{
        Integer qtd;
        ContasModel cm = new ContasModel();
        String sql = "SELECT *FROM TB_CONTAS ORDER BY Id_Contas DESC;";        
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                cm.setIdConta(rs.getInt(1));
                break;
            }
            rs.close();
            stmt.close();
        }
        
        return cm.getIdConta();        
    }

    public void excluirCadastroContas(Integer cod) throws SQLException {
        String sql = "UPDATE TB_CONTAS SET Ativa_Conta = ? WHERE Id_Contas = ?";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"0");
            stmt.setInt(2,cod);        
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            e.getMessage();
        }
    }
               
    public void alterarCadastroContas(ContasModel contas,int cod) throws SQLException {
        String sql = "UPDATE TB_CONTAS SET Numero_Conta = ?, Valor_Conta = ?,Emissao_Conta = ?, Venc_Conta = ?, Status_Conta = ?,Obser_Conta = ? WHERE Id_Contas = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,contas.getNumeroConta());
            stmt.setDouble(2,contas.getValorConta());
            stmt.setDate(3,new Date(contas.getEmissaoConta().getTime()));
            stmt.setDate(4,new Date(contas.getVencimentoConta().getTime()));
            stmt.setString(5,contas.getStatus());
            stmt.setString(6,contas.getObservacaoConta());
            stmt.setInt(7,cod);        
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            e.getMessage();
        } 
    }
}