package view.diversos;

import controller.administrativo.ConfiguracaoController;
import controller.administrativo.ContatoController;
import controller.administrativo.EmpresaController;
import controller.administrativo.EnderecoController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.administrativo.ConfiguracaoModel;
import model.administrativo.ContatoModel;
import model.administrativo.EmpresaModel;
import model.administrativo.EnderecoModel;
import view.validacao.Validar;

/*
 * @author Jonathan
 */

public class ConfiguracaoSistema extends javax.swing.JDialog {
    Validar validar = new Validar();
    
    EnderecoModel endereco;
    ContatoModel contato;
    EmpresaModel empresa;        
    ConfiguracaoModel conf = new ConfiguracaoModel();
    
    public ConfiguracaoSistema(java.awt.Frame parent, boolean modal,EnderecoModel end,ContatoModel cont,EmpresaModel emp) {
        super(parent, modal);
        this.empresa = emp;
        this.endereco = end;
        this.contato = cont;
        initComponents();
        confInicial();
        setLocationRelativeTo(null);
        setVisible(true);
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblModulos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chbAdministrativo = new javax.swing.JCheckBox();
        chbEstoque = new javax.swing.JCheckBox();
        chbFinanceiro = new javax.swing.JCheckBox();
        chbLembretes = new javax.swing.JCheckBox();
        chbVendas = new javax.swing.JCheckBox();
        panelImagens = new javax.swing.JPanel();
        panelAdm = new javax.swing.JPanel();
        lblAdm = new javax.swing.JLabel();
        panelEstoque = new javax.swing.JPanel();
        lblEstoque = new javax.swing.JLabel();
        panelFinanceiro = new javax.swing.JPanel();
        lblFinanceiro = new javax.swing.JLabel();
        panelLembretes = new javax.swing.JPanel();
        lblLembretes = new javax.swing.JLabel();
        panelLembretes1 = new javax.swing.JPanel();
        lblVendas = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de Módulos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblModulos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblModulos.setText("Selecione os módulos desejados:");

        jLabel1.setText("Módulos:");

        chbAdministrativo.setText("Administrativo");
        chbAdministrativo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbAdministrativoItemStateChanged(evt);
            }
        });

        chbEstoque.setText("Estoque");
        chbEstoque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbEstoqueItemStateChanged(evt);
            }
        });

        chbFinanceiro.setText("Financeiro");
        chbFinanceiro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbFinanceiroItemStateChanged(evt);
            }
        });

        chbLembretes.setText("Lembretes");
        chbLembretes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbLembretesItemStateChanged(evt);
            }
        });

        chbVendas.setText("Vendas");
        chbVendas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbVendasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModulos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbEstoque)
                            .addComponent(chbAdministrativo)
                            .addComponent(chbFinanceiro)
                            .addComponent(chbLembretes)
                            .addComponent(chbVendas))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModulos)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chbAdministrativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbFinanceiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbLembretes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbVendas)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelAdm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblAdm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Administrativo.png"))); // NOI18N
        lblAdm.setEnabled(false);

        javax.swing.GroupLayout panelAdmLayout = new javax.swing.GroupLayout(panelAdm);
        panelAdm.setLayout(panelAdmLayout);
        panelAdmLayout.setHorizontalGroup(
            panelAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAdmLayout.setVerticalGroup(
            panelAdmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelEstoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblEstoque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Estoque.png"))); // NOI18N
        lblEstoque.setEnabled(false);

        javax.swing.GroupLayout panelEstoqueLayout = new javax.swing.GroupLayout(panelEstoque);
        panelEstoque.setLayout(panelEstoqueLayout);
        panelEstoqueLayout.setHorizontalGroup(
            panelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEstoqueLayout.setVerticalGroup(
            panelEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFinanceiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Financeiro.png"))); // NOI18N
        lblFinanceiro.setEnabled(false);

        javax.swing.GroupLayout panelFinanceiroLayout = new javax.swing.GroupLayout(panelFinanceiro);
        panelFinanceiro.setLayout(panelFinanceiroLayout);
        panelFinanceiroLayout.setHorizontalGroup(
            panelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFinanceiroLayout.setVerticalGroup(
            panelFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLembretes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblLembretes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLembretes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Notas.png"))); // NOI18N
        lblLembretes.setEnabled(false);

        javax.swing.GroupLayout panelLembretesLayout = new javax.swing.GroupLayout(panelLembretes);
        panelLembretes.setLayout(panelLembretesLayout);
        panelLembretesLayout.setHorizontalGroup(
            panelLembretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLembretes, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLembretesLayout.setVerticalGroup(
            panelLembretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLembretes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLembretes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblVendas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vendas.png"))); // NOI18N
        lblVendas.setEnabled(false);

        javax.swing.GroupLayout panelLembretes1Layout = new javax.swing.GroupLayout(panelLembretes1);
        panelLembretes1.setLayout(panelLembretes1Layout);
        panelLembretes1Layout.setHorizontalGroup(
            panelLembretes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLembretes1Layout.setVerticalGroup(
            panelLembretes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLembretes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelImagensLayout = new javax.swing.GroupLayout(panelImagens);
        panelImagens.setLayout(panelImagensLayout);
        panelImagensLayout.setHorizontalGroup(
            panelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagensLayout.createSequentialGroup()
                .addComponent(panelAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLembretes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLembretes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelImagensLayout.setVerticalGroup(
            panelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLembretes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLembretes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Confirmar.png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbAdministrativoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbAdministrativoItemStateChanged
        if (chbAdministrativo.isSelected()){  
            lblAdm.setEnabled(true);
            this.conf.setAdm(1);
        }else{
            lblAdm.setEnabled(false);
            this.conf.setAdm(0);
        }
    }//GEN-LAST:event_chbAdministrativoItemStateChanged

    private void chbEstoqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbEstoqueItemStateChanged
        if (chbEstoque.isSelected()){  
            lblEstoque.setEnabled(true);
            this.conf.setEstoque(1);
        }else{
            lblEstoque.setEnabled(false);
            this.conf.setEstoque(0);
        }
    }//GEN-LAST:event_chbEstoqueItemStateChanged

    private void chbFinanceiroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbFinanceiroItemStateChanged
        if (chbFinanceiro.isSelected()){  
            lblFinanceiro.setEnabled(true);
            this.conf.setFinanceiro(1);
        }else{
            lblFinanceiro.setEnabled(false);
            this.conf.setFinanceiro(0);
        }        
    }//GEN-LAST:event_chbFinanceiroItemStateChanged

    private void chbLembretesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbLembretesItemStateChanged
        if (chbLembretes.isSelected()){  
            lblLembretes.setEnabled(true);
            this.conf.setLembrete(1);
        }else{
            lblLembretes.setEnabled(false);
            this.conf.setLembrete(0);
        }        
    }//GEN-LAST:event_chbLembretesItemStateChanged

    private void chbVendasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbVendasItemStateChanged
        if (chbVendas.isSelected()){  
            chbEstoque.setSelected(true);
            chbAdministrativo.setSelected(true);
            lblVendas.setEnabled(true);
            this.conf.setVendas(1);
        }else{
            lblVendas.setEnabled(false);            
            this.conf.setVendas(0);
        }
    }//GEN-LAST:event_chbVendasItemStateChanged

    private void confInicial(){        
        this.conf.setAdm(0);
        this.conf.setEstoque(0);
        this.conf.setFinanceiro(0);
        this.conf.setLembrete(0);
        this.conf.setVendas(0);
    }
    
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        EmpresaController ec = new EmpresaController();
        ConfiguracaoController cc = new ConfiguracaoController();
        conf.setIdEmpresa(1);
        try {
            ec.inserirEmpresa(empresa);            
            //CONTATO
            contato.setIdEmpresa(1);
            ContatoController contatoController = new ContatoController();
            contatoController.inserirContatoEmpresa(contato);                        
            //ENDEREÇO
            EnderecoController enderecoController = new EnderecoController();            
            enderecoController.inserirEnderecoEmpresa(endereco);            
            validar.exibirConfirmacaoCadastro("Empresa");
            cc.inserirConfiguracao(conf);                        
            this.dispose();            
            try {
                SplashView splash = new SplashView();
                Thread.sleep(1600);
                splash.dispose();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR PROCESSO SPLASH","ERRO",JOptionPane.ERROR_MESSAGE);
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            validar.exibirErroCadastro("Empresa");
        }                
    }//GEN-LAST:event_btnFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JCheckBox chbAdministrativo;
    private javax.swing.JCheckBox chbEstoque;
    private javax.swing.JCheckBox chbFinanceiro;
    private javax.swing.JCheckBox chbLembretes;
    private javax.swing.JCheckBox chbVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdm;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblFinanceiro;
    private javax.swing.JLabel lblLembretes;
    private javax.swing.JLabel lblModulos;
    private javax.swing.JLabel lblVendas;
    private javax.swing.JPanel panelAdm;
    private javax.swing.JPanel panelEstoque;
    private javax.swing.JPanel panelFinanceiro;
    private javax.swing.JPanel panelImagens;
    private javax.swing.JPanel panelLembretes;
    private javax.swing.JPanel panelLembretes1;
    // End of variables declaration//GEN-END:variables
}