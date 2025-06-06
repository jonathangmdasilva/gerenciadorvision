package tablemodels;

import controller.estoque.FornecedorController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import model.estoque.FornecedorModel;

public class FornecedorTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<FornecedorModel> lista;
    
    private final String[] colunas;
    
    public FornecedorTableModel(){
        this.colunas = new String[]{"Código", "Razão Social", "Email", "Telefone Um", "Telefone Dois", "Cnpj", "Lograd.", "Número", "Cidade", "Bairro", "Estado", "Excluir"};
        lista = new ArrayList<>();
    }
    
    public FornecedorTableModel(List<FornecedorModel> lista){
        this.colunas = new String[]{"Código", "Razão Social", "Email", "Telefone Um", "Telefone Dois", "Cnpj", "Lograd.", "Número", "Cidade", "Bairro", "Estado", "Excluir"};
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
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Erro!!!!!");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        validar = new Validar();
        FornecedorModel fornecedor = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return fornecedor.getIdFornecedor();
            case 1:
                return fornecedor.getRazaoSocial();
            case 2:
                return fornecedor.getContato().getEmail();
            case 3:
                return fornecedor.getContato().getTelUm();                            
            case 4:
                return fornecedor.getContato().getTelDois();                            
            case 5:
                return fornecedor.getCnpj();
            case 6:
                return fornecedor.getEndereco().getLogradouro();
            case 7:
                return fornecedor.getEndereco().getNumero();
            case 8:
                return fornecedor.getEndereco().getCidade();
            case 9:
                return fornecedor.getEndereco().getBairro();
            case 10:
                return fornecedor.getEndereco().getEstado().getNomeEstado();
            case 11:                            
                return fornecedor.isAtivo();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        FornecedorModel fornecedor = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                fornecedor.setIdFornecedor((Integer) aValue);
                break;
            case 1:
                fornecedor.setRazaoSocial((String) aValue);
                break;
            case 2:
                fornecedor.getContato().setEmail((String) aValue);
                break;
            case 3:
                fornecedor.getContato().setTelUm((String) aValue);
                break;
            case 4:
                fornecedor.getContato().setTelDois((String) aValue);
                break;
            case 5:
                fornecedor.setCnpj((String) aValue);
                break;
            case 6:
                fornecedor.getEndereco().setLogradouro((String) aValue);
                break;
            case 7:
                fornecedor.getEndereco().setNumero((Integer) aValue);
                break;
            case 8:
                fornecedor.getEndereco().setCidade((String) aValue);
                break;
            case 9:
                fornecedor.getEndereco().setBairro((String) aValue);
                break;
            case 10:
                fornecedor.getEndereco().getEstado().setNomeEstado((String) aValue);
                break;    
            case 11:
                fornecedor.setAtivo((Boolean) aValue);
                break;    
            default:
                throw new IndexOutOfBoundsException("Erro!!!");
        }        
        fireTableCellUpdated(linhaIndice, colunaIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 11;
    }
    
    public FornecedorModel getFornecedor(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addFornecedor(List<FornecedorModel> fornecedor){
        int indice = getRowCount();        
        lista.addAll(fornecedor);        
        fireTableRowsInserted(indice, indice);        
    }

    public void addListaFornecedor(List<FornecedorModel> fornecedor){
        int indice = getRowCount();        
        lista.addAll(fornecedor);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        FornecedorModel fornecedor = new FornecedorModel();
        
        FornecedorController fc = new FornecedorController();
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir o fornecedor selecionado?","Confirmar exclusão do fornecedor",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                fornecedor = lista.remove(indiceLinha);                
                fc.excluirFornecedor(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Fornecedor excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Fornecedor não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}