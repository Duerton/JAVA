
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
    private String loginFuncionario;
    
    public Caixa(){        
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;        
    }
    
    public void setLogin(String login){
        this.loginFuncionario = login;
    }
    
    public void novaVenda(){
        this.venda = new Venda();        
    }
    
    public Venda getVenda(){
        return this.venda;
    }
    
    public void finalizarVenda(){
        NotaFiscal nota = new NotaFiscal(this.idCaixa, this.loginFuncionario, this.venda);
        nota.gerarNota();
        vendasCaixa.add(nota);        
    }

    
}
