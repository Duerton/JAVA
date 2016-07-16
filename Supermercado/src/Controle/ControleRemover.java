
package Controle;

import Supermercado.Caixa;
import Supermercado.Item;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ControleRemover implements ActionListener{
    private final JList<Item> listaItens;
    private final DefaultListModel<Item> itens;
    private final Caixa caixa;
    private final JTextField valorTotal;
    
    public ControleRemover(JList listaItens, DefaultListModel itens, Caixa caixa, JTextField valorTotal){
        this.listaItens = listaItens;
        this.itens = itens;
        this.caixa = caixa;
        this.valorTotal = valorTotal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Item itemSelecionado = listaItens.getSelectedValue();
        caixa.getVenda().removerProdutoVenda(itemSelecionado);        
        itens.removeElement(itemSelecionado);
        valorTotal.setText(String.valueOf(caixa.getVenda().getValorTotal()));
    }
    
    
}
