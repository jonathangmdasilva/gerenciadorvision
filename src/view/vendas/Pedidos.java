package view.vendas;

import controller.administrativo.ClienteController;
import controller.estoque.ProdutoController;
import controller.vendas.PagamentoController;
import controller.vendas.PedidoController;
import ia.InteligenciaArtificial;
import ia.ManipulacaoArquivos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.administrativo.ClienteModel;
import model.administrativo.UsuarioModel;
import model.estoque.ProdutoModel;
import model.vendas.CotacaoModel;
import model.vendas.FormaPagamentoModel;
import model.vendas.ItemPedidoModel;
import model.vendas.PedidoModel;
import relatorio.Relatorios;
import tablemodels.ClientePedidoTableModel;
import tablemodels.ItemPedidoTableModel;
import tablemodels.ProdutoPedidoTableModel;
import view.consulta.ConsultaPedidos;
import view.diversos.FormaPagamento;
import view.validacao.Validar;

//javax.swing.JDialog
public class Pedidos extends javax.swing.JFrame {
    
    Validar validar = new Validar();
    //CONTROLLERS
    ClienteController clienteController = new ClienteController();
    ProdutoController produtoController = new ProdutoController();
    PedidoController pedidoController = new PedidoController();
    //TABLEMODELS
    ClientePedidoTableModel clienteTableModel= new ClientePedidoTableModel();                 
    ProdutoPedidoTableModel produtoTableModel= new ProdutoPedidoTableModel();                 
    ItemPedidoTableModel itemPedidoTableModel = new ItemPedidoTableModel();
    //MODELS
    UsuarioModel usuario;
    ClienteModel cliente = new ClienteModel();
    FormaPagamentoModel pagamento = new FormaPagamentoModel();
    PedidoModel pedidoModel = new PedidoModel();
    CotacaoModel cotacaoModel = new CotacaoModel();
    ProdutoModel produto = new ProdutoModel();
    //LISTAS
    List<ItemPedidoModel> listaItemPedido = new ArrayList<>();        
    List<ClienteModel> listaClientes = new ArrayList<>();
    List<ProdutoModel> listaProdutos = new ArrayList<>();
    
        
    public Pedidos(java.awt.Frame parent, boolean modal,UsuarioModel us) {                
        initComponents();     
        configurarTabela();
        this.usuario= us;
        setLocationRelativeTo(null);                
        tbl_cliente.setModel(clienteTableModel);
        tbl_produto.setModel(produtoTableModel);
        tbl_item_pedidos.setModel(itemPedidoTableModel);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    
    private ItemPedidoTableModel getModelo() {
	if(itemPedidoTableModel == null){
            itemPedidoTableModel = new ItemPedidoTableModel(listaItemPedido);
	}
	return itemPedidoTableModel;		
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDadosCliente = new javax.swing.JDesktopPane();
        lblQuantidade1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblUnitário = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        panelProdutos = new javax.swing.JDesktopPane();
        panelItensPedido = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_item_pedidos = new javax.swing.JTable();
        panelInformacoes = new javax.swing.JDesktopPane();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbFormaPagamento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnExcluirItem = new javax.swing.JButton();
        lblRecebido = new javax.swing.JLabel();
        txtRecebido = new javax.swing.JTextField();
        lblTroco = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        btnCotacao = new javax.swing.JButton();
        chkImprimir = new javax.swing.JCheckBox();
        panelAdicionaProduto2 = new javax.swing.JDesktopPane();
        lblProduto2 = new javax.swing.JLabel();
        lblQuantidade3 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        lblUnitário2 = new javax.swing.JLabel();
        lblTotal2 = new javax.swing.JLabel();
        txtUnitárioProduto = new javax.swing.JTextField();
        txtTotalProduto = new javax.swing.JTextField();
        btnAdicionarItem = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lblQuantidade4 = new javax.swing.JLabel();
        jDesktopPaneClientes = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        txtProcuraCliente = new javax.swing.JTextField();
        jScrollPaneClientes = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        jDesktopPaneProdutos = new javax.swing.JDesktopPane();
        jLabel6 = new javax.swing.JLabel();
        txtProcuraProduto = new javax.swing.JTextField();
        jScrollPaneProdutos = new javax.swing.JScrollPane();
        tbl_produto = new javax.swing.JTable();
        jmiMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiArquivoCotacao = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiCotacao = new javax.swing.JMenu();
        jmiGerarCotacao = new javax.swing.JMenuItem();
        jmiCotacaoCarregar = new javax.swing.JMenuItem();
        jmiOportunidade = new javax.swing.JMenu();
        jmiOportunidadeMomentoDeOuro = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAjudaAjuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos");
        setMinimumSize(new java.awt.Dimension(1000, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblQuantidade1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuantidade1.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade1.setText("Nome");

        txtNome.setEditable(false);
        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.setText("NOME DO CLIENTE");
        txtNome.setEnabled(false);

        lblUnitário.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUnitário.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitário.setText("Telefone");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("E-mail");

        txtTelefone.setEditable(false);
        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTelefone.setText("(xx)xxxxx-xxxx");
        txtTelefone.setEnabled(false);

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setText("email@gmail.com");
        txtEmail.setEnabled(false);

        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cliente(x128).png"))); // NOI18N

        panelDadosCliente.setLayer(lblQuantidade1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(txtNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(lblUnitário, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(lblTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(txtTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(txtEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelDadosCliente.setLayer(lblCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelDadosClienteLayout = new javax.swing.GroupLayout(panelDadosCliente);
        panelDadosCliente.setLayout(panelDadosClienteLayout);
        panelDadosClienteLayout.setHorizontalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosClienteLayout.createSequentialGroup()
                        .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnitário, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosClienteLayout.createSequentialGroup()
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
                            .addComponent(txtEmail)))
                    .addComponent(txtNome)
                    .addComponent(lblQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDadosClienteLayout.setVerticalGroup(
            panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosClienteLayout.createSequentialGroup()
                .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblQuantidade1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnitário)
                            .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDadosClienteLayout.createSequentialGroup()
                                    .addComponent(lblTotal)
                                    .addGap(34, 34, 34)))))
                    .addGroup(panelDadosClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_item_pedidos.setModel(getModelo());
        tbl_item_pedidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tbl_item_pedidos.setRowSelectionAllowed(false);
        tbl_item_pedidos.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tbl_item_pedidos);

        panelItensPedido.setViewportView(jScrollPane1);

        panelProdutos.setLayer(panelItensPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelProdutosLayout = new javax.swing.GroupLayout(panelProdutos);
        panelProdutos.setLayout(panelProdutosLayout);
        panelProdutosLayout.setHorizontalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelItensPedido)
                .addContainerGap())
        );
        panelProdutosLayout.setVerticalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelItensPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Confirmar.png"))); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setToolTipText("Finalizar Vendar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sub Total");

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSubTotal.setForeground(new java.awt.Color(0, 102, 255));
        txtSubTotal.setText("R$ 0,00");
        txtSubTotal.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Desconto");

        txtDesconto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDesconto.setText("R$ 0,00");
        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Form. Pag.");

        cmbFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbFormaPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFormaPagamentoItemStateChanged(evt);
            }
        });
        cmbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFormaPagamentoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 102, 255));
        txtTotal.setText("R$ 0,00");
        txtTotal.setEnabled(false);

        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Deletar.png"))); // NOI18N
        btnExcluirItem.setText("Remover");
        btnExcluirItem.setToolTipText("remover item do Pedido");
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        lblRecebido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRecebido.setForeground(new java.awt.Color(255, 255, 255));
        lblRecebido.setText("Recebido");

        txtRecebido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtRecebido.setText("R$ 0,00");
        txtRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRecebidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRecebidoFocusLost(evt);
            }
        });
        txtRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecebidoKeyPressed(evt);
            }
        });

        lblTroco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTroco.setForeground(new java.awt.Color(255, 255, 255));
        lblTroco.setText("Troco");

        txtTroco.setEditable(false);
        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTroco.setForeground(new java.awt.Color(0, 51, 255));
        txtTroco.setText("R$ 0,00");

        btnCotacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cotação.png"))); // NOI18N
        btnCotacao.setText("Cotação");
        btnCotacao.setToolTipText("Gerar Cotação");
        btnCotacao.setPreferredSize(new java.awt.Dimension(101, 36));
        btnCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotacaoActionPerformed(evt);
            }
        });

        chkImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chkImprimir.setForeground(new java.awt.Color(255, 255, 255));
        chkImprimir.setSelected(true);
        chkImprimir.setText("Imprimir recibo");

        panelInformacoes.setLayer(btnFinalizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(txtSubTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(txtDesconto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(cmbFormaPagamento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(txtTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(btnExcluirItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(lblRecebido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(txtRecebido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(lblTroco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(txtTroco, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(btnCotacao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelInformacoes.setLayer(chkImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelInformacoesLayout = new javax.swing.GroupLayout(panelInformacoes);
        panelInformacoes.setLayout(panelInformacoesLayout);
        panelInformacoesLayout.setHorizontalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubTotal)
                    .addComponent(txtDesconto)
                    .addComponent(txtRecebido)
                    .addComponent(txtTroco)
                    .addComponent(txtTotal)
                    .addComponent(cmbFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInformacoesLayout.createSequentialGroup()
                        .addGroup(panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(lblRecebido)
                            .addComponent(lblTroco)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chkImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInformacoesLayout.setVerticalGroup(
            panelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecebido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTroco)
                .addGap(1, 1, 1)
                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkImprimir)
                .addGap(3, 3, 3)
                .addComponent(btnCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblProduto2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProduto2.setForeground(new java.awt.Color(255, 255, 255));
        lblProduto2.setText("Produto");

        lblQuantidade3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuantidade3.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade3.setText("Qtd.");

        txtQtd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtdFocusGained(evt);
            }
        });
        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtdKeyReleased(evt);
            }
        });

        txtProduto.setEditable(false);
        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProduto.setEnabled(false);

        lblUnitário2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUnitário2.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitário2.setText("Vl. Unitário");

        lblTotal2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal2.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal2.setText("Vl. Total");

        txtUnitárioProduto.setEditable(false);
        txtUnitárioProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUnitárioProduto.setEnabled(false);

        txtTotalProduto.setEditable(false);
        txtTotalProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalProduto.setEnabled(false);

        btnAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Adicionar.png"))); // NOI18N
        btnAdicionarItem.setToolTipText("Adicionar Item ao pedido");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigo.setEnabled(false);

        lblQuantidade4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuantidade4.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade4.setText("Código");

        panelAdicionaProduto2.setLayer(lblProduto2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(lblQuantidade3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(txtQtd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(txtProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(lblUnitário2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(lblTotal2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(txtUnitárioProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(txtTotalProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(btnAdicionarItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelAdicionaProduto2.setLayer(lblQuantidade4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelAdicionaProduto2Layout = new javax.swing.GroupLayout(panelAdicionaProduto2);
        panelAdicionaProduto2.setLayout(panelAdicionaProduto2Layout);
        panelAdicionaProduto2Layout.setHorizontalGroup(
            panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantidade3)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantidade4)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                                .addComponent(lblProduto2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtProduto)))
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUnitário2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtUnitárioProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal2)
                            .addComponent(txtTotalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(btnAdicionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAdicionaProduto2Layout.setVerticalGroup(
            panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addComponent(lblQuantidade4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addComponent(lblProduto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addComponent(lblQuantidade3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addComponent(lblUnitário2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnitárioProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdicionaProduto2Layout.createSequentialGroup()
                        .addComponent(lblTotal2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAdicionaProduto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisa de Cliente");

        txtProcuraCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcuraClienteKeyReleased(evt);
            }
        });

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        jScrollPaneClientes.setViewportView(tbl_cliente);

        jDesktopPaneClientes.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(txtProcuraCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jScrollPaneClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneClientesLayout = new javax.swing.GroupLayout(jDesktopPaneClientes);
        jDesktopPaneClientes.setLayout(jDesktopPaneClientesLayout);
        jDesktopPaneClientesLayout.setHorizontalGroup(
            jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtProcuraCliente))
                .addContainerGap())
            .addComponent(jScrollPaneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jDesktopPaneClientesLayout.setVerticalGroup(
            jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProcuraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pesquisa de Produto");

        txtProcuraProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcuraProdutoKeyReleased(evt);
            }
        });

        tbl_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produtoMouseClicked(evt);
            }
        });
        jScrollPaneProdutos.setViewportView(tbl_produto);

        jDesktopPaneProdutos.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneProdutos.setLayer(txtProcuraProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneProdutos.setLayer(jScrollPaneProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneProdutosLayout = new javax.swing.GroupLayout(jDesktopPaneProdutos);
        jDesktopPaneProdutos.setLayout(jDesktopPaneProdutosLayout);
        jDesktopPaneProdutosLayout.setHorizontalGroup(
            jDesktopPaneProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneProdutosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addComponent(txtProcuraProduto))
                .addContainerGap())
            .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jDesktopPaneProdutosLayout.setVerticalGroup(
            jDesktopPaneProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneProdutosLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProcuraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Arquivo");

        jmiArquivoCotacao.setText("Cotação");
        jmiArquivoCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiArquivoCotacaoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiArquivoCotacao);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jmiMenu.add(jMenu1);

        jMenu3.setText("Consulta");

        jMenuItem2.setText("Consultar Pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jmiMenu.add(jMenu3);

        jmiCotacao.setText("Cotação");

        jmiGerarCotacao.setText("Gerar Cotação");
        jmiGerarCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGerarCotacaoActionPerformed(evt);
            }
        });
        jmiCotacao.add(jmiGerarCotacao);

        jmiCotacaoCarregar.setText("Carregar");
        jmiCotacaoCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCotacaoCarregarActionPerformed(evt);
            }
        });
        jmiCotacao.add(jmiCotacaoCarregar);

        jmiMenu.add(jmiCotacao);

        jmiOportunidade.setText("Oportunidade");

        jmiOportunidadeMomentoDeOuro.setText("Momento de Ouro");
        jmiOportunidadeMomentoDeOuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOportunidadeMomentoDeOuroActionPerformed(evt);
            }
        });
        jmiOportunidade.add(jmiOportunidadeMomentoDeOuro);

        jmiMenu.add(jmiOportunidade);

        jMenu2.setText("Ajuda");

        jmiAjudaAjuda.setText("Ajuda");
        jmiAjudaAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAjudaAjudaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAjudaAjuda);

        jmiMenu.add(jMenu2);

        setJMenuBar(jmiMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelProdutos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelAdicionaProduto2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDadosCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDesktopPaneProdutos)
                            .addComponent(jDesktopPaneClientes))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelDadosCliente)
                            .addComponent(jDesktopPaneClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDesktopPaneProdutos)
                            .addComponent(panelAdicionaProduto2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProdutos))
                    .addComponent(panelInformacoes))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            Integer op = JOptionPane.showConfirmDialog(null, "Deseja inserir observação ao pedido?","Confirmação",JOptionPane.YES_NO_OPTION);        
            if(op == 0){
                String observacao = JOptionPane.showInputDialog("Informa observação para o pedido").toUpperCase();            
                pedidoModel.setObservacao(observacao);
            }else{
                pedidoModel.setObservacao("SEM OBSERVAÇÃO");
            }            
            pagamento.setIdFormaPagamento(cmbFormaPagamento.getSelectedIndex()+1);
            pedidoModel.setCliente(cliente);
            pedidoModel.setUsuario(usuario);
            //pedidoModel.setDataHora(new java.util.Date (System.currentTimeMillis()));
            pedidoModel.setDesconto(validar.converteValorDigitadoemDouble(txtDesconto.getText()));            
            pedidoModel.setPagamento(pagamento);
            pedidoModel.setStatus("PAGO");
            pedidoModel.setSubTotal(validar.converteValorDigitadoemDouble(txtSubTotal.getText()));
            pedidoModel.setTotal(validar.converteValorDigitadoemDouble(txtTotal.getText()));
            if(listaItemPedido.isEmpty()==false){                
                pedidoController.inserirPedido(pedidoModel,listaItemPedido);
                validar.exibirConfirmacaoCadastro("Pedido");            
                if(chkImprimir.isSelected())Relatorios.gerarRelatorio("ORDER");
            }else{
                JOptionPane.showMessageDialog(null,"Lista de itens está vazia! São necessários itens para ser vendidos!","Atenção",JOptionPane.PLAIN_MESSAGE);
            }
            dispose();            
        } catch (HeadlessException | ClassNotFoundException | SQLException | NullPointerException e) {
            validar.exibirErroCadastro("Pedido: " + e.getMessage());
        }                        
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        ConsultaPedidos cp = new ConsultaPedidos(usuario);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmiAjudaAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAjudaAjudaActionPerformed
        validar.exibirAjudaCadastro("Pedidos");
    }//GEN-LAST:event_jmiAjudaAjudaActionPerformed

    private void jmiArquivoCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiArquivoCotacaoActionPerformed
        try {
            validar.sucesso("Cotação");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na cotação","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiArquivoCotacaoActionPerformed

    private void txtQtdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyReleased
        totalProduto(Integer.parseInt(txtQtd.getText()));
    }//GEN-LAST:event_txtQtdKeyReleased

    private void txtProcuraClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcuraClienteKeyReleased
        txtProcuraCliente.setText(txtProcuraCliente.getText().toUpperCase());
        consultarCliente();
    }//GEN-LAST:event_txtProcuraClienteKeyReleased

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
        this.cliente = clienteTableModel.getCliente(tbl_cliente.getSelectedRow());
        txtNome.setText(cliente.getNome());              
        txtTelefone.setText(cliente.getContato().getTelUm());
        txtEmail.setText(cliente.getContato().getEmail());        
    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void txtProcuraProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcuraProdutoKeyReleased
        consultarProduto();        
    }//GEN-LAST:event_txtProcuraProdutoKeyReleased

    private void tbl_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produtoMouseClicked
        produto = null;
        produto = produtoTableModel.getProduto(tbl_produto.getSelectedRow());
        txtCodigo.setText(produto.getIdProduto().toString());        
        txtProduto.setText(produto.getDescricao());
        txtUnitárioProduto.setText(validar.converterMoeda(produto.getLucro().getValorVenda()));
        txtQtd.requestFocus();
        txtQtd.setText("1");
    }//GEN-LAST:event_tbl_produtoMouseClicked

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        adicionarItemPedido();
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void txtQtdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdFocusGained
        try {
            totalProduto(Integer.parseInt(txtQtd.getText()));
        } catch (NumberFormatException e) {
            System.out.println("CAMPO QTD VAZIO; " + e.getMessage());
        }        
    }//GEN-LAST:event_txtQtdFocusGained

    private void txtQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
             adicionarItemPedido();
         }       
    }//GEN-LAST:event_txtQtdKeyPressed

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost
        txtDesconto.setText(validar.converterMoeda(txtDesconto.getText()));
        calcularTroco();
        calcularTotalPedido();
    }//GEN-LAST:event_txtDescontoFocusLost

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        excluirItemLista();
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void txtDescontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusGained
        txtDesconto.setText("");
    }//GEN-LAST:event_txtDescontoFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            carregarCombos();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Erro ao carregar combos: " + ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbFormaPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFormaPagamentoItemStateChanged
        if(cmbFormaPagamento.getSelectedItem().equals("DINHEIRO")){
            lblRecebido.setEnabled(true);
            lblRecebido.setVisible(true);
            txtRecebido.setEnabled(true);
            txtRecebido.setVisible(true);
            lblTroco.setEnabled(true);
            lblTroco.setVisible(true);
            txtTroco.setEnabled(true);
            txtTroco.setVisible(true);
        }else{
            lblRecebido.setEnabled(false);
            lblRecebido.setVisible(false);
            txtRecebido.setEnabled(false);
            txtRecebido.setVisible(false);
            lblTroco.setEnabled(false);
            lblTroco.setVisible(false);
            txtTroco.setEnabled(false);
            txtTroco.setVisible(false);
        }
    }//GEN-LAST:event_cmbFormaPagamentoItemStateChanged

    private void txtRecebidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRecebidoFocusGained
        txtRecebido.setText("");
    }//GEN-LAST:event_txtRecebidoFocusGained

    private void txtRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRecebidoFocusLost
        calcularTroco();
    }//GEN-LAST:event_txtRecebidoFocusLost

    private void btnCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotacaoActionPerformed
        gerarCotacao();        
    }//GEN-LAST:event_btnCotacaoActionPerformed

    private void jmiGerarCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGerarCotacaoActionPerformed
        gerarCotacao();
    }//GEN-LAST:event_jmiGerarCotacaoActionPerformed

    private void txtRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecebidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){                   
            calcularTroco();
        }        
    }//GEN-LAST:event_txtRecebidoKeyPressed

    private void jmiCotacaoCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCotacaoCarregarActionPerformed
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        LocalDate hj = LocalDate.now();                        
        try {            
            Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe código da Cotação!"));
            cotacaoModel = pedidoController.listarCotacaoCodigo(codigo);                        
            Instant instant = Instant.ofEpochMilli(cotacaoModel.getPedido().getDataHora().getTime());
            LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();            
            
            if((localDate.isAfter(hj)) && !(cotacaoModel.getPedido().getStatus().equals("INVALIDA"))){                                         
                pedidoModel = cotacaoModel.getPedido();
                pedidoModel.setStatus("PAGO");                                                
                listaItemPedido = pedidoController.listarItensCotacao(codigo);                                                                              
                pedidoController.inserirPedido(pedidoModel,listaItemPedido);
                pedidoController.invalidarCotacao(codigo);
                validar.exibirConfirmacaoCadastro("Pedido");            
            } else {
                if(cotacaoModel.getPedido().getStatus().equals("INVALIDA")) JOptionPane.showMessageDialog(null, "Cotação já utilizada!","Mensagem",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(this, "Cotação passou do período de validade!","Atenção",JOptionPane.WARNING_MESSAGE);                
            }            
        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a cotação no pedido: " +ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmiCotacaoCarregarActionPerformed

    private void jmiOportunidadeMomentoDeOuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOportunidadeMomentoDeOuroActionPerformed
        try {                        
            ManipulacaoArquivos ma = new ManipulacaoArquivos();             
            ma.removerArquivos();
            if(cliente.getIdCliente()!=null){
                InteligenciaArtificial ia = new InteligenciaArtificial();                                
                ma.gerarTxt("apriori",cliente.getIdCliente());
                ma.gerarArffApriori();                 
                MomentoDeOuro mo = new MomentoDeOuro(this, rootPaneCheckingEnabled,ia.carregarApriori());
            }else{
                JOptionPane.showMessageDialog(null,"Selecione o cliente! ","Cliente não selecionado",JOptionPane.INFORMATION_MESSAGE);
            }                                    
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, "Cliente não possui histórico de pedido! " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);                        
        }
    }//GEN-LAST:event_jmiOportunidadeMomentoDeOuroActionPerformed

    private void cmbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFormaPagamentoActionPerformed
    PagamentoController  pagCont = new PagamentoController();
        try {
            pagamento = pagCont.listarFormasPagamentoPelaDescricao(cmbFormaPagamento.getSelectedItem().toString());            
        } catch (ClassNotFoundException |SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }     
    }//GEN-LAST:event_cmbFormaPagamentoActionPerformed
    
    private void totalProduto(int qtd){        
        double total = qtd * validar.converteValorDigitadoemDouble(txtUnitárioProduto.getText());
        txtTotalProduto.setText(validar.converterMoeda(total));
    }
    
    
    private void consultarCliente(){
        try {
           listaClientes = clienteController.listarTodosNome(txtProcuraCliente.getText());
           clienteTableModel.limpar();
           clienteTableModel.addListaCliente(listaClientes);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void consultarProduto(){        
        try {
           listaProdutos = produtoController.listarTodosProdutosDescricao(txtProcuraProduto.getText());
           produtoTableModel.limpar();
           produtoTableModel.addListaProduto(listaProdutos);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void adicionarItemPedido(){
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
        double soma;
        try {                        
            if(!(produto==null)){
                boolean controle = true;
                for(int x=0;x< listaItemPedido.size();x++){
                    if(Objects.equals(listaItemPedido.get(x).getIdProduto(), produto.getIdProduto())){
                        soma = listaItemPedido.get(x).getQtd()+Double.parseDouble(txtQtd.getText());
                        listaItemPedido.get(x).setQtd(soma);                                                
                        listaItemPedido.get(x).setValorTotal(validar.converteValorDigitadoemDouble(txtTotalProduto.getText())+listaItemPedido.get(x).getValorTotal());
                        controle = false;
                        break;
                    }   
                }
                if(controle){
                    itemPedidoModel.setIdProduto(produto.getIdProduto());
                    itemPedidoModel.setProduto(produto);
                    itemPedidoModel.setQtd(validar.converteValorDigitadoemDouble(txtQtd.getText()));       
                    itemPedidoModel.setValorUnitario(validar.converteValorDigitadoemDouble(txtUnitárioProduto.getText()));        
                    itemPedidoModel.setValorTotal(validar.converteValorDigitadoemDouble(txtTotalProduto.getText()));                 
                    listaItemPedido.add(itemPedidoModel);                                
                }                                
                itemPedidoTableModel.addItemPedido(listaItemPedido);
                calcularTotalPedido();
            }else{
                JOptionPane.showMessageDialog(this,"Item não selecionado","Atenção",JOptionPane.WARNING_MESSAGE);
            }
            JOptionPane.showMessageDialog(rootPane, "Item adicionado à lista com sucesso!","Mensagem",JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Item não adicionado à lista!","Mensagem",JOptionPane.ERROR_MESSAGE);
            System.out.println("erro");
            e.getMessage();
        }                
    }
 
    private void calcularTotalPedido(){
        Double subtotalPedido = 0.0;
        subtotalPedido = listaItemPedido.stream().map((item) -> item.getValorTotal()).reduce(subtotalPedido, (accumulator, _item) -> accumulator + _item);
        txtSubTotal.setText(validar.converterMoeda(subtotalPedido));
        double total = ((subtotalPedido - validar.converteValorDigitadoemDouble(txtDesconto.getText())));
        txtTotal.setText(validar.converterMoeda(total));
    }
    
    private void carregarCombos() throws SQLException, ClassNotFoundException{
        List<FormaPagamentoModel> listaPagamentos;// = new ArrayList<>();
        listaPagamentos = pedidoController.listarFormasPagamento();
        if(listaPagamentos.isEmpty()){
            this.dispose();
            JOptionPane.showMessageDialog(this,"Cadastre forma de pagamento primeiro!: ");
            FormaPagamento pag = new FormaPagamento(null, rootPaneCheckingEnabled);
        }else{
            for (int i = 0; i < listaPagamentos.size(); i++) {
                cmbFormaPagamento.addItem(listaPagamentos.get(i).getDescricao());             
            }                      
        }        
    } 
    private void excluirItemLista(){
        int indice = tbl_item_pedidos.getSelectedRow();
        itemPedidoTableModel.remover(indice);
        listaItemPedido.remove(indice);
        calcularTotalPedido();
    }
    
    
    public final void configurarTabela(){
        tbl_item_pedidos.getColumnModel().getColumn(0).setPreferredWidth(20);
        tbl_item_pedidos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_item_pedidos.getColumnModel().getColumn(2).setPreferredWidth(15);
        tbl_item_pedidos.getColumnModel().getColumn(3).setPreferredWidth(25);
        tbl_item_pedidos.getColumnModel().getColumn(4).setPreferredWidth(25);
        tbl_item_pedidos.getColumnModel().getColumn(5).setPreferredWidth(10);        
    }        
    
    private void calcularTroco(){
        txtRecebido.setText(validar.converterMoeda(txtRecebido.getText()));
        Double recebido = validar.converteValorDigitadoemDouble(txtRecebido.getText());
        Double total = validar.converteValorDigitadoemDouble(txtTotal.getText());        
        if(recebido<total){
            JOptionPane.showMessageDialog(null,"Valor recebido inferior ao total do Pedido:","Valor inválido",JOptionPane.WARNING_MESSAGE);
            txtTroco.setForeground(Color.RED);
        }else{
            txtTroco.setForeground(Color.BLUE);            
        }        
        txtTroco.setText(validar.converterMoeda(recebido-total));        
    }

    private void gerarCotacao(){
        cotacaoModel.setPeriodo(Integer.parseInt(JOptionPane.showInputDialog("Informe tempo de validade da cotação")));        
        try {
            Integer op = JOptionPane.showConfirmDialog(this, "Deseja inserir observação na cotação?","Confirmação",JOptionPane.YES_NO_OPTION);        
            if(op == 0){
                String observacao = JOptionPane.showInputDialog("Informa observação para cotação");            
                pedidoModel.setObservacao(observacao);
            }else{
                pedidoModel.setObservacao("SEM OBSERVAÇÃO");
            }            
            pagamento.setIdFormaPagamento(cmbFormaPagamento.getSelectedIndex()+1);
            pedidoModel.setCliente(cliente);
            pedidoModel.setUsuario(usuario);
            pedidoModel.setDataHora(new java.util.Date (System.currentTimeMillis()));
            pedidoModel.setDesconto(validar.converteValorDigitadoemDouble(txtDesconto.getText()));            
            pedidoModel.setPagamento(pagamento);
            pedidoModel.setStatus("VALIDO");
            pedidoModel.setSubTotal(validar.converteValorDigitadoemDouble(txtSubTotal.getText()));
            pedidoModel.setTotal(validar.converteValorDigitadoemDouble(txtTotal.getText()));
            cotacaoModel.setPedido(pedidoModel);
            if(listaItemPedido.isEmpty()==false){                
                pedidoController.inserirCotacao(cotacaoModel,listaItemPedido);
                validar.exibirConfirmacaoCadastro("Cotação");            
            }else{
                JOptionPane.showMessageDialog(null,"Lista de itens está vazia! São necessários itens para ser vendidos!","Atenção",JOptionPane.PLAIN_MESSAGE);
            }
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.getMessage();
            validar.exibirErroCadastro("Cotação");
        }                        
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCotacao;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JCheckBox chkImprimir;
    private javax.swing.JComboBox<String> cmbFormaPagamento;
    private javax.swing.JDesktopPane jDesktopPaneClientes;
    private javax.swing.JDesktopPane jDesktopPaneProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneClientes;
    private javax.swing.JScrollPane jScrollPaneProdutos;
    private javax.swing.JMenuItem jmiAjudaAjuda;
    private javax.swing.JMenuItem jmiArquivoCotacao;
    private javax.swing.JMenu jmiCotacao;
    private javax.swing.JMenuItem jmiCotacaoCarregar;
    private javax.swing.JMenuItem jmiGerarCotacao;
    private javax.swing.JMenuBar jmiMenu;
    private javax.swing.JMenu jmiOportunidade;
    private javax.swing.JMenuItem jmiOportunidadeMomentoDeOuro;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto2;
    private javax.swing.JLabel lblQuantidade1;
    private javax.swing.JLabel lblQuantidade3;
    private javax.swing.JLabel lblQuantidade4;
    private javax.swing.JLabel lblRecebido;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal2;
    private javax.swing.JLabel lblTroco;
    private javax.swing.JLabel lblUnitário;
    private javax.swing.JLabel lblUnitário2;
    private javax.swing.JDesktopPane panelAdicionaProduto2;
    private javax.swing.JDesktopPane panelDadosCliente;
    private javax.swing.JDesktopPane panelInformacoes;
    private javax.swing.JScrollPane panelItensPedido;
    private javax.swing.JDesktopPane panelProdutos;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTable tbl_item_pedidos;
    private javax.swing.JTable tbl_produto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProcuraCliente;
    private javax.swing.JTextField txtProcuraProduto;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtRecebido;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalProduto;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtUnitárioProduto;
    // End of variables declaration//GEN-END:variables
}