package Supermercado;

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
    private JTextField codigoProduto;
    private JTextField nomeProduto;
    private JTextField valorProduto;
    private JTextField descricaoProduto;
    private JTextField digitarCodigo;

    public void montarTelaFuncionario(BD bd) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelGeral = new JPanel(new BorderLayout());
        JPanel painelLista = new JPanel();
        painelLista.setBorder(BorderFactory.createTitledBorder("Produtos"));
        listaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProdutos.setModel(produtos);
        painelLista.add(new JScrollPane(listaProdutos));
        painelGeral.add(painelLista, BorderLayout.WEST);
        frame.add(painelGeral);

        JButton adicionar = new JButton("Adicionar");
        JButton remover = new JButton("Remover");
        JButton visualizar = new JButton("Visualizar");
        JButton sair = new JButton("Sair");
        JPanel painelBotoes = new JPanel(new GridLayout(5, 1));
        painelBotoes.add(adicionar);
        painelBotoes.add(remover);
        painelBotoes.add(visualizar);
        painelBotoes.add(sair);
        painelGeral.add(painelBotoes, BorderLayout.EAST);

        digitarCodigo = new JTextField("Digite o codigo aqui");
        JLabel codigo = new JLabel("Codigo: ");
        JPanel painelCodigo = new JPanel(new GridLayout(1, 2));
        painelCodigo.add(codigo);
        painelCodigo.add(digitarCodigo);
        painelGeral.add(painelCodigo, BorderLayout.SOUTH);

        codigoProduto = new JTextField();
        nomeProduto = new JTextField();
        valorProduto = new JTextField();
        descricaoProduto = new JTextField();
        JLabel nome = new JLabel("Nome: ");
        JLabel valor = new JLabel("Valor: ");
        JLabel codigo2 = new JLabel("Codigo: ");
        JLabel descricao = new JLabel("Descrição: ");
        JPanel painelDescricao = new JPanel(new GridLayout(4, 2));
        painelDescricao.add(codigo2);
        painelDescricao.add(codigoProduto);
        painelDescricao.add(nome);
        painelDescricao.add(nomeProduto);
        painelDescricao.add(valor);
        painelDescricao.add(valorProduto);
        painelDescricao.add(descricao);
        painelDescricao.add(descricaoProduto);
        painelGeral.add(painelDescricao, BorderLayout.CENTER);
        
               
        
        visualizar.addActionListener(new ControleVisualizar(bd, listaProdutos, codigoProduto, nomeProduto, valorProduto, descricaoProduto, digitarCodigo));
        adicionar.addActionListener(new ControleAdicionar(bd, produtos, digitarCodigo));
        remover.addActionListener(new ControleRemover(listaProdutos, produtos));

        frame.pack();
        frame.setSize(650, 200);
        frame.setVisible(true);

        frame.pack();
        frame.setVisible(true);
    }

}
