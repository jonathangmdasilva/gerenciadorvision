package view.diversos;
/**
 * @author Jonathan
 */
public class Sobre extends javax.swing.JDialog { 
    public Sobre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jheaInformacoes = new org.jdesktop.swingx.JXHeader();
        jButton1 = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre");
        setMinimumSize(new java.awt.Dimension(635, 375));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jheaInformacoes.setDescription("\nO Gerenciado de Pequenos Varejos 2017 é um software desenvolvido por alunos do curso de Análise e Desenvolvimento de Sistemas da Fatec Zona Sul\n\nCriado:10/08/2017\nVersão: 1.9.8             Data:04/10/2018                Hora: 18:50:38\nCopyright 2017\nE-mail: visiontecnologia@gmail.com\n");
        jheaInformacoes.setTitle("Informações,");
        jheaInformacoes.setToolTipText(null);
        jheaInformacoes.setFocusable(false);
        jheaInformacoes.setName("JdSobre"); // NOI18N
        jheaInformacoes.setPaintBorderInsets(false);
        jheaInformacoes.setRequestFocusEnabled(false);
        getContentPane().add(jheaInformacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 620, 150));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 200, 180));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sobre.jpg"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private org.jdesktop.swingx.JXHeader jheaInformacoes;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}