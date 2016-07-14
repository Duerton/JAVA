package Controle;


import Supermercado.Estoque;
import Telas.TelaBalanca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleIniciarBalanca implements ActionListener {

    private final Estoque estoque;

    public ControleIniciarBalanca(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaBalanca balanca = new TelaBalanca();
        balanca.montarBalanca(estoque);
    }
}
