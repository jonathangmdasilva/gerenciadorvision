package view.administrativo;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.administrativo.ContatoModel;
import model.administrativo.EmpresaModel;
import model.administrativo.EnderecoModel;
import view.diversos.ConfiguracaoSistema;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class CadastroEmpresa extends javax.swing.JDialog {

    Validar validar = new Validar();
    EnderecoModel endereco = new EnderecoModel();
    ContatoModel contato = new ContatoModel();
    EmpresaModel empresa = new EmpresaModel();
    
    public CadastroEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_empresas = new javax.swing.JPanel();
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
        jLabel6 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        btn_cancela = new javax.swing.JButton();
        btn_cadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de empresa");
        setResizable(false);

        panel_empresas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel_empresas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Razão Social");
        panel_empresas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 20));

        txtRazao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazaoKeyReleased(evt);
            }
        });
        panel_empresas.add(txtRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 280, -1));

        lbl_cnpj.setText("CNPJ");
        panel_empresas.add(lbl_cnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

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
        panel_empresas.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, -1));

        jLabel4.setText("Tel. 1");
        panel_empresas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));
        panel_empresas.add(txtTelefoneUm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        jLabel12.setText("E-mail.:");
        panel_empresas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        panel_empresas.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 340, -1));

        jLabel5.setText("Rua");
        panel_empresas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 40));

        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyReleased(evt);
            }
        });
        panel_empresas.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 420, -1));

        jLabel15.setText("Bairro");
        panel_empresas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });
        panel_empresas.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, -1));

        jLabel11.setText("Cidade");
        panel_empresas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCidadeKeyReleased(evt);
            }
        });
        panel_empresas.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 210, -1));

        jLabel16.setText("Est.:");
        panel_empresas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 20));

        jLabel13.setText("Numero");
        panel_empresas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 20));

        txtNumero.setText("0");
        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroFocusGained(evt);
            }
        });
        panel_empresas.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 130, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        panel_empresas.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empresa.png"))); // NOI18N
        panel_empresas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, -1));

        jLabel2.setText("Tel. 2");
        panel_empresas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        panel_empresas.add(txtTelefoneDois, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));

        jLabel6.setText("Insc. Estadual");
        panel_empresas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        panel_empresas.add(txtIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, -1));

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

        btn_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salvar.png"))); // NOI18N
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setPreferredSize(new java.awt.Dimension(120, 41));
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        btn_cadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cadastrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_empresas, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_empresas, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoKeyReleased
        txtRazao.setText(txtRazao.getText().toUpperCase());
    }//GEN-LAST:event_txtRazaoKeyReleased

    private void txtCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnpjFocusLost
        if(!validar.validarCNPJ(txtCnpj.getText())){
            JOptionPane.showMessageDialog(panel_empresas, "Cnpj Inválido","Invalido",JOptionPane.ERROR_MESSAGE);
            txtCnpj.setText("");
            txtCnpj.requestFocus();
        }
    }//GEN-LAST:event_txtCnpjFocusLost

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

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void btn_cancelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_cancelaKeyPressed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        cadastro();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void btn_cadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cadastrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cadastro();
        }
    }//GEN-LAST:event_btn_cadastrarKeyPressed

    private void txtNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusGained
        txtNumero.setText("");
    }//GEN-LAST:event_txtNumeroFocusGained
    
    private void cadastro(){
        this.dispose();
        //DADOS EMPRESA        
        empresa.setIdEmpresa(1);
        empresa.setRazaoSocial(txtRazao.getText());        
        empresa.setCnpj(txtCnpj.getText());
        empresa.setInscricaoEstadual(txtIE.getText());
        //DADOS CONTATO
        contato.setIdEmpresa(1);
        contato.setTelUm(txtTelefoneUm.getText());
        contato.setTelDois(txtTelefoneDois.getText());
        contato.setEmail(txtEmail.getText());                
        //DADOS ENDERECO
        endereco.setIdEmpresa(1);
        endereco.setLogradouro(txtLogradouro.getText());
        endereco.setNumero(Integer.parseInt(txtNumero.getText()));
        endereco.setCidade(txtCidade.getText());
        endereco.setBairro(txtBairro.getText());           
        endereco.setIdEstado(cmbEstado.getSelectedIndex()+1);                
        ConfiguracaoSistema cs = new ConfiguracaoSistema(null, true,endereco,contato,empresa);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_cancela;
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
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel lbl_cnpj;
    private javax.swing.JPanel panel_empresas;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    public javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JTextField txtTelefoneDois;
    private javax.swing.JTextField txtTelefoneUm;
    // End of variables declaration//GEN-END:variables
}
