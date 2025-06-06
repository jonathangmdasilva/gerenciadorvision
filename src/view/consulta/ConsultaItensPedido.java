package view.consulta;

import controller.vendas.PedidoController;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.vendas.ItemPedidoModel;
import tablemodels.ItemPedidoConsultaTableModel;

/*
 * @author Jonathan
 */
public class ConsultaItensPedido extends javax.swing.JFrame {

    ItemPedidoConsultaTableModel itemPedidoTableModel= new ItemPedidoConsultaTableModel();        
    PedidoController pc = new PedidoController();
    int codigo;
    
    public ConsultaItensPedido(java.awt.Frame parent, boolean modal,int idPedido) throws SQLException, ClassNotFoundException {        
        initComponents();
        this.getContentPane().setBackground(Color.darkGray);
        tabela_itens_pedido.setModel(itemPedidoTableModel);
        this.codigo = idPedido;
        lblCodigoPedido.setText(""+codigo);
        carregarItens();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    List<ItemPedidoModel> listaItensPedidos = new ArrayList<>();
    
    public ItemPedidoConsultaTableModel getModelo() {
	if(itemPedidoTableModel == null){
            itemPedidoTableModel = new ItemPedidoConsultaTableModel(listaItensPedidos);
	}
	return itemPedidoTableModel;		
    }
    
    public JTable getTabela(){
	if(tabela_itens_pedido == null){
            tabela_itens_pedido = new JTable();
            tabela_itens_pedido.setModel(getModelo());
	}
            return tabela_itens_pedido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_itens_pedido = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_itens_pedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblCodigoPedido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblQtdItens = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        tabela_itens_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela_itens_pedido);

        panel_itens_pedido.setViewportView(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedido:");

        lblCodigoPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCodigoPedido.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoPedido.setText("Cód");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantidade Itens");

        lblQtdItens.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblQtdItens.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdItens.setText("Cód");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_itens_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigoPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQtdItens)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblQtdItens))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblCodigoPedido)))
                .addGap(18, 18, 18)
                .addComponent(panel_itens_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_formKeyPressed

    private void carregarItens() throws SQLException, ClassNotFoundException{
        listaItensPedidos = pc.listarItensPedido(codigo);
        itemPedidoTableModel.addItemPedido(listaItensPedidos);
        lblQtdItens.setText(""+listaItensPedidos.size());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoPedido;
    private javax.swing.JLabel lblQtdItens;
    private javax.swing.JScrollPane panel_itens_pedido;
    private javax.swing.JTable tabela_itens_pedido;
    // End of variables declaration//GEN-END:variables
}
