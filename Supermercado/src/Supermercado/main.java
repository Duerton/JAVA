package Supermercado;

import Telas.TelaLogin;

public class main {

    public static void main(String[] args) {
        Estoque estoqueLocal = new Estoque();
        BD bd = new BD(estoqueLocal);
        Caixa caixa = new Caixa(bd);
        TelaLogin telalogin = new TelaLogin();
        Arquivo arquivo = new Arquivo();

        arquivo.getProdutos(estoqueLocal);

        arquivo.getFuncionarios(bd);

        telalogin.montarTelaLogin(bd, estoqueLocal, caixa);

    }

}
