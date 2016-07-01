
package Controle;

import Supermercado.Produto;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ControleRemover implements ActionListener{
    private final JList<Produto> listaProdutos;
    private final DefaultListModel<Produto> produtos;
    private final Venda venda;
    private JTextField valorTotal;
    
    public ControleRemover(JList listaProdutos, DefaultListModel produtos, Venda venda, JTextField valorTotal){
        this.listaProdutos = listaProdutos;
        this.produtos = produtos;
        this.venda = venda;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produtoSelecionado = listaProdutos.getSelectedValue();
        venda.removerProdutoVenda(produtoSelecionado);        
        produtos.removeElement(produtoSelecionado);
        valorTotal.setText(String.valueOf(venda.getValorTotal()));
    }
    
    
}
