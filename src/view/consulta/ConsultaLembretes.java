package view.consulta;

import controller.administrativo.LembreteController;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.administrativo.LembreteModel;
import model.administrativo.UsuarioModel;
import tablemodels.LembreteTableModel;
import view.administrativo.CadastroLembretes;
import view.alterar.AlterarLembretes;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ConsultaLembretes extends javax.swing.JFrame {
    
    Validar validar = new Validar();
    LembreteController lc = new LembreteController();                
    LembreteModel lembreteModel;    
    LembreteTableModel lembreteTableModel= new LembreteTableModel();             
    UsuarioModel usuario;
    
    public ConsultaLembretes(UsuarioModel usu) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.usuario = usu;
        acesso(usu);
        setLocationRelativeTo(null);
        configurarTabela();
        tabela_lembretes.setModel(lembreteTableModel);
        setVisible(true);
    }
    
    List<LembreteModel> listaLembretes = new ArrayList<>();
    
    public LembreteTableModel getModelo() {
	if(lembreteTableModel == null){
            lembreteTableModel = new LembreteTableModel(listaLembretes);
	}
	return lembreteTableModel;		
    }
    
    public JTable getTabela(){
	if(tabela_lembretes == null){
            tabela_lembretes = new JTable();
            tabela_lembretes.setModel(getModelo());
	}
            return tabela_lembretes;
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDadosCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_lembretes = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbParametro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Lembretes");
        setExtendedState(100);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tabela_lembretes.setModel(getModelo());
        tabela_lembretes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tabela_lembretes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_lembretes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_lembretesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_lembretes);

        javax.swing.GroupLayout panelDadosClienteLayout = new javax.swing.GroupLayout(panelDadosCliente);
        panelDadosCliente.setLayout(panelDadosClienteLayout);
        panelDadosClienteLayout.setHorizontalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelDadosClienteLayout.setVerticalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar Cadastro");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Limpar Campos");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        btnExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExcluirKeyPressed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo Lembrete");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNovoKeyPressed(evt);
            }
        });

        jLabel1.setText("Parametro");

        cmbParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Data", "Todos" }));
        cmbParametro.setSelectedIndex(2);
        cmbParametro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbParametroItemStateChanged(evt);
            }
        });
        cmbParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParametroActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição");

        txtChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChaveKeyPressed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Confirmar.png"))); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        btnConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmarKeyPressed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Ajuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtChave))
                    .addComponent(cmbParametro)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir))
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        validar.exibirAjudaConsulta("Lembrete");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            confirmar();
        }        
    }//GEN-LAST:event_txtChaveKeyPressed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        confirmar();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            confirmar();
        }
    }//GEN-LAST:event_btnConfirmarKeyPressed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            novo();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            excluir();
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void cmbParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParametroItemStateChanged
        txtChave.setText(null);        
    }//GEN-LAST:event_cmbParametroItemStateChanged

    private void cmbParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParametroActionPerformed
        if(cmbParametro.getSelectedIndex()==1){ // TRABALHANDO COM DATA DE VENCIMENTO
            //btnConfirmar.setEnabled(false);            
            //txtChave.setEnabled(false);                        
            Date inicial,fim;
            REPETIR_DATA:
            while (true) {              
                try {                
                    inicial = (Date) Validar.formatarTeste(validar.FormatarData(JOptionPane.showInputDialog("Informe data inicial")));
                    fim =   (Date) Validar.formatarTeste(validar.FormatarData(JOptionPane.showInputDialog("Informe data final")));                    
                    listaDatas(inicial, fim);
                    break;                    
                } catch (ParseException | SQLException | ClassNotFoundException |NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao inserir datas! Utilize o padrão dd/mm/aaaa!","Erro",JOptionPane.ERROR_MESSAGE);                    
                }                
            }                 
        }
    }//GEN-LAST:event_cmbParametroActionPerformed

    private void tabela_lembretesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_lembretesMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            if (evt.getClickCount() == 2) {
                if (usuario.getNivel().equals("ADMINISTRADOR")) {
                    lembreteModel = lembreteTableModel.getLembrete(tabela_lembretes.getSelectedRow());                   
                    AlterarLembretes alterarLembrete = new AlterarLembretes(this, rootPaneCheckingEnabled,lembreteModel);                    
                }else if(evt.getClickCount() == 2){
                    JOptionPane.showMessageDialog(null, "Você não possui acesso para alterar cadastros!","Hierarquia",JOptionPane.WARNING_MESSAGE);
                }
            }            
        }        
    }//GEN-LAST:event_tabela_lembretesMouseClicked

    public void configurarTabela(){
        tabela_lembretes.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabela_lembretes.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela_lembretes.getColumnModel().getColumn(2).setPreferredWidth(400);        
        tabela_lembretes.getColumnModel().getColumn(3).setPreferredWidth(10);                        
    }    
 
    public void lista(int num, String param) throws SQLException, ClassNotFoundException{
        switch (num) {
            case 0:
                lembreteTableModel.limpar();
                listaLembretes = lc.listarTodosLembretesCodigo(Integer.parseInt(param));
                lembreteTableModel.addListaLembrete(listaLembretes);
                break;
            //case 1:
                //lembreteTableModel.limpar();
                //listaLembretes = lc.listarTodosLembretesData(param);
                //lembreteTableModel.addListaLembrete(listaLembretes);
                //break;
            case 2:
                lembreteTableModel.limpar();
                listaLembretes = lc.listarTodosLembretes();
                lembreteTableModel.addListaLembrete(listaLembretes);
                break;
            default:
                throw new NullPointerException("Erro!!!!");
        }
    }  

    public void excluir(){
        try {            
            int codigo  = listaLembretes.get(tabela_lembretes.getSelectedRow()).getIdLembrete();
            lembreteTableModel.remover(tabela_lembretes.getSelectedRow(),codigo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo(){
        this.dispose();
        CadastroLembretes cad= new CadastroLembretes(this, rootPaneCheckingEnabled,usuario);            
    }
    
    private void confirmar(){
        if (cmbParametro.getSelectedIndex()!=1){
            try {
                int num = cmbParametro.getSelectedIndex();
                String parametro = txtChave.getText();              
                lista(num, parametro);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }    
    
    private void listaDatas(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        lembreteTableModel.limpar();                
        listaLembretes = lc.listarTodosLembretesData(inicio,fim);
        lembreteTableModel.addListaLembrete(listaLembretes);
    }   
 
    private void acesso(UsuarioModel u){
        if(u.getNivel().equals("PADRÃO")){
            btnExcluir.setVisible(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> cmbParametro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDadosCliente;
    private javax.swing.JTable tabela_lembretes;
    private javax.swing.JTextField txtChave;
    // End of variables declaration//GEN-END:variables
}