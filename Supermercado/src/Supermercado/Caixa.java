
package Supermercado;

import Telas.TelaLogin;
import java.util.ArrayList;
import java.util.Collection;

public class Caixa{
    private int idFunc;
    private static int totalCaixa;
    private final int idCaixa;
    private Venda venda;
    private Collection vendasCaixa = new ArrayList();
    
    public Caixa(){        
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;        
    }
    
    public float balanca(ProdutoPeso produto, float peso){
        Balanca balanca = new Balanca();
        return balanca.calcularPeso(produto, peso);
    }
    
    public void novaVenda(){
        this.venda = new Venda();        
    }
    
    public Venda getVenda(){
        return this.venda;
    }
    
    public void finalizarVenda(){
        vendasCaixa.add(this.venda);
    }

    
}
