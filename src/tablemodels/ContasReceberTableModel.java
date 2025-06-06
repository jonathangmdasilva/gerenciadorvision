package tablemodels;

import controller.contas.ContasReceberController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import java.util.Date;
import model.contas.ContasReceberModel;

public class ContasReceberTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ContasReceberModel> lista;
    
    private final String[] colunas = {"Código","Sacado","Número","Valor","Emissão","Vencimento","Status","Observação","Excluir"};
    
    public ContasReceberTableModel(){
        lista = new ArrayList<>();
    }
    
    public ContasReceberTableModel(List<ContasReceberModel> lista){
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
        ContasReceberModel receber = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return receber.getIdConta();
            case 1:
                return receber.getSacado();
            case 2:
                return receber.getNumeroConta();
            case 3:
                return validar.converterMoeda(receber.getValorConta());                            
            case 4:
                return validar.FormatarData(receber.getEmissaoConta());                            
            case 5:
                return validar.FormatarData(receber.getVencimentoConta());
            case 6:
                return receber.getStatus();
            case 7:
                return receber.getObservacaoConta();                
            case 8:        
                return receber.isAtivo();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        ContasReceberModel receber = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                receber.setIdConta((Integer) aValue);
                break;
            case 1:
                receber.setSacado((String) aValue);
                break;
            case 2:
                receber.setNumeroConta((String) aValue);
                break;
            case 3:
                receber.setValorConta( (Double) aValue);
                break;
            case 4:
                receber.setEmissaoConta((Date) aValue);                
                break;
            case 5:
                receber.setVencimentoConta((Date) aValue);
                break;
            case 6:
                receber.setStatus((String) aValue);
                break;
            case 7:
                receber.setObservacaoConta((String) aValue);
                break;
            case 8:
                receber.setAtivo((Boolean) aValue);
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
    
    public ContasReceberModel getContasPagar(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addContasReceber(List<ContasReceberModel> contasPagar){
        int indice = getRowCount();        
        lista.addAll(contasPagar);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void addListaContasReceber(List<ContasReceberModel> contasPagar){
        int indice = getRowCount();        
        lista.addAll(contasPagar);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        ContasReceberModel contasReceber = new ContasReceberModel();
        ContasReceberController cr = new ContasReceberController();        
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir a conta selecionado?","Confirmar exclusão de conta",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                contasReceber = lista.remove(indiceLinha);                                
                cr.excluirContasReceber(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Conta excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Conta não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}