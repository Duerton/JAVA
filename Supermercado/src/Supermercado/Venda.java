package Supermercado;

import java.util.ArrayList;
import java.util.Collection;

public class Venda {

    private final int idVenda;
    private static int totalIDVenda;
    private Collection produtosCompra = new ArrayList();
    private float valorTotal = 0;

    public Venda() {
        Venda.totalIDVenda++;
        this.idVenda = totalIDVenda;
    }
    
    public Collection getProdutosCompra(){
        return produtosCompra;
    }

    public void adicionarProdutoVenda(Item item) {
        produtosCompra.add(item);
        valorTotal += item.getValorTotal();
    }

    public void removerProdutoVenda(Item item) {
        produtosCompra.remove(item);
        valorTotal -= item.getValorTotal();
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public boolean finalizarVenda(int senha){
        Cartao cartao = new Cartao();
        if (cartao.validarCartao(senha)){            
            return true;
        }        
        return false;
    }
    
    public float calcularTroco(float valor){
        float troco = valor - this.valorTotal;
        if(troco >= 0){
            return troco;
        }
        return -1;
    }
  

}
