package dao.administrativo;

import conexao.Conexao;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.administrativo.LembreteModel;

/*
 * @author Jonathan
 */
public class LembreteDao implements IDao<LembreteModel> {
    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public LembreteDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }        
    
    public List<LembreteModel> listarTodosLembretesDoDia() throws SQLException {    
        List<LembreteModel> lembretes = new ArrayList<>();        
        String sql = "SELECT * FROM TB_LEMBRETES WHERE DATE_FORMAT(Data_Lembrete,'%Y/%m/%d') = CURDATE() AND Status_Lembrete =1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {        
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));
                lembretes.add(lm);
            }
            rs.close();
            stmt.close();
        }                              
        return lembretes;        
    }       
                                      
    public List<LembreteModel> listarTodosLembretesData(Date inicio, Date fim) throws SQLException {    
        List<LembreteModel> lembretes = new ArrayList<>();        
        String sql = "SELECT Id_Lembrete, Data_Lembrete, Descricao_Lembrete FROM TB_LEMBRETES WHERE Status_Lembrete = 1 AND Data_Lembrete BETWEEN ? AND ?";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setDate(1,inicio);
            stmt.setDate(2,fim);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));
                lembretes.add(lm);
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO NO LISTAR POR DATAS LEMBRETES");
        }                              
        return lembretes;        
    }            
    
    public boolean verificarLembrete(){        
        String sql = "SELECT Id_Lembrete, Data_Lembrete, Descricao_Lembrete FROM TB_LEMBRETES WHERE Status_Lembrete = 1";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));                               
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO NO LISTAR POR DATAS LEMBRETES");
        }                                      
        return false;
    }

    @Override
    public void inserir(LembreteModel lm) throws SQLException {
        String sql = "INSERT INTO TB_LEMBRETES" + " (Data_Lembrete, Descricao_Lembrete, Status_Lembrete)" + " values (?,?,?)";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setDate(1,new Date(lm.getData().getTime()));
            stmt.setString(2,lm.getDescricao());            
            stmt.setInt(3, 1);
            // executa
            stmt.execute();           
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO AO INSERIR LEMBRETE");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void alterar(LembreteModel lembrete) {
        String sql = "UPDATE TB_LEMBRETES SET Data_Lembrete = ?, Descricao_Lembrete = ? WHERE Id_Lembrete = ?";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setDate(1,new Date(lembrete.getData().getTime()));
            stmt.setString(2,lembrete.getDescricao());
            stmt.setInt(3,lembrete.getIdLembrete());        
            // executa
            stmt.execute();            
            stmt.close();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_LEMBRETES SET Status_Lembrete = ? WHERE Id_Lembrete = ?";
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<LembreteModel> consultarTodos() {
        List<LembreteModel> lembretes = new ArrayList<>();        
        String sql = "SELECT Id_Lembrete, Data_Lembrete, Descricao_Lembrete FROM TB_LEMBRETES WHERE Status_Lembrete = 1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {        
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));
                lembretes.add(lm);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {                              
            System.out.println("ERRO AO LISTAR TODOS OS LEMBRETES");
            System.out.println(ex.getMessage());
        }finally{
            return lembretes;  
        }        
    }

    @Override
    public List<LembreteModel> consultarCodigo(Integer cod) {
        List<LembreteModel> lembretes = new ArrayList<>();        
        String sql = "SELECT Id_Lembrete, Data_Lembrete, Descricao_Lembrete FROM TB_LEMBRETES WHERE Status_Lembrete = 1 AND Id_Lembrete = ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));
                lembretes.add(lm);
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("ERRO AO LISTAR LEMBRETES PELO CÓDIGO");
            System.out.println(e.getMessage());
        }
        return lembretes;
    }

    @Override
    public List<LembreteModel> consultarNome(String nome) {
        List<LembreteModel> lembretes = new ArrayList<>();        
        String sql = "SELECT Id_Lembrete, Data_Lembrete, Descricao_Lembrete FROM TB_LEMBRETES WHERE Status_Lembrete = 1 AND Descricao_Lembrete LIKE ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                LembreteModel lm = new LembreteModel();
                lm.setIdLembrete(rs.getInt(1));
                lm.setData(rs.getDate(2));
                lm.setDescricao(rs.getString(3));
                lembretes.add(lm);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {                              
               System.out.println("ERRO AO LISTAR LEMBRETES PELA DESCRIÇÃO");
               System.out.println(ex.getMessage());
        }finally{
            return lembretes;  
        }        
    }    
}