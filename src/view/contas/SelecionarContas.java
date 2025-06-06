package view.contas;

import model.administrativo.UsuarioModel;

public class SelecionarContas extends javax.swing.JDialog {

    UsuarioModel usuario;
    
    public SelecionarContas(java.awt.Frame parent, boolean modal, UsuarioModel usu) {
        super(parent, modal);
        this.usuario = usu;
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setUndecorated(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeleção = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        btnReceber = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de Tipo de Contas");
        setUndecorated(true);

        btnPagar.setText("Contas Pagar");
        btnPagar.setToolTipText("Cadastrar Contas à Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnReceber.setText("Contas Receber");
        btnReceber.setToolTipText("Cadastrar Contas a Receber");
        btnReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSeleçãoLayout = new javax.swing.GroupLayout(panelSeleção);
        panelSeleção.setLayout(panelSeleçãoLayout);
        panelSeleçãoLayout.setHorizontalGroup(
            panelSeleçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleçãoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSeleçãoLayout.setVerticalGroup(
            panelSeleçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeleçãoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeleçãoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeleção, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeleção, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceberActionPerformed
        this.dispose();
        CadastroContasReceber ccr = new CadastroContasReceber(null, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnReceberActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        this.dispose();
        CadastroContasPagar ccp = new CadastroContasPagar(null, true,usuario);
    }//GEN-LAST:event_btnPagarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnReceber;
    private javax.swing.JPanel panelSeleção;
    // End of variables declaration//GEN-END:variables
}
