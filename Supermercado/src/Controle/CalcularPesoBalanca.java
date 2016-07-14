
package Controle;

import Supermercado.Balanca;
import Supermercado.Estoque;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalcularPesoBalanca implements ActionListener{
    private final JTextField peso;
    private final JTextField codigo;
    private final Estoque estoque;
    
    public CalcularPesoBalanca(Estoque estoque, JTextField peso, JTextField codigo){
        this.codigo = codigo;
        this.peso = peso;
        this.estoque = estoque;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Produto produto = estoque.buscarProduto(Integer.parseInt(codigo.getText()));
        Balanca balanca = new Balanca();
        JOptionPane.showMessageDialog(null, "Valor: " + balanca.calcularPeso(produto, Integer.parseInt(peso.getText())));
    }
    
}
