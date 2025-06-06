package dao.contas;

import conexao.Conexao;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.contas.ContasReceberModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ContasReceberDao implements IDao<ContasReceberModel>{

    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ContasReceberDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }         
    
    public List<ContasReceberModel> listarTodasContasReceberStatus(String nome) throws SQLException {    
        List<ContasReceberModel> contasReceber = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Rec, T1.Sacado_Cont_Rec, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_RECEBER T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T2.Status_Conta LIKE ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(rs.getInt(1));
                crm.setSacado(rs.getString(2));
                crm.setNumeroConta(rs.getString(3));
                crm.setValorConta(Double.parseDouble(rs.getString(4)));
                crm.setEmissaoConta(rs.getDate(5));
                crm.setVencimentoConta(rs.getDate(6));
                crm.setStatus(rs.getString(7));
                crm.setObservacaoConta(rs.getString(8));                
                contasReceber.add(crm);
            }
            stmt.close();
            rs.close();
        }                              
        return contasReceber;        
    }    

    public List<ContasReceberModel> listarTodasPeriodoVenc(Date inicio, Date fim) throws SQLException {    
        List<ContasReceberModel> contasReceber = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Rec, T1.Sacado_Cont_Rec, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_RECEBER T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 and T2.Venc_Conta between ? and ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setDate(1,inicio);
            stmt.setDate(2,fim);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(Integer.parseInt(rs.getString(1)));
                crm.setSacado(rs.getString(2));
                crm.setNumeroConta(rs.getString(3));
                crm.setValorConta(Double.parseDouble(rs.getString(4)));
                crm.setEmissaoConta(rs.getDate(5));
                crm.setVencimentoConta(rs.getDate(6));
                crm.setStatus(rs.getString(7));
                crm.setObservacaoConta(rs.getString(8));
                contasReceber.add(crm);
            }
            stmt.close();
            rs.close();
        }                              
        return contasReceber;        
    }        

    public Boolean existeContaReceberVencida() throws SQLException {    
        Boolean decisao = false;
        //List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT Id_Contas FROM TB_CONTAS WHERE DATE_FORMAT(Venc_Conta,'%Y/%m/%d') <= CURDATE() AND Tipo_Conta = 'RECEBER' AND Status_Conta = 'ABERTO' AND Ativa_Conta = 1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(rs.getInt(1));
                if (crm.getIdConta()!=null) {                
                    decisao = true;
                    break;
                }else if(crm.getIdConta()==null){
                    decisao = false;                    
                    break;
                }                
            }
            stmt.close();
            rs.close();
        }                              
        return decisao;        
    }    
    
    public int recuperarIdContas(ContasReceberModel pag) throws SQLException{       
        Integer cod = null;        
        String sql = "SELECT Id_Contas FROM TB_CONTA_RECEBER WHERE Id_Cont_Rec = ?";
        // seta os valores
        try ( 
           PreparedStatement stmt = this.c.prepareStatement(sql)) {                       
           stmt.setInt(1,pag.getIdConta());
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                cod = rs.getInt(1);
                break;
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.getMessage();
            System.out.println("Erro no recuperar Id contas");        
        }
        return cod;                
    }    

    @Override
    public void inserir(ContasReceberModel cr) throws SQLException {
        String sql = "INSERT INTO TB_CONTA_RECEBER (Sacado_Cont_Rec, Id_Contas)" + " values (?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cr.getSacado());            
            stmt.setInt(2,cr.getIdConta());                             
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e ){
            e.getMessage();
            System.out.println("ERRO AO RECEBER");
        }
    }

    @Override
    public void alterar(ContasReceberModel receber) {
        String sql = "UPDATE TB_CONTA_RECEBER SET Sacado_Cont_Rec = ? WHERE Id_Cont_Rec = ?";        
        try ( 
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,receber.getSacado());
            stmt.setInt(2,receber.getIdConta());
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){
            System.out.println(e.getMessage());            
            System.out.println("ERRO NO CONTAS A RECEBER DAO");
        }
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_CONTAS SET Ativa_Conta = ? WHERE Id_Conta = ?";
        // seta os valores
        try ( // prepared statement para inserção
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

    @Override
    public List<ContasReceberModel> consultarTodos() {
        List<ContasReceberModel> contasReceber = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Rec, T1.Sacado_Cont_Rec, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_RECEBER T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(Integer.parseInt(rs.getString(1)));
                crm.setSacado(rs.getString(2));
                crm.setNumeroConta(rs.getString(3));
                crm.setValorConta(Double.parseDouble(rs.getString(4)));
                crm.setEmissaoConta(rs.getDate(5));
                crm.setVencimentoConta(rs.getDate(6));
                crm.setStatus(rs.getString(7));
                crm.setObservacaoConta(rs.getString(8)); 
                contasReceber.add(crm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            ex.getMessage();
            System.out.println("ERRO AO LISTAR TODAS CONTAS A RECEBER");
        }
        return contasReceber;        
    }

    @Override
    public List<ContasReceberModel> consultarCodigo(Integer cod) {
        List<ContasReceberModel> contasReceber = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Rec, T1.Sacado_Cont_Rec, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_RECEBER T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T1.Id_Cont_Rec = ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(Integer.parseInt(rs.getString(1)));
                crm.setSacado(rs.getString(2));
                crm.setNumeroConta(rs.getString(3));
                crm.setValorConta(Double.parseDouble(rs.getString(4)));
                crm.setEmissaoConta(rs.getDate(5));
                crm.setVencimentoConta(rs.getDate(6));
                crm.setStatus(rs.getString(7));
                crm.setObservacaoConta(rs.getString(8)); 
                contasReceber.add(crm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            ex.getMessage();
            System.out.println("ERRO AO LISTAR CONTAS E RECEBER PELO CÓDIGO!");
        }
        return contasReceber;        
    }

    @Override
    public List<ContasReceberModel> consultarNome(String nome) {
       List<ContasReceberModel> contasReceber = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Rec, T1.Sacado_Cont_Rec, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_RECEBER T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T1.Sacado_Cont_Rec LIKE ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasReceberModel crm = new ContasReceberModel();
                crm.setIdConta(Integer.parseInt(rs.getString(1)));
                crm.setSacado(rs.getString(2));
                crm.setNumeroConta(rs.getString(3));
                crm.setValorConta(Double.parseDouble(rs.getString(4)));
                crm.setEmissaoConta(rs.getDate(5));
                crm.setVencimentoConta(rs.getDate(6));
                crm.setStatus(rs.getString(7));
                crm.setObservacaoConta(rs.getString(8)); 
                contasReceber.add(crm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            System.out.println(ex.getMessage());
            System.out.println("ERRO AO LISTAR CONTAS A RECEBER PELO CEDENTE!");
        }
        return contasReceber;        
    }   
}