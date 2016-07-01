package Telas;

import Supermercado.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPagamento {

    public void montarPagamento(Venda venda) {
        JFrame frame = new JFrame();

        JPanel painelEscolha = new JPanel();
        painelEscolha.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        JButton cartao = new JButton("Cartao");
        JButton dinheiro = new JButton("Dinheiro");
        JButton cancela = new JButton("Cancelar");
        painelEscolha.add(cartao);
        painelEscolha.add(dinheiro);
        painelEscolha.add(cancela);
        frame.add(painelEscolha);

        cartao.addActionListener(new TelaVerificarCartao(venda));
        
        dinheiro.addActionListener(new TelaVerificarDinheiro(venda));
        
        cancela.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
            
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
