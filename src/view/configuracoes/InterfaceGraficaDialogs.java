package view.configuracoes;

/**
 *
 * @author Jonathan
 */
public class InterfaceGraficaDialogs extends javax.swing.JDialog{
    
    public  InterfaceGraficaDialogs(java.awt.Frame parent, boolean modal){
        super(parent, modal);
       //initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void iniciarModelo(){  
        setLocationRelativeTo(null);
        setVisible(true);
    }   
}
