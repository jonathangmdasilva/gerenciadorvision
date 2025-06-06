package controller.estoque;

import dao.estoque.CategoriaDao;
import dao.estoque.EstoqueSaldoDao;
import dao.estoque.LucroProdutoDao;
import dao.estoque.ProdutoDao;
import java.sql.SQLException;
import java.util.List;
import model.estoque.CategoriaModel;
import model.estoque.ProdutoModel;

/*
 * @author Jonathan
 */
public class ProdutoController {
  
    public void inserirProduto(ProdutoModel produto) throws SQLException, ClassNotFoundException{
        LucroProdutoDao lucroDao = new LucroProdutoDao();
        lucroDao.inserirCadastro(produto);
        int qtd = lucroDao.listarLucros();
        produto.getLucro().setIdLucro(qtd);
        ProdutoDao proDao = new ProdutoDao();
        proDao.inserir(produto);
        produto.setIdProduto(proDao.consultarMaiorProduto());
        EstoqueSaldoDao saldoDao = new EstoqueSaldoDao();        
        saldoDao.inserirCadastro(produto);
    }
    
    public List<CategoriaModel> listarTodosCategorias() throws SQLException, ClassNotFoundException{
            CategoriaDao categoriaDao = new CategoriaDao();
            return categoriaDao.listarCategoriaProdutos();            
    }     
    
    public List<ProdutoModel> listarTodosProdutos() throws SQLException, ClassNotFoundException{
        ProdutoDao produtoDao = new ProdutoDao();        
        return produtoDao.consultarTodos();
    }
    
    public List<ProdutoModel> listarTodosProdutosDescricao(String descricao) throws SQLException, ClassNotFoundException{
        ProdutoDao produtoDao = new ProdutoDao();        
        return produtoDao.consultarNome(descricao);
    }
    
    public List<ProdutoModel> listarProdutoCodigo(Integer cod) throws SQLException, ClassNotFoundException{
        ProdutoDao produtoDao = new ProdutoDao();            
        return produtoDao.consultarCodigo(cod);
    }

    public ProdutoModel listarProdutoCodigoMovimentar(Integer cod) throws SQLException, ClassNotFoundException{
        ProdutoDao produtoDao = new ProdutoDao();            
        return produtoDao.listarProdutoCodigoMovimentar(cod);
    }
    
    public void excluirProduto(int codigo) throws SQLException, ClassNotFoundException{
        ProdutoDao produtoDao = new ProdutoDao();        
        produtoDao.excluir(codigo);
    }

    public void alterarProduto(ProdutoModel produto) throws SQLException, ClassNotFoundException{
        LucroProdutoDao lucroDao = new LucroProdutoDao();
        lucroDao.inserirCadastro(produto);
        int qtd = lucroDao.listarLucros();
        produto.getLucro().setIdLucro(qtd);
        ProdutoDao proDao = new ProdutoDao();
        proDao.alterar(produto);
    }
    
    public int listarCodigoCategoria(String categoria) throws SQLException, ClassNotFoundException{
        CategoriaDao catDao = new CategoriaDao();
        return catDao.listarCodigoCategoriaProdutos(categoria);
    }
}
