package Controle;

import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Estoque;
import Telas.TelaFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleLogin implements ActionListener, KeyListener {

    private final JTextField login;
    private final JPasswordField senha;
    private final BD bd;
    private final Estoque estoque;
    private final Caixa caixa;

    public ControleLogin(JTextField login, JPasswordField senha, BD bd, Estoque estoque, Caixa caixa) {
        this.login = login;
        this.senha = senha;
        this.bd = bd;
        this.estoque = estoque;
        this.caixa = caixa;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String aux = login.getText();
        String auxS = senha.getText();
        if (bd.loginPessoa(aux, auxS)) {
            login.setText("");
            senha.setText("");
            TelaFuncionario telafuncionario = new TelaFuncionario();
            telafuncionario.montarTelaFuncionario(bd, estoque, caixa);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aux = login.getText();
        String auxS = senha.getText();
        if (bd.loginPessoa(aux, auxS)) {
            login.setText("");
            senha.setText("");
            TelaFuncionario telafuncionario = new TelaFuncionario();
            telafuncionario.montarTelaFuncionario(bd, estoque, caixa);
        }
    }
}
