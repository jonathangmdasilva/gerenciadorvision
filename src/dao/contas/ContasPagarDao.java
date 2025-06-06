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
import model.contas.ContasPagarModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ContasPagarDao implements IDao<ContasPagarModel>{
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ContasPagarDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
                     

    public Boolean existeContaPagarVencida() throws SQLException {    
        Boolean decisao = false;   
        String sql = "SELECT Id_Contas FROM TB_CONTAS WHERE DATE_FORMAT(Venc_Conta,'%Y/%m/%d') <= CURDATE() AND Tipo_Conta = 'PAGAR' AND Status_Conta = 'ABERTO' AND Ativa_Conta = 1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(rs.getInt(1));
                if (cpm.getIdConta()!=null) {                
                    decisao = true;
                    break;
                }else if (cpm.getCedente().isEmpty()){                    
                    decisao = false;
                    break;
                } else {
                }                
            }
            stmt.close();
            rs.close();
        }        
        return decisao;        
    }                    
    
    public List<ContasPagarModel> listarTodasContasPagarStatus(String nome) throws SQLException {    
        List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Pag, T1.Cedente_Cont_Pag, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_PAGAR T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T2.Status_Conta LIKE ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(rs.getInt(1));
                cpm.setCedente(rs.getString(2));
                cpm.setNumeroConta(rs.getString(3));
                cpm.setValorConta(Double.parseDouble(rs.getString(4)));
                cpm.setEmissaoConta(rs.getDate(5));
                cpm.setVencimentoConta(rs.getDate(6));
                cpm.setStatus(rs.getString(7));
                cpm.setObservacaoConta(rs.getString(8));                
                contasPagar.add(cpm);
            }
            stmt.close();
            rs.close();
        }                              
        return contasPagar;        
    }            
          

    public List<ContasPagarModel> listarTodasPeriodoVenc(Date inicio, Date fim) throws SQLException {    
        List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Pag, T1.Cedente_Cont_Pag, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_PAGAR T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 and T2.Venc_Conta between ? and ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setDate(1,inicio);
            stmt.setDate(2,fim);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(Integer.parseInt(rs.getString(1)));
                cpm.setCedente(rs.getString(2));
                cpm.setNumeroConta(rs.getString(3));
                cpm.setValorConta(Double.parseDouble(rs.getString(4)));
                cpm.setEmissaoConta(rs.getDate(5));
                cpm.setVencimentoConta(rs.getDate(6));
                cpm.setStatus(rs.getString(7));
                cpm.setObservacaoConta(rs.getString(8));
                contasPagar.add(cpm);
            }
            stmt.close();
            rs.close();
        }                              
        return contasPagar;        
    }        
    
    public int recuperarIdContas(ContasPagarModel pag) throws SQLException{       
        Integer cod = null;        
        String sql = "SELECT Id_Contas FROM TB_CONTA_PAGAR WHERE Id_Cont_Pag = ?";
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
    public void inserir(ContasPagarModel cp) throws SQLException {
        String sql = "INSERT INTO TB_CONTA_PAGAR (Cedente_Cont_Pag, Id_Contas)" + " values (?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,cp.getCedente());            
            stmt.setInt(2,cp.getIdConta());                             
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println("ERRO NO PAGAR");
            e.getMessage();
        }
    }

    @Override
    public void alterar(ContasPagarModel pagar) {
        String sql = "UPDATE TB_CONTA_PAGAR SET Cedente_Cont_Pag = ? WHERE Id_Cont_Pag = ?";        
        try ( 
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,pagar.getCedente());
            stmt.setInt(2,pagar.getIdConta());
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){
            e.getMessage();
            System.out.println("ERRO NO CONTAS A PAGAR DAO");
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
    public List<ContasPagarModel> consultarTodos() {
        List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Pag, T1.Cedente_Cont_Pag, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_PAGAR T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(Integer.parseInt(rs.getString(1)));
                cpm.setCedente(rs.getString(2));
                cpm.setNumeroConta(rs.getString(3));
                cpm.setValorConta(Double.parseDouble(rs.getString(4)));
                cpm.setEmissaoConta(rs.getDate(5));
                cpm.setVencimentoConta(rs.getDate(6));
                cpm.setStatus(rs.getString(7));
                cpm.setObservacaoConta(rs.getString(8));
                contasPagar.add(cpm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            ex.getMessage();
            System.out.println("ERRO AO LISTAR TODAS CONTAS A PAGAR");
        }finally{
            return contasPagar; 
        }        
    }

    @Override
    public List<ContasPagarModel> consultarCodigo(Integer cod) {
        List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Pag, T1.Cedente_Cont_Pag, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_PAGAR T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T1.Id_Cont_Pag = ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(Integer.parseInt(rs.getString(1)));
                cpm.setCedente(rs.getString(2));
                cpm.setNumeroConta(rs.getString(3));
                cpm.setValorConta(Double.parseDouble(rs.getString(4)));
                cpm.setEmissaoConta(rs.getDate(5));
                cpm.setVencimentoConta(rs.getDate(6));
                cpm.setStatus(rs.getString(7));
                cpm.setObservacaoConta(rs.getString(8));
                contasPagar.add(cpm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            ex.getMessage();
            System.out.println("ERRO AO LISTAR LEMBRETES PELO CÓDIGO");
        }finally{
            return contasPagar;        
        }        
    }

    @Override
    public List<ContasPagarModel> consultarNome(String nome) {
        List<ContasPagarModel> contasPagar = new ArrayList<>();        
        String sql = "SELECT T1.Id_Cont_Pag, T1.Cedente_Cont_Pag, T2. Numero_Conta, T2.Valor_Conta, T2.Emissao_Conta, T2.Venc_Conta, T2.Status_Conta, T2.Obser_Conta  FROM TB_CONTA_PAGAR T1, TB_CONTAS T2 WHERE T1.Id_Contas = T2.Id_Contas and T2.Ativa_Conta = 1 AND T1.Cedente_Cont_Pag LIKE ?";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ContasPagarModel cpm = new ContasPagarModel();
                cpm.setIdConta(rs.getInt(1));
                cpm.setCedente(rs.getString(2));
                cpm.setNumeroConta(rs.getString(3));
                cpm.setValorConta(Double.parseDouble(rs.getString(4)));
                cpm.setEmissaoConta(rs.getDate(5));
                cpm.setVencimentoConta(rs.getDate(6));
                cpm.setStatus(rs.getString(7));
                cpm.setObservacaoConta(rs.getString(8));                
                contasPagar.add(cpm);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                              
            ex.getMessage();
            System.out.println("ERRO AO LISTAR CONTAS A PAGAR OELO CEDENTE");
        }finally{
            return contasPagar;            
        }        
    }
}