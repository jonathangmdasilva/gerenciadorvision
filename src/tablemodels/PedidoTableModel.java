package tablemodels;


import controller.vendas.PedidoController;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.validacao.Validar;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import model.vendas.PedidoModel;

public class PedidoTableModel extends AbstractTableModel{    
    
    Validar validar;
    DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
    
    private final List<PedidoModel> lista;
    
    private final String[] colunas;
    
    public PedidoTableModel(){
        this.colunas = new String[]{"Código", "Cliente", "Sub Total", "Desconto (Dinheiro)", "Total","Desconto(Pagamento R$)","Valor Líquido", "Observação", "Forma Pagamento", "Data", "Status", "Funcionário", "Selecione"};
        lista = new ArrayList<>();
    }
    
    public PedidoTableModel(List<PedidoModel> lista){
        this.colunas = new String[]{"Código", "Cliente", "Sub Total", "Desconto (Dinheiro)", "Total","Desconto(Pagamento R$)","Valor Líquido", "Observação", "Forma Pagamento", "Data", "Status", "Funcionário", "Selecione"};
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
        PedidoModel pedido = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return pedido.getCodigoPedido();
            case 1:
                return pedido.getCliente().getNome();
            case 2:
                return validar.converterMoeda(pedido.getSubTotal());
            case 3:                
                return validar.converterMoeda(pedido.getDesconto());
            case 4:
                return validar.converterMoeda(pedido.getTotal());
            case 5:
                return validar.converterMoeda((pedido.getPagamento().getTaxaDesconto()/100)* pedido.getTotal());
            case 6: //CORRIGIR -- EM TESTES                
                return validar.converterMoeda(pedido.getTotal() - (pedido.getPagamento().getTaxaDesconto()/100)* pedido.getTotal());    
            case 7:
                return pedido.getObservacao();
            case 8:
                return pedido.getPagamento().getDescricao();
            case 9:                
                return validar.FormatarData(pedido.getDataHora());
            case 10:
                return pedido.getStatus();
            case 11:
                return pedido.getUsuario().getNome();
            case 12:                            
                return pedido.isAtivo();
            default:
                throw new IndexOutOfBoundsException("Erro Indice!!!");
        }
    }

    @Override
    public void setValueAt(Object aValue, int linhaIndice, int colunaIndice) {      
        PedidoModel pedido = lista.get(linhaIndice);
        switch(colunaIndice){
            case 0:
                pedido.setCodigoPedido((Integer) aValue);
                break;
            case 1:
                pedido.getCliente().setNome((String) aValue);
                break;
            case 2:
                pedido.setSubTotal((Double) aValue);
                break;
            case 3:
                pedido.setDesconto((Double) aValue);
                break;
            case 4:
                pedido.setTotal((Double) aValue);                
                break;
            case 5:                
                pedido.getPagamento().setTaxaDesconto((Double) aValue);
                break;    
            case 6: // CORRIGIR  LIQUIDO              
                pedido.getPagamento().setTaxaDesconto((Double) aValue);
                break;        
            case 7:
                pedido.setObservacao((String) aValue);
                break;
            case 8:
                pedido.getPagamento().setDescricao((String) aValue);
                break;
            case 9:
                pedido.setDataHora((Date) aValue);
                break;
            case 10:
                pedido.setStatus((String) aValue);
                break;
            case 11:
                pedido.getUsuario().setNome((String) aValue);
                break;
            case 12:
                pedido.setAtivo((Boolean) aValue);
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
    
    public PedidoModel getPedido(int indiceLinha){
        return lista.get(indiceLinha);
    }
    
    public void addPedido(List<PedidoModel> pedido){
        int indice = getRowCount();        
        lista.addAll(pedido);        
        fireTableRowsInserted(indice, indice);        
    }

    public void addListaPedido(List<PedidoModel> pedido){
        int indice = getRowCount();        
        lista.addAll(pedido);        
        fireTableRowsInserted(indice, indice);        
    }
    
    public void limpar(){        
        lista.clear();	         
        fireTableDataChanged();
    }
    
    public void remover(int indiceLinha,int codigo) throws SQLException, ClassNotFoundException{
        PedidoModel pedido = new PedidoModel();
        pedido.setCodigoPedido(codigo);
        PedidoController pc = new PedidoController();
        int x = JOptionPane.showConfirmDialog(null,"Deseja realmente cancelar o pedido selecionado?","Confirmar cancelamento do´pedido",JOptionPane.YES_NO_OPTION);
        if(x == JOptionPane.OK_OPTION){
            if(lista.get(indiceLinha).isAtivo() == true){
                pedido = lista.remove(indiceLinha);                
                pc.cancelarPedido(pedido);                
                fireTableRowsDeleted(indiceLinha, indiceLinha);
                JOptionPane.showMessageDialog(null,"Pedido cancelado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);              
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pedido não cancelado!","Erro",JOptionPane.ERROR_MESSAGE);              
            lista.get(indiceLinha).setAtivo(false);            
        }
    }
}