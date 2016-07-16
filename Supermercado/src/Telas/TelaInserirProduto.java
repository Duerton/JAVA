package Telas;

import Controle.ControleAtualizarProduto;
import Supermercado.Estoque;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaInserirProduto {
   
    public void montarTelaInserirProduto(Estoque estoque) {
        
        JFrame frame = new JFrame();
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        JButton inserirNovoProduto = new JButton("Inserir novo produto ao estoque");
        JButton inserirQuantProduto = new JButton("Atualizar estoque");
        JButton inserir = new JButton("Inserir");
        JButton voltar = new JButton("Voltar");
        JButton cancelar = new JButton("Cancelar");
        JPanel painelBotoes = new JPanel(new GridLayout(5, 1));

        JLabel codProdutoL = new JLabel("Codigo do produto: ");
        JTextField codProduto = new JTextField(10);
        JLabel valorL = new JLabel("Valor: ");
        JTextField valor = new JTextField(10);
        JLabel quantidadeL = new JLabel("Quantidade: ");
        JTextField quantidade = new JTextField(10);
        JLabel nomeL = new JLabel("Nome: ");
        JTextField nome = new JTextField(10);
        JPanel painelPreencher = new JPanel(new GridLayout(5, 2));

        painelPreencher.add(nomeL);
        painelPreencher.add(nome);
        painelPreencher.add(valorL);
        painelPreencher.add(valor);
        painelPreencher.add(codProdutoL);
        painelPreencher.add(codProduto);
        painelPreencher.add(quantidadeL);
        painelPreencher.add(quantidade);
        painelPrincipal.add(painelPreencher, BorderLayout.WEST);

        painelBotoes.add(inserirNovoProduto);
        painelBotoes.add(inserirQuantProduto);
        painelBotoes.add(inserir);
        painelBotoes.add(voltar);
        painelBotoes.add(cancelar);
        painelPrincipal.add(painelBotoes, BorderLayout.EAST);
        frame.add(painelPrincipal);

        valor.setEditable(false);
        codProduto.setEnabled(false);
        voltar.setEnabled(false);
        nome.setEnabled(false);
        quantidade.setEnabled(false);
        inserir.setEnabled(false);

        inserirNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome.setEnabled(true);
                quantidade.setEnabled(true);
                inserir.setEnabled(true);
                voltar.setEnabled(true);
                valor.setEditable(true);
                inserirNovoProduto.setEnabled(false);
                inserirQuantProduto.setEnabled(false);                  
            }
        });

        inserirQuantProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codProduto.setEnabled(true);
                quantidade.setEnabled(true);
                inserir.setEnabled(true);
                voltar.setEnabled(true);
                inserirNovoProduto.setEnabled(false);
                inserirQuantProduto.setEnabled(false);                
            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codProduto.setEnabled(false);
                voltar.setEnabled(false);
                valor.setEditable(false);
                nome.setEnabled(false);
                quantidade.setEnabled(false);
                inserir.setEnabled(false);
                inserirNovoProduto.setEnabled(true);
                inserirQuantProduto.setEnabled(true);
            }
        });
        
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }            
        });
        
        inserir.addActionListener(new ControleAtualizarProduto(estoque, nome, quantidade, codProduto, valor));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
