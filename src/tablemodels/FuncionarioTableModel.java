package tablemodels;

import controller.administrativo.FuncionarioController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import model.administrativo.FuncionarioModel;

public class FuncionarioTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<FuncionarioModel> lista;
    
    private final String[] colunas = {"Código","Nome","Cargo","Login ","Senha ","Nível Acesso","Excluir"};
    
    public FuncionarioTableModel(){
        lista = new ArrayList<>();
    }
    
    public FuncionarioTableModel(List<FuncionarioModel> lista){
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
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Erro!!!!! NO GET COLLUMN");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        FuncionarioModel funcionario = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return funcionario.getIdFuncionario();
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getCargo();
            case 3:
                return funcionario.getLogin();                            
            case 4:
                return funcionario.getSenha();                            
            case 5:
                return funcionario.getNivel();
            case 6:
                return funcionario.getAtivo();            
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        FuncionarioModel funcionario = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                funcionario.setIdFuncionario((Integer) aValue);
                break;
            case 1:
                funcionario.setNome((String) aValue);
                break;
            case 2:
                funcionario.setCargo((String) aValue);
                break;
            case 3:
                funcionario.setLogin((String) aValue);
                break;
            case 4:
                funcionario.setSenha((String) aValue);
                break;
            case 5:
                funcionario.setNivel((String) aValue);
                break;
            case 6:
                funcionario.setAtivo((Boolean) aValue);
                break;    
            default:
                throw new IndexOutOfBoundsException("Erro!!! NO SET VALEU AT");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 6;
    }
    
    public FuncionarioModel getFuncionario(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addFuncionario(List<FuncionarioModel> funcionario){
        int indice = getRowCount();        
        lista.addAll(funcionario);        
        fireTableRowsInserted(indice, indice);        
    }

    public void addListaFuncionario(List<FuncionarioModel> funcionario){
        int indice = getRowCount();        
        lista.addAll(funcionario);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{    
        FuncionarioModel funcionario = new FuncionarioModel();        
        FuncionarioController fc = new FuncionarioController();
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir o funcionário -selecionado?","Confirmar exclusão do funcionário",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).getAtivo() == true){
                funcionario = lista.remove(indiceLinha);                                
                fc.excluirFuncionario(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Funcionário excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Funcionário não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}