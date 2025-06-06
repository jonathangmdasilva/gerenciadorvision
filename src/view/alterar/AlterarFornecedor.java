package view.alterar;

import controller.administrativo.ContatoController;
import controller.administrativo.EnderecoController;
import controller.estoque.FornecedorController;
import view.consulta.ConsultaFornecedor;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.administrativo.ContatoModel;
import model.administrativo.EnderecoModel;
import model.estoque.FornecedorModel;
import view.validacao.Validar;


public class AlterarFornecedor extends javax.swing.JDialog {
    
    Validar validar = new Validar();
    FornecedorModel fornecedor = new FornecedorModel();
    ContatoModel contato = new ContatoModel();
    EnderecoModel endereco = new EnderecoModel();
    String estados[]={"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};    
    Integer idFornecedor; 
    
    public AlterarFornecedor(java.awt.Frame parent, boolean modal,FornecedorModel fornecedor) {
        super(parent, modal);
        this.fornecedor = fornecedor;        
        initComponents();                
        carregarInfs(fornecedor);
        setLocationRelativeTo(null);
        setVisible(true);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        btn_cadastra = new javax.swing.JButton();
        btn_limpa = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        panel_forne = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        lbl_cnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefoneUm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefoneDois = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmi_arquivo = new javax.swing.JMenu();
        jmi_arquivo_sair = new javax.swing.JMenuItem();
        jmiAjuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Fornecedor");
        setResizable(false);

        jLabel7.setText("Cadastro de Fornecedor");

        btn_cadastra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alterar.png"))); // NOI18N
        btn_cadastra.setText("Alterar");
        btn_cadastra.setPreferredSize(new java.awt.Dimension(120, 41));
        btn_cadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastraActionPerformed(evt);
            }
        });
        btn_cadastra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cadastraKeyPressed(evt);
            }
        });

        btn_limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Limpar.png"))); // NOI18N
        btn_limpa.setText("Limpar");
        btn_limpa.setPreferredSize(new java.awt.Dimension(117, 41));
        btn_limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpaActionPerformed(evt);
            }
        });
        btn_limpa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_limpaKeyPressed(evt);
            }
        });

        btn_cancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btn_cancela.setText("Cancelar");
        btn_cancela.setPreferredSize(new java.awt.Dimension(120, 41));
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });
        btn_cancela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cancelaKeyPressed(evt);
            }
        });

        panel_forne.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel_forne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Razão Social");
        panel_forne.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 20));

        txtRazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazaoKeyReleased(evt);
            }
        });
        panel_forne.add(txtRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 280, -1));

        lbl_cnpj.setText("CNPJ");
        panel_forne.add(lbl_cnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        txtCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCnpjFocusLost(evt);
            }
        });
        txtCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCnpjKeyReleased(evt);
            }
        });
        panel_forne.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, -1));

        jLabel4.setText("Tel. 1");
        panel_forne.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));
        panel_forne.add(txtTelefoneUm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, -1));

        jLabel12.setText("E-mail.:");
        panel_forne.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 20));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        panel_forne.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));

        jLabel5.setText("Rua");
        panel_forne.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 40));

        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyReleased(evt);
            }
        });
        panel_forne.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 420, -1));

        jLabel15.setText("Bairro");
        panel_forne.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });
        panel_forne.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 210, -1));

        jLabel11.setText("Cidade");
        panel_forne.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });
        panel_forne.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, -1));

        jLabel16.setText("Est.:");
        panel_forne.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, 20));

        jLabel13.setText("Numero");
        panel_forne.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 20));
        panel_forne.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 110, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        panel_forne.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 110, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fornecedor(x128).png"))); // NOI18N
        panel_forne.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, -1));

        jLabel2.setText("Tel. 2");
        panel_forne.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        panel_forne.add(txtTelefoneDois, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        jmi_arquivo.setText("Arquivo");

        jmi_arquivo_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jmi_arquivo_sair.setText("Sair");
        jmi_arquivo_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_arquivo_sairActionPerformed(evt);
            }
        });
        jmi_arquivo.add(jmi_arquivo_sair);

        jMenuBar1.add(jmi_arquivo);

        jmiAjuda.setText("Ajuda");

        jMenuItem1.setText("Ajuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiAjuda.add(jMenuItem1);

        jMenuBar1.add(jmiAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_forne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btn_cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_limpa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_forne, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void btn_limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpaActionPerformed
        limpar();
    }//GEN-LAST:event_btn_limpaActionPerformed

    private void jmi_arquivo_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_arquivo_sairActionPerformed
        dispose();        
    }//GEN-LAST:event_jmi_arquivo_sairActionPerformed

    private void btn_cancelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){         
           dispose();
        }
    }//GEN-LAST:event_btn_cancelaKeyPressed

    private void btn_limpaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_limpaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){         
            validar.limpar(panel_forne);            
        }
    }//GEN-LAST:event_btn_limpaKeyPressed

    private void btn_cadastraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cadastraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            try {
                alterarFornecedor();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_btn_cadastraKeyPressed

    private void btn_cadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastraActionPerformed
        try {
            alterarFornecedor();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cadastraActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        validar.exibirAjudaCadastro("Fornecedor");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtRazaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoKeyReleased
        txtRazao.setText(txtRazao.getText().toUpperCase());
    }//GEN-LAST:event_txtRazaoKeyReleased

    private void txtCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCnpjKeyReleased
        txtCnpj.setText(txtCnpj.getText().toUpperCase());
    }//GEN-LAST:event_txtCnpjKeyReleased

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

    private void txtCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnpjFocusLost
        if(!validar.validarCNPJ(txtCnpj.getText())){
            JOptionPane.showMessageDialog(panel_forne, "Cnpj Inválido","Invalido",JOptionPane.ERROR_MESSAGE);
            txtCnpj.setText("");
        }
    }//GEN-LAST:event_txtCnpjFocusLost
    
    public void limpar(){
        validar.limpar(panel_forne);        
    }
    
    private void alterarFornecedor() throws SQLException, ClassNotFoundException{
        try {
            //INICIANDO VALORES DE CLIENTE
            fornecedor.setRazaoSocial(txtRazao.getText());
            fornecedor.setCnpj(txtCnpj.getText());                                    
            //INICIANDO VARIÁVEIS DE CONTATO
            fornecedor.getContato().setEmail(txtEmail.getText());
            fornecedor.getContato().setTelUm(txtTelefoneUm.getText());
            fornecedor.getContato().setTelDois(txtTelefoneDois.getText());
            //INICIANDO VARIÁVEIS DE ENDEREÇO
            fornecedor.getEndereco().setLogradouro(txtLogradouro.getText());
            fornecedor.getEndereco().setNumero(Integer.parseInt(txtNumero.getText()));
            fornecedor.getEndereco().setCidade(txtCidade.getText());
            fornecedor.getEndereco().setBairro(txtBairro.getText());
            fornecedor.getEndereco().getEstado().setIdEstado(cmbEstado.getSelectedIndex()+1);            
            //FORNECEDOR
            FornecedorController fornecedorController = new FornecedorController();
            fornecedorController.alterarFornecedor(fornecedor);                                    
            idFornecedor = fornecedorController.listarQtdFornecedores();            
            //CONTATO
            ContatoController contatoController = new ContatoController();
            contatoController.alterarContatoFornecedor(fornecedor);                        
            //ENDEREÇO
            EnderecoController enderecoController = new EnderecoController();
            enderecoController.alterarEnderecoFornecedor(fornecedor);            
            //VALIDAR SE CADASTRO FOI FEITO COM SUCESSO
            validar.exibirConfirmacaoCadastro("Fornecedor");
            this.dispose();           
        } catch (NumberFormatException | NullPointerException n) {
            validar.exibirErroCadastro("Fornecedor");
        }        
    }    
    
    public void carregarInfs(FornecedorModel fornecedor){
        //DADOS CLIENTE
        txtRazao.setText(fornecedor.getRazaoSocial());        
        txtCnpj.setText(fornecedor.getCnpj());
        //DADOS CONTATO
        txtEmail.setText(fornecedor.getContato().getEmail());
        txtTelefoneUm.setText(fornecedor.getContato().getTelUm());
        txtTelefoneDois.setText(fornecedor.getContato().getTelDois());        
        int indice =0;
        while (!fornecedor.getEndereco().getEstado().getNomeEstado().equals(estados[indice])) {
            indice++;            
        }        
        //DADOS ENDEREÇO
        txtLogradouro.setText(fornecedor.getEndereco().getLogradouro());
        txtNumero.setText(fornecedor.getEndereco().getNumero().toString());
        txtBairro.setText(fornecedor.getEndereco().getBairro());
        txtCidade.setText(fornecedor.getEndereco().getCidade());
        cmbEstado.setSelectedIndex(indice);      
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastra;
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_limpa;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmiAjuda;
    private javax.swing.JMenu jmi_arquivo;
    private javax.swing.JMenuItem jmi_arquivo_sair;
    public javax.swing.JLabel lbl_cnpj;
    private javax.swing.JPanel panel_forne;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    public javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JTextField txtTelefoneDois;
    private javax.swing.JTextField txtTelefoneUm;
    // End of variables declaration//GEN-END:variables
}
