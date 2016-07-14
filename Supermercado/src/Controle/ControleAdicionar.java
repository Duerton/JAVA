
package Controle;

import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Produto;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControleAdicionar implements ActionListener{
    
    private final DefaultListModel<Produto> produtos;
    private Caixa caixa;
    private final Estoque estoque;
    private final JTextField digitarCodigo;
    private final JTextField valorTotal;
    
    public ControleAdicionar(Estoque estoque, Caixa caixa, DefaultListModel<Produto> produtos, JTextField digitarCodigo, JTextField valorTotal){
        this.produtos = produtos;
        this.estoque = estoque;
        this.digitarCodigo = digitarCodigo;
        this.valorTotal = valorTotal;
        this.caixa = caixa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produto = estoque.buscarProduto(Integer.parseInt(digitarCodigo.getText()));
        produtos.addElement(produto);
        caixa.getVenda().adicionarProdutoVenda(produto);
        DecimalFormat df = new DecimalFormat("0.00");
        valorTotal.setText(String.valueOf(df.format(caixa.getVenda().getValorTotal())));
    }

   
    
    
}
