package view.validacao;

import java.awt.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *Classe que contem os metodos de validações dos campos de todas as views.
 */
public class Validar{
    
    public String converterMoeda(String valor){
        NumberFormat nf = new DecimalFormat("R$ ###,##0.00");                
        Float moeda;
        moeda = converteValorDigitadoemFloat(valor);
        return nf.format(moeda);        
    }
    
    public String converterMoeda(Double valor){
        NumberFormat nf = new DecimalFormat("R$ ###,##0.00");                                
        return nf.format(valor);        
    }
    
    public String converterPercentual(Double valor){
        NumberFormat nf = new DecimalFormat("##0.00"); 
        return nf.format(valor).concat("%");        
    }

    public String converterMoeda(Float valor){
        NumberFormat nf = new DecimalFormat("R$ ###,##0.00");                
        return nf.format(valor);        
    }    
    
    public Float converteValorDigitadoemFloat(String valor) {
        String formatoFloat = valor;
        formatoFloat = formatoFloat.replace(".", "");
        formatoFloat = formatoFloat.replace(",", ".");
        formatoFloat = formatoFloat.replace("R$ ", "");
        formatoFloat = formatoFloat.replace("%", "");
        Float val = Float.parseFloat(formatoFloat);
        return val;
    }

    public Double converteValorDigitadoemDouble(String valor) {
        String formatoDouble = valor;
        formatoDouble = formatoDouble.replace(".", "");
        formatoDouble = formatoDouble.replace(",", ".");
        formatoDouble = formatoDouble.replace("R$ ", "");
        formatoDouble = formatoDouble.replace("%", "");
        Double val = Double.parseDouble(formatoDouble);
        return val;
    }    
    
    public String FormatarData(Date data){
        try{
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String formato = formatter.format(data);
            return formato;
        }catch(Exception e){
            return null;
        }
    }
    
    public Date FormatarData(String data) throws ParseException{
        try{
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");       
            return new Date(formatter.parse(data).getTime());
        }catch(ParseException e){
            return null;
        }
    }
    
    public String formatarData(String data){
        String formatada = null;
        
        try {
            for(int x = 0;x < data.length(); x++){                
            }
        } catch (Exception e) {
            System.out.println("ERRO AO FORMATAR DATA DA TELA PRINCIPAL");          
        }
        return formatada;
    }    
    
