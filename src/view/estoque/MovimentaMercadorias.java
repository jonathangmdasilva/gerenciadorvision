package view.estoque;

import controller.estoque.EstoqueController;
import controller.estoque.ProdutoController;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.estoque.EstoqueModel;
import model.estoque.ProdutoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class MovimentaMercadorias extends javax.swing.JDialog {

    Validar valida = new Validar();
    ProdutoController prodController = new ProdutoController();
    EstoqueController esController = new EstoqueController();
    ProdutoModel produto = new ProdutoModel();
    Double saldo;
    //Date data = new Date();
    
    public MovimentaMercadorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_abas = new javax.swing.JTabbedPane();
        panel_entrada = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoEntrada = new javax.swing.JTextField();
        txtDescricaoEntrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        btnMovimentarEntrada = new javax.swing.JButton();
        btnCancelarEnt = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSkuEntrada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSaldoEntrada = new javax.swing.JTextField();
        panel_saida = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoSaida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescricaoSaida = new javax.swing.JTextField();
        txtSaida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnMovimentarSaida = new javax.swing.JButton();
        btnCancelarSaida = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSkuSaida = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSaldoSaida = new javax.swing.JTextField();
        panel_automatico = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtCodigoAutomatico = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDescricaoAutomatico = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSkuAutomatico = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSaldoAutomatico = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtAutomatico = new javax.swing.JTextField();
        btnCancelarAut = new javax.swing.JButton();
        btnMovimentarAutomatico = new javax.swing.JButton();
        jmiMenu = new javax.swing.JMenuBar();
        jmiMenuArquivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiMenuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Estoque");
        setResizable(false);

        panel_abas.setMinimumSize(new java.awt.Dimension(540, 212));

        panel_entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panel_entradaFocusLost(evt);
            }
        });
        panel_entrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        panel_entrada.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        jLabel2.setText("Desc.:");
        panel_entrada.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        txtCodigoEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoEntradaFocusLost(evt);
            }
        });
        txtCodigoEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoEntradaKeyPressed(evt);
            }
        });
        panel_entrada.add(txtCodigoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        txtDescricaoEntrada.setEditable(false);
        panel_entrada.add(txtDescricaoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 460, -1));

        jLabel3.setText("Entrada");
        panel_entrada.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEntradaKeyReleased(evt);
            }
        });
        panel_entrada.add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, -1));

        btnMovimentarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Entrada_Produto.png"))); // NOI18N
        btnMovimentarEntrada.setToolTipText("Efetuar Entrada de Mercadoria");
        btnMovimentarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimentarEntradaActionPerformed(evt);
            }
        });
        btnMovimentarEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMovimentarEntradaKeyPressed(evt);
            }
        });
        panel_entrada.add(btnMovimentarEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 41));

        btnCancelarEnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelarEnt.setToolTipText("Cancelar Cadastro");
        btnCancelarEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEntActionPerformed(evt);
            }
        });
        btnCancelarEnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarEntKeyPressed(evt);
            }
        });
        panel_entrada.add(btnCancelarEnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        jLabel8.setText("Sku");
        panel_entrada.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txtSkuEntrada.setEditable(false);
        panel_entrada.add(txtSkuEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 230, -1));

        jLabel10.setText("Saldo");
        panel_entrada.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        txtSaldoEntrada.setEditable(false);
        txtSaldoEntrada.setForeground(new java.awt.Color(0, 51, 255));
        panel_entrada.add(txtSaldoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 110, -1));

        panel_abas.addTab("Entrada", panel_entrada);

        panel_saida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panel_saidaFocusLost(evt);
            }
        });
        panel_saida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Código");
        panel_saida.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        txtCodigoSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoSaidaFocusLost(evt);
            }
        });
        txtCodigoSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoSaidaKeyPressed(evt);
            }
        });
        panel_saida.add(txtCodigoSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        jLabel5.setText("Desc.:");
        panel_saida.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        txtDescricaoSaida.setEditable(false);
        panel_saida.add(txtDescricaoSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 460, -1));

        txtSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaidaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaidaKeyReleased(evt);
            }
        });
        panel_saida.add(txtSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, -1));

        jLabel6.setText("Saida");
        panel_saida.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        btnMovimentarSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Saida_Produto.png"))); // NOI18N
        btnMovimentarSaida.setToolTipText("Efetuar Saída de Mercadoria");
        btnMovimentarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimentarSaidaActionPerformed(evt);
            }
        });
        btnMovimentarSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMovimentarSaidaKeyPressed(evt);
            }
        });
        panel_saida.add(btnMovimentarSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 41));

        btnCancelarSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelarSaida.setToolTipText("Cancelar Cadastro");
        btnCancelarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSaidaActionPerformed(evt);
            }
        });
        btnCancelarSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarSaidaKeyPressed(evt);
            }
        });
        panel_saida.add(btnCancelarSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        jLabel7.setText("Sku");
        panel_saida.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txtSkuSaida.setEditable(false);
        panel_saida.add(txtSkuSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 230, -1));

        jLabel9.setText("Saldo");
        panel_saida.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        txtSaldoSaida.setEditable(false);
        txtSaldoSaida.setForeground(new java.awt.Color(0, 51, 255));
        panel_saida.add(txtSaldoSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 110, -1));

        panel_abas.addTab("Saída", panel_saida);

        panel_automatico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Código");
        panel_automatico.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        txtCodigoAutomatico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoAutomaticoFocusLost(evt);
            }
        });
        txtCodigoAutomatico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoAutomaticoKeyPressed(evt);
            }
        });
        panel_automatico.add(txtCodigoAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        jLabel12.setText("Desc.:");
        panel_automatico.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        txtDescricaoAutomatico.setEditable(false);
        panel_automatico.add(txtDescricaoAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 460, -1));

        jLabel13.setText("Sku");
        panel_automatico.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        txtSkuAutomatico.setEditable(false);
        panel_automatico.add(txtSkuAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 230, -1));

        jLabel14.setText("Saldo");
        panel_automatico.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        txtSaldoAutomatico.setEditable(false);
        txtSaldoAutomatico.setForeground(new java.awt.Color(0, 51, 255));
        panel_automatico.add(txtSaldoAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 110, -1));

        jLabel15.setText("Atual");
        panel_automatico.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        txtAutomatico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAutomaticoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAutomaticoKeyReleased(evt);
            }
        });
        panel_automatico.add(txtAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, -1));

        btnCancelarAut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelarAut.setToolTipText("Cancelar Cadastro");
        btnCancelarAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAutActionPerformed(evt);
            }
        });
        btnCancelarAut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarAutKeyPressed(evt);
            }
        });
        panel_automatico.add(btnCancelarAut, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        btnMovimentarAutomatico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Automatico_Produto.png"))); // NOI18N
        btnMovimentarAutomatico.setToolTipText("Acerto automático de Mercadoria");
        btnMovimentarAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimentarAutomaticoActionPerformed(evt);
            }
        });
        btnMovimentarAutomatico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnMovimentarAutomaticoKeyPressed(evt);
            }
        });
        panel_automatico.add(btnMovimentarAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 41));

        panel_abas.addTab("Automático", panel_automatico);

        jmiMenuArquivo.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiMenuArquivo.add(jMenuItem1);

        jmiMenu.add(jmiMenuArquivo);

        jmiMenuAjuda.setText("Ajuda");
        jmiMenu.add(jmiMenuAjuda);

        setJMenuBar(jmiMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_abas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_abas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCancelarEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEntActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarEntActionPerformed

    private void btnCancelarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSaidaActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarSaidaActionPerformed

    private void btnCancelarSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarSaidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            dispose();
        }
    }//GEN-LAST:event_btnCancelarSaidaKeyPressed

    private void btnCancelarEntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarEntKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            dispose();
        }        
    }//GEN-LAST:event_btnCancelarEntKeyPressed

    private void txtCodigoEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoEntradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            valida.validarNumeros(txtCodigoEntrada);
            //txtCodigoEntrada.requestFocus();
            buscaEntrada();
        }        
    }//GEN-LAST:event_txtCodigoEntradaKeyPressed

    private void txtCodigoSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoSaidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            valida.validarNumeros(txtCodigoSaida);
            //txtCodigoSaida.requestFocus();
            buscaSaida();
        }   
    }//GEN-LAST:event_txtCodigoSaidaKeyPressed

    private void btnMovimentarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentarEntradaActionPerformed
        entrada();
    }//GEN-LAST:event_btnMovimentarEntradaActionPerformed

    private void btnMovimentarEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMovimentarEntradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            entrada();
        }   
    }//GEN-LAST:event_btnMovimentarEntradaKeyPressed

    private void btnMovimentarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentarSaidaActionPerformed
        saida();
    }//GEN-LAST:event_btnMovimentarSaidaActionPerformed

    private void btnMovimentarSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMovimentarSaidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            saida();
        }   
    }//GEN-LAST:event_btnMovimentarSaidaKeyPressed

    private void txtEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyReleased
        valida.validarNumeros(txtEntrada);
    }//GEN-LAST:event_txtEntradaKeyReleased

    private void txtSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaidaKeyReleased
        valida.validarNumeros(txtSaida);
        txtSaida.requestFocus();
    }//GEN-LAST:event_txtSaidaKeyReleased

    private void panel_entradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panel_entradaFocusLost
        valida.limpar(panel_entrada);
    }//GEN-LAST:event_panel_entradaFocusLost

    private void panel_saidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panel_saidaFocusLost
        valida.limpar(panel_saida);
    }//GEN-LAST:event_panel_saidaFocusLost

    private void txtCodigoAutomaticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoAutomaticoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            valida.validarNumeros(txtCodigoAutomatico);
            //txtCodigoAutomatico.requestFocus();            
            buscaAutomatica();
        }   
    }//GEN-LAST:event_txtCodigoAutomaticoKeyPressed

    private void txtAutomaticoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutomaticoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutomaticoKeyReleased

    private void btnCancelarAutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAutActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarAutActionPerformed

    private void btnCancelarAutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarAutKeyPressed
        dispose();
    }//GEN-LAST:event_btnCancelarAutKeyPressed

    private void btnMovimentarAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentarAutomaticoActionPerformed
        acertoAutomatico();
    }//GEN-LAST:event_btnMovimentarAutomaticoActionPerformed

    private void btnMovimentarAutomaticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnMovimentarAutomaticoKeyPressed
        acertoAutomatico();
    }//GEN-LAST:event_btnMovimentarAutomaticoKeyPressed

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            entrada();
        }           
    }//GEN-LAST:event_txtEntradaKeyPressed

    private void txtSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaidaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            saida();
        }   
    }//GEN-LAST:event_txtSaidaKeyPressed

    private void txtAutomaticoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutomaticoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            acertoAutomatico();
        }   
    }//GEN-LAST:event_txtAutomaticoKeyPressed

    private void txtCodigoAutomaticoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoAutomaticoFocusLost
        valida.validarNumeros(txtCodigoAutomatico);
        //txtCodigoAutomatico.requestFocus();            
        buscaAutomatica();
    }//GEN-LAST:event_txtCodigoAutomaticoFocusLost

    private void txtCodigoSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoSaidaFocusLost
        valida.validarNumeros(txtCodigoSaida);
        //txtCodigoSaida.requestFocus();
        buscaSaida();
    }//GEN-LAST:event_txtCodigoSaidaFocusLost

    private void txtCodigoEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoEntradaFocusLost
        valida.validarNumeros(txtCodigoEntrada);
        //txtCodigoEntrada.requestFocus();
        buscaEntrada();        
    }//GEN-LAST:event_txtCodigoEntradaFocusLost

    private void buscaEntrada(){        
        txtEntrada.setEnabled(true);
        btnMovimentarEntrada.setEnabled(true);        
        try {
            int cod =  Integer. parseInt(txtCodigoEntrada.getText());
                produto = prodController.listarProdutoCodigoMovimentar(cod);
                saldo = esController.consultaSaldo(cod);
            if (!(produto==null)) {
                txtDescricaoEntrada.setText(produto.getDescricao());
                txtSkuEntrada.setText(produto.getSku());
                txtSaldoEntrada.setText(saldo.toString());
                txtEntrada.requestFocus();
            }else{
                txtDescricaoEntrada.setText("PRODUTO NÃO ENCONTRADO");                
                txtSkuEntrada.setText("PRODUTO NÃO ENCONTRADO");                
                txtSaldoEntrada.setText("0.0");
                txtEntrada.setEnabled(false);               
                btnMovimentarEntrada.setEnabled(false);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovimentaMercadorias.class.getName()).log(Level.SEVERE, null, ex);
            valida.erroMovimentar("Entrada");
        }
    }
    
    private void buscaSaida(){        
        txtSaida.setEnabled(true);
        btnMovimentarSaida.setEnabled(true);        
        try {
            int cod =  Integer. parseInt(txtCodigoSaida.getText());
            produto = prodController.listarProdutoCodigoMovimentar(cod);
            saldo = esController.consultaSaldo(cod);
            if (!(produto==null)) {
                txtDescricaoSaida.setText(produto.getDescricao());
                txtSkuSaida.setText(produto.getSku());
                txtSaldoSaida.setText(saldo.toString());
                txtSaida.requestFocus();
            }else{
                txtDescricaoSaida.setText("PRODUTO NÃO ENCONTRADO");                
                txtSkuSaida.setText("PRODUTO NÃO ENCONTRADO"); 
                txtSaldoSaida.setText("0.0");
                txtSaida.setEnabled(false);
                btnMovimentarSaida.setEnabled(false);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovimentaMercadorias.class.getName()).log(Level.SEVERE, null, ex);
            valida.erroMovimentar("Saida");
        }
    }

    private void buscaAutomatica(){        
        txtAutomatico.setEnabled(true);
        btnMovimentarAutomatico.setEnabled(true);        
        try {
            int cod =  Integer. parseInt(txtCodigoAutomatico.getText());
                produto = prodController.listarProdutoCodigoMovimentar(cod);
                saldo = esController.consultaSaldo(cod);
            if (!(produto==null)) {
                txtDescricaoAutomatico.setText(produto.getDescricao());
                txtSkuAutomatico.setText(produto.getSku());
                txtSaldoAutomatico.setText(saldo.toString());
                txtAutomatico.requestFocus();
            }else{
                txtDescricaoAutomatico.setText("PRODUTO NÃO ENCONTRADO");                
                txtSkuAutomatico.setText("PRODUTO NÃO ENCONTRADO");                
                txtSaldoAutomatico.setText("0.0");
                txtAutomatico.setEnabled(false);               
                btnMovimentarAutomatico.setEnabled(false);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovimentaMercadorias.class.getName()).log(Level.SEVERE, null, ex);
            valida.erroMovimentar("Entrada");
        }
    }
    
    
    private void entrada(){
        EstoqueModel entrada = new EstoqueModel();        
        try {
            entrada.setIdProduto(Integer.parseInt(txtCodigoEntrada.getText()));
            entrada.setQtd(Double.parseDouble(txtEntrada.getText()));
            entrada.setData(Validar.formatarData());
            EstoqueController ec = new EstoqueController();
            ec.inserirEntrada(entrada);
            produto.setIdProduto(Integer.parseInt(txtCodigoEntrada.getText()));
            produto.setSaldo(Double.parseDouble(txtSaldoEntrada.getText())+Double.parseDouble(txtEntrada.getText()));
            ec.atualizarSaldo(produto);
            limpar();
            valida.exibirConfirmacaoCadastro("Entrada");            
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            valida.exibirErroCadastro("Entrada");
        }
    }
    
    private void saida(){
        EstoqueModel saida = new EstoqueModel();
        try {
            saida.setIdProduto(Integer.parseInt(txtCodigoSaida.getText()));
            saida.setQtd(Double.parseDouble(txtSaida.getText()));            
            saida.setData(Validar.formatarData());
            EstoqueController ec = new EstoqueController();
            ec.inserirSaida(saida);
            produto.setIdProduto(Integer.parseInt(txtCodigoSaida.getText()));
            produto.setSaldo(Double.parseDouble(txtSaldoSaida.getText())-Double.parseDouble(txtSaida.getText()));
            ec.atualizarSaldo(produto);
            limpar();
            valida.exibirConfirmacaoCadastro("Saida");            
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            valida.exibirErroCadastro("Saida");            
        }                    
    }


    private void acertoAutomatico(){
        EstoqueModel mov = new EstoqueModel();        
        //ProdutoModel produto = new ProdutoModel();
        Double acerto;        
        try{
            if((Double.parseDouble(txtAutomatico.getText()) > (Double.parseDouble(txtSaldoAutomatico.getText())))){//FAZ ENTRADA
                acerto = (Double.parseDouble(txtAutomatico.getText()) - (Double.parseDouble(txtSaldoAutomatico.getText())));
                mov.setIdProduto(Integer.parseInt(txtCodigoAutomatico.getText()));
                produto.setIdProduto(Integer.parseInt(txtCodigoAutomatico.getText()));
                produto.setSaldo(Double.parseDouble(txtSaldoAutomatico.getText())+acerto);
                mov.setQtd(Double.parseDouble(txtAutomatico.getText()));            
                mov.setData(Validar.formatarData());
                EstoqueController ec = new EstoqueController();
                ec.inserirEntrada(mov);
                ec.atualizarSaldo(produto);
                limpar();
                JOptionPane.showMessageDialog(rootPane, "Acerto automático realizado com sucesso! Entrada no sistema");
            }else if((Double.parseDouble(txtAutomatico.getText()) < (Double.parseDouble(txtSaldoAutomatico.getText())))){//FAZ SAIDA
                acerto = (Double.parseDouble(txtSaldoAutomatico.getText()) - (Double.parseDouble(txtAutomatico.getText())));
                mov.setIdProduto(Integer.parseInt(txtCodigoAutomatico.getText()));
                produto.setIdProduto(Integer.parseInt(txtCodigoAutomatico.getText()));
                produto.setSaldo(Double.parseDouble(txtSaldoAutomatico.getText())-acerto);
                mov.setQtd(Double.parseDouble(txtAutomatico.getText()));            
                mov.setData(Validar.formatarData());
                EstoqueController ec = new EstoqueController();
                ec.inserirSaida(mov);
                ec.atualizarSaldo(produto);                
                limpar();
                JOptionPane.showMessageDialog(rootPane, "Acerto automático realizado com sucesso! Saída no sistema");
            }else{
                JOptionPane.showMessageDialog(rootPane, "O Saldo já está correto!");
            }                        
        }catch(HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e){
            valida.exibirErroCadastro("Automatico");
            JOptionPane.showMessageDialog(rootPane,e.getMessage());
        }
        
    }
    
    private void limpar(){
        valida.limpar(panel_saida);
        valida.limpar(panel_entrada);
        valida.limpar(panel_automatico);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarAut;
    private javax.swing.JButton btnCancelarEnt;
    private javax.swing.JButton btnCancelarSaida;
    private javax.swing.JButton btnMovimentarAutomatico;
    private javax.swing.JButton btnMovimentarEntrada;
    private javax.swing.JButton btnMovimentarSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar jmiMenu;
    private javax.swing.JMenu jmiMenuAjuda;
    private javax.swing.JMenu jmiMenuArquivo;
    private javax.swing.JTabbedPane panel_abas;
    private javax.swing.JPanel panel_automatico;
    private javax.swing.JPanel panel_entrada;
    private javax.swing.JPanel panel_saida;
    private javax.swing.JTextField txtAutomatico;
    private javax.swing.JTextField txtCodigoAutomatico;
    private javax.swing.JTextField txtCodigoEntrada;
    private javax.swing.JTextField txtCodigoSaida;
    private javax.swing.JTextField txtDescricaoAutomatico;
    private javax.swing.JTextField txtDescricaoEntrada;
    private javax.swing.JTextField txtDescricaoSaida;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    private javax.swing.JTextField txtSaldoAutomatico;
    private javax.swing.JTextField txtSaldoEntrada;
    private javax.swing.JTextField txtSaldoSaida;
    private javax.swing.JTextField txtSkuAutomatico;
    private javax.swing.JTextField txtSkuEntrada;
    private javax.swing.JTextField txtSkuSaida;
    // End of variables declaration//GEN-END:variables
}
