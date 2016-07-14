
package Controle;

import Supermercado.Caixa;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ControleRemover implements ActionListener{
    private final JList<Produto> listaProdutos;
    private final DefaultListModel<Produto> produtos;
    private final Caixa caixa;
    private JTextField valorTotal;
    
    public ControleRemover(JList listaProdutos, DefaultListModel produtos, Caixa caixa, JTextField valorTotal){
        this.listaProdutos = listaProdutos;
        this.produtos = produtos;
        this.caixa = caixa;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produtoSelecionado = listaProdutos.getSelectedValue();
        caixa.getVenda().removerProdutoVenda(produtoSelecionado);        
        produtos.removeElement(produtoSelecionado);
        valorTotal.setText(String.valueOf(caixa.getVenda().getValorTotal()));
    }
    
    
}
