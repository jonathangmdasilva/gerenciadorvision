package backup;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * @author Jonathan
 */
public class Backup {
    
    JFileChooser salvarArquivo = new JFileChooser();
    
    public void relizarBackup(){
    // Botão Backup
        try{
            String arquivo = "";
            salvarArquivo.setVisible(true);                        
            int result = salvarArquivo.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                arquivo = salvarArquivo.getSelectedFile().toString().concat(".sql");
                File file = new File(arquivo); 
                if(file.exists()){
                    Object[] options = { "Sim", "Não" };
                    int opcao = JOptionPane.showOptionDialog(null,"Este arquivo já existe. Quer sobreescrever este arquivo?", "Atenção!!!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
                    if (opcao == JOptionPane.YES_OPTION) {                                                
                        String caminho = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\mysqldump.exe";
                        ProcessBuilder pb = new ProcessBuilder(caminho, "--user=root","--password=root", "bd_vision", "--result-file=" + arquivo);
                        pb.start();                      
                        JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.", "Opção YES!", 1);
                    }else{
                        JOptionPane.showMessageDialog(null, "Backup não realizado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                }else{                    
                    String caminho = "C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\mysqldump.exe";
                    ProcessBuilder pb = new ProcessBuilder(caminho, "--user=root","--password=root", "bd_vision", "--result-file=" + arquivo);
                    pb.start();
                    JOptionPane.showMessageDialog(null, "Backup realizado com sucesso.", "Opção Não!", 1);   
                }
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null,"Erro ao gerar Backup!:\n" + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }        
}