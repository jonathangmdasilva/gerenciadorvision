package view.vendas;

import ia.InteligenciaArtificial;
import ia.ManipulacaoArquivos;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import weka.associations.Apriori;

/*
 * @author Jonathan
 */

public class MomentoDeOuro extends javax.swing.JDialog {
    
    Apriori apri;
    
    public MomentoDeOuro(java.awt.Frame parent, boolean modal,Apriori ap) {
        super(parent, modal);
        initComponents();
        this.apri = ap;
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCabecalho = new javax.swing.JLabel();
        lblOpcao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMomento = new javax.swing.JTextArea();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Momento de Ouro");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCabecalho.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lblCabecalho.setText("Seja mais dinâmico veja as oportunidades!");
        getContentPane().add(lblCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblOpcao.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblOpcao.setForeground(new java.awt.Color(255, 255, 255));
        lblOpcao.setText("Ofereça os seguintes produtos para seu cliente!");
        getContentPane().add(lblOpcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txaMomento.setEditable(false);
        txaMomento.setColumns(20);
        txaMomento.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txaMomento.setRows(5);
        jScrollPane1.setViewportView(txaMomento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 620, 280));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ouro.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            ManipulacaoArquivos mpa = new ManipulacaoArquivos(); 
            InteligenciaArtificial ia = new InteligenciaArtificial();                                            
            txaMomento.setText(apri.toString());            
            String informacao = txaMomento.getText(290,233);            
            JOptionPane.showMessageDialog(null,"Ofereça " + ia.sugestao(informacao));            
            mpa.removerArquivos();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar carregar arquivos: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            ManipulacaoArquivos mpa = new ManipulacaoArquivos();                                   
            mpa.removerArquivos();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao fechar a tela Momento de Ouro: " + ex.getMessage());
        }        
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblOpcao;
    private javax.swing.JTextArea txaMomento;
    // End of variables declaration//GEN-END:variables
}
