package view.administrativo;

import controller.administrativo.FuncionarioController;
import java.awt.HeadlessException;
import view.consulta.ConsultaFuncionário;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.validacao.Validar;

public class CadastroFuncionarios extends javax.swing.JDialog {

    Validar validar = new Validar();
    String nome,cargo,nivel,login;
    Integer idFuncionario,status;
    
    public CadastroFuncionarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFuncionario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        cmbNivel = new javax.swing.JComboBox<>();
        txtLogin = new javax.swing.JTextField();
        lblImagemFunc = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtConfSenha = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setResizable(false);

        panelFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Básico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        panelFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        panelFuncionario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        panelFuncionario.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 290, -1));

        jLabel3.setText("Cargo");
        panelFuncionario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        jLabel4.setText("Nível");
        panelFuncionario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 40));

        jLabel5.setText("Login");
        panelFuncionario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        jLabel6.setText("Senha");
        panelFuncionario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        jLabel7.setText("Conf. Senha");
        panelFuncionario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, 20));

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargoKeyReleased(evt);
            }
        });
        panelFuncionario.add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 210, -1));

        cmbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Padrão" }));
        panelFuncionario.add(cmbNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 140, 30));

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        panelFuncionario.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 140, -1));

        lblImagemFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Funcionario.png"))); // NOI18N
        panelFuncionario.add(lblImagemFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 140, 130));
        panelFuncionario.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, -1));
        panelFuncionario.add(txtConfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 110, -1));

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

        jMenu1.setText("Arquivo");

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
                    .addComponent(panelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        cadastrarFuncionario();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            cadastrarFuncionario();
        }                
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        consultar();
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         validar.exibirAjudaCadastro("Funcionários");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnProcurarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnProcurarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
            consultar();
        }
    }//GEN-LAST:event_btnProcurarKeyPressed

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

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        txtNome.setText(txtNome.getText().toUpperCase());
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyReleased
        txtCargo.setText(txtCargo.getText().toUpperCase());
    }//GEN-LAST:event_txtCargoKeyReleased

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        txtLogin.setText(txtLogin.getText().toUpperCase());
    }//GEN-LAST:event_txtLoginKeyReleased

    private void consultar(){
        this.dispose();
        ConsultaFuncionário cf = new ConsultaFuncionário();                
    }
    
    private void limpar(){
        validar.limpar(panelFuncionario);
    }
    
    private void cadastrarFuncionario(){        
        try {
            nome =txtNome.getText();
            cargo = txtCargo.getText();
            status = 1;
            if(cmbNivel.getSelectedIndex()==0){
                nivel = "ADMINISTRADOR";
            }else{
                nivel = "PADRÃO";
            }            
            login = txtLogin.getText();                       
            String senha = new String(txtSenha.getPassword());
            String confirmarSenha = new String(txtConfSenha.getPassword());
            if(senha.equals(confirmarSenha)){
                FuncionarioController fc = new FuncionarioController();
                fc.inserirFuncionario(nome, cargo, nivel, login, senha, status);
                validar.exibirConfirmacaoCadastro("Funcionário");        
                limpar();
            }else{
                JOptionPane.showMessageDialog(null, "Senhas divergentes!","Divergência",JOptionPane.ERROR_MESSAGE);
                txtSenha.requestFocus();
            }               
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            validar.exibirErroCadastro("Funcionário");        
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblImagemFunc;
    private javax.swing.JPanel panelFuncionario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JPasswordField txtConfSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}