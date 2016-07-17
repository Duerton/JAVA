
package Supermercado;

import Telas.TelaLogin;

public class Threads implements Runnable{
    private final BD bd;
    private final Estoque estoqueLocal;
    private final Arquivo arquivo;
    
    public Threads (BD bd, Estoque estoqueLocal, Arquivo arquivo){
        this.bd = bd;
        this.estoqueLocal = estoqueLocal;
        this.arquivo = arquivo;
    }
    
    @Override
    public void run() {
        Caixa caixa = new Caixa(bd);
        TelaLogin telalogin = new TelaLogin();       
        arquivo.getProdutos(estoqueLocal);
        arquivo.getFuncionarios(bd);
        telalogin.montarTelaLogin(bd, estoqueLocal, caixa);
    }

}
