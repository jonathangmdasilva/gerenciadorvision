package view.diversos;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


public class Splash extends Thread{
    
    JProgressBar barra;
    
    public Splash(JProgressBar barra){
        super();
        this.barra = barra;        
    }
    
    @Override
    public void run(){                
       int i =0;
       while(i<=100){           
           barra.setValue(i);
           i++;
           try {
               sleep(15);
           } catch (InterruptedException ex) {
               JOptionPane.showMessageDialog(null, "Erro ao carregar Splash: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
           }           
       }       
       Login login = new Login(null, true);           
    }            
}