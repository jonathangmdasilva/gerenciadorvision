package tablemodels;

import controller.administrativo.ClienteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.administrativo.ClienteModel;
import view.validacao.Validar;
import java.sql.SQLException;

public class ClienteTableModel extends AbstractTableModel{
    
    Validar validar;
    
    private final List<ClienteModel> lista;
    
    private final String[] colunas = {"Código","Nome","Email","Telefone Um","Telefone Dois","Cpf","Cnpj","Lograd.","Número","Cidade","Bairro","Estado","Excluir"};
    
    public ClienteTableModel(){
        lista = new ArrayList<>();
    }
    
    public ClienteTableModel(List<ClienteModel> lista){
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
            case 3:
                return cliente.getContato().getTelUm();                            
            case 4:
                return cliente.getContato().getTelDois();                            
            case 5:
                return cliente.getCpf();
            case 6:
                return cliente.getCnpj();
            case 7:
                return cliente.getEndereco().getLogradouro();
            case 8:
                return cliente.getEndereco().getNumero();
            case 9:
                return cliente.getEndereco().getCidade();
            case 10:
                return cliente.getEndereco().getBairro();
            case 11:
                return cliente.getEndereco().getEstado().getNomeEstado();    
            case 12:                            
                return cliente.isAtivo();
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
            case 3:
                cliente.getContato().setTelUm((String) aValue);
                break;
            case 4:
                cliente.getContato().setTelDois((String) aValue);
                break;
            case 5:
                cliente.setCpf((String) aValue);
                break;
            case 6:
                cliente.setCnpj((String) aValue);
                break;
            case 7:
                cliente.getEndereco().setLogradouro((String) aValue);
                break;
            case 8:
                cliente.getEndereco().setNumero((Integer) aValue);
                break;
            case 9:
                cliente.getEndereco().setCidade((String) aValue);
                break;
            case 10:
                cliente.getEndereco().setBairro((String) aValue);
                break;
            case 11:
                cliente.getEndereco().getEstado().setNomeEstado((String) aValue);
                break;    
            case 12:
                cliente.setAtivo((Boolean) aValue);
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
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        ClienteModel cliente = new ClienteModel();
        ClienteController cc = new ClienteController();        
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir o cliente selecionado?","Confirmar exclusão do cliente",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                cliente = lista.remove(indiceLinha);                
                cc.excluirCliente(codigo);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não excluido!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}