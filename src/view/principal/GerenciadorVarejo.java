package view.principal;

import conexao.Conexao;
import controller.administrativo.EmpresaController;
import java.sql.SQLException;
import view.administrativo.CadastroEmpresa;
import view.configuracoes.InterfaceGraficaJFrame;
import view.diversos.SplashView;

public class GerenciadorVarejo {

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException{      
               
        EmpresaController empC= new EmpresaController();
        Conexao c = new Conexao();
        //Cria um objeto referente a classe que seta o Nimbus da Interface gráfica/
        InterfaceGraficaJFrame itg = new InterfaceGraficaJFrame();
        //Seta o Nimbus como Interface Padrão da Aplicação
        itg.iniciarNimbus();        
        if((empC.validaEmpresa()) &&(c.getConnection()!=null)){
            SplashView splash = new SplashView();
            Thread.sleep(1600);
            splash.dispose();
        }else if(!(empC.validaEmpresa())&&(c.getConnection()!=null)){
            CadastroEmpresa cadEmpresa = new CadastroEmpresa(null, true);
        }
    }    
}