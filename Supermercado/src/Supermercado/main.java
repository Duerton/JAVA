package Supermercado;

import Telas.TelaLogin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JButton;

public class main {

    public static void main(String[] args) {
        BD bd = new BD();
        Estoque estoqueLocal = new Estoque();
        TelaLogin telalogin = new TelaLogin();
        Venda venda = new Venda();
        
        estoqueLocal.inserirProdutoUnidade(001, 10.00f, "Feijão", "Combrasil");
        estoqueLocal.inserirProdutoUnidade(002, 15.00f, "Arroz", "Tio João");
        estoqueLocal.inserirProdutoUnidade(003, 4.00f, "Açucar", "União");
        estoqueLocal.inserirProdutoUnidade(004, 3.50f, "Biscoito", "Piraque");
        
        bd.cadastrarGerentePadrao();
   
        telalogin.montarTelaLogin(bd,estoqueLocal,venda);
  
    }

}
