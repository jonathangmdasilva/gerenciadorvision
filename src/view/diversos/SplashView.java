package view.diversos;

//import viewer.diversos.Splash;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


public class SplashView extends JFrame {

    
    Splash splash;
    public SplashView() {
        
        initComponents();
        setVisible(true);
        //com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.95f);
        setLocationRelativeTo(null);        
        iniciarSplash();
        splash = new Splash(progresso);        
        iniciarSplash();
        splash.start();
        splash=null;                
    }
    
    public final void iniciarSplash(){
        try{            
            getProgresso().setBorderPainted(true);            
            getProgresso().setForeground(new Color(255,255,255));
            getProgresso().setStringPainted(true);            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao carregar Splash","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        progresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo-Splash.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        progresso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progresso.setForeground(new java.awt.Color(102, 255, 0));
        progresso.setPreferredSize(new java.awt.Dimension(146, 28));
        getContentPane().add(progresso, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progresso;
    // End of variables declaration//GEN-END:variables

    public JProgressBar getProgresso() {
        return progresso;
    }
}
