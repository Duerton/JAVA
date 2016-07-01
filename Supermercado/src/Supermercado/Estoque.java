package Supermercado;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    Map<Integer, Produto> estoque = new HashMap();

    public void inserirProdutoUnidade(Integer codigo, float valor, String nome, String marca) {
        Produto produto = new ProdutoUnidade(codigo, valor, nome, marca);
        this.estoque.put(codigo, produto);
    }

    public Produto buscarProduto(Integer codProd) {
        return estoque.get(codProd);
    }

    public void retirarEstoque(Integer codProd) {
        estoque.remove(codProd);
    }
}
