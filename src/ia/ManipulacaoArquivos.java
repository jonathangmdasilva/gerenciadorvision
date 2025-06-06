package ia;

import conexao.Conexao;
import controller.estoque.ProdutoController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.estoque.CategoriaModel;
import model.estoque.ProdutoModel;

/*
 * @author Jonathan
 */

public class ManipulacaoArquivos {
    private final Connection c ;
    String caminho = new File("").getAbsolutePath();
    ProdutoController prodCont = new ProdutoController();    
    
    public ManipulacaoArquivos() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }  
          
    public void gerarTxt(String alg,Integer codigo) throws SQLException {                
        removerArquivos();
        String sql = "";
        String cam = new File("").getAbsolutePath();
        String arquivoTxt = "/weka.txt";                
        cam = cam.replace("\\", "/");           
        this.caminho = cam;                       
        //mysqld --secure-file-priv=""﻿
        if(alg.equals("apriori")){
            sql = "SELECT T4.Descricao_Produto,T5.Descricao_Cat_Prod,T2.Status_Pedido FROM TB_ASSOC_ITEM_PEDIDO T1, TB_PEDIDO T2, TB_CLIENTE T3, TB_PRODUTO T4,TB_CATEGORIA_PRODUTO T5 WHERE T1.Id_Pedido = T2.Id_Pedido AND T1.Id_Produto = T4.Id_Produto AND T2.Id_Cliente = T3.Id_Cliente AND T3.Id_Cliente = ? AND T4.Id_Cat_Produto = T5.Id_Cat_Prod INTO OUTFILE '" + cam + arquivoTxt + "' FIELDS TERMINATED BY ',' ENCLOSED BY'\' LINES TERMINATED BY '\n';";                          
        }else {            
            sql = "null";
        }                
        try ( 
            PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1,codigo);                        
            // executa
            stmt.execute();
            stmt.close();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao gerar .txt: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }                
    }    
         
    public void gerarArffApriori() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{                
        String cam = new File("").getAbsolutePath();        
        cam = cam.replace("\\", "/");           
        this.caminho = cam;        
        String cat = "", prod ="";
                
        List <CategoriaModel> listaCategorias = new ArrayList<>();
        List <ProdutoModel> listaProdutos = new ArrayList<>();
        ProdutoController pc = new ProdutoController();
        listaCategorias = pc.listarTodosCategorias();
        listaProdutos = pc.listarTodosProdutos();
        
        for(int x =0;x<listaCategorias.size();x++){
            if(listaCategorias.get(x).getDescricao().contains(" ")) listaCategorias.get(x).setDescricao(listaCategorias.get(x).getDescricao().replace(" ", "_"));
            cat = cat + listaCategorias.get(x).getDescricao() + ",";
        }        
        String catModificada = cat.substring(0,cat.length()-1);
        
        for(int x =0;x<listaProdutos.size();x++){
            if(listaProdutos.get(x).getDescricao().contains(" ")) listaProdutos.get(x).setDescricao(listaProdutos.get(x).getDescricao().replace(" ", "_"));
            prod = prod + listaProdutos.get(x).getDescricao() + ",";
        }                
        String prodModificada = prod.substring(0,prod.length()-1);
                
        String arquivoTxt = "/weka.txt", arquivoArff = "/weka.arff";
        String relacao ="@relation Comercio";
        String atributoUm = "@attribute Descricao:  {"+prodModificada+"}", atributoDois ="@attribute Categoria:  {"+catModificada+"}",atributoTres="@attribute Pedido:  {PAGO,CANCELADO}";
        String dados ="@data";    
                
        try{
            java.nio.file.Path path = Paths.get(caminho.concat(arquivoTxt));
            java.nio.file.Path arff = Paths.get(caminho + arquivoArff);                         
            List<String> linhas = new ArrayList<>();
            List<String> linhasDois = Files.readAllLines(path);
            for(int x = 0;x<linhasDois.size();x++){
                if(linhasDois.get(x).contains(" ")){                    
                    linhasDois.set(x, linhasDois.get(x).replace(" ", "_"));        
                }
            }            
            linhas.add(relacao);
            linhas.add("");
            linhas.add(atributoUm);
            linhas.add(atributoDois);
            linhas.add(atributoTres);            
            linhas.add("");
            linhas.add(dados);
            linhas.addAll(linhasDois);            
            Files.write(path , linhas);                        
            Files.copy(path, arff,StandardCopyOption.REPLACE_EXISTING);            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Erro na Edição do Arff: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            removerArquivos();
       }                                
        
    } 
    public void removerArquivos(){
        String cam = new File("").getAbsolutePath();        
        cam = cam.replace("\\", "/");        
        try {
            String arquivoTxt = "/weka.txt", arquivoArff = "/weka.arff",arquivoPdf = "/Relatório Inventário.pdf" ;        
            
            //EXCLUSÃO DE ARQUIVO TXT
            String caminhoTxt = cam.concat(arquivoTxt);
            File fileTxt = new File(caminhoTxt);        
            if(fileTxt.exists()){
                fileTxt.delete();                
            }                                                
            //EXCLUSÃO DE ARQUIVO ARFF
            String caminhoArff = cam.concat(arquivoArff);            
            File fileArff = new File(caminhoArff);        
            if(fileArff.exists()){                
                fileArff.delete();                
            }
            //EXCLUSÃO DE ARQUIVO PDF
            String caminhoPdf = cam.concat(arquivoPdf);            
            File filePdf = new File(caminhoPdf);        
            if(filePdf.exists()){                
                filePdf.delete();                
            }                                               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar remover arquivos TXT e ARFF: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }                
    }
}