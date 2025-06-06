package view.principal;

import backup.Backup;
import controller.administrativo.ConfiguracaoController;
import controller.administrativo.LembreteController;
import controller.contas.ContasPagarController;
import controller.contas.ContasReceberController;
import controller.estoque.EstoqueController;
import ia.ManipulacaoArquivos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.administrativo.ConfiguracaoModel;
import model.administrativo.LembreteModel;
import model.administrativo.UsuarioModel;
import relatorio.Relatorios;
import view.administrativo.CadastroCliente;
import view.administrativo.CadastroFuncionarios;
import view.administrativo.CadastroLembretes;
import view.configuracoes.Relogio;
import view.consulta.ConsultaCliente;
import view.consulta.ConsultaContaPagar;
import view.consulta.ConsultaContaReceber;
import view.consulta.ConsultaEmpresa;
import view.consulta.ConsultaFornecedor;
import view.consulta.ConsultaFuncionário;
import view.consulta.ConsultaLembretes;
import view.consulta.ConsultaPedidos;
import view.consulta.ConsultaProdutos;
import view.contas.CadastroContasPagar;
import view.contas.CadastroContasReceber;
import view.contas.SelecionarContas;
import view.diversos.Calendario;
import view.diversos.FormaPagamento;
import view.diversos.Sobre;
import view.diversos.panel_img;
import view.estoque.CadastroFornecedor;
import view.estoque.CadastroProdutos;
import view.estoque.MovimentaMercadorias;
import view.validacao.Validar;
import view.vendas.Pedidos;


public final class TelaPrincipal extends javax.swing.JFrame {
        
    Validar valid = new Validar();    
    UsuarioModel usuario;    
    
