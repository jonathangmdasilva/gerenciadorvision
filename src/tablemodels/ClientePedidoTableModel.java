package tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.administrativo.ClienteModel;
import view.validacao.Validar;

public class ClientePedidoTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ClienteModel> lista;
    
    private final String[] colunas = {"Código","Nome","Email"};
    
    public ClientePedidoTableModel(){
        lista = new ArrayList<>();
    }
    
    public ClientePedidoTableModel(List<ClienteModel> lista){
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
                throw new IndexOutOfBoundsException("Erro!!!!!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        ClienteModel cliente = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return cliente.getIdCliente();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getContato().getEmail();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        ClienteModel cliente = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                cliente.setIdCliente((Integer) aValue);
                break;
            case 1:
                cliente.setNome((String) aValue);
                break;
            case 2:
                cliente.getContato().setEmail((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }
    
    public ClienteModel getCliente(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addCliente(List<ClienteModel> cliente){
        int indice = getRowCount();        
        lista.addAll(cliente);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void addListaCliente(List<ClienteModel> cliente){
        int indice = getRowCount();        
        lista.addAll(cliente);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }        
}