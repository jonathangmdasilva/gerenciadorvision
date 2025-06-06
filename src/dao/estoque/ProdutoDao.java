package dao.estoque;

import conexao.Conexao;
import interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.estoque.CategoriaModel;
import model.estoque.FornecedorModel;
import model.estoque.LucroProdutoModel;
import model.estoque.ProdutoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class ProdutoDao implements IDao<ProdutoModel>{
    Validar validar = new Validar();    
    private final Connection c ;
    
    //DEFININDO CONSTRUTOR DA CLASSE    
    public ProdutoDao() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }
        
    public List<ProdutoModel> listarTodosProdutosSku(String sku) throws SQLException {   
        List<ProdutoModel> produtos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Produto, T1.Descricao_Produto, T1.Sku_Produto, T1.Min_Produto,T1.Max_Produto, T2.Valor_Compra, T2.Valor_Venda, T2.Lucro_Produto,T2.Margem_Lucro,T3.Descricao_Cat_Prod,T5.Saldo_Produto, T4.Razao_Social_Forn FROM TB_PRODUTO T1, TB_LUCRO_PRODUTO T2, TB_CATEGORIA_PRODUTO T3, TB_FORNECEDOR T4, TB_ESTOQUE_SALDO T5 WHERE T1.Id_Lucro = T2.Id_Lucro AND T1.Id_Cat_Produto = T3.Id_Cat_Prod AND T1.Id_Fornecedor = T4.Id_Fornecedor AND T1.Id_Produto = T5.Id_Produto AND T1.Status_Produto =1 AND T1.Sku_Produto like ?;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + sku + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 

                ProdutoModel prodModel = new ProdutoModel();                
                LucroProdutoModel lucroModel = new LucroProdutoModel();               
                CategoriaModel categoriaModel = new CategoriaModel();
                FornecedorModel forncedorModel = new FornecedorModel();

                prodModel.setIdProduto(rs.getInt(1));
                prodModel.setDescricao(rs.getString(2));
                prodModel.setSku(rs.getString(3));
                prodModel.setMinimo(rs.getInt(4));
                prodModel.setMaximo(rs.getInt(5));        
                                
                lucroModel.setValorCompra(rs.getDouble(6));
                lucroModel.setValorVenda(rs.getDouble(7));
                lucroModel.setLucro(rs.getDouble(8));
                lucroModel.setMargem(rs.getDouble(9));
                
                categoriaModel.setDescricao(rs.getString(10));                 
                prodModel.setSaldo(rs.getDouble(11));        
                forncedorModel.setRazaoSocial(rs.getString(12));
                
                prodModel.setCategoria(categoriaModel);
                prodModel.setFornecedor(forncedorModel);                
                prodModel.setLucro(lucroModel);
                                
                produtos.add(prodModel);
            }
            stmt.close();
            rs.close();
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }                
        return produtos;        
    }    
                
    
    public ProdutoModel listarProdutoCodigoMovimentar(Integer codigo) throws SQLException {                   
        String sql = "SELECT Id_Produto,Descricao_Produto,Sku_Produto FROM TB_PRODUTO WHERE Status_Produto =1 AND Id_Produto =?;";                                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                ProdutoModel prodModel = new ProdutoModel();                
                prodModel.setIdProduto(Integer.parseInt(rs.getString(1)));
                prodModel.setDescricao(rs.getString(2));
                prodModel.setSku(rs.getString(3));                    
                return prodModel;
            }
            stmt.close();
            rs.close();
        }                
        return null;
    }     

    @Override
    public void inserir(ProdutoModel pm) throws SQLException {
        String sql = "INSERT INTO TB_PRODUTO (Descricao_Produto,Sku_Produto,Min_Produto,Max_Produto,Status_Produto,Id_Cat_Produto,Id_Lucro,Id_Fornecedor)VALUES (?,?,?,?,?,?,?,?);";
        // seta os valores
        try ( // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,pm.getDescricao());
            stmt.setString(2,pm.getSku());
            stmt.setInt(3,pm.getMinimo());     
            stmt.setInt(4,pm.getMaximo());
            stmt.setInt(5,pm.getStatus());
            stmt.setInt(6,pm.getCategoria().getIdCategoria());     
            stmt.setInt(7,pm.getLucro().getIdLucro());
            stmt.setInt(8,pm.getFornecedor().getIdFornecedor());
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e){ 
            System.out.println("ERRO AO INSERIR PRODUTO");
            e.getMessage();            
        }
    }

    @Override
    public void alterar(ProdutoModel produto) {
        String sql = "UPDATE TB_PRODUTO SET Descricao_Produto = ?, Sku_Produto = ?, Min_Produto = ?, Max_Produto = ?, Id_Cat_Produto = ?, Id_Lucro = ?, Id_Fornecedor = ? WHERE Id_Produto = ?;";
        // seta os valores
        try ( 
            // prepared statement para inserção
            PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,produto.getDescricao());
            stmt.setString(2,produto.getSku());            
            stmt.setDouble(3,produto.getMinimo());        
            stmt.setDouble(4,produto.getMaximo());        
            stmt.setInt(5,produto.getCategoria().getIdCategoria());        
            stmt.setInt(6,produto.getLucro().getIdLucro());        
            stmt.setInt(7,produto.getFornecedor().getIdFornecedor());        
            stmt.setInt(8,produto.getIdProduto());        
            // executa
            stmt.execute();
            stmt.close();
        }catch(Exception e ){
            System.out.println("ERRO AO ALTERAR PRODUTO!");
            System.out.println(e.getMessage());
        }     
    }

    @Override
    public void excluir(Integer cod) {
        String sql = "UPDATE TB_PRODUTO SET Status_Produto = ? WHERE Id_Produto = ?";
        // prepared statement para inserção
        PreparedStatement stmt;
        try {            
            stmt = c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,"0");
            stmt.setInt(2,cod);
            // executa
            stmt.execute();
            stmt.close();   
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXCLUIR PRODUTO!");
            System.out.println(ex.getMessage());            
        }        
    }

    @Override
    public List<ProdutoModel> consultarTodos() {
        List<ProdutoModel> produtos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Produto, T1.Descricao_Produto, T1.Sku_Produto, T1.Min_Produto,T1.Max_Produto, T2.Valor_Compra, T2.Valor_Venda, T2.Lucro_Produto,T2.Margem_Lucro,T3.Descricao_Cat_Prod,T5.Saldo_Produto, T4.Razao_Social_Forn FROM TB_PRODUTO T1, TB_LUCRO_PRODUTO T2, TB_CATEGORIA_PRODUTO T3, TB_FORNECEDOR T4, TB_ESTOQUE_SALDO T5 WHERE T1.Id_Lucro = T2.Id_Lucro AND T1.Id_Cat_Produto = T3.Id_Cat_Prod AND T1.Id_Fornecedor = T4.Id_Fornecedor AND T1.Id_Produto = T5.Id_Produto AND T1.Status_Produto =1;";
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ProdutoModel prodModel = new ProdutoModel();                
                LucroProdutoModel lucroModel = new LucroProdutoModel();               
                CategoriaModel categoriaModel = new CategoriaModel();
                FornecedorModel forncedorModel = new FornecedorModel();

                prodModel.setIdProduto(rs.getInt(1));
                prodModel.setDescricao(rs.getString(2));
                prodModel.setSku(rs.getString(3));
                prodModel.setMinimo(rs.getInt(4));
                prodModel.setMaximo(rs.getInt(5));        
                                
                lucroModel.setValorCompra(rs.getDouble(6));
                lucroModel.setValorVenda(rs.getDouble(7));
                lucroModel.setLucro(rs.getDouble(8));
                lucroModel.setMargem(rs.getDouble(9));
                
                categoriaModel.setDescricao(rs.getString(10));                 
                prodModel.setSaldo(rs.getDouble(11));        
                forncedorModel.setRazaoSocial(rs.getString(12));
                
                prodModel.setCategoria(categoriaModel);
                prodModel.setFornecedor(forncedorModel);                
                prodModel.setLucro(lucroModel);
                                
                produtos.add(prodModel);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                       
            System.out.println("ERRO AO LISTAR TODOS PRODUTOS");
            System.out.println(ex.getMessage());
        }
        return produtos;        
    }

    @Override
    public List<ProdutoModel> consultarCodigo(Integer cod) {
        List<ProdutoModel> produtos = new ArrayList<>();                        
        String sql = "SELECT T1.Id_Produto, T1.Descricao_Produto, T1.Sku_Produto, T1.Min_Produto,T1.Max_Produto, T2.Valor_Compra, T2.Valor_Venda, T2.Lucro_Produto,T2.Margem_Lucro,T3.Descricao_Cat_Prod,T5.Saldo_Produto, T4.Razao_Social_Forn FROM TB_PRODUTO T1, TB_LUCRO_PRODUTO T2, TB_CATEGORIA_PRODUTO T3, TB_FORNECEDOR T4, TB_ESTOQUE_SALDO T5 WHERE T1.Id_Lucro = T2.Id_Lucro AND T1.Id_Cat_Produto = T3.Id_Cat_Prod AND T1.Id_Fornecedor = T4.Id_Fornecedor AND T1.Id_Produto = T5.Id_Produto AND T1.Status_Produto =1 AND T1.Id_Produto = ?;";                       
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1,cod);
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) {                                
                ProdutoModel prodModel = new ProdutoModel();                
                LucroProdutoModel lucroModel = new LucroProdutoModel();               
                CategoriaModel categoriaModel = new CategoriaModel();
                FornecedorModel forncedorModel = new FornecedorModel();

                prodModel.setIdProduto(rs.getInt(1));
                prodModel.setDescricao(rs.getString(2));
                prodModel.setSku(rs.getString(3));
                prodModel.setMinimo(rs.getInt(4));
                prodModel.setMaximo(rs.getInt(5));                        
                
                lucroModel.setValorCompra(rs.getDouble(6));
                lucroModel.setValorVenda(rs.getDouble(7));
                lucroModel.setLucro(rs.getDouble(8));
                lucroModel.setMargem(rs.getDouble(9));
                
                categoriaModel.setDescricao(rs.getString(10));                 
                prodModel.setSaldo(rs.getDouble(11));        
                forncedorModel.setRazaoSocial(rs.getString(12));
                
                prodModel.setCategoria(categoriaModel);
                prodModel.setFornecedor(forncedorModel);                
                prodModel.setLucro(lucroModel);
                                
                produtos.add(prodModel);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR PRODUTOS PELO CÓDIGO!");            
            System.out.println(ex.getMessage());
        }finally{
            return produtos;        
        }        
    }

    @Override
    public List<ProdutoModel> consultarNome(String nome) {
        List<ProdutoModel> produtos = new ArrayList<>();        
        String sql = "SELECT T1.Id_Produto, T1.Descricao_Produto, T1.Sku_Produto, T1.Min_Produto,T1.Max_Produto, T2.Valor_Compra, T2.Valor_Venda, T2.Lucro_Produto,T2.Margem_Lucro,T3.Descricao_Cat_Prod,T5.Saldo_Produto, T4.Razao_Social_Forn FROM TB_PRODUTO T1, TB_LUCRO_PRODUTO T2, TB_CATEGORIA_PRODUTO T3, TB_FORNECEDOR T4, TB_ESTOQUE_SALDO T5 WHERE T1.Id_Lucro = T2.Id_Lucro AND T1.Id_Cat_Produto = T3.Id_Cat_Prod AND T1.Id_Fornecedor = T4.Id_Fornecedor AND T1.Id_Produto = T5.Id_Produto AND T1.Status_Produto =1 AND T1.Descricao_Produto like ?;";                       
        // seta os valores
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setString(1,"%" + nome + "%");
            ResultSet rs = stmt.executeQuery();                            
            while (rs.next()) { 
                ProdutoModel prodModel = new ProdutoModel();                
                LucroProdutoModel lucroModel = new LucroProdutoModel();               
                CategoriaModel categoriaModel = new CategoriaModel();
                FornecedorModel forncedorModel = new FornecedorModel();

                prodModel.setIdProduto(rs.getInt(1));
                prodModel.setDescricao(rs.getString(2));
                prodModel.setSku(rs.getString(3));
                prodModel.setMinimo(rs.getInt(4));
                prodModel.setMaximo(rs.getInt(5));        
                                
                lucroModel.setValorCompra(rs.getDouble(6));
                lucroModel.setValorVenda(rs.getDouble(7));
                lucroModel.setLucro(rs.getDouble(8));
                lucroModel.setMargem(rs.getDouble(9));
                
                categoriaModel.setDescricao(rs.getString(10));                 
                prodModel.setSaldo(rs.getDouble(11));        
                forncedorModel.setRazaoSocial(rs.getString(12));
                
                prodModel.setCategoria(categoriaModel);
                prodModel.setFornecedor(forncedorModel);                
                prodModel.setLucro(lucroModel);
                                
                produtos.add(prodModel);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {                
            System.out.println("ERRO AO LISTAR PRODUTOS PELA DESCRIÇÃO!");
            System.out.println(ex.getMessage());
        }finally{
            return produtos;
        }                
    }
    
    public int consultarMaiorProduto() throws SQLException {        
        ProdutoModel produtoModel = new ProdutoModel();
        String sql = "SELECT Max(Id_Produto) FROM TB_PRODUTO;";
        // seta os valores        
        try ( 
            PreparedStatement stmt = this.c.prepareStatement(sql)) {           
            // executa
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()) {                
                produtoModel.setIdProduto(rs.getInt(1));
                break;
            }
            stmt.close();
            rs.close();
         }
         return produtoModel.getIdProduto();
    }    
}       