    /**
     * Metodo que limpa todos os campos de textos dentro de um JPanel, ele percorre um array de componentes
     * e seta um valor em branco nos componentes que forem instancias de um campo de texto.
     * @param panel 
     */
    public void limpar(JPanel panel){        
        Component components[] = panel.getComponents();
        
        for (Component component : components) {
            //Textfield
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");                
            }
            //ComboBox
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
            //PassWordField
            if (component instanceof JPasswordField) {
                ((JPasswordField) component).setText("");
            }
            //RadioButtons
            if (component instanceof JRadioButton) {
                ((JRadioButton) component).setSelected(false);
            }
            //TextArea            
            if(component instanceof JTextArea){  
                ((JTextArea) component).setText(null);                      
            } 
        }
    }
    
    public void limpar(JScrollPane panel){        
        Component components[] = panel.getComponents();
        
        for (Component component : components) {
            //Textfield
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");                
            }
            //ComboBox
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
            //PassWordField
            if (component instanceof JPasswordField) {
                ((JPasswordField) component).setText("");
            }
            //RadioButtons
            if (component instanceof JRadioButton) {
                ((JRadioButton) component).setSelected(false);
            }
            //TextArea            
            if(component instanceof JTextArea){  
                ((JTextArea) component).setText(null);                      
            } 
        }
    }    
   /**
    * Metodo que valida se um campo de texto esta vazio ou nao, percorre um array de componentes recolhidos de um JPanel
    * apos isso verifica se eles contem algum valor.
    * @param panel 
    */
    public  void validarCampos(JPanel panel){
        Component components[] = panel.getComponents();        
        for (Component component : components) {
            if (component instanceof JTextField) {
                if (((JTextField) component).getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Existem campos vazios","Aviso",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }
    /**
     * Metodo de validação que deixa um campo aceitar apenas letras em campos de textos, recolhe um jtextfield
     * e valida-o deixando apenas receber letras.
     * @param campo 
     */
    public void validarLetras(JTextField campo){
        String num = campo.getText();
        //Character t = null;
        for (char c : num.toCharArray()){            
            if(Character.isDigit(c)){
                JOptionPane.showMessageDialog(null,"Este campo deve conter somente letras","Alerta", JOptionPane.WARNING_MESSAGE);
                campo.setText("");
                break;
            }
        }
    }
    /**
     * Metodo que valida um campo de texto para receber apenas numeros, recebe um paramentro de JTextField, recolhe o valor
     * no campo e valida-o.
     * @param campo 
     */
    public void validarNumeros(JTextField campo){
        String num = campo.getText();
        //Character t = null;
        for (char c : num.toCharArray()) {            
            if(Character.isLetter(c)){
                JOptionPane.showMessageDialog(null,"Este campo deve conter somente numeros","Alerta", JOptionPane.WARNING_MESSAGE);
                campo.setText("");
                break;
            }
        }
    }
    /*
     * Metodo que valida o CPF.
     * @param teste
     * @return 
     */
    public boolean validarCPF(String teste){
      if("".equals(teste)){
            return true;
      }
      teste = teste.replace(".", "");
      teste = teste.replace("-", "");        
      char digito1;
      char digito2;
      int soma;
      int num;
      int peso;
      int r;      
      if (teste.equals("00000000000") || teste.equals("11111111111") ||
        teste.equals("22222222222") || teste.equals("33333333333") ||
        teste.equals("44444444444") || teste.equals("55555555555") ||
        teste.equals("66666666666") || teste.equals("77777777777") ||
        teste.equals("88888888888") || teste.equals("99999999999") ||
       (teste.length() != 11)){
          JOptionPane.showMessageDialog(null, "Erro, CPF invalido","Validação",JOptionPane.ERROR_MESSAGE);
          return false;
      }             
      try{
          soma = 0;
          peso = 10;
          for (int i = 0; i < 9; i++) {
              num = (int)(teste.charAt(i) - 48);
              soma = soma +(num * peso);
              peso -=1;
          }          
          r = 11 - (soma % 11);          
          if(r == 10 || r == 11){
              digito1 = '0';
          }else{
              digito1 = (char)(r + 48);
          }
          soma = 0;
          peso = 11;
          for (int i = 0; i < 10; i++) {
              num = (int)(teste.charAt(i) - 48);
              soma = soma + (num * peso);
              peso -= 1;
          }          
          r = 11 - (soma % 11);
          if(r == 10 || r == 11){
              digito2 = '0';
          }else{
              digito2 = (char) (r + 48);
          }          
          if (digito1 == teste.charAt(9) && (digito2 == teste.charAt(10))){              
              return true;
          }else{
              JOptionPane.showMessageDialog(null, "Erro, CPF invalido","Validação",JOptionPane.ERROR_MESSAGE);
              return false;
          }      
      }catch(InputMismatchException e){
              e.getMessage();
              JOptionPane.showMessageDialog(null, "Erro, validação cancelada","Erro",JOptionPane.ERROR_MESSAGE);
              return false;
          }
  }
    /*
     * Metodo de validação do CNPJ.
     * @param CNPJ
     * @return 
     */
    public boolean validarCNPJ(String CNPJ) {
        if("".equals(CNPJ)){
            return true;
        }
        CNPJ = CNPJ.replace(".","");
        CNPJ = CNPJ.replace("-","");
        CNPJ = CNPJ.replace("/","");
    // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
       (CNPJ.length() != 14))
       return(false);
 
    char dig13, dig14;
    int sm, i, r, num, peso;
 
    // "try" - protege o código para eventuais erros de conversao de tipo (int)
    try {
    // Calculo do 1o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i=11; i>=0; i--) {
    // converte o i-ésimo caractere do CNPJ em um número:
    // por exemplo, transforma o caractere '0' no inteiro 0
    // (48 eh a posição de '0' na tabela ASCII)
        num = (int)(CNPJ.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }
 
      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig13 = '0';
      else dig13 = (char)((11-r) + 48);
 
    // Calculo do 2o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i=12; i>=0; i--) {
        num = (int)(CNPJ.charAt(i)- 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
           peso = 2;
      }
 
      r = sm % 11;
      if ((r == 0) || (r == 1))
         dig14 = '0';
      else dig14 = (char)((11-r) + 48);
 
    // Verifica se os dígitos calculados conferem com os dígitos informados.
      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
         return(true);
      else return(false);
    } catch (InputMismatchException erro) {
        return(false);
    }
  }
        
    public static Date formatarData(){
        java.util.Date agora = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat formata = new SimpleDateFormat("yyyy'-'MM'-'dd");
        formata.format(agora);
        return agora;
    }
    
    public static String formatarData(Date date){
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
        return formatarDate.format(date);
    }
    
    public static Date formatarTeste(Date data){
        //java.util.Date data = new java.util.Date();  
        SimpleDateFormat formata = new SimpleDateFormat("yyyy'-'MM'-'dd");        
        java.sql.Date dataSql = new java.sql.Date(data.getTime());        
        formata.format(dataSql);
        return dataSql;
    }         
    
    public static String formatarDataCheia(Date date){
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
        return formatarDate.format(date);
    }    

    public void confirmarSaida(){
        Integer op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?","Confirmação",JOptionPane.YES_NO_OPTION);        
        if(op == 0){
            System.exit(0);
        } 
    }

    /*MENSAGENS DE VALIDAÇÃO*/
    public void exibirConfirmacaoCadastro(String obj){
        JOptionPane.showMessageDialog(null,obj + " Cadastrado com Sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
    }        
    
    public void exibirConfirmacaoAlterarCadastro(String obj){
        JOptionPane.showMessageDialog(null,obj + " Alterado com Sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
    }   
    
    public void exibirErroCadastro(String obj){
        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + obj,"Erro",JOptionPane.ERROR_MESSAGE);
    }
    
    public void exibirErroAlterarCadastro(String obj){
        JOptionPane.showMessageDialog(null, "Erro ao Alterar " + obj,"Erro",JOptionPane.ERROR_MESSAGE);
    }    
    
    public void exibirCampoObrigatório(){
        JOptionPane.showMessageDialog(null, "Preencha Campos Obrigatórios","Campo Obrigatório",JOptionPane.WARNING_MESSAGE);
    }
 
    public void exibirAjudaConsulta(String obj){
        JOptionPane.showMessageDialog(null, " Essa tela serve para efetuar o consulta de "+ obj,"Ajuda",JOptionPane.INFORMATION_MESSAGE);
    }        
    
    public void exibirAjudaCadastro(String obj){
        JOptionPane.showMessageDialog(null, " Essa tela serve para efetuar o cadastro de "+ obj,"Ajuda",JOptionPane.INFORMATION_MESSAGE);
    }        
    
    public void exibirAjudaAlterar(String obj){
        JOptionPane.showMessageDialog(null, " Essa tela serve para efetuar o alteração do cadstro de "+ obj,"Ajuda",JOptionPane.INFORMATION_MESSAGE);
    }        
    
    public void sucesso(String obj){
        JOptionPane.showMessageDialog(null,obj + " gerada com Sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void sucessoMovimentar(String obj){
        JOptionPane.showMessageDialog(null,obj + " gerada com Sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void erroMovimentar(String obj){
        JOptionPane.showMessageDialog(null,obj + " gerada com Erro","Erro",JOptionPane.ERROR_MESSAGE);
    }
}