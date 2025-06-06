package view.consulta;

import controller.estoque.FornecedorController;
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
import model.estoque.FornecedorModel;
import tablemodels.FornecedorTableModel;
import view.alterar.AlterarFornecedor;
import view.estoque.CadastroFornecedor;
import view.validacao.Validar;


/**
 * @author Jonathan
 */
public class ConsultaFornecedor extends javax.swing.JFrame {
    FornecedorController fc = new FornecedorController();                
    FornecedorModel fornecedorModel;
    Validar v = new Validar();
    FornecedorTableModel fornecedorTableModel= new FornecedorTableModel();        
    UsuarioModel usu;     
    
    public ConsultaFornecedor(UsuarioModel us) {        
        initComponents();
        configurarTabela();
        this.usu = us;
        acesso(us);
        setExtendedState(MAXIMIZED_BOTH);        
        setLocationRelativeTo(null);        
        tabela_fornecedor.setModel(fornecedorTableModel);
        setVisible(true);
    }
    
    List<FornecedorModel> listaFornecedores = new ArrayList<>();
    
    public FornecedorTableModel getModelo() {
	if(fornecedorTableModel == null){
            fornecedorTableModel = new FornecedorTableModel(listaFornecedores);
	}
	return fornecedorTableModel;		
    }
    
    public JTable getTabela(){
	if(tabela_fornecedor == null){
            tabela_fornecedor = new JTable();
            tabela_fornecedor.setModel(getModelo());
	}
            return tabela_fornecedor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbParametro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelDadosFornecedor = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_fornecedor = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Fornecedores");
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
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
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
        btnExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExcluirKeyPressed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Alterar Clientes");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNovoKeyPressed(evt);
            }
        });

        jLabel1.setText("Parametro");

        cmbParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Todos" }));
        cmbParametro.setSelectedIndex(2);
        cmbParametro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbParametroItemStateChanged(evt);
            }
        });

        jLabel2.setText("Descrição");

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
        btnConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmarKeyPressed(evt);
            }
        });

        jLabel4.setText("(Clique duas vezes com o botão esquerdo do mouse no campo para visualizar em nova janela.)");

        jLabel5.setText("Aperte F5 para atualizar a lista");

        tabela_fornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela_fornecedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabela_fornecedor.setModel(getModelo());
        tabela_fornecedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_fornecedor.setGridColor(new java.awt.Color(0, 51, 255));
        tabela_fornecedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_fornecedor);

        panelDadosFornecedor.setViewportView(jScrollPane1);

        jMenu1.setText("Arquivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem3.setText("Atualizar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Ajuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDadosFornecedor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtChave))
                    .addComponent(cmbParametro)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDadosFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        novo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        v.exibirAjudaConsulta("Cliente");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void tabela_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_fornecedorMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            if (evt.getClickCount() == 2) {
                if (usu.getNivel().equals("ADMINISTRADOR")) {
                    fornecedorModel = fornecedorTableModel.getFornecedor(tabela_fornecedor.getSelectedRow());                   
                AlterarFornecedor alterarFornecedor = new AlterarFornecedor(this, rootPaneCheckingEnabled,fornecedorModel);                    
                }else if(evt.getClickCount() == 2){
                    JOptionPane.showMessageDialog(null, "Você não possui acesso para alterar cadastros!","Hierarquia",JOptionPane.WARNING_MESSAGE);
                }
                
            }
        }     
    }//GEN-LAST:event_tabela_fornecedorMouseClicked

    private void btnConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarKeyPressed
        confirmar();
    }//GEN-LAST:event_btnConfirmarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
            dispose();
        }         
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                    
            excluir();
        }        
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                    
           novo();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void cmbParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParametroItemStateChanged
        txtChave.setText("");
    }//GEN-LAST:event_cmbParametroItemStateChanged

    private void txtChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyReleased
        txtChave.setText(txtChave.getText().toUpperCase());
    }//GEN-LAST:event_txtChaveKeyReleased

    private void txtChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            confirmar();
        }        
    }//GEN-LAST:event_txtChaveKeyPressed

    public void configurarTabela(){
        tabela_fornecedor.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela_fornecedor.getColumnModel().getColumn(2).setPreferredWidth(220);
        tabela_fornecedor.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabela_fornecedor.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela_fornecedor.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabela_fornecedor.getColumnModel().getColumn(6).setPreferredWidth(250);
        tabela_fornecedor.getColumnModel().getColumn(7).setPreferredWidth(75);
        tabela_fornecedor.getColumnModel().getColumn(8).setPreferredWidth(120);
        tabela_fornecedor.getColumnModel().getColumn(9).setPreferredWidth(120);
        tabela_fornecedor.getColumnModel().getColumn(10).setPreferredWidth(100);
        
    }    
    
  public void lista(int num, String param) throws SQLException, ClassNotFoundException{
        switch (num) {
            case 0:
                fornecedorTableModel.limpar();
                listaFornecedores = fc.listarCodigo(Integer.parseInt(param));
                fornecedorTableModel.addListaFornecedor(listaFornecedores);
                break;
            case 1:
                fornecedorTableModel.limpar();
                listaFornecedores = fc.listarTodosNome(param);
                fornecedorTableModel.addListaFornecedor(listaFornecedores);
                break;
            case 2:
                fornecedorTableModel.limpar();
                listaFornecedores = fc.listarTodosFornecedores();
                fornecedorTableModel.addListaFornecedor(listaFornecedores);
                break;
            default:
                throw new NullPointerException("Erro!!!!");
        }
    }  

    public void excluir(){
        try {            
            int codigo  = listaFornecedores.get(tabela_fornecedor.getSelectedRow()).getIdFornecedor();
            fornecedorTableModel.remover(tabela_fornecedor.getSelectedRow(),codigo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo(){
        this.dispose();
        CadastroFornecedor cad= new CadastroFornecedor(this, rootPaneCheckingEnabled,usu);            
    }
    
    public void confirmar(){
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void acesso(UsuarioModel u){
        if(u.getNivel().equals("PADRÃO")){
            btnExcluir.setVisible(false);
        }
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cmbParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane panelDadosFornecedor;
    private javax.swing.JTable tabela_fornecedor;
    private javax.swing.JTextField txtChave;
    // End of variables declaration//GEN-END:variables
}
