package view.consulta;

import controller.vendas.PedidoController;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.administrativo.UsuarioModel;
import model.vendas.PedidoModel;
import relatorio.Relatorios;
import tablemodels.PedidoTableModel;
import view.validacao.Validar;
import view.vendas.Pedidos;

/*
 * @author Jonathan
 */

public final class ConsultaPedidos extends javax.swing.JFrame {

    PedidoController pc = new PedidoController();
    PedidoModel pedidoModel;
    Validar v = new Validar();
    PedidoTableModel pedidoTableModel = new PedidoTableModel();
    UsuarioModel usu;

    public ConsultaPedidos(UsuarioModel us) {
        initComponents();
        this.usu = us;
        acesso(us);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        tabela_pedido.setModel(pedidoTableModel);        
        configurarTabela();
        setVisible(true);
    }

    List<PedidoModel> listaPedidos = new ArrayList<>();

    public PedidoTableModel getModelo() {
        if (pedidoTableModel == null) {
            pedidoTableModel = new PedidoTableModel(listaPedidos);
        }
        return pedidoTableModel;
    }

    public JTable getTabela() {
        if (tabela_pedido == null) {
            tabela_pedido = new JTable();
            tabela_pedido.setModel(getModelo());
        }
        return tabela_pedido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblParametro = new javax.swing.JLabel();
        cmbParametro = new javax.swing.JComboBox<>();
        lblDesc = new javax.swing.JLabel();
        txtChave = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        panelDadosFornecedor = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_pedido = new javax.swing.JTable();
        lblInicial = new javax.swing.JLabel();
        txtInicial = new javax.swing.JFormattedTextField();
        lblFinal = new javax.swing.JLabel();
        txtFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        lbltotalPedidos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPagos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCancelados = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblGanhos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkBoxDia = new javax.swing.JCheckBox();
        btnReimprimir = new javax.swing.JButton();
        jmiMenuPedidos = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Pedidos");
        setExtendedState(100);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Sair");
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
        btnExcluir.setText("Cancelar");
        btnExcluir.setToolTipText("Cancelar Pedido");
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
        btnNovo.setToolTipText("Alterar Clientes");
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

        cmbParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Todos", "Período" }));
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

        lblDesc.setText("Descrição");

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

        tabela_pedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela_pedido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabela_pedido.setModel(getModelo());
        tabela_pedido.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_pedido.setGridColor(new java.awt.Color(0, 51, 255));
        tabela_pedido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_pedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_pedido);

        panelDadosFornecedor.setViewportView(jScrollPane1);

        lblInicial.setText("Inicial");

