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

    public void adicionarProdutoVenda(Produto produto) {
        produtosCompra.add(produto);
        valorTotal += produto.valorProd;
    }

    public void removerProdutoVenda(Produto produto) {
        produtosCompra.remove(produto);
        valorTotal -= produto.valorProd;
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
        return valor - this.valorTotal;
    }

}
