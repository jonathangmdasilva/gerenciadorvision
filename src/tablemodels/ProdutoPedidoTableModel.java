package tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import model.estoque.ProdutoModel;

public class ProdutoPedidoTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ProdutoModel> lista;
    
    private final String[] colunas = {"Código","Descrição","Valor de Venda"};
    
    public ProdutoPedidoTableModel(){
        lista = new ArrayList<>();
    }
    
    public ProdutoPedidoTableModel(List<ProdutoModel> lista){
        this.lista = new ArrayList<>(lista);
    }
    
    @Override
    public int getRowCount() {        
        return lista.size();                
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Object.class;
            case 1:
                return Object.class;
            case 2:
                return Object.class;    
            default:
                throw new IndexOutOfBoundsException("Erro no getColumnClass!!!!!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        ProdutoModel produto = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return produto.getIdProduto();
            case 1:
                return produto.getDescricao();
            case 2:
                return validar.converterMoeda(produto.getLucro().getValorVenda());
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!! getValueAt");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        ProdutoModel produto = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                produto.setIdProduto((Integer) aValue);
                break;
            case 1:
                produto.setDescricao((String) aValue);
                break;
            case 2:
                produto.getLucro().setValorVenda((Double) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }
    
    public ProdutoModel getProduto(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addProduto(List<ProdutoModel> produto){
        int indice = getRowCount();        
        lista.addAll(produto);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void addListaProduto(List<ProdutoModel> produto){
        int indice = getRowCount();        
        lista.addAll(produto);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void addProduto(ProdutoModel produto){
        int indice = getRowCount();        
        lista.add(0,produto);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
}