        try {
            txtInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtInicial.setEnabled(false);

        lblFinal.setText("Final");

        try {
            txtFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFinal.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Pedidos");

        lbltotalPedidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltotalPedidos.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Pagos:");

        lblPagos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPagos.setForeground(new java.awt.Color(0, 102, 255));
        lblPagos.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Cancelados");

        lblCancelados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCancelados.setForeground(new java.awt.Color(255, 0, 0));
        lblCancelados.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setText("Receita Acumulada");
        jLabel10.setToolTipText("Calculo referente a pedidos pagos");

        lblGanhos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGanhos.setForeground(new java.awt.Color(0, 204, 204));
        lblGanhos.setText("0");
        lblGanhos.setToolTipText("Calculo referente a pedidos pagos");

        jLabel4.setText("Dia");

        chkBoxDia.setText("Atual");
        chkBoxDia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkBoxDiaStateChanged(evt);
            }
        });

        btnReimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnReimprimir.setText("Pdf");
        btnReimprimir.setToolTipText("Reimprimir Pedido");
        btnReimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReimprimirActionPerformed(evt);
            }
        });
        btnReimprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnReimprimirKeyPressed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem3.setText("Atualizar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        jMenuItem4.setText("Reimprimir Comprovante");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmiMenuPedidos.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Ajuda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jmiMenuPedidos.add(jMenu2);

        setJMenuBar(jmiMenuPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDadosFornecedor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblParametro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkBoxDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGanhos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalPedidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPagos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCancelados)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbParametro)
                        .addComponent(lblInicial)
                        .addComponent(txtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFinal)
                        .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblParametro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(panelDadosFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblCancelados)
                        .addComponent(jLabel8)
                        .addComponent(lblPagos)
                        .addComponent(jLabel7)
                        .addComponent(lbltotalPedidos)
                        .addComponent(jLabel10)
                        .addComponent(lblGanhos)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        cancelar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        v.exibirAjudaConsulta("Cliente");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            int num = cmbParametro.getSelectedIndex();
            String parametro = txtChave.getText();
            lista(num, parametro);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao clicar em pesquisa! " +ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void tabela_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_pedidoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (evt.getClickCount() == 2) {
                pedidoModel = pedidoTableModel.getPedido(tabela_pedido.getSelectedRow());
                int codigo = pedidoTableModel.getPedido(tabela_pedido.getSelectedRow()).getCodigoPedido();
                try {
                    ConsultaItensPedido consultaItens = new ConsultaItensPedido(this, rootPaneCheckingEnabled, codigo);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tabela_pedidoMouseClicked

    private void btnConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmarKeyPressed
        confirmar();
    }//GEN-LAST:event_btnConfirmarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cancelar();
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            novo();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregarTela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void cmbParametroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbParametroItemStateChanged
        txtChave.setText("");
    }//GEN-LAST:event_cmbParametroItemStateChanged

    private void txtChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            confirmar();
        }
    }//GEN-LAST:event_txtChaveKeyPressed

    private void cmbParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParametroActionPerformed
        if(cmbParametro.getSelectedIndex()==3){
            txtInicial.setEnabled(true);
            txtFinal.setEnabled(true);
            txtChave.setEnabled(false);
        }else{
            txtInicial.setEnabled(false);
            txtFinal.setEnabled(false);
            txtChave.setEnabled(true);
        }                      
    }//GEN-LAST:event_cmbParametroActionPerformed

    private void chkBoxDiaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkBoxDiaStateChanged
        pesquisaDia();
    }//GEN-LAST:event_chkBoxDiaStateChanged

    private void txtChaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChaveKeyReleased
        txtChave.setText(txtChave.getText().toUpperCase());
        confirmar();
    }//GEN-LAST:event_txtChaveKeyReleased

    private void btnReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReimprimirActionPerformed
        try {
            Integer pedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do pedido: "));      
            Relatorios.reimprimirOrder(pedido);
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar Reimpressão:\n" + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btnReimprimirActionPerformed

    private void btnReimprimirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnReimprimirKeyPressed
        try {
            Integer pedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do pedido: "));      
            Relatorios.reimprimirOrder(pedido);
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar Reimpressão:\n" + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_btnReimprimirKeyPressed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Relatorios.reimprimirOrder(WIDTH);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public void configurarTabela() {
        tabela_pedido.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_pedido.getColumnModel().getColumn(1).setPreferredWidth(275);
        tabela_pedido.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela_pedido.getColumnModel().getColumn(3).setPreferredWidth(125);
        tabela_pedido.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela_pedido.getColumnModel().getColumn(5).setPreferredWidth(160);
        tabela_pedido.getColumnModel().getColumn(6).setPreferredWidth(150);
        tabela_pedido.getColumnModel().getColumn(7).setPreferredWidth(180);
        tabela_pedido.getColumnModel().getColumn(8).setPreferredWidth(160);
        tabela_pedido.getColumnModel().getColumn(9).setPreferredWidth(95);
        tabela_pedido.getColumnModel().getColumn(10).setPreferredWidth(95);
        tabela_pedido.getColumnModel().getColumn(11).setPreferredWidth(100);
        tabela_pedido.getColumnModel().getColumn(12).setPreferredWidth(65);
    }

    public void lista(int num, String param) throws SQLException, ClassNotFoundException {
        switch (num) {
            case 0:
                pedidoTableModel.limpar();
                listaPedidos = pc.listarPedidosCodigo(Integer.parseInt(param));
                pedidoTableModel.addListaPedido(listaPedidos);
                break;
            case 1:
                pedidoTableModel.limpar();
                listaPedidos = pc.listarPedidosCliente(param);
                pedidoTableModel.addListaPedido(listaPedidos);
                break;
            case 2:
                pedidoTableModel.limpar();
                listaPedidos = pc.listarTodosPedidos();
                pedidoTableModel.addListaPedido(listaPedidos);
                break;
            default:
                throw new NullPointerException("Erro!!!!");
        }
        cmbParametro.requestFocus();
        configQtds();
    }

    private void cancelar() {
        try {
            int codigo = listaPedidos.get(tabela_pedido.getSelectedRow()).getCodigoPedido();
            pedidoTableModel.remover(tabela_pedido.getSelectedRow(), codigo);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cancelar o pedido:\n"+ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void novo() {
        this.dispose();
        Pedidos pedido = new Pedidos(this, rootPaneCheckingEnabled, usu);
    }

    public void confirmar() {        
        if (cmbParametro.getSelectedIndex()==3) {
            pesquisaPorData();
        }else{
            try {
                int num = cmbParametro.getSelectedIndex();
                String parametro = txtChave.getText();
                lista(num, parametro);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    private void acesso(UsuarioModel u) {
        if (u.getNivel().equals("PADRÃO")) {
            btnExcluir.setVisible(false);
        }
    }

    private void listaDatas(Date inicio, Date fim) throws SQLException, ClassNotFoundException{
        pedidoTableModel.limpar();
        listaPedidos = pc.listarPedidosPeriodo(inicio, fim);
        pedidoTableModel.addListaPedido(listaPedidos);
    }    
    
    private void pesquisaPorData(){
        if(cmbParametro.getSelectedIndex()==3){            
            txtChave.setEnabled(false);            
            Date inicial,fim;
            REPETIR_DATA:
            while (true) {
                try {                    
                    inicial = (Date) Validar.formatarTeste(v.FormatarData(txtInicial.getText()));                                        
                    fim =   (Date) Validar.formatarTeste(v.FormatarData(txtFinal.getText()));                    
                    try {
                        listaDatas(inicial, fim);
                    } catch (SQLException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao tentar listar pela data: " +ex.getMessage());
                    }                                        
                   break;
                }  catch (ParseException |NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao inserir datas! Utilize o padrão dd/mm/aaaa!","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }                   
        }
        txtInicial.setEnabled(false);
        txtFinal.setEnabled(false
        );
        configQtds();
    }

    //DATA ATUAL
    private void pesquisaPorDataAtual(){
            Date inicial,fim;
            LocalDate data = LocalDate.now();            
                try {                    
                    inicial = (Date) Validar.formatarTeste(v.FormatarData(data.getDayOfMonth()+"/"+data.getMonthValue()+"/"+data.getYear()));                                                                   
                    fim = (Date) Validar.formatarTeste(v.FormatarData(data.getDayOfMonth()+1+"/"+data.getMonthValue()+"/"+data.getYear()));                    
                    try {
                        listaDatas(inicial, fim);
                    } catch (SQLException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao tentar listar pela data atual: " + ex.getMessage());
                    }                                                         
                }  catch (ParseException |NullPointerException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao inserir datas! Utilize o padrão dd/mm/aaaa! " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
                }                                               
        configQtds();
    }
    
    private void configQtds(){
        int cancelados =0,pagos=0;
        Double total = 0.0;
        lbltotalPedidos.setText(""+listaPedidos.size());
        for(PedidoModel pedido: listaPedidos){
            if(pedido.getStatus().equals("PAGO")){
                total = total + pedido.getTotal();
                pagos++;
            }else{
                cancelados++;
            }
            //total = total + pedido.getTotal();
        }
        lblPagos.setText("" + pagos);
        lblCancelados.setText("" + cancelados);
        lblGanhos.setText(v.converterMoeda(total));
    }
    
    private void carregarTela(){
        if(!chkBoxDia.isSelected()){
            try {
                int num = cmbParametro.getSelectedIndex();
                String parametro = txtChave.getText();
                lista(num, parametro);
            } catch (SQLException | ClassNotFoundException ex) {            
                JOptionPane.showMessageDialog(null, "Erro ao carregar a tela de dados do pedido: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            pesquisaDia();
        }        
    }

    private void pesquisaDia(){
        if(chkBoxDia.isSelected()){
            //VISIBILIDADE
            cmbParametro.setVisible(false);
            txtInicial.setVisible(false);
            txtFinal.setVisible(false);
            lblParametro.setVisible(false);
            lblInicial.setVisible(false);
            lblFinal.setVisible(false);
            lblDesc.setVisible(false);
            btnConfirmar.setVisible(false);
            txtChave.setVisible(false);
            pesquisaPorDataAtual();
        }else{
            carregarTela();
            //VISIBILIDADE
            cmbParametro.setVisible(true);
            txtInicial.setVisible(true);
            txtFinal.setVisible(true);
            lblParametro.setVisible(true);
            lblInicial.setVisible(true);
            lblFinal.setVisible(true);
            lblDesc.setVisible(true);
            btnConfirmar.setVisible(true);
            txtChave.setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnReimprimir;
    private javax.swing.JCheckBox chkBoxDia;
    private javax.swing.JComboBox<String> cmbParametro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar jmiMenuPedidos;
    private javax.swing.JLabel lblCancelados;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblGanhos;
    private javax.swing.JLabel lblInicial;
    private javax.swing.JLabel lblPagos;
    private javax.swing.JLabel lblParametro;
    private javax.swing.JLabel lbltotalPedidos;
    private javax.swing.JScrollPane panelDadosFornecedor;
    private javax.swing.JTable tabela_pedido;
    private javax.swing.JTextField txtChave;
    private javax.swing.JFormattedTextField txtFinal;
    private javax.swing.JFormattedTextField txtInicial;
    // End of variables declaration//GEN-END:variables
}