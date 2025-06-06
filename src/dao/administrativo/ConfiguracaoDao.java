package dao.administrativo;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.administrativo.ConfiguracaoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class ConfiguracaoDao{
    
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ConfiguracaoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }         
                         
    public void inserir(ConfiguracaoModel cm) throws SQLException {
        String sql = "INSERT INTO TB_CONFIGURACAO_SISTEMA (Id_Empresa, Admin_Config, Estoque_Config,Financeiro_Config,Lembretes_Config,Vendas_Config)" + " values (?,?,?,?,?,?)";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,cm.getIdEmpresa());
            stmt.setInt(2,cm.getAdm());
            stmt.setInt(3,cm.getEstoque());
            stmt.setInt(4,cm.getFinanceiro());
            stmt.setInt(5,cm.getLembrete());
            stmt.setInt(6,cm.getVendas()); 
            stmt.execute();
            stmt.close();           
            // executa         
        }catch(Exception e){                      
            System.out.println("ERRO AO INSERIR CONFIGURAÇÃO");
            System.out.println(e.getMessage());
        }
    }

    public ConfiguracaoModel retornaConfiguracao() throws SQLException{    
        ConfiguracaoModel config = new ConfiguracaoModel();
        String sql = "SELECT Admin_Config, Estoque_Config,Financeiro_Config,Lembretes_Config,Vendas_Config FROM TB_CONFIGURACAO_SISTEMA";        
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            // executa            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {                
                // criando o objeto configuração
                config.setAdm(rs.getInt(1));
                config.setEstoque(rs.getInt(2));
                config.setFinanceiro(rs.getInt(3));
                config.setLembrete(rs.getInt(4));
                config.setVendas(rs.getInt(5));                
            }            
             rs.close();
             stmt.close();
        }catch(Exception e){ 
            System.out.println("ERRO NA BUSCAR CONFIGURAÇÕES");
            System.out.println(e.getMessage());
        }
        return config;
    }           
}