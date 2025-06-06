package controller.vendas;

import dao.vendas.FormaPagamentoDao;
import java.sql.SQLException;
import model.vendas.FormaPagamentoModel;

/*
 * @author Jonathan
 */

public class PagamentoController {
    
    FormaPagamentoModel pagModel = new FormaPagamentoModel();
    
    public void cadastrarFormaPagamento(String descricao, double taxa) throws SQLException, ClassNotFoundException{
        FormaPagamentoDao formDao = new FormaPagamentoDao();
        //FormaPagamentoModel pagModel = new FormaPagamentoModel();
        pagModel.setDescricao(descricao);
        pagModel.setTaxaDesconto(taxa);        
        formDao.inserirCadastro(pagModel);
    }
    
    public FormaPagamentoModel listarFormasPagamentoPelaDescricao(String desc) throws SQLException, ClassNotFoundException{
        FormaPagamentoDao formDao = new FormaPagamentoDao();    
        return pagModel = formDao.listarFormasPagamentoPelaDescricao(desc);
    }    
}
