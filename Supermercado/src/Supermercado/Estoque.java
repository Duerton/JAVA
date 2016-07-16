package Supermercado;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    Map<Integer, Produto> estoque = new HashMap();

    public void inserirProdutoUnidade(float valor, String nome) {
        Produto produto = new ProdutoUnidade(valor, nome);
        this.estoque.put(produto.getCodigo(), produto);
    }

    public Produto buscarProduto(Integer codProd) {
        return estoque.get(codProd);
    }

    public void retirarEstoque(Integer codProd) {
        estoque.remove(codProd);
    }
}
