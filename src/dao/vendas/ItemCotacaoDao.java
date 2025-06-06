package dao.vendas;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.estoque.ProdutoModel;
import model.vendas.ItemPedidoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ItemCotacaoDao {
        
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ItemCotacaoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
         
    public void inserirCadastro(ItemPedidoModel itemPedido) throws SQLException {
        String sql = "INSERT INTO TB_ASSOC_ITEM_COTACAO(Id_Cotacao,Id_Produto,Qtd_Item_Cotacao,Preco_Item_Cotacao,Total_Item_Cotacao)"+ "VALUES(?,?,?,?,?)";
        // seta os valores
        try ( 
            //prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,itemPedido.getIdPedido());
            stmt.setInt(2,itemPedido.getIdProduto());
            stmt.setDouble(3,itemPedido.getQtd());            
            stmt.setDouble(4,itemPedido.getValorUnitario());
            stmt.setDouble(5,itemPedido.getValorTotal());                    
            // executa
            stmt.execute();                              
            stmt.close();            
        }catch(Exception e ){
            e.getMessage();
            System.out.println("ERRO AO INSERIR LISTA ITEM DA COTAÇÃO");
        }
    }
    
    public List<ItemPedidoModel> listarItensCotacao(Integer codigoPedido) throws SQLException {           
        List<ItemPedidoModel> itens = new ArrayList<>();                        
        String sql = "SELECT T1.Id_Produto, T2.Descricao_Produto, T1.Qtd_Item_Cotacao,T1.Preco_Item_Cotacao,T1.Total_Item_Cotacao FROM TB_ASSOC_ITEM_COTACAO T1, TB_PRODUTO T2 WHERE T1.Id_Produto = T2.Id_Produto AND T1.Id_Cotacao = ?;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {            
            stmt.setInt(1,codigoPedido);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                
                ItemPedidoModel item = new ItemPedidoModel();
                ProdutoModel produto = new ProdutoModel();                                
                item.setIdProduto(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
                item.setQtd(rs.getDouble(3));
                item.setValorUnitario(rs.getDouble(4));
                item.setValorTotal(rs.getDouble(5));
                item.setProduto(produto);
                itens.add(item);                
            }
            rs.close();
            stmt.close();
        } catch(Exception e){            
            JOptionPane.showMessageDialog(null,"Erro no Dao Cotação" + e.getMessage());
        }               
        return itens;        
    }   
}