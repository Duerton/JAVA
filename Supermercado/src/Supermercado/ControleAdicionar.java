
package Supermercado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControleAdicionar implements ActionListener{
    
    private final DefaultListModel<Produto> produtos;
    private final BD bd;
    private final JTextField digitarCodigo;
    
    public ControleAdicionar(BD bd, DefaultListModel<Produto> produtos, JTextField digitarCodigo){
        this.produtos = produtos;
        this.bd = bd;
        this.digitarCodigo = digitarCodigo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        produtos.addElement(bd.buscarProduto(Integer.parseInt(digitarCodigo.getText())));
    }

   
    
    
}
