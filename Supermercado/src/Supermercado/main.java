package Supermercado;

import Telas.TelaLogin;

public class main {

    public static void main(String[] args) {
        BD bd = new BD();
        Estoque estoqueLocal = new Estoque();
        Caixa caixa = new Caixa();
        TelaLogin telalogin = new TelaLogin();
        
        estoqueLocal.inserirProdutoUnidade(10.00f, "Feijão");
        estoqueLocal.inserirProdutoUnidade(15.00f, "Arroz");
        estoqueLocal.inserirProdutoUnidade(4.00f, "Açucar");
        estoqueLocal.inserirProdutoUnidade(3.50f, "Biscoito");
        
        bd.cadastrarGerentePadrao();
   
        telalogin.montarTelaLogin(bd,estoqueLocal,caixa);
  
    }

}
