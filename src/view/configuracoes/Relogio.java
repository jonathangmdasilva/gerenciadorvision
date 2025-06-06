package view.configuracoes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.*;


public class Relogio extends JPanel{
          
    //declarando variáveis  
    JLabel lblHorario;
    int hh,mm,ss;  
    Calendar hora;  
    DecimalFormat formato;
      
      
    /* abrindo o método construtor da classe  
     * Esse trecho do código será o resposável pela CONSTRUÇÃO da interface gráfica                 
     */         
    public Relogio() {          
        
        setVisible(true);
        setSize(340, 52);
        setOpaque(false);
        
        lblHorario = new JLabel("");//configurando o label inicial  
        add(lblHorario);//adicionando o label configurado ao painel  
          
        Timer time = new Timer(1000,ativar);  
        time.start();     
          
    }  
      
    private void HORAS(){  
        hora = Calendar.getInstance();  
        hh = hora.get(Calendar.HOUR_OF_DAY);  
        mm = hora.get(Calendar.MINUTE);  
        ss = hora.get(Calendar.SECOND);
        //lblHorario.setFont(f);
        lblHorario.setFont(new Font("Courier New", Font.CENTER_BASELINE, 50));
        lblHorario.setForeground(Color.WHITE);
        
        lblHorario.setText(formatar(hh)+":"+formatar(mm)+":"+formatar(ss));  
              
    }  
  
    private String formatar(int num){  
        formato = new DecimalFormat("00");  
        return formato.format(num);  
    }  
    //metodo para ativar as horas  
    ActionListener ativar = (  
        new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                HORAS();  
            }  
          
        }  
    );
                
}
