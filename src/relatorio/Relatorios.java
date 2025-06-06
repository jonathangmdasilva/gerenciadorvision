package relatorio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexao.Conexao;
import controller.vendas.PedidoController;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import model.estoque.InventarioModel;
import model.vendas.PedidoModel;
import view.validacao.Validar;
//IMPORTS JASPER 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/*
 * @author Jonathan
 */
public class Relatorios {

    PedidoController pedidoController = new PedidoController();
    public static final String DESTINO = "/Relatórios/Relatório.pdf";    
    
    
    public static void gerarPdfPedidos(List<PedidoModel> listp) throws SQLException, ClassNotFoundException {
        Validar valida = new Validar();
        Document doc = new Document(PageSize.A4,10, 10, 10, 10);
        
        String arquivoPdf = "Relatório Pedidos.pdf";

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
            doc.open();
            doc.add(new Paragraph(Validar.formatarData(new Date())));            
            doc.add(new Paragraph("Relatório de Pedidos",FontFactory.getFont(FontFactory.TIMES_ROMAN, 24,Font.BOLD)));
            Paragraph p = new Paragraph(" ");
            p.setAlignment(1);            
            doc.add(p);

            //PdfPTable table = new PdfPTable(7);
            PdfPTable table = new PdfPTable(new float[] {0.05f,0.3f,0.1f,0.1f,0.1f,0.12f,0.13f});
            table.setWidthPercentage(100.0f);
            table.setHorizontalAlignment(1);

            PdfPCell cel1 = new PdfPCell(new Paragraph("Cod."));                        
            PdfPCell cel2 = new PdfPCell(new Paragraph("Cliente\t"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Subtotal"));
            PdfPCell cel4 = new PdfPCell(new Paragraph("Total Pedido"));
            PdfPCell cel5 = new PdfPCell(new Paragraph("Desconto"));
            PdfPCell cel6 = new PdfPCell(new Paragraph("Observação\t"));
            PdfPCell cel7 = new PdfPCell(new Paragraph("Data"));

            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);
            table.addCell(cel5);
            table.addCell(cel6);
            table.addCell(cel7);

            for (PedidoModel pedido : listp) {
                cel1 = new PdfPCell(new Paragraph(pedido.getCodigoPedido() + " "));
                cel2 = new PdfPCell(new Paragraph(pedido.getCliente().getNome() + "\t"));
                cel3 = new PdfPCell(new Paragraph(valida.converterMoeda(pedido.getSubTotal()) + ""));
                cel4 = new PdfPCell(new Paragraph(valida.converterMoeda(pedido.getTotal()) + " "));
                cel5 = new PdfPCell(new Paragraph(valida.converterMoeda(pedido.getDesconto()) + " "));
                cel6 = new PdfPCell(new Paragraph(pedido.getObservacao() + "\t"));
                cel7 = new PdfPCell(new Paragraph(valida.FormatarData(pedido.getDataHora())));

                table.addCell(cel1);
                table.addCell(cel2);
                table.addCell(cel3);
                table.addCell(cel4);
                table.addCell(cel5);
                table.addCell(cel6);
                table.addCell(cel7);                                    
            }
            doc.add(table);            
            doc.addAuthor("Jonathan Gomes");
            doc.close();
            doc.setPageCount(1);
            Desktop.getDesktop().open(new File(arquivoPdf));
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar PDF", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    public static void gerarPdfInventario(List<InventarioModel> listp){       
        Font vermelha = FontFactory.getFont(FontFactory.HELVETICA, Font.DEFAULTSIZE, Font.BOLD, new BaseColor(BaseColor.RED.getRGB()));
        Font preta = FontFactory.getFont(FontFactory.HELVETICA, Font.DEFAULTSIZE, Font.BOLD, new BaseColor(BaseColor.BLACK.getRGB()));
        Font f = null;
        Document doc = new Document(PageSize.A4,12, 12, 12, 12);        
        String arquivoPdf = "Relatório Inventário.pdf";

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
            doc.open();
            doc.add(new Paragraph(Validar.formatarData(new Date())));
            
            doc.add(new Paragraph("Inventário",FontFactory.getFont(FontFactory.TIMES_ROMAN, 24,Font.BOLD)));
            Paragraph p = new Paragraph("  ");                       
            doc.add(p);            

            PdfPTable table = new PdfPTable(new float[] {0.1f,0.4f,0.1f,0.1f,0.1f,0.1f});
            table.setWidthPercentage(100.0f);
            table.setHorizontalAlignment(1);

            PdfPCell cel1 = new PdfPCell(new Paragraph("Prod."));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Descrição  \t"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Min."));
            PdfPCell cel4 = new PdfPCell(new Paragraph("Max."));
            PdfPCell cel5 = new PdfPCell(new Paragraph("Saldo"));
            PdfPCell cel6 = new PdfPCell(new Paragraph("Acerto"));
           
            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);
            table.addCell(cel5);            
            table.addCell(cel6);            

            for (InventarioModel iventario : listp) {               
                if(iventario.getSaldo()<=iventario.getProduto().getMinimo()){
                    cel1 = new PdfPCell(new Phrase(iventario.getProduto().getIdProduto().toString(),vermelha));
                    cel2 = new PdfPCell(new Phrase(iventario.getProduto().getDescricao(),vermelha));                
                    cel3 = new PdfPCell(new Phrase(iventario.getProduto().getMinimo().toString(),vermelha));
                    cel4 = new PdfPCell(new Phrase(iventario.getProduto().getMaximo().toString(),vermelha));
                    cel5 = new PdfPCell(new Phrase(iventario.getSaldo()+"",vermelha));                
                    cel6 = new PdfPCell(new Phrase("                   \t     "));                
                }else{
                    cel1 = new PdfPCell(new Phrase(iventario.getProduto().getIdProduto().toString(),preta));
                    cel2 = new PdfPCell(new Phrase(iventario.getProduto().getDescricao(),preta));                
                    cel3 = new PdfPCell(new Phrase(iventario.getProduto().getMinimo().toString(),preta));
                    cel4 = new PdfPCell(new Phrase(iventario.getProduto().getMaximo().toString(),preta));
                    cel5 = new PdfPCell(new Phrase(iventario.getSaldo()+"",preta));                
                    cel6 = new PdfPCell(new Phrase("                   \t     "));                
                }                                                
                table.addCell(cel1);
                table.addCell(cel2);
                table.addCell(cel3);
                table.addCell(cel4);
                table.addCell(cel5);
                table.addCell(cel6);                     
            }
            doc.add(table);
            doc.addAuthor("Jonathan Gomes");
            doc.close();
            doc.setPageCount(1);
            Desktop.getDesktop().open(new File(arquivoPdf));
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar PDF", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
    
   public static void gerarRelatorio(String opcao) throws SQLException, ClassNotFoundException{
        Conexao conexao = new Conexao() ;        
        Connection con = conexao.getConnection();                
        try {
            JasperPrint print = null;
            if(opcao.equals("TODOS")){                    
                //print = JasperFillManager.fillReport("Y:/Documentos/NetBeansProjects/GerenciadorVision/src/relatorio/TodosPedidos.jasper",null,con);                    
                print = JasperFillManager.fillReport("TodosPedidos.jasper",null,con);                    
            }else if (opcao.equals("ATUAL")){
                //print = JasperFillManager.fillReport("Y:/Documentos/NetBeansProjects/GerenciadorVision/src/relatorio/DiaPedidos.jasper",null,con);
                print = JasperFillManager.fillReport("DiaPedidos.jasper",null,con);
            }else if (opcao.equals("ORDER")){
                //print = JasperFillManager.fillReport("Y:/Documentos/NetBeansProjects/GerenciadorVision/src/relatorio/Order.jasper",null,con);
                print = JasperFillManager.fillReport("Order.jasper",null,con);
            }                               
            JasperViewer.viewReport(print,false);
        }catch (JRException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            conexao.desconecta();
        }finally{
            conexao.desconecta();
        }
    }
   
   public static void reimprimirOrder(Integer codigo){        
       Conexao conexao = new Conexao() ;         
       try{                                    
            Connection con = conexao.getConnection();                 
            HashMap parametros = new HashMap();//Crio os parametros
            parametros.put("CODIGO", codigo);//aqui eu coloco dentro do parametro chamado USER o nome 'julio'
            //JasperPrint jp = JasperFillManager.fillReport("D:/Documentos/NetBeansProjects/GerenciadorVision/src/relatorio/OrderReimpressao.jasper", parametros, con);
            JasperPrint jp = JasperFillManager.fillReport("OrderReimpressao.jasper", parametros, con);            
            JasperViewer.viewReport(jp,true);
            //JasperViewer jrv = new JasperViewer(jp,false);//Crio o JasperViewer com o JasperPrint dentro.
            //jrv.setVisible(true);//Chamo o relatório
        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: \n" + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            conexao.desconecta();
        }
    }
   
}