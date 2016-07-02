
package Supermercado;

import java.util.ArrayList;
import java.util.Collection;

public class Caixa {
    private final int idFunc;
    private static int totalCaixa;
    private final int idCaixa;
    private Collection vendasCaixa = new ArrayList();
    
    public Caixa(Funcionario funcionario){
        this.idFunc = funcionario.getIDFunc();
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;
    }
    
    public float balanca(ProdutoPeso produto, float peso){
        return produto.valorProd * peso;
    }
    
}
