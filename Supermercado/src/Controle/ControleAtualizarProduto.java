
package Controle;

import Supermercado.Estoque;
import Supermercado.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleAtualizarProduto implements ActionListener{
    private final Estoque estoque;
    private final JTextField nome;
    private final JTextField valor;
    private final JTextField codigo;
    private final JTextField quantidade;
    
    public ControleAtualizarProduto(Estoque estoque, JTextField nome, JTextField quantidade, JTextField codigo, JTextField valor){
        this.estoque = estoque;
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "teste");
            estoque.inserirProdutoUnidade(Float.parseFloat(valor.getText()), nome.getText(), Float.parseFloat(quantidade.getText()));            
        }else{
            JOptionPane.showMessageDialog(null, "teste2");
            Produto produto = estoque.buscarProduto(Integer.parseInt(codigo.getText()));
            estoque.inserirPrateleira(produto, Float.parseFloat(quantidade.getText()));            
        }
    }
    
}
