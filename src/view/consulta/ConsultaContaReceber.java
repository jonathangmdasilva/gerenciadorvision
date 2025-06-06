package view.consulta;

import controller.contas.ContasReceberController;
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
import model.administrativo.UsuarioModel;
import model.contas.ContasReceberModel;
import tablemodels.ContasReceberTableModel;
import view.alterar.AlterarContasReceber;
import view.contas.CadastroContasReceber;
import view.validacao.Validar;

/*
 * @author Jonathan
 */
public class ConsultaContaReceber extends javax.swing.JFrame {

    Validar validar = new Validar();
    ContasReceberTableModel receberTableModel= new ContasReceberTableModel();             
    ContasReceberModel receberModel = new ContasReceberModel();
    ContasReceberController cr = new ContasReceberController();
    UsuarioModel usuario;
    
    public ConsultaContaReceber(UsuarioModel usu) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.usuario = usu;
        acesso(usu);
        setLocationRelativeTo(null);
        configurarTabela();
        tabelaReceber.setModel(receberTableModel);
        setVisible(true);
    }
    
    List<ContasReceberModel> listaContas = new ArrayList<>();

    
    public ContasReceberTableModel getModelo() {
	if(receberTableModel == null){
            receberTableModel = new ContasReceberTableModel(listaContas);
	}
	return receberTableModel;		
    }
    
    public JTable getTabela(){
	if(tabelaReceber == null){
            tabelaReceber = new JTable();
            tabelaReceber.setModel(getModelo());
	}
            return tabelaReceber;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDadosCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaReceber = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblParametro = new javax.swing.JLabel();
        cmbParametro = new javax.swing.JComboBox<>();
        lblDescricao = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmiMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Contas Receber");
        setExtendedState(100);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabelaReceber.setModel(getModelo());
        tabelaReceber.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaReceber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaReceberFocusGained(evt);
            }
        });
        tabelaReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaReceberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaReceber);

        javax.swing.GroupLayout panelDadosClienteLayout = new javax.swing.GroupLayout(panelDadosCliente);
        panelDadosCliente.setLayout(panelDadosClienteLayout);
        panelDadosClienteLayout.setHorizontalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosClienteLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(1, 1, 1))
        );
        panelDadosClienteLayout.setVerticalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
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
        btnNovo.setToolTipText("Nova Conta à Pagar");
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

        lblParametro.setText("Parametro");

        cmbParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedente", "Código", "Status", "Todos", "Vencimento" }));
        cmbParametro.setSelectedIndex(3);
        cmbParametro.setAutoscrolls(true);
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

        lblDescricao.setText("Descrição");

        txtChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChaveKeyReleased(evt);
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

        jLabel5.setText("Aperte F5 para atualizar a lista");

        jLabel4.setText("(Clique duas vezes com o botão esquerdo do mouse no campo para visualizar em nova janela.)");

        jMenu1.setText("Arquivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem3.setText("Atualizar");
        jMenuItem3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenuItem3FocusGained(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmiMenu.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Ajuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jmiMenu.add(jMenu2);

        setJMenuBar(jmiMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDadosCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblParametro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtChave, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbParametro)
                        .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblParametro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir))
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        validar.exibirAjudaConsulta("Contas a Receber");        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed
    
    private void cmbParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParametroItemStateChanged
        txtChave.setText(null);        
    }//GEN-LAST:event_cmbParametroItemStateChanged

    private void txtChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyReleased
        txtChave.setText(txtChave.getText().toUpperCase());
    }//GEN-LAST:event_txtChaveKeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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

    private void txtChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                 
            confirmar();
        }        
    }//GEN-LAST:event_txtChaveKeyPressed

    private void tabelaReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaReceberMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON1){
            if (evt.getClickCount() == 2) {
                if (usuario.getNivel().equals("ADMINISTRADOR")) {
                    receberModel = receberTableModel.getContasPagar(tabelaReceber.getSelectedRow());                   
                    AlterarContasReceber acr = new AlterarContasReceber(this, rootPaneCheckingEnabled,receberModel);
                }else if(evt.getClickCount() == 2){
                    JOptionPane.showMessageDialog(null, "Você não possui acesso para alterar cadastros!","Hierarquia",JOptionPane.WARNING_MESSAGE);
                }
            }        
        }                            
    }//GEN-LAST:event_tabelaReceberMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParametroActionPerformed
        int num = 2;
        String parametro= "";
        if(cmbParametro.getSelectedIndex()==2){
            btnConfirmar.setEnabled(false);            
            txtChave.setEnabled(false);            
            Integer op;
            REPETIR_STATUS:
            while (true) {
                op = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção: \n\n 1-ABERTO \n 2-FECHADO"));
                switch (op) {
                    case 1:
                        parametro = "ABERTO";
                        break REPETIR_STATUS;
                    case 2:
                        parametro = "PAGO";
                        break REPETIR_STATUS;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!","Opção",JOptionPane.ERROR_MESSAGE);
                }
            }
        try {
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaContaReceber.class.getName()).log(Level.SEVERE, null, ex);
        }                                            
        }else if(cmbParametro.getSelectedIndex()==4){ // TRABALHANDO COM DATA DE VENCIMENTO
            btnConfirmar.setEnabled(false);            
            txtChave.setEnabled(false);                        
            Date inicial,fim;
            REPETIR_DATA:
            while (true) {              
                try {                
                    inicial = (Date) Validar.formatarTeste(validar.FormatarData(JOptionPane.showInputDialog("Informe data inicial")));
                    fim =   (Date) Validar.formatarTeste(validar.FormatarData(JOptionPane.showInputDialog("Informe data final")));                    
                    listaDatas(inicial, fim);
                    break;                    
                }  catch (ParseException | SQLException | ClassNotFoundException |NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao inserir datas! Utilize o padrão dd/mm/aaaa!","Erro",JOptionPane.ERROR_MESSAGE);                    
                }                
            }                 
        }else{
            btnConfirmar.setEnabled(true);
            txtChave.setEnabled(true);
        }                
    }//GEN-LAST:event_cmbParametroActionPerformed

    private void jMenuItem3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenuItem3FocusGained
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jMenuItem3FocusGained

    private void tabelaReceberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaReceberFocusGained
        confirmar();
    }//GEN-LAST:event_tabelaReceberFocusGained

    public void configurarTabela(){
        tabelaReceber.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabelaReceber.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabelaReceber.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelaReceber.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelaReceber.getColumnModel().getColumn(2).setPreferredWidth(75);
    }    

    private void confirmar(){
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();              
            if(num==2){
                int x =  Integer.parseInt(JOptionPane.showInputDialog("Informe Código de Status\n 1- Aberto\n 2- Pago"));                
                if(x==1){
                    parametro = "ABERTO";
                }else{
                    parametro = "PAGO";
                }
            }
            
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lista(int num, String param) throws SQLException, ClassNotFoundException{
        switch (num) {
            case 0:
                receberTableModel.limpar();
                listaContas = cr.listarTodosSacado(param);                
                receberTableModel.addListaContasReceber(listaContas);
                break;
            case 1:
                receberTableModel.limpar();
                listaContas = cr.listarCodigo(Integer.parseInt(param));
                receberTableModel.addListaContasReceber(listaContas);
                break;
            case 2:
                receberTableModel.limpar();
                listaContas = cr.listarPorStatus(param);
                receberTableModel.addListaContasReceber(listaContas);
                break;                
            case 3:
                receberTableModel.limpar();
                listaContas = cr.listarTodosContasReceber();
                receberTableModel.addListaContasReceber(listaContas);
                break;
            case 4:
                receberTableModel.limpar();
                listaContas = cr.listarTodosContasReceber();
                receberTableModel.addListaContasReceber(listaContas);
                break;                
            default:
                throw new NullPointerException("Erro!!!!");
        }
    }
    
    public void listaDatas(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        receberTableModel.limpar();                
        listaContas = cr.listarTodasPeriodoVenc(inicio,fim);
        //java.sql.Date.valueOf(inicio)
        receberTableModel.addListaContasReceber(listaContas);
    }
    
    public void excluir(){
        try {            
            int codigo  = listaContas.get(tabelaReceber.getSelectedRow()).getIdConta();
            receberTableModel.remover(tabelaReceber.getSelectedRow(),codigo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConsultaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo(){
        this.dispose();
        CadastroContasReceber cad= new CadastroContasReceber(this, rootPaneCheckingEnabled,usuario);            
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar jmiMenu;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblParametro;
    private javax.swing.JPanel panelDadosCliente;
    private javax.swing.JTable tabelaReceber;
    private javax.swing.JTextField txtChave;
    // End of variables declaration//GEN-END:variables
}
