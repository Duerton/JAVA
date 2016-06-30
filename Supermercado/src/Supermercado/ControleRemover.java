
package Supermercado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ControleRemover implements ActionListener{
    private final JList<Produto> listaProdutos;
    private final DefaultListModel<Produto> produtos;
    
    public ControleRemover(JList listaProdutos, DefaultListModel produtos){
        this.listaProdutos = listaProdutos;
        this.produtos = produtos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produtoSelecionado = listaProdutos.getSelectedValue();
        produtos.removeElement(produtoSelecionado);
    }
    
    
}
