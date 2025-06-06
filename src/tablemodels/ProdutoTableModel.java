package tablemodels;

import controller.estoque.ProdutoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import model.estoque.ProdutoModel;

public class ProdutoTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ProdutoModel> lista;
    
    private final String[] colunas = {"Código","Descrição","SKU","Estoque Minimo","Estoque Máximo","Valor de Custo","Valor de Venda","Lucro Produto(R$)","Margem de Lucro(%)","Categoria","Saldo","Fornecedor","Excluir"};
    
    public ProdutoTableModel(){
        lista = new ArrayList<>();
    }
    
    public ProdutoTableModel(List<ProdutoModel> lista){
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
            case 5:
                return Object.class;
            case 6:
                return Object.class;
            case 7:
                return Object.class;
            case 8:
                return Object.class;
            case 9:
                return Object.class;
            case 10:
                return Object.class;    
            case 11:
                return Object.class;        
            case 12:                
                return Boolean.class;
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
                return produto.getSku();
            case 3:
                return produto.getMinimo();                            
            case 4:
                return produto.getMaximo();                            
            case 5:
                return validar.converterMoeda(produto.getLucro().getValorCompra());
            case 6:
                return validar.converterMoeda(produto.getLucro().getValorVenda());
            case 7:
                return validar.converterMoeda(produto.getLucro().getLucro());
            case 8:
                return validar.converterPercentual(produto.getLucro().getMargem());
            case 9:
                return produto.getCategoria().getDescricao();
            case 10:
                return produto.getSaldo();                
            case 11:
                return produto.getFornecedor().getRazaoSocial();            
            case 12:                            
                return produto.isAtivo();
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
                produto.setSku((String) aValue);
                break;
            case 3:
                produto.setMinimo((Integer) aValue);                
                break;
            case 4:
                produto.setMaximo((Integer) aValue);                
                break;
            case 5:
                produto.getLucro().setValorCompra((Double) aValue);
                break;
            case 6:
                produto.getLucro().setValorVenda((Double) aValue);
                break;
            case 7:
                produto.getLucro().setLucro((Double) aValue);                
                break;
            case 8:
                produto.getLucro().setMargem((Double) aValue);
                break;
            case 9:
                produto.getCategoria().setDescricao((String) aValue);                
                break;
            case 10:
                produto.setSaldo((Double) aValue);                
                break;    
            case 11:
                produto.getFornecedor().setRazaoSocial((String) aValue);                
                break;
            case 12:
                produto.setAtivo((Boolean) aValue);
                break;    
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 12;
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
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        ProdutoModel produto = new ProdutoModel();
        ProdutoController pc = new ProdutoController();        
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir o produto selecionado?","Confirmar exclusão do produto",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                produto = lista.remove(indiceLinha);                
                pc.excluirProduto(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Produto excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Produto não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}