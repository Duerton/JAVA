package Supermercado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin {

    private JFrame telaLogin;
    private JPanel painelLogin;
    private JTextField senha;
    private JTextField login;

    public void montarTelaLogin(BD bd) {
        prepararJanela();
        prepararPainelLogin();
        prepararCaixaTextoInserirLogin();
        prepararCaixaTextoInserirSenha();
        prepararBotaoConfirma(bd);
        prepararBotaoSair();
        mostrarJanela();
    }

    private void prepararJanela() {
        telaLogin = new JFrame("Sistema Supermercado");
        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void prepararPainelLogin() {
        painelLogin = new JPanel(new GridLayout(3, 2));
        telaLogin.add(painelLogin);
    }

    private void prepararCaixaTextoInserirLogin() {
        JLabel labelLogin = new JLabel("Login:");
        login = new JTextField();
        painelLogin.add(labelLogin);
        painelLogin.add(login);
    }

    private void prepararCaixaTextoInserirSenha() {
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JTextField();
        painelLogin.add(labelSenha);
        painelLogin.add(senha);
    }

    private void prepararBotaoConfirma(BD bd) {
        JButton confirma = new JButton("Confirma");
        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aux = login.getText();
                String auxS = senha.getText();
                if (bd.loginPessoa(aux, auxS)) {
                    TelaGerente telagerente = new TelaGerente();
                    telagerente.pack();
                    telagerente.setVisible(true);
                }
            }
        });
        painelLogin.add(confirma);
    }

    private void prepararBotaoSair() {
        JButton sair = new JButton("Sair");
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        painelLogin.add(sair);
    }

    private void mostrarJanela() {
        telaLogin.pack();
        telaLogin.setSize(200, 120);
        telaLogin.setVisible(true);
    }
}
