
package Supermercado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JTextField;

public class ControleVisualizar implements ActionListener {
    
    private final BD bd;
    private final JList<Produto> listaProdutos;
    private final JTextField codigoProduto;
    private final JTextField nomeProduto;
    private final JTextField valorProduto;
    private final JTextField descricaoProduto;
    private final JTextField digitarCodigo;
    
    public ControleVisualizar(BD bd,JList lista, JTextField codigo, JTextField nome, JTextField valor, JTextField descricao, JTextField digitarCodigo){
        this.codigoProduto = codigo;
        this.descricaoProduto = descricao;
        this.listaProdutos = lista;
        this.nomeProduto = nome;
        this.valorProduto = valor;
        this.bd = bd;
        this.digitarCodigo = digitarCodigo;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Integer codigoI = Integer.parseInt(digitarCodigo.getText());
        Produto produto = bd.buscarProduto(codigoI);
        codigoProduto.setText(String.valueOf(produto.getCodigo()));
        valorProduto.setText(String.valueOf(produto.getValorProd()));
        descricaoProduto.setText(produto.getDescricao());
        nomeProduto.setText(produto.getNome());
    }    
}
