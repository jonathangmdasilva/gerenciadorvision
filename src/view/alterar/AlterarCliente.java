package view.alterar;

import controller.administrativo.ClienteController;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.administrativo.ClienteModel;
import view.validacao.Validar;

public final class AlterarCliente extends javax.swing.JDialog{
    
    //DEFININDO VARIÁVEIS PADRÕES DO CADASTRO CLIENTE
    Validar validar = new Validar();    
    String nome,cpf,cnpj,email,tipo,telefoneUm,telefoneDois,logradouro,cidade,bairro;
    Integer status,numero,estado,idCliente;
    String estados[]={"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
    ClienteModel cliente;
    //public AlterarCliente(java.awt.Frame parent, boolean modal) {        
    public AlterarCliente(java.awt.Frame parent, boolean modal,ClienteModel cli) {        
        super(parent, modal);
        this.cliente = cli;        
        initComponents();
        setLocationRelativeTo(null);        
        setVisible(true);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controleTipoPessoa = new javax.swing.ButtonGroup();
        panelBasico = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefoneUm = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jrbFisica = new javax.swing.JRadioButton();
        jrbJuridica = new javax.swing.JRadioButton();
        lblImagemCliente = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTelefoneDois = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        panelEndereco = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar de Cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBasico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Básico Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        panelBasico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome.:");
        panelBasico.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jLabel2.setText("Cnpj.:");
        panelBasico.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jLabel3.setText("Cpf.:");
        panelBasico.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        panelBasico.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 320, -1));

        txtCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCnpjFocusLost(evt);
            }
        });
        panelBasico.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 240, -1));

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        panelBasico.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, -1));

        jLabel4.setText("E-mail.:");
        panelBasico.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        panelBasico.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 320, -1));

        lblTelefone.setText("Tel Um.:");
        panelBasico.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));
        panelBasico.add(txtTelefoneUm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 130, -1));

        jLabel5.setText("Pessoa.:");
        panelBasico.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        controleTipoPessoa.add(jrbFisica);
        jrbFisica.setText("Fisica");
        jrbFisica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbFisicaItemStateChanged(evt);
            }
        });
        panelBasico.add(jrbFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        controleTipoPessoa.add(jrbJuridica);
        jrbJuridica.setText("Juridica");
        jrbJuridica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbJuridicaStateChanged(evt);
            }
        });
        panelBasico.add(jrbJuridica, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        lblImagemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente(x128).png"))); // NOI18N
        panelBasico.add(lblImagemCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 120, 160));

        jLabel11.setText("Tel Dois.:");
        panelBasico.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, 30));
        panelBasico.add(txtTelefoneDois, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 140, -1));

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

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alterar.png"))); // NOI18N
        btnSalvar.setText("Alterar");
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

        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        panelEndereco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Lograd.:");
        panelEndereco.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 33, 50, -1));

        jLabel7.setText("Num.:");
        panelEndereco.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 60, 40, 20));

        jLabel8.setText("Bairro.:");
        panelEndereco.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel9.setText("Cidade.:");
        panelEndereco.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyReleased(evt);
            }
        });
        panelEndereco.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 330, -1));
        panelEndereco.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 120, -1));

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });
        panelEndereco.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 330, -1));

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });
        panelEndereco.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 170, -1));

        jLabel12.setText("Estado.:");
        panelEndereco.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 30));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        cmbEstado.setMinimumSize(new java.awt.Dimension(59, 20));
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        panelEndereco.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 120, 190, 30));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBasico, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(panelEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnLimpar))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        if (jrbFisica.isSelected()) {
            if(validar.validarCPF(txtCpf.getText())){
                gravar();
                dispose();
            }else{
                txtCpf.requestFocus();
            }    
        }
        if(jrbJuridica.isSelected()){
            if(validar.validarCNPJ(txtCnpj.getText())){
                gravar();
                dispose();
            }else{
                txtCnpj.requestFocus();
            }
        }                
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        gravar();
        dispose();
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         validar.exibirAjudaCadastro("Cliente");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jrbFisicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbFisicaItemStateChanged
        if(jrbFisica.isSelected()){
            txtCnpj.setEnabled(false);
            txtCnpj.setText("");
            txtCpf.setEnabled(true);
            tipo = "Fisica";
        }        
    }//GEN-LAST:event_jrbFisicaItemStateChanged

    private void jrbJuridicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbJuridicaStateChanged
        if(jrbJuridica.isSelected()){
            txtCpf.setEnabled(false);
            txtCpf.setText("");
            txtCnpj.setEnabled(true);
            tipo = "Juridica";
        }
    }//GEN-LAST:event_jrbJuridicaStateChanged

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        txtNome.setText(txtNome.getText().toUpperCase());
    }//GEN-LAST:event_txtNomeKeyReleased

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        estado = cmbEstado.getSelectedIndex()+1;            
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        txtEmail.setText(txtEmail.getText().toUpperCase());        
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogradouroKeyReleased
        txtLogradouro.setText(txtLogradouro.getText().toUpperCase());
    }//GEN-LAST:event_txtLogradouroKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        txtBairro.setText(txtBairro.getText().toUpperCase());
    }//GEN-LAST:event_txtBairroKeyReleased

    private void txtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyReleased
        txtCidade.setText(txtCidade.getText().toUpperCase());
    }//GEN-LAST:event_txtCidadeKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregarInfs(cliente);        
    }//GEN-LAST:event_formWindowOpened

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

    private void txtCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnpjFocusLost
        if(!validar.validarCNPJ(txtCnpj.getText())){
            JOptionPane.showMessageDialog(null, "Cnpj Invalido","Invalido",JOptionPane.ERROR_MESSAGE);
            txtCnpj.setText("");
        }        
    }//GEN-LAST:event_txtCnpjFocusLost

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        if(!validar.validarCPF(txtCpf.getText())){            
            txtCpf.setText("");
        }
    }//GEN-LAST:event_txtCpfFocusLost

    private void gravar(){
        try {
            //INICIANDO VALORES DE CLIENTE
            if(jrbFisica.isSelected()){
                cliente.setCpf(txtCpf.getText());
                cliente.setCnpj("");
            }else if (jrbJuridica.isSelected()){
                cliente.setCnpj(txtCnpj.getText());
                cliente.setCpf("");
            } 
            cliente.setNome(txtNome.getText());
            
            if(cliente.getCpf().isEmpty()){
                cliente.setTipo("Juridica");
            }else{
                cliente.setTipo("Fisica");
            }            
            //INICIANDO VARIÁVEIS DE CONTATO
            cliente.getContato().setEmail( txtEmail.getText());
            cliente.getContato().setTelUm(txtTelefoneUm.getText());
            cliente.getContato().setTelDois(txtTelefoneDois.getText());
            //INICIANDO VARIÁVEIS DE ENDEREÇO
            cliente.getEndereco().setLogradouro(txtLogradouro.getText());
            cliente.getEndereco().setNumero(Integer.parseInt(txtNumero.getText()));
            cliente.getEndereco().setCidade(txtCidade.getText());
            cliente.getEndereco().setBairro(txtBairro.getText());
            cliente.getEndereco().getEstado().setIdEstado(cmbEstado.getSelectedIndex()+1);                        
            //CLIENTE
            ClienteController clienteController = new ClienteController();
            clienteController.alterarCliente(cliente);                                    
            validar.exibirConfirmacaoAlterarCadastro("Cliente");                 
            this.dispose();
        } catch (ClassNotFoundException | NumberFormatException | SQLException | NullPointerException n) {
            validar.exibirErroAlterarCadastro("Cliente");
        }        
    }

    private void carregarInfs(ClienteModel cliente){
        //DADOS CLIENTE
       txtNome.setText(cliente.getNome());
        if(cliente.getCpf().isEmpty()){
            jrbJuridica.setSelected(true);
        }else{
            jrbFisica.setSelected(true);
        }        
        txtCpf.setText(cliente.getCpf());
        txtCnpj.setText(cliente.getCnpj());
        //DADOS CONTATO
        txtEmail.setText(cliente.getContato().getEmail());
        txtTelefoneUm.setText(cliente.getContato().getTelUm());
        txtTelefoneDois.setText(cliente.getContato().getTelDois());        
        int indice =0;
        while (!cliente.getEndereco().getEstado().getNomeEstado().equals(estados[indice])) {
            indice++;            
        } 
        //DADOS ENDEREÇO
        txtLogradouro.setText(cliente.getEndereco().getLogradouro());
        txtNumero.setText(cliente.getEndereco().getNumero().toString());
        txtBairro.setText(cliente.getEndereco().getBairro());
        txtCidade.setText(cliente.getEndereco().getCidade());
        cmbEstado.setSelectedIndex(indice);      
    }

    public void limpar(){
        validar.limpar(panelBasico);
        validar.limpar(panelEndereco);        
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.ButtonGroup controleTipoPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButton jrbFisica;
    private javax.swing.JRadioButton jrbJuridica;
    private javax.swing.JLabel lblImagemCliente;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefoneDois;
    private javax.swing.JTextField txtTelefoneUm;
    // End of variables declaration//GEN-END:variables
}