    public TelaPrincipal(UsuarioModel usuario) throws SQLException, ClassNotFoundException {        
        initComponents();
        configurarOpcao();
        this.usuario = usuario;
        iniciarFundo();          
        acessos(usuario);        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_relogio = new javax.swing.JPanel();
        lbl_relogio = new javax.swing.JLabel();
        calendario = new org.jdesktop.swingx.calendar.JXMonthView();
        lblUsuario = new javax.swing.JLabel();
        btnCliente = new javax.swing.JButton();
        btnFornecedor = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnContas = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnLembretes = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        panelAvisos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblContasPagar = new javax.swing.JLabel();
        lblContasReceber = new javax.swing.JLabel();
        jmiMenuPrincipal = new javax.swing.JMenuBar();
        jmiArquivo = new javax.swing.JMenu();
        jmiArquivoSair = new javax.swing.JMenuItem();
        jmiCadastro = new javax.swing.JMenu();
        jmiCadastroAdministrativo = new javax.swing.JMenu();
        jmiCadastroAdministrativoCliente = new javax.swing.JMenuItem();
        jmiCadastroAdministrativoFuncionario = new javax.swing.JMenuItem();
        jmiCadastroFinanceiro = new javax.swing.JMenu();
        jmiCadastroFinanceiroPagar = new javax.swing.JMenuItem();
        jmiCadastroFinanceiroReceber = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiCadastroEstoque = new javax.swing.JMenu();
        jmiCadastroEstoqueFornecedores = new javax.swing.JMenuItem();
        jmiCadastroEstoqueProdutos = new javax.swing.JMenuItem();
        jmiFinanceiro = new javax.swing.JMenu();
        jmiConsultaAdministrativo = new javax.swing.JMenu();
        jmiConsultaAdministrativoClientes = new javax.swing.JMenuItem();
        jmiConsultaAdministrativoFuncionario = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmiConsultaEstoque = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jmiEstoqueProdutos = new javax.swing.JMenuItem();
        jmiConsultaFinanceiro = new javax.swing.JMenu();
        jmiFinanceiroPagar = new javax.swing.JMenuItem();
        jmiFinanceiroReceber = new javax.swing.JMenuItem();
        jmiConsultaVendas = new javax.swing.JMenu();
        jmiConsultaVendasPedido = new javax.swing.JMenuItem();
        jmiMovimentacao = new javax.swing.JMenu();
        jmiMovimentacaoIventario = new javax.swing.JMenuItem();
        jmiMovimentacaoMovimentar = new javax.swing.JMenuItem();
        jmiMenuPrincipalManutencao = new javax.swing.JMenu();
        jmiMenuPrincipalManutencaoBackup = new javax.swing.JMenuItem();
        jmiRelatorios = new javax.swing.JMenu();
        jmiRelatoriosPedidos = new javax.swing.JMenu();
        jmiRelatoriosPedidosTodos = new javax.swing.JMenuItem();
        jmiRelatoriosPedidosHoje = new javax.swing.JMenuItem();
        jmiAjuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setMinimumSize(new java.awt.Dimension(745, 474));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_relogio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel_relogio.setOpaque(false);

        lbl_relogio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_relogio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Relogio.png"))); // NOI18N

        javax.swing.GroupLayout panel_relogioLayout = new javax.swing.GroupLayout(panel_relogio);
        panel_relogio.setLayout(panel_relogioLayout);
        panel_relogioLayout.setHorizontalGroup(
            panel_relogioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_relogioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_relogio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        panel_relogioLayout.setVerticalGroup(
            panel_relogioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_relogio, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        calendario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuário");

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente(x64).png"))); // NOI18N
        btnCliente.setToolTipText("Cadastro de Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fornecedor.png"))); // NOI18N
        btnFornecedor.setToolTipText("Cadastro de Fornecedores");
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Produto.png"))); // NOI18N
        btnProduto.setToolTipText("Cadastro de Mercadoria");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Contas.png"))); // NOI18N
        btnContas.setToolTipText("Cadastro de Contas");
        btnContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContasActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Calendario.png"))); // NOI18N
        btnCalendario.setToolTipText("Calendario");
        btnCalendario.setBorderPainted(false);
        btnCalendario.setContentAreaFilled(false);
        btnCalendario.setFocusPainted(false);
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });

        btnLembretes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lembretes.png"))); // NOI18N
        btnLembretes.setToolTipText("Lembretes");
        btnLembretes.setBorderPainted(false);
        btnLembretes.setContentAreaFilled(false);
        btnLembretes.setFocusPainted(false);
        btnLembretes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLembretesActionPerformed(evt);
            }
        });

        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pedidos.png"))); // NOI18N
        btnPedidos.setToolTipText("Pedidos");
        btnPedidos.setBorderPainted(false);
        btnPedidos.setContentAreaFilled(false);
        btnPedidos.setFocusPainted(false);
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        panelAvisos.setBackground(new java.awt.Color(255, 255, 255));
        panelAvisos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelAvisos.setToolTipText("Quadro de avisos financeiros");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quadro de Avisos");

        lblContasPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContasPagar.setForeground(new java.awt.Color(255, 0, 0));
        lblContasPagar.setText("PAGAR");

        lblContasReceber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContasReceber.setForeground(new java.awt.Color(51, 102, 255));
        lblContasReceber.setText("RECEBER");

        javax.swing.GroupLayout panelAvisosLayout = new javax.swing.GroupLayout(panelAvisos);
        panelAvisos.setLayout(panelAvisosLayout);
        panelAvisosLayout.setHorizontalGroup(
            panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelAvisosLayout.createSequentialGroup()
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAvisosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContasPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContasReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelAvisosLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel6)
                        .addGap(0, 106, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAvisosLayout.setVerticalGroup(
            panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvisosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContasPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContasReceber)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jmiArquivo.setText("Arquivo");

        jmiArquivoSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmiArquivoSair.setText("Sair");
        jmiArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiArquivoSairActionPerformed(evt);
            }
        });
        jmiArquivo.add(jmiArquivoSair);

        jmiMenuPrincipal.add(jmiArquivo);

        jmiCadastro.setText("Cadastro");

        jmiCadastroAdministrativo.setText("Administrativo");

        jmiCadastroAdministrativoCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jmiCadastroAdministrativoCliente.setText("Cliente");
        jmiCadastroAdministrativoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroAdministrativoClienteActionPerformed(evt);
            }
        });
        jmiCadastroAdministrativo.add(jmiCadastroAdministrativoCliente);

        jmiCadastroAdministrativoFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jmiCadastroAdministrativoFuncionario.setText("Funcionário");
        jmiCadastroAdministrativoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroAdministrativoFuncionarioActionPerformed(evt);
            }
        });
        jmiCadastroAdministrativo.add(jmiCadastroAdministrativoFuncionario);

        jmiCadastro.add(jmiCadastroAdministrativo);

        jmiCadastroFinanceiro.setText("Financeiro");

        jmiCadastroFinanceiroPagar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jmiCadastroFinanceiroPagar.setText("Contas à Pagar");
        jmiCadastroFinanceiroPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroFinanceiroPagarActionPerformed(evt);
            }
        });
        jmiCadastroFinanceiro.add(jmiCadastroFinanceiroPagar);

        jmiCadastroFinanceiroReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jmiCadastroFinanceiroReceber.setText("Contas à Receber");
        jmiCadastroFinanceiroReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroFinanceiroReceberActionPerformed(evt);
            }
        });
        jmiCadastroFinanceiro.add(jmiCadastroFinanceiroReceber);

        jMenuItem1.setText("Forma de Pagamento (Pedido)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiCadastroFinanceiro.add(jMenuItem1);

        jmiCadastro.add(jmiCadastroFinanceiro);

        jmiCadastroEstoque.setText("Estoque");

        jmiCadastroEstoqueFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmiCadastroEstoqueFornecedores.setText("Fornecedores");
        jmiCadastroEstoqueFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroEstoqueFornecedoresActionPerformed(evt);
            }
        });
        jmiCadastroEstoque.add(jmiCadastroEstoqueFornecedores);

        jmiCadastroEstoqueProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jmiCadastroEstoqueProdutos.setText("Produtos");
        jmiCadastroEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastroEstoqueProdutosActionPerformed(evt);
            }
        });
        jmiCadastroEstoque.add(jmiCadastroEstoqueProdutos);

        jmiCadastro.add(jmiCadastroEstoque);

        jmiMenuPrincipal.add(jmiCadastro);

        jmiFinanceiro.setText("Consulta");

        jmiConsultaAdministrativo.setText("Administrativo");

        jmiConsultaAdministrativoClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiConsultaAdministrativoClientes.setText("Clientes");
        jmiConsultaAdministrativoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaAdministrativoClientesActionPerformed(evt);
            }
        });
        jmiConsultaAdministrativo.add(jmiConsultaAdministrativoClientes);

        jmiConsultaAdministrativoFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmiConsultaAdministrativoFuncionario.setText("Funcionário");
        jmiConsultaAdministrativoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaAdministrativoFuncionarioActionPerformed(evt);
            }
        });
        jmiConsultaAdministrativo.add(jmiConsultaAdministrativoFuncionario);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Lembretes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmiConsultaAdministrativo.add(jMenuItem4);

        jmiFinanceiro.add(jmiConsultaAdministrativo);

        jMenuItem7.setText("Empresa");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmiFinanceiro.add(jMenuItem7);

        jmiConsultaEstoque.setText("Estoque");

        jMenuItem3.setText("Fornecedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmiConsultaEstoque.add(jMenuItem3);

        jmiEstoqueProdutos.setText("Produtos");
        jmiEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEstoqueProdutosActionPerformed(evt);
            }
        });
        jmiConsultaEstoque.add(jmiEstoqueProdutos);

        jmiFinanceiro.add(jmiConsultaEstoque);

        jmiConsultaFinanceiro.setText("Financeiro");

        jmiFinanceiroPagar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiFinanceiroPagar.setText("Contas Pagar");
        jmiFinanceiroPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFinanceiroPagarActionPerformed(evt);
            }
        });
        jmiConsultaFinanceiro.add(jmiFinanceiroPagar);

        jmiFinanceiroReceber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiFinanceiroReceber.setText("Contas Receber");
        jmiFinanceiroReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFinanceiroReceberActionPerformed(evt);
            }
        });
        jmiConsultaFinanceiro.add(jmiFinanceiroReceber);

        jmiFinanceiro.add(jmiConsultaFinanceiro);

        jmiConsultaVendas.setText("Vendas");

        jmiConsultaVendasPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jmiConsultaVendasPedido.setText("Pedido");
        jmiConsultaVendasPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultaVendasPedidoActionPerformed(evt);
            }
        });
        jmiConsultaVendas.add(jmiConsultaVendasPedido);

        jmiFinanceiro.add(jmiConsultaVendas);

        jmiMenuPrincipal.add(jmiFinanceiro);

        jmiMovimentacao.setText("Movimentação");

        jmiMovimentacaoIventario.setText("Inventário");
        jmiMovimentacaoIventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMovimentacaoIventarioActionPerformed(evt);
            }
        });
        jmiMovimentacao.add(jmiMovimentacaoIventario);

        jmiMovimentacaoMovimentar.setText("Movimentar");
        jmiMovimentacaoMovimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMovimentacaoMovimentarActionPerformed(evt);
            }
        });
        jmiMovimentacao.add(jmiMovimentacaoMovimentar);

        jmiMenuPrincipal.add(jmiMovimentacao);

        jmiMenuPrincipalManutencao.setText("Manutenção");

        jmiMenuPrincipalManutencaoBackup.setText("Backup");
        jmiMenuPrincipalManutencaoBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMenuPrincipalManutencaoBackupActionPerformed(evt);
            }
        });
        jmiMenuPrincipalManutencao.add(jmiMenuPrincipalManutencaoBackup);

        jmiMenuPrincipal.add(jmiMenuPrincipalManutencao);

        jmiRelatorios.setText("Relatórios");

        jmiRelatoriosPedidos.setText("Pedidos");

        jmiRelatoriosPedidosTodos.setText("Todos");
        jmiRelatoriosPedidosTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatoriosPedidosTodosActionPerformed(evt);
            }
        });
        jmiRelatoriosPedidos.add(jmiRelatoriosPedidosTodos);

        jmiRelatoriosPedidosHoje.setText("Hoje");
        jmiRelatoriosPedidosHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatoriosPedidosHojeActionPerformed(evt);
            }
        });
        jmiRelatoriosPedidos.add(jmiRelatoriosPedidosHoje);

        jmiRelatorios.add(jmiRelatoriosPedidos);

        jmiMenuPrincipal.add(jmiRelatorios);

        jmiAjuda.setText("Ajuda");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmiAjuda.add(jMenuItem2);

        jmiMenuPrincipal.add(jmiAjuda);

        setJMenuBar(jmiMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_relogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(178, 178, 178)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLembretes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnContas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(panelAvisos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_relogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnContas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPedidos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLembretes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCalendario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiArquivoSairActionPerformed
        valid.confirmarSaida();
    }//GEN-LAST:event_jmiArquivoSairActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        valid.confirmarSaida();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        Calendario c = new Calendario(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Sobre s = new Sobre(this, rootPaneCheckingEnabled);                
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        CadastroCliente cc = new CadastroCliente(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
        CadastroFornecedor cf  = new CadastroFornecedor(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContasActionPerformed
        SelecionarContas s = new SelecionarContas(null, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnContasActionPerformed

    private void jmiCadastroFinanceiroPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroFinanceiroPagarActionPerformed
        CadastroContasPagar ccp = new CadastroContasPagar(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_jmiCadastroFinanceiroPagarActionPerformed

    private void jmiCadastroFinanceiroReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroFinanceiroReceberActionPerformed
        CadastroContasReceber ccr = new CadastroContasReceber(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_jmiCadastroFinanceiroReceberActionPerformed

    private void jmiCadastroAdministrativoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroAdministrativoFuncionarioActionPerformed
        CadastroFuncionarios cfun = new CadastroFuncionarios(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmiCadastroAdministrativoFuncionarioActionPerformed

    private void jmiCadastroEstoqueFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroEstoqueFornecedoresActionPerformed
        CadastroFornecedor cf  = new CadastroFornecedor(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_jmiCadastroEstoqueFornecedoresActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        Pedidos pedido = new Pedidos(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        CadastroProdutos cpp = new CadastroProdutos(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void jmiConsultaAdministrativoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaAdministrativoClientesActionPerformed
        ConsultaCliente conCli = new ConsultaCliente(usuario);        
    }//GEN-LAST:event_jmiConsultaAdministrativoClientesActionPerformed

    private void jmiConsultaAdministrativoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaAdministrativoFuncionarioActionPerformed
        ConsultaFuncionário con = new ConsultaFuncionário();
    }//GEN-LAST:event_jmiConsultaAdministrativoFuncionarioActionPerformed

    private void jmiCadastroAdministrativoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroAdministrativoClienteActionPerformed
        CadastroCliente cc = new CadastroCliente(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_jmiCadastroAdministrativoClienteActionPerformed

    private void jmiCadastroEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastroEstoqueProdutosActionPerformed
        CadastroProdutos cpp = new CadastroProdutos(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_jmiCadastroEstoqueProdutosActionPerformed

    private void jmiFinanceiroReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFinanceiroReceberActionPerformed
        ConsultaContaReceber ccr = new ConsultaContaReceber(usuario);
    }//GEN-LAST:event_jmiFinanceiroReceberActionPerformed

    private void jmiFinanceiroPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFinanceiroPagarActionPerformed
        ConsultaContaPagar ccp = new ConsultaContaPagar(usuario);
    }//GEN-LAST:event_jmiFinanceiroPagarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ConsultaFornecedor cf = new ConsultaFornecedor(usuario);        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jmiEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstoqueProdutosActionPerformed
        ConsultaProdutos cp = new ConsultaProdutos(usuario);
    }//GEN-LAST:event_jmiEstoqueProdutosActionPerformed

    private void btnLembretesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLembretesActionPerformed
        CadastroLembretes cl = new CadastroLembretes(this, rootPaneCheckingEnabled,usuario);
    }//GEN-LAST:event_btnLembretesActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ConsultaLembretes cl = new ConsultaLembretes(usuario);        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmiMovimentacaoMovimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMovimentacaoMovimentarActionPerformed
        MovimentaMercadorias em = new MovimentaMercadorias(this, rootPaneCheckingEnabled);
    }//GEN-LAST:event_jmiMovimentacaoMovimentarActionPerformed

    private void jmiConsultaVendasPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultaVendasPedidoActionPerformed
        ConsultaPedidos consultarPedidos = new ConsultaPedidos(usuario);
    }//GEN-LAST:event_jmiConsultaVendasPedidoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            ManipulacaoArquivos ma = new ManipulacaoArquivos();             
            ma.removerArquivos();
            verificarLembretes();
            avisos();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao carregar Lembretes! ","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jmiMovimentacaoIventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMovimentacaoIventarioActionPerformed
        try {
            EstoqueController inventario = new EstoqueController();
            Relatorios.gerarPdfInventario(inventario.realizarInventario());
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jmiMovimentacaoIventarioActionPerformed
      
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            ConsultaEmpresa conEmp = new ConsultaEmpresa(null, rootPaneCheckingEnabled);
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this,"Problema ao consultar a empresa: \n"+ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            avisos();            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FormaPagamento pag = new FormaPagamento(null, rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiMenuPrincipalManutencaoBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMenuPrincipalManutencaoBackupActionPerformed
       Backup bc = new Backup();
       bc.relizarBackup();       
    }//GEN-LAST:event_jmiMenuPrincipalManutencaoBackupActionPerformed

    private void jmiRelatoriosPedidosHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatoriosPedidosHojeActionPerformed
        try {
            Relatorios.gerarRelatorio("ATUAL");
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório dos pedidos de hoje: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiRelatoriosPedidosHojeActionPerformed

    private void jmiRelatoriosPedidosTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatoriosPedidosTodosActionPerformed
        try {
            Relatorios.gerarRelatorio("TODOS");
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório de todos os pedidos: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiRelatoriosPedidosTodosActionPerformed
            
    private void iniciarFundo(){         
        panel_img p = new panel_img();
        this.add(p);
        this.pack();
        //File imagem = new File("fundo.jpg");        
        //panelFundo.setImagem(imagem);//SETTAR FUNDO NA IMAGEM EM DIFERENTES PLATAFORMAS         
        Relogio r = new Relogio();         
        this.panel_relogio.add(r);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);        
    }    
    
    private void acessos(UsuarioModel usu){
        lblUsuario.setText(usu.getNome());
        if(usu.getNivel().equals("PADRÃO")){
            jmiCadastroAdministrativoFuncionario.setVisible(false);
            jmiConsultaAdministrativoFuncionario.setVisible(false);            
        }
    }

    private void verificarLembretes() throws SQLException, ClassNotFoundException{
        LembreteController lembreteController = new LembreteController();  
        List<LembreteModel> lembretes;       
        lembretes = lembreteController.listarTodosLembretesDoDia();      
        if(!lembretes.isEmpty()){
            lembretes.forEach((lemb) -> {                  
                JOptionPane.showMessageDialog(this,lemb.getDescricao(),"Código Lembrete: "+ lemb.getIdLembrete(),JOptionPane.WARNING_MESSAGE);
            });                        
        }
    }
    
    private void avisos() throws SQLException, ClassNotFoundException{
        boolean p,r;
        ContasPagarController pagar = new ContasPagarController();
        ContasReceberController receber = new ContasReceberController();
        p = pagar.existePagarVencidas();
        r = receber.existeReceberVencidas();
        //VERIFICAR SE EXISTE CONTAS A PAGAR EM ABERTO
        if(p == true){
            lblContasPagar.setText("Existem contas a Pagar em aberto!");
        }else if(p == false){
            lblContasPagar.setText("Sem contas à pagar");
        }
        //VERIFICAR SE EXISTE CONTAS A RECEBER EM ABERTO
        if(r == true){
            lblContasReceber.setText("Existem contas a Receber em aberto!");
        }else if(r == false){
            lblContasReceber.setText("Sem contas à receber");
        }
    }

    private void configurarOpcao() throws SQLException, ClassNotFoundException{
        ConfiguracaoController confCont = new ConfiguracaoController();
        //ConfiguracaoModel confModel = new ConfiguracaoModel();
        ConfiguracaoModel confModel;
        confModel= confCont.verificarConfiguracao();
        if(confModel.getAdm()==0){
            btnCliente.setVisible(false);
            jmiCadastroAdministrativo.setVisible(false);
            jmiConsultaAdministrativo.setVisible(false);
        }            
        if(confModel.getEstoque()==0){
            btnProduto.setVisible(false);
            btnFornecedor.setVisible(false);
            jmiCadastroEstoque.setVisible(false);
            jmiConsultaEstoque.setVisible(false);
            jmiMovimentacao.setVisible(false);
        }        
        if(confModel.getFinanceiro()==0){
            btnContas.setVisible(false);
            jmiCadastroFinanceiro.setVisible(false);
            jmiConsultaFinanceiro.setVisible(false);
        }
        if(confModel.getLembrete()==0){
            btnLembretes.setVisible(false);            
            jmiConsultaAdministrativo.setVisible(false);
        }
        if(confModel.getVendas()==0){
            btnPedidos.setVisible(false);
            jmiConsultaVendas.setVisible(false);            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnContas;
    private javax.swing.JButton btnFornecedor;
    private javax.swing.JButton btnLembretes;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnSair;
    private org.jdesktop.swingx.calendar.JXMonthView calendario;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JMenu jmiAjuda;
    private javax.swing.JMenu jmiArquivo;
    private javax.swing.JMenuItem jmiArquivoSair;
    private javax.swing.JMenu jmiCadastro;
    private javax.swing.JMenu jmiCadastroAdministrativo;
    private javax.swing.JMenuItem jmiCadastroAdministrativoCliente;
    private javax.swing.JMenuItem jmiCadastroAdministrativoFuncionario;
    private javax.swing.JMenu jmiCadastroEstoque;
    private javax.swing.JMenuItem jmiCadastroEstoqueFornecedores;
    private javax.swing.JMenuItem jmiCadastroEstoqueProdutos;
    private javax.swing.JMenu jmiCadastroFinanceiro;
    private javax.swing.JMenuItem jmiCadastroFinanceiroPagar;
    private javax.swing.JMenuItem jmiCadastroFinanceiroReceber;
    private javax.swing.JMenu jmiConsultaAdministrativo;
    private javax.swing.JMenuItem jmiConsultaAdministrativoClientes;
    private javax.swing.JMenuItem jmiConsultaAdministrativoFuncionario;
    private javax.swing.JMenu jmiConsultaEstoque;
    private javax.swing.JMenu jmiConsultaFinanceiro;
    private javax.swing.JMenu jmiConsultaVendas;
    private javax.swing.JMenuItem jmiConsultaVendasPedido;
    private javax.swing.JMenuItem jmiEstoqueProdutos;
    private javax.swing.JMenu jmiFinanceiro;
    private javax.swing.JMenuItem jmiFinanceiroPagar;
    private javax.swing.JMenuItem jmiFinanceiroReceber;
    private javax.swing.JMenuBar jmiMenuPrincipal;
    private javax.swing.JMenu jmiMenuPrincipalManutencao;
    private javax.swing.JMenuItem jmiMenuPrincipalManutencaoBackup;
    private javax.swing.JMenu jmiMovimentacao;
    private javax.swing.JMenuItem jmiMovimentacaoIventario;
    private javax.swing.JMenuItem jmiMovimentacaoMovimentar;
    private javax.swing.JMenu jmiRelatorios;
    private javax.swing.JMenu jmiRelatoriosPedidos;
    private javax.swing.JMenuItem jmiRelatoriosPedidosHoje;
    private javax.swing.JMenuItem jmiRelatoriosPedidosTodos;
    private javax.swing.JLabel lblContasPagar;
    private javax.swing.JLabel lblContasReceber;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lbl_relogio;
    private javax.swing.JPanel panelAvisos;
    private javax.swing.JPanel panel_relogio;
    // End of variables declaration//GEN-END:variables
}