package view.consulta;

import controller.administrativo.EmpresaController;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import model.administrativo.ContatoModel;
import model.administrativo.EmpresaModel;
import model.administrativo.EnderecoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class ConsultaEmpresa extends javax.swing.JDialog {

    Validar validar = new Validar();
    EnderecoModel endereco = new EnderecoModel();
    ContatoModel contato = new ContatoModel();
    EmpresaModel empresa = new EmpresaModel();
    
    public ConsultaEmpresa(java.awt.Frame parent, boolean modal) throws SQLException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        carregarDados();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefoneDois = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        btn_cancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de empresa");
        setResizable(false);

        panel_empresas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel_empresas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Razão Social");
        panel_empresas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 20));

        txtRazao.setEditable(false);
        panel_empresas.add(txtRazao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 280, -1));

        lbl_cnpj.setText("CNPJ");
        panel_empresas.add(lbl_cnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));

        txtCnpj.setEditable(false);
        panel_empresas.add(txtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, -1));

        jLabel4.setText("Tel. 1");
        panel_empresas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        txtTelefoneUm.setEditable(false);
        panel_empresas.add(txtTelefoneUm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        jLabel12.setText("E-mail.:");
        panel_empresas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        txtEmail.setEditable(false);
        panel_empresas.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 340, -1));

        jLabel5.setText("Rua");
        panel_empresas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 40));

        txtLogradouro.setEditable(false);
        panel_empresas.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 420, -1));

        jLabel15.setText("Bairro");
        panel_empresas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        txtBairro.setEditable(false);
        panel_empresas.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, -1));

        jLabel11.setText("Cidade");
        panel_empresas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 20));

        txtCidade.setEditable(false);
        panel_empresas.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 210, -1));

        jLabel16.setText("Est.:");
        panel_empresas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 20));

        jLabel13.setText("Numero");
        panel_empresas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 20));

        txtNumero.setEditable(false);
        panel_empresas.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empresa.png"))); // NOI18N
        panel_empresas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, -1));

        jLabel2.setText("Tel. 2");
        panel_empresas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtTelefoneDois.setEditable(false);
        panel_empresas.add(txtTelefoneDois, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));

        jLabel6.setText("Insc. Estadual");
        panel_empresas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtIE.setEditable(false);
        panel_empresas.add(txtIE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, -1));

        txtEstado.setEditable(false);
        panel_empresas.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 130, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_empresas, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_empresas, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void btn_cancelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            dispose();
        }
    }//GEN-LAST:event_btn_cancelaKeyPressed

    private void carregarDados() throws SQLException, ClassNotFoundException{
        EmpresaController empCont = new EmpresaController();
        empresa = empCont.consultaEmpresa();
        txtRazao.setText(empresa.getRazaoSocial());
        txtIE.setText(empresa.getInscricaoEstadual());
        txtCnpj.setText(empresa.getCnpj());
        
        txtEmail.setText(empresa.getContato().getEmail());
        txtTelefoneUm.setText(empresa.getContato().getTelUm());
        txtTelefoneDois.setText(empresa.getContato().getTelDois());
        
        txtLogradouro.setText(empresa.getEndereco().getLogradouro());
        txtCidade.setText(empresa.getEndereco().getCidade());
        txtNumero.setText(empresa.getEndereco().getNumero().toString());
        txtEstado.setText(empresa.getEndereco().getEstado().getNomeEstado());
        txtBairro.setText(empresa.getEndereco().getBairro());
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancela;
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
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JTextField txtTelefoneDois;
    private javax.swing.JTextField txtTelefoneUm;
    // End of variables declaration//GEN-END:variables
}
