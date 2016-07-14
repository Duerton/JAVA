package Supermercado;

import Telas.TelaLogin;

public class main {

    public static void main(String[] args) {
        BD bd = new BD();
        Estoque estoqueLocal = new Estoque();
        Caixa caixa = new Caixa();
        TelaLogin telalogin = new TelaLogin();
        
        estoqueLocal.inserirProdutoUnidade(001, 10.00f, "Feijão", "Combrasil");
        estoqueLocal.inserirProdutoUnidade(002, 15.00f, "Arroz", "Tio João");
        estoqueLocal.inserirProdutoUnidade(003, 4.00f, "Açucar", "União");
        estoqueLocal.inserirProdutoUnidade(004, 3.50f, "Biscoito", "Piraque");
        
        bd.cadastrarGerentePadrao();
   
        telalogin.montarTelaLogin(bd,estoqueLocal,caixa);
  
    }

}
