
package Controle;

import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Item;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class ControleAdicionar implements ActionListener{
    
    private final DefaultListModel<Item> itens;
    private Caixa caixa;
    private final Estoque estoque;
    private final JTextField digitarCodigo;
    private final JTextField valorTotal;
    private final JTextField quantidade;
    
    public ControleAdicionar(Estoque estoque, Caixa caixa, DefaultListModel<Item> itens, JTextField digitarCodigo, JTextField valorTotal, JTextField quantidade){
        this.itens = itens;
        this.estoque = estoque;
        this.digitarCodigo = digitarCodigo;
        this.caixa = caixa;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produto = estoque.buscarProduto(Integer.parseInt(digitarCodigo.getText()));
        Item item = new Item(produto, Float.parseFloat(quantidade.getText()));        
        itens.addElement(item);
        caixa.getVenda().adicionarProdutoVenda(item);
        estoque.retirarPrateleira(produto, Integer.parseInt(quantidade.getText()));
        DecimalFormat df = new DecimalFormat("0.00");
        valorTotal.setText(String.valueOf(df.format(caixa.getVenda().getValorTotal())));
    }

   
    
    
}
