package Telas;

import Controle.ControleVisualizar;
import Controle.ControlePagamento;
import Controle.ControleNovaVenda;
import Controle.ControleRemover;
import Controle.ControleAdicionar;
import Controle.ControleFinalizarVenda;
import Controle.ControleIniciarBalanca;
import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Produto;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TelaFuncionario {

    private final DefaultListModel<Produto> produtos = new DefaultListModel<>();
    private final JList<Produto> listaProdutos = new JList();
    private JTextField nomeProduto;
    private JTextField valorProduto;
    private JTextField digitarCodigo;
    private JTextField valorTotal;

    public void montarTelaFuncionario(BD bd, Estoque estoque, Caixa caixa) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelGeral = new JPanel(new BorderLayout());
        JPanel painelLista = new JPanel(new GridLayout(1, 1));
        painelLista.setBorder(BorderFactory.createTitledBorder("Produtos"));
        listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProdutos.setModel(produtos);
        painelLista.add(new JScrollPane(listaProdutos));
        painelGeral.add(painelLista, BorderLayout.CENTER);
        frame.add(painelGeral);

        JButton novaVenda = new JButton("Nova Venda");
        JButton adicionar = new JButton("Adicionar");
        JButton remover = new JButton("Remover");
        JButton consultar = new JButton("Consultar");
        JButton balanca = new JButton("Balança");
        JButton pagamento = new JButton("Forma de Pagamento");
        JButton finalizarVenda = new JButton("Finalizar Venda");
        JButton desconectar = new JButton("Desconectar");
        JPanel painelBotoes = new JPanel(new GridLayout(10, 1));
        painelBotoes.add(novaVenda);
        painelBotoes.add(adicionar);
        painelBotoes.add(remover);
        painelBotoes.add(consultar);
        painelBotoes.add(balanca);
        painelBotoes.add(pagamento);
        painelBotoes.add(finalizarVenda);
        painelBotoes.add(desconectar);
        painelGeral.add(painelBotoes, BorderLayout.EAST);
        
        digitarCodigo = new JTextField();
        JLabel codigo = new JLabel("Codigo: ");
        valorTotal = new JTextField();
        JLabel valorTotalL = new JLabel("Total: R$");
        JPanel painelCodigo = new JPanel(new GridLayout(1, 4));
        painelCodigo.add(codigo);
        painelCodigo.add(digitarCodigo);
        painelCodigo.add(valorTotalL);
        painelCodigo.add(valorTotal);
        painelGeral.add(painelCodigo, BorderLayout.SOUTH);

        nomeProduto = new JTextField();
        valorProduto = new JTextField();
        JLabel nome = new JLabel("Nome: ");
        JLabel valor = new JLabel("Valor: R$");
        JPanel painelDescricao = new JPanel(new GridLayout(10, 1));
        painelDescricao.add(nome);
        painelDescricao.add(nomeProduto);
        painelDescricao.add(valor);
        painelDescricao.add(valorProduto);
        painelGeral.add(painelDescricao, BorderLayout.WEST);
        
        adicionar.setEnabled(false);
        consultar.setEnabled(false);
        finalizarVenda.setEnabled(false);
        remover.setEnabled(false);
        pagamento.setEnabled(false);
        nomeProduto.setEditable(false);
        valorProduto.setEditable(false);
        valorTotal.setEditable(false);
        digitarCodigo.setEditable(false);
        
        
        balanca.addActionListener(new ControleIniciarBalanca(estoque));
        novaVenda.addActionListener(new ControleNovaVenda(caixa, adicionar, consultar, remover, pagamento, finalizarVenda, novaVenda, nomeProduto, valorProduto, valorTotal, digitarCodigo));
        consultar.addActionListener(new ControleVisualizar(estoque, nomeProduto, valorProduto, digitarCodigo));
        adicionar.addActionListener(new ControleAdicionar(estoque, caixa, produtos, digitarCodigo, valorTotal));
        adicionar.addActionListener(new ControleVisualizar(estoque, nomeProduto, valorProduto, digitarCodigo));
        remover.addActionListener(new ControleRemover(listaProdutos, produtos, caixa, valorTotal));
        pagamento.addActionListener(new ControlePagamento(caixa, adicionar, consultar, remover, pagamento, finalizarVenda, desconectar));
        finalizarVenda.addActionListener(new ControleFinalizarVenda(caixa,adicionar, consultar, remover, pagamento, finalizarVenda, novaVenda, desconectar, produtos, nomeProduto, valorProduto, valorTotal, digitarCodigo));
        desconectar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }            
        });

        frame.pack();
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
