package view.consulta;

import controller.estoque.ProdutoController;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.administrativo.UsuarioModel;
import model.estoque.ProdutoModel;
import tablemodels.ProdutoTableModel;
import view.alterar.AlterarProdutos;
import view.estoque.CadastroProdutos;
import view.validacao.Validar;

/**
 *
 * @author Jonathan
 */
public class ConsultaProdutos extends javax.swing.JFrame {

    Validar validar = new Validar();
    ProdutoController pc = new ProdutoController();                
    ProdutoModel produtoModel;
    
    ProdutoTableModel produtoTableModel= new ProdutoTableModel();                 
    UsuarioModel usu;
    
    public ConsultaProdutos(UsuarioModel us) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.usu = us;
        acesso(us);
        setLocationRelativeTo(null);
        configurarTabela();
        tabela_produtos.setModel(produtoTableModel);
        setVisible(true);
    }

    List<ProdutoModel> listaProdutos = new ArrayList<>();
    
    public ProdutoTableModel getModelo() {
	if(produtoTableModel == null){
            produtoTableModel = new ProdutoTableModel(listaProdutos);
	}
	return produtoTableModel;		
    }
    
    public JTable getTabela(){
	if(tabela_produtos == null){
            tabela_produtos = new JTable();
            tabela_produtos.setModel(getModelo());
	}
            return tabela_produtos;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblParametro = new javax.swing.JLabel();
        cmbParametro = new javax.swing.JComboBox<>();
        lblDescricao = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jmiMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Produtos");
        setExtendedState(100);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar Cadastro");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Limpar Campos");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo Produto");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblParametro.setText("Parametro");

        cmbParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Descrição", "Todos" }));
        cmbParametro.setSelectedIndex(2);
        cmbParametro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbParametroItemStateChanged(evt);
            }
        });

        lblDescricao.setText("Descrição");

        txtChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChaveKeyReleased(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Confirmar.png"))); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        tabela_produtos.setModel(getModelo() );
        tabela_produtos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_produtos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_produtos);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel4.setText("(Clique duas vezes com o botão esquerdo do mouse no campo para visualizar em nova janela.)");

        jLabel5.setText("Aperte F5 para atualizar a lista");

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmiMenu.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Ajuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jmiMenu.add(jMenu2);

        setJMenuBar(jmiMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblParametro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(lblDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtChave))
                    .addComponent(cmbParametro)
                    .addComponent(lblParametro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir))
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.dispose();
        CadastroProdutos cadProdutos = new CadastroProdutos(this, rootPaneCheckingEnabled, usu);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        validar.exibirAjudaConsulta("Produtos");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            confirmar();
        }        
    }//GEN-LAST:event_txtChaveKeyPressed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void txtChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyReleased
        txtChave.setText(txtChave.getText().toUpperCase());
    }//GEN-LAST:event_txtChaveKeyReleased

    private void cmbParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParametroItemStateChanged
        txtChave.setText("");
    }//GEN-LAST:event_cmbParametroItemStateChanged

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            if (evt.getClickCount() == 2) {
                if (usu.getNivel().equals("ADMINISTRADOR")) {
                    produtoModel = produtoTableModel.getProduto(tabela_produtos.getSelectedRow());                     
                    AlterarProdutos alterarProdutos = new AlterarProdutos(this, rootPaneCheckingEnabled,produtoModel);                    
                }else if(evt.getClickCount() == 2){
                    JOptionPane.showMessageDialog(null, "Você não possui acesso para alterar cadastros!","Hierarquia",JOptionPane.WARNING_MESSAGE);
                }
            }
        }                                         
    }//GEN-LAST:event_tabela_produtosMouseClicked

    public void configurarTabela(){
        tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabela_produtos.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela_produtos.getColumnModel().getColumn(2).setPreferredWidth(170);
        tabela_produtos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela_produtos.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela_produtos.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela_produtos.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabela_produtos.getColumnModel().getColumn(7).setPreferredWidth(120);
        tabela_produtos.getColumnModel().getColumn(8).setPreferredWidth(125);
        tabela_produtos.getColumnModel().getColumn(9).setPreferredWidth(160);
        tabela_produtos.getColumnModel().getColumn(10).setPreferredWidth(50);        
        tabela_produtos.getColumnModel().getColumn(11).setPreferredWidth(190);                
        tabela_produtos.getColumnModel().getColumn(12).setPreferredWidth(60);                
    }     
    
    public void novo(){
        this.dispose();
        CadastroProdutos cad= new CadastroProdutos(this, rootPaneCheckingEnabled,usu);            
    }
    
    private void confirmar(){
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void acesso(UsuarioModel u){
        if(u.getNivel().equals("PADRÃO")){
            btnExcluir.setVisible(false);
        }
    }
    
    public void lista(int num, String param) throws SQLException, ClassNotFoundException{
        switch (num) {
            case 0:
                produtoTableModel.limpar();
                listaProdutos = pc.listarProdutoCodigo(Integer.parseInt(param));                
                produtoTableModel.addListaProduto(listaProdutos);
                break;
            case 1:
                produtoTableModel.limpar();
                listaProdutos = pc.listarTodosProdutosDescricao(param);
                produtoTableModel.addListaProduto(listaProdutos);
                break;
            case 2:
                produtoTableModel.limpar();
                listaProdutos = pc.listarTodosProdutos();
                produtoTableModel.addListaProduto(listaProdutos);
                break;
            default:
                throw new NullPointerException("Erro!!!!");
        }
    }      
 
    public void excluir(){
        try {            
            int codigo  = listaProdutos.get(tabela_produtos.getSelectedRow()).getIdProduto();
            produtoTableModel.remover(tabela_produtos.getSelectedRow(),codigo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cmbParametro;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar jmiMenu;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblParametro;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JTextField txtChave;
    // End of variables declaration//GEN-END:variables
}