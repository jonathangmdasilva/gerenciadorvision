package view.alterar;

import controller.estoque.FornecedorController;
import controller.estoque.ProdutoController;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.estoque.CategoriaModel;
import model.estoque.FornecedorModel;
import model.estoque.LucroProdutoModel;
import model.estoque.ProdutoModel;
import view.validacao.Validar;

/*
 * @author Jonathan Gomes da Silva
 */
public class AlterarProdutos extends javax.swing.JDialog {
    
    Validar validar = new Validar();
    //ProdutoModel produto = new ProdutoModel();
    CategoriaModel categoria = new CategoriaModel();
    FornecedorModel fornecedor = new FornecedorModel();
    LucroProdutoModel lucro = new LucroProdutoModel();
    ProdutoController pController = new ProdutoController();
    FornecedorController forneController = new FornecedorController();    
    ProdutoModel produto;
    
    public AlterarProdutos(java.awt.Frame parent, boolean modal, ProdutoModel produto) {
        super(parent, modal);
        initComponents();
        this.produto = produto;
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_cancela = new javax.swing.JButton();
        btn_limpa = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        panelProduto = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtMinimoEstoque = new javax.swing.JTextField();
        txtMaxEstoque = new javax.swing.JTextField();
        cmbFornecedor = new javax.swing.JComboBox<>();
        txtCusto = new javax.swing.JTextField();
        txtValorVenda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLucro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSku = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMargem = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmi_arquivo = new javax.swing.JMenu();
        jmi_arquivo_sair = new javax.swing.JMenuItem();
        jmiAjuda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_cancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btn_cancela.setText("Cancelar");
        btn_cancela.setPreferredSize(new java.awt.Dimension(120, 41));
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });
        btn_cancela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_cancelaKeyPressed(evt);
            }
        });

        btn_limpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Limpar.png"))); // NOI18N
        btn_limpa.setText("Limpar");
        btn_limpa.setPreferredSize(new java.awt.Dimension(117, 41));
        btn_limpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpaActionPerformed(evt);
            }
        });
        btn_limpa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_limpaKeyPressed(evt);
            }
        });

        btn_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alterar.png"))); // NOI18N
        btn_alterar.setText("Alterar");
        btn_alterar.setToolTipText("Alterar Cadastro");
        btn_alterar.setPreferredSize(new java.awt.Dimension(120, 41));
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });
        btn_alterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_alterarKeyPressed(evt);
            }
        });

        panelProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProduto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Produto(128).png"))); // NOI18N
        panelProduto.add(lblProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 130, 130));

        jLabel1.setText("Desc");
        panelProduto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });
        panelProduto.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 280, -1));

        jLabel2.setText("Custo.:");
        panelProduto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        jLabel3.setText("Valor.:Venda");
        panelProduto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, 20));

        jLabel4.setText("Categ.:");
        panelProduto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jLabel5.setText("Min. Est.");
        panelProduto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel6.setText("Max.Est.:");
        panelProduto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, 20));

        jLabel7.setText("Forne.:");
        panelProduto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        panelProduto.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 220, 30));
        panelProduto.add(txtMinimoEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, -1));
        panelProduto.add(txtMaxEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 100, -1));

        panelProduto.add(cmbFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 250, 30));

        txtCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoFocusLost(evt);
            }
        });
        panelProduto.add(txtCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 80, -1));

        txtValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorVendaFocusLost(evt);
            }
        });
        panelProduto.add(txtValorVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 80, -1));

        jLabel8.setText("Lucro.:");
        panelProduto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        txtLucro.setEditable(false);
        txtLucro.setForeground(new java.awt.Color(0, 0, 255));
        panelProduto.add(txtLucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 80, -1));

        jLabel9.setText("SKU");
        panelProduto.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        txtSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSkuKeyReleased(evt);
            }
        });
        panelProduto.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 280, -1));

        jLabel10.setText("Margem");
        panelProduto.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, 20));

        txtMargem.setEditable(false);
        panelProduto.add(txtMargem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 80, -1));

        jmi_arquivo.setText("Arquivo");

        jmi_arquivo_sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jmi_arquivo_sair.setText("Sair");
        jmi_arquivo_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_arquivo_sairActionPerformed(evt);
            }
        });
        jmi_arquivo.add(jmi_arquivo_sair);

        jMenuBar1.add(jmi_arquivo);

        jmiAjuda.setText("Ajuda");

        jMenuItem1.setText("Ajuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiAjuda.add(jMenuItem1);

        jMenuBar1.add(jmiAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_limpa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void btn_cancelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_cancelaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            dispose();
        }
    }//GEN-LAST:event_btn_cancelaKeyPressed

    private void btn_limpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpaActionPerformed
        validar.limpar(panelProduto);
    }//GEN-LAST:event_btn_limpaActionPerformed

    private void btn_limpaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_limpaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            validar.limpar(panelProduto);
        }
    }//GEN-LAST:event_btn_limpaKeyPressed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        alterar();
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void btn_alterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_alterarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            alterar();
        }
    }//GEN-LAST:event_btn_alterarKeyPressed

    private void jmi_arquivo_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_arquivo_sairActionPerformed
        dispose();
    }//GEN-LAST:event_jmi_arquivo_sairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         validar.exibirAjudaCadastro("Produtos");                 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoFocusLost
        txtCusto.setText(validar.converterMoeda(txtCusto.getText()));
    }//GEN-LAST:event_txtCustoFocusLost

    private void txtValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorVendaFocusLost
        txtValorVenda.setText(validar.converterMoeda(txtValorVenda.getText()));                        
        if(validar.converteValorDigitadoemFloat(txtValorVenda.getText())<(validar.converteValorDigitadoemFloat(txtCusto.getText()))){
            JOptionPane.showMessageDialog(null, "O valor de venda é menor que o de compra!","Preço",JOptionPane.ERROR_MESSAGE);            
            txtValorVenda.requestFocus();
        }else{
            float lucroC = (validar.converteValorDigitadoemFloat(txtValorVenda.getText())-(validar.converteValorDigitadoemFloat(txtCusto.getText())));                    
            txtLucro.setText(validar.converterMoeda(lucroC));        
            txtMargem.setText(validar.converterPercentual(calculoMargem(validar.converteValorDigitadoemDouble(txtCusto.getText()), validar.converteValorDigitadoemDouble(txtValorVenda.getText()))));
        }        
    }//GEN-LAST:event_txtValorVendaFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {        
            carregarCombos();
            carregarInfs(produto);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyReleased
        txtSku.setText(txtSku.getText().toUpperCase());
    }//GEN-LAST:event_txtSkuKeyReleased

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        txtDescricao.setText(txtDescricao.getText().toUpperCase());
    }//GEN-LAST:event_txtDescricaoKeyReleased

    private void alterar(){        
        try {
            produto.setDescricao(txtDescricao.getText());
            produto.setSku(txtSku.getText());
            categoria.setIdCategoria(cmbCategoria.getSelectedIndex()+1);
            produto.setCategoria(categoria);
            produto.setMinimo(Integer.parseInt(txtMinimoEstoque.getText()));
            produto.setMaximo(Integer.parseInt(txtMaxEstoque.getText()));            
            fornecedor.setIdFornecedor(cmbFornecedor.getSelectedIndex()+1);
            produto.setFornecedor(fornecedor);
            lucro.setValorCompra(validar.converteValorDigitadoemDouble(txtCusto.getText()));
            lucro.setValorVenda(validar.converteValorDigitadoemDouble(txtValorVenda.getText()));
            lucro.setLucro(validar.converteValorDigitadoemDouble(txtLucro.getText()));
            lucro.setMargem(validar.converteValorDigitadoemDouble(txtMargem.getText()));
            produto.setLucro(lucro);                        
            pController.alterarProduto(produto);
            validar.exibirConfirmacaoAlterarCadastro("Produto");
            this.dispose();
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            validar.exibirErroAlterarCadastro("Produto");        }       
    }
    
    private void carregarCombos(){
        List<CategoriaModel> listaCategorias = new ArrayList<>(); 
        List<FornecedorModel> listaFornecedores = new ArrayList<>();   
        try {
            listaCategorias = pController.listarTodosCategorias();
            listaFornecedores = forneController.listarComboFornecedor();
            for (int i = 0; i < listaCategorias.size(); i++) {
                cmbCategoria.addItem(listaCategorias.get(i).getDescricao());             
            }
            for (int i = 0; i < listaFornecedores.size(); i++) {
                cmbFornecedor.addItem(listaFornecedores.get(i).getRazaoSocial());             
            }            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlterarProdutos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERRO AO CARREGADOR COMBOS!","ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
    private double calculoMargem(Double custo,Double venda){                              
        Double margem = (((venda*100)/custo)-100);
        return margem;
    }   
    
    private void carregarInfs(ProdutoModel prod) throws SQLException, ClassNotFoundException{
       txtDescricao.setText(prod.getDescricao());
       txtSku.setText(prod.getSku());       
       txtMinimoEstoque.setText(prod.getMinimo().toString());
       txtMaxEstoque.setText(prod.getMaximo().toString());
       txtCusto.setText(validar.converterMoeda(prod.getLucro().getValorCompra()));
       txtValorVenda.setText(validar.converterMoeda(prod.getLucro().getValorVenda()));
       txtLucro.setText(validar.converterMoeda(prod.getLucro().getLucro()));
       txtMargem.setText(validar.converterPercentual(prod.getLucro().getMargem()));
       cmbCategoria.setSelectedIndex(pController.listarCodigoCategoria(prod.getCategoria().getDescricao())-1);
       cmbFornecedor.setSelectedIndex(forneController.listarCodigoFornecedor(prod.getFornecedor().getRazaoSocial())-1);       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_cancela;
    private javax.swing.JButton btn_limpa;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmiAjuda;
    private javax.swing.JMenu jmi_arquivo;
    private javax.swing.JMenuItem jmi_arquivo_sair;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JPanel panelProduto;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLucro;
    private javax.swing.JTextField txtMargem;
    private javax.swing.JTextField txtMaxEstoque;
    private javax.swing.JTextField txtMinimoEstoque;
    private javax.swing.JTextField txtSku;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}