package view.contas;

import controller.contas.ContasPagarController;
import view.consulta.ConsultaContaPagar;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.administrativo.UsuarioModel;
import model.contas.ContasPagarModel;
import view.validacao.Validar;

public class CadastroContasPagar extends javax.swing.JDialog {

    Validar validar = new Validar();
    ContasPagarModel  pagar = new ContasPagarModel();
    UsuarioModel usuario;
    
    public CadastroContasPagar(java.awt.Frame parent, boolean modal,UsuarioModel usu) {
        super(parent, modal);
        this.usuario = usu;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        txtCedente = new javax.swing.JTextField();
        txtNumeroDocumento = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtVencimento = new javax.swing.JFormattedTextField();
        txtEmissao = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas à Pagar");
        setResizable(false);

        panelContas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cedente.:");
        panelContas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 51, -1));

        jLabel2.setText("Nº Doc.:");
        panelContas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jLabel3.setText("Valor.:");
        panelContas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, -1, 20));

        jLabel4.setText("Emissão.:");
        panelContas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel5.setText("Venc.:");
        panelContas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel6.setText("Status.:");
        panelContas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel7.setText("Observação.:");
        panelContas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        txtObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservacaoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtObservacao);

        panelContas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 530, 120));

        txtCedente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedenteKeyReleased(evt);
            }
        });
        panelContas.add(txtCedente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 350, -1));
        panelContas.add(txtNumeroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 170, -1));

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });
        panelContas.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, -1));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABERTO", "PAGO" }));
        panelContas.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pagar.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        panelContas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 130, 140));

        try {
            txtVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVencimento.setText("");
        txtVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVencimentoFocusLost(evt);
            }
        });
        panelContas.add(txtVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 120, -1));

        try {
            txtEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEmissao.setText("");
        panelContas.add(txtEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png"))); // NOI18N
        btnSalvar.setText("Cadastrar");
        btnSalvar.setToolTipText("Salvar Cadastro");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Procurar.png"))); // NOI18N
        btnProcurar.setText("Consultar");
        btnProcurar.setToolTipText("Procurar Clientes");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });
        btnProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnProcurarKeyPressed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        btnLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimparKeyPressed(evt);
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

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Fechar");
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
            .addComponent(panelContas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContas, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnProcurar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {        
            gravar();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            try {        
                gravar();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        this.dispose();
        ConsultaContaPagar ccp = new ConsultaContaPagar(usuario);
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnProcurarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProcurarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();        
            ConsultaContaPagar ccp = new ConsultaContaPagar(usuario);
        } 
    }//GEN-LAST:event_btnProcurarKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        validar.exibirAjudaCadastro("Contas a Pagar");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        txtValor.setText(validar.converterMoeda(txtValor.getText()));
    }//GEN-LAST:event_txtValorFocusLost

    private void txtCedenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedenteKeyReleased
        txtCedente.setText(txtCedente.getText().toUpperCase());
    }//GEN-LAST:event_txtCedenteKeyReleased

    private void txtObservacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacaoKeyReleased
        txtObservacao.setText(txtObservacao.getText().toUpperCase());
    }//GEN-LAST:event_txtObservacaoKeyReleased

    private void btnLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLimparKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
            limpar();
        }        
    }//GEN-LAST:event_btnLimparKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
            dispose();
        }        
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void txtVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVencimentoFocusLost
        try {
            pagar.setEmissaoConta(Validar.formatarTeste(validar.FormatarData(txtEmissao.getText())));
            pagar.setVencimentoConta(Validar.formatarTeste(validar.FormatarData(txtVencimento.getText())));
            if(pagar.getVencimentoConta().before(pagar.getEmissaoConta())){
                JOptionPane.showMessageDialog(null,"Vencimento deve ser maior ou igual a emissão","Erro com datas",JOptionPane.ERROR_MESSAGE);
                txtVencimento.setText(null);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastroContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtVencimentoFocusLost

    private void gravar() throws ParseException{        
        try {
            pagar.setCedente(txtCedente.getText());
            pagar.setNumeroConta(txtNumeroDocumento.getText());
            pagar.setValorConta(validar.converteValorDigitadoemDouble(txtValor.getText()));        
            pagar.setEmissaoConta(Validar.formatarTeste(validar.FormatarData(txtEmissao.getText())));
            pagar.setVencimentoConta(Validar.formatarTeste(validar.FormatarData(txtVencimento.getText())));
            switch (cmbStatus.getSelectedIndex()) {
                case 0:
                    pagar.setStatus("ABERTO");
                    break;
                case 1:
                    pagar.setStatus("PAGO");
                    break;
            }            
            pagar.setObservacaoConta(txtObservacao.getText());
            pagar.setTipo("PAGAR");
            ContasPagarController pagarController = new ContasPagarController();
            pagarController.inserirContasPagar(pagar);            
            validar.exibirConfirmacaoCadastro("Contas à Pagar");
            this.dispose();
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            validar.exibirErroCadastro("Conta a Pagar");
        }    
    }
    
    private void limpar(){
        validar.limpar(panelContas);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContas;
    private javax.swing.JTextField txtCedente;
    private javax.swing.JFormattedTextField txtEmissao;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtValor;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
