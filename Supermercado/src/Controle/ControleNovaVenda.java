
package Controle;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControleNovaVenda implements ActionListener{
    private JButton adicionar;
    private JButton visualizar;
    private JButton remover;
    private JButton finalizarVenda;
    private JButton novaVenda;
    
    public ControleNovaVenda(JButton adicionar, JButton visualizar, JButton remover, JButton finalizarVenda, JButton novaVenda){
        this.adicionar = adicionar;
        this.visualizar = visualizar;
        this.remover = remover;
        this.finalizarVenda = finalizarVenda;
        this.novaVenda = novaVenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Nova venda iniciada");
        adicionar.setEnabled(true);
        visualizar.setEnabled(true);
        finalizarVenda.setEnabled(true);
        remover.setEnabled(true);
        novaVenda.setEnabled(false);
    }
    
}
