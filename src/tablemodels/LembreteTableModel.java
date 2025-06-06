package tablemodels;

import controller.administrativo.LembreteController;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import model.administrativo.LembreteModel;

public class LembreteTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<LembreteModel> lista;
    
    private final String[] colunas = {"Código","Data","Descrição","Excluir"};
    
    public LembreteTableModel(){
        lista = new ArrayList<>();
    }
    
    public LembreteTableModel(List<LembreteModel> lista){
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
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Erro!!!!! NO GET COLLUMN");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        LembreteModel lembrete = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return lembrete.getIdLembrete();
            case 1:
                return validar.FormatarData(lembrete.getData());
            case 2:
                return lembrete.getDescricao();
            case 3:
                return lembrete.isAtivo();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        LembreteModel lembrete = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                lembrete.setIdLembrete((Integer) aValue);
                break;
            case 1:
                lembrete.setData((Date) aValue);
                break;
            case 2:
                lembrete.setDescricao((String) aValue);
                break;
            case 3:
                lembrete.setAtivo((Boolean) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Erro!!! NO SET VALUe AT");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
    
    public LembreteModel getLembrete(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addLembrete(List<LembreteModel> lembrete){
        int indice = getRowCount();        
        lista.addAll(lembrete);        
        fireTableRowsInserted(indice, indice);        
    }

    public void addListaLembrete(List<LembreteModel> lembrete){
        int indice = getRowCount();        
        lista.addAll(lembrete);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{    
        LembreteModel lembrete = new LembreteModel();        
        LembreteController lc = new LembreteController();
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir o lembrete -selecionado?","Confirmar exclusão do lembrete",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            
            if(lista.get(indiceLinha).isAtivo() == true){                
                lembrete = lista.remove(indiceLinha);                                
                lc.excluirLembrete(codigo);                
                System.out.println("passou excluirLembrete");
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Lembrete excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Lembrete não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}