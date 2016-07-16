package Telas;

import Controle.ControleIniciarCadastro;
import Supermercado.BD;
import Supermercado.Estoque;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaGerente {

    public void montarTelaGerente(BD bd, Estoque estoque) {
        JFrame frame = new JFrame();
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JButton relatorioVenda = new JButton("Relatorio de Venda");
        JButton relatorioEstoque = new JButton("Relatorio de Estoque");
        JButton cadastro = new JButton("Cadastrar novo usuário");
        JButton desconectar = new JButton("Desconectar");
        JPanel painelBotoes = new JPanel(new GridLayout(5,1));
        painelBotoes.add(relatorioVenda);
        painelBotoes.add(relatorioEstoque);
        painelBotoes.add(cadastro);
        painelBotoes.add(desconectar);
        painelPrincipal.add(painelBotoes, BorderLayout.EAST);
        frame.add(painelPrincipal);

        //relatorioVenda.addActionListener();
        //relatorioEstoque.addActionListener();
        cadastro.addActionListener(new ControleIniciarCadastro(bd));
        desconectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }            
        });
        
        
        frame.pack();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
