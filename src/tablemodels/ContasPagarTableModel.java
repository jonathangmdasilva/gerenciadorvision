package tablemodels;

import controller.contas.ContasPagarController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import java.util.Date;
import model.contas.ContasPagarModel;

public class ContasPagarTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ContasPagarModel> lista;
    
    private final String[] colunas = {"Código","Cedente","Número","Valor","Emissão","Vencimento","Status","Observação","Excluir"};
    
    public ContasPagarTableModel(){
        lista = new ArrayList<>();
    }
    
    public ContasPagarTableModel(List<ContasPagarModel> lista){
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
                return Boolean.class;           
            default:
                throw new IndexOutOfBoundsException("Erro!!!!!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        ContasPagarModel pagar = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return pagar.getIdConta();
            case 1:
                return pagar.getCedente();
            case 2:
                return pagar.getNumeroConta();
            case 3:
                return validar.converterMoeda(pagar.getValorConta());                            
            case 4:
                return validar.FormatarData(pagar.getEmissaoConta());                            
            case 5:
                return validar.FormatarData(pagar.getVencimentoConta());
            case 6:
                return pagar.getStatus();
            case 7:
                return pagar.getObservacaoConta();                
            case 8:        
                return pagar.isAtivo();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        ContasPagarModel pagar = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                pagar.setIdConta((Integer) aValue);                
                break;
            case 1:
                pagar.setCedente((String) aValue);
                break;
            case 2:
                pagar.setNumeroConta((String) aValue);
                break;
            case 3:
                pagar.setValorConta( (Double) aValue);
                break;
            case 4:
                pagar.setEmissaoConta((Date) aValue);                
                break;
            case 5:
                pagar.setVencimentoConta((Date) aValue);
                break;
            case 6:
                pagar.setStatus((String) aValue);                
                break;
            case 7:
                pagar.setObservacaoConta((String) aValue);
                break;
            case 8:
                pagar.setAtivo((Boolean) aValue);
                break;    
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 8;
    }
    
    public ContasPagarModel getContasPagar(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addContasPagar(List<ContasPagarModel> contasPagar){
        int indice = getRowCount();        
        lista.addAll(contasPagar);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void addListaContasPagar(List<ContasPagarModel> contasPagar){
        int indice = getRowCount();        
        lista.addAll(contasPagar);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        ContasPagarModel contasPagar = new ContasPagarModel();
        ContasPagarController cc = new ContasPagarController();        
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir a conta selecionado?","Confirmar exclusão de conta",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                contasPagar = lista.remove(indiceLinha);                                
                cc.excluirContasPagar(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Conta excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Conta não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}