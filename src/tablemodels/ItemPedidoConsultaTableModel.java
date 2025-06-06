package tablemodels;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;

import model.vendas.ItemPedidoModel;

public class ItemPedidoConsultaTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ItemPedidoModel> lista;
    
    private final String[] colunas = {"Cód. Produto","Descrição","Qtd","Valor Unitário","Valor Total"};
    
    public ItemPedidoConsultaTableModel(){
        lista = new ArrayList<>();
    }
    
    public ItemPedidoConsultaTableModel(List<ItemPedidoModel> lista){
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
            case 3:
                return Object.class;
            case 4:
                return Object.class;
            default:
                throw new IndexOutOfBoundsException("Erro no getColumnClass!!!!!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        ItemPedidoModel itemPedidos = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return itemPedidos.getProduto().getIdProduto();
            case 1:
                return itemPedidos.getProduto().getDescricao();
            case 2:
                return itemPedidos.getQtd();
            case 3:
                return validar.converterMoeda(itemPedidos.getValorUnitario());                            
            case 4:
                return validar.converterMoeda(itemPedidos.getValorTotal());                                       
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!! getValueAt");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        ItemPedidoModel itemPedido = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                itemPedido.getProduto().setIdProduto((Integer) aValue);
                break;
            case 1:
                itemPedido.getProduto().setDescricao((String) aValue);
                break;
            case 2:
                itemPedido.setQtd((Double) aValue);
                break;
            case 3:
                itemPedido.setValorUnitario((Double) aValue);                
                break;
            case 4:
                itemPedido.setValorTotal((Double) aValue);                
                break;
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }
    
    public ItemPedidoModel getItemPedido(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addItemPedido(List<ItemPedidoModel> itemPedido){
        limpar();
        int indice = getRowCount();        
        lista.addAll(itemPedido);        
        fireTableRowsInserted(indice, indice);        
    }    
    
    public void addItemPedido(ItemPedidoModel itemPedido){
        int indice = getRowCount();        
        lista.add(0,itemPedido);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }    
}