package Controle;

import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Funcionario;
import Telas.TelaFuncionario;
import Telas.TelaGerente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
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
        if (bd.loginFuncionario(aux, auxS)) {
            Funcionario funcionario = bd.getFuncionario(aux);
            if (funcionario.getCargo() == 0) {
                TelaGerente telagerente = new TelaGerente();
                telagerente.montarTelaGerente(bd, estoque);
                login.setText("");
                senha.setText("");
            } else {
                caixa.setLogin(login.getText());
                TelaFuncionario telafuncionario = new TelaFuncionario();
                telafuncionario.montarTelaFuncionario(bd, estoque, caixa);
                login.setText("");
                senha.setText("");
            }
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
        if (bd.loginFuncionario(aux, auxS)) {
            Funcionario funcionario = bd.getFuncionario(aux);
            if (funcionario.getCargo() == 0) {
                TelaGerente telagerente = new TelaGerente();
                telagerente.montarTelaGerente(bd, estoque);
                login.setText("");
                senha.setText("");
            } else {
                caixa.setLogin(login.getText());
                TelaFuncionario telafuncionario = new TelaFuncionario();
                telafuncionario.montarTelaFuncionario(bd, estoque, caixa);
                login.setText("");
                senha.setText("");
            }
        }
    }
}
