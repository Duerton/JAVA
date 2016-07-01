
package Controle;

import Telas.TelaPagamento;
import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControleFinalizarVenda implements ActionListener{

    private Venda venda;
    
    public ControleFinalizarVenda(Venda venda){
        this.venda = venda;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TelaPagamento telaPagamento = new TelaPagamento();
        telaPagamento.montarPagamento(venda);
    }
    
}
