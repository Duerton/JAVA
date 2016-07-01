
package Controle;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleVerificarCartao implements ActionListener{
    private final Venda venda;
    private final JPasswordField senha;
    
    public ControleVerificarCartao(Venda venda, JPasswordField senha){
        this.venda = venda;
        this.senha = senha;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        int senhaI = Integer.parseInt(senha.getText());
        if(venda.finalizarVenda(senhaI)){
            JOptionPane.showMessageDialog(null, "Transação aceita");
        }
        else {
            JOptionPane.showMessageDialog(null, "Transação incompleta");
        }
    }
    
}
