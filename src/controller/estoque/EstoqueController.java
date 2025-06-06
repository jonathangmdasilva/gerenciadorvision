package controller.estoque;

import dao.estoque.EstoqueEntradaDao;
import dao.estoque.EstoqueSaidaDao;
import dao.estoque.EstoqueSaldoDao;
import dao.estoque.InventarioDao;
import java.sql.SQLException;
import java.util.List;
import model.estoque.EstoqueModel;
import model.estoque.InventarioModel;
import model.estoque.ProdutoModel;

/*
 * @author Jonathan
 */

public class EstoqueController {
    
    public void inserirEntrada(EstoqueModel entrada) throws SQLException, ClassNotFoundException{
        EstoqueEntradaDao entradaDao = new EstoqueEntradaDao();
        entradaDao.inserirCadastro(entrada);
    }
    
    public void inserirSaida(EstoqueModel saida) throws SQLException, ClassNotFoundException{
        EstoqueSaidaDao saidaDao = new EstoqueSaidaDao();
        saidaDao.inserirCadastro(saida);
    }
    
    public void atualizarSaldo(ProdutoModel pro) throws SQLException, ClassNotFoundException{
        EstoqueSaldoDao saldoDao = new EstoqueSaldoDao();
        saldoDao.atualizarSaldo(pro);
    }
    
    public double consultaSaldo(int cod) throws SQLException, ClassNotFoundException{
        EstoqueSaldoDao saldoDao = new EstoqueSaldoDao();        
        return saldoDao.saldoProduto(cod);
    }
    
    public List<InventarioModel> realizarInventario() throws SQLException, ClassNotFoundException{
        InventarioDao inveratio = new InventarioDao();
        return inveratio.realizarInventario();
    }
}
