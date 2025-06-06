package view.configuracoes;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Panel;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jonathan
 */
public class InterfaceGraficaJFrame extends JFrame{

    public void iniciarNimbus(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar Nimbus","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
