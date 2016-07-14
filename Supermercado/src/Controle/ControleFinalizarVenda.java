package Controle;

import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleFinalizarVenda implements ActionListener {

    private final JButton adicionar;
    private final JButton consultar;
    private final JButton remover;
    private final JButton finalizarVenda;
    private final JButton novaVenda;
    private final JButton pagamento;
    private final JButton desconectar;
    private final Caixa caixa;
    private final DefaultListModel produtos;
    private final JTextField nomeProduto;
    private final JTextField valorProduto;
    private final JTextField valorTotal;
    private final JTextField digitarCodigo;

    public ControleFinalizarVenda(Caixa caixa, JButton adicionar, JButton consultar, JButton remover, JButton pagamento, JButton finalizarVenda, JButton novaVenda, JButton desconectar, DefaultListModel produtos, JTextField nomeProduto, JTextField valorProduto, JTextField valorTotal, JTextField digitarCodigo) {
        this.adicionar = adicionar;
        this.consultar = consultar;
        this.remover = remover;
        this.finalizarVenda = finalizarVenda;
        this.novaVenda = novaVenda;
        this.pagamento = pagamento;
        this.caixa = caixa;
        this.produtos = produtos;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.valorTotal = valorTotal;
        this.digitarCodigo = digitarCodigo;
        this.desconectar = desconectar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        caixa.finalizarVenda();
        JOptionPane.showMessageDialog(null, "Venda Finalizada");
        produtos.clear();
        nomeProduto.setText("");
        valorProduto.setText("");
        valorTotal.setText("");
        digitarCodigo.setText("");
        nomeProduto.setEditable(false);
        valorProduto.setEditable(false);
        valorTotal.setEditable(false);
        digitarCodigo.setEditable(false);
        adicionar.setEnabled(false);
        consultar.setEnabled(false);
        finalizarVenda.setEnabled(false);
        remover.setEnabled(false);
        pagamento.setEnabled(false);
        novaVenda.setEnabled(true);
        desconectar.setEnabled(true);
    }

}
