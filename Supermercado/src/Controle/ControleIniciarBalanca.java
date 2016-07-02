package Controle;

import Supermercado.Venda;
import Telas.TelaBalanca;
import Telas.TelaFormaPagamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControleIniciarBalanca implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaBalanca balanca = new TelaBalanca();
        balanca.montarBalanca();
    }
}
