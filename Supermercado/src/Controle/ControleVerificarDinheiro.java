
package Controle;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleVerificarDinheiro implements ActionListener{
    private final Venda venda;
    private final JTextField valor;
    
    public ControleVerificarDinheiro(Venda venda, JTextField valor){
        this.venda = venda;
        this.valor = valor;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        float valorF = Float.parseFloat(valor.getText());
        float troco = venda.calcularTroco(valorF);
        DecimalFormat df = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(null, "Troco: R$" + df.format(troco));
    }
    